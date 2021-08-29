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
/*     */ import me.iLucaH.PrisonEnchants.Utils;
/*     */ import org.bukkit.Location;
/*     */ import org.bukkit.Material;
/*     */ import org.bukkit.block.Block;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.event.EventHandler;
/*     */ import org.bukkit.event.Listener;
/*     */ import org.bukkit.event.block.BlockBreakEvent;
/*     */ import org.bukkit.inventory.ItemStack;
/*     */ 
/*     */ public class Souls
/*     */   implements Listener {
/*  31 */   private static MainClass plugin = MainClass.plugin;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @EventHandler
/*     */   public void onBlockBreak(BlockBreakEvent e) {
/*  38 */     int range = plugin.getConfig().getInt("Enchants.Souls.Procrange");
/*     */     
/*  40 */     Player p = e.getPlayer();
/*  41 */     Block b = e.getBlock();
/*  42 */     Random random = new Random();
/*  43 */     int chance = random.nextInt(range) + 1;
/*  44 */     if (p.getInventory().getItemInMainHand().hasItemMeta() && 
/*  45 */       p.getInventory().getItemInMainHand().getItemMeta().hasLore()) {
/*  46 */       int enchlevel = -1;
/*  47 */       for (String str : p.getInventory().getItemInMainHand().getItemMeta().getLore()) {
/*  48 */         if (str.contains("Souls")) {
/*  49 */           enchlevel = Integer.valueOf(str.split(" ")[1]).intValue();
/*  50 */           if (chance <= enchlevel) {
/*  51 */             ApplicableRegionSet set = getApplicableRegions(b.getLocation());
/*  52 */             plugin.getWorldGuard(); LocalPlayer localplayer = WorldGuardPlugin.inst().wrapPlayer(p);
/*  53 */             for (ProtectedRegion regions : set) {
/*  54 */               BlockVector3 min = regions.getMinimumPoint();
/*  55 */               BlockVector3 max = regions.getMaximumPoint();
/*  56 */               Location bcorner = new Location(b.getWorld(), min.getX(), min.getY(), min.getZ());
/*  57 */               Location tcorner = new Location(b.getWorld(), max.getX(), min.getY(), max.getZ());
/*  58 */               for (Block block : blocksFromTwoPoints(bcorner, tcorner)) {
/*  59 */                 ApplicableRegionSet blockset = getApplicableRegions(block.getLocation());
/*  60 */                 if (blockset.testState((RegionAssociable)localplayer, new StateFlag[] { Flags.BLOCK_BREAK })) {
/*  61 */                   p.getInventory().addItem(new ItemStack[] { new ItemStack(block.getType(), Utils.getFortune(p), block.getData()) });
/*  62 */                   block.setType(Material.valueOf(plugin.getConfig().getString("Enchants.Souls.Blocktype").toUpperCase()));
/*     */                 } 
/*     */               } 
/*     */             } 
/*  66 */             p.sendTitle("§3Souls!", "§7The bottom of the mine has been changed!", 20, 40, 20);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static List<Block> blocksFromTwoPoints(Location loc1, Location loc2) {
/*  75 */     List<Block> blocks = new ArrayList<>();
/*     */     
/*  77 */     int topBlockX = (loc1.getBlockX() < loc2.getBlockX()) ? loc2.getBlockX() : loc1.getBlockX();
/*  78 */     int bottomBlockX = (loc1.getBlockX() > loc2.getBlockX()) ? loc2.getBlockX() : loc1.getBlockX();
/*     */     
/*  80 */     int topBlockY = (loc1.getBlockY() < loc2.getBlockY()) ? loc2.getBlockY() : loc1.getBlockY();
/*  81 */     int bottomBlockY = (loc1.getBlockY() > loc2.getBlockY()) ? loc2.getBlockY() : loc1.getBlockY();
/*     */     
/*  83 */     int topBlockZ = (loc1.getBlockZ() < loc2.getBlockZ()) ? loc2.getBlockZ() : loc1.getBlockZ();
/*  84 */     int bottomBlockZ = (loc1.getBlockZ() > loc2.getBlockZ()) ? loc2.getBlockZ() : loc1.getBlockZ();
/*     */     
/*  86 */     for (int x = bottomBlockX; x <= topBlockX; x++) {
/*  87 */       for (int z = bottomBlockZ; z <= topBlockZ; z++) {
/*  88 */         for (int y = bottomBlockY; y <= topBlockY; y++) {
/*  89 */           Block block = loc1.getWorld().getBlockAt(x, y, z);
/*     */           
/*  91 */           blocks.add(block);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/*  96 */     return blocks;
/*     */   }
/*     */   private ApplicableRegionSet getApplicableRegions(Location loc) {
/*  99 */     RegionContainer container = WorldGuard.getInstance().getPlatform().getRegionContainer();
/*     */     RegionManager manager;
/* 101 */     if (container == null || (manager = container.get(BukkitAdapter.adapt(loc.getWorld()))) == null) {
/* 102 */       return null;
/*     */     }
/* 104 */     return manager.getApplicableRegions(BukkitAdapter.asBlockVector(loc));
/*     */   }
/*     */ }


/* Location:              C:\Users\17hautrivel\Desktop\PrisonEnchants.jar!\me\iLucaH\PrisonEnchants\Enchants\Souls.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */