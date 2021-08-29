/*     */ package me.iLucaH.PrisonEnchants.Enchants;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import me.iLucaH.PrisonEnchants.MainClass;
/*     */ import me.iLucaH.PrisonEnchants.Tokens.Tokens;
/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.Material;
/*     */ import org.bukkit.command.Command;
/*     */ import org.bukkit.command.CommandExecutor;
/*     */ import org.bukkit.command.CommandSender;
/*     */ import org.bukkit.enchantments.Enchantment;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.inventory.Inventory;
/*     */ import org.bukkit.inventory.ItemFlag;
/*     */ import org.bukkit.inventory.ItemStack;
/*     */ import org.bukkit.inventory.meta.ItemMeta;
/*     */ 
/*     */ public class EnchantMenu
/*     */   implements CommandExecutor
/*     */ {
/*  22 */   private static MainClass plugin = MainClass.plugin;
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
/*  27 */     if (sender instanceof Player) {
/*  28 */       Player p = (Player)sender;
/*  29 */       if (p.getInventory().getItemInMainHand().getType().equals(Material.DIAMOND_PICKAXE) || 
/*  30 */         p.getInventory().getItemInMainHand().getType().equals(Material.IRON_PICKAXE) || 
/*  31 */         p.getInventory().getItemInMainHand().getType().equals(Material.STONE_PICKAXE)) {
/*     */         
/*  33 */         Tokens tokens = new Tokens(p.getUniqueId());
/*  34 */         Inventory inv = Bukkit.createInventory(null, 27, "Enchant Menu");
/*  35 */         String tokenbal = String.valueOf(tokens.getTokens());
/*  36 */         ItemStack item = p.getInventory().getItemInMainHand();
/*  37 */         ItemStack blackglass = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
/*  38 */         ItemStack whiteglass = new ItemStack(Material.WHITE_STAINED_GLASS_PANE);
/*  39 */         ItemStack blueglass = new ItemStack(Material.BLUE_STAINED_GLASS_PANE);
/*     */         
/*  41 */         ItemStack enchantbook = new ItemStack(Material.BOOK);
/*     */         
/*  43 */         ItemMeta meta = enchantbook.getItemMeta();
/*  44 */         meta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
/*  45 */         meta.setDisplayName("§b§lEnchanter");
/*  46 */         meta.addEnchant(Enchantment.DIG_SPEED, 1, true);
/*  47 */         List<String> lore = new ArrayList<>();
/*  48 */         lore.add("§b * §7Enchant your pickaxe to: ");
/*  49 */         lore.add("§b   - §f§oUnlock new mining possibilities!");
/*  50 */         lore.add("§b   - §f§oMake more money and tokens!");
/*  51 */         lore.add("§b   - §f§oUnlock awesome rewards!");
/*  52 */         lore.add(" ");
/*  53 */         lore.add("§b * §7Your tokens: §b" + plugin.getConfig().getString("Tokens.Symbol") + tokenbal);
/*  54 */         lore.add(" ");
/*  55 */         lore.add("§b * §7§oLeftclick to purchase custom enchants!");
/*  56 */         meta.setLore(lore);
/*  57 */         enchantbook.setItemMeta(meta);
/*     */ 
/*     */         
/*  60 */         ItemStack disenchantbook = new ItemStack(Material.ANVIL);
/*     */         
/*  62 */         ItemMeta itemMeta1 = disenchantbook.getItemMeta();
/*  63 */         itemMeta1.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
/*  64 */         itemMeta1.setDisplayName("§c§lDisenchanter");
/*  65 */         disenchantbook.addUnsafeEnchantment(Enchantment.DIG_SPEED, 1);
/*  66 */         List<String> list1 = new ArrayList<>();
/*  67 */         list1.add("§c * §7Disenchant your pickaxe to: ");
/*  68 */         list1.add("§c   - §f§oRemove unwanted enchants!");
/*  69 */         list1.add("§c   - §f§oReceive 15% of your orbs back!");
/*  70 */         list1.add(" ");
/*  71 */         list1.add("§c * §7Your tokens: §c" + plugin.getConfig().getString("Tokens.Symbol") + tokenbal);
/*  72 */         list1.add(" ");
/*  73 */         list1.add("§c * §7§oLeftclick to disenchant custom enchants!");
/*  74 */         itemMeta1.setLore(list1);
/*  75 */         disenchantbook.setItemMeta(itemMeta1);
/*  76 */         disenchantbook.addUnsafeEnchantment(Enchantment.DIG_SPEED, 1);
/*     */ 
/*     */         
/*  79 */         fillInventory(inv, blackglass);
/*  80 */         inv.setItem(13, item);
/*  81 */         inv.setItem(11, enchantbook);
/*  82 */         inv.setItem(15, disenchantbook);
/*  83 */         inv.setItem(1, whiteglass);
/*  84 */         inv.setItem(3, whiteglass);
/*  85 */         inv.setItem(5, whiteglass);
/*  86 */         inv.setItem(7, whiteglass);
/*  87 */         inv.setItem(19, whiteglass);
/*  88 */         inv.setItem(21, whiteglass);
/*  89 */         inv.setItem(23, whiteglass);
/*  90 */         inv.setItem(25, whiteglass);
/*  91 */         inv.setItem(9, blueglass);
/*  92 */         inv.setItem(12, blueglass);
/*  93 */         inv.setItem(14, blueglass);
/*  94 */         inv.setItem(17, blueglass);
/*     */         
/*  96 */         p.openInventory(inv);
/*  97 */         return true;
/*     */       } 
/*  99 */       sender.sendMessage("§cYou must be holding a pickaxe!");
/*     */     } 
/*     */     
/* 102 */     return false;
/*     */   }
/*     */   
/*     */   public void fillInventory(Inventory inv, ItemStack item) {
/* 106 */     for (int i = 0; i < inv.getSize(); i++) {
/* 107 */       if (inv.getItem(i) == null || inv.getItem(i).getType().equals(Material.AIR))
/* 108 */         inv.setItem(i, item); 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\17hautrivel\Desktop\PrisonEnchants.jar!\me\iLucaH\PrisonEnchants\Enchants\EnchantMenu.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */