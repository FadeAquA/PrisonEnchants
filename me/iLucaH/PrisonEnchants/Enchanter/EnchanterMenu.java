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
/*    */ public class EnchanterMenu
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
/* 52 */         Inventory menu = Bukkit.createInventory(null, inventorysize, "Enchantment Menu");
/* 53 */         for (String str : enchants) {
/* 54 */           ItemStack item = new ItemStack(Material.BOOK);
/* 55 */           ItemMeta im = item.getItemMeta();
/* 56 */           List<String> lore = new ArrayList<>();
/* 57 */           im.setDisplayName(
/* 58 */               String.valueOf(plugin.getEnchantColor(str)) + ChatColor.translateAlternateColorCodes('&', "&l") + str);
/* 59 */           lore.add("§8Description:");
/* 60 */           lore.add(" ");
/* 61 */           lore.add("§8 * §7" + plugin.getConfig().getString("Enchants." + str + ".Enchantdescription"));
/* 62 */           lore.add(" ");
/* 63 */           lore.add("§8 * §fPrice: " + plugin.getConfig().getString("Tokens.Symbol") + 
/* 64 */               plugin.getConfig().getInt("Enchants." + str + ".Enchantprice"));
/* 65 */           lore.add("§8 * §fMax Level: " + plugin.getConfig().getInt("Enchants." + str + ".Maxlevel"));
/* 66 */           lore.add(" ");
/* 67 */           lore.add("§8 * §7§oLeftclick to enchant");
/* 68 */           lore.add("§8 * §7§oRightclick to enchant max levels");
/* 69 */           item.addUnsafeEnchantment(Enchantment.DIG_SPEED, 1);
/* 70 */           im.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
/* 71 */           im.setLore(lore);
/* 72 */           item.setItemMeta(im);
/* 73 */           menu.addItem(new ItemStack[] { item });
/*    */         } 
/* 75 */         p.openInventory(menu);
/* 76 */         return true;
/*    */       } 
/* 78 */       sender.sendMessage("§cYou must be holding a pickaxe!");
/*    */     } else {
/*    */       
/* 81 */       sender.sendMessage("You must be a player to execute this command!");
/*    */     } 
/* 83 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Users\17hautrivel\Desktop\PrisonEnchants.jar!\me\iLucaH\PrisonEnchants\Enchanter\EnchanterMenu.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */