/*    */ package rightagile.badge.accent.shared.domain.cineroom;
/*    */

import rightagile.badge.accent.shared.domain.NameValueList;
import rightagile.badge.accent.shared.domain.patron.AudienceKey;
import rightagile.badge.accent.shared.util.json.JsonSerializable;
import rightagile.badge.accent.shared.util.json.JsonUtil;

import java.util.Arrays;
import java.util.List;

/*    */
/*    */
/*    */ 
/*    */ 
/*    */ 
/*    */ public class AudienceSdo
/*    */   implements JsonSerializable
/*    */ {
/*    */   private String id;
/*    */   private List<String> roleKeys;
/*    */   private String displayName;
/*    */   private NameValueList nameValues;
/*    */   
/*    */   public void setId(String id) {
/* 21 */     this.id = id; } public void setRoleKeys(List<String> roleKeys) { this.roleKeys = roleKeys; } public void setDisplayName(String displayName) { this.displayName = displayName; } public void setNameValues(NameValueList nameValues) { this.nameValues = nameValues; }
/*    */ 
/*    */   
/*    */   public AudienceSdo() {}
/* 25 */   public String getId() { return this.id; }
/* 26 */   public List<String> getRoleKeys() { return this.roleKeys; }
/* 27 */   public String getDisplayName() { return this.displayName; } public NameValueList getNameValues() {
/* 28 */     return this.nameValues;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public AudienceSdo(String id, List<String> roleKeys, String displayName) {
/* 34 */     this.id = id;
/* 35 */     this.roleKeys = roleKeys;
/* 36 */     this.displayName = displayName;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 41 */     return toJson();
/*    */   }
/*    */ 
/*    */   
/*    */   public static AudienceSdo fromJson(String json) {
/* 46 */     return (AudienceSdo) JsonUtil.fromJson(json, AudienceSdo.class);
/*    */   }
/*    */ 
/*    */   
/*    */   public static AudienceSdo sample() {
/* 51 */     String id = AudienceKey.sample().getKeyString();
/* 52 */     List<String> roleKeys = Arrays.asList(new String[] { "User", "Admin" });
/* 53 */     String displayName = "Steve Jobs";
/*    */     
/* 55 */     return new AudienceSdo(id, roleKeys, displayName);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void main(String[] args) {
/* 64 */     System.out.println(sample());
/*    */   }
/*    */ }


/* Location:              /Users/jmlee90/Documents/mySUNI/deployments/base/accent/accent-0.5.1-20200131.120332-18.jar!/io/naraplatform/share/domain/cineroom/AudienceSdo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */