/*    */ package me.iLucaH.PrisonEnchants.Enchants;
/*    */ 
/*    */ import java.text.DecimalFormat;
/*    */ import java.util.Random;
/*    */ import me.iLucaH.PrisonEnchants.MainClass;
/*    */ import net.milkbowl.vault.economy.Economy;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.ChatColor;
/*    */ import org.bukkit.OfflinePlayer;
/*    */ import org.bukkit.Sound;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.block.BlockBreakEvent;
/*    */ 
/*    */ public class Charity
/*    */   implements Listener {
/* 18 */   private static Economy econ = MainClass.economy;
/* 19 */   private static MainClass plugin = MainClass.plugin;
/*    */ 
/*    */ 
/*    */   
/*    */   @EventHandler
/*    */   public void onBlockBreak(BlockBreakEvent e) {
/* 25 */     int range = plugin.getConfig().getInt("Enchants.Charity.Procrange");
/* 26 */     DecimalFormat df = new DecimalFormat("#,###.00");
/* 27 */     Player p = e.getPlayer();
/* 28 */     Random random = new Random();
/* 29 */     double econommy = econ.getBalance((OfflinePlayer)p);
/* 30 */     double bal = econommy * 0.001D;
/* 31 */     int finalbal = (int)Math.round(bal);
/* 32 */     String configmessage = plugin.getConfig().getString("Enchants.Charity.Message").replace("{username}", p.getName());
/*    */     
/* 34 */     String message = ChatColor.translateAlternateColorCodes('&', configmessage);
/*    */     
/* 36 */     message = message.replace("{amount}", df.format(finalbal));
/* 37 */     if (p.getInventory().getItemInMainHand().hasItemMeta() && 
/* 38 */       p.getInventory().getItemInMainHand().getItemMeta().hasLore()) {
/* 39 */       int enchlevel = -1;
/* 40 */       for (String str : p.getInventory().getItemInMainHand().getItemMeta().getLore()) {
/* 41 */         if (str.contains("Charity")) {
/* 42 */           enchlevel = Integer.valueOf(str.split(" ")[1]).intValue();
/* 43 */           int chance = random.nextInt(range) + 1;
/* 44 */           if (chance <= enchlevel) {
/* 45 */             p.sendMessage("§6You donated §e§l$" + df.format(finalbal) + "§6 to §6§leveryone §6online!");
/* 46 */             for (Player players : Bukkit.getServer().getOnlinePlayers()) {
/* 47 */               econ.depositPlayer((OfflinePlayer)players, finalbal);
/* 48 */               Bukkit.broadcastMessage(message);
/* 49 */               players.playSound(players.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0F, 1.0F);
/*    */             } 
/*    */           } 
/*    */         } 
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\17hautrivel\Desktop\PrisonEnchants.jar!\me\iLucaH\PrisonEnchants\Enchants\Charity.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */