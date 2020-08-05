/*    */ package rightagile.badge.accent.shared.domain.tenant;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum NaraType
/*    */ {
/* 11 */   HomeNara("h"),
/* 12 */   ServiceNara("s"),
/* 13 */   EnterpriseNara("e");
/*    */   
/*    */   private String initial;
/*    */ 
/*    */   
/*    */   NaraType(String initial) {
/* 19 */     this.initial = initial;
/*    */   }
/*    */ 
/*    */   
/*    */   public String initial() {
/* 24 */     return this.initial;
/*    */   }
/*    */ 
/*    */   
/*    */   public static NaraType fromInitial(char initialChar) {
/* 29 */     switch (initialChar) { case 'h':
/* 30 */         return HomeNara;
/* 31 */       case 's': return ServiceNara;
/* 32 */       case 'e': return EnterpriseNara; }
/*    */     
/* 34 */     throw new IllegalArgumentException("Invalid initial character: " + initialChar);
/*    */   }
/*    */ }


/* Location:              /Users/jmlee90/Documents/mySUNI/deployments/base/accent/accent-0.5.1-20200131.120332-18.jar!/io/naraplatform/share/domain/tenant/NaraType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */