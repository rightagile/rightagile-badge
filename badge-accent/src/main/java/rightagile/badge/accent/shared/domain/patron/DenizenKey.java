/*    */ package rightagile.badge.accent.shared.domain.patron;

import rightagile.badge.accent.shared.domain.tenant.CitizenKey;
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
/*    */ 
/*    */ 
/*    */ public class DenizenKey
/*    */   extends PatronKey
/*    */ {
/*    */   public DenizenKey() {}
/*    */   
/*    */   public DenizenKey(String metroKeyString) {
/* 23 */     super(metroKeyString, PatronType.Denizen);
/*    */   }
/*    */ 
/*    */   
/*    */   public DenizenKey(CitizenKey citizenKey) {
/* 28 */     this(citizenKey.getKeyString());
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 33 */     return toJson();
/*    */   }
/*    */ 
/*    */   
/*    */   public static DenizenKey fromJson(String json) {
/* 38 */     return (DenizenKey) JsonUtil.fromJson(json, DenizenKey.class);
/*    */   }
/*    */ 
/*    */   
/*    */   public static DenizenKey fromKeyString(String keyString) {
/* 43 */     return new DenizenKey(keyString);
/*    */   }
/*    */ 
/*    */   
/*    */   public PavilionKey genPavilionKey() {
/* 48 */     return new PavilionKey(genPavilionKey(getKeyString()));
/*    */   }
/*    */ 
/*    */   
/*    */   public static String genPavilionKey(String denizenKeyString) {
/* 53 */     return denizenKeyString.substring(denizenKeyString.indexOf('@') + 1);
/*    */   }
/*    */ 
/*    */   
/*    */   public String genSequencePart() {
/* 58 */     return getKeyString().substring(0, getKeyString().indexOf('@'));
/*    */   }
/*    */ 
/*    */   
/*    */   public String getSequenceStringAs36() {
/* 63 */     return getKeyString().substring(0, getKeyString().indexOf('@'));
/*    */   }
/*    */ 
/*    */   
/*    */   public static DenizenKey sample() {
/* 68 */     CitizenKey citizenKey = CitizenKey.sample();
/* 69 */     return new DenizenKey(citizenKey.getKeyString());
/*    */   }
/*    */ 
/*    */   
/*    */   public static void main(String[] args) {
/* 74 */     System.out.println(fromKeyString(sample().getKeyString()));
/* 75 */     System.out.println(sample().genSequencePart());
/* 76 */     System.out.println(sample().getSequenceStringAs36());
/* 77 */     System.out.println(sample().genPavilionKey());
/*    */   }
/*    */ }


/* Location:              /Users/jmlee90/Documents/mySUNI/deployments/base/accent/accent-0.5.1-20200131.120332-18.jar!/io/naraplatform/share/domain/patron/DenizenKey.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */