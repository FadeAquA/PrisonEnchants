/*    */ package me.iLucaH.PrisonEnchants.Enchants;
/*    */ 
/*    */ import java.util.Random;
/*    */ import me.iLucaH.PrisonEnchants.MainClass;
/*    */ import me.iLucaH.PrisonEnchants.Tokens.Tokens;
/*    */ import org.bukkit.ChatColor;
/*    */ import org.bukkit.Sound;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.block.BlockBreakEvent;
/*    */ 
/*    */ public class Shockwave
/*    */   implements Listener
/*    */ {
/* 16 */   private static MainClass plugin = MainClass.plugin;
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
/* 30 */     int range = plugin.getConfig().getInt("Enchants.Shockwave.Procrange");
/*    */     
/* 32 */     Player p = e.getPlayer();
/* 33 */     Random gen = new Random();
/* 34 */     int chance = gen.nextInt(range) + 1;
/* 35 */     int x = plugin.getConfig().getInt("Enchants.Shockwave.Mineheight");
/* 36 */     int y = plugin.getConfig().getInt("Enchants.Shockwave.Minewidth");
/* 37 */     int blocks = x * y;
/* 38 */     int shave = gen.nextInt(250) + 1;
/* 39 */     Long amount = Long.valueOf((blocks * shave));
/* 40 */     Long bonusamount = Long.valueOf(amount.longValue() * 3L);
/* 41 */     int lvl5000 = gen.nextInt(100) + 1;
/* 42 */     Tokens tokens = new Tokens(p.getUniqueId());
/* 43 */     if (p.getInventory().getItemInMainHand().hasItemMeta() && 
/* 44 */       p.getInventory().getItemInMainHand().getItemMeta().hasLore()) {
/* 45 */       int enchlevel = -1;
/* 46 */       for (String str : p.getInventory().getItemInMainHand().getItemMeta().getLore()) {
/* 47 */         if (str.contains("Shockwave")) {
/* 48 */           enchlevel = Integer.valueOf(str.split(" ")[1]).intValue();
/* 49 */           if (chance <= enchlevel) {
/* 50 */             if (enchlevel == 5000) {
/* 51 */               if (chance <= 5000 && lvl5000 == 69) {
/* 52 */                 p.sendMessage(ChatColor.DARK_RED + "§l*** " + ChatColor.RED + "§lSHOCKWAVE BONUS!" + 
/* 53 */                     ChatColor.DARK_RED + "§l ***");
/* 54 */                 p.sendMessage(ChatColor.translateAlternateColorCodes('&', 
/* 55 */                       plugin.getConfig().getString("Enchants.Shockwavebonus.Bonusmessage")
/* 56 */                       .replace("{amount}", String.valueOf(plugin.getConfig().getString("Tokens.Symbol")) + Long.toString(bonusamount.longValue()))));
/* 57 */                 p.sendMessage(ChatColor.DARK_RED + "§l*** " + ChatColor.RED + "§lSHOCKWAVE BONUS!" + 
/* 58 */                     ChatColor.DARK_RED + "§l ***");
/* 59 */                 p.playSound(p.getLocation(), Sound.BLOCK_PORTAL_TRIGGER, 1.0F, 1.0F);
/* 60 */                 tokens.addTokens(Long.valueOf(plugin.getConfig().getLong("Enchants.Shockwavebonus.Tokensamount")));
/* 61 */                 tokens.addTokens(Long.valueOf(amount.longValue() * 3L));
/* 62 */                 tokens.savePlayerConfig(); continue;
/* 63 */               }  if (chance <= 5000) {
/* 64 */                 p.sendMessage(ChatColor.translateAlternateColorCodes('&', 
/* 65 */                       plugin.getConfig().getString("Enchants.Shockwave.Message")
/* 66 */                       .replace("{amount}", String.valueOf(plugin.getConfig().getString("Tokens.Symbol")) + Long.toString(amount.longValue()))));
/* 67 */                 p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_FALL, 1.0F, 1.0F);
/* 68 */                 tokens.addTokens(amount);
/* 69 */                 tokens.savePlayerConfig();
/*    */               }  continue;
/*    */             } 
/* 72 */             p.sendMessage(ChatColor.translateAlternateColorCodes('&', 
/* 73 */                   plugin.getConfig().getString("Enchants.Shockwave.Message").replace("{amount}", 
/* 74 */                     String.valueOf(plugin.getConfig().getString("Tokens.Symbol")) + Long.toString(amount.longValue()))));
/* 75 */             p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_FALL, 1.0F, 1.0F);
/* 76 */             tokens.addTokens(amount);
/* 77 */             tokens.savePlayerConfig();
/*    */           } 
/*    */         } 
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\17hautrivel\Desktop\PrisonEnchants.jar!\me\iLucaH\PrisonEnchants\Enchants\Shockwave.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */