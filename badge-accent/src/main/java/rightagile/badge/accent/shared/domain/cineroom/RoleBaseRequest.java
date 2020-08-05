/*    */ package rightagile.badge.accent.shared.domain.cineroom;
/*    */

import rightagile.badge.accent.shared.domain.Offset;
import rightagile.badge.accent.shared.domain.patron.CineroomKey;
import rightagile.badge.accent.shared.util.json.JsonSerializable;
import rightagile.badge.accent.shared.util.json.JsonUtil;

import java.util.ArrayList;
import java.util.List;

/*    */
/*    */
/*    */ 
/*    */ public class RoleBaseRequest implements JsonSerializable {
/*    */   private String cineroomId;
/*    */   private String roleKey;
/*    */   private Offset offset;
/*    */   private List<String> attributeNames;
/*    */   
/* 15 */   public void setCineroomId(String cineroomId) { this.cineroomId = cineroomId; } public void setRoleKey(String roleKey) { this.roleKey = roleKey; } public void setOffset(Offset offset) { this.offset = offset; } public void setAttributeNames(List<String> attributeNames) { this.attributeNames = attributeNames; }
/*    */ 
/*    */   
/*    */   public RoleBaseRequest() {}
/* 19 */   public String getCineroomId() { return this.cineroomId; }
/* 20 */   public String getRoleKey() { return this.roleKey; }
/* 21 */   public Offset getOffset() { return this.offset; } public List<String> getAttributeNames() {
/* 22 */     return this.attributeNames;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public RoleBaseRequest(String cineroomId, String roleKey, Offset offset) {
/* 28 */     this.cineroomId = cineroomId;
/* 29 */     this.roleKey = roleKey;
/* 30 */     this.offset = offset;
/* 31 */     this.attributeNames = new ArrayList<>();
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 36 */     return toJson();
/*    */   }
/*    */ 
/*    */   
/*    */   public static RoleBaseRequest fromJson(String json) {
/* 41 */     return (RoleBaseRequest) JsonUtil.fromJson(json, RoleBaseRequest.class);
/*    */   }
/*    */ 
/*    */   
/*    */   public static RoleBaseRequest sample() {
/* 46 */     String cineroomId = CineroomKey.sample().getKeyString();
/* 47 */     String roleKey = "Admin";
/* 48 */     Offset offset = new Offset(0, 20);
/*    */     
/* 50 */     return new RoleBaseRequest(cineroomId, roleKey, offset);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void main(String[] args) {
/* 59 */     System.out.println(sample());
/*    */   }
/*    */ }


/* Location:              /Users/jmlee90/Documents/mySUNI/deployments/base/accent/accent-0.5.1-20200131.120332-18.jar!/io/naraplatform/share/domain/cineroom/RoleBaseRequest.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */