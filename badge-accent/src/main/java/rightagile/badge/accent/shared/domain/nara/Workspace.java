/*    */ package rightagile.badge.accent.shared.domain.nara;
/*    */ 

/*    */ import rightagile.badge.accent.shared.domain.IdName;
import rightagile.badge.accent.shared.domain.ddd.ValueObject;
import rightagile.badge.accent.shared.domain.tenant.CitizenKey;
import rightagile.badge.accent.shared.domain.tenant.MetroKey;
import rightagile.badge.accent.shared.util.json.JsonUtil;

import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Workspace
/*    */   implements ValueObject
/*    */ {
/*    */   String id;
/*    */   String name;
/*    */   String tenantId;
/*    */   List<String> roles;
/*    */   
/*    */   public void setId(String id) {
/* 21 */     this.id = id; } public void setName(String name) { this.name = name; } public void setTenantId(String tenantId) { this.tenantId = tenantId; } public void setRoles(List<String> roles) { this.roles = roles; }
/*    */ 
/*    */   
/*    */   public Workspace() {}
/* 25 */   public String getId() { return this.id; }
/* 26 */   public String getName() { return this.name; }
/* 27 */   public String getTenantId() { return this.tenantId; } public List<String> getRoles() {
/* 28 */     return this.roles;
/*    */   }
/*    */   
/*    */   public Workspace(String id, String name, String tenantId) {
/* 32 */     this.id = id;
/* 33 */     this.name = name;
/* 34 */     this.tenantId = tenantId;
/*    */   }
/*    */ 
/*    */   
/*    */   public Workspace(IdName idName, String tenantId) {
/* 39 */     this(idName.getId(), idName.getName(), tenantId);
/*    */   }
/*    */ 
/*    */   
/*    */   public Workspace(String tenantId) {
/* 44 */     this.tenantId = tenantId;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String toString() {
/* 50 */     return toJson();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean equals(Object obj) {
/* 56 */     if (obj == null)
/* 57 */       return false; 
/* 58 */     if (this == obj)
/* 59 */       return true; 
/* 60 */     if (getClass() != obj.getClass())
/* 61 */       return false; 
/* 62 */     Workspace workspace = (Workspace)obj;
/* 63 */     if (this.id == workspace.id) {
/* 64 */       return true;
/*    */     }
/* 66 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 72 */     return this.id.hashCode();
/*    */   }
/*    */ 
/*    */   
/*    */   public static Workspace fromJson(String json) {
/* 77 */     return (Workspace) JsonUtil.fromJson(json, Workspace.class);
/*    */   }
/*    */ 
/*    */   
/*    */   public static Workspace sample() {
/* 82 */     CitizenKey citizenKey = CitizenKey.sample();
/* 83 */     return new Workspace(citizenKey.genMetroKey().getKeyString(), citizenKey.genMetroKey().getKeyString(), citizenKey.getKeyString());
/*    */   }
/*    */ 
/*    */   
/*    */   public static Workspace samplePavilion() {
/* 88 */     CitizenKey citizenKey = CitizenKey.sample();
/* 89 */     MetroKey metroKey = citizenKey.genMetroKey();
/*    */     
/* 91 */     return new Workspace(metroKey.getKeyString(), metroKey
/* 92 */         .getKeyString(), citizenKey
/* 93 */         .getKeyString());
/*    */   }
/*    */ 
/*    */   
/*    */   public static void main(String[] args) {
/* 98 */     System.out.println(sample());
/*    */   }
/*    */ }


/* Location:              /Users/jmlee90/Documents/mySUNI/deployments/base/accent/accent-0.5.1-20200131.120332-18.jar!/io/naraplatform/share/domain/nara/Workspace.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */