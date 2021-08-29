/*     */ package me.iLucaH.PrisonEnchants.Enchanter;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import me.iLucaH.PrisonEnchants.MainClass;
/*     */ import me.iLucaH.PrisonEnchants.PluginLogs;
/*     */ import me.iLucaH.PrisonEnchants.Tokens.Tokens;
/*     */ import me.iLucaH.PrisonEnchants.Utils;
/*     */ import org.bukkit.ChatColor;
/*     */ import org.bukkit.Instrument;
/*     */ import org.bukkit.Note;
/*     */ import org.bukkit.Sound;
/*     */ import org.bukkit.enchantments.Enchantment;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.event.EventHandler;
/*     */ import org.bukkit.event.Listener;
/*     */ import org.bukkit.event.inventory.InventoryClickEvent;
/*     */ import org.bukkit.event.inventory.InventoryType;
/*     */ import org.bukkit.inventory.Inventory;
/*     */ import org.bukkit.inventory.InventoryView;
/*     */ import org.bukkit.inventory.ItemStack;
/*     */ import org.bukkit.inventory.meta.ItemMeta;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class EnventoryListener
/*     */   implements Listener
/*     */ {
/*  30 */   private static MainClass plugin = MainClass.plugin;
/*     */   public static String enchantname;
/*     */   public static String disenchantname;
/*     */   
/*     */   @EventHandler
/*     */   public void setClick(InventoryClickEvent e) {
/*  36 */     Player p = (Player)e.getWhoClicked();
/*  37 */     List<String> enchantments = new ArrayList<>();
/*  38 */     for (String str : plugin.getEnchants().keySet()) {
/*  39 */       enchantments.add(str);
/*     */     }
/*  41 */     if (e.getView().getTitle() == "Enchantment Menu") {
/*     */       try {
/*  43 */         enchantname = e.getCurrentItem().getItemMeta().getDisplayName();
/*  44 */         for (String str : enchantments) {
/*  45 */           if (str.contains(enchantname)) {
/*  46 */             enchantname = str;
/*     */           }
/*     */         } 
/*  49 */         PurchaseMenu purchase = new PurchaseMenu();
/*  50 */         purchase.openMenu(enchantname, p);
/*  51 */       } catch (Exception excep) {
/*  52 */         excep.toString();
/*     */       } 
/*     */     }
/*  55 */     if (e.getView().getTitle() == "Disenchantment Menu") {
/*     */       try {
/*  57 */         disenchantname = e.getCurrentItem().getItemMeta().getDisplayName();
/*  58 */         for (String str : enchantments) {
/*  59 */           if (str.contains(disenchantname)) {
/*  60 */             disenchantname = str;
/*     */           }
/*     */         } 
/*  63 */         DisenchantMenu purchasedisenchant = new DisenchantMenu();
/*  64 */         purchasedisenchant.openMenu(disenchantname, p);
/*  65 */       } catch (Exception excep) {
/*  66 */         excep.toString();
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void buyClick(InventoryClickEvent e) {
/*  73 */     Player p = (Player)e.getWhoClicked();
/*  74 */     PurchaseMenu purchase = new PurchaseMenu();
/*  75 */     ItemStack item = e.getCurrentItem();
/*  76 */     Tokens tokens = new Tokens(p.getUniqueId());
/*  77 */     long balance = tokens.getTokens().longValue();
/*  78 */     Inventory inv = e.getInventory();
/*  79 */     List<String> menus = new ArrayList<>();
/*  80 */     for (String str : plugin.getEnchants().keySet()) {
/*  81 */       menus.add("Purchase " + 
/*  82 */           ChatColor.translateAlternateColorCodes('&', String.valueOf(plugin.getEnchantColor(str)) + "&l" + str));
/*     */     }
/*  84 */     if (menus.contains(e.getView().getTitle())) {
/*  85 */       String invname = e.getView().getTitle();
/*  86 */       InventoryView view = p.getOpenInventory();
/*  87 */       if (view.getBottomInventory().getType().equals(InventoryType.PLAYER)) {
/*  88 */         e.setCancelled(true);
/*     */       }
/*  90 */       if (item == null || !item.hasItemMeta()) {
/*     */         return;
/*     */       }
/*  93 */       String colorenchant = String.valueOf(e.getView().getTitle().split(" ")[1]);
/*  94 */       String enchant = String.valueOf(e.getView().getTitle().split(" ")[1]);
/*  95 */       enchant = enchant.substring(4);
/*  96 */       Long enchprice = Long.valueOf(plugin.getConfig().getLong("Enchants." + enchant + ".Enchantprice"));
/*  97 */       int maxlevel = plugin.getConfig().getInt("Enchants." + enchant + ".Maxlevel");
/*  98 */       Long fiveprice = Long.valueOf(enchprice.longValue() * 5L);
/*  99 */       Long tenprice = Long.valueOf(enchprice.longValue() * 10L);
/* 100 */       Long twentieprice = Long.valueOf(enchprice.longValue() * 25L);
/* 101 */       Long fiftyprice = Long.valueOf(enchprice.longValue() * 50L);
/* 102 */       Long hundoprice = Long.valueOf(enchprice.longValue() * 100L);
/* 103 */       Long twofiftyprice = Long.valueOf(enchprice.longValue() * 250L);
/* 104 */       Long fivehundoprice = Long.valueOf(enchprice.longValue() * 500L);
/* 105 */       Long centprice = Long.valueOf(enchprice.longValue() * 1000L);
/*     */       
/* 107 */       if (e.getView().getTitle().equals(invname)) {
/* 108 */         if (e.getSlot() == 9) {
/* 109 */           if (Utils.getEnchantLevel(p.getInventory().getItemInMainHand(), enchant) + 1 > maxlevel) {
/* 110 */             p.closeInventory();
/* 111 */             p.playNote(p.getLocation(), Instrument.BASS_GUITAR, Note.flat(1, Note.Tone.A));
/* 112 */             p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cThis will exceed the max level!"));
/*     */           }
/* 114 */           else if (balance >= enchprice.longValue()) {
/* 115 */             tokens.removeTokens(enchprice);
/* 116 */             tokens.savePlayerConfig();
/* 117 */             Utils.addToItem(p.getInventory().getItemInMainHand(), 1, enchant);
/* 118 */             p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 1.0F);
/* 119 */             p.sendMessage(ChatColor.translateAlternateColorCodes('&', 
/* 120 */                   "&c&l-" + plugin.getConfig().getString("Tokens.Symbol") + enchprice + 
/* 121 */                   " Tokens &7(+1 " + enchant + ")"));
/*     */           } else {
/* 123 */             p.closeInventory();
/* 124 */             p.playNote(p.getLocation(), Instrument.BASS_GUITAR, Note.flat(1, Note.Tone.A));
/* 125 */             p.sendMessage(
/* 126 */                 ChatColor.translateAlternateColorCodes('&', "&cYou don't have enough tokens!"));
/*     */           }
/*     */         
/* 129 */         } else if (e.getSlot() == 10) {
/* 130 */           if (Utils.getEnchantLevel(p.getInventory().getItemInMainHand(), enchant) + 5 > maxlevel) {
/* 131 */             p.closeInventory();
/* 132 */             p.playNote(p.getLocation(), Instrument.BASS_GUITAR, Note.flat(1, Note.Tone.A));
/* 133 */             p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cThis will exceed the max level!"));
/*     */           }
/* 135 */           else if (balance >= fiveprice.longValue()) {
/* 136 */             tokens.removeTokens(fiveprice);
/* 137 */             tokens.savePlayerConfig();
/* 138 */             Utils.addToItem(p.getInventory().getItemInMainHand(), 5, enchant);
/* 139 */             p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 1.0F);
/* 140 */             p.sendMessage(ChatColor.translateAlternateColorCodes('&', 
/* 141 */                   "&c&l-" + plugin.getConfig().getString("Tokens.Symbol") + fiveprice + 
/* 142 */                   " Tokens &7(+5 " + enchant + ")"));
/*     */           } else {
/* 144 */             p.closeInventory();
/* 145 */             p.playNote(p.getLocation(), Instrument.BASS_GUITAR, Note.flat(1, Note.Tone.A));
/* 146 */             p.sendMessage(
/* 147 */                 ChatColor.translateAlternateColorCodes('&', "&cYou don't have enough tokens!"));
/*     */           }
/*     */         
/* 150 */         } else if (e.getSlot() == 11) {
/* 151 */           if (Utils.getEnchantLevel(p.getInventory().getItemInMainHand(), enchant) + 10 > maxlevel) {
/* 152 */             p.closeInventory();
/* 153 */             p.playNote(p.getLocation(), Instrument.BASS_GUITAR, Note.flat(1, Note.Tone.A));
/* 154 */             p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cThis will exceed the max level!"));
/*     */           }
/* 156 */           else if (balance >= tenprice.longValue()) {
/* 157 */             tokens.removeTokens(tenprice);
/* 158 */             tokens.savePlayerConfig();
/* 159 */             Utils.addToItem(p.getInventory().getItemInMainHand(), 10, enchant);
/* 160 */             p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 1.0F);
/* 161 */             p.sendMessage(ChatColor.translateAlternateColorCodes('&', 
/* 162 */                   "&c&l-" + plugin.getConfig().getString("Tokens.Symbol") + tenprice + 
/* 163 */                   " Tokens &7(+10 " + enchant + ")"));
/*     */           } else {
/* 165 */             p.closeInventory();
/* 166 */             p.playNote(p.getLocation(), Instrument.BASS_GUITAR, Note.flat(1, Note.Tone.A));
/* 167 */             p.sendMessage(
/* 168 */                 ChatColor.translateAlternateColorCodes('&', "&cYou don't have enough tokens!"));
/*     */           }
/*     */         
/* 171 */         } else if (e.getSlot() == 12) {
/* 172 */           if (Utils.getEnchantLevel(p.getInventory().getItemInMainHand(), enchant) + 25 > maxlevel) {
/* 173 */             p.closeInventory();
/* 174 */             p.playNote(p.getLocation(), Instrument.BASS_GUITAR, Note.flat(1, Note.Tone.A));
/* 175 */             p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cThis will exceed the max level!"));
/*     */           }
/* 177 */           else if (balance >= twentieprice.longValue()) {
/* 178 */             tokens.removeTokens(twentieprice);
/* 179 */             tokens.savePlayerConfig();
/* 180 */             Utils.addToItem(p.getInventory().getItemInMainHand(), 25, enchant);
/* 181 */             p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 1.0F);
/* 182 */             p.sendMessage(ChatColor.translateAlternateColorCodes('&', 
/* 183 */                   "&c&l-" + plugin.getConfig().getString("Tokens.Symbol") + twentieprice + 
/* 184 */                   " Tokens &7(+25 " + enchant + ")"));
/*     */           } else {
/* 186 */             p.closeInventory();
/* 187 */             p.playNote(p.getLocation(), Instrument.BASS_GUITAR, Note.flat(1, Note.Tone.A));
/* 188 */             p.sendMessage(
/* 189 */                 ChatColor.translateAlternateColorCodes('&', "&cYou don't have enough tokens!"));
/*     */           }
/*     */         
/* 192 */         } else if (e.getSlot() == 13) {
/* 193 */           if (Utils.getEnchantLevel(p.getInventory().getItemInMainHand(), enchant) + 50 > maxlevel) {
/* 194 */             p.closeInventory();
/* 195 */             p.playNote(p.getLocation(), Instrument.BASS_GUITAR, Note.flat(1, Note.Tone.A));
/* 196 */             p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cThis will exceed the max level!"));
/*     */           }
/* 198 */           else if (balance >= fiftyprice.longValue()) {
/* 199 */             tokens.removeTokens(fiftyprice);
/* 200 */             tokens.savePlayerConfig();
/* 201 */             Utils.addToItem(p.getInventory().getItemInMainHand(), 50, enchant);
/* 202 */             p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 1.0F);
/* 203 */             p.sendMessage(ChatColor.translateAlternateColorCodes('&', 
/* 204 */                   "&c&l-" + plugin.getConfig().getString("Tokens.Symbol") + fiftyprice + 
/* 205 */                   " Tokens &7(+50 " + enchant + ")"));
/*     */           } else {
/* 207 */             p.closeInventory();
/* 208 */             p.playNote(p.getLocation(), Instrument.BASS_GUITAR, Note.flat(1, Note.Tone.A));
/* 209 */             p.sendMessage(
/* 210 */                 ChatColor.translateAlternateColorCodes('&', "&cYou don't have enough tokens!"));
/*     */           }
/*     */         
/* 213 */         } else if (e.getSlot() == 14) {
/* 214 */           if (Utils.getEnchantLevel(p.getInventory().getItemInMainHand(), enchant) + 100 > maxlevel) {
/* 215 */             p.closeInventory();
/* 216 */             p.playNote(p.getLocation(), Instrument.BASS_GUITAR, Note.flat(1, Note.Tone.A));
/* 217 */             p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cThis will exceed the max level!"));
/*     */           }
/* 219 */           else if (balance >= hundoprice.longValue()) {
/* 220 */             tokens.removeTokens(hundoprice);
/* 221 */             tokens.savePlayerConfig();
/* 222 */             Utils.addToItem(p.getInventory().getItemInMainHand(), 100, enchant);
/* 223 */             p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 1.0F);
/* 224 */             p.sendMessage(ChatColor.translateAlternateColorCodes('&', 
/* 225 */                   "&c&l-" + plugin.getConfig().getString("Tokens.Symbol") + hundoprice + 
/* 226 */                   " Tokens &7(+100 " + enchant + ")"));
/*     */           } else {
/* 228 */             p.closeInventory();
/* 229 */             p.playNote(p.getLocation(), Instrument.BASS_GUITAR, Note.flat(1, Note.Tone.A));
/* 230 */             p.sendMessage(
/* 231 */                 ChatColor.translateAlternateColorCodes('&', "&cYou don't have enough tokens!"));
/*     */           }
/*     */         
/* 234 */         } else if (e.getSlot() == 15) {
/* 235 */           if (Utils.getEnchantLevel(p.getInventory().getItemInMainHand(), enchant) + 250 > maxlevel) {
/* 236 */             p.closeInventory();
/* 237 */             p.playNote(p.getLocation(), Instrument.BASS_GUITAR, Note.flat(1, Note.Tone.A));
/* 238 */             p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cThis will exceed the max level!"));
/*     */           }
/* 240 */           else if (balance >= twofiftyprice.longValue()) {
/* 241 */             tokens.removeTokens(twofiftyprice);
/* 242 */             tokens.savePlayerConfig();
/* 243 */             Utils.addToItem(p.getInventory().getItemInMainHand(), 250, enchant);
/* 244 */             p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 1.0F);
/* 245 */             p.sendMessage(ChatColor.translateAlternateColorCodes('&', 
/* 246 */                   "&c&l-" + plugin.getConfig().getString("Tokens.Symbol") + twofiftyprice + 
/* 247 */                   " Tokens &7(+250 " + enchant + ")"));
/*     */           } else {
/* 249 */             p.closeInventory();
/* 250 */             p.playNote(p.getLocation(), Instrument.BASS_GUITAR, Note.flat(1, Note.Tone.A));
/* 251 */             p.sendMessage(
/* 252 */                 ChatColor.translateAlternateColorCodes('&', "&cYou don't have enough tokens!"));
/*     */           }
/*     */         
/* 255 */         } else if (e.getSlot() == 16) {
/* 256 */           if (Utils.getEnchantLevel(p.getInventory().getItemInMainHand(), enchant) + 500 > maxlevel) {
/* 257 */             p.closeInventory();
/* 258 */             p.playNote(p.getLocation(), Instrument.BASS_GUITAR, Note.flat(1, Note.Tone.A));
/* 259 */             p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cThis will exceed the max level!"));
/*     */           }
/* 261 */           else if (balance >= fivehundoprice.longValue()) {
/* 262 */             tokens.removeTokens(fivehundoprice);
/* 263 */             tokens.savePlayerConfig();
/* 264 */             Utils.addToItem(p.getInventory().getItemInMainHand(), 500, enchant);
/* 265 */             p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 1.0F);
/* 266 */             p.sendMessage(ChatColor.translateAlternateColorCodes('&', 
/* 267 */                   "&c&l-" + plugin.getConfig().getString("Tokens.Symbol") + fivehundoprice + 
/* 268 */                   " Tokens &7(+500 " + enchant + ")"));
/*     */             try {
/* 270 */               PluginLogs.logMessage(p + " added 500 levels to " + enchant + "!");
/* 271 */             } catch (IOException exeption) {
/* 272 */               exeption.printStackTrace();
/*     */             } 
/*     */           } else {
/* 275 */             p.closeInventory();
/* 276 */             p.playNote(p.getLocation(), Instrument.BASS_GUITAR, Note.flat(1, Note.Tone.A));
/* 277 */             p.sendMessage(
/* 278 */                 ChatColor.translateAlternateColorCodes('&', "&cYou don't have enough tokens!"));
/*     */           }
/*     */         
/* 281 */         } else if (e.getSlot() == 17) {
/* 282 */           if (Utils.getEnchantLevel(p.getInventory().getItemInMainHand(), enchant) + 1000 > maxlevel) {
/* 283 */             p.closeInventory();
/* 284 */             p.playNote(p.getLocation(), Instrument.BASS_GUITAR, Note.flat(1, Note.Tone.A));
/* 285 */             p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cThis will exceed the max level!"));
/*     */           }
/* 287 */           else if (balance >= centprice.longValue()) {
/* 288 */             tokens.removeTokens(centprice);
/* 289 */             tokens.savePlayerConfig();
/* 290 */             Utils.addToItem(p.getInventory().getItemInMainHand(), 1000, enchant);
/* 291 */             p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 1.0F);
/* 292 */             p.sendMessage(ChatColor.translateAlternateColorCodes('&', 
/* 293 */                   "&c&l-" + plugin.getConfig().getString("Tokens.Symbol") + centprice + 
/* 294 */                   " Tokens &7(+1000 " + enchant + ")"));
/*     */             try {
/* 296 */               PluginLogs.logMessage(p + " added 1000 levels to " + enchant + "!");
/* 297 */             } catch (IOException exeption) {
/* 298 */               exeption.printStackTrace();
/*     */             } 
/*     */           } else {
/* 301 */             p.closeInventory();
/* 302 */             p.playNote(p.getLocation(), Instrument.BASS_GUITAR, Note.flat(1, Note.Tone.A));
/* 303 */             p.sendMessage(
/* 304 */                 ChatColor.translateAlternateColorCodes('&', "&cYou don't have enough tokens!"));
/*     */           } 
/*     */         } 
/*     */         
/* 308 */         purchase.refreshMenu(colorenchant, p, inv);
/* 309 */         p.updateInventory();
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   @EventHandler
/*     */   public void disenchantClick(InventoryClickEvent e) {
/* 317 */     Player p = (Player)e.getWhoClicked();
/* 318 */     PurchaseMenu purchase = new PurchaseMenu();
/* 319 */     ItemStack item = e.getCurrentItem();
/* 320 */     Tokens tokens = new Tokens(p.getUniqueId());
/* 321 */     long balance = tokens.getTokens().longValue();
/* 322 */     Inventory inv = e.getInventory();
/* 323 */     List<String> menus = new ArrayList<>();
/* 324 */     for (String str : plugin.getEnchants().keySet()) {
/* 325 */       menus.add("Disenchant " + 
/* 326 */           ChatColor.translateAlternateColorCodes('&', String.valueOf(plugin.getEnchantColor(str)) + "&l" + str));
/*     */     }
/* 328 */     if (menus.contains(e.getView().getTitle())) {
/* 329 */       String invname = e.getView().getTitle();
/* 330 */       DisenchantMenu menu = new DisenchantMenu();
/* 331 */       InventoryView view = p.getOpenInventory();
/* 332 */       if (view.getBottomInventory().getType().equals(InventoryType.PLAYER)) {
/* 333 */         e.setCancelled(true);
/*     */       }
/* 335 */       if (item == null || !item.hasItemMeta()) {
/*     */         return;
/*     */       }
/* 338 */       String colorenchant = String.valueOf(e.getView().getTitle().split(" ")[1]);
/* 339 */       String enchant = String.valueOf(e.getView().getTitle().split(" ")[1]);
/* 340 */       enchant = enchant.substring(4);
/* 341 */       int enchlevel = 0;
/* 342 */       if (p.getInventory().getItemInMainHand().hasItemMeta() && 
/* 343 */         p.getInventory().getItemInMainHand().getItemMeta().hasLore()) {
/* 344 */         for (String str : p.getInventory().getItemInMainHand().getItemMeta().getLore()) {
/* 345 */           if (str.contains(enchant)) {
/* 346 */             enchlevel = Integer.valueOf(str.split(" ")[1]).intValue();
/*     */           }
/*     */         } 
/*     */       }
/*     */ 
/*     */       
/*     */       try {
/* 353 */         Long enchprice = Long.valueOf(plugin.getConfig().getLong("Enchants." + enchant + ".Enchantprice"));
/*     */ 
/*     */         
/* 356 */         Long allprice = Long.valueOf(Math.round((enchlevel * enchprice.longValue()) * 0.15D));
/* 357 */         Long oneprice = Long.valueOf(Math.round(enchprice.longValue() * 0.15D));
/*     */         
/* 359 */         if (e.getView().getTitle().equals(invname)) {
/* 360 */           if (e.getSlot() == 2) {
/* 361 */             if (enchlevel >= 1) {
/* 362 */               if (enchlevel == 1) {
/* 363 */                 tokens.addTokens(enchprice);
/* 364 */                 tokens.savePlayerConfig();
/* 365 */                 ItemStack mh = p.getInventory().getItemInMainHand();
/* 366 */                 ItemMeta meta = mh.getItemMeta();
/* 367 */                 List<String> lore = meta.hasLore() ? meta.getLore() : new ArrayList<>();
/* 368 */                 lore.remove(String.valueOf(String.valueOf(plugin.getEnchantColor(enchant))) + enchant + " " + 
/* 369 */                     Integer.toString(enchlevel));
/* 370 */                 meta.setLore(lore);
/* 371 */                 mh.setItemMeta(meta);
/* 372 */                 if (enchant.equals("Fortune")) {
/* 373 */                   p.getInventory().getItemInMainHand()
/* 374 */                     .removeEnchantment(Enchantment.LOOT_BONUS_BLOCKS);
/* 375 */                 } else if (enchant.equals("Efficiency")) {
/* 376 */                   p.getInventory().getItemInMainHand().removeEnchantment(Enchantment.DIG_SPEED);
/*     */                 } 
/* 378 */                 p.playSound(p.getLocation(), Sound.BLOCK_WOOD_BREAK, 1.0F, 1.0F);
/* 379 */                 p.sendMessage(ChatColor.translateAlternateColorCodes('&', 
/* 380 */                       "&a&l+" + plugin.getConfig().getString("Tokens.Symbol") + allprice + 
/* 381 */                       " Tokens &7(Disenchanter)"));
/*     */               } else {
/* 383 */                 tokens.addTokens(enchprice);
/* 384 */                 tokens.savePlayerConfig();
/* 385 */                 Utils.removeFromItem(p.getInventory().getItemInMainHand(), 1, enchant);
/* 386 */                 p.playSound(p.getLocation(), Sound.BLOCK_WOOD_BREAK, 1.0F, 1.0F);
/* 387 */                 p.sendMessage(ChatColor.translateAlternateColorCodes('&', 
/* 388 */                       "&a&l+" + plugin.getConfig().getString("Tokens.Symbol") + enchprice + 
/* 389 */                       " Tokens &7(Disenchanter)"));
/*     */               } 
/*     */             } else {
/* 392 */               p.closeInventory();
/* 393 */               p.playNote(p.getLocation(), Instrument.BASS_GUITAR, Note.flat(1, Note.Tone.A));
/* 394 */               p.sendMessage(ChatColor.translateAlternateColorCodes('&', 
/* 395 */                     "&cYou don't have enough levels to disenchant!"));
/*     */             } 
/* 397 */           } else if (e.getSlot() == 6) {
/* 398 */             if (enchlevel >= 1) {
/* 399 */               tokens.addTokens(allprice);
/* 400 */               tokens.savePlayerConfig();
/* 401 */               ItemStack mh = p.getInventory().getItemInMainHand();
/* 402 */               ItemMeta meta = mh.getItemMeta();
/* 403 */               List<String> lore = meta.hasLore() ? meta.getLore() : new ArrayList<>();
/* 404 */               lore.remove(String.valueOf(String.valueOf(plugin.getEnchantColor(enchant))) + enchant + " " + 
/* 405 */                   Integer.toString(enchlevel));
/* 406 */               meta.setLore(lore);
/* 407 */               mh.setItemMeta(meta);
/* 408 */               if (enchant.equals("Fortune")) {
/* 409 */                 p.getInventory().getItemInMainHand().removeEnchantment(Enchantment.LOOT_BONUS_BLOCKS);
/* 410 */               } else if (enchant.equals("Efficiency")) {
/* 411 */                 p.getInventory().getItemInMainHand().removeEnchantment(Enchantment.DIG_SPEED);
/*     */               } 
/* 413 */               p.playSound(p.getLocation(), Sound.BLOCK_WOOD_BREAK, 1.0F, 1.0F);
/* 414 */               p.sendMessage(ChatColor.translateAlternateColorCodes('&', 
/* 415 */                     "&a&l+" + plugin.getConfig().getString("Tokens.Symbol") + allprice + 
/* 416 */                     " Tokens &7(Disenchanter)"));
/*     */             } else {
/* 418 */               p.closeInventory();
/* 419 */               p.playNote(p.getLocation(), Instrument.BASS_GUITAR, Note.flat(1, Note.Tone.A));
/* 420 */               p.sendMessage(ChatColor.translateAlternateColorCodes('&', 
/* 421 */                     "&cYou don't have enough levels to disenchant!"));
/*     */             } 
/*     */           } 
/* 424 */           menu.refreshMenu(enchant, p, inv);
/* 425 */           p.updateInventory();
/*     */         } 
/* 427 */       } catch (Exception exception) {
/* 428 */         exception.printStackTrace();
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void menuRedirect(InventoryClickEvent e) {
/* 435 */     Player p = (Player)e.getWhoClicked();
/*     */     
/* 437 */     if (e.getView().getTitle() == "Enchant Menu") {
/* 438 */       if (e.getSlot() == 11) {
/* 439 */         p.performCommand("enchshop");
/* 440 */       } else if (e.getSlot() == 15) {
/* 441 */         p.performCommand("disenchanter");
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   @EventHandler
/*     */   public void cancelClick(InventoryClickEvent event) {
/* 449 */     Inventory open = event.getClickedInventory();
/* 450 */     ItemStack item = event.getCurrentItem();
/* 451 */     if (open == null) {
/*     */       return;
/*     */     }
/* 454 */     if (event.getView().getTitle().contains("Enchantment Menu") || 
/* 455 */       event.getView().getTitle().contains("Enchantment Menu")) {
/* 456 */       event.setCancelled(true);
/* 457 */       if (item == null || !item.hasItemMeta()) {
/*     */         return;
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public String getEnchantName() {
/* 464 */     return enchantname;
/*     */   }
/*     */   
/*     */   public String getDisenchantName() {
/* 468 */     return disenchantname;
/*     */   }
/*     */ }


/* Location:              C:\Users\17hautrivel\Desktop\PrisonEnchants.jar!\me\iLucaH\PrisonEnchants\Enchanter\EnventoryListener.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */