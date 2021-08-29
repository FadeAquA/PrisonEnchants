/*    */ package me.iLucaH.PrisonEnchants.Enchants;
/*    */ 
/*    */ import com.sk89q.worldedit.bukkit.BukkitAdapter;
/*    */ import com.sk89q.worldguard.LocalPlayer;
/*    */ import com.sk89q.worldguard.WorldGuard;
/*    */ import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
/*    */ import com.sk89q.worldguard.protection.ApplicableRegionSet;
/*    */ import com.sk89q.worldguard.protection.association.RegionAssociable;
/*    */ import com.sk89q.worldguard.protection.flags.Flags;
/*    */ import com.sk89q.worldguard.protection.flags.StateFlag;
/*    */ import com.sk89q.worldguard.protection.managers.RegionManager;
/*    */ import com.sk89q.worldguard.protection.regions.RegionContainer;
/*    */ import java.util.Random;
/*    */ import me.iLucaH.PrisonEnchants.MainClass;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.ChatColor;
/*    */ import org.bukkit.Location;
/*    */ import org.bukkit.Sound;
/*    */ import org.bukkit.command.CommandSender;
/*    */ import org.bukkit.command.ConsoleCommandSender;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.block.BlockBreakEvent;
/*    */ 
/*    */ public class Lucky
/*    */   implements Listener {
/* 28 */   private static MainClass plugin = MainClass.plugin;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @EventHandler
/*    */   public void onBlockBreak(BlockBreakEvent e) {
/* 46 */     int range = plugin.getConfig().getInt("Enchants.Lucky.Procrange");
/*    */     
/* 48 */     Player p = e.getPlayer();
/* 49 */     Random random = new Random();
/* 50 */     ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
/*    */     
/* 52 */     int chance = random.nextInt(range) + 1;
/* 53 */     if (p.getInventory().getItemInMainHand().hasItemMeta() && 
/* 54 */       p.getInventory().getItemInMainHand().getItemMeta().hasLore()) {
/* 55 */       int enchlevel = -1;
/* 56 */       for (String str : p.getInventory().getItemInMainHand().getItemMeta().getLore()) {
/* 57 */         if (str.contains("Lucky")) {
/* 58 */           enchlevel = Integer.valueOf(str.split(" ")[1]).intValue();
/*    */           
/* 60 */           ApplicableRegionSet set = getApplicableRegions(e.getBlock().getLocation());
/* 61 */           LocalPlayer localPlayer = WorldGuardPlugin.inst().wrapPlayer(p);
/*    */           
/* 63 */           if (chance <= enchlevel && set.testState((RegionAssociable)localPlayer, new StateFlag[] { Flags.BLOCK_BREAK })) {
/* 64 */             p.sendMessage(ChatColor.translateAlternateColorCodes('&', 
/* 65 */                   plugin.getConfig().getString("Enchants.Lucky.Message")));
/* 66 */             Bukkit.dispatchCommand((CommandSender)console, plugin.getConfig().getString("Enchants.Lucky.Command").replace("{username}", p.getName()));
/* 67 */             p.playSound(p.getLocation(), Sound.ENTITY_SKELETON_SHOOT, 1.0F, 1.0F);
/*    */           } 
/*    */         } 
/*    */       } 
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   private ApplicableRegionSet getApplicableRegions(Location loc) {
/* 76 */     RegionContainer container = WorldGuard.getInstance().getPlatform().getRegionContainer();
/*    */     RegionManager manager;
/* 78 */     if (container == null || (manager = container.get(BukkitAdapter.adapt(loc.getWorld()))) == null) {
/* 79 */       return null;
/*    */     }
/* 81 */     return manager.getApplicableRegions(BukkitAdapter.asBlockVector(loc));
/*    */   }
/*    */ }


/* Location:              C:\Users\17hautrivel\Desktop\PrisonEnchants.jar!\me\iLucaH\PrisonEnchants\Enchants\Lucky.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */