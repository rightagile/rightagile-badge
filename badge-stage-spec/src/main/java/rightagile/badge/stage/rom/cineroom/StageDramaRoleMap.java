/*    */ package rightagile.badge.stage.rom.cineroom;

import rightagile.badge.accent.shared.domain.cineroom.DramaRoleMap;
import rightagile.badge.accent.shared.domain.ddd.ValueObject;

/*    */
/*    */
/*    */ public class StageDramaRoleMap implements ValueObject {
/*    */   private String id;
/*    */   private DramaRoleMap dramaRoleMap;
/*    */   
/* 10 */   public void setId(String id) { this.id = id; } public void setDramaRoleMap(DramaRoleMap dramaRoleMap) { this.dramaRoleMap = dramaRoleMap; }
/*    */ 
/*    */   
/*    */   public StageDramaRoleMap() {}
/* 14 */   public String getId() { return this.id; } public DramaRoleMap getDramaRoleMap() {
/* 15 */     return this.dramaRoleMap;
/*    */   }
/*    */   
/*    */   public StageDramaRoleMap(String cineroomId, String dramaId, DramaRoleMap dramaRoleMap) {
/* 19 */     this.id = genId(cineroomId, dramaId);
/* 20 */     this.dramaRoleMap = dramaRoleMap;
/*    */   }
/*    */ 
/*    */   
/*    */   public static String genId(String cineroomId, String dramaId) {
/* 25 */     return String.format("%s_%s", new Object[] { cineroomId, dramaId });
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String toString() {
/* 31 */     return toJson();
/*    */   }
/*    */ }


/* Location:              /Users/jmlee90/Documents/mySUNI/deployments/base/stage/stage-spec-0.5.0-SNAPSHOT.jar!/io/naraplatform/stage/rom/cineroom/StageDramaRoleMap.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */