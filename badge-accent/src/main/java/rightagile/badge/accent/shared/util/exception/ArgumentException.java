/*    */
package rightagile.badge.accent.shared.util.exception;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ArgumentException
/*    */   extends DramaException
/*    */ {
/*    */   public ArgumentException(String message) {
/* 12 */     super(message);
/*    */   }
/*    */ 
/*    */   
/*    */   public ArgumentException(String message, Developer developer) {
/* 17 */     super(message, developer);
/*    */   }
/*    */   
/*    */   public ArgumentException(String message, Throwable t) {
/* 21 */     super(message, t);
/*    */   }
/*    */   
/*    */   public ArgumentException(Throwable t) {
/* 25 */     super(t);
/*    */   }
/*    */ 
/*    */   
/*    */   public static ArgumentException newOne(String message, Developer developer) {
/* 30 */     return new ArgumentException(message, developer);
/*    */   }
/*    */ }


/* Location:              /Users/jmlee90/Documents/mySUNI/deployments/base/accent/accent-0.5.1-20200131.120332-18.jar!/io/naraplatform/share/util/exception/ArgumentException.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */