/*     */ package me.iLucaH.PrisonEnchants.Tokens;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.text.DecimalFormat;
/*     */ import java.util.UUID;
/*     */ import me.iLucaH.PrisonEnchants.MainClass;
/*     */ import me.iLucaH.PrisonEnchants.Utils;
/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.ChatColor;
/*     */ import org.bukkit.OfflinePlayer;
/*     */ import org.bukkit.command.Command;
/*     */ import org.bukkit.command.CommandExecutor;
/*     */ import org.bukkit.command.CommandSender;
/*     */ import org.bukkit.command.ConsoleCommandSender;
/*     */ import org.bukkit.configuration.file.FileConfiguration;
/*     */ import org.bukkit.configuration.file.YamlConfiguration;
/*     */ import org.bukkit.entity.Player;
/*     */ 
/*     */ 
/*     */ public class TokensCommands
/*     */   implements CommandExecutor
/*     */ {
/*     */   File pData;
/*     */   FileConfiguration pDataConfig;
/*  26 */   private static MainClass plugin = MainClass.plugin;
/*     */   
/*     */   public Long getTokens() {
/*  29 */     return Long.valueOf(this.pDataConfig.getLong("Tokens"));
/*     */   }
/*     */   
/*     */   public FileConfiguration getPlayerConfig() {
/*  33 */     return this.pDataConfig;
/*     */   }
/*     */   
/*     */   public void savePlayerConfig() {
/*     */     try {
/*  38 */       getPlayerConfig().save(this.pData);
/*  39 */     } catch (IOException e) {
/*  40 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public ChatColor getDominantColor() {
/*  45 */     ChatColor dominant = 
/*  46 */       ChatColor.valueOf(plugin.getConfig().getString("Tokens.Messages.Dominantcolor").toUpperCase());
/*  47 */     return dominant;
/*     */   }
/*     */   
/*     */   public ChatColor getSecondaryColor() {
/*  51 */     ChatColor secondary = 
/*  52 */       ChatColor.valueOf(plugin.getConfig().getString("Tokens.Messages.Secondarycolor").toUpperCase());
/*  53 */     return secondary;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
/*  58 */     DecimalFormat df = new DecimalFormat("#,###");
/*     */     try {
/*  60 */       if (sender.hasPermission("prisonenchants.tokens.usecmds") || sender.hasPermission("prisonenchants.admin") || sender.hasPermission("prisonenchants.player")) {
/*  61 */         if (args.length == 0) {
/*  62 */           UUID senderuuid = ((OfflinePlayer)sender).getUniqueId();
/*  63 */           Tokens tokens = new Tokens(senderuuid);
/*  64 */           sender.sendMessage(getDominantColor() + "§lTokens: §f" + getSecondaryColor() + 
/*  65 */               plugin.getConfig().getString("Tokens.Symbol") + df.format(tokens.getTokens()));
/*  66 */           return true;
/*  67 */         }  if (args.length == 1) {
/*  68 */           if (args[0].equalsIgnoreCase("add")) {
/*  69 */             sender.sendMessage(getDominantColor() + "/tokens" + getSecondaryColor() + " add" + 
/*  70 */                 getDominantColor() + " <" + getSecondaryColor() + "player" + getDominantColor() + 
/*  71 */                 "> <" + getSecondaryColor() + "amount" + getDominantColor() + ">");
/*  72 */             return true;
/*  73 */           }  if (args[0].equalsIgnoreCase("remove")) {
/*  74 */             sender.sendMessage(getDominantColor() + "/tokens" + getSecondaryColor() + " remove" + 
/*  75 */                 getDominantColor() + " <" + getSecondaryColor() + "player" + getDominantColor() + 
/*  76 */                 "> <" + getSecondaryColor() + "amount" + getDominantColor() + ">");
/*  77 */             return true;
/*  78 */           }  if (args[0].equalsIgnoreCase("set")) {
/*  79 */             sender.sendMessage(getDominantColor() + "/tokens" + getSecondaryColor() + " set" + 
/*  80 */                 getDominantColor() + " <" + getSecondaryColor() + "player" + getDominantColor() + 
/*  81 */                 "> <" + getSecondaryColor() + "amount" + getDominantColor() + ">");
/*  82 */             return true;
/*  83 */           }  if (args[0].equalsIgnoreCase("view")) {
/*  84 */             sender.sendMessage(getDominantColor() + "/tokens" + getSecondaryColor() + " add" + 
/*  85 */                 getDominantColor() + " <" + getSecondaryColor() + "player" + getDominantColor() + 
/*  86 */                 "> <" + getSecondaryColor() + "amount" + getDominantColor() + ">");
/*  87 */             return true;
/*     */           } 
/*  89 */           if (args[0].equalsIgnoreCase("top")) {
/*  90 */             if (sender.hasPermission("prisonenchants.tokens.top") || sender.hasPermission("prisonenchants.player")) {
/*  91 */               sender.sendMessage(getDominantColor() + "Top 10 Players Tokens:");
/*  92 */               for (String str : Utils.getTopTokens()) {
/*  93 */                 sender.sendMessage(str);
/*     */               }
/*  95 */               Utils.clearTokenTop();
/*  96 */               return true;
/*     */             } 
/*  98 */             sender.sendMessage(
/*  99 */                 getDominantColor() + "You do not have permission to execute this command!");
/*     */           }
/*     */           else {
/*     */             
/* 103 */             sender.sendMessage(getDominantColor() + "/tokens" + getSecondaryColor() + 
/* 104 */                 " view:top:withdraw:pay" + getDominantColor() + " <" + getSecondaryColor() + "player" + 
/* 105 */                 getDominantColor() + "> <" + getSecondaryColor() + "amount" + getDominantColor() + 
/* 106 */                 ">");
/* 107 */             return true;
/*     */           } 
/* 109 */         } else if (args.length == 2) {
/*     */           
/* 111 */           if (args[0].equalsIgnoreCase("view")) {
/* 112 */             if (sender.hasPermission("prisonenchants.tokens.view") || sender.hasPermission("prisonenchants.player")) {
/*     */               
/* 114 */               OfflinePlayer p = Bukkit.getOfflinePlayer(args[1]);
/* 115 */               Tokens tokens = new Tokens(p.getUniqueId());
/* 116 */               sender.sendMessage(getDominantColor() + "The player " + getSecondaryColor() + p.getName() + 
/* 117 */                   getDominantColor() + "'s token balance is " + getSecondaryColor() + 
/* 118 */                   plugin.getConfig().getString("Tokens.Symbol") + df.format(tokens.getTokens()));
/* 119 */               return true;
/*     */             } 
/* 121 */             sender.sendMessage(
/* 122 */                 getDominantColor() + "You do not have permission to execute this command!");
/*     */           } else {
/* 124 */             if (args[0].equalsIgnoreCase("withdraw")) {
/* 125 */               if (sender.hasPermission("prisonenchants.tokens.withdraw") || sender.hasPermission("prisonenchants.player")) {
/* 126 */                 Player p = (Player)sender;
/* 127 */                 Tokens tokens = new Tokens(p.getUniqueId());
/* 128 */                 Long amount = Long.valueOf(Long.parseLong(args[1]));
/* 129 */                 if (tokens.getTokens().longValue() >= amount.longValue()) {
/* 130 */                   if (amount.longValue() >= plugin.getConfig().getInt("Tokens.Withdrawminimum")) {
/* 131 */                     sender.sendMessage("§c§l - " + plugin.getConfig().getString("Tokens.Symbol") + 
/* 132 */                         amount + " §7(Withdrawn)");
/* 133 */                     tokens.removeTokens(amount);
/* 134 */                     tokens.savePlayerConfig();
/* 135 */                     Utils.giveTokenNote(p, p.getName(), amount);
/* 136 */                     return true;
/*     */                   } 
/* 138 */                   sender.sendMessage(getDominantColor() + "The minimum withdraw amount is: " + 
/* 139 */                       getSecondaryColor() + plugin.getConfig().getString("Tokens.Symbol") + 
/* 140 */                       df.format(plugin.getConfig().getInt("Tokens.Withdrawminimum")));
/* 141 */                   return true;
/*     */                 } 
/*     */                 
/* 144 */                 sender.sendMessage(getDominantColor() + "You dont have enough tokens!");
/* 145 */                 return true;
/*     */               } 
/*     */               
/* 148 */               sender.sendMessage(getDominantColor() + "/tokens view:top:withdraw:pay " + "player:amount");
/* 149 */               return true;
/*     */             } 
/*     */             
/* 152 */             sender.sendMessage(getDominantColor() + "You do not have permission to execute this command!");
/*     */           } 
/* 154 */         } else if (args.length == 3) {
/*     */           
/* 156 */           OfflinePlayer p = Bukkit.getOfflinePlayer(args[1]);
/* 157 */           Long amount = Long.valueOf(Long.parseLong(args[2]));
/* 158 */           if (args[0].equalsIgnoreCase("give"))
/* 159 */           { if (sender.hasPermission("prisonenchants.admin")) {
/* 160 */               if (p != null) {
/* 161 */                 Tokens tokens = new Tokens(p.getUniqueId());
/* 162 */                 tokens.addTokens(amount);
/* 163 */                 tokens.savePlayerConfig();
/* 164 */                 sender.sendMessage(getDominantColor() + "You added " + getSecondaryColor() + args[2] + 
/* 165 */                     getDominantColor() + " tokens to " + getSecondaryColor() + p.getName() + 
/* 166 */                     getDominantColor() + "'s account!");
/* 167 */                 return true;
/*     */               } 
/* 169 */               sender.sendMessage("Player could not be found!");
/*     */             } else {
/*     */               
/* 172 */               sender.sendMessage(
/* 173 */                   getDominantColor() + "You do not have permission to execute this command!");
/*     */             }  }
/* 175 */           else if (args[0].equalsIgnoreCase("remove"))
/* 176 */           { if (sender.hasPermission("prisonenchants.admin")) {
/* 177 */               if (p != null) {
/* 178 */                 Tokens tokens = new Tokens(p.getUniqueId());
/* 179 */                 tokens.removeTokens(amount);
/* 180 */                 tokens.savePlayerConfig();
/* 181 */                 sender.sendMessage(getDominantColor() + "You removed " + getSecondaryColor() + args[2] + 
/* 182 */                     getDominantColor() + " tokens to " + getSecondaryColor() + p.getName() + 
/* 183 */                     getDominantColor() + "'s account!");
/* 184 */                 return true;
/*     */               } 
/* 186 */               sender.sendMessage("Player could not be found!");
/*     */             }
/*     */              }
/* 189 */           else if (args[0].equalsIgnoreCase("pay"))
/* 190 */           { if (sender.hasPermission("prisonenchants.tokens.pay") || sender.hasPermission("prisonenchants.player")) {
/* 191 */               if (p != null) {
/* 192 */                 UUID senderuuid = ((OfflinePlayer)sender).getUniqueId();
/* 193 */                 Tokens tokens = new Tokens(senderuuid);
/* 194 */                 if (amount.longValue() > 0L) {
/* 195 */                   if (tokens.getTokens().longValue() >= amount.longValue()) {
/* 196 */                     if (p.hasPlayedBefore()) {
/* 197 */                       if (p.getPlayer().isOnline()) {
/* 198 */                         String s = p.getUniqueId().toString();
/* 199 */                         ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
/* 200 */                         Bukkit.dispatchCommand((CommandSender)console, 
/* 201 */                             "tokens remove " + sender.getName() + " " + args[2]);
/* 202 */                         this.pData = new File("plugins/PrisonEnchants/Tokens/" + s + ".yml");
/* 203 */                         this.pDataConfig = (FileConfiguration)YamlConfiguration.loadConfiguration(this.pData);
/* 204 */                         this.pDataConfig.set("Tokens", Long.valueOf(getTokens().longValue() + amount.longValue()));
/* 205 */                         savePlayerConfig();
/* 206 */                         sender.sendMessage(getDominantColor() + "You sent " + 
/* 207 */                             getSecondaryColor() + 
/* 208 */                             plugin.getConfig().getString("Tokens.Symbol") + args[2] + 
/* 209 */                             getDominantColor() + " tokens to " + getSecondaryColor() + 
/* 210 */                             p.getName() + getDominantColor() + "!");
/* 211 */                         p.getPlayer().sendMessage(getDominantColor() + "You received " + 
/* 212 */                             getSecondaryColor() + 
/* 213 */                             plugin.getConfig().getString("Tokens.Symbol") + args[2] + 
/* 214 */                             getDominantColor() + " tokens from " + getSecondaryColor() + 
/* 215 */                             sender.getName() + getDominantColor() + "!");
/*     */                       } else {
/* 217 */                         sender.sendMessage(getDominantColor() + "Player is offline!");
/*     */                       } 
/*     */                     } else {
/* 220 */                       sender.sendMessage(
/* 221 */                           getDominantColor() + "Player has not joined this server!");
/*     */                     } 
/*     */                   } else {
/* 224 */                     sender.sendMessage(getDominantColor() + "You do not have enough tokens!");
/*     */                   } 
/*     */                 } else {
/* 227 */                   sender.sendMessage(getDominantColor() + "The minimum pay amount is 1!");
/*     */                 } 
/* 229 */                 return true;
/*     */               } 
/* 231 */               sender.sendMessage("Player could not be found!");
/*     */             } else {
/*     */               
/* 234 */               sender.sendMessage(
/* 235 */                   getDominantColor() + "You do not have permission to execute this command!");
/*     */             }  }
/* 237 */           else { if (args[0].equalsIgnoreCase("set")) {
/* 238 */               if (sender.hasPermission("prisonenchants.admin")) {
/* 239 */                 if (p != null) {
/* 240 */                   Tokens tokens = new Tokens(p.getUniqueId());
/* 241 */                   tokens.setTokens(amount);
/* 242 */                   tokens.savePlayerConfig();
/* 243 */                   sender.sendMessage(getDominantColor() + "You set " + getSecondaryColor() + p.getName() + 
/* 244 */                       getDominantColor() + "'s tokens to " + getSecondaryColor() + args[2]);
/*     */                 } else {
/* 246 */                   sender.sendMessage("Player could not be found!");
/*     */                 } 
/*     */               } else {
/* 249 */                 sender.sendMessage(
/* 250 */                     getDominantColor() + "You do not have permission to execute this command!");
/*     */               } 
/* 252 */               return true;
/*     */             } 
/* 254 */             sender.sendMessage(getDominantColor() + "/tokens" + getSecondaryColor() + 
/* 255 */                 " view:top:withdraw:pay" + getDominantColor() + " <" + getSecondaryColor() + "player" + 
/* 256 */                 getDominantColor() + "> <" + getSecondaryColor() + "amount" + getDominantColor() + 
/* 257 */                 ">");
/* 258 */             return true; }
/*     */         
/* 260 */         } else if (args.length > 3) {
/* 261 */           sender.sendMessage(getDominantColor() + "/tokens" + getSecondaryColor() + " view:top:withdraw:pay" + 
/* 262 */               getDominantColor() + " <" + getSecondaryColor() + "player" + getDominantColor() + "> <" + 
/* 263 */               getSecondaryColor() + "amount" + getDominantColor() + ">");
/* 264 */           return true;
/*     */         } 
/*     */       } else {
/* 267 */         sender.sendMessage(getDominantColor() + "You do not have permission to execute this command!");
/* 268 */         return true;
/*     */       } 
/* 270 */     } catch (Exception e) {
/* 271 */       sender.sendMessage(getDominantColor() + "Please use the correct command:");
/* 272 */       sender.sendMessage(getDominantColor() + "/tokens" + getSecondaryColor() + " view:top:withdraw:pay" + 
/* 273 */           getDominantColor() + " <" + getSecondaryColor() + "player" + getDominantColor() + "> <" + 
/* 274 */           getSecondaryColor() + "amount" + getDominantColor() + ">");
/* 275 */       return true;
/*     */     } 
/*     */     
/* 278 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\17hautrivel\Desktop\PrisonEnchants.jar!\me\iLucaH\PrisonEnchants\Tokens\TokensCommands.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */