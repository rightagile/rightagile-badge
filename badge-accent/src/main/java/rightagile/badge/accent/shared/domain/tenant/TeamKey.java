/*    */ package rightagile.badge.accent.shared.domain.tenant;
/*    */ 
import rightagile.badge.accent.shared.util.json.JsonSerializable;
import rightagile.badge.accent.shared.util.json.JsonUtil;

/*    */
/*    */ public class TeamKey implements JsonSerializable {
/*    */   private String keyString;
/*    */   
/*    */   public String getKeyString() {
/* 10 */     return this.keyString;
/*    */   }
/*    */   
/*    */   public TeamKey(String keyString) {
/* 14 */     this.keyString = keyString;
/*    */   }
/*    */ 
/*    */   
/*    */   public static TeamKey newKey(MetroKey metroKey, int teamSequence) {
/* 19 */     return newKey(metroKey.getKeyString(), teamSequence);
/*    */   }
/*    */ 
/*    */   
/*    */   public static TeamKey newKey(String metroKeyString, int teamSequence) {
/* 24 */     String keyString = newKeyString(metroKeyString, teamSequence);
/*    */     
/* 26 */     return new TeamKey(keyString);
/*    */   }
/*    */ 
/*    */   
/*    */   public static String newKeyString(String metroKeyString, int teamSequence) {
/* 31 */     return String.format("%s-t%d", new Object[] { metroKeyString, 
/*    */           
/* 33 */           Integer.valueOf(teamSequence) });
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 38 */     return toJson();
/*    */   }
/*    */ 
/*    */   
/*    */   public static TeamKey fromJson(String json) {
/* 43 */     return (TeamKey) JsonUtil.fromJson(json, TeamKey.class);
/*    */   }
/*    */ 
/*    */   
/*    */   public static TeamKey fromKeyString(String keyString) {
/* 48 */     return new TeamKey(keyString);
/*    */   }
/*    */ 
/*    */   
/*    */   public String genMetroKeyString() {
/* 53 */     return this.keyString.substring(0, this.keyString.lastIndexOf('-'));
/*    */   }
/*    */ 
/*    */   
/*    */   public MetroKey genMetroKey() {
/* 58 */     return new MetroKey(genMetroKeyString());
/*    */   }
/*    */ 
/*    */   
/*    */   public OrgChartKey genOrgChartKey() {
/* 63 */     return new OrgChartKey(genOrgChartKeyString());
/*    */   }
/*    */ 
/*    */   
/*    */   public String genOrgChartKeyString() {
/* 68 */     return genMetroKeyString() + "-1";
/*    */   }
/*    */ 
/*    */   
/*    */   public static String genOrgChartKeyString(String teamKeyString) {
/* 73 */     return teamKeyString.substring(0, teamKeyString.lastIndexOf('-')) + "-1";
/*    */   }
/*    */ 
/*    */   
/*    */   public static TeamKey sample() {
/* 78 */     return newKey(MetroKey.sample(), 5);
/*    */   }
/*    */ 
/*    */   
/*    */   public static void main(String[] args) {
/* 83 */     TeamKey teamKey = sample();
/* 84 */     System.out.println(teamKey);
/* 85 */     System.out.println(teamKey.genMetroKeyString());
/* 86 */     System.out.println(teamKey.genOrgChartKeyString());
/*    */   }
/*    */ }


/* Location:              /Users/jmlee90/Documents/mySUNI/deployments/base/accent/accent-0.5.1-20200131.120332-18.jar!/io/naraplatform/share/domain/tenant/TeamKey.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */