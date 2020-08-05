/*    */ package rightagile.badge.accent.shared.domain;

import rightagile.badge.accent.shared.util.json.JsonSerializable;
import rightagile.badge.accent.shared.util.json.JsonUtil;

/*    */
/*    */
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RowColumnIndex
/*    */   implements JsonSerializable
/*    */ {
/*    */   private int rowIndex;
/*    */   private int columnIndex;
/*    */   
/*    */   public void setRowIndex(int rowIndex) {
/* 17 */     this.rowIndex = rowIndex; } public void setColumnIndex(int columnIndex) { this.columnIndex = columnIndex; } public RowColumnIndex(int rowIndex, int columnIndex) {
/* 18 */     this.rowIndex = rowIndex; this.columnIndex = columnIndex;
/*    */   }
/*    */   
/*    */   public RowColumnIndex() {}
/* 22 */   public int getRowIndex() { return this.rowIndex; } public int getColumnIndex() {
/* 23 */     return this.columnIndex;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 27 */     return toJson();
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isValid() {
/* 32 */     return (this.rowIndex >= 0 && this.columnIndex >= 0);
/*    */   }
/*    */ 
/*    */   
/*    */   public static RowColumnIndex fromJson(String json) {
/* 37 */     return (RowColumnIndex) JsonUtil.fromJson(json, RowColumnIndex.class);
/*    */   }
/*    */ 
/*    */   
/*    */   public static RowColumnIndex sample() {
/* 42 */     return new RowColumnIndex(1, 4);
/*    */   }
/*    */ 
/*    */   
/*    */   public static void main(String[] args) {
/* 47 */     System.out.println(sample());
/*    */   }
/*    */ }


/* Location:              /Users/jmlee90/Documents/mySUNI/deployments/base/accent/accent-0.5.1-20200131.120332-18.jar!/io/naraplatform/share/domain/RowColumnIndex.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */