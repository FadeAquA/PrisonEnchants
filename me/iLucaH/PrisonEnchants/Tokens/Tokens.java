/*    */ package me.iLucaH.PrisonEnchants.Tokens;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.io.IOException;
/*    */ import java.util.UUID;
/*    */ import me.iLucaH.PrisonEnchants.PluginLogs;
/*    */ import org.bukkit.configuration.file.FileConfiguration;
/*    */ import org.bukkit.configuration.file.YamlConfiguration;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Tokens
/*    */ {
/*    */   UUID u;
/*    */   File pData;
/*    */   FileConfiguration pDataConfig;
/*    */   
/*    */   public Tokens(UUID u) {
/* 19 */     this.u = u;
/*    */     
/* 21 */     this.pData = new File("plugins/PrisonEnchants/Tokens/" + u + ".yml");
/* 22 */     this.pDataConfig = (FileConfiguration)YamlConfiguration.loadConfiguration(this.pData);
/*    */   }
/*    */   
/*    */   public void createPlayerConfig() {
/*    */     try {
/* 27 */       this.pData.createNewFile();
/* 28 */     } catch (IOException e) {
/* 29 */       e.printStackTrace();
/*    */     } 
/*    */   }
/*    */   
/*    */   public void createPlayerDefaults() {
/* 34 */     if (this.pData.length() <= 0L) {
/* 35 */       this.pDataConfig.set("Tokens", Integer.valueOf(0));
/*    */     }
/*    */   }
/*    */   
/*    */   public FileConfiguration getPlayerConfig() {
/* 40 */     return this.pDataConfig;
/*    */   }
/*    */   
/*    */   public void savePlayerConfig() {
/*    */     try {
/* 45 */       getPlayerConfig().save(this.pData);
/* 46 */     } catch (IOException e) {
/* 47 */       e.printStackTrace();
/*    */     } 
/*    */   }
/*    */   
/*    */   public Long getTokens() {
/* 52 */     return Long.valueOf(this.pDataConfig.getLong("Tokens"));
/*    */   }
/*    */   
/*    */   public void setTokens(Long amount) {
/* 56 */     this.pDataConfig.set("Tokens", amount);
/*    */     try {
/* 58 */       PluginLogs.logMessage("Set " + this.u + "'s Tokens to " + amount);
/* 59 */     } catch (IOException e) {
/* 60 */       e.printStackTrace();
/*    */     } 
/*    */   }
/*    */   
/*    */   public void removeTokens(Long amount) {
/* 65 */     this.pDataConfig.set("Tokens", Long.valueOf(getTokens().longValue() - amount.longValue()));
/*    */   }
/*    */   
/*    */   public void addTokens(Long amount) {
/* 69 */     this.pDataConfig.set("Tokens", Long.valueOf(getTokens().longValue() + amount.longValue()));
/*    */   }
/*    */ }


/* Location:              C:\Users\17hautrivel\Desktop\PrisonEnchants.jar!\me\iLucaH\PrisonEnchants\Tokens\Tokens.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */