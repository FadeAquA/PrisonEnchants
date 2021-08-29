/*    */ package me.iLucaH.PrisonEnchants.Enchants;
/*    */ 
/*    */ import java.text.DecimalFormat;
/*    */ import java.util.Random;
/*    */ import me.iLucaH.PrisonEnchants.MainClass;
/*    */ import net.milkbowl.vault.economy.Economy;
/*    */ import org.bukkit.ChatColor;
/*    */ import org.bukkit.OfflinePlayer;
/*    */ import org.bukkit.Sound;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.block.BlockBreakEvent;
/*    */ 
/*    */ public class Moneygreed
/*    */   implements Listener {
/* 17 */   private static Economy econ = MainClass.economy;
/* 18 */   private static MainClass plugin = MainClass.plugin;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @EventHandler
/*    */   public void onBlockBreak(BlockBreakEvent e) {
/* 28 */     int range = plugin.getConfig().getInt("Enchants.Moneygreed.Procrange");
/* 29 */     DecimalFormat df = new DecimalFormat("#,###");
/* 30 */     Player p = e.getPlayer();
/* 31 */     Random random = new Random();
/* 32 */     int chance = random.nextInt(range) + 1;
/* 33 */     double econommy = econ.getBalance((OfflinePlayer)p);
/* 34 */     double bal = econommy * 0.1D;
/* 35 */     int finalbal = (int)Math.round(bal);
/*    */     
/* 37 */     if (p.getInventory().getItemInMainHand().hasItemMeta() && 
/* 38 */       p.getInventory().getItemInMainHand().getItemMeta().hasLore()) {
/* 39 */       int enchlevel = -1;
/* 40 */       for (String str : p.getInventory().getItemInMainHand().getItemMeta().getLore()) {
/* 41 */         if (str.contains("Moneygreed")) {
/* 42 */           enchlevel = Integer.valueOf(str.split(" ")[1]).intValue();
/* 43 */           if (chance <= enchlevel) {
/* 44 */             econ.depositPlayer((OfflinePlayer)p, finalbal);
/* 45 */             p.sendMessage(ChatColor.translateAlternateColorCodes('&', 
/* 46 */                   plugin.getConfig().getString("Enchants.Moneygreed.Message").replace("{amount}", 
/* 47 */                     df.format(finalbal))));
/* 48 */             p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 1.0F);
/*    */           } 
/*    */         } 
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\17hautrivel\Desktop\PrisonEnchants.jar!\me\iLucaH\PrisonEnchants\Enchants\Moneygreed.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */