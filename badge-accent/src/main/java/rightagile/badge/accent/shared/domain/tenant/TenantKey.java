/*     */ package rightagile.badge.accent.shared.domain.tenant;
/*     */ 
/*     */ import rightagile.badge.accent.shared.util.json.JsonSerializable;
import rightagile.badge.accent.shared.util.json.JsonUtil;

import java.util.Objects;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TenantKey
/*     */   implements JsonSerializable
/*     */ {
/*     */   private String keyString;
/*     */   private TenantType tenantType;
/*     */   
/*     */   public void setKeyString(String keyString) {
/*  18 */     this.keyString = keyString; } public void setTenantType(TenantType tenantType) { this.tenantType = tenantType; }
/*     */ 
/*     */   
/*     */   public TenantKey() {}
/*  22 */   public String getKeyString() { return this.keyString; } public TenantType getTenantType() {
/*  23 */     return this.tenantType;
/*     */   }
/*     */   
/*     */   public TenantKey(String keyString, TenantType tenantType) {
/*  27 */     this.keyString = keyString;
/*  28 */     this.tenantType = tenantType;
/*     */   }
/*     */ 
/*     */   
/*     */   public TenantKey(TenantKey tenantKey) {
/*  33 */     this.keyString = tenantKey.getKeyString();
/*  34 */     this.tenantType = tenantKey.getTenantType();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object target) {
/*  39 */     if (this == target)
/*  40 */       return true; 
/*  41 */     if (target != null && getClass() == target.getClass()) {
/*  42 */       TenantKey key = (TenantKey)target;
/*  43 */       return Objects.equals(this.keyString, key.getKeyString());
/*     */     } 
/*  45 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/*  50 */     return Objects.hash(new Object[] { this.keyString });
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/*  55 */     return toJson();
/*     */   }
/*     */ 
/*     */   
/*     */   public static TenantKey fromJson(String json) {
/*  60 */     return (TenantKey) JsonUtil.fromJson(json, TenantKey.class);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isCitizenKey() {
/*  65 */     if (this.tenantType.equals(TenantType.Citizen)) {
/*  66 */       return true;
/*     */     }
/*     */     
/*  69 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public CitizenKey genCitizenKey() {
/*  74 */     if (isCitizenKey()) {
/*  75 */       return new CitizenKey(this.keyString);
/*     */     }
/*     */     
/*  78 */     throw new IllegalArgumentException("Tenant is not citizen: " + this.tenantType);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isMetroKey() {
/*  83 */     if (this.tenantType.equals(TenantType.Metro)) {
/*  84 */       return true;
/*     */     }
/*     */     
/*  87 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public MetroKey genMetroKey() {
/*  92 */     if (isMetroKey()) {
/*  93 */       return new MetroKey(this.keyString);
/*     */     }
/*     */     
/*  96 */     throw new IllegalArgumentException("Tenant is not metro: " + this.tenantType);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isNaraKey() {
/* 101 */     if (this.tenantType.equals(TenantType.Nara)) {
/* 102 */       return true;
/*     */     }
/*     */     
/* 105 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public NaraKey genNaraKey() {
/* 110 */     if (isNaraKey()) {
/* 111 */       return new NaraKey(this.keyString);
/*     */     }
/*     */     
/* 114 */     throw new IllegalArgumentException("Tenant is not nara: " + this.tenantType);
/*     */   }
/*     */ 
/*     */   
/*     */   public static TenantKey sample() {
/* 119 */     return new TenantKey(CitizenKey.sample());
/*     */   }
/*     */ 
/*     */   
/*     */   public static void main(String[] args) {
/*     */     try {
/* 125 */       System.out.println(fromJson(sample().toJson()));
/* 126 */       System.out.println(sample().genCitizenKey());
/* 127 */     } catch (IllegalArgumentException e) {
/* 128 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              /Users/jmlee90/Documents/mySUNI/deployments/base/accent/accent-0.5.1-20200131.120332-18.jar!/io/naraplatform/share/domain/tenant/TenantKey.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */