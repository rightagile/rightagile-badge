/*     */ package rightagile.badge.accent.shared.domain.nara;
/*     */ 

/*     */

import rightagile.badge.accent.shared.domain.ddd.ValueObject;
import rightagile.badge.accent.shared.util.json.JsonUtil;
import rightagile.badge.accent.shared.util.string.StringUtil;

import java.util.ArrayList;
import java.util.List;

/*     */
/*     */ 
/*     */ 
/*     */ public class WorkspaceList
/*     */   implements ValueObject
/*     */ {
/*     */   private List<Workspace> stationWorkspaces;
/*     */   private List<Workspace> squareWorkspaces;
/*     */   private List<Workspace> pavilionWorkspaces;
/*     */   private List<Workspace> cineroomWorkspaces;
/*     */   private Workspace studioWorkspace;
/*     */   
/*     */   public void setStationWorkspaces(List<Workspace> stationWorkspaces) {
/*  20 */     this.stationWorkspaces = stationWorkspaces; } public void setSquareWorkspaces(List<Workspace> squareWorkspaces) { this.squareWorkspaces = squareWorkspaces; } public void setPavilionWorkspaces(List<Workspace> pavilionWorkspaces) { this.pavilionWorkspaces = pavilionWorkspaces; } public void setCineroomWorkspaces(List<Workspace> cineroomWorkspaces) { this.cineroomWorkspaces = cineroomWorkspaces; } public void setStudioWorkspace(Workspace studioWorkspace) { this.studioWorkspace = studioWorkspace; }
/*     */ 
/*     */   
/*     */   public List<Workspace> getStationWorkspaces() {
/*  24 */     return this.stationWorkspaces;
/*  25 */   } public List<Workspace> getSquareWorkspaces() { return this.squareWorkspaces; }
/*  26 */   public List<Workspace> getPavilionWorkspaces() { return this.pavilionWorkspaces; }
/*  27 */   public List<Workspace> getCineroomWorkspaces() { return this.cineroomWorkspaces; } public Workspace getStudioWorkspace() {
/*  28 */     return this.studioWorkspace;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/*  33 */     return toJson();
/*     */   }
/*     */ 
/*     */   
/*     */   public static WorkspaceList fromJson(String json) {
/*  38 */     return (WorkspaceList) JsonUtil.fromJson(json, WorkspaceList.class);
/*     */   }
/*     */ 
/*     */   
/*     */   public void addWorkspace(WorkspaceType workspaceType, Workspace workspace) {
/*  43 */     switch (workspaceType) {
/*     */       case Station:
/*  45 */         addStation(workspace);
/*     */         break;
/*     */       case Square:
/*  48 */         addSquare(workspace);
/*     */         break;
/*     */       case Pavilion:
/*  51 */         addPavilion(workspace);
/*     */         break;
/*     */       case Cineroom:
/*  54 */         addCineroom(workspace);
/*     */         break;
/*     */       case Studio:
/*  57 */         this.studioWorkspace = workspace;
/*     */         break;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void addStation(Workspace workspace) {
/*  64 */     if (this.stationWorkspaces == null) {
/*  65 */       this.stationWorkspaces = new ArrayList<>();
/*  66 */       this.stationWorkspaces.add(workspace);
/*     */       
/*     */       return;
/*     */     } 
/*  70 */     mergeWorkspace(this.stationWorkspaces, workspace);
/*     */   }
/*     */ 
/*     */   
/*     */   public void addSquare(Workspace workspace) {
/*  75 */     if (this.squareWorkspaces == null) {
/*  76 */       this.squareWorkspaces = new ArrayList<>();
/*  77 */       this.squareWorkspaces.add(workspace);
/*     */       
/*     */       return;
/*     */     } 
/*  81 */     mergeWorkspace(this.squareWorkspaces, workspace);
/*     */   }
/*     */ 
/*     */   
/*     */   public void addPavilion(Workspace workspace) {
/*  86 */     if (this.pavilionWorkspaces == null) {
/*  87 */       this.pavilionWorkspaces = new ArrayList<>();
/*  88 */       this.pavilionWorkspaces.add(workspace);
/*     */       
/*     */       return;
/*     */     } 
/*  92 */     mergeWorkspace(this.pavilionWorkspaces, workspace);
/*     */   }
/*     */ 
/*     */   
/*     */   public void addCineroom(Workspace workspace) {
/*  97 */     if (this.cineroomWorkspaces == null) {
/*  98 */       this.cineroomWorkspaces = new ArrayList<>();
/*  99 */       this.cineroomWorkspaces.add(workspace);
/*     */       
/*     */       return;
/*     */     } 
/* 103 */     mergeWorkspace(this.cineroomWorkspaces, workspace);
/*     */   }
/*     */ 
/*     */   
/*     */   public void removeWorkspace(WorkspaceType workspaceType, String workspaceId) {
/* 108 */     switch (workspaceType) {
/*     */       case Station:
/* 110 */         removeWorkspace(workspaceId, this.stationWorkspaces);
/*     */         break;
/*     */       case Square:
/* 113 */         removeWorkspace(workspaceId, this.squareWorkspaces);
/*     */         break;
/*     */       case Pavilion:
/* 116 */         removeWorkspace(workspaceId, this.pavilionWorkspaces);
/*     */         break;
/*     */       case Cineroom:
/* 119 */         removeWorkspace(workspaceId, this.cineroomWorkspaces);
/*     */         break;
/*     */       case Studio:
/* 122 */         if (workspaceId.equals(this.studioWorkspace.getId())) {
/* 123 */           this.studioWorkspace = null;
/*     */         }
/*     */         break;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void removeWorkspace(String workspaceId, List<Workspace> workspaces) {
/* 131 */     for (int i = 0; i < workspaces.size(); i++) {
/* 132 */       Workspace workspace = workspaces.get(i);
/* 133 */       if (workspaceId.equals(workspace.getId())) {
/* 134 */         workspaces.remove(workspace);
/*     */         break;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void mergeWorkspace(List<Workspace> workspaces, Workspace addingWorkspace) {
/* 142 */     boolean merged = false;
/* 143 */     for (Workspace workspace : workspaces) {
/*     */       
/* 145 */       if (StringUtil.equals(workspace.getId(), addingWorkspace.getId())) {
/* 146 */         workspace.setName(addingWorkspace.getName());
/* 147 */         workspace.setTenantId(addingWorkspace.getTenantId());
/* 148 */         workspace.setRoles(addingWorkspace.getRoles());
/* 149 */         merged = true;
/*     */       } 
/*     */     } 
/*     */     
/* 153 */     if (!merged) {
/* 154 */       workspaces.add(addingWorkspace);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void resetWorkspace(WorkspaceType workspaceType, Workspace workspace) {
/* 160 */     switch (workspaceType) {
/*     */       case Station:
/* 162 */         resetWorkspace(workspace, this.stationWorkspaces);
/*     */         break;
/*     */       case Square:
/* 165 */         resetWorkspace(workspace, this.squareWorkspaces);
/*     */         break;
/*     */       case Pavilion:
/* 168 */         resetWorkspace(workspace, this.pavilionWorkspaces);
/*     */         break;
/*     */       case Cineroom:
/* 171 */         resetWorkspace(workspace, this.cineroomWorkspaces);
/*     */         break;
/*     */       case Studio:
/* 174 */         if (workspace.getId().equals(this.studioWorkspace.getId())) {
/* 175 */           this.studioWorkspace = workspace;
/*     */         }
/*     */         break;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void resetWorkspace(Workspace newWorkspace, List<Workspace> workspaces) {
/* 183 */     for (int i = 0; i < workspaces.size(); i++) {
/* 184 */       Workspace workspace = workspaces.get(i);
/* 185 */       if (workspace.getId().equals(newWorkspace.getId())) {
/* 186 */         workspaces.remove(workspace);
/* 187 */         workspaces.add(newWorkspace);
/*     */         break;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static WorkspaceList sample() {
/* 195 */     WorkspaceList workspaceList = new WorkspaceList();
/* 196 */     workspaceList.addCineroom(Workspace.sample());
/* 197 */     return workspaceList;
/*     */   }
/*     */ 
/*     */   
/*     */   public static void main(String[] args) {
/* 202 */     System.out.println(sample());
/*     */   }
/*     */ }


/* Location:              /Users/jmlee90/Documents/mySUNI/deployments/base/accent/accent-0.5.1-20200131.120332-18.jar!/io/naraplatform/share/domain/nara/WorkspaceList.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */