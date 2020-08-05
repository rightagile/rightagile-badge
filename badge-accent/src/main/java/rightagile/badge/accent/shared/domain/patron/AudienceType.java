/*    */ package rightagile.badge.accent.shared.domain.patron;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum AudienceType
/*    */ {
/* 11 */   Regular("r"),
/* 12 */   Guest("g");
/*    */   
/*    */   private String initial;
/*    */ 
/*    */   
/*    */   AudienceType(String initial) {
/* 18 */     this.initial = initial;
/*    */   }
/*    */ 
/*    */   
/*    */   public String initial() {
/* 23 */     return this.initial;
/*    */   }
/*    */ 
/*    */   
/*    */   public AudienceType fromInitial(String initial) {
/* 28 */     switch (initial) { case "r":
/* 29 */         return Regular;
/* 30 */       case "g": return Guest; }
/*    */ 
/*    */     
/* 33 */     throw new IllegalArgumentException("Invalid initial: " + initial);
/*    */   }
/*    */ }


/* Location:              /Users/jmlee90/Documents/mySUNI/deployments/base/accent/accent-0.5.1-20200131.120332-18.jar!/io/naraplatform/share/domain/patron/AudienceType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */