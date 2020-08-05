/*    */ package rightagile.badge.accent.shared.domain.tenant;

import rightagile.badge.accent.shared.util.json.JsonSerializable;
import rightagile.badge.accent.shared.util.json.JsonUtil;

/*    */
/*    */
/*    */ public class OrgChartKey implements JsonSerializable {
/*    */   private String keyString;
/*    */   
/*    */   public String getKeyString() {
/* 10 */     return this.keyString;
/*    */   }
/*    */   
/*    */   public OrgChartKey(String keyString) {
/* 14 */     this.keyString = keyString;
/*    */   }
/*    */ 
/*    */   
/*    */   public static OrgChartKey newKey(MetroKey metroKey, int orgChartSequence) {
/* 19 */     return newKey(metroKey.getKeyString(), orgChartSequence);
/*    */   }
/*    */ 
/*    */   
/*    */   public static OrgChartKey newKey(String metroKeyString, int orgChartSequence) {
/* 24 */     String keyString = newKeyString(metroKeyString, orgChartSequence);
/*    */     
/* 26 */     return new OrgChartKey(keyString);
/*    */   }
/*    */ 
/*    */   
/*    */   public static String newKeyString(String metroKeyString, int orgChartSequence) {
/* 31 */     return String.format("%s-%d", new Object[] { metroKeyString, 
/*    */           
/* 33 */           Integer.valueOf(orgChartSequence) });
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 38 */     return toJson();
/*    */   }
/*    */ 
/*    */   
/*    */   public static OrgChartKey fromJson(String json) {
/* 43 */     return (OrgChartKey) JsonUtil.fromJson(json, OrgChartKey.class);
/*    */   }
/*    */ 
/*    */   
/*    */   public String genMetroKeyString() {
/* 48 */     return this.keyString.substring(0, this.keyString.lastIndexOf('-'));
/*    */   }
/*    */ 
/*    */   
/*    */   public MetroKey genMetroKey() {
/* 53 */     return new MetroKey(genMetroKeyString());
/*    */   }
/*    */ 
/*    */   
/*    */   public static OrgChartKey sample() {
/* 58 */     return newKey(MetroKey.sample(), 1);
/*    */   }
/*    */ 
/*    */   
/*    */   public static void main(String[] args) {
/* 63 */     OrgChartKey orgChartKey = sample();
/* 64 */     System.out.println(orgChartKey);
/* 65 */     System.out.println(orgChartKey.genMetroKey());
/*    */   }
/*    */ }


/* Location:              /Users/jmlee90/Documents/mySUNI/deployments/base/accent/accent-0.5.1-20200131.120332-18.jar!/io/naraplatform/share/domain/tenant/OrgChartKey.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */