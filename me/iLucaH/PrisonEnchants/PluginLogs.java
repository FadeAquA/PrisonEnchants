/*    */ package me.iLucaH.PrisonEnchants;
/*    */ 
/*    */ import java.io.BufferedWriter;
/*    */ import java.io.File;
/*    */ import java.io.FileWriter;
/*    */ import java.io.IOException;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Calendar;
/*    */ import java.util.List;
/*    */ import java.util.Scanner;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.ChatColor;
/*    */ import org.bukkit.command.CommandSender;
/*    */ import org.bukkit.entity.Player;
/*    */ 
/*    */ 
/*    */ public class PluginLogs
/*    */ {
/* 19 */   public static String newline = System.getProperty("line.separator");
/*    */ 
/*    */   
/*    */   public static String getWhoSent(CommandSender sender) {
/*    */     String sendername;
/* 24 */     if (sender instanceof Player) {
/* 25 */       Player p = (Player)sender;
/* 26 */       sendername = p.getName();
/*    */     } else {
/* 28 */       sendername = "Console";
/*    */     } 
/* 30 */     return sendername;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static void logMessage(String message) throws IOException {
/* 36 */     String filecontents = "";
/* 37 */     BufferedWriter output = null;
/*    */     try {
/* 39 */       File logs = new File("plugins/PrisonEnchants/PluginLogs.txt");
/* 40 */       if (!logs.exists()) {
/* 41 */         logs.createNewFile();
/*    */       }
/* 43 */       Scanner scan = new Scanner(logs);
/* 44 */       while (scan.hasNextLine()) {
/* 45 */         filecontents = filecontents.concat(String.valueOf(scan.nextLine()) + newline);
/*    */       }
/* 47 */       output = new BufferedWriter(new FileWriter(logs));
/* 48 */       output.write(filecontents);
/* 49 */       output.write("[" + Calendar.getInstance().getTime() + "] [Prison Logs] " + message);
/* 50 */     } catch (IOException e) {
/* 51 */       e.printStackTrace();
/*    */     } finally {
/* 53 */       if (output != null) {
/* 54 */         output.close();
/*    */       }
/*    */     } 
/*    */   }
/*    */   
/*    */   public static List<String> getLogArray() {
/* 60 */     List<String> messages = new ArrayList<>();
/* 61 */     int i = 0;
/*    */     try {
/* 63 */       File file = new File("plugins/PrisonEnchants/PluginLogs.txt");
/* 64 */       Scanner scanner = new Scanner(file);
/* 65 */       while (scanner.hasNextLine()) {
/* 66 */         i++;
/* 67 */         messages.add(scanner.nextLine());
/* 68 */         if (i > 750) {
/*    */           break;
/*    */         }
/*    */       } 
/* 72 */       scanner.close();
/* 73 */     } catch (Exception e) {
/* 74 */       Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "PluginLogs file not found!");
/*    */     } 
/* 76 */     return messages;
/*    */   }
/*    */   
/*    */   public static List<String> feedbackLogs(int page) {
/* 80 */     List<String> messages = getLogArray();
/* 81 */     int i = page * 15;
/* 82 */     List<String> m = messages.subList(i, i + 15);
/* 83 */     return m;
/*    */   }
/*    */ }


/* Location:              C:\Users\17hautrivel\Desktop\PrisonEnchants.jar!\me\iLucaH\PrisonEnchants\PluginLogs.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */