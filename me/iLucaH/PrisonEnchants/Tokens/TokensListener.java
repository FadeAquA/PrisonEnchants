/*    */ package me.iLucaH.PrisonEnchants.Tokens;
/*    */ 
/*    */ import me.iLucaH.PrisonEnchants.MainClass;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.block.BlockBreakEvent;
/*    */ 
/*    */ public class TokensListener
/*    */   implements Listener {
/* 11 */   private static MainClass plugin = MainClass.plugin;
/*    */   
/*    */   @EventHandler
/*    */   public void onBlockBreak(BlockBreakEvent e) {
/* 15 */     Player p = e.getPlayer();
/* 16 */     Tokens tokens = new Tokens(p.getUniqueId());
/* 17 */     tokens.addTokens(Long.valueOf(plugin.getConfig().getLong("Tokens.Tokensperblock")));
/* 18 */     tokens.savePlayerConfig();
/*    */   }
/*    */ }


/* Location:              C:\Users\17hautrivel\Desktop\PrisonEnchants.jar!\me\iLucaH\PrisonEnchants\Tokens\TokensListener.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */