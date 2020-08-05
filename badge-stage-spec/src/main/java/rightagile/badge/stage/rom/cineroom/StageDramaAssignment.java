/*    */ package rightagile.badge.stage.rom.cineroom;
/*    */ 
import rightagile.badge.accent.shared.domain.ddd.ValueObject;
import rightagile.badge.accent.shared.domain.drama.DramaKey;
import rightagile.badge.accent.shared.domain.patron.CineroomKey;

/*    */
/*    */ public class StageDramaAssignment implements ValueObject {
/*    */   private String id;
/*    */   private String cineroomId;
/*    */   private String cineroomUsid;
/*    */   
/* 11 */   public void setId(String id) { this.id = id; } private String dramaId; private String dramaName; private String dramaEdition; public void setCineroomId(String cineroomId) { this.cineroomId = cineroomId; } public void setCineroomUsid(String cineroomUsid) { this.cineroomUsid = cineroomUsid; } public void setDramaId(String dramaId) { this.dramaId = dramaId; } public void setDramaName(String dramaName) { this.dramaName = dramaName; } public void setDramaEdition(String dramaEdition) { this.dramaEdition = dramaEdition; }
/*    */   
/*    */   public StageDramaAssignment() {}
/*    */   
/* 15 */   public String getId() { return this.id; }
/* 16 */   public String getCineroomId() { return this.cineroomId; }
/* 17 */   public String getCineroomUsid() { return this.cineroomUsid; }
/* 18 */   public String getDramaId() { return this.dramaId; }
/* 19 */   public String getDramaName() { return this.dramaName; } public String getDramaEdition() {
/* 20 */     return this.dramaEdition;
/*    */   }
/*    */   
/*    */   public StageDramaAssignment(String cineroomId, String cineroomUsid, String dramaId, String dramaName, String dramaEdition) {
/* 24 */     this.id = genId(cineroomId, dramaId);
/* 25 */     this.cineroomId = cineroomId;
/* 26 */     this.cineroomUsid = cineroomUsid;
/* 27 */     this.dramaId = dramaId;
/* 28 */     this.dramaName = dramaName;
/* 29 */     this.dramaEdition = dramaEdition;
/*    */   }
/*    */ 
/*    */   
/*    */   public static String genId(String cineroomId, String dramaId) {
/* 34 */     return String.format("%s_%s", new Object[] { cineroomId, dramaId });
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String toString() {
/* 40 */     return toJson();
/*    */   }
/*    */ 
/*    */   
/*    */   public static StageDramaAssignment sample() {
/* 45 */     String cineroomId = CineroomKey.sample().getKeyString();
/* 46 */     String dramaId = DramaKey.sample().getDramaId();
/*    */     
/* 48 */     return new StageDramaAssignment(cineroomId, cineroomId, dramaId, "Hello", "Professional");
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void main(String[] args) {
/* 57 */     System.out.println(sample());
/*    */   }
/*    */ }


/* Location:              /Users/jmlee90/Documents/mySUNI/deployments/base/stage/stage-spec-0.5.0-SNAPSHOT.jar!/io/naraplatform/stage/rom/cineroom/StageDramaAssignment.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */