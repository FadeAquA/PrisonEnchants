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
/*    */ import org.bukkit.Effect;
/*    */ import org.bukkit.Location;
/*    */ import org.bukkit.Sound;
/*    */ import org.bukkit.command.CommandSender;
/*    */ import org.bukkit.command.ConsoleCommandSender;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.block.BlockBreakEvent;
/*    */ 
/*    */ public class Keyalls
/*    */   implements Listener {
/* 29 */   private static MainClass plugin = MainClass.plugin;
/*    */ 
/*    */ 
/*    */   
/*    */   @EventHandler
/*    */   public void onBlockBreak(BlockBreakEvent e) {
/* 35 */     int range = plugin.getConfig().getInt("Enchants.Keyalls.Procrange");
/*    */     
/* 37 */     Player p = e.getPlayer();
/* 38 */     Random random = new Random();
/* 39 */     ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
/*    */     
/* 41 */     int chance = random.nextInt(range) + 1;
/* 42 */     int control = random.nextInt(7) + 1;
/* 43 */     if (p.getInventory().getItemInMainHand().hasItemMeta() && 
/* 44 */       p.getInventory().getItemInMainHand().getItemMeta().hasLore()) {
/* 45 */       int enchlevel = -1;
/* 46 */       for (String str : p.getInventory().getItemInMainHand().getItemMeta().getLore()) {
/* 47 */         if (str.contains("Keyalls")) {
/* 48 */           enchlevel = Integer.valueOf(str.split(" ")[1]).intValue();
/*    */           
/* 50 */           ApplicableRegionSet set = getApplicableRegions(e.getBlock().getLocation());
/* 51 */           LocalPlayer localPlayer = WorldGuardPlugin.inst().wrapPlayer(p);
/*    */           
/* 53 */           if (chance <= enchlevel && set.testState((RegionAssociable)localPlayer, new StateFlag[] { Flags.BLOCK_BREAK })) {
/* 54 */             if (control < 5) {
/* 55 */               p.sendMessage(ChatColor.translateAlternateColorCodes('&', 
/* 56 */                     plugin.getConfig().getString("Enchants.Keyalls.Message")));
/* 57 */               Bukkit.dispatchCommand((CommandSender)console, plugin.getConfig()
/* 58 */                   .getString("Enchants.Keyalls.Crateone").replace("{username}", p.getName()));
/* 59 */               p.playSound(p.getLocation(), Sound.ENTITY_SPLASH_POTION_THROW, 1.0F, 1.0F);
/* 60 */               p.playEffect(p.getLocation(), Effect.BOW_FIRE, 1); continue;
/* 61 */             }  if (control == 5 || control == 6) {
/* 62 */               p.sendMessage(ChatColor.translateAlternateColorCodes('&', 
/* 63 */                     plugin.getConfig().getString("Enchants.Keyalls.Message")));
/* 64 */               Bukkit.dispatchCommand((CommandSender)console, plugin.getConfig()
/* 65 */                   .getString("Enchants.Keyalls.Cratetwo").replace("{username}", p.getName()));
/* 66 */               p.playSound(p.getLocation(), Sound.ENTITY_SPLASH_POTION_THROW, 1.0F, 1.0F);
/* 67 */               p.playEffect(p.getLocation(), Effect.BOW_FIRE, 1); continue;
/*    */             } 
/* 69 */             p.sendMessage(ChatColor.translateAlternateColorCodes('&', 
/* 70 */                   plugin.getConfig().getString("Enchants.Keyalls.Message")));
/* 71 */             Bukkit.dispatchCommand((CommandSender)console, plugin.getConfig()
/* 72 */                 .getString("Enchants.Keyalls.Cratethree").replace("{username}", p.getName()));
/* 73 */             p.playSound(p.getLocation(), Sound.ENTITY_SPLASH_POTION_THROW, 1.0F, 1.0F);
/* 74 */             p.playEffect(p.getLocation(), Effect.BOW_FIRE, 1);
/*    */           } 
/*    */         } 
/*    */       } 
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private ApplicableRegionSet getApplicableRegions(Location loc) {
/* 85 */     RegionContainer container = WorldGuard.getInstance().getPlatform().getRegionContainer();
/*    */     RegionManager manager;
/* 87 */     if (container == null || (manager = container.get(BukkitAdapter.adapt(loc.getWorld()))) == null) {
/* 88 */       return null;
/*    */     }
/* 90 */     return manager.getApplicableRegions(BukkitAdapter.asBlockVector(loc));
/*    */   }
/*    */ }


/* Location:              C:\Users\17hautrivel\Desktop\PrisonEnchants.jar!\me\iLucaH\PrisonEnchants\Enchants\Keyalls.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */