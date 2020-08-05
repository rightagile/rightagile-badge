/*     */ package rightagile.badge.accent.shared.domain.patron;

import rightagile.badge.accent.shared.domain.tenant.TenantType;
import rightagile.badge.accent.shared.util.exception.ArgumentException;

/*     */
/*     */
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public enum PatronType
/*     */ {
/*  14 */   Square("s", "Nara"),
/*  15 */   Pavilion("p", "Metro"),
/*  16 */   Cineroom("c", "Cineroom"),
/*  17 */   Denizen("d", "Citizen"),
/*  18 */   Audience("a", "Audience"),
/*  19 */   System("z", "System");
/*     */   
/*     */   private String initial;
/*     */   
/*     */   private String tenantType;
/*     */   
/*     */   PatronType(String initial, String tenantType) {
/*  26 */     this.initial = initial;
/*  27 */     this.tenantType = tenantType;
/*     */   }
/*     */ 
/*     */   
/*     */   public String initial() {
/*  32 */     return this.initial;
/*     */   }
/*     */ 
/*     */   
/*     */   public String tenantType() {
/*  37 */     return this.tenantType;
/*     */   }
/*     */ 
/*     */

/*     */   //public PatronScope genScope() {
/*  42 */   //  switch (this) { case Nara:
/*  43 */   //      return PatronScope.Square;
/*  44 */   //    case Metro: return PatronScope.Pavilion;
/*  45 */   //    case Cineroom: return PatronScope.Cineroom;
/*  46 */   //    case Citizen: return PatronScope.Pavilion;
/*  47 */   //    case Audience: return PatronScope.Cineroom; }
/*     */ 
/*     */     
/*  50 */   //  return PatronScope.Cineroom;
/*     */   //}
/*     */ 
/*     */   
/*     */   public boolean isPavilion() {
/*  55 */     return equals(Pavilion);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isCineroom() {
/*  60 */     return equals(Cineroom);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isDenizen() {
/*  65 */     return equals(Denizen);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isAudience() {
/*  70 */     return equals(Audience);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isSystem() {
/*  75 */     return equals(System);
/*     */   }
/*     */ 
/*     */   
/*     */   public static PatronType fromInitial(String initial) {
/*  80 */     switch (initial) { case "s":
/*  81 */         return Square;
/*  82 */       case "p": return Pavilion;
/*  83 */       case "c": return Cineroom;
/*  84 */       case "d": return Denizen;
/*  85 */       case "a": return Audience;
/*  86 */       case "z": return System; }
/*     */ 
/*     */     
/*  89 */     throw new ArgumentException("Invalid initial: " + initial);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static PatronType fromTenantType(String tenantTypeString) {
/*  95 */     switch (tenantTypeString) { case "Nara":
/*  96 */         return Square;
/*  97 */       case "Metro": return Pavilion;
/*  98 */       case "Cineroom": return Cineroom;
/*  99 */       case "Citizen": return Denizen;
/* 100 */       case "Audience": return Audience;
/* 101 */       case "System": return System; }
/*     */ 
/*     */     
/* 104 */     throw new ArgumentException("Invalid TenantType: " + tenantTypeString);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static PatronType fromTenantType(TenantType tenantType) {
/* 110 */     switch (tenantType) { case Nara:
/* 111 */         return Square;
/* 112 */       case Metro: return Pavilion;
/* 113 */       case Cineroom: return Cineroom;
/* 114 */       case Citizen: return Denizen;
/* 115 */       case Audience: return Audience;
/* 116 */       case System: return System; }
/*     */ 
/*     */     
/* 119 */     throw new ArgumentException("Invalid TenantType: " + tenantType);
/*     */   }
/*     */ }


/* Location:              /Users/jmlee90/Documents/mySUNI/deployments/base/accent/accent-0.5.1-20200131.120332-18.jar!/io/naraplatform/share/domain/patron/PatronType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */