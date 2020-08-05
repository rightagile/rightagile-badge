/*    */ package rightagile.badge.accent.shared.domain.tenant;

import rightagile.badge.accent.shared.util.json.JsonUtil;
import rightagile.badge.accent.shared.util.numeral36.Numeral36;

/*    */
/*    */
/*    */ 
/*    */ public class CitizenKey
/*    */   extends TenantKey
/*    */ {
/*    */   private static final int DEFAULT_CITIZEN_SEQUENCE = 0;
/*    */   
/*    */   public CitizenKey() {}
/*    */   
/*    */   public CitizenKey(String keyString) {
/* 24 */     super(keyString, TenantType.Citizen);
/*    */   }
/*    */ 
/*    */   
/*    */   public static CitizenKey newDefaultCitizenKey(MetroKey metroKey) {
/* 29 */     return newKey(metroKey.getKeyString(), CitizenType.Official, 0);
/*    */   }
/*    */ 
/*    */   
/*    */   public static CitizenKey newKey(MetroKey metroKey, CitizenType type, int citizenSequence) {
/* 34 */     return newKey(metroKey.getKeyString(), type, citizenSequence);
/*    */   }
/*    */ 
/*    */   
/*    */   public static CitizenKey newKey(String metroKeyString, CitizenType type, int citizenSequence) {
/* 39 */     String keyString = String.format("%s%s@%s", new Object[] { type
/* 40 */           .initial(), 
/* 41 */           Numeral36.getInstance().getStr36(citizenSequence), metroKeyString });
/*    */ 
/*    */     
/* 44 */     return new CitizenKey(keyString);
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 49 */     return toJson();
/*    */   }
/*    */ 
/*    */   
/*    */   public static CitizenKey fromJson(String json) {
/* 54 */     return (CitizenKey) JsonUtil.fromJson(json, CitizenKey.class);
/*    */   }
/*    */ 
/*    */   
/*    */   public static CitizenKey fromKeyString(String keyString) {
/* 59 */     return new CitizenKey(keyString);
/*    */   }
/*    */ 
/*    */   
/*    */   public MetroKey genMetroKey() {
/* 64 */     return new MetroKey(getKeyString().substring(getKeyString().indexOf('@') + 1));
/*    */   }
/*    */ 
/*    */   
/*    */   public NaraKey genNaraKey() {
/* 69 */     return genMetroKey().genNaraKey();
/*    */   }
/*    */ 
/*    */   
/*    */   public String genSequencePart() {
/* 74 */     return getKeyString().substring(0, getKeyString().indexOf('@'));
/*    */   }
/*    */ 
/*    */   
/*    */   public String getSequenceStringAs36() {
/* 79 */     return getKeyString().substring(0, getKeyString().indexOf('@'));
/*    */   }
/*    */ 
/*    */   
/*    */   public static CitizenKey sample() {
/* 84 */     MetroKey metroKey = MetroKey.sample();
/* 85 */     return newKey(metroKey, CitizenType.Resident, 3500);
/*    */   }
/*    */ 
/*    */   
/*    */   public static void main(String[] args) {
/* 90 */     System.out.println(fromKeyString(sample().getKeyString()));
/* 91 */     System.out.println(sample().genNaraKey());
/* 92 */     System.out.println(sample().genMetroKey());
/* 93 */     System.out.println(sample().genSequencePart());
/* 94 */     System.out.println(sample().getSequenceStringAs36());
/* 95 */     System.out.println(newDefaultCitizenKey(MetroKey.newDefaultMetroKey(NaraKey.newDefaultNaraKey(NaraType.EnterpriseNara))));
/*    */   }
/*    */ }


/* Location:              /Users/jmlee90/Documents/mySUNI/deployments/base/accent/accent-0.5.1-20200131.120332-18.jar!/io/naraplatform/share/domain/tenant/CitizenKey.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */