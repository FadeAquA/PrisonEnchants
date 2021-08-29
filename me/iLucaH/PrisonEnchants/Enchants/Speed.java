/*    */ package me.iLucaH.PrisonEnchants.Enchants;
/*    */ 
/*    */ import org.bukkit.ChatColor;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.player.PlayerInteractEvent;
/*    */ import org.bukkit.potion.PotionEffect;
/*    */ import org.bukkit.potion.PotionEffectType;
/*    */ 
/*    */ public class Speed
/*    */   implements Listener
/*    */ {
/*    */   @EventHandler
/*    */   public void PlayerInteractEvent(PlayerInteractEvent e) {
/* 17 */     Player p = e.getPlayer();
/* 18 */     if (p.getInventory().getItemInMainHand().getType() == null || 
/* 19 */       p.getInventory().getItemInMainHand().getType() == Material.AIR)
/*    */       return; 
/* 21 */     if (p.getInventory().getItemInMainHand().hasItemMeta())
/*    */     {
/* 23 */       if (p.getInventory().getItemInMainHand().getItemMeta().hasLore())
/*    */       {
/* 25 */         if (p.getInventory().getItemInMainHand().getItemMeta().getLore().contains(ChatColor.WHITE + "Speed 1")) {
/* 26 */           p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 300, 0));
/* 27 */         } else if (p.getInventory().getItemInMainHand().getItemMeta().getLore()
/* 28 */           .contains(ChatColor.WHITE + "Speed 2")) {
/* 29 */           p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 300, 1));
/* 30 */         } else if (p.getInventory().getItemInMainHand().getItemMeta().getLore()
/* 31 */           .contains(ChatColor.WHITE + "Speed 3")) {
/* 32 */           p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 300, 2));
/* 33 */         } else if (p.getInventory().getItemInMainHand().getItemMeta().getLore()
/* 34 */           .contains(ChatColor.WHITE + "Speed 4")) {
/* 35 */           p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 300, 3));
/* 36 */         } else if (p.getInventory().getItemInMainHand().getItemMeta().getLore()
/* 37 */           .contains(ChatColor.WHITE + "Speed 5")) {
/* 38 */           p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 300, 4));
/*    */         } 
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\17hautrivel\Desktop\PrisonEnchants.jar!\me\iLucaH\PrisonEnchants\Enchants\Speed.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */