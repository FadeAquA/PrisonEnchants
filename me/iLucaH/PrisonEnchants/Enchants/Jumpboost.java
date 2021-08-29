/*    */ package me.iLucaH.PrisonEnchants.Enchants;
/*    */ 
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.player.PlayerInteractEvent;
/*    */ import org.bukkit.potion.PotionEffect;
/*    */ import org.bukkit.potion.PotionEffectType;
/*    */ 
/*    */ public class Jumpboost
/*    */   implements Listener
/*    */ {
/*    */   @EventHandler
/*    */   public void PlayerInteractEvent(PlayerInteractEvent e) {
/* 16 */     Player p = e.getPlayer();
/* 17 */     if (p.getInventory().getItemInMainHand().getType() == null || 
/* 18 */       p.getInventory().getItemInMainHand().getType() == Material.AIR)
/*    */       return; 
/* 20 */     if (p.getInventory().getItemInMainHand().hasItemMeta())
/*    */     {
/* 22 */       if (p.getInventory().getItemInMainHand().getItemMeta().hasLore())
/*    */       {
/* 24 */         if (p.getInventory().getItemInMainHand().getItemMeta().getLore()
/* 25 */           .contains("§bJumpboost 1")) {
/* 26 */           p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 300, 0));
/* 27 */         } else if (p.getInventory().getItemInMainHand().getItemMeta().getLore()
/* 28 */           .contains("§bJumpboost 2")) {
/* 29 */           p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 300, 1));
/* 30 */         } else if (p.getInventory().getItemInMainHand().getItemMeta().getLore()
/* 31 */           .contains("§bJumpboost 3")) {
/* 32 */           p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 300, 2));
/* 33 */         } else if (p.getInventory().getItemInMainHand().getItemMeta().getLore()
/* 34 */           .contains("§bJumpboost 4")) {
/* 35 */           p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 300, 3));
/* 36 */         } else if (p.getInventory().getItemInMainHand().getItemMeta().getLore()
/* 37 */           .contains("§bJumpboost 5")) {
/* 38 */           p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 300, 4));
/*    */         } 
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\17hautrivel\Desktop\PrisonEnchants.jar!\me\iLucaH\PrisonEnchants\Enchants\Jumpboost.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */