/*     */ package rightagile.badge.accent.shared.domain.patron;
/*     */ 
/*     */

import rightagile.badge.accent.shared.domain.tenant.CitizenKey;
import rightagile.badge.accent.shared.domain.tenant.TenantKey;
import rightagile.badge.accent.shared.util.json.JsonSerializable;
import rightagile.badge.accent.shared.util.json.JsonUtil;

import java.io.Serializable;
import java.util.Objects;

/*     */
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PatronKey
/*     */   implements JsonSerializable, Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1755449118285000893L;
/*     */   private String keyString;
/*     */   private PatronType patronType;
/*     */   
/*     */   public void setKeyString(String keyString) {
/*  21 */     this.keyString = keyString; } public void setPatronType(PatronType patronType) { this.patronType = patronType; }
/*     */ 
/*     */   
/*     */   public PatronKey() {}
/*     */   
/*  26 */   public String getKeyString() { return this.keyString; } public PatronType getPatronType() {
/*  27 */     return this.patronType;
/*     */   }
/*     */   
/*     */   public PatronKey(String keyString, PatronType patronType) {
/*  31 */     this.keyString = keyString;
/*  32 */     this.patronType = patronType;
/*     */   }
/*     */ 
/*     */   
/*     */   public PatronKey(TenantKey tenantKey) {
/*  37 */     this.keyString = tenantKey.getKeyString();
/*  38 */     this.patronType = PatronType.fromTenantType(tenantKey.getTenantType());
/*     */   }
/*     */ 
/*     */   
/*     */   public static PatronKey genSystemPatronKey() {
/*  43 */     return new PatronKey("system", PatronType.System);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object target) {
/*  48 */     if (this == target)
/*  49 */       return true; 
/*  50 */     if (target != null && getClass() == target.getClass()) {
/*  51 */       PatronKey key = (PatronKey)target;
/*  52 */       return Objects.equals(this.keyString, key.getKeyString());
/*     */     } 
/*  54 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/*  60 */     return Objects.hash(new Object[] { this.keyString });
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/*  65 */     return toJson();
/*     */   }
/*     */ 
/*     */   
/*     */   public static PatronKey fromJson(String json) {
/*  70 */     return (PatronKey) JsonUtil.fromJson(json, PatronKey.class);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isPavilionKey() {
/*  75 */     return this.patronType.isPavilion();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isCineroomKey() {
/*  80 */     return this.patronType.isCineroom();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isDenizenKey() {
/*  85 */     return this.patronType.isDenizen();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isAudienceKey() {
/*  90 */     return this.patronType.isAudience();
/*     */   }
/*     */ 
/*     */   
/*     */   public PavilionKey genPavilionKey() {
/*  95 */     if (isPavilionKey()) {
/*  96 */       return new PavilionKey(getKeyString());
/*     */     }
/*     */     
/*  99 */     throw new IllegalArgumentException("Current PatronType: " + this.patronType);
/*     */   }
/*     */ 
/*     */   
/*     */   public CineroomKey genCineroomKey() {
/* 104 */     if (isCineroomKey()) {
/* 105 */       return new CineroomKey(getKeyString());
/*     */     }
/*     */     
/* 108 */     throw new IllegalArgumentException("Current PatronType: " + this.patronType);
/*     */   }
/*     */ 
/*     */   
/*     */   public DenizenKey genDenizenKey() {
/* 113 */     if (isDenizenKey()) {
/* 114 */       return new DenizenKey(getKeyString());
/*     */     }
/*     */     
/* 117 */     throw new IllegalArgumentException("Current PatronType: " + this.patronType);
/*     */   }
/*     */ 
/*     */   
/*     */   public AudienceKey genAudienceKey() {
/* 122 */     if (isAudienceKey()) {
/* 123 */       return new AudienceKey(getKeyString());
/*     */     }
/*     */     
/* 126 */     throw new IllegalArgumentException("Current PatronType: " + this.patronType);
/*     */   }
/*     */ 
/*     */   
/*     */   public static PatronKey sample() {
/* 131 */     CitizenKey citizenKey = CitizenKey.sample();
/* 132 */     return new PatronKey(new TenantKey(citizenKey.getKeyString(), citizenKey.getTenantType()));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void main(String[] args) {
/* 137 */     System.out.println(sample());
/* 138 */     System.out.println(sample().genDenizenKey());
/* 139 */     System.out.println(sample().genCineroomKey());
/*     */   }
/*     */ }


/* Location:              /Users/jmlee90/Documents/mySUNI/deployments/base/accent/accent-0.5.1-20200131.120332-18.jar!/io/naraplatform/share/domain/patron/PatronKey.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */