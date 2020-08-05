/*     */ package rightagile.badge.accent.shared.domain.tenant;

import rightagile.badge.accent.shared.util.json.JsonUtil;
import rightagile.badge.accent.shared.util.numeral36.Numeral36;

/*     */
/*     */
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MetroKey
/*     */   extends TenantKey
/*     */ {
/*     */   private static final int DEFAULT_METRO_SEQUENCE = 0;
/*     */   
/*     */   public MetroKey() {}
/*     */   
/*     */   public MetroKey(String keyString) {
/*  23 */     super(keyString, TenantType.Metro);
/*     */   }
/*     */ 
/*     */   
/*     */   public static MetroKey newDefaultMetroKey() {
/*  28 */     return newKey(NaraKey.newDefaultNaraKey(NaraType.EnterpriseNara), 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public static MetroKey newDefaultMetroKey(NaraKey naraKey) {
/*  33 */     return newKey(naraKey, 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public static MetroKey newKey(NaraKey naraKey, int metroSequence) {
/*  38 */     String keyString = String.format("%s-m%s", new Object[] { naraKey
/*  39 */           .getKeyString(), 
/*  40 */           Numeral36.getInstance().getStr36(metroSequence) });
/*     */     
/*  42 */     return new MetroKey(keyString);
/*     */   }
/*     */ 
/*     */   
/*     */   public static MetroKey newKey(String naraKeyString, int metroSequence) {
/*  47 */     String keyString = String.format("%s-M%s", new Object[] { naraKeyString, 
/*     */           
/*  49 */           Numeral36.getInstance().getStr36(metroSequence) });
/*     */     
/*  51 */     return new MetroKey(keyString);
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/*  56 */     return toJson();
/*     */   }
/*     */ 
/*     */   
/*     */   public static MetroKey fromJson(String json) {
/*  61 */     return (MetroKey) JsonUtil.fromJson(json, MetroKey.class);
/*     */   }
/*     */ 
/*     */   
/*     */   public static MetroKey fromKeyString(String keyString) {
/*  66 */     return new MetroKey(keyString);
/*     */   }
/*     */ 
/*     */   
/*     */   public NaraKey genNaraKey() {
/*  71 */     String naraKeyString = getKeyString().substring(0, getKeyString().indexOf("-"));
/*  72 */     return new NaraKey(naraKeyString);
/*     */   }
/*     */ 
/*     */   
/*     */   private String genMetroOnlyKeyString() {
/*  77 */     return getKeyString().substring(getKeyString().indexOf('-') + 1);
/*     */   }
/*     */ 
/*     */   
/*     */   public int genSequence() {
/*  82 */     String sequenceString = genMetroOnlyKeyString().substring(1);
/*  83 */     return (int)Numeral36.getInstance().getLong36(sequenceString);
/*     */   }
/*     */ 
/*     */   
/*     */   public String getSequenceStringAs36() {
/*  88 */     return genMetroOnlyKeyString().substring(1);
/*     */   }
/*     */ 
/*     */   
/*     */   public static MetroKey sample() {
/*  93 */     NaraKey naraKey = NaraKey.sampleForEnterprise();
/*  94 */     return newKey(naraKey, 5);
/*     */   }
/*     */ 
/*     */   
/*     */   public static MetroKey sample(NaraKey naraKey) {
/*  99 */     return newKey(naraKey, 5);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void main(String[] args) {
/* 104 */     System.out.println(fromKeyString(sample().getKeyString()));
/* 105 */     System.out.println(sample().genNaraKey());
/* 106 */     System.out.println(sample().genSequence());
/* 107 */     System.out.println(sample().getSequenceStringAs36());
/* 108 */     System.out.println(newDefaultMetroKey(NaraKey.newKey(NaraType.EnterpriseNara, 12)));
/*     */   }
/*     */ }


/* Location:              /Users/jmlee90/Documents/mySUNI/deployments/base/accent/accent-0.5.1-20200131.120332-18.jar!/io/naraplatform/share/domain/tenant/MetroKey.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */