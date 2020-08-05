/*    */ package rightagile.badge.accent.shared.util.numeral36;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class UsidGen
/*    */ {
/*    */   public static String getStr36(String prefix, String separator, long number, int formatLength) {
/* 13 */     number = (number < 0L) ? -number : number;
/*    */     
/* 15 */     Numeral36 numeral36 = Numeral36.getInstance();
/*    */     
/* 17 */     return String.format("%s%s%s", new Object[] { prefix, separator, numeral36
/*    */           
/* 19 */           .getStr36(number, formatLength) });
/*    */   }
/*    */ 
/*    */   
/*    */   public static String getStr36(String prefix, long number, int formatLength) {
/* 24 */     number = (number < 0L) ? -number : number;
/*    */     
/* 26 */     Numeral36 numeral36 = Numeral36.getInstance();
/* 27 */     return String.format("%s-%s", new Object[] { prefix, numeral36.getStr36(number, formatLength) });
/*    */   }
/*    */ 
/*    */   
/*    */   public static String getStr36(String prefix, long number) {
/* 32 */     number = (number < 0L) ? -number : number;
/*    */     
/* 34 */     Numeral36 numeral36 = Numeral36.getInstance();
/* 35 */     return String.format("%s-%s", new Object[] { prefix, numeral36.getStr36(number) });
/*    */   }
/*    */ 
/*    */   
/*    */   public static String getStr36(long number, int formatLength) {
/* 40 */     number = (number < 0L) ? -number : number;
/*    */     
/* 42 */     Numeral36 numeral36 = Numeral36.getInstance();
/* 43 */     return numeral36.getStr36(number, formatLength);
/*    */   }
/*    */ 
/*    */   
/*    */   public static String getStr36(long number) {
/* 48 */     number = (number < 0L) ? -number : number;
/*    */     
/* 50 */     Numeral36 numeral36 = Numeral36.getInstance();
/* 51 */     return numeral36.getStr36(number);
/*    */   }
/*    */ }


/* Location:              /Users/jmlee90/Documents/mySUNI/deployments/base/accent/accent-0.5.1-20200131.120332-18.jar!/io/naraplatform/share/util/numeral36/UsidGen.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */