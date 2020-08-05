/*     */ package rightagile.badge.accent.shared.util.numeral36;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Numeral36
/*     */ {
/*     */   private static final int Decimal36 = 36;
/*     */   
/*     */   public static Numeral36 getInstance() {
/*  19 */     return new Numeral36();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getNextStr36(int int36) {
/*  24 */     return getStr36(++int36);
/*     */   }
/*     */ 
/*     */   
/*     */   public String getNextStr36(String str36) {
/*  29 */     if (str36.length() == 1 && str36.equals("z")) {
/*  30 */       throw new RuntimeException("Overflow, z is the last char in one byte value -> " + str36);
/*     */     }
/*     */     
/*  33 */     long longValue = getLong36(str36);
/*  34 */     longValue++;
/*  35 */     return getStr36(longValue);
/*     */   }
/*     */ 
/*     */   
/*     */   public long getLong36(String str36) {
/*  40 */     if (str36 == null || str36.equals("")) {
/*  41 */       throw new RuntimeException("Minus digit is not valid -> " + str36);
/*     */     }
/*     */     
/*  44 */     long resultInt = 0L;
/*  45 */     int currentIndex = 0;
/*  46 */     int remainCount = 0;
/*  47 */     char currentChar = '0';
/*  48 */     int intValue = 0;
/*     */     
/*  50 */     while (currentIndex < str36.length()) {
/*     */       
/*  52 */       currentChar = str36.charAt(currentIndex);
/*  53 */       if (currentChar < 'a') {
/*  54 */         intValue = currentChar - 48;
/*     */       } else {
/*  56 */         intValue = currentChar + 10 - 97;
/*     */       } 
/*     */       
/*  59 */       currentIndex++;
/*  60 */       remainCount = str36.length() - currentIndex;
/*     */       
/*  62 */       if (remainCount == 0) {
/*  63 */         resultInt += intValue; continue;
/*     */       } 
/*  65 */       resultInt = (long)(resultInt + intValue * Math.pow(36.0D, remainCount));
/*     */     } 
/*     */ 
/*     */     
/*  69 */     return resultInt;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getStr36(long int36, int formatLength) {
/*  74 */     return format(getStr36(int36), formatLength);
/*     */   }
/*     */ 
/*     */   
/*     */   public String getStr36(long int36) {
/*  79 */     String resultStr = "";
/*     */     
/*  81 */     if (int36 < 0L) {
/*  82 */       throw new RuntimeException("Minus digit is not valid -> " + int36);
/*     */     }
/*     */     
/*  85 */     if (int36 < 10L) {
/*  86 */       resultStr = resultStr + (char)(int)(int36 + 48L);
/*     */     } else {
/*     */       
/*  89 */       long remain = 0L;
/*  90 */       char charDigit = '0';
/*     */       
/*  92 */       while (int36 > 0L) {
/*  93 */         remain = int36 % 36L;
/*  94 */         if (remain < 10L) {
/*  95 */           charDigit = (char)(int)(remain + 48L);
/*     */         } else {
/*  97 */           charDigit = (char)(int)(remain - 10L + 97L);
/*     */         } 
/*  99 */         resultStr = charDigit + resultStr;
/* 100 */         int36 /= 36L;
/*     */       } 
/*     */     } 
/* 103 */     return resultStr;
/*     */   }
/*     */ 
/*     */   
/*     */   private String format(String str36, int formatLength) {
/* 108 */     int fillCount = formatLength - str36.length();
/* 109 */     if (fillCount < 0) {
/* 110 */       throw new RuntimeException("Formatted length is smaller than str36 length:" + str36);
/*     */     }
/*     */     
/* 113 */     if (fillCount == 0) {
/* 114 */       return str36;
/*     */     }
/*     */     
/* 117 */     StringBuilder strBuilder = new StringBuilder(formatLength);
/* 118 */     for (int i = 0; i < fillCount; i++) {
/* 119 */       strBuilder.append("0");
/*     */     }
/*     */     
/* 122 */     strBuilder.append(str36);
/*     */     
/* 124 */     return strBuilder.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public static void main(String[] args) {
/* 129 */     Numeral36 numeral36 = new Numeral36();
/* 130 */     System.out.println(numeral36.getStr36(12L));
/* 131 */     System.out.println(numeral36.getStr36(1201010L));
/*     */   }
/*     */ }


/* Location:              /Users/jmlee90/Documents/mySUNI/deployments/base/accent/accent-0.5.1-20200131.120332-18.jar!/io/naraplatform/share/util/numeral36/Numeral36.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */