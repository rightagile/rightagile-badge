/*    */ package rightagile.badge.accent.shared.domain.tenant;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum CitizenType
/*    */ {
/* 11 */   Resident("r"),
/* 12 */   Visitant("v"),
/* 13 */   Official("o");
/*    */   
/*    */   private String initial;
/*    */ 
/*    */   
/*    */   CitizenType(String initial) {
/* 19 */     this.initial = initial;
/*    */   }
/*    */ 
/*    */   
/*    */   public String initial() {
/* 24 */     return this.initial;
/*    */   }
/*    */ 
/*    */   
/*    */   public CitizenType fromInitial(String initial) {
/* 29 */     switch (initial) { case "r":
/* 30 */         return Resident;
/* 31 */       case "v": return Visitant;
/* 32 */       case "o": return Official; }
/*    */ 
/*    */     
/* 35 */     throw new IllegalArgumentException("Invalid initial: " + initial);
/*    */   }
/*    */ }


/* Location:              /Users/jmlee90/Documents/mySUNI/deployments/base/accent/accent-0.5.1-20200131.120332-18.jar!/io/naraplatform/share/domain/tenant/CitizenType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */