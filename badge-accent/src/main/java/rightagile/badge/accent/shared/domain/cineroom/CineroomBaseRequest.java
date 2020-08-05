/*    */ package rightagile.badge.accent.shared.domain.cineroom;
/*    */ 
/*    */

import rightagile.badge.accent.shared.domain.Offset;
import rightagile.badge.accent.shared.domain.patron.CineroomKey;
import rightagile.badge.accent.shared.util.json.JsonSerializable;
import rightagile.badge.accent.shared.util.json.JsonUtil;

import java.util.ArrayList;
import java.util.List;

/*    */
/*    */ 
/*    */ public class CineroomBaseRequest implements JsonSerializable {
/*    */   private String cineroomId;
/*    */   private Offset offset;
/*    */   private List<String> attributeNames;
/*    */   
/* 15 */   public void setCineroomId(String cineroomId) { this.cineroomId = cineroomId; } public void setOffset(Offset offset) { this.offset = offset; } public void setAttributeNames(List<String> attributeNames) { this.attributeNames = attributeNames; }
/*    */ 
/*    */   
/*    */   public CineroomBaseRequest() {}
/* 19 */   public String getCineroomId() { return this.cineroomId; }
/* 20 */   public Offset getOffset() { return this.offset; } public List<String> getAttributeNames() {
/* 21 */     return this.attributeNames;
/*    */   }
/*    */ 
/*    */   
/*    */   public CineroomBaseRequest(String cineroomId, Offset offset) {
/* 26 */     this.cineroomId = cineroomId;
/* 27 */     this.offset = offset;
/* 28 */     this.attributeNames = new ArrayList<>();
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 33 */     return toJson();
/*    */   }
/*    */ 
/*    */   
/*    */   public static CineroomBaseRequest fromJson(String json) {
/* 38 */     return (CineroomBaseRequest) JsonUtil.fromJson(json, CineroomBaseRequest.class);
/*    */   }
/*    */ 
/*    */   
/*    */   public static CineroomBaseRequest sample() {
/* 43 */     String cineroomId = CineroomKey.sample().getKeyString();
/* 44 */     Offset offset = new Offset(0, 20);
/*    */     
/* 46 */     return new CineroomBaseRequest(cineroomId, offset);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void main(String[] args) {
/* 54 */     System.out.println(sample());
/*    */   }
/*    */ }


/* Location:              /Users/jmlee90/Documents/mySUNI/deployments/base/accent/accent-0.5.1-20200131.120332-18.jar!/io/naraplatform/share/domain/cineroom/CineroomBaseRequest.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */