/*     */ package me.iLucaH.PrisonEnchants;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.util.UUID;
/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.ChatColor;
/*     */ import org.bukkit.OfflinePlayer;
/*     */ import org.bukkit.command.Command;
/*     */ import org.bukkit.command.CommandExecutor;
/*     */ import org.bukkit.command.CommandSender;
/*     */ import org.bukkit.entity.Player;
/*     */ 
/*     */ 
/*     */ public class ModifierCommand
/*     */   implements CommandExecutor
/*     */ {
/*  17 */   private static MainClass plugin = MainClass.plugin;
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean onCommand(CommandSender sender, Command cmd, String key, String[] args) {
/*  22 */     if (sender.hasPermission("prisonenchants.admin")) {
/*     */ 
/*     */       
/*  25 */       if (args.length == 0) {
/*     */         
/*  27 */         incorrectMessage(sender);
/*  28 */         return true;
/*     */       } 
/*  30 */       if (args.length == 1) {
/*     */         
/*  32 */         if (args[0].equalsIgnoreCase("reload")) {
/*  33 */           if (sender.hasPermission("prisonenchants.admin.reload")) {
/*     */             
/*  35 */             plugin.reloadConfig();
/*     */             
/*  37 */             sender.sendMessage("§6Configuration file reloaded!");
/*     */             
/*     */             try {
/*  40 */               PluginLogs.logMessage("Configuration file reloaded by " + PluginLogs.getWhoSent(sender) + "!");
/*  41 */             } catch (IOException e) {
/*  42 */               e.printStackTrace();
/*     */             } 
/*     */           } else {
/*  45 */             sender.sendMessage("§cYou do not have permission to execute this command!");
/*     */           }
/*     */         
/*  48 */         } else if (!args[0].equalsIgnoreCase("reload")) {
/*     */           
/*  50 */           incorrectMessage(sender);
/*     */         }
/*     */       
/*  53 */       } else if (args.length == 2) {
/*     */         
/*  55 */         if (args[0].equalsIgnoreCase("help")) {
/*     */           
/*  57 */           if (args[1].equals("1")) {
/*     */             
/*  59 */             helpPageOne(sender);
/*  60 */           } else if (args[1].equals("2")) {
/*  61 */             helpPageTwo(sender);
/*  62 */           } else if (args[1].equals("3")) {
/*  63 */             helpPageThree(sender);
/*     */           } 
/*  65 */         } else if (args[0].equalsIgnoreCase("addenchant")) {
/*  66 */           sender.sendMessage("§6Incorrect Usage!");
/*  67 */           sender.sendMessage("§6/pe addenchant <enchant> <level>");
/*  68 */         } else if (args[0].equalsIgnoreCase("namelookup")) {
/*  69 */           String uuid = args[1];
/*  70 */           OfflinePlayer player = Bukkit.getOfflinePlayer(UUID.fromString(uuid));
/*  71 */           sender.sendMessage(player.getName());
/*  72 */         } else if (args[0].equalsIgnoreCase("logs")) {
/*     */           try {
/*  74 */             if (args[1] == null) {
/*  75 */               sender.sendMessage("Please enter a page number to search for.");
/*  76 */               return true;
/*     */             } 
/*  78 */             int pageno = Integer.parseInt(args[1]);
/*  79 */             sender.sendMessage(ChatColor.GOLD + "[INFORMATION] Page index starts at 0.");
/*  80 */             sender.sendMessage(ChatColor.GOLD + "[INFORMATION] Page index recalls the oldest text, 50 recalls the newest.");
/*  81 */             sender.sendMessage(ChatColor.GOLD + "[WARNING] A server restart may be needed to recall latest logs.");
/*  82 */             sender.sendMessage(ChatColor.GOLD + "Plugin Logs on page: " + pageno + "/49");
/*  83 */             for (String str : PluginLogs.feedbackLogs(pageno)) {
/*  84 */               sender.sendMessage(ChatColor.YELLOW + str);
/*     */             }
/*     */           }
/*  87 */           catch (Exception exc) {
/*  88 */             sender.sendMessage("Please enter a valid pagenumber.");
/*     */           } 
/*  90 */           return true;
/*     */         } 
/*  92 */       } else if (args.length == 3) {
/*  93 */         Player p = (Player)sender;
/*  94 */         if (args[0].equalsIgnoreCase("addenchant")) {
/*  95 */           if (Integer.parseInt(args[2]) >= 1000) {
/*     */             try {
/*  97 */               PluginLogs.logMessage(String.valueOf(p.getName()) + " has added " + args[2] + " to the enchant: " + args[1]);
/*  98 */             } catch (IOException e) {
/*  99 */               e.printStackTrace();
/*     */             } 
/*     */           }
/* 102 */           if (args[1].equalsIgnoreCase("speed")) {
/*     */             
/* 104 */             int amount = Integer.parseInt(args[2]);
/* 105 */             Utils.addToItem(p.getInventory().getItemInMainHand(), amount, args[1]);
/* 106 */             sender.sendMessage("§aYou added§2 " + amount + "§a to the the enchant §2" + args[1]);
/* 107 */             return true;
/*     */           } 
/* 109 */           if (args[1].equalsIgnoreCase("haste")) {
/* 110 */             int amount = Integer.parseInt(args[2]);
/* 111 */             Utils.addToItem(p.getInventory().getItemInMainHand(), amount, args[1]);
/* 112 */             sender.sendMessage("§aYou added§2 " + amount + "§a to the the enchant §2" + args[1]);
/* 113 */             return true;
/*     */           } 
/* 115 */           if (args[1].equalsIgnoreCase("nuker")) {
/* 116 */             int amount = Integer.parseInt(args[2]);
/* 117 */             Utils.addToItem(p.getInventory().getItemInMainHand(), amount, args[1]);
/* 118 */             sender.sendMessage("§aYou added§2 " + amount + "§a to the the enchant §2" + args[1]);
/* 119 */             return true;
/*     */           } 
/* 121 */           if (args[1].equalsIgnoreCase("keyalls")) {
/* 122 */             int amount = Integer.parseInt(args[2]);
/* 123 */             Utils.addToItem(p.getInventory().getItemInMainHand(), amount, args[1]);
/* 124 */             sender.sendMessage("§aYou added§2 " + amount + "§a to the the enchant §2" + args[1]);
/* 125 */             return true;
/*     */           } 
/* 127 */           if (args[1].equalsIgnoreCase("jumpboost")) {
/* 128 */             int amount = Integer.parseInt(args[2]);
/* 129 */             Utils.addToItem(p.getInventory().getItemInMainHand(), amount, args[1]);
/* 130 */             sender.sendMessage("§aYou added§2 " + amount + "§a to the the enchant §2" + args[1]);
/* 131 */             return true;
/*     */           } 
/* 133 */           if (args[1].equalsIgnoreCase("tokengreed")) {
/* 134 */             int amount = Integer.parseInt(args[2]);
/* 135 */             Utils.addToItem(p.getInventory().getItemInMainHand(), amount, args[1]);
/* 136 */             sender.sendMessage("§aYou added§2 " + amount + "§a to the the enchant §2" + args[1]);
/* 137 */             return true;
/*     */           } 
/* 139 */           if (args[1].equalsIgnoreCase("moneygreed")) {
/* 140 */             int amount = Integer.parseInt(args[2]);
/* 141 */             Utils.addToItem(p.getInventory().getItemInMainHand(), amount, args[1]);
/* 142 */             sender.sendMessage("§aYou added§2 " + amount + "§a to the the enchant §2" + args[1]);
/* 143 */             return true;
/*     */           } 
/* 145 */           if (args[1].equalsIgnoreCase("shockwave")) {
/* 146 */             int amount = Integer.parseInt(args[2]);
/* 147 */             Utils.addToItem(p.getInventory().getItemInMainHand(), amount, args[1]);
/* 148 */             sender.sendMessage("§aYou added§2 " + amount + "§a to the the enchant §2" + args[1]);
/* 149 */             return true;
/*     */           } 
/* 151 */           if (args[1].equalsIgnoreCase("earthquake")) {
/* 152 */             int amount = Integer.parseInt(args[2]);
/* 153 */             Utils.addToItem(p.getInventory().getItemInMainHand(), amount, args[1]);
/* 154 */             sender.sendMessage("§aYou added§2 " + amount + "§a to the the enchant §2" + args[1]);
/* 155 */             return true;
/*     */           } 
/* 157 */           if (args[1].equalsIgnoreCase("souls")) {
/* 158 */             int amount = Integer.parseInt(args[2]);
/* 159 */             Utils.addToItem(p.getInventory().getItemInMainHand(), amount, args[1]);
/* 160 */             sender.sendMessage("§aYou added§2 " + amount + "§a to the the enchant §2" + args[1]);
/* 161 */             return true;
/*     */           } 
/* 163 */           if (args[1].equalsIgnoreCase("charity")) {
/* 164 */             int amount = Integer.parseInt(args[2]);
/* 165 */             Utils.addToItem(p.getInventory().getItemInMainHand(), amount, args[1]);
/* 166 */             sender.sendMessage("§aYou added§2 " + amount + "§a to the the enchant §2" + args[1]);
/* 167 */             return true;
/*     */           } 
/* 169 */           if (args[1].equalsIgnoreCase("lucky")) {
/* 170 */             int amount = Integer.parseInt(args[2]);
/* 171 */             Utils.addToItem(p.getInventory().getItemInMainHand(), amount, args[1]);
/* 172 */             sender.sendMessage("§aYou added§2 " + amount + "§a to the the enchant §2" + args[1]);
/* 173 */             return true;
/*     */           } 
/*     */           
/* 176 */           if (args[1].equalsIgnoreCase("laser")) {
/* 177 */             int amount = Integer.parseInt(args[2]);
/*     */             
/* 179 */             Utils.addToItem(p.getInventory().getItemInMainHand(), amount, args[1]);
/* 180 */             sender.sendMessage("§aYou added§2 " + amount + "§a to the the enchant §2" + args[1]);
/* 181 */             return true;
/*     */           } 
/*     */           
/* 184 */           if (args[1].equalsIgnoreCase("efficiency")) {
/* 185 */             int amount = Integer.parseInt(args[2]);
/*     */             
/* 187 */             Utils.addToItem(p.getInventory().getItemInMainHand(), amount, args[1]);
/* 188 */             sender.sendMessage("§aYou added§2 " + amount + "§a to the the enchant §2" + args[1]);
/* 189 */             return true;
/*     */           } 
/* 191 */           if (args[1].equalsIgnoreCase("fortune")) {
/* 192 */             int amount = Integer.parseInt(args[2]);
/*     */             
/* 194 */             Utils.addToItem(p.getInventory().getItemInMainHand(), amount, args[1]);
/* 195 */             sender.sendMessage("§aYou added§2 " + amount + "§a to the the enchant §2" + args[1]);
/* 196 */             return true;
/*     */           } 
/* 198 */           sender.sendMessage("§cPlease enter a valid enchant!");
/* 199 */           sender.sendMessage("§cEnchants:");
/* 200 */           sender.sendMessage("§c * Speed");
/* 201 */           sender.sendMessage("§c * Haste");
/* 202 */           sender.sendMessage("§c * Lucky");
/* 203 */           sender.sendMessage("§c * Tokengreed");
/* 204 */           sender.sendMessage("§c * Moneygreed");
/* 205 */           sender.sendMessage("§c * Nuker");
/* 206 */           sender.sendMessage("§c * Laser");
/* 207 */           sender.sendMessage("§c * Shockwave");
/* 208 */           sender.sendMessage("§c * Earthquake");
/* 209 */           sender.sendMessage("§c * Souls");
/* 210 */           sender.sendMessage("§c * Charity");
/* 211 */           sender.sendMessage("§c * Fortune");
/* 212 */           sender.sendMessage("§c * Efficiency");
/* 213 */           sender.sendMessage("§c * Keyalls");
/* 214 */           sender.sendMessage("§c * Jumpboost");
/*     */         }
/* 216 */         else if (args[0].equalsIgnoreCase("setenchant")) {
/* 217 */           if (Integer.parseInt(args[2]) >= 1000) {
/*     */             try {
/* 219 */               PluginLogs.logMessage(String.valueOf(p.getName()) + " set the enchant " + args[1] + " to: " + args[2]);
/* 220 */             } catch (IOException e) {
/* 221 */               e.printStackTrace();
/*     */             } 
/*     */           }
/* 224 */           if (args[1].equalsIgnoreCase("speed")) {
/*     */             
/* 226 */             int amount = Integer.parseInt(args[2]);
/* 227 */             Utils.setToItem(p.getInventory().getItemInMainHand(), amount, args[1]);
/* 228 */             sender.sendMessage("§aYou set the enchant §a" + args[1] + "§a to §2" + amount);
/* 229 */             return true;
/*     */           } 
/* 231 */           if (args[1].equalsIgnoreCase("haste")) {
/* 232 */             int amount = Integer.parseInt(args[2]);
/* 233 */             Utils.setToItem(p.getInventory().getItemInMainHand(), amount, args[1]);
/* 234 */             sender.sendMessage("§aYou set the enchant §a" + args[1] + "§a to §2" + amount);
/* 235 */             return true;
/*     */           } 
/* 237 */           if (args[1].equalsIgnoreCase("nuker")) {
/* 238 */             int amount = Integer.parseInt(args[2]);
/* 239 */             Utils.setToItem(p.getInventory().getItemInMainHand(), amount, args[1]);
/* 240 */             sender.sendMessage("§aYou set the enchant §a" + args[1] + "§a to §2" + amount);
/* 241 */             return true;
/*     */           } 
/* 243 */           if (args[1].equalsIgnoreCase("tokengreed")) {
/* 244 */             int amount = Integer.parseInt(args[2]);
/* 245 */             Utils.setToItem(p.getInventory().getItemInMainHand(), amount, args[1]);
/* 246 */             sender.sendMessage("§aYou set the enchant §a" + args[1] + "§a to §2" + amount);
/* 247 */             return true;
/*     */           } 
/* 249 */           if (args[1].equalsIgnoreCase("moneygreed")) {
/* 250 */             int amount = Integer.parseInt(args[2]);
/* 251 */             Utils.setToItem(p.getInventory().getItemInMainHand(), amount, args[1]);
/* 252 */             sender.sendMessage("§aYou set the enchant §a" + args[1] + "§a to §2" + amount);
/* 253 */             return true;
/*     */           } 
/* 255 */           if (args[1].equalsIgnoreCase("shockwave")) {
/* 256 */             int amount = Integer.parseInt(args[2]);
/* 257 */             Utils.setToItem(p.getInventory().getItemInMainHand(), amount, args[1]);
/* 258 */             sender.sendMessage("§aYou set the enchant §a" + args[1] + "§a to §2" + amount);
/* 259 */             return true;
/*     */           } 
/* 261 */           if (args[1].equalsIgnoreCase("earthquake")) {
/* 262 */             int amount = Integer.parseInt(args[2]);
/* 263 */             Utils.setToItem(p.getInventory().getItemInMainHand(), amount, args[1]);
/* 264 */             sender.sendMessage("§aYou set the enchant §a" + args[1] + "§a to §2" + amount);
/* 265 */             return true;
/*     */           } 
/* 267 */           if (args[1].equalsIgnoreCase("souls")) {
/* 268 */             int amount = Integer.parseInt(args[2]);
/* 269 */             Utils.setToItem(p.getInventory().getItemInMainHand(), amount, args[1]);
/* 270 */             sender.sendMessage("§aYou set the enchant §a" + args[1] + "§a to §2" + amount);
/* 271 */             return true;
/*     */           } 
/* 273 */           if (args[1].equalsIgnoreCase("jumpboost")) {
/* 274 */             int amount = Integer.parseInt(args[2]);
/* 275 */             Utils.setToItem(p.getInventory().getItemInMainHand(), amount, args[1]);
/* 276 */             sender.sendMessage("§aYou set the enchant §a" + args[1] + "§a to §2" + amount);
/* 277 */             return true;
/*     */           } 
/* 279 */           if (args[1].equalsIgnoreCase("keyalls")) {
/* 280 */             int amount = Integer.parseInt(args[2]);
/* 281 */             Utils.setToItem(p.getInventory().getItemInMainHand(), amount, args[1]);
/* 282 */             sender.sendMessage("§aYou set the enchant §a" + args[1] + "§a to §2" + amount);
/* 283 */             return true;
/*     */           } 
/* 285 */           if (args[1].equalsIgnoreCase("charity")) {
/* 286 */             int amount = Integer.parseInt(args[2]);
/* 287 */             Utils.setToItem(p.getInventory().getItemInMainHand(), amount, args[1]);
/* 288 */             sender.sendMessage("§aYou set the enchant §a" + args[1] + "§a to §2" + amount);
/* 289 */             return true;
/*     */           } 
/* 291 */           if (args[1].equalsIgnoreCase("lucky")) {
/* 292 */             int amount = Integer.parseInt(args[2]);
/* 293 */             Utils.setToItem(p.getInventory().getItemInMainHand(), amount, args[1]);
/* 294 */             sender.sendMessage("§aYou set the enchant §a" + args[1] + "§a to §2" + amount);
/* 295 */             return true;
/*     */           } 
/*     */           
/* 298 */           if (args[1].equalsIgnoreCase("laser")) {
/* 299 */             int amount = Integer.parseInt(args[2]);
/*     */             
/* 301 */             Utils.setToItem(p.getInventory().getItemInMainHand(), amount, args[1]);
/* 302 */             sender.sendMessage("§aYou set the enchant §a" + args[1] + "§a to §2" + amount);
/* 303 */             return true;
/*     */           } 
/*     */           
/* 306 */           if (args[1].equalsIgnoreCase("efficiency")) {
/* 307 */             int amount = Integer.parseInt(args[2]);
/*     */             
/* 309 */             Utils.setToItem(p.getInventory().getItemInMainHand(), amount, args[1]);
/* 310 */             sender.sendMessage("§aYou set the enchant §a" + args[1] + "§a to §2" + amount);
/* 311 */             return true;
/*     */           } 
/* 313 */           if (args[1].equalsIgnoreCase("fortune")) {
/* 314 */             int amount = Integer.parseInt(args[2]);
/*     */             
/* 316 */             Utils.setToItem(p.getInventory().getItemInMainHand(), amount, args[1]);
/* 317 */             sender.sendMessage("§aYou set the enchant §a" + args[1] + "§a to §2" + amount);
/* 318 */             return true;
/*     */           } 
/* 320 */           sender.sendMessage("§cPlease enter a valid enchant!");
/* 321 */           sender.sendMessage("§cEnchants:");
/* 322 */           sender.sendMessage("§c * Speed - Max 5");
/* 323 */           sender.sendMessage("§c * Haste - Max 5");
/* 324 */           sender.sendMessage("§c * Lucky - Max 5000");
/* 325 */           sender.sendMessage("§c * Tokengreed - Max 1000");
/* 326 */           sender.sendMessage("§c * Moneygreed - Max 1000");
/* 327 */           sender.sendMessage("§c * Nuker - Max 5000");
/* 328 */           sender.sendMessage("§c * Laser - Max 5000");
/* 329 */           sender.sendMessage("§c * Shockwave - Max 5000");
/* 330 */           sender.sendMessage("§c * Earthquake - Max 5000");
/* 331 */           sender.sendMessage("§c * Souls - Max 5000");
/* 332 */           sender.sendMessage("§c * Charity - Max 5000");
/* 333 */           sender.sendMessage("§c * Fortune - Max 20000");
/* 334 */           sender.sendMessage("§c * Efficiency - Max 1000");
/* 335 */           sender.sendMessage("§c * Keyalls");
/* 336 */           sender.sendMessage("§c * Jumpboost");
/*     */         }
/* 338 */         else if (args[0].equalsIgnoreCase("removeenchant")) {
/* 339 */           if (Integer.parseInt(args[2]) >= 1000) {
/*     */             try {
/* 341 */               PluginLogs.logMessage(String.valueOf(p.getName()) + " has removed " + args[2] + " from the enchant: " + args[1]);
/* 342 */             } catch (IOException e) {
/* 343 */               e.printStackTrace();
/*     */             } 
/*     */           }
/* 346 */           if (args[1].equalsIgnoreCase("speed")) {
/*     */             
/* 348 */             int amount = Integer.parseInt(args[2]);
/* 349 */             Utils.removeFromItem(p.getInventory().getItemInMainHand(), amount, args[1]);
/* 350 */             sender.sendMessage("§aYou removed§2 " + amount + "§alevels from the the enchant §2" + args[1]);
/* 351 */             return true;
/*     */           } 
/* 353 */           if (args[1].equalsIgnoreCase("haste")) {
/* 354 */             int amount = Integer.parseInt(args[2]);
/* 355 */             Utils.removeFromItem(p.getInventory().getItemInMainHand(), amount, args[1]);
/* 356 */             sender.sendMessage("§aYou removed§2 " + amount + "§alevels from the the enchant §2" + args[1]);
/* 357 */             return true;
/*     */           } 
/* 359 */           if (args[1].equalsIgnoreCase("nuker")) {
/* 360 */             int amount = Integer.parseInt(args[2]);
/* 361 */             Utils.removeFromItem(p.getInventory().getItemInMainHand(), amount, args[1]);
/* 362 */             sender.sendMessage("§aYou removed§2 " + amount + "§alevels from the the enchant §2" + args[1]);
/* 363 */             return true;
/*     */           } 
/* 365 */           if (args[1].equalsIgnoreCase("keyalls")) {
/* 366 */             int amount = Integer.parseInt(args[2]);
/* 367 */             Utils.removeFromItem(p.getInventory().getItemInMainHand(), amount, args[1]);
/* 368 */             sender.sendMessage("§aYou removed§2 " + amount + "§alevels from the the enchant §2" + args[1]);
/* 369 */             return true;
/*     */           } 
/* 371 */           if (args[1].equalsIgnoreCase("jumpboost")) {
/* 372 */             int amount = Integer.parseInt(args[2]);
/* 373 */             Utils.removeFromItem(p.getInventory().getItemInMainHand(), amount, args[1]);
/* 374 */             sender.sendMessage("§aYou removed§2 " + amount + "§alevels from the the enchant §2" + args[1]);
/* 375 */             return true;
/*     */           } 
/* 377 */           if (args[1].equalsIgnoreCase("tokengreed")) {
/* 378 */             int amount = Integer.parseInt(args[2]);
/* 379 */             Utils.removeFromItem(p.getInventory().getItemInMainHand(), amount, args[1]);
/* 380 */             sender.sendMessage("§aYou removed§2 " + amount + "§alevels from the the enchant §2" + args[1]);
/* 381 */             return true;
/*     */           } 
/* 383 */           if (args[1].equalsIgnoreCase("moneygreed")) {
/* 384 */             int amount = Integer.parseInt(args[2]);
/* 385 */             Utils.removeFromItem(p.getInventory().getItemInMainHand(), amount, args[1]);
/* 386 */             sender.sendMessage("§aYou removed§2 " + amount + "§alevels from the the enchant §2" + args[1]);
/* 387 */             return true;
/*     */           } 
/* 389 */           if (args[1].equalsIgnoreCase("shockwave")) {
/* 390 */             int amount = Integer.parseInt(args[2]);
/* 391 */             Utils.removeFromItem(p.getInventory().getItemInMainHand(), amount, args[1]);
/* 392 */             sender.sendMessage("§aYou removed§2 " + amount + "§alevels from the the enchant §2" + args[1]);
/* 393 */             return true;
/*     */           } 
/* 395 */           if (args[1].equalsIgnoreCase("earthquake")) {
/* 396 */             int amount = Integer.parseInt(args[2]);
/* 397 */             Utils.removeFromItem(p.getInventory().getItemInMainHand(), amount, args[1]);
/* 398 */             sender.sendMessage("§aYou removed§2 " + amount + "§alevels from the the enchant §2" + args[1]);
/* 399 */             return true;
/*     */           } 
/* 401 */           if (args[1].equalsIgnoreCase("souls")) {
/* 402 */             int amount = Integer.parseInt(args[2]);
/* 403 */             Utils.removeFromItem(p.getInventory().getItemInMainHand(), amount, args[1]);
/* 404 */             sender.sendMessage("§aYou removed§2 " + amount + "§alevels from the the enchant §2" + args[1]);
/* 405 */             return true;
/*     */           } 
/* 407 */           if (args[1].equalsIgnoreCase("charity")) {
/* 408 */             int amount = Integer.parseInt(args[2]);
/* 409 */             Utils.removeFromItem(p.getInventory().getItemInMainHand(), amount, args[1]);
/* 410 */             sender.sendMessage("§aYou removed§2 " + amount + "§alevels from the the enchant §2" + args[1]);
/* 411 */             return true;
/*     */           } 
/* 413 */           if (args[1].equalsIgnoreCase("lucky")) {
/* 414 */             int amount = Integer.parseInt(args[2]);
/* 415 */             Utils.removeFromItem(p.getInventory().getItemInMainHand(), amount, args[1]);
/* 416 */             sender.sendMessage("§aYou removed§2 " + amount + "§alevels from the the enchant §2" + args[1]);
/* 417 */             return true;
/*     */           } 
/*     */           
/* 420 */           if (args[1].equalsIgnoreCase("laser")) {
/* 421 */             int amount = Integer.parseInt(args[2]);
/*     */             
/* 423 */             Utils.removeFromItem(p.getInventory().getItemInMainHand(), amount, args[1]);
/* 424 */             sender.sendMessage("§aYou removed§2 " + amount + "§alevels from the the enchant §2" + args[1]);
/* 425 */             return true;
/*     */           } 
/*     */           
/* 428 */           if (args[1].equalsIgnoreCase("efficiency")) {
/* 429 */             int amount = Integer.parseInt(args[2]);
/*     */             
/* 431 */             Utils.removeFromItem(p.getInventory().getItemInMainHand(), amount, args[1]);
/* 432 */             sender.sendMessage("§aYou removed§2 " + amount + "§alevels from the the enchant §2" + args[1]);
/* 433 */             return true;
/*     */           } 
/* 435 */           if (args[1].equalsIgnoreCase("fortune")) {
/* 436 */             int amount = Integer.parseInt(args[2]);
/*     */             
/* 438 */             Utils.removeFromItem(p.getInventory().getItemInMainHand(), amount, args[1]);
/* 439 */             sender.sendMessage("§aYou removed§2 " + amount + "§alevels from the the enchant §2" + args[1]);
/* 440 */             return true;
/*     */           } 
/* 442 */           sender.sendMessage("§cPlease enter a valid enchant!");
/* 443 */           sender.sendMessage("§cEnchants:");
/* 444 */           sender.sendMessage("§c * Speed - Max 5");
/* 445 */           sender.sendMessage("§c * Haste - Max 5");
/* 446 */           sender.sendMessage("§c * Lucky - Max 5000");
/* 447 */           sender.sendMessage("§c * Tokengreed - Max 1000");
/* 448 */           sender.sendMessage("§c * Moneygreed - Max 1000");
/* 449 */           sender.sendMessage("§c * Nuker - Max 5000");
/* 450 */           sender.sendMessage("§c * Laser - Max 5000");
/* 451 */           sender.sendMessage("§c * Shockwave - Max 5000");
/* 452 */           sender.sendMessage("§c * Earthquake - Max 5000");
/* 453 */           sender.sendMessage("§c * Souls - Max 5000");
/* 454 */           sender.sendMessage("§c * Charity - Max 5000");
/* 455 */           sender.sendMessage("§c * Fortune - Max 20000");
/* 456 */           sender.sendMessage("§c * Efficiency - Max 1000");
/* 457 */           sender.sendMessage("§c * Keyalls");
/* 458 */           sender.sendMessage("§c * Jumpboost");
/*     */         } 
/*     */       } 
/*     */     } else {
/*     */       
/* 463 */       sender.sendMessage("§cYou do not have permission to execute this command!");
/*     */     } 
/* 465 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   private void incorrectMessage(CommandSender sender) {
/* 470 */     sender.sendMessage("§6Incorrect Usage!");
/* 471 */     sender.sendMessage("§6/pe help <page>");
/*     */   }
/*     */ 
/*     */   
/*     */   private void helpPageOne(CommandSender sender) {
/* 476 */     sender.sendMessage("§6----------------------------");
/* 477 */     sender.sendMessage("§f----------------------------");
/* 478 */     sender.sendMessage("§6Prison Enchants Help Page: 1/3");
/* 479 */     sender.sendMessage("§6/pe reload - §eReloads the config file.");
/* 480 */     sender.sendMessage("§6/pe addenchant <enchant> <level> - §eAdds enchant levels to a pickaxe!");
/* 481 */     sender.sendMessage("§6/pe setenchant <enchant> <level> - §eSets enchant levels on a pickaxe!");
/* 482 */     sender.sendMessage("§6/pe removeenchant <enchant> <level> - §eRemoves enchant levels from a pickaxe!");
/* 483 */     sender.sendMessage("§6/pe logs <page> - §eSearch through plugin logs! (Do not rely on this feature)");
/* 484 */     sender.sendMessage("§6/pe uuidlookup <UUID> - §eFind a player name from UUID!");
/* 485 */     sender.sendMessage("§f----------------------------");
/* 486 */     sender.sendMessage("§6----------------------------");
/*     */   }
/*     */ 
/*     */   
/*     */   private void helpPageTwo(CommandSender sender) {
/* 491 */     sender.sendMessage("§6----------------------------");
/* 492 */     sender.sendMessage("§f----------------------------");
/* 493 */     sender.sendMessage("§6Prison Enchants Help Page: 2/3");
/* 494 */     sender.sendMessage("§6/enchantshop - §eOpens enchanter menu.");
/* 495 */     sender.sendMessage("§6/disenchanter - §eOpens disencanter menu.");
/* 496 */     sender.sendMessage("§6/enchanter - §eOpens custom enchant navigation menu.");
/* 497 */     sender.sendMessage("§f----------------------------");
/* 498 */     sender.sendMessage("§6----------------------------");
/*     */   }
/*     */ 
/*     */   
/*     */   private void helpPageThree(CommandSender sender) {
/* 503 */     sender.sendMessage("§6----------------------------");
/* 504 */     sender.sendMessage("§f----------------------------");
/* 505 */     sender.sendMessage("§6Prison Enchants Help Page: 2/3");
/* 506 */     sender.sendMessage("§6/tokens - §eShows the player their tokens.");
/* 507 */     sender.sendMessage("§6/tokens top - §eShows the top players tokens.");
/* 508 */     sender.sendMessage("§6/tokens pay <player> <amount> - §ePay a player your tokens.");
/* 509 */     sender.sendMessage("§6/tokens withdraw <amount> - §eWithdraw your tokens into a token note.");
/* 510 */     sender.sendMessage("§6/tokens view <player> - §eView someone elses tokens.");
/* 511 */     sender.sendMessage("§6/tokens give <player> <amount> - §eGive a player an amount of tokens.");
/* 512 */     sender.sendMessage("§6/tokens set <player> <amount> - §eSet a players tokens to a specific amount.");
/* 513 */     sender.sendMessage("§6/tokens remove <player> <amount> - §eRemove a certain amount of tokens from a player.");
/* 514 */     sender.sendMessage("§f----------------------------");
/* 515 */     sender.sendMessage("§6----------------------------");
/*     */   }
/*     */ }


/* Location:              C:\Users\17hautrivel\Desktop\PrisonEnchants.jar!\me\iLucaH\PrisonEnchants\ModifierCommand.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */