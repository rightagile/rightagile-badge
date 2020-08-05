/*    */ package rightagile.badge.accent.shared.util.exception;

import rightagile.badge.accent.shared.util.json.JsonSerializable;
import rightagile.badge.accent.shared.util.json.JsonUtil;

/*    */
/*    */
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Developer
/*    */   implements JsonSerializable
/*    */ {
/*    */   private String id;
/*    */   private String name;
/*    */   private String email;
/*    */   private String teamName;
/*    */   
/*    */   public Developer(String id, String name, String email, String teamName) {
/* 24 */     this.id = id;
/* 25 */     this.name = name;
/* 26 */     this.email = email;
/* 27 */     this.teamName = teamName;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 32 */     return toJson();
/*    */   }
/*    */ 
/*    */   
/*    */   public static Developer fromJson(String json) {
/* 37 */     return (Developer) JsonUtil.fromJson(json, Developer.class);
/*    */   }
/*    */ 
/*    */   
/*    */   public static Developer anonymous() {
/* 42 */     return new Developer("no-id", "no-name", "no-email", "no-team");
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static Developer sample() {
/* 52 */     return new Developer("A19-10901", "Steve Jobs", "steve@google.com", "Namoosori labs");
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void main(String[] args) {
/* 62 */     System.out.println(sample());
/*    */   }
/*    */ }


/* Location:              /Users/jmlee90/Documents/mySUNI/deployments/base/accent/accent-0.5.1-20200131.120332-18.jar!/io/naraplatform/share/util/exception/Developer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */