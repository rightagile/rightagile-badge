/*    */ package rightagile.badge.accent.shared.util.exception;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DramaException
/*    */   extends RuntimeException
/*    */ {
/*    */   private Developer developer;
/*    */   
/*    */   public DramaException(String message, Developer developer) {
/* 15 */     super(message);
/* 16 */     this.developer = developer;
/*    */   }
/*    */ 
/*    */   
/*    */   public DramaException(String message) {
/* 21 */     super(message);
/* 22 */     this.developer = Developer.anonymous();
/*    */   }
/*    */   
/*    */   public DramaException(String message, Throwable t) {
/* 26 */     super(message, t);
/*    */   }
/*    */   
/*    */   public DramaException(Throwable t) {
/* 30 */     super(t);
/*    */   }
/*    */ 
/*    */   
/*    */   public static DramaException newOne(String message, Developer developer) {
/* 35 */     return new DramaException(message, developer);
/*    */   }
/*    */ }


/* Location:              /Users/jmlee90/Documents/mySUNI/deployments/base/accent/accent-0.5.1-20200131.120332-18.jar!/io/naraplatform/share/util/exception/DramaException.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */