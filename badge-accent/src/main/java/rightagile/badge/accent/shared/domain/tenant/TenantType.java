/*    */ package rightagile.badge.accent.shared.domain.tenant;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum TenantType
/*    */ {
/* 11 */   Nara("n"),
/* 12 */   Metro("m"),
/* 13 */   Cineroom("t"),
/* 14 */   Citizen("c"),
/* 15 */   Audience("r"),
/* 16 */   System("z");
/*    */   
/*    */   private String initial;
/*    */ 
/*    */   
/*    */   TenantType(String initial) {
/* 22 */     this.initial = initial;
/*    */   }
/*    */ 
/*    */   
/*    */   public String initial() {
/* 27 */     return this.initial;
/*    */   }
/*    */ 
/*    */   
/*    */   public TenantType fromInitial(String tenantInitial) {
/* 32 */     switch (tenantInitial) { case "n":
/* 33 */         return Nara;
/* 34 */       case "m": return Metro;
/* 35 */       case "t": return Cineroom;
/* 36 */       case "c": return Citizen;
/* 37 */       case "r": return Audience; }
/*    */ 
/*    */     
/* 40 */     throw new IllegalArgumentException("Invalid TenantType initial: " + tenantInitial);
/*    */   }
/*    */ }


/* Location:              /Users/jmlee90/Documents/mySUNI/deployments/base/accent/accent-0.5.1-20200131.120332-18.jar!/io/naraplatform/share/domain/tenant/TenantType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */