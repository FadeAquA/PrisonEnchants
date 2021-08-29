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
/*     */ public class DisenchantMenu
/*     */ {
/*  18 */   private static MainClass plugin = MainClass.plugin;
/*     */ 
/*     */   
/*     */   public void refreshMenu(String enchant, Player p, Inventory inv) {
/*  22 */     Tokens tokens = new Tokens(p.getUniqueId());
/*  23 */     String nocolorname = enchant;
/*  24 */     ItemStack item = p.getInventory().getItemInMainHand();
/*     */     
/*  26 */     ItemStack one = new ItemStack(Material.EXPERIENCE_BOTTLE);
/*     */     
/*  28 */     ItemMeta im = one.getItemMeta();
/*  29 */     List<String> lore = new ArrayList<>();
/*  30 */     im.setDisplayName(String.valueOf(plugin.getEnchantColor(nocolorname)) + "§l- 1 Levels");
/*  31 */     lore.add("§8Description:");
/*  32 */     lore.add(" ");
/*  33 */     lore.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §7Enchant: ");
/*  34 */     lore.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §f" + enchant);
/*  35 */     lore.add(" ");
/*  36 */     lore.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §7Return: ");
/*  37 */     lore.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §f15% Tokens");
/*  38 */     lore.add(" ");
/*  39 */     lore.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §7Your tokens: ");
/*  40 */     lore.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §f" + tokens.getTokens());
/*  41 */     lore.add(" ");
/*  42 */     lore.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §7§oLeftcick to disenchant 1 level!");
/*  43 */     im.setLore(lore);
/*  44 */     one.setItemMeta(im);
/*     */     
/*  46 */     ItemStack all = new ItemStack(Material.EXPERIENCE_BOTTLE);
/*     */     
/*  48 */     ItemMeta itemMeta1 = all.getItemMeta();
/*  49 */     List<String> list1 = new ArrayList<>();
/*  50 */     itemMeta1.setDisplayName(String.valueOf(plugin.getEnchantColor(nocolorname)) + "§l- All Levels");
/*  51 */     list1.add("§8Description:");
/*  52 */     list1.add(" ");
/*  53 */     list1.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §7Enchant: ");
/*  54 */     list1.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §f" + enchant);
/*  55 */     list1.add(" ");
/*  56 */     list1.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §7Return: ");
/*  57 */     list1.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §f15% Tokens");
/*  58 */     list1.add(" ");
/*  59 */     list1.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §7Your tokens: ");
/*  60 */     list1.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §f" + tokens.getTokens());
/*  61 */     list1.add(" ");
/*  62 */     list1.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §7§oLeftcick to disenchant all levels!");
/*  63 */     itemMeta1.setLore(list1);
/*  64 */     all.setItemMeta(itemMeta1);
/*     */     
/*  66 */     inv.setItem(6, all);
/*  67 */     inv.setItem(4, item);
/*  68 */     inv.setItem(2, one);
/*     */   }
/*     */ 
/*     */   
/*     */   public void openMenu(String enchant, Player p) {
/*  73 */     Inventory menu = Bukkit.createInventory((InventoryHolder)p, 9, "Disenchant " + enchant);
/*  74 */     Tokens tokens = new Tokens(p.getUniqueId());
/*  75 */     String nocolorname = enchant.substring(4);
/*  76 */     ItemStack item = p.getInventory().getItemInMainHand();
/*  77 */     ItemStack pane = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
/*     */     
/*  79 */     ItemStack one = new ItemStack(Material.EXPERIENCE_BOTTLE);
/*     */     
/*  81 */     ItemMeta im = one.getItemMeta();
/*  82 */     List<String> lore = new ArrayList<>();
/*  83 */     im.setDisplayName(String.valueOf(plugin.getEnchantColor(nocolorname)) + "§l- 1 Levels");
/*  84 */     lore.add("§8Description:");
/*  85 */     lore.add(" ");
/*  86 */     lore.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §7Enchant: ");
/*  87 */     lore.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §f" + enchant);
/*  88 */     lore.add(" ");
/*  89 */     lore.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §7Return: ");
/*  90 */     lore.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §f15% Tokens");
/*  91 */     lore.add(" ");
/*  92 */     lore.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §7Your tokens: ");
/*  93 */     lore.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §f" + tokens.getTokens());
/*  94 */     lore.add(" ");
/*  95 */     lore.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §7§oLeftcick to disenchant 1 level!");
/*  96 */     im.setLore(lore);
/*  97 */     one.setItemMeta(im);
/*     */     
/*  99 */     ItemStack all = new ItemStack(Material.EXPERIENCE_BOTTLE);
/*     */     
/* 101 */     ItemMeta itemMeta1 = all.getItemMeta();
/* 102 */     List<String> list1 = new ArrayList<>();
/* 103 */     itemMeta1.setDisplayName(String.valueOf(plugin.getEnchantColor(nocolorname)) + "§l- All Levels");
/* 104 */     list1.add("§8Description:");
/* 105 */     list1.add(" ");
/* 106 */     list1.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §7Enchant: ");
/* 107 */     list1.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §f" + enchant);
/* 108 */     list1.add(" ");
/* 109 */     list1.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §7Return: ");
/* 110 */     list1.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §f15% Tokens");
/* 111 */     list1.add(" ");
/* 112 */     list1.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §7Your tokens: ");
/* 113 */     list1.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §f" + tokens.getTokens());
/* 114 */     list1.add(" ");
/* 115 */     list1.add(String.valueOf(plugin.getEnchantColor(nocolorname)) + " * §7§oLeftcick to disenchant all levels!");
/* 116 */     itemMeta1.setLore(list1);
/* 117 */     all.setItemMeta(itemMeta1);
/*     */     
/* 119 */     menu.setItem(0, pane);
/* 120 */     menu.setItem(1, pane);
/* 121 */     menu.setItem(2, one);
/* 122 */     menu.setItem(3, pane);
/* 123 */     menu.setItem(4, item);
/* 124 */     menu.setItem(5, pane);
/* 125 */     menu.setItem(6, all);
/* 126 */     menu.setItem(7, pane);
/* 127 */     menu.setItem(8, pane);
/* 128 */     p.openInventory(menu);
/*     */   }
/*     */ }


/* Location:              C:\Users\17hautrivel\Desktop\PrisonEnchants.jar!\me\iLucaH\PrisonEnchants\Enchanter\DisenchantMenu.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */