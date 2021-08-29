/*     */ package me.iLucaH.PrisonEnchants.Enchants;
/*     */ 
/*     */ import com.sk89q.worldedit.bukkit.BukkitAdapter;
/*     */ import com.sk89q.worldguard.LocalPlayer;
/*     */ import com.sk89q.worldguard.WorldGuard;
/*     */ import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
/*     */ import com.sk89q.worldguard.protection.ApplicableRegionSet;
/*     */ import com.sk89q.worldguard.protection.association.RegionAssociable;
/*     */ import com.sk89q.worldguard.protection.flags.Flags;
/*     */ import com.sk89q.worldguard.protection.flags.StateFlag;
/*     */ import com.sk89q.worldguard.protection.managers.RegionManager;
/*     */ import com.sk89q.worldguard.protection.regions.RegionContainer;
/*     */ import java.util.HashSet;
/*     */ import java.util.Random;
/*     */ import java.util.Set;
/*     */ import me.iLucaH.PrisonEnchants.MainClass;
/*     */ import me.iLucaH.PrisonEnchants.Tokens.Tokens;
/*     */ import me.iLucaH.PrisonEnchants.Utils;
/*     */ import org.bukkit.Location;
/*     */ import org.bukkit.Material;
/*     */ import org.bukkit.World;
/*     */ import org.bukkit.block.Block;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.event.EventHandler;
/*     */ import org.bukkit.event.Listener;
/*     */ import org.bukkit.event.block.BlockBreakEvent;
/*     */ import org.bukkit.inventory.ItemStack;
/*     */ 
/*     */ public class Nuker
/*     */   implements Listener {
/*  31 */   private static MainClass plugin = MainClass.plugin;
/*     */   
/*     */   private Set<Location> makeHollow(Set<Location> blocks, boolean sphere) {
/*  34 */     Set<Location> edge = new HashSet<>();
/*  35 */     if (!sphere) {
/*  36 */       for (Location l : blocks) {
/*  37 */         World w = l.getWorld();
/*  38 */         int X = l.getBlockX();
/*  39 */         int Y = l.getBlockY();
/*  40 */         int Z = l.getBlockZ();
/*  41 */         Location front = new Location(w, (X + 1), Y, Z);
/*  42 */         Location back = new Location(w, (X - 1), Y, Z);
/*  43 */         Location left = new Location(w, X, Y, (Z + 1));
/*  44 */         Location right = new Location(w, X, Y, (Z - 1));
/*  45 */         if (!blocks.contains(front) || !blocks.contains(back) || !blocks.contains(left) || 
/*  46 */           !blocks.contains(right)) {
/*  47 */           edge.add(l);
/*     */         }
/*     */       } 
/*  50 */       return edge;
/*     */     } 
/*  52 */     for (Location l : blocks) {
/*  53 */       World w = l.getWorld();
/*  54 */       int X = l.getBlockX();
/*  55 */       int Y = l.getBlockY();
/*  56 */       int Z = l.getBlockZ();
/*  57 */       Location front = new Location(w, (X + 1), Y, Z);
/*  58 */       Location back = new Location(w, (X - 1), Y, Z);
/*  59 */       Location left = new Location(w, X, Y, (Z + 1));
/*  60 */       Location right = new Location(w, X, Y, (Z - 1));
/*  61 */       Location top = new Location(w, X, (Y + 1), Z);
/*  62 */       Location bottom = new Location(w, X, (Y - 1), Z);
/*  63 */       if (!blocks.contains(front) || !blocks.contains(back) || !blocks.contains(left) || !blocks.contains(right) || 
/*  64 */         !blocks.contains(top) || !blocks.contains(bottom)) {
/*  65 */         edge.add(l);
/*     */       }
/*     */     } 
/*  68 */     return edge;
/*     */   }
/*     */ 
/*     */   
/*     */   public Set<Location> sphere(Location location, int radius, boolean hollow) {
/*  73 */     Set<Location> blocks = new HashSet<>();
/*  74 */     World world = location.getWorld();
/*  75 */     int X = location.getBlockX();
/*  76 */     int Y = location.getBlockY();
/*  77 */     int Z = location.getBlockZ();
/*  78 */     int radiusSquared = radius * radius;
/*     */     
/*  80 */     if (hollow) {
/*  81 */       for (int i = X - radius; i <= X + radius; i++) {
/*  82 */         for (int y = Y - radius; y <= Y + radius; y++) {
/*  83 */           for (int z = Z - radius; z <= Z + radius; z++) {
/*  84 */             if ((X - i) * (X - i) + (Y - y) * (Y - y) + (Z - z) * (Z - z) <= radiusSquared) {
/*  85 */               Location block = new Location(world, i, y, z);
/*  86 */               blocks.add(block);
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*  91 */       return makeHollow(blocks, true);
/*     */     } 
/*  93 */     for (int x = X - radius; x <= X + radius; x++) {
/*  94 */       for (int y = Y - radius; y <= Y + radius; y++) {
/*  95 */         for (int z = Z - radius; z <= Z + radius; z++) {
/*  96 */           if ((X - x) * (X - x) + (Y - y) * (Y - y) + (Z - z) * (Z - z) <= radiusSquared) {
/*  97 */             Location block = new Location(world, x, y, z);
/*  98 */             blocks.add(block);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/* 103 */     return blocks;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @EventHandler
/*     */   public void onBlockBreak(BlockBreakEvent e) {
/* 112 */     int range = plugin.getConfig().getInt("Enchants.Nuker.Procrange");
/*     */     
/* 114 */     Player p = e.getPlayer();
/* 115 */     Block b = e.getBlock();
/* 116 */     ItemStack mainhand = p.getInventory().getItemInMainHand();
/* 117 */     Random random = new Random();
/* 118 */     Tokens tokens = new Tokens(p.getUniqueId());
/* 119 */     int chance = random.nextInt(range) + 1;
/*     */     
/* 121 */     if (p.getInventory().getItemInMainHand().hasItemMeta() && 
/* 122 */       p.getInventory().getItemInMainHand().getItemMeta().hasLore()) {
/* 123 */       int enchlevel = -1;
/* 124 */       for (String str : mainhand.getItemMeta().getLore()) {
/* 125 */         if (str.contains("Nuker")) {
/* 126 */           enchlevel = Integer.valueOf(str.split(" ")[1]).intValue();
/* 127 */           if (chance <= enchlevel) {
/* 128 */             int size = Math.round((enchlevel / 600));
/* 129 */             if (chance <= enchlevel) {
/* 130 */               for (Location l : sphere(b.getLocation(), size, false)) {
/* 131 */                 ItemStack blocks = new ItemStack(l.getBlock().getType(), Utils.getFortune(p), l.getBlock().getData());
/* 132 */                 ApplicableRegionSet set = getApplicableRegions(l);
/* 133 */                 plugin.getWorldGuard(); LocalPlayer localplayer = WorldGuardPlugin.inst().wrapPlayer(p);
/* 134 */                 if (set.testState((RegionAssociable)localplayer, new StateFlag[] { Flags.BLOCK_BREAK })) {
/* 135 */                   l.getBlock().setType(Material.AIR);
/* 136 */                   tokens.addTokens(Long.valueOf(1L));
/* 137 */                   tokens.savePlayerConfig();
/* 138 */                   p.getInventory().addItem(new ItemStack[] { blocks });
/*     */                 } 
/*     */               } 
/* 141 */               b.getWorld().createExplosion(b.getLocation(), 0.0F);
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private ApplicableRegionSet getApplicableRegions(Location loc) {
/* 150 */     RegionContainer container = WorldGuard.getInstance().getPlatform().getRegionContainer();
/*     */     RegionManager manager;
/* 152 */     if (container == null || (manager = container.get(BukkitAdapter.adapt(loc.getWorld()))) == null) {
/* 153 */       return null;
/*     */     }
/* 155 */     return manager.getApplicableRegions(BukkitAdapter.asBlockVector(loc));
/*     */   }
/*     */ }


/* Location:              C:\Users\17hautrivel\Desktop\PrisonEnchants.jar!\me\iLucaH\PrisonEnchants\Enchants\Nuker.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */