/*     */ package rightagile.badge.accent.shared.domain.patron;

import rightagile.badge.accent.shared.domain.tenant.CitizenKey;
import rightagile.badge.accent.shared.domain.tenant.NaraKey;
import rightagile.badge.accent.shared.util.json.JsonUtil;

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
/*     */ public class AudienceKey
/*     */   extends PatronKey
/*     */ {
/*     */   public AudienceKey() {}
/*     */   
/*     */   public AudienceKey(String keyString) {
/*  23 */     super(keyString, PatronType.Audience);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static AudienceKey newKey(CineroomKey cineroomKey, CitizenKey citizenKey, AudienceType audienceType) {
/*  30 */     String keyString = String.format("%s-%s@%s", new Object[] { citizenKey
/*  31 */           .genSequencePart(), audienceType
/*  32 */           .initial(), cineroomKey
/*  33 */           .getKeyString() });
/*     */     
/*  35 */     return new AudienceKey(keyString);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/*  41 */     return toJson();
/*     */   }
/*     */ 
/*     */   
/*     */   public static AudienceKey fromJson(String json) {
/*  46 */     return (AudienceKey) JsonUtil.fromJson(json, AudienceKey.class);
/*     */   }
/*     */ 
/*     */   
/*     */   public static AudienceKey fromKeyString(String keyString) {
/*  51 */     return new AudienceKey(keyString);
/*     */   }
/*     */ 
/*     */   
/*     */   public NaraKey genNaraKey() {
/*  56 */     return genPavilionKey().genNaraKey();
/*     */   }
/*     */ 
/*     */   
/*     */   public PavilionKey genPavilionKey() {
/*  61 */     return genCineroomKey().genPavilionKey();
/*     */   }
/*     */ 
/*     */   
/*     */   public CitizenKey genCitizenKey() {
/*  66 */     String citizenSequencePart = getKeyString().substring(0, getKeyString().indexOf('-'));
/*  67 */     String pavilionKeyString = genPavilionKey().getKeyString();
/*     */     
/*  69 */     return new CitizenKey(String.format("%s@%s", new Object[] { citizenSequencePart, pavilionKeyString }));
/*     */   }
/*     */ 
/*     */   
/*     */   public CineroomKey genCineroomKey() {
/*  74 */     return new CineroomKey(genCineroomKeyString());
/*     */   }
/*     */ 
/*     */   
/*     */   public String genCineroomKeyString() {
/*  79 */     return genCineroomKeyString(getKeyString());
/*     */   }
/*     */ 
/*     */   
/*     */   public static String genCineroomKeyString(String audienceKeyString) {
/*  84 */     return audienceKeyString.substring(audienceKeyString.lastIndexOf("@") + 1);
/*     */   }
/*     */ 
/*     */   
/*     */   public String genSequencePart() {
/*  89 */     return getKeyString().substring(0, getKeyString().indexOf('@'));
/*     */   }
/*     */ 
/*     */   
/*     */   public String genSequenceStringAs36() {
/*  94 */     return getKeyString().substring(0, getKeyString().indexOf('@'));
/*     */   }
/*     */ 
/*     */   
/*     */   public static AudienceKey sample() {
/*  99 */     CineroomKey cineroomKey = CineroomKey.sample();
/* 100 */     CitizenKey citizenKey = CitizenKey.sample();
/*     */     
/* 102 */     return newKey(cineroomKey, citizenKey, AudienceType.Regular);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void main(String[] args) {
/* 107 */     AudienceKey audienceKey = sample();
/* 108 */     System.out.println(audienceKey);
/* 109 */     System.out.println(audienceKey.genNaraKey());
/* 110 */     System.out.println(audienceKey.genPavilionKey());
/* 111 */     System.out.println(audienceKey.genCitizenKey());
/* 112 */     System.out.println(audienceKey.genCineroomKey());
/* 113 */     System.out.println(audienceKey.genSequencePart());
/* 114 */     System.out.println(audienceKey.genSequenceStringAs36());
/*     */   }
/*     */ }


/* Location:              /Users/jmlee90/Documents/mySUNI/deployments/base/accent/accent-0.5.1-20200131.120332-18.jar!/io/naraplatform/share/domain/patron/AudienceKey.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */