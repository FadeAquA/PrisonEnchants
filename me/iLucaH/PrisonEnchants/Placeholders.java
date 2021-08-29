/*    */ package me.iLucaH.PrisonEnchants;
/*    */ 
/*    */ import java.text.DecimalFormat;
/*    */ import me.clip.placeholderapi.expansion.PlaceholderExpansion;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.OfflinePlayer;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Placeholders
/*    */   extends PlaceholderExpansion
/*    */ {
/*    */   MainClass plugin;
/*    */   
/*    */   public Placeholders(MainClass mainClass) {}
/*    */   
/*    */   public String getAuthor() {
/* 18 */     return "iLucaH";
/*    */   }
/*    */ 
/*    */   
/*    */   public String getIdentifier() {
/* 23 */     return "prisonenchants";
/*    */   }
/*    */ 
/*    */   
/*    */   public String getVersion() {
/* 28 */     return "1.0.0";
/*    */   }
/*    */ 
/*    */   
/*    */   public String getRequiredPlugin() {
/* 33 */     return "PrisonEnchants";
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean canRegister() {
/* 38 */     return ((this.plugin = (MainClass)Bukkit.getPluginManager().getPlugin(getRequiredPlugin())) != null);
/*    */   }
/*    */ 
/*    */   
/*    */   public String onRequest(OfflinePlayer player, String params) {
/* 43 */     DecimalFormat df = new DecimalFormat("#,###");
/* 44 */     if (params.equalsIgnoreCase("tint")) {
/* 45 */       return String.valueOf(this.plugin.getTokenBal(player.getUniqueId()));
/*    */     }
/*    */     
/* 48 */     if (params.equalsIgnoreCase("tform")) {
/* 49 */       return String.valueOf(this.plugin.getConfig().getString("Tokens.Symbol")) + df.format(this.plugin.getTokenBal(player.getUniqueId()));
/*    */     }
/*    */     
/* 52 */     if (params.equalsIgnoreCase("td")) {
/* 53 */       return String.valueOf(this.plugin.getConfig().getString("Tokens.Symbol")) + Utils.formatValue(this.plugin.getTokenBal(player.getUniqueId()));
/*    */     }
/*    */     
/* 56 */     if (params.equalsIgnoreCase("topone")) {
/* 57 */       return Utils.getTopTokens(1);
/*    */     }
/*    */     
/* 60 */     if (params.equalsIgnoreCase("toptwo")) {
/* 61 */       return Utils.getTopTokens(2);
/*    */     }
/*    */     
/* 64 */     if (params.equalsIgnoreCase("topthree")) {
/* 65 */       return Utils.getTopTokens(3);
/*    */     }
/*    */     
/* 68 */     if (params.equalsIgnoreCase("topfour")) {
/* 69 */       return Utils.getTopTokens(4);
/*    */     }
/*    */     
/* 72 */     if (params.equalsIgnoreCase("topfive")) {
/* 73 */       return Utils.getTopTokens(5);
/*    */     }
/*    */     
/* 76 */     if (params.equalsIgnoreCase("topsix")) {
/* 77 */       return Utils.getTopTokens(6);
/*    */     }
/*    */     
/* 80 */     if (params.equalsIgnoreCase("topseven")) {
/* 81 */       return Utils.getTopTokens(7);
/*    */     }
/*    */     
/* 84 */     if (params.equalsIgnoreCase("topeight")) {
/* 85 */       return Utils.getTopTokens(8);
/*    */     }
/*    */     
/* 88 */     if (params.equalsIgnoreCase("topnine")) {
/* 89 */       return Utils.getTopTokens(9);
/*    */     }
/*    */     
/* 92 */     if (params.equalsIgnoreCase("topten")) {
/* 93 */       return Utils.getTopTokens(10);
/*    */     }
/*    */     
/* 96 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\Users\17hautrivel\Desktop\PrisonEnchants.jar!\me\iLucaH\PrisonEnchants\Placeholders.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */