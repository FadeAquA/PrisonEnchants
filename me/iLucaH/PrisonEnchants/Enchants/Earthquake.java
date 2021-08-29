/*     */ package me.iLucaH.PrisonEnchants.Enchants;
/*     */ 
/*     */ import com.sk89q.worldedit.bukkit.BukkitAdapter;
/*     */ import com.sk89q.worldedit.math.BlockVector3;
/*     */ import com.sk89q.worldguard.LocalPlayer;
/*     */ import com.sk89q.worldguard.WorldGuard;
/*     */ import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
/*     */ import com.sk89q.worldguard.protection.ApplicableRegionSet;
/*     */ import com.sk89q.worldguard.protection.association.RegionAssociable;
/*     */ import com.sk89q.worldguard.protection.flags.Flags;
/*     */ import com.sk89q.worldguard.protection.flags.StateFlag;
/*     */ import com.sk89q.worldguard.protection.managers.RegionManager;
/*     */ import com.sk89q.worldguard.protection.regions.ProtectedRegion;
/*     */ import com.sk89q.worldguard.protection.regions.RegionContainer;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import me.iLucaH.PrisonEnchants.MainClass;
/*     */ import me.iLucaH.PrisonEnchants.Tokens.Tokens;
/*     */ import me.iLucaH.PrisonEnchants.Utils;
/*     */ import org.bukkit.Location;
/*     */ import org.bukkit.Material;
/*     */ import org.bukkit.Sound;
/*     */ import org.bukkit.block.Block;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.event.EventHandler;
/*     */ import org.bukkit.event.Listener;
/*     */ import org.bukkit.event.block.BlockBreakEvent;
/*     */ import org.bukkit.inventory.ItemStack;
/*     */ 
/*     */ 
/*     */ public class Earthquake
/*     */   implements Listener
/*     */ {
/*  35 */   private static MainClass plugin = MainClass.plugin;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @EventHandler
/*     */   public void onBlockBreak(BlockBreakEvent e) {
/*  43 */     int range = plugin.getConfig().getInt("Enchants.Layer.Procrange");
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  48 */     Player p = e.getPlayer();
/*     */     
/*  50 */     Block b = e.getBlock();
/*     */     
/*  52 */     ItemStack mainhand = p.getInventory().getItemInMainHand();
/*     */     
/*  54 */     Random random = new Random();
/*     */     
/*  56 */     Tokens tokens = new Tokens(p.getUniqueId());
/*     */     
/*  58 */     int chance = random.nextInt(range) + 1;
/*  59 */     ApplicableRegionSet set = getApplicableRegions(b.getLocation());
/*  60 */     LocalPlayer localPlayer = WorldGuardPlugin.inst().wrapPlayer(p);
/*     */     
/*  62 */     if (p.getInventory().getItemInMainHand().hasItemMeta())
/*     */     {
/*  64 */       if (p.getInventory().getItemInMainHand().getItemMeta().hasLore()) {
/*     */         
/*  66 */         int enchlevel = -1;
/*     */         
/*  68 */         for (String str : mainhand.getItemMeta().getLore()) {
/*     */           
/*  70 */           if (str.contains("Layer")) {
/*     */             
/*  72 */             enchlevel = Integer.valueOf(str.split(" ")[1]).intValue();
/*     */             
/*  74 */             if (chance <= enchlevel) {
/*     */               
/*  76 */               for (ProtectedRegion regions : set) {
/*  77 */                 BlockVector3 min = regions.getMinimumPoint();
/*  78 */                 BlockVector3 max = regions.getMaximumPoint();
/*  79 */                 Location bcorner = new Location(b.getWorld(), min.getX(), b.getLocation().getY(), 
/*  80 */                     min.getZ());
/*  81 */                 Location tcorner = new Location(b.getWorld(), max.getX(), b.getLocation().getY(), 
/*  82 */                     max.getZ());
/*  83 */                 for (Block block : blocksFromTwoPoints(bcorner, tcorner)) {
/*  84 */                   ApplicableRegionSet blockset = getApplicableRegions(block.getLocation());
/*  85 */                   if (blockset.testState((RegionAssociable)localPlayer, new StateFlag[] { Flags.BLOCK_BREAK
/*  86 */                       }) && (block.getType() != null || block.getType() != Material.AIR)) {
/*     */                     
/*  88 */                     p.getInventory().addItem(new ItemStack[] { new ItemStack(block.getType(), Utils.getFortune(p), block.getData()) });
/*  89 */                     block.setType(Material.AIR);
/*     */                     
/*  91 */                     tokens.addTokens(Long.valueOf(1L));
/*  92 */                     tokens.savePlayerConfig();
/*     */                   } 
/*     */                 } 
/*     */               } 
/*     */               
/*  97 */               p.playSound(p.getLocation(), Sound.ENTITY_IRON_GOLEM_STEP, 1.0F, 1.0F);
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   public static List<Block> blocksFromTwoPoints(Location loc1, Location loc2) {
/* 106 */     List<Block> blocks = new ArrayList<>();
/*     */     
/* 108 */     int topBlockX = (loc1.getBlockX() < loc2.getBlockX()) ? loc2.getBlockX() : loc1.getBlockX();
/* 109 */     int bottomBlockX = (loc1.getBlockX() > loc2.getBlockX()) ? loc2.getBlockX() : loc1.getBlockX();
/*     */     
/* 111 */     int topBlockY = (loc1.getBlockY() < loc2.getBlockY()) ? loc2.getBlockY() : loc1.getBlockY();
/* 112 */     int bottomBlockY = (loc1.getBlockY() > loc2.getBlockY()) ? loc2.getBlockY() : loc1.getBlockY();
/*     */     
/* 114 */     int topBlockZ = (loc1.getBlockZ() < loc2.getBlockZ()) ? loc2.getBlockZ() : loc1.getBlockZ();
/* 115 */     int bottomBlockZ = (loc1.getBlockZ() > loc2.getBlockZ()) ? loc2.getBlockZ() : loc1.getBlockZ();
/*     */     
/* 117 */     for (int x = bottomBlockX; x <= topBlockX; x++) {
/* 118 */       for (int z = bottomBlockZ; z <= topBlockZ; z++) {
/* 119 */         for (int y = bottomBlockY; y <= topBlockY; y++) {
/* 120 */           Block block = loc1.getWorld().getBlockAt(x, y, z);
/*     */           
/* 122 */           blocks.add(block);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 127 */     return blocks;
/*     */   }
/*     */   
/*     */   private ApplicableRegionSet getApplicableRegions(Location loc) {
/* 131 */     RegionContainer container = WorldGuard.getInstance().getPlatform().getRegionContainer();
/*     */     RegionManager manager;
/* 133 */     if (container == null || (manager = container.get(BukkitAdapter.adapt(loc.getWorld()))) == null) {
/* 134 */       return null;
/*     */     }
/* 136 */     return manager.getApplicableRegions(BukkitAdapter.asBlockVector(loc));
/*     */   }
/*     */ }


/* Location:              C:\Users\17hautrivel\Desktop\PrisonEnchants.jar!\me\iLucaH\PrisonEnchants\Enchants\Earthquake.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */