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
/*     */ public class Laser
/*     */   implements Listener
/*     */ {
/*  35 */   private static MainClass plugin = MainClass.plugin;
/*     */ 
/*     */ 
/*     */   
/*     */   public ArrayList<Location> generateLaser(Location location, int radius) {
/*  40 */     ArrayList<Location> blocks = new ArrayList<>();
/*     */     
/*  42 */     for (double x = location.getX() - radius; x <= location.getX() + radius; x++) {
/*     */       
/*  44 */       for (double y = location.getY() - radius; y <= location.getY() + radius; y++) {
/*     */         
/*  46 */         Location locxy = new Location(location.getWorld(), x, y, location.getZ());
/*     */         
/*  48 */         blocks.add(locxy);
/*     */       } 
/*     */     } 
/*     */     
/*  52 */     for (double z = location.getZ() - radius; z <= location.getZ() + radius; z++) {
/*     */       
/*  54 */       for (double y = location.getY() - radius; y <= location.getY() + radius; y++) {
/*     */         
/*  56 */         Location loczy = new Location(location.getWorld(), location.getX(), y, z);
/*     */         
/*  58 */         blocks.add(loczy);
/*     */       } 
/*     */     } 
/*     */     
/*  62 */     return blocks;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @EventHandler
/*     */   public void onBlockBreak(BlockBreakEvent e) {
/*  71 */     int range = plugin.getConfig().getInt("Enchants.Laser.Procrange");
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  76 */     Player p = e.getPlayer();
/*     */     
/*  78 */     Block b = e.getBlock();
/*     */     
/*  80 */     ItemStack mainhand = p.getInventory().getItemInMainHand();
/*     */     
/*  82 */     Random random = new Random();
/*     */     
/*  84 */     Tokens tokens = new Tokens(p.getUniqueId());
/*     */     
/*  86 */     int chance = random.nextInt(range) + 1;
/*  87 */     ApplicableRegionSet set = getApplicableRegions(b.getLocation());
/*  88 */     LocalPlayer localPlayer = WorldGuardPlugin.inst().wrapPlayer(p);
/*     */     
/*  90 */     if (p.getInventory().getItemInMainHand().hasItemMeta())
/*     */     {
/*  92 */       if (p.getInventory().getItemInMainHand().getItemMeta().hasLore()) {
/*     */         
/*  94 */         int enchlevel = -1;
/*     */         
/*  96 */         for (String str : mainhand.getItemMeta().getLore()) {
/*     */           
/*  98 */           if (str.contains("Laser")) {
/*     */             
/* 100 */             enchlevel = Integer.valueOf(str.split(" ")[1]).intValue();
/*     */             
/* 102 */             if (chance <= enchlevel)
/*     */             {
/* 104 */               if (set.testState((RegionAssociable)localPlayer, new StateFlag[] { Flags.BLOCK_BREAK })) {
/* 105 */                 for (ProtectedRegion regions : set) {
/* 106 */                   BlockVector3 min = regions.getMinimumPoint();
/* 107 */                   BlockVector3 max = regions.getMaximumPoint();
/* 108 */                   Location bcorner = new Location(b.getWorld(), b.getX(), min.getY(), min.getZ());
/* 109 */                   Location tcorner = new Location(b.getWorld(), b.getX(), max.getY(), max.getZ());
/* 110 */                   Location bcornerxy = new Location(b.getWorld(), min.getX(), min.getY(), b.getZ());
/* 111 */                   Location tcornerxy = new Location(b.getWorld(), max.getX(), max.getY(), b.getZ());
/* 112 */                   for (Block blocks : blocksFromTwoPoints(bcorner, tcorner)) {
/* 113 */                     ApplicableRegionSet setblocks = getApplicableRegions(blocks.getLocation());
/* 114 */                     if (setblocks.testState((RegionAssociable)localPlayer, new StateFlag[] { Flags.BLOCK_BREAK
/* 115 */                         }) && (blocks.getType() != null || blocks.getType() != Material.AIR)) {
/* 116 */                       p.getInventory().addItem(new ItemStack[] { new ItemStack(blocks.getType()) });
/* 117 */                       blocks.setType(Material.AIR);
/*     */                       
/* 119 */                       tokens.addTokens(Long.valueOf(1L));
/* 120 */                       tokens.savePlayerConfig();
/*     */                     } 
/*     */                   } 
/*     */                   
/* 124 */                   for (Block blocks : blocksFromTwoPoints(bcornerxy, tcornerxy)) {
/* 125 */                     ApplicableRegionSet setblocks = getApplicableRegions(blocks.getLocation());
/* 126 */                     if (setblocks.testState((RegionAssociable)localPlayer, new StateFlag[] { Flags.BLOCK_BREAK
/* 127 */                         }) && (blocks.getType() != null || blocks.getType() != Material.AIR)) {
/* 128 */                       p.getInventory().addItem(new ItemStack[] { new ItemStack(blocks.getType(), Utils.getFortune(p), blocks.getData()) });
/* 129 */                       blocks.setType(Material.AIR);
/*     */                       
/* 131 */                       tokens.addTokens(Long.valueOf(1L));
/* 132 */                       tokens.savePlayerConfig();
/*     */                     } 
/*     */                   } 
/*     */                 } 
/*     */                 
/* 137 */                 p.playSound(p.getLocation(), Sound.ENTITY_BLAZE_SHOOT, 1.0F, 1.0F);
/*     */               } 
/*     */             }
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   public static List<Block> blocksFromTwoPoints(Location loc1, Location loc2) {
/* 147 */     List<Block> blocks = new ArrayList<>();
/*     */     
/* 149 */     int topBlockX = (loc1.getBlockX() < loc2.getBlockX()) ? loc2.getBlockX() : loc1.getBlockX();
/* 150 */     int bottomBlockX = (loc1.getBlockX() > loc2.getBlockX()) ? loc2.getBlockX() : loc1.getBlockX();
/*     */     
/* 152 */     int topBlockY = (loc1.getBlockY() < loc2.getBlockY()) ? loc2.getBlockY() : loc1.getBlockY();
/* 153 */     int bottomBlockY = (loc1.getBlockY() > loc2.getBlockY()) ? loc2.getBlockY() : loc1.getBlockY();
/*     */     
/* 155 */     int topBlockZ = (loc1.getBlockZ() < loc2.getBlockZ()) ? loc2.getBlockZ() : loc1.getBlockZ();
/* 156 */     int bottomBlockZ = (loc1.getBlockZ() > loc2.getBlockZ()) ? loc2.getBlockZ() : loc1.getBlockZ();
/*     */     
/* 158 */     for (int x = bottomBlockX; x <= topBlockX; x++) {
/* 159 */       for (int z = bottomBlockZ; z <= topBlockZ; z++) {
/* 160 */         for (int y = bottomBlockY; y <= topBlockY; y++) {
/* 161 */           Block block = loc1.getWorld().getBlockAt(x, y, z);
/*     */           
/* 163 */           blocks.add(block);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 168 */     return blocks;
/*     */   }
/*     */   
/*     */   private ApplicableRegionSet getApplicableRegions(Location loc) {
/* 172 */     RegionContainer container = WorldGuard.getInstance().getPlatform().getRegionContainer();
/*     */     RegionManager manager;
/* 174 */     if (container == null || (manager = container.get(BukkitAdapter.adapt(loc.getWorld()))) == null) {
/* 175 */       return null;
/*     */     }
/* 177 */     return manager.getApplicableRegions(BukkitAdapter.asBlockVector(loc));
/*     */   }
/*     */ }


/* Location:              C:\Users\17hautrivel\Desktop\PrisonEnchants.jar!\me\iLucaH\PrisonEnchants\Enchants\Laser.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */