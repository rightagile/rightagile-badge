/*     */ package rightagile.badge.accent.shared.domain.patron;
/*     */ 
/*     */

import rightagile.badge.accent.shared.domain.Offset;
import rightagile.badge.accent.shared.domain.tenant.MetroKey;
import rightagile.badge.accent.shared.domain.tenant.NaraKey;
import rightagile.badge.accent.shared.domain.tenant.TeamKey;
import rightagile.badge.accent.shared.util.json.JsonUtil;

import java.util.ArrayList;
import java.util.List;

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
/*     */ 
/*     */ public class CineroomKey
/*     */   extends PatronKey
/*     */ {
/*     */   public CineroomKey() {}
/*     */   
/*     */   public CineroomKey(String keyString) {
/*  28 */     super(keyString, PatronType.Cineroom);
/*     */   }
/*     */ 
/*     */   
/*     */   public static CineroomKey newKey(TeamKey teamKey) {
/*  33 */     String keyString = String.format("%s-%s%s", new Object[] { teamKey
/*  34 */           .genMetroKeyString(), PatronType.Cineroom
/*  35 */           .initial(), teamKey
/*  36 */           .getKeyString().substring(teamKey.getKeyString().lastIndexOf('-') + 2) });
/*     */     
/*  38 */     return new CineroomKey(keyString);
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/*  43 */     return toJson();
/*     */   }
/*     */ 
/*     */   
/*     */   public static CineroomKey fromJson(String json) {
/*  48 */     return (CineroomKey) JsonUtil.fromJson(json, CineroomKey.class);
/*     */   }
/*     */ 
/*     */   
/*     */   public static CineroomKey fromKeyString(String keyString) {
/*  53 */     return new CineroomKey(keyString);
/*     */   }
/*     */ 
/*     */   
/*     */   public NaraKey genNaraKey() {
/*  58 */     return genMetroKey().genNaraKey();
/*     */   }
/*     */ 
/*     */   
/*     */   public MetroKey genMetroKey() {
/*  63 */     return new MetroKey(genMetroKeyString());
/*     */   }
/*     */ 
/*     */   
/*     */   public String genMetroKeyString() {
/*  68 */     return genMetroKeyString(getKeyString());
/*     */   }
/*     */ 
/*     */   
/*     */   public String genPavilionKeyString() {
/*  73 */     return genMetroKeyString();
/*     */   }
/*     */ 
/*     */   
/*     */   public static String genMetroKeyString(String cineroomKeyString) {
/*  78 */     return cineroomKeyString.substring(0, cineroomKeyString.lastIndexOf('-'));
/*     */   }
/*     */ 
/*     */   
/*     */   public static String genPavilionKeyString(String cineroomKeyString) {
/*  83 */     return genMetroKeyString(cineroomKeyString);
/*     */   }
/*     */ 
/*     */   
/*     */   public PavilionKey genPavilionKey() {
/*  88 */     return new PavilionKey(genMetroKey().getKeyString());
/*     */   }
/*     */ 
/*     */   
/*     */   public String genMetroId() {
/*  93 */     return genMetroKey().getKeyString();
/*     */   }
/*     */ 
/*     */   
/*     */   public TeamKey genTeamKey() {
/*  98 */     String teamKeyString = String.format("%s-t%s", new Object[] {
/*  99 */           genMetroKey().getKeyString(), 
/* 100 */           getKeyString().substring(getKeyString().lastIndexOf('-') + 2)
/*     */         });
/* 102 */     return TeamKey.fromKeyString(teamKeyString);
/*     */   }
/*     */ 
/*     */   
/*     */   public static CineroomKey sample() {
/* 107 */     TeamKey teamKey = TeamKey.sample();
/* 108 */     return newKey(teamKey);
/*     */   }
/*     */ 
/*     */   
/*     */   public static List<CineroomKey> samples(MetroKey metroKey, Offset offset) {
/* 113 */     List<CineroomKey> cineroomKeys = new ArrayList<>();
/* 114 */     int startOffset = offset.offset();
/* 115 */     for (int i = 0; i < offset.limit(); i++) {
/* 116 */       cineroomKeys.add(newKey(TeamKey.newKey(metroKey, startOffset + i)));
/*     */     }
/*     */     
/* 119 */     return cineroomKeys;
/*     */   }
/*     */ 
/*     */   
/*     */   public static void main(String[] args) {
/* 124 */     System.out.println(fromKeyString(sample().getKeyString()));
/* 125 */     System.out.println(sample().genNaraKey());
/* 126 */     System.out.println(sample().genMetroKey());
/* 127 */     System.out.println(samples(MetroKey.sample(), Offset.newOne(1, 20)));
/* 128 */     System.out.println(sample().genTeamKey());
/*     */   }
/*     */ }


/* Location:              /Users/jmlee90/Documents/mySUNI/deployments/base/accent/accent-0.5.1-20200131.120332-18.jar!/io/naraplatform/share/domain/patron/CineroomKey.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */