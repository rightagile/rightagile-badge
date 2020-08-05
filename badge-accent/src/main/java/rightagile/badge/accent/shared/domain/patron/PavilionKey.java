/*    */ package rightagile.badge.accent.shared.domain.patron;

import rightagile.badge.accent.shared.domain.tenant.MetroKey;
import rightagile.badge.accent.shared.domain.tenant.NaraKey;
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
/*    */ public class PavilionKey
/*    */   extends PatronKey
/*    */ {
/*    */   public PavilionKey() {}
/*    */   
/*    */   public PavilionKey(String metroKeyString) {
/* 23 */     super(metroKeyString, PatronType.Pavilion);
/*    */   }
/*    */ 
/*    */   
/*    */   public PavilionKey(MetroKey metroKey) {
/* 28 */     this(metroKey.getKeyString());
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 33 */     return toJson();
/*    */   }
/*    */ 
/*    */   
/*    */   public static PavilionKey fromJson(String json) {
/* 38 */     return (PavilionKey) JsonUtil.fromJson(json, PavilionKey.class);
/*    */   }
/*    */ 
/*    */   
/*    */   public static PavilionKey fromKeyString(String keyString) {
/* 43 */     return new PavilionKey(keyString);
/*    */   }
/*    */ 
/*    */   
/*    */   public NaraKey genNaraKey() {
/* 48 */     String naraKeyString = getKeyString().substring(0, getKeyString().indexOf("-"));
/* 49 */     return new NaraKey(naraKeyString);
/*    */   }
/*    */ 
/*    */   
/*    */   public static PavilionKey sample() {
/* 54 */     NaraKey naraKey = NaraKey.sampleForEnterprise();
/* 55 */     MetroKey metroKey = MetroKey.newKey(naraKey, 5);
/*    */     
/* 57 */     return new PavilionKey(metroKey.getKeyString());
/*    */   }
/*    */ 
/*    */   
/*    */   public static void main(String[] args) {
/* 62 */     System.out.println(fromKeyString(sample().getKeyString()));
/*    */   }
/*    */ }


/* Location:              /Users/jmlee90/Documents/mySUNI/deployments/base/accent/accent-0.5.1-20200131.120332-18.jar!/io/naraplatform/share/domain/patron/PavilionKey.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */