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
/*     */ 
/*     */ public class NaraKey
/*     */   extends TenantKey
/*     */ {
/*     */   public NaraKey() {}
/*     */   
/*     */   public NaraKey(String keyString) {
/*  22 */     super(keyString, TenantType.Nara);
/*     */   }
/*     */ 
/*     */   
/*     */   public static NaraKey newKey(NaraType naraType, int naraSequence) {
/*  27 */     String keyString = null;
/*  28 */     switch (naraType) {
/*     */       case HomeNara:
/*  30 */         keyString = newKeyString(NaraType.HomeNara.initial(), 1);
/*     */         break;
/*     */       case ServiceNara:
/*  33 */         keyString = newKeyString(NaraType.ServiceNara.initial(), naraSequence);
/*     */         break;
/*     */       case EnterpriseNara:
/*  36 */         keyString = newKeyString(NaraType.EnterpriseNara.initial(), naraSequence);
/*     */         break;
/*     */     } 
/*     */     
/*  40 */     return new NaraKey(keyString);
/*     */   }
/*     */ 
/*     */   
/*     */   public static NaraKey newDefaultNaraKey(NaraType naraType) {
/*  45 */     return newKey(naraType, 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/*  50 */     return toJson();
/*     */   }
/*     */ 
/*     */   
/*     */   public static NaraKey fromJson(String json) {
/*  55 */     return (NaraKey) JsonUtil.fromJson(json, NaraKey.class);
/*     */   }
/*     */ 
/*     */   
/*     */   public static NaraKey fromKeyString(String keyString) {
/*  60 */     return new NaraKey(keyString);
/*     */   }
/*     */ 
/*     */   
/*     */   private static String newKeyString(String naraTypeString, int naraSequence) {
/*  65 */     return String.format("%s%s%s", new Object[] { TenantType.Nara
/*  66 */           .initial(), naraTypeString, 
/*     */           
/*  68 */           Numeral36.getInstance().getStr36(naraSequence) });
/*     */   }
/*     */ 
/*     */   
/*     */   public NaraType genNaraType() {
/*  73 */     return NaraType.fromInitial(getKeyString().charAt(1));
/*     */   }
/*     */ 
/*     */   
/*     */   public int genSequence() {
/*  78 */     String sequenceString = getKeyString().substring(2);
/*  79 */     return (int)Numeral36.getInstance().getLong36(sequenceString);
/*     */   }
/*     */ 
/*     */   
/*     */   public String getSequenceStringAs36() {
/*  84 */     return getKeyString().substring(2);
/*     */   }
/*     */ 
/*     */   
/*     */   public static NaraKey sampleForHome() {
/*  89 */     return newKey(NaraType.HomeNara, 1);
/*     */   }
/*     */ 
/*     */   
/*     */   public static NaraKey sampleForService() {
/*  94 */     return newKey(NaraType.ServiceNara, 30);
/*     */   }
/*     */ 
/*     */   
/*     */   public static NaraKey sampleForEnterprise() {
/*  99 */     return newKey(NaraType.EnterpriseNara, 10);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void main(String[] args) {
/* 104 */     NaraKey naraKey = sampleForHome();
/* 105 */     System.out.println(naraKey.genNaraType());
/* 106 */     System.out.println(fromKeyString(naraKey.getKeyString()));
/* 107 */     System.out.println(naraKey.genNaraType());
/* 108 */     System.out.println(naraKey.genSequence());
/* 109 */     System.out.println(naraKey.getSequenceStringAs36());
/*     */     
/* 111 */     naraKey = sampleForService();
/* 112 */     System.out.println(naraKey.genNaraType());
/* 113 */     System.out.println(fromKeyString(naraKey.getKeyString()));
/* 114 */     System.out.println(naraKey.genNaraType());
/* 115 */     System.out.println(naraKey.genSequence());
/* 116 */     System.out.println(naraKey.getSequenceStringAs36());
/*     */     
/* 118 */     naraKey = sampleForEnterprise();
/* 119 */     System.out.println(naraKey.genNaraType());
/* 120 */     System.out.println(fromKeyString(naraKey.getKeyString()));
/* 121 */     System.out.println(naraKey.genNaraType());
/* 122 */     System.out.println(naraKey.genSequence());
/* 123 */     System.out.println(naraKey.getSequenceStringAs36());
/*     */   }
/*     */ }


/* Location:              /Users/jmlee90/Documents/mySUNI/deployments/base/accent/accent-0.5.1-20200131.120332-18.jar!/io/naraplatform/share/domain/tenant/NaraKey.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */