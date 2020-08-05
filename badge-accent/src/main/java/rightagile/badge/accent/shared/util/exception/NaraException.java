/*    */
package rightagile.badge.accent.shared.util.exception;
/*    */ 
/*    */ public class NaraException
/*    */   extends RuntimeException
/*    */ {
/*    */   private Developer developer;
/*    */   private boolean useMessageCode = true;
/*    */   
/*    */   public NaraException(String message, Developer developer) {
/* 10 */     super(message);
/* 11 */     this.developer = developer;
/*    */   }
/*    */ 
/*    */   
/*    */   public NaraException(String message) {
/* 16 */     super(message);
/* 17 */     this.developer = Developer.anonymous();
/*    */   }
/*    */ 
/*    */   
/*    */   public NaraException(String message, Throwable t) {
/* 22 */     super(message, t);
/*    */   }
/*    */ 
/*    */   
/*    */   public NaraException(Throwable t) {
/* 27 */     super(t);
/*    */   }
/*    */ 
/*    */   
/*    */   public static NaraException newOne(String message, Developer developer) {
/* 32 */     return new NaraException(message, developer);
/*    */   }
/*    */ 
/*    */   
/*    */   public static NaraException newOneWithMessage(String message) {
/* 37 */     NaraException naraException = new NaraException(message);
/* 38 */     naraException.setUseMessageCode(false);
/*    */     
/* 40 */     return naraException;
/*    */   }
/*    */ 
/*    */   
/*    */   public static NaraException newOneWithMessage(String message, Throwable t) {
/* 45 */     NaraException naraException = new NaraException(message, t);
/* 46 */     naraException.setUseMessageCode(false);
/*    */     
/* 48 */     return naraException;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setUseMessageCode(boolean useMessageCode) {
/* 54 */     this.useMessageCode = useMessageCode;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isUseMessageCode() {
/* 59 */     return this.useMessageCode;
/*    */   }
/*    */ }


/* Location:              /Users/jmlee90/Documents/mySUNI/deployments/base/accent/accent-0.5.1-20200131.120332-18.jar!/io/naraplatform/share/util/exception/NaraException.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */