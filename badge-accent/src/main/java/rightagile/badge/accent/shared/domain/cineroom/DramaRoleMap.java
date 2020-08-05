/*     */ package rightagile.badge.accent.shared.domain.cineroom;
/*     */ 
/*     */

import rightagile.badge.accent.shared.domain.IdName;
import rightagile.badge.accent.shared.domain.RowColumnIndex;
import rightagile.badge.accent.shared.domain.drama.DramaKey;
import rightagile.badge.accent.shared.util.exception.ArgumentException;
import rightagile.badge.accent.shared.util.json.JsonSerializable;
import rightagile.badge.accent.shared.util.json.JsonUtil;

import java.util.Arrays;
import java.util.List;

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
/*     */ 
/*     */ public class DramaRoleMap
/*     */   implements JsonSerializable
/*     */ {
/*     */   private IdName drama;
/*     */   private List<String> dramaRoleKeys;
/*     */   private List<String> cineroomRoleKeys;
/*     */   private boolean[][] mappingCells;
/*     */   
/*     */   public DramaRoleMap() {}
/*     */   
/*     */   public DramaRoleMap(IdName drama, List<String> dramaRoleKeys, List<String> cineroomRoleKeys) {
/*  34 */     this.drama = drama;
/*  35 */     if (cineroomRoleKeys == null || cineroomRoleKeys.isEmpty() || dramaRoleKeys == null || dramaRoleKeys
/*  36 */       .isEmpty()) {
/*  37 */       throw new ArgumentException("No keys");
/*     */     }
/*     */     
/*  40 */     this.cineroomRoleKeys = cineroomRoleKeys;
/*  41 */     this.dramaRoleKeys = dramaRoleKeys;
/*  42 */     this.mappingCells = new boolean[dramaRoleKeys.size()][cineroomRoleKeys.size()];
/*  43 */     for (String dramaRoleKey : dramaRoleKeys) {
/*  44 */       for (String cineroomRoleKey : cineroomRoleKeys) {
/*  45 */         if (!dramaRoleKey.equals(cineroomRoleKey)) {
/*     */           continue;
/*     */         }
/*  48 */         RowColumnIndex rowColumnIndex = findIndex(dramaRoleKey, cineroomRoleKey);
/*  49 */         this.mappingCells[rowColumnIndex.getRowIndex()][rowColumnIndex.getColumnIndex()] = true;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/*  56 */     return toJson();
/*     */   }
/*     */ 
/*     */   
/*     */   public static DramaRoleMap fromJson(String json) {
/*  61 */     return (DramaRoleMap) JsonUtil.fromJson(json, DramaRoleMap.class);
/*     */   }
/*     */ 
/*     */   
/*     */   private RowColumnIndex findIndex(String cineroomRoleKey, String dramaRoleKey) {
/*  66 */     int dramaRoleKeyIndex = this.dramaRoleKeys.indexOf(dramaRoleKey);
/*  67 */     int cineroomRoleKeyIndex = this.cineroomRoleKeys.indexOf(cineroomRoleKey);
/*     */     
/*  69 */     return new RowColumnIndex(dramaRoleKeyIndex, cineroomRoleKeyIndex);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isMarked(String cineroomRoleKey, String dramaRoleKey) {
/*  74 */     RowColumnIndex rowColumnIndex = findIndex(cineroomRoleKey, dramaRoleKey);
/*     */     
/*  76 */     if (!rowColumnIndex.isValid()) {
/*  77 */       return false;
/*     */     }
/*  79 */     return this.mappingCells[rowColumnIndex.getRowIndex()][rowColumnIndex.getColumnIndex()];
/*     */   }
/*     */ 
/*     */   
/*     */   public DramaRoleMap mark(String cineroomRoleKey, String dramaRoleKey) {
/*  84 */     RowColumnIndex rowColumnIndex = findIndex(cineroomRoleKey, dramaRoleKey);
/*  85 */     this.mappingCells[rowColumnIndex.getRowIndex()][rowColumnIndex.getColumnIndex()] = true;
/*  86 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public DramaRoleMap unmark(String cineroomRoleKey, String dramaRoleKey) {
/*  91 */     RowColumnIndex rowColumnIndex = findIndex(cineroomRoleKey, dramaRoleKey);
/*  92 */     this.mappingCells[rowColumnIndex.getRowIndex()][rowColumnIndex.getColumnIndex()] = false;
/*  93 */     return this;
/*     */   }
/*     */   
/*     */   public IdName getDrama() {
/*  97 */     return this.drama;
/*     */   }
/*     */   
/*     */   public void setDrama(IdName drama) {
/* 101 */     this.drama = drama;
/*     */   }
/*     */   
/*     */   public List<String> getDramaRoleKeys() {
/* 105 */     return this.dramaRoleKeys;
/*     */   }
/*     */   
/*     */   public List<String> getCineroomRoleKeys() {
/* 109 */     return this.cineroomRoleKeys;
/*     */   }
/*     */   
/*     */   public boolean[][] getMappingCells() {
/* 113 */     return this.mappingCells;
/*     */   }
/*     */ 
/*     */   
/*     */   public static DramaRoleMap sample() {
/* 118 */     String dramaId = DramaKey.sample().getKeyString();
/* 119 */     IdName drama = new IdName(dramaId, "nara.drama.talk");
/* 120 */     List<String> dramaRoleKeys = Arrays.asList(new String[] { "Administrator", "User" });
/* 121 */     List<String> cineroomRoleKeys = Arrays.asList(new String[] { "Admin", "User", "Advisor" });
/*     */     
/* 123 */     return new DramaRoleMap(drama, dramaRoleKeys, cineroomRoleKeys);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void main(String[] args) {
/* 132 */     System.out.println(sample());
/* 133 */     System.out.println(sample().isMarked("User", "User"));
/* 134 */     System.out.println(sample().isMarked("Admin", "User"));
/* 135 */     System.out.println(sample().isMarked("Advisor", "Administrator"));
/* 136 */     System.out.println(sample().mark("Advisor", "Administrator").isMarked("Advisor", "Administrator"));
/*     */   }
/*     */ }


/* Location:              /Users/jmlee90/Documents/mySUNI/deployments/base/accent/accent-0.5.1-20200131.120332-18.jar!/io/naraplatform/share/domain/cineroom/DramaRoleMap.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */