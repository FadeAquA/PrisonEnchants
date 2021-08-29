/*     */ package me.iLucaH.PrisonEnchants;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.text.DecimalFormat;
/*     */ import java.text.NumberFormat;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.Comparator;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.UUID;
/*     */ import java.util.function.Supplier;
/*     */ import java.util.stream.Collectors;
/*     */ import me.iLucaH.PrisonEnchants.Tokens.Tokens;
/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.ChatColor;
/*     */ import org.bukkit.Material;
/*     */ import org.bukkit.OfflinePlayer;
/*     */ import org.bukkit.Sound;
/*     */ import org.bukkit.enchantments.Enchantment;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.inventory.ItemFlag;
/*     */ import org.bukkit.inventory.ItemStack;
/*     */ import org.bukkit.inventory.PlayerInventory;
/*     */ import org.bukkit.inventory.meta.ItemMeta;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Utils
/*     */ {
/*  33 */   private static MainClass plugin = MainClass.plugin;
/*     */   
/*  35 */   public static Map<OfflinePlayer, Long> tokenlist = new HashMap<>();
/*     */ 
/*     */   
/*     */   public static boolean hasLore(Player p) {
/*  39 */     Boolean haslore = Boolean.valueOf(true);
/*  40 */     if (p.getInventory().getItemInMainHand().hasItemMeta()) {
/*  41 */       if (p.getInventory().getItemInMainHand().getItemMeta().hasLore()) {
/*  42 */         haslore = Boolean.valueOf(true);
/*     */       }
/*     */     } else {
/*  45 */       haslore = Boolean.valueOf(false);
/*     */     } 
/*  47 */     return haslore.booleanValue();
/*     */   }
/*     */   
/*     */   public static int getSpeed(Player p) {
/*  51 */     int speedlevel = 0;
/*  52 */     for (String str : p.getInventory().getItemInMainHand().getItemMeta().getLore()) {
/*  53 */       if (str.contains("Speed")) {
/*  54 */         speedlevel = Integer.valueOf(str.split(" ")[1]).intValue();
/*     */       }
/*     */     } 
/*  57 */     return speedlevel;
/*     */   }
/*     */   
/*     */   public static int getEnchantLevel(ItemStack item, String enchant) {
/*  61 */     int enchantlevel = 0;
/*  62 */     if (item.hasItemMeta() && 
/*  63 */       item.getItemMeta().hasLore()) {
/*  64 */       for (String str : item.getItemMeta().getLore()) {
/*  65 */         if (str.contains(enchant)) {
/*  66 */           enchantlevel = Integer.valueOf(str.split(" ")[1]).intValue();
/*     */         }
/*     */       } 
/*     */     }
/*     */     
/*  71 */     return enchantlevel;
/*     */   }
/*     */   
/*     */   public static int getHaste(Player p) {
/*  75 */     int hastelevel = 0;
/*  76 */     for (String str : p.getInventory().getItemInMainHand().getItemMeta().getLore()) {
/*  77 */       if (str.contains("Haste")) {
/*  78 */         hastelevel = Integer.valueOf(str.split(" ")[1]).intValue();
/*     */       }
/*     */     } 
/*  81 */     return hastelevel;
/*     */   }
/*     */   
/*     */   public static int getNuker(Player p) {
/*  85 */     int nukerlevel = 0;
/*  86 */     for (String str : p.getInventory().getItemInMainHand().getItemMeta().getLore()) {
/*  87 */       if (str.contains("Nuker")) {
/*  88 */         nukerlevel = Integer.valueOf(str.split(" ")[1]).intValue();
/*     */       }
/*     */     } 
/*  91 */     return nukerlevel;
/*     */   }
/*     */   
/*     */   public static int getTGreed(Player p) {
/*  95 */     int tgreedlevel = 0;
/*  96 */     for (String str : p.getInventory().getItemInMainHand().getItemMeta().getLore()) {
/*  97 */       if (str.contains("TokenGreed")) {
/*  98 */         tgreedlevel = Integer.valueOf(str.split(" ")[1]).intValue();
/*     */       }
/*     */     } 
/* 101 */     return tgreedlevel;
/*     */   }
/*     */   
/*     */   public static int getMGreed(Player p) {
/* 105 */     int mgreedlevel = 0;
/* 106 */     for (String str : p.getInventory().getItemInMainHand().getItemMeta().getLore()) {
/* 107 */       if (str.contains("MoneyGreed")) {
/* 108 */         mgreedlevel = Integer.valueOf(str.split(" ")[1]).intValue();
/*     */       }
/*     */     } 
/* 111 */     return mgreedlevel;
/*     */   }
/*     */   
/*     */   public static int getShockwave(Player p) {
/* 115 */     int shockwavelevel = 0;
/* 116 */     for (String str : p.getInventory().getItemInMainHand().getItemMeta().getLore()) {
/* 117 */       if (str.contains("Shockwave")) {
/* 118 */         shockwavelevel = Integer.valueOf(str.split(" ")[1]).intValue();
/*     */       }
/*     */     } 
/* 121 */     return shockwavelevel;
/*     */   }
/*     */   
/*     */   public static int getEarthquake(Player p) {
/* 125 */     int earthquakelevel = 0;
/* 126 */     for (String str : p.getInventory().getItemInMainHand().getItemMeta().getLore()) {
/* 127 */       if (str.contains("Earthquake")) {
/* 128 */         earthquakelevel = Integer.valueOf(str.split(" ")[1]).intValue();
/*     */       }
/*     */     } 
/* 131 */     return earthquakelevel;
/*     */   }
/*     */   
/*     */   public static int getSouls(Player p) {
/* 135 */     int soulslevel = 0;
/* 136 */     for (String str : p.getInventory().getItemInMainHand().getItemMeta().getLore()) {
/* 137 */       if (str.contains("Souls")) {
/* 138 */         soulslevel = Integer.valueOf(str.split(" ")[1]).intValue();
/*     */       }
/*     */     } 
/* 141 */     return soulslevel;
/*     */   }
/*     */   
/*     */   public static int getCharity(Player p) {
/* 145 */     int charitylevel = 0;
/* 146 */     for (String str : p.getInventory().getItemInMainHand().getItemMeta().getLore()) {
/* 147 */       if (str.contains("Charity")) {
/* 148 */         charitylevel = Integer.valueOf(str.split(" ")[1]).intValue();
/*     */       }
/*     */     } 
/* 151 */     return charitylevel;
/*     */   }
/*     */   
/*     */   public static int getLaser(Player p) {
/* 155 */     int laserlevel = 0;
/* 156 */     for (String str : p.getInventory().getItemInMainHand().getItemMeta().getLore()) {
/* 157 */       if (str.contains("Laser")) {
/* 158 */         laserlevel = Integer.valueOf(str.split(" ")[1]).intValue();
/*     */       }
/*     */     } 
/* 161 */     return laserlevel;
/*     */   }
/*     */   
/*     */   public static int getLucky(Player p) {
/* 165 */     int luckylevel = 0;
/* 166 */     for (String str : p.getInventory().getItemInMainHand().getItemMeta().getLore()) {
/* 167 */       if (str.contains("Lucky")) {
/* 168 */         luckylevel = Integer.valueOf(str.split(" ")[1]).intValue();
/*     */       }
/*     */     } 
/* 171 */     return luckylevel;
/*     */   }
/*     */   
/*     */   public static int getEfficiency(Player p) {
/* 175 */     int efficiencylevel = 0;
/* 176 */     for (String str : p.getInventory().getItemInMainHand().getItemMeta().getLore()) {
/* 177 */       if (str.contains("Efficiency")) {
/* 178 */         efficiencylevel = Integer.valueOf(str.split(" ")[1]).intValue();
/*     */       }
/*     */     } 
/* 181 */     return efficiencylevel;
/*     */   }
/*     */   
/*     */   public static int getFortune(Player p) {
/* 185 */     int fortunelevel = 1;
/* 186 */     if (p.getInventory().getItemInMainHand().getItemMeta().hasEnchant(Enchantment.LOOT_BONUS_BLOCKS)) {
/* 187 */       fortunelevel = p.getInventory().getItemInMainHand().getItemMeta().getEnchantLevel(Enchantment.LOOT_BONUS_BLOCKS);
/*     */     }
/* 189 */     return fortunelevel;
/*     */   }
/*     */   
/*     */   public static List<String> getTokenUUID() {
/* 193 */     List<String> top = new ArrayList<>();
/* 194 */     File filename = new File("plugins/PrisonEnchants/Tokens");
/*     */     
/* 196 */     String[] filelist = filename.list(); byte b; int i; String[] arrayOfString1;
/* 197 */     for (i = (arrayOfString1 = filelist).length, b = 0; b < i; ) { String file = arrayOfString1[b];
/* 198 */       top.add(file); b++; }
/*     */     
/* 200 */     return top;
/*     */   }
/*     */   
/*     */   public static List<String> getTopTokens() {
/* 204 */     List<String> top = new ArrayList<>();
/* 205 */     File filename = new File("plugins/PrisonEnchants/Tokens");
/*     */     
/* 207 */     String[] filelist = filename.list(); byte b; int j; String[] arrayOfString1;
/* 208 */     for (j = (arrayOfString1 = filelist).length, b = 0; b < j; ) { String file = arrayOfString1[b];
/* 209 */       file = file.substring(0, file.length() - 4);
/* 210 */       OfflinePlayer player = Bukkit.getOfflinePlayer(UUID.fromString(file));
/* 211 */       Tokens tokens = new Tokens(UUID.fromString(file));
/* 212 */       Long balance = tokens.getTokens();
/* 213 */       addToTokenMap(player, balance); b++; }
/*     */     
/* 215 */     Map<OfflinePlayer, Long> sortedMap = (Map<OfflinePlayer, Long>)tokenlist.entrySet().stream()
/* 216 */       .sorted(Comparator.comparingDouble(e -> -((Long)e.getValue()).longValue()))
/* 217 */       .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> {
/*     */             throw new AssertionError();
/* 219 */           }java.util.LinkedHashMap::new));
/* 220 */     int i = 0;
/* 221 */     for (Map.Entry<OfflinePlayer, Long> set : sortedMap.entrySet()) {
/* 222 */       i++;
/* 223 */       top.add(getDominantTokenColor() + " * " + getSecondaryTokenColor() + "#" + i + " " + getDominantTokenColor() + (
/* 224 */           (OfflinePlayer)set.getKey()).getName() + ": " + "§f" + plugin.getConfig().getString("Tokens.Symbol") + set.getValue());
/* 225 */       if (i == 10) {
/*     */         break;
/*     */       }
/*     */     } 
/* 229 */     return top;
/*     */   }
/*     */   
/*     */   public static String getTopTokens(int index) {
/* 233 */     int amount = index - 1;
/* 234 */     List<String> top = getTopTokens();
/* 235 */     top.add(getDominantTokenColor() + " * " + getSecondaryTokenColor() + "#" + index + " " + getDominantTokenColor() + "Empty");
/* 236 */     top.add(getDominantTokenColor() + " * " + getSecondaryTokenColor() + "#" + index + " " + getDominantTokenColor() + "Empty");
/* 237 */     top.add(getDominantTokenColor() + " * " + getSecondaryTokenColor() + "#" + index + " " + getDominantTokenColor() + "Empty");
/* 238 */     top.add(getDominantTokenColor() + " * " + getSecondaryTokenColor() + "#" + index + " " + getDominantTokenColor() + "Empty");
/* 239 */     top.add(getDominantTokenColor() + " * " + getSecondaryTokenColor() + "#" + index + " " + getDominantTokenColor() + "Empty");
/* 240 */     top.add(getDominantTokenColor() + " * " + getSecondaryTokenColor() + "#" + index + " " + getDominantTokenColor() + "Empty");
/* 241 */     top.add(getDominantTokenColor() + " * " + getSecondaryTokenColor() + "#" + index + " " + getDominantTokenColor() + "Empty");
/* 242 */     top.add(getDominantTokenColor() + " * " + getSecondaryTokenColor() + "#" + index + " " + getDominantTokenColor() + "Empty");
/* 243 */     top.add(getDominantTokenColor() + " * " + getSecondaryTokenColor() + "#" + index + " " + getDominantTokenColor() + "Empty");
/* 244 */     top.add(getDominantTokenColor() + " * " + getSecondaryTokenColor() + "#" + index + " " + getDominantTokenColor() + "Empty");
/* 245 */     return top.get(amount);
/*     */   }
/*     */   
/*     */   public static void clearTokenTop() {
/* 249 */     tokenlist.clear();
/*     */   }
/*     */   
/*     */   public static Long getValueFromTokenMap(OfflinePlayer key) {
/* 253 */     return tokenlist.get(key);
/*     */   }
/*     */   
/*     */   public static void addToTokenMap(OfflinePlayer name, Long bal) {
/* 257 */     tokenlist.put(name, bal);
/*     */   }
/*     */ 
/*     */   
/*     */   public static ItemStack addToItem(ItemStack item, int level, String enchant) {
/* 262 */     enchant = String.valueOf(enchant.substring(0, 1).toUpperCase()) + enchant.substring(1).toLowerCase();
/*     */     
/* 264 */     ItemMeta meta = item.getItemMeta();
/* 265 */     List<String> lore = meta.hasLore() ? meta.getLore() : new ArrayList<>();
/*     */     
/* 267 */     int lvl = 0;
/* 268 */     for (String str : lore) {
/* 269 */       if (str.contains(enchant)) {
/* 270 */         lvl = Integer.valueOf(str.split(" ")[1]).intValue();
/*     */       }
/*     */     } 
/*     */     
/* 274 */     if (lvl > 0) {
/* 275 */       lore.remove(String.valueOf(String.valueOf(plugin.getEnchantColor(enchant))) + enchant + " " + Integer.toString(lvl));
/*     */     }
/*     */     
/* 278 */     lore.add(String.valueOf(String.valueOf(plugin.getEnchantColor(enchant))) + enchant + " " + Integer.toString(lvl + level));
/* 279 */     Collections.sort(lore);
/* 280 */     meta.setLore(lore);
/* 281 */     meta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
/* 282 */     item.setItemMeta(meta);
/*     */     
/* 284 */     if (enchant.equalsIgnoreCase("Fortune")) {
/* 285 */       item.addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 
/* 286 */           item.getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS) + level);
/* 287 */     } else if (enchant.equalsIgnoreCase("Efficiency")) {
/* 288 */       item.addUnsafeEnchantment(Enchantment.DIG_SPEED, item.getEnchantmentLevel(Enchantment.DIG_SPEED) + level);
/*     */     } 
/*     */     
/* 291 */     return item;
/*     */   }
/*     */ 
/*     */   
/*     */   public static ItemStack removeFromItem(ItemStack item, int level, String enchant) {
/* 296 */     enchant = String.valueOf(enchant.substring(0, 1).toUpperCase()) + enchant.substring(1).toLowerCase();
/*     */     
/* 298 */     ItemMeta meta = item.getItemMeta();
/* 299 */     List<String> lore = meta.hasLore() ? meta.getLore() : new ArrayList<>();
/*     */     
/* 301 */     int lvl = 0;
/* 302 */     for (String str : lore) {
/* 303 */       if (str.contains(enchant)) {
/* 304 */         lvl = Integer.valueOf(str.split(" ")[1]).intValue();
/*     */       }
/*     */     } 
/*     */     
/* 308 */     if (lvl > 0) {
/* 309 */       lore.remove(String.valueOf(String.valueOf(plugin.getEnchantColor(enchant))) + enchant + " " + Integer.toString(lvl));
/*     */     }
/* 311 */     lore.add(String.valueOf(String.valueOf(plugin.getEnchantColor(enchant))) + enchant + " " + Integer.toString(lvl - level));
/* 312 */     if (level >= lvl) {
/* 313 */       lore.remove(String.valueOf(String.valueOf(plugin.getEnchantColor(enchant))) + enchant + " " + Integer.toString(lvl));
/*     */     }
/* 315 */     Collections.sort(lore);
/* 316 */     meta.setLore(lore);
/* 317 */     item.setItemMeta(meta);
/*     */     
/* 319 */     if (enchant.equalsIgnoreCase("Fortune")) {
/* 320 */       if (level >= lvl) {
/* 321 */         item.removeEnchantment(Enchantment.LOOT_BONUS_BLOCKS);
/* 322 */       } else if (lvl > level) {
/* 323 */         item.addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, lvl - level);
/*     */       } 
/* 325 */     } else if (enchant.equalsIgnoreCase("Efficiency")) {
/* 326 */       if (level >= lvl) {
/* 327 */         item.removeEnchantment(Enchantment.DIG_SPEED);
/* 328 */       } else if (lvl > level) {
/* 329 */         item.addUnsafeEnchantment(Enchantment.DIG_SPEED, lvl - level);
/*     */       } 
/*     */     } 
/*     */     
/* 333 */     return item;
/*     */   }
/*     */ 
/*     */   
/*     */   public static ItemStack setToItem(ItemStack item, int level, String enchant) {
/* 338 */     enchant = String.valueOf(enchant.substring(0, 1).toUpperCase()) + enchant.substring(1).toLowerCase();
/*     */     
/* 340 */     ItemMeta meta = item.getItemMeta();
/* 341 */     List<String> lore = meta.hasLore() ? meta.getLore() : new ArrayList<>();
/*     */     
/* 343 */     int lvl = 0;
/* 344 */     for (String str : lore) {
/* 345 */       if (str.contains(enchant)) {
/* 346 */         lvl = Integer.valueOf(str.split(" ")[1]).intValue();
/*     */       }
/*     */     } 
/*     */     
/* 350 */     if (lvl > 0) {
/* 351 */       lore.remove(String.valueOf(String.valueOf(plugin.getEnchantColor(enchant))) + enchant + " " + Integer.toString(lvl));
/*     */     }
/*     */     
/* 354 */     lore.add(String.valueOf(String.valueOf(plugin.getEnchantColor(enchant))) + enchant + " " + Integer.toString(level));
/* 355 */     Collections.sort(lore);
/* 356 */     meta.setLore(lore);
/* 357 */     meta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
/* 358 */     item.setItemMeta(meta);
/*     */     
/* 360 */     if (enchant.equalsIgnoreCase("Fortune")) {
/* 361 */       item.addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, level);
/* 362 */     } else if (enchant.equalsIgnoreCase("Efficiency")) {
/* 363 */       item.addUnsafeEnchantment(Enchantment.DIG_SPEED, level);
/*     */     } 
/*     */     
/* 366 */     return item;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean hasAvailableSlot(Player p) {
/* 372 */     PlayerInventory playerInventory = p.getInventory();
/*     */     
/* 374 */     Boolean check = Boolean.valueOf(false); byte b; int i;
/*     */     ItemStack[] arrayOfItemStack;
/* 376 */     for (i = (arrayOfItemStack = playerInventory.getContents()).length, b = 0; b < i; ) { ItemStack item = arrayOfItemStack[b];
/*     */       
/* 378 */       if (item == null) {
/*     */         
/* 380 */         check = Boolean.valueOf(true);
/*     */         break;
/*     */       } 
/*     */       b++; }
/*     */     
/* 385 */     return check.booleanValue();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void giveTokenNote(Player p, String owner, Long amount) {
/* 391 */     ItemStack note = new ItemStack(Material.PAPER);
/* 392 */     ItemMeta meta = note.getItemMeta();
/* 393 */     meta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
/* 394 */     meta.setDisplayName(getDominantTokenColor() + "Token Note");
/* 395 */     List<String> lore = new ArrayList<>();
/* 396 */     lore.add(getDominantTokenColor() + " * " + getSecondaryTokenColor() + "Owner: " + getDominantTokenColor() + 
/* 397 */         owner);
/* 398 */     lore.add(getDominantTokenColor() + " * " + getSecondaryTokenColor() + "Amount: " + getDominantTokenColor() + 
/* 399 */         amount);
/* 400 */     lore.add(" ");
/* 401 */     lore.add(getDominantTokenColor() + " * " + getSecondaryTokenColor() + 
/* 402 */         "§oRight click to deposit this Token Note!");
/* 403 */     meta.setLore(lore);
/* 404 */     note.setItemMeta(meta);
/* 405 */     note.addUnsafeEnchantment(Enchantment.DIG_SPEED, 1);
/* 406 */     if (hasAvailableSlot(p)) {
/* 407 */       p.getInventory().addItem(new ItemStack[] { note });
/*     */     } else {
/* 409 */       p.getWorld().dropItem(p.getLocation(), note);
/*     */     } 
/* 411 */     p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0F, 1.0F);
/*     */   }
/*     */   
/*     */   public static ChatColor getDominantTokenColor() {
/* 415 */     ChatColor dominant = 
/* 416 */       ChatColor.valueOf(plugin.getConfig().getString("Tokens.Messages.Dominantcolor").toUpperCase());
/* 417 */     return dominant;
/*     */   }
/*     */   
/*     */   public static ChatColor getSecondaryTokenColor() {
/* 421 */     ChatColor secondary = 
/* 422 */       ChatColor.valueOf(plugin.getConfig().getString("Tokens.Messages.Secondarycolor").toUpperCase());
/* 423 */     return secondary;
/*     */   }
/*     */ 
/*     */   
/*     */   public static String formatValue(Long value) {
/* 428 */     String suffix = " kmbtq";
/* 429 */     String formattedNumber = "";
/*     */     
/* 431 */     NumberFormat formatter = new DecimalFormat("#,###.#");
/* 432 */     int power = (int)StrictMath.log10(value.longValue());
/* 433 */     value = Long.valueOf(value.longValue() / (long)Math.pow(10.0D, (power / 3 * 3)));
/* 434 */     formattedNumber = formatter.format(value);
/* 435 */     formattedNumber = String.valueOf(formattedNumber) + suffix.charAt(power / 3);
/* 436 */     return (formattedNumber.length() > 4) ? formattedNumber.replaceAll("\\.[0-9]+", "") : formattedNumber;
/*     */   }
/*     */ }


/* Location:              C:\Users\17hautrivel\Desktop\PrisonEnchants.jar!\me\iLucaH\PrisonEnchants\Utils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */