/*     */ package me.iLucaH.PrisonEnchants.Enchanter;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import me.iLucaH.PrisonEnchants.MainClass;
/*     */ import me.iLucaH.PrisonEnchants.Tokens.Tokens;
/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.Material;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.inventory.Inventory;
/*     */ import org.bukkit.inventory.InventoryHolder;
/*     */ import org.bukkit.inventory.ItemStack;
/*     */ import org.bukkit.inventory.meta.ItemMeta;
/*     */ 
/*     */ 
/*     */ public class PurchaseMenu
/*     */ {
/*  18 */   private static MainClass plugin = MainClass.plugin;
/*     */   
/*     */   public void refreshMenu(String enchant, Player p, Inventory menu) {
/*  21 */     Tokens tokens = new Tokens(p.getUniqueId());
/*  22 */     String nocolorname = enchant.substring(4);
/*  23 */     ItemStack one = new ItemStack(Material.EXPERIENCE_BOTTLE);
/*  24 */     ItemStack item = p.getInventory().getItemInMainHand();
/*     */     
/*  26 */     int enchantlevel = 0;
/*  27 */     if (item.hasItemMeta() && 
/*  28 */       item.getItemMeta().hasLore()) {
/*  29 */       for (String str : item.getItemMeta().getLore()) {
/*  30 */         if (str.contains(nocolorname)) {
/*  31 */           enchantlevel = Integer.valueOf(str.split(" ")[1]).intValue();
/*     */         }
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*  37 */     int enchprice = plugin.getConfig().getInt("Enchants." + nocolorname + ".Enchantprice");
/*  38 */     int fiveprice = enchprice * 5;
/*  39 */     int tenprice = enchprice * 10;
/*  40 */     int twentieprice = enchprice * 25;
/*  41 */     int fiftyprice = enchprice * 50;
/*  42 */     int hundoprice = enchprice * 100;
/*  43 */     int twofiftyprice = enchprice * 250;
/*  44 */     int fivehundoprice = enchprice * 500;
/*  45 */     int centprice = enchprice * 1000;
/*     */ 
/*     */     
/*  48 */     ItemMeta im = one.getItemMeta();
/*  49 */     List<String> lore = new ArrayList<>();
/*  50 */     im.setDisplayName(String.valueOf(plugin.getEnchantColor(nocolorname)) + "§l+ 1 Level");
/*  51 */     lore.add("§8Description:");
/*  52 */     lore.add(" ");
/*  53 */     lore.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §7Enchant: ");
/*  54 */     lore.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §f" + enchant);
/*  55 */     lore.add(" ");
/*  56 */     lore.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §7Price: ");
/*  57 */     lore.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §f" + plugin.getConfig().getString("Tokens.Symbol") + enchprice);
/*  58 */     lore.add(" ");
/*  59 */     lore.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §7Your tokens: ");
/*  60 */     lore.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §f" + plugin.getConfig().getString("Tokens.Symbol") + tokens.getTokens());
/*  61 */     lore.add(" ");
/*  62 */     lore.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §7Current " + enchant + "§7 level: ");
/*  63 */     lore.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §f" + enchantlevel);
/*  64 */     lore.add(" ");
/*  65 */     lore.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §7§oLeftcick to purchase!");
/*  66 */     im.setLore(lore);
/*  67 */     one.setItemMeta(im);
/*     */ 
/*     */     
/*  70 */     ItemStack five = new ItemStack(Material.EXPERIENCE_BOTTLE);
/*     */     
/*  72 */     ItemMeta itemMeta1 = five.getItemMeta();
/*  73 */     List<String> list1 = new ArrayList<>();
/*  74 */     itemMeta1.setDisplayName(String.valueOf(plugin.getEnchantColor(nocolorname)) + "§l+ 5 Levels");
/*  75 */     list1.add("§8Description:");
/*  76 */     list1.add(" ");
/*  77 */     list1.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §7Enchant: ");
/*  78 */     list1.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §f" + enchant);
/*  79 */     list1.add(" ");
/*  80 */     list1.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §7Price: ");
/*  81 */     list1.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §f" + plugin.getConfig().getString("Tokens.Symbol") + fiveprice);
/*  82 */     list1.add(" ");
/*  83 */     list1.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §7Your tokens: ");
/*  84 */     list1.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §f" + plugin.getConfig().getString("Tokens.Symbol") + tokens.getTokens());
/*  85 */     list1.add(" ");
/*  86 */     list1.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §7Current " + enchant + "§7 level: ");
/*  87 */     list1.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §f" + enchantlevel);
/*  88 */     list1.add(" ");
/*  89 */     list1.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §7§oLeftcick to purchase!");
/*  90 */     itemMeta1.setLore(list1);
/*  91 */     five.setItemMeta(itemMeta1);
/*     */ 
/*     */     
/*  94 */     ItemStack ten = new ItemStack(Material.EXPERIENCE_BOTTLE);
/*     */     
/*  96 */     ItemMeta itemMeta2 = ten.getItemMeta();
/*  97 */     List<String> list2 = new ArrayList<>();
/*  98 */     itemMeta2.setDisplayName(String.valueOf(plugin.getEnchantColor(nocolorname)) + "§l+ 10 Levels");
/*  99 */     list2.add("§8Description:");
/* 100 */     list2.add(" ");
/* 101 */     list2.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §7Enchant: ");
/* 102 */     list2.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §f" + enchant);
/* 103 */     list2.add(" ");
/* 104 */     list2.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §7Price: ");
/* 105 */     list2.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §f" + plugin.getConfig().getString("Tokens.Symbol") + tenprice);
/* 106 */     list2.add(" ");
/* 107 */     list2.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §7Your tokens: ");
/* 108 */     list2.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §f" + plugin.getConfig().getString("Tokens.Symbol") + tokens.getTokens());
/* 109 */     list2.add(" ");
/* 110 */     list2.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §7Current " + enchant + "§7 level: ");
/* 111 */     list2.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §f" + enchantlevel);
/* 112 */     list2.add(" ");
/* 113 */     list2.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §7§oLeftcick to purchase!");
/* 114 */     itemMeta2.setLore(list2);
/* 115 */     ten.setItemMeta(itemMeta2);
/*     */ 
/*     */     
/* 118 */     ItemStack twentie = new ItemStack(Material.EXPERIENCE_BOTTLE);
/*     */     
/* 120 */     ItemMeta itemMeta3 = twentie.getItemMeta();
/* 121 */     List<String> list3 = new ArrayList<>();
/* 122 */     itemMeta3.setDisplayName(String.valueOf(plugin.getEnchantColor(nocolorname)) + "§l+ 25 Levels");
/* 123 */     list3.add("§8Description:");
/* 124 */     list3.add(" ");
/* 125 */     list3.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §7Enchant: ");
/* 126 */     list3.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §f" + enchant);
/* 127 */     list3.add(" ");
/* 128 */     list3.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §7Price: ");
/* 129 */     list3.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §f" + plugin.getConfig().getString("Tokens.Symbol") + twentieprice);
/* 130 */     list3.add(" ");
/* 131 */     list3.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §7Your tokens: ");
/* 132 */     list3.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §f" + plugin.getConfig().getString("Tokens.Symbol") + tokens.getTokens());
/* 133 */     list3.add(" ");
/* 134 */     list3.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §7Current " + enchant + "§7 level: ");
/* 135 */     list3.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §f" + enchantlevel);
/* 136 */     list3.add(" ");
/* 137 */     list3.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §7§oLeftcick to purchase!");
/* 138 */     itemMeta3.setLore(list3);
/* 139 */     twentie.setItemMeta(itemMeta3);
/*     */ 
/*     */     
/* 142 */     ItemStack fifty = new ItemStack(Material.EXPERIENCE_BOTTLE);
/*     */     
/* 144 */     ItemMeta itemMeta4 = fifty.getItemMeta();
/* 145 */     List<String> list4 = new ArrayList<>();
/* 146 */     itemMeta4.setDisplayName(String.valueOf(plugin.getEnchantColor(nocolorname)) + "§l+ 50 Levels");
/* 147 */     list4.add("§8Description:");
/* 148 */     list4.add(" ");
/* 149 */     list4.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §7Enchant: ");
/* 150 */     list4.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §f" + enchant);
/* 151 */     list4.add(" ");
/* 152 */     list4.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §7Price: ");
/* 153 */     list4.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §f" + plugin.getConfig().getString("Tokens.Symbol") + fiftyprice);
/* 154 */     list4.add(" ");
/* 155 */     list4.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §7Your tokens: ");
/* 156 */     list4.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §f" + plugin.getConfig().getString("Tokens.Symbol") + tokens.getTokens());
/* 157 */     list4.add(" ");
/* 158 */     list4.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §7Current " + enchant + "§7 level: ");
/* 159 */     list4.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §f" + enchantlevel);
/* 160 */     list4.add(" ");
/* 161 */     list4.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §7§oLeftcick to purchase!");
/* 162 */     itemMeta4.setLore(list4);
/* 163 */     fifty.setItemMeta(itemMeta4);
/*     */ 
/*     */     
/* 166 */     ItemStack hundo = new ItemStack(Material.EXPERIENCE_BOTTLE);
/*     */     
/* 168 */     ItemMeta itemMeta5 = hundo.getItemMeta();
/* 169 */     List<String> list5 = new ArrayList<>();
/* 170 */     itemMeta5.setDisplayName(String.valueOf(plugin.getEnchantColor(nocolorname)) + "§l+ 100 Levels");
/* 171 */     list5.add("§8Description:");
/* 172 */     list5.add(" ");
/* 173 */     list5.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §7Enchant: ");
/* 174 */     list5.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §f" + enchant);
/* 175 */     list5.add(" ");
/* 176 */     list5.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §7Price: ");
/* 177 */     list5.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §f" + plugin.getConfig().getString("Tokens.Symbol") + hundoprice);
/* 178 */     list5.add(" ");
/* 179 */     list5.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §7Your tokens: ");
/* 180 */     list5.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §f" + plugin.getConfig().getString("Tokens.Symbol") + tokens.getTokens());
/* 181 */     list5.add(" ");
/* 182 */     list5.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §7Current " + enchant + "§7 level: ");
/* 183 */     list5.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §f" + enchantlevel);
/* 184 */     list5.add(" ");
/* 185 */     list5.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §7§oLeftcick to purchase!");
/* 186 */     itemMeta5.setLore(list5);
/* 187 */     hundo.setItemMeta(itemMeta5);
/*     */ 
/*     */     
/* 190 */     ItemStack twofifty = new ItemStack(Material.EXPERIENCE_BOTTLE);
/*     */     
/* 192 */     ItemMeta itemMeta6 = twofifty.getItemMeta();
/* 193 */     List<String> list6 = new ArrayList<>();
/* 194 */     itemMeta6.setDisplayName(String.valueOf(plugin.getEnchantColor(nocolorname)) + "§l+ 250 Levels");
/* 195 */     list6.add("§8Description:");
/* 196 */     list6.add(" ");
/* 197 */     list6.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §7Enchant: ");
/* 198 */     list6.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §f" + enchant);
/* 199 */     list6.add(" ");
/* 200 */     list6.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §7Price: ");
/* 201 */     list6.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §f" + plugin.getConfig().getString("Tokens.Symbol") + twofiftyprice);
/* 202 */     list6.add(" ");
/* 203 */     list6.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §7Your tokens: ");
/* 204 */     list6.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §f" + plugin.getConfig().getString("Tokens.Symbol") + tokens.getTokens());
/* 205 */     list6.add(" ");
/* 206 */     list6.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §7Current " + enchant + "§7 level: ");
/* 207 */     list6.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §f" + enchantlevel);
/* 208 */     list6.add(" ");
/* 209 */     list6.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §7§oLeftcick to purchase!");
/* 210 */     itemMeta6.setLore(list6);
/* 211 */     twofifty.setItemMeta(itemMeta6);
/*     */ 
/*     */     
/* 214 */     ItemStack fivehundo = new ItemStack(Material.EXPERIENCE_BOTTLE);
/*     */     
/* 216 */     ItemMeta itemMeta7 = fivehundo.getItemMeta();
/* 217 */     List<String> list7 = new ArrayList<>();
/* 218 */     itemMeta7.setDisplayName(String.valueOf(plugin.getEnchantColor(nocolorname)) + "§l+ 500 Levels");
/* 219 */     list7.add("§8Description:");
/* 220 */     list7.add(" ");
/* 221 */     list7.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §7Enchant: ");
/* 222 */     list7.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §f" + enchant);
/* 223 */     list7.add(" ");
/* 224 */     list7.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §7Price: ");
/* 225 */     list7.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §f" + plugin.getConfig().getString("Tokens.Symbol") + fivehundoprice);
/* 226 */     list7.add(" ");
/* 227 */     list7.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §7Your tokens: ");
/* 228 */     list7.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §f" + plugin.getConfig().getString("Tokens.Symbol") + tokens.getTokens());
/* 229 */     list7.add(" ");
/* 230 */     list7.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §7Current " + enchant + "§7 level: ");
/* 231 */     list7.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §f" + enchantlevel);
/* 232 */     list7.add(" ");
/* 233 */     list7.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §7§oLeftcick to purchase!");
/* 234 */     itemMeta7.setLore(list7);
/* 235 */     fivehundo.setItemMeta(itemMeta7);
/*     */ 
/*     */     
/* 238 */     ItemStack cent = new ItemStack(Material.EXPERIENCE_BOTTLE);
/*     */     
/* 240 */     ItemMeta itemMeta8 = cent.getItemMeta();
/* 241 */     List<String> list8 = new ArrayList<>();
/* 242 */     itemMeta8.setDisplayName(String.valueOf(plugin.getEnchantColor(nocolorname)) + "§l+ 1000 Levels");
/* 243 */     list8.add("§8Description:");
/* 244 */     list8.add(" ");
/* 245 */     list8.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §7Enchant: ");
/* 246 */     list8.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §f" + enchant);
/* 247 */     list8.add(" ");
/* 248 */     list8.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §7Price: ");
/* 249 */     list8.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §f" + plugin.getConfig().getString("Tokens.Symbol") + centprice);
/* 250 */     list8.add(" ");
/* 251 */     list8.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §7Your tokens: ");
/* 252 */     list8.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §f" + plugin.getConfig().getString("Tokens.Symbol") + tokens.getTokens());
/* 253 */     list8.add(" ");
/* 254 */     list8.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §7Current " + enchant + "§7 level: ");
/* 255 */     list8.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §f" + enchantlevel);
/* 256 */     list8.add(" ");
/* 257 */     list8.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §7§oLeftcick to purchase!");
/* 258 */     itemMeta8.setLore(list8);
/* 259 */     cent.setItemMeta(itemMeta8);
/*     */     
/* 261 */     menu.setItem(9, one);
/* 262 */     menu.setItem(10, five);
/* 263 */     menu.setItem(11, ten);
/* 264 */     menu.setItem(12, twentie);
/* 265 */     menu.setItem(13, fifty);
/* 266 */     menu.setItem(14, hundo);
/* 267 */     menu.setItem(15, twofifty);
/* 268 */     menu.setItem(16, fivehundo);
/* 269 */     menu.setItem(17, cent);
/* 270 */     menu.setItem(4, item);
/*     */   }
/*     */ 
/*     */   
/*     */   public void openMenu(String enchant, Player p) {
/* 275 */     Inventory menu = Bukkit.createInventory((InventoryHolder)p, 18, "Purchase " + enchant);
/* 276 */     Tokens tokens = new Tokens(p.getUniqueId());
/* 277 */     String nocolorname = enchant.substring(4);
/* 278 */     ItemStack item = p.getInventory().getItemInMainHand();
/* 279 */     ItemStack pane = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
/*     */     
/* 281 */     int enchantlevel = 0;
/* 282 */     if (item.hasItemMeta() && 
/* 283 */       item.getItemMeta().hasLore()) {
/* 284 */       for (String str : item.getItemMeta().getLore()) {
/* 285 */         if (str.contains(nocolorname)) {
/* 286 */           enchantlevel = Integer.valueOf(str.split(" ")[1]).intValue();
/*     */         }
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/* 292 */     int enchprice = plugin.getConfig().getInt("Enchants." + nocolorname + ".Enchantprice");
/* 293 */     int fiveprice = enchprice * 5;
/* 294 */     int tenprice = enchprice * 10;
/* 295 */     int twentieprice = enchprice * 25;
/* 296 */     int fiftyprice = enchprice * 50;
/* 297 */     int hundoprice = enchprice * 100;
/* 298 */     int twofiftyprice = enchprice * 250;
/* 299 */     int fivehundoprice = enchprice * 500;
/* 300 */     int centprice = enchprice * 1000;
/*     */     
/* 302 */     menu.setItem(4, item);
/*     */     
/* 304 */     ItemStack one = new ItemStack(Material.EXPERIENCE_BOTTLE);
/*     */     
/* 306 */     ItemMeta im = one.getItemMeta();
/* 307 */     List<String> lore = new ArrayList<>();
/* 308 */     im.setDisplayName(String.valueOf(plugin.getEnchantColor(nocolorname)) + "§l+ 1 Level");
/* 309 */     lore.add("§8Description:");
/* 310 */     lore.add(" ");
/* 311 */     lore.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §7Enchant: ");
/* 312 */     lore.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §f" + enchant);
/* 313 */     lore.add(" ");
/* 314 */     lore.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §7Price: ");
/* 315 */     lore.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §f" + plugin.getConfig().getString("Tokens.Symbol") + enchprice);
/* 316 */     lore.add(" ");
/* 317 */     lore.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §7Your tokens: ");
/* 318 */     lore.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §f" + plugin.getConfig().getString("Tokens.Symbol") + tokens.getTokens());
/* 319 */     lore.add(" ");
/* 320 */     lore.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §7Current " + enchant + "§7 level: ");
/* 321 */     lore.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §f" + enchantlevel);
/* 322 */     lore.add(" ");
/* 323 */     lore.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §7§oLeftcick to purchase!");
/* 324 */     im.setLore(lore);
/* 325 */     one.setItemMeta(im);
/* 326 */     menu.addItem(new ItemStack[] { one });
/* 327 */     menu.setItem(9, one);
/*     */ 
/*     */     
/* 330 */     ItemStack five = new ItemStack(Material.EXPERIENCE_BOTTLE);
/*     */     
/* 332 */     ItemMeta itemMeta1 = five.getItemMeta();
/* 333 */     List<String> list1 = new ArrayList<>();
/* 334 */     itemMeta1.setDisplayName(String.valueOf(plugin.getEnchantColor(nocolorname)) + "§l+ 5 Levels");
/* 335 */     list1.add("§8Description:");
/* 336 */     list1.add(" ");
/* 337 */     list1.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §7Enchant: ");
/* 338 */     list1.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §f" + enchant);
/* 339 */     list1.add(" ");
/* 340 */     list1.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §7Price: ");
/* 341 */     list1.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §f" + plugin.getConfig().getString("Tokens.Symbol") + fiveprice);
/* 342 */     list1.add(" ");
/* 343 */     list1.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §7Your tokens: ");
/* 344 */     list1.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §f" + plugin.getConfig().getString("Tokens.Symbol") + tokens.getTokens());
/* 345 */     list1.add(" ");
/* 346 */     list1.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §7Current " + enchant + "§7 level: ");
/* 347 */     list1.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §f" + enchantlevel);
/* 348 */     list1.add(" ");
/* 349 */     list1.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §7§oLeftcick to purchase!");
/* 350 */     itemMeta1.setLore(list1);
/* 351 */     five.setItemMeta(itemMeta1);
/* 352 */     menu.addItem(new ItemStack[] { five });
/* 353 */     menu.setItem(10, five);
/*     */ 
/*     */     
/* 356 */     ItemStack ten = new ItemStack(Material.EXPERIENCE_BOTTLE);
/*     */     
/* 358 */     ItemMeta itemMeta2 = ten.getItemMeta();
/* 359 */     List<String> list2 = new ArrayList<>();
/* 360 */     itemMeta2.setDisplayName(String.valueOf(plugin.getEnchantColor(nocolorname)) + "§l+ 10 Levels");
/* 361 */     list2.add("§8Description:");
/* 362 */     list2.add(" ");
/* 363 */     list2.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §7Enchant: ");
/* 364 */     list2.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §f" + enchant);
/* 365 */     list2.add(" ");
/* 366 */     list2.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §7Price: ");
/* 367 */     list2.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §f" + plugin.getConfig().getString("Tokens.Symbol") + tenprice);
/* 368 */     list2.add(" ");
/* 369 */     list2.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §7Your tokens: ");
/* 370 */     list2.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §f" + plugin.getConfig().getString("Tokens.Symbol") + tokens.getTokens());
/* 371 */     list2.add(" ");
/* 372 */     list2.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §7Current " + enchant + "§7 level: ");
/* 373 */     list2.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §f" + enchantlevel);
/* 374 */     list2.add(" ");
/* 375 */     list2.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §7§oLeftcick to purchase!");
/* 376 */     itemMeta2.setLore(list2);
/* 377 */     ten.setItemMeta(itemMeta2);
/* 378 */     menu.addItem(new ItemStack[] { ten });
/* 379 */     menu.setItem(11, ten);
/*     */ 
/*     */     
/* 382 */     ItemStack twentie = new ItemStack(Material.EXPERIENCE_BOTTLE);
/*     */     
/* 384 */     ItemMeta itemMeta3 = twentie.getItemMeta();
/* 385 */     List<String> list3 = new ArrayList<>();
/* 386 */     itemMeta3.setDisplayName(String.valueOf(plugin.getEnchantColor(nocolorname)) + "§l+ 25 Levels");
/* 387 */     list3.add("§8Description:");
/* 388 */     list3.add(" ");
/* 389 */     list3.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §7Enchant: ");
/* 390 */     list3.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §f" + enchant);
/* 391 */     list3.add(" ");
/* 392 */     list3.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §7Price: ");
/* 393 */     list3.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §f" + plugin.getConfig().getString("Tokens.Symbol") + twentieprice);
/* 394 */     list3.add(" ");
/* 395 */     list3.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §7Your tokens: ");
/* 396 */     list3.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §f" + plugin.getConfig().getString("Tokens.Symbol") + tokens.getTokens());
/* 397 */     list3.add(" ");
/* 398 */     list3.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §7Current " + enchant + "§7 level: ");
/* 399 */     list3.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §f" + enchantlevel);
/* 400 */     list3.add(" ");
/* 401 */     list3.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §7§oLeftcick to purchase!");
/* 402 */     itemMeta3.setLore(list3);
/* 403 */     twentie.setItemMeta(itemMeta3);
/* 404 */     menu.addItem(new ItemStack[] { twentie });
/* 405 */     menu.setItem(12, twentie);
/*     */ 
/*     */     
/* 408 */     ItemStack fifty = new ItemStack(Material.EXPERIENCE_BOTTLE);
/*     */     
/* 410 */     ItemMeta itemMeta4 = fifty.getItemMeta();
/* 411 */     List<String> list4 = new ArrayList<>();
/* 412 */     itemMeta4.setDisplayName(String.valueOf(plugin.getEnchantColor(nocolorname)) + "§l+ 50 Levels");
/* 413 */     list4.add("§8Description:");
/* 414 */     list4.add(" ");
/* 415 */     list4.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §7Enchant: ");
/* 416 */     list4.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §f" + enchant);
/* 417 */     list4.add(" ");
/* 418 */     list4.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §7Price: ");
/* 419 */     list4.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §f" + plugin.getConfig().getString("Tokens.Symbol") + fiftyprice);
/* 420 */     list4.add(" ");
/* 421 */     list4.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §7Your tokens: ");
/* 422 */     list4.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §f" + plugin.getConfig().getString("Tokens.Symbol") + tokens.getTokens());
/* 423 */     list4.add(" ");
/* 424 */     list4.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §7Current " + enchant + "§7 level: ");
/* 425 */     list4.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §f" + enchantlevel);
/* 426 */     list4.add(" ");
/* 427 */     list4.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §7§oLeftcick to purchase!");
/* 428 */     itemMeta4.setLore(list4);
/* 429 */     fifty.setItemMeta(itemMeta4);
/* 430 */     menu.addItem(new ItemStack[] { fifty });
/* 431 */     menu.setItem(13, fifty);
/*     */ 
/*     */     
/* 434 */     ItemStack hundo = new ItemStack(Material.EXPERIENCE_BOTTLE);
/*     */     
/* 436 */     ItemMeta itemMeta5 = hundo.getItemMeta();
/* 437 */     List<String> list5 = new ArrayList<>();
/* 438 */     itemMeta5.setDisplayName(String.valueOf(plugin.getEnchantColor(nocolorname)) + "§l+ 100 Levels");
/* 439 */     list5.add("§8Description:");
/* 440 */     list5.add(" ");
/* 441 */     list5.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §7Enchant: ");
/* 442 */     list5.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §f" + enchant);
/* 443 */     list5.add(" ");
/* 444 */     list5.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §7Price: ");
/* 445 */     list5.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §f" + plugin.getConfig().getString("Tokens.Symbol") + hundoprice);
/* 446 */     list5.add(" ");
/* 447 */     list5.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §7Your tokens: ");
/* 448 */     list5.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §f" + plugin.getConfig().getString("Tokens.Symbol") + tokens.getTokens());
/* 449 */     list5.add(" ");
/* 450 */     list5.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §7Current " + enchant + "§7 level: ");
/* 451 */     list5.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §f" + enchantlevel);
/* 452 */     list5.add(" ");
/* 453 */     list5.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §7§oLeftcick to purchase!");
/* 454 */     itemMeta5.setLore(list5);
/* 455 */     hundo.setItemMeta(itemMeta5);
/* 456 */     menu.addItem(new ItemStack[] { hundo });
/* 457 */     menu.setItem(14, hundo);
/*     */ 
/*     */     
/* 460 */     ItemStack twofifty = new ItemStack(Material.EXPERIENCE_BOTTLE);
/*     */     
/* 462 */     ItemMeta itemMeta6 = twofifty.getItemMeta();
/* 463 */     List<String> list6 = new ArrayList<>();
/* 464 */     itemMeta6.setDisplayName(String.valueOf(plugin.getEnchantColor(nocolorname)) + "§l+ 250 Levels");
/* 465 */     list6.add("§8Description:");
/* 466 */     list6.add(" ");
/* 467 */     list6.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §7Enchant: ");
/* 468 */     list6.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §f" + enchant);
/* 469 */     list6.add(" ");
/* 470 */     list6.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §7Price: ");
/* 471 */     list6.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §f" + plugin.getConfig().getString("Tokens.Symbol") + twofiftyprice);
/* 472 */     list6.add(" ");
/* 473 */     list6.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §7Your tokens: ");
/* 474 */     list6.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §f" + plugin.getConfig().getString("Tokens.Symbol") + tokens.getTokens());
/* 475 */     list6.add(" ");
/* 476 */     list6.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §7Current " + enchant + "§7 level: ");
/* 477 */     list6.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §f" + enchantlevel);
/* 478 */     list6.add(" ");
/* 479 */     list6.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §7§oLeftcick to purchase!");
/* 480 */     itemMeta6.setLore(list6);
/* 481 */     twofifty.setItemMeta(itemMeta6);
/* 482 */     menu.addItem(new ItemStack[] { twofifty });
/* 483 */     menu.setItem(15, twofifty);
/*     */ 
/*     */     
/* 486 */     ItemStack fivehundo = new ItemStack(Material.EXPERIENCE_BOTTLE);
/*     */     
/* 488 */     ItemMeta itemMeta7 = fivehundo.getItemMeta();
/* 489 */     List<String> list7 = new ArrayList<>();
/* 490 */     itemMeta7.setDisplayName(String.valueOf(plugin.getEnchantColor(nocolorname)) + "§l+ 500 Levels");
/* 491 */     list7.add("§8Description:");
/* 492 */     list7.add(" ");
/* 493 */     list7.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §7Enchant: ");
/* 494 */     list7.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §f" + enchant);
/* 495 */     list7.add(" ");
/* 496 */     list7.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §7Price: ");
/* 497 */     list7.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §f" + plugin.getConfig().getString("Tokens.Symbol") + fivehundoprice);
/* 498 */     list7.add(" ");
/* 499 */     list7.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §7Your tokens: ");
/* 500 */     list7.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §f" + plugin.getConfig().getString("Tokens.Symbol") + tokens.getTokens());
/* 501 */     list7.add(" ");
/* 502 */     list7.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §7Current " + enchant + "§7 level: ");
/* 503 */     list7.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §f" + enchantlevel);
/* 504 */     list7.add(" ");
/* 505 */     list7.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §7§oLeftcick to purchase!");
/* 506 */     itemMeta7.setLore(list7);
/* 507 */     fivehundo.setItemMeta(itemMeta7);
/* 508 */     menu.addItem(new ItemStack[] { fivehundo });
/* 509 */     menu.setItem(16, fivehundo);
/*     */ 
/*     */     
/* 512 */     ItemStack cent = new ItemStack(Material.EXPERIENCE_BOTTLE);
/*     */     
/* 514 */     ItemMeta itemMeta8 = cent.getItemMeta();
/* 515 */     List<String> list8 = new ArrayList<>();
/* 516 */     itemMeta8.setDisplayName(String.valueOf(plugin.getEnchantColor(nocolorname)) + "§l+ 1000 Levels");
/* 517 */     list8.add("§8Description:");
/* 518 */     list8.add(" ");
/* 519 */     list8.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §7Enchant: ");
/* 520 */     list8.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §f" + enchant);
/* 521 */     list8.add(" ");
/* 522 */     list8.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §7Price: ");
/* 523 */     list8.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §f" + plugin.getConfig().getString("Tokens.Symbol") + centprice);
/* 524 */     list8.add(" ");
/* 525 */     list8.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §7Your tokens: ");
/* 526 */     list8.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §f" + plugin.getConfig().getString("Tokens.Symbol") + tokens.getTokens());
/* 527 */     list8.add(" ");
/* 528 */     list8.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §7Current " + enchant + "§7 level: ");
/* 529 */     list8.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §f" + enchantlevel);
/* 530 */     list8.add(" ");
/* 531 */     list8.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §7§oLeftcick to purchase!");
/* 532 */     itemMeta8.setLore(list8);
/* 533 */     cent.setItemMeta(itemMeta8);
/* 534 */     menu.addItem(new ItemStack[] { cent });
/* 535 */     menu.setItem(17, cent);
/*     */     
/* 537 */     menu.setItem(0, pane);
/* 538 */     menu.setItem(1, pane);
/* 539 */     menu.setItem(2, pane);
/* 540 */     menu.setItem(3, pane);
/* 541 */     menu.setItem(4, item);
/* 542 */     menu.setItem(5, pane);
/* 543 */     menu.setItem(6, pane);
/* 544 */     menu.setItem(7, pane);
/* 545 */     menu.setItem(8, pane);
/* 546 */     p.openInventory(menu);
/*     */   }
/*     */ }


/* Location:              C:\Users\17hautrivel\Desktop\PrisonEnchants.jar!\me\iLucaH\PrisonEnchants\Enchanter\PurchaseMenu.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */