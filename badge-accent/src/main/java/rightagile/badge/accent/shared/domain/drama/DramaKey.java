/*    */ package rightagile.badge.accent.shared.domain.drama;

import rightagile.badge.accent.shared.util.json.JsonSerializable;
import rightagile.badge.accent.shared.util.json.JsonUtil;
import rightagile.badge.accent.shared.util.numeral36.UsidGen;

/*    */
/*    */
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DramaKey
/*    */   implements JsonSerializable
/*    */ {
/*    */   private String keyString;
/*    */   
/*    */   public void setKeyString(String keyString) {
/* 17 */     this.keyString = keyString;
/*    */   }
/*    */   
/*    */   public String getKeyString() {
/* 21 */     return this.keyString;
/*    */   }
/*    */   public DramaKey() {}
/*    */   protected DramaKey(String keyString) {
/* 25 */     this.keyString = keyString;
/*    */   }
/*    */ 
/*    */   
/*    */   public static DramaKey genKey(long sequence) {
/* 30 */     String dramaId = UsidGen.getStr36(sequence, 4);
/* 31 */     return new DramaKey(dramaId);
/*    */   }
/*    */ 
/*    */   
/*    */   public String getDramaId() {
/* 36 */     return this.keyString;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 41 */     return toJson();
/*    */   }
/*    */ 
/*    */   
/*    */   public static DramaKey fromJson(String json) {
/* 46 */     return (DramaKey) JsonUtil.fromJson(json, DramaKey.class);
/*    */   }
/*    */ 
/*    */   
/*    */   public static DramaKey sample() {
/* 51 */     return genKey(123L);
/*    */   }
/*    */ 
/*    */   
/*    */   public static void main(String[] args) {
/* 56 */     System.out.println(sample());
/*    */   }
/*    */ }


/* Location:              /Users/jmlee90/Documents/mySUNI/deployments/base/accent/accent-0.5.1-20200131.120332-18.jar!/io/naraplatform/share/domain/drama/DramaKey.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */