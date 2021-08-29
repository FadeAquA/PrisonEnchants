/*     */ package me.iLucaH.PrisonEnchants;
/*     */ 
/*     */ import me.iLucaH.PrisonEnchants.Tokens.Tokens;
/*     */ import org.bukkit.Material;
/*     */ import org.bukkit.Sound;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.event.EventHandler;
/*     */ import org.bukkit.event.Listener;
/*     */ import org.bukkit.event.block.Action;
/*     */ import org.bukkit.event.inventory.InventoryClickEvent;
/*     */ import org.bukkit.event.player.PlayerCommandPreprocessEvent;
/*     */ import org.bukkit.event.player.PlayerInteractEvent;
/*     */ import org.bukkit.event.player.PlayerJoinEvent;
/*     */ import org.bukkit.inventory.Inventory;
/*     */ import org.bukkit.inventory.ItemStack;
/*     */ 
/*     */ public class EventsClass
/*     */   implements Listener
/*     */ {
/*  20 */   private static MainClass plugin = MainClass.plugin;
/*     */   
/*     */   @EventHandler
/*     */   public void onJoin(PlayerJoinEvent e) {
/*  24 */     Player player = e.getPlayer();
/*     */     
/*  26 */     if (!player.hasPlayedBefore()) {
/*  27 */       Tokens tokens = new Tokens(player.getUniqueId());
/*  28 */       tokens.createPlayerConfig();
/*  29 */       tokens.createPlayerDefaults();
/*  30 */       tokens.addTokens(Long.valueOf(plugin.getConfig().getLong("Tokens.Joinamount")));
/*  31 */       tokens.savePlayerConfig();
/*     */     } 
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void preProcessCommand(PlayerCommandPreprocessEvent event) {
/*  37 */     if (event.getMessage().equalsIgnoreCase("/enchanter")) {
/*  38 */       Player p = event.getPlayer();
/*  39 */       if (p.getInventory().getItemInMainHand().getType() == Material.DIAMOND_PICKAXE || 
/*  40 */         p.getInventory().getItemInMainHand().getType() == Material.GOLDEN_PICKAXE || 
/*  41 */         p.getInventory().getItemInMainHand().getType() == Material.STONE_PICKAXE || 
/*  42 */         p.getInventory().getItemInMainHand().getType() == Material.WOODEN_PICKAXE) {
/*  43 */         event.setCancelled(false);
/*     */       } else {
/*  45 */         p.sendMessage("§c * §7You must be holding a pickaxe!");
/*  46 */         event.setCancelled(true);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @EventHandler
/*     */   public void rightClickEvent(PlayerInteractEvent e) {
/*  55 */     Action action = e.getAction();
/*  56 */     Player p = e.getPlayer();
/*  57 */     ItemStack item = p.getInventory().getItemInMainHand();
/*  58 */     if ((action.equals(Action.RIGHT_CLICK_AIR) || action.equals(Action.RIGHT_CLICK_BLOCK)) && 
/*  59 */       item != null && item.getType() == Material.PAPER && 
/*  60 */       item.getItemMeta().getDisplayName().equals(Utils.getDominantTokenColor() + "Token Note")) {
/*  61 */       for (String str : item.getItemMeta().getLore()) {
/*  62 */         if (str.contains("Amount:")) {
/*  63 */           Long amount = Long.valueOf(str.split(" ")[3].substring(2));
/*  64 */           amount = Long.valueOf(amount.longValue() * item.getAmount());
/*  65 */           p.setItemInHand(null);
/*  66 */           Tokens tokens = new Tokens(p.getUniqueId());
/*  67 */           tokens.addTokens(amount);
/*  68 */           tokens.savePlayerConfig();
/*  69 */           p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0F, 1.0F);
/*  70 */           p.sendMessage("§a§l + " + plugin.getConfig().getString("Tokens.Symbol") + amount + " §7(Deposited)");
/*     */           break;
/*     */         } 
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @EventHandler
/*     */   public void InvenClick(InventoryClickEvent event) {
/*  82 */     Inventory open = event.getClickedInventory();
/*  83 */     ItemStack item = event.getCurrentItem();
/*     */     
/*  85 */     if (open == null) {
/*     */       return;
/*     */     }
/*  88 */     if (event.getView().getTitle().contains("Enchant Menu")) {
/*  89 */       event.setCancelled(true);
/*     */       
/*  91 */       if (item == null || !item.hasItemMeta()) {
/*     */         return;
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void playerClickEvent(PlayerInteractEvent e) {
/*  99 */     Action action = e.getAction();
/* 100 */     Player p = e.getPlayer();
/* 101 */     ItemStack item = p.getInventory().getItemInMainHand();
/* 102 */     if ((action.equals(Action.RIGHT_CLICK_AIR) || action.equals(Action.RIGHT_CLICK_BLOCK)) && 
/* 103 */       item != null && item.getType() == Material.DIAMOND_PICKAXE)
/* 104 */       p.performCommand("enchanter"); 
/*     */   }
/*     */ }


/* Location:              C:\Users\17hautrivel\Desktop\PrisonEnchants.jar!\me\iLucaH\PrisonEnchants\EventsClass.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */