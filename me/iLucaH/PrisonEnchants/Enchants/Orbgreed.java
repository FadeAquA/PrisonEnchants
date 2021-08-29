/*    */ package me.iLucaH.PrisonEnchants.Enchants;
/*    */ 
/*    */ import java.text.DecimalFormat;
/*    */ import java.util.Random;
/*    */ import me.iLucaH.PrisonEnchants.MainClass;
/*    */ import me.iLucaH.PrisonEnchants.Tokens.Tokens;
/*    */ import org.bukkit.ChatColor;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.block.BlockBreakEvent;
/*    */ 
/*    */ public class Orbgreed
/*    */   implements Listener
/*    */ {
/* 16 */   private static MainClass plugin = MainClass.plugin;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @EventHandler
/*    */   public void onBlockBreak(BlockBreakEvent e) {
/* 25 */     int range = plugin.getConfig().getInt("Enchants.Tokengreed.Procrange");
/* 26 */     DecimalFormat df = new DecimalFormat("#,###");
/* 27 */     Player p = e.getPlayer();
/* 28 */     Tokens tokens = new Tokens(p.getUniqueId());
/* 29 */     Random random = new Random();
/* 30 */     int chance = random.nextInt(range) + 1;
/* 31 */     int amounti = random.nextInt(19899) + 150;
/* 32 */     Long amount = new Long(amounti);
/*    */     
/* 34 */     if (p.getInventory().getItemInMainHand().hasItemMeta() && 
/* 35 */       p.getInventory().getItemInMainHand().getItemMeta().hasLore()) {
/* 36 */       int enchlevel = -1;
/* 37 */       for (String str : p.getInventory().getItemInMainHand().getItemMeta().getLore()) {
/* 38 */         if (str.contains("Tokengreed")) {
/* 39 */           enchlevel = Integer.valueOf(str.split(" ")[1]).intValue();
/* 40 */           if (chance <= enchlevel) {
/* 41 */             p.sendMessage(ChatColor.translateAlternateColorCodes('&', 
/* 42 */                   plugin.getConfig().getString("Enchants.Tokengreed.Message").replace("{amount}", 
/* 43 */                     String.valueOf(plugin.getConfig().getString("Tokens.Symbol")) + df.format(amount))));
/* 44 */             tokens.addTokens(amount);
/* 45 */             tokens.savePlayerConfig();
/*    */           } 
/*    */         } 
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\17hautrivel\Desktop\PrisonEnchants.jar!\me\iLucaH\PrisonEnchants\Enchants\Orbgreed.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */