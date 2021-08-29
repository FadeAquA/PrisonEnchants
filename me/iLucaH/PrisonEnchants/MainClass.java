/*     */ package me.iLucaH.PrisonEnchants;
/*     */ 
/*     */ import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
/*     */ import java.io.IOException;
/*     */ import java.util.Calendar;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.UUID;
/*     */ import me.iLucaH.PrisonEnchants.Enchanter.Disenchanter;
/*     */ import me.iLucaH.PrisonEnchants.Enchanter.EnchanterMenu;
/*     */ import me.iLucaH.PrisonEnchants.Enchanter.EnventoryListener;
/*     */ import me.iLucaH.PrisonEnchants.Enchants.Charity;
/*     */ import me.iLucaH.PrisonEnchants.Enchants.Earthquake;
/*     */ import me.iLucaH.PrisonEnchants.Enchants.EnchantMenu;
/*     */ import me.iLucaH.PrisonEnchants.Enchants.Haste;
/*     */ import me.iLucaH.PrisonEnchants.Enchants.Jumpboost;
/*     */ import me.iLucaH.PrisonEnchants.Enchants.Keyalls;
/*     */ import me.iLucaH.PrisonEnchants.Enchants.Laser;
/*     */ import me.iLucaH.PrisonEnchants.Enchants.Lucky;
/*     */ import me.iLucaH.PrisonEnchants.Enchants.Moneygreed;
/*     */ import me.iLucaH.PrisonEnchants.Enchants.Nuker;
/*     */ import me.iLucaH.PrisonEnchants.Enchants.Orbgreed;
/*     */ import me.iLucaH.PrisonEnchants.Enchants.Shockwave;
/*     */ import me.iLucaH.PrisonEnchants.Enchants.Souls;
/*     */ import me.iLucaH.PrisonEnchants.Enchants.Speed;
/*     */ import me.iLucaH.PrisonEnchants.Tokens.Tokens;
/*     */ import me.iLucaH.PrisonEnchants.Tokens.TokensCommands;
/*     */ import me.iLucaH.PrisonEnchants.Tokens.TokensListener;
/*     */ import net.milkbowl.vault.economy.Economy;
/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.command.CommandExecutor;
/*     */ import org.bukkit.event.Listener;
/*     */ import org.bukkit.plugin.Plugin;
/*     */ import org.bukkit.plugin.RegisteredServiceProvider;
/*     */ import org.bukkit.plugin.java.JavaPlugin;
/*     */ 
/*     */ public class MainClass
/*     */   extends JavaPlugin
/*     */ {
/*     */   public static Economy economy;
/*     */   public static MainClass plugin;
/*     */   public WorldGuardPlugin worldguardplugin;
/*  43 */   public static Map<String, String> enchants = new HashMap<>();
/*     */   
/*     */   public void onEnable() {
/*  46 */     if (!setupEconomy()) {
/*  47 */       getServer().getConsoleSender().sendMessage("§6To use: §ePRISON ENCHANTS");
/*  48 */       getServer().getConsoleSender().sendMessage("§6You need the plugin:§e VAULT");
/*  49 */       Bukkit.shutdown();
/*     */     } 
/*  51 */     plugin = this;
/*  52 */     loadConfig();
/*     */     
/*  54 */     registerCommands();
/*     */     
/*  56 */     registerEvents();
/*     */     
/*  58 */     registerCustomEnchants();
/*  59 */     Bukkit.getServer().getConsoleSender().sendMessage("§6[§e" + Calendar.getInstance().getTime() + 
/*  60 */         "§6] [§ePrison Logs§6] " + "§6Plugin <PrisonEnchants> Enabled");
/*     */     try {
/*  62 */       PluginLogs.logMessage("Plugin <PrisonEnchants> Enabled");
/*  63 */     } catch (IOException e) {
/*  64 */       e.printStackTrace();
/*     */     } 
/*  66 */     if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
/*  67 */       (new Placeholders(this)).register();
/*     */     }
/*     */   }
/*     */   
/*     */   public void onDisable() {
/*  72 */     Bukkit.getServer().getConsoleSender().sendMessage("§6[§e" + Calendar.getInstance().getTime() + 
/*  73 */         "§6] [§ePrison Logs§6] " + "§6Plugin <PrisonEnchants> Disabled");
/*     */     try {
/*  75 */       PluginLogs.logMessage("Plugin <PrisonEnchants> Disabled");
/*  76 */     } catch (IOException e) {
/*  77 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void loadConfig() {
/*  82 */     getConfig().options().copyDefaults(true);
/*  83 */     saveConfig();
/*     */   }
/*     */   
/*     */   public WorldGuardPlugin getWorldGuard() {
/*  87 */     Plugin plugin = getServer().getPluginManager().getPlugin("WorldGuard");
/*  88 */     if (plugin == null || !(plugin instanceof WorldGuardPlugin)) {
/*  89 */       return null;
/*     */     }
/*  91 */     return (WorldGuardPlugin)plugin;
/*     */   }
/*     */ 
/*     */   
/*     */   public void registerEvents() {
/*  96 */     getServer().getPluginManager().registerEvents(new EventsClass(), (Plugin)this);
/*  97 */     getServer().getPluginManager().registerEvents((Listener)new Speed(), (Plugin)this);
/*  98 */     getServer().getPluginManager().registerEvents((Listener)new Haste(), (Plugin)this);
/*  99 */     getServer().getPluginManager().registerEvents((Listener)new Nuker(), (Plugin)this);
/* 100 */     getServer().getPluginManager().registerEvents((Listener)new Earthquake(), (Plugin)this);
/* 101 */     getServer().getPluginManager().registerEvents((Listener)new Laser(), (Plugin)this);
/* 102 */     getServer().getPluginManager().registerEvents((Listener)new Moneygreed(), (Plugin)this);
/* 103 */     getServer().getPluginManager().registerEvents((Listener)new Orbgreed(), (Plugin)this);
/* 104 */     getServer().getPluginManager().registerEvents((Listener)new Shockwave(), (Plugin)this);
/* 105 */     getServer().getPluginManager().registerEvents((Listener)new Charity(), (Plugin)this);
/* 106 */     getServer().getPluginManager().registerEvents((Listener)new Keyalls(), (Plugin)this);
/* 107 */     getServer().getPluginManager().registerEvents((Listener)new Lucky(), (Plugin)this);
/* 108 */     getServer().getPluginManager().registerEvents((Listener)new Jumpboost(), (Plugin)this);
/* 109 */     getServer().getPluginManager().registerEvents((Listener)new Souls(), (Plugin)this);
/* 110 */     getServer().getPluginManager().registerEvents((Listener)new TokensListener(), (Plugin)this);
/* 111 */     getServer().getPluginManager().registerEvents((Listener)new EnventoryListener(), (Plugin)this);
/*     */   }
/*     */ 
/*     */   
/*     */   public void registerCommands() {
/* 116 */     getCommand("tokens").setExecutor((CommandExecutor)new TokensCommands());
/* 117 */     getCommand("enchanter").setExecutor((CommandExecutor)new EnchantMenu());
/* 118 */     getCommand("prisonenchants").setExecutor(new ModifierCommand());
/* 119 */     getCommand("enchantshop").setExecutor((CommandExecutor)new EnchanterMenu());
/* 120 */     getCommand("disenchanter").setExecutor((CommandExecutor)new Disenchanter());
/*     */   }
/*     */   
/*     */   private boolean setupEconomy() {
/* 124 */     RegisteredServiceProvider<Economy> economyProvider = getServer().getServicesManager()
/* 125 */       .getRegistration(Economy.class);
/* 126 */     if (economyProvider != null) {
/* 127 */       economy = (Economy)economyProvider.getProvider();
/*     */     }
/* 129 */     return (economy != null);
/*     */   }
/*     */   
/*     */   public static void registerCustomEnchants() {
/* 133 */     enchants.put("Fortune", "§7");
/* 134 */     enchants.put("Efficiency", "§7");
/* 135 */     enchants.put("Speed", "§f");
/* 136 */     enchants.put("Haste", "§f");
/* 137 */     enchants.put("Lucky", "§b");
/* 138 */     enchants.put("Jumpboost", "§b");
/* 139 */     enchants.put("Laser", "§4");
/* 140 */     enchants.put("Nuker", "§4");
/* 141 */     enchants.put("Layer", "§c");
/* 142 */     enchants.put("Shockwave", "§c");
/* 143 */     enchants.put("Tokengreed", "§a");
/* 144 */     enchants.put("Moneygreed", "§a");
/* 145 */     enchants.put("Charity", "§e");
/* 146 */     enchants.put("Keyalls", "§e");
/* 147 */     enchants.put("Souls", "§3");
/*     */   }
/*     */   
/*     */   public static void registerCustomEnchant(String name, String color) {
/* 151 */     enchants.put(name, color);
/*     */   }
/*     */   
/*     */   public String getEnchantColor(String enchant) {
/* 155 */     return enchants.get(enchant);
/*     */   }
/*     */   
/*     */   public Map<String, String> getEnchants() {
/* 159 */     return enchants;
/*     */   }
/*     */   
/*     */   public Long getTokenBal(UUID uuid) {
/* 163 */     Tokens tokens = new Tokens(uuid);
/* 164 */     return tokens.getTokens();
/*     */   }
/*     */ }


/* Location:              C:\Users\17hautrivel\Desktop\PrisonEnchants.jar!\me\iLucaH\PrisonEnchants\MainClass.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */