/*    */ package me.iLucaH.PrisonEnchants.Enchanter;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import java.util.Set;
/*    */ import me.iLucaH.PrisonEnchants.MainClass;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.ChatColor;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.command.Command;
/*    */ import org.bukkit.command.CommandExecutor;
/*    */ import org.bukkit.command.CommandSender;
/*    */ import org.bukkit.enchantments.Enchantment;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.inventory.Inventory;
/*    */ import org.bukkit.inventory.ItemFlag;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ import org.bukkit.inventory.meta.ItemMeta;
/*    */ 
/*    */ 
/*    */ public class Disenchanter
/*    */   implements CommandExecutor
/*    */ {
/* 24 */   private static MainClass plugin = MainClass.plugin;
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
/* 29 */     if (sender instanceof Player) {
/* 30 */       Player p = (Player)sender;
/* 31 */       if (p.getInventory().getItemInMainHand().getType().equals(Material.DIAMOND_PICKAXE) || 
/* 32 */         p.getInventory().getItemInMainHand().getType().equals(Material.IRON_PICKAXE) || 
/* 33 */         p.getInventory().getItemInMainHand().getType().equals(Material.STONE_PICKAXE)) {
/* 34 */         int inventorysize = 9;
/*    */         
/* 36 */         Set<String> enchants = plugin.getEnchants().keySet();
/*    */         
/* 38 */         int totalenchants = enchants.size();
/* 39 */         if (totalenchants < 9) {
/* 40 */           inventorysize = 9;
/* 41 */         } else if (totalenchants > 27) {
/* 42 */           inventorysize = 36;
/* 43 */         } else if (totalenchants > 18) {
/* 44 */           inventorysize = 27;
/* 45 */         } else if (totalenchants > 9) {
/* 46 */           inventorysize = 18;
/*    */         } else {
/* 48 */           inventorysize = 45;
/*    */         } 
/*    */ 
/*    */         
/* 52 */         Inventory menu = Bukkit.createInventory(null, inventorysize, "Disenchantment Menu");
/* 53 */         for (String str : enchants) {
/* 54 */           ItemStack item = new ItemStack(Material.BOOK);
/* 55 */           ItemMeta im = item.getItemMeta();
/* 56 */           item.addUnsafeEnchantment(Enchantment.DIG_SPEED, 1);
/* 57 */           List<String> lore = new ArrayList<>();
/* 58 */           im.setDisplayName(
/* 59 */               String.valueOf(plugin.getEnchantColor(str)) + ChatColor.translateAlternateColorCodes('&', "&l") + str);
/* 60 */           lore.add(String.valueOf(plugin.getEnchantColor(str)) + "Description:");
/* 61 */           lore.add(" ");
/* 62 */           lore.add(String.valueOf(plugin.getEnchantColor(str)) + " * §7Disenchant your pickaxe to remove unwanted items!");
/* 63 */           lore.add(String.valueOf(plugin.getEnchantColor(str)) + " * §8Return: §715% Tokens");
/* 64 */           lore.add(" ");
/* 65 */           lore.add(String.valueOf(plugin.getEnchantColor(str)) + " * §7§oLeftclick to disenchant");
/* 66 */           im.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
/* 67 */           im.setLore(lore);
/* 68 */           item.setItemMeta(im);
/* 69 */           menu.addItem(new ItemStack[] { item });
/*    */         } 
/* 71 */         p.openInventory(menu);
/* 72 */         return true;
/*    */       } 
/* 74 */       sender.sendMessage("§cYou must be holding a pickaxe!");
/*    */     } else {
/*    */       
/* 77 */       sender.sendMessage("You must be a player to execute this command!");
/*    */     } 
/* 79 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Users\17hautrivel\Desktop\PrisonEnchants.jar!\me\iLucaH\PrisonEnchants\Enchanter\Disenchanter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */