/*    */ package rightagile.badge.accent.shared.domain;
/*    */ 
/*    */

import rightagile.badge.accent.shared.domain.ddd.ValueObject;
import rightagile.badge.accent.shared.util.json.JsonUtil;

import java.io.Serializable;
import java.util.Objects;
import java.util.StringTokenizer;

/*    */
/*    */
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class IdName
/*    */   implements ValueObject, Serializable
/*    */ {
/*    */   private static final long serialVersionUID = 253022376813035322L;
/*    */   private String id;
/*    */   private String name;
/*    */   
/*    */   public void setId(String id) {
/* 20 */     this.id = id; } public void setName(String name) { this.name = name; }
/*    */ 
/*    */   
/*    */   public IdName() {}
/*    */   
/*    */   public String getId() {
/* 26 */     return this.id; } public String getName() {
/* 27 */     return this.name;
/*    */   }
/*    */   
/*    */   public IdName(String id, String name) {
/* 31 */     this.id = id;
/* 32 */     this.name = name;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 37 */     return toJson();
/*    */   }
/*    */ 
/*    */   
/*    */   public String toSimpleString() {
/* 42 */     return this.id + ":" + this.name;
/*    */   }
/*    */ 
/*    */   
/*    */   public static IdName fromSimpleString(String idNameStr) {
/* 47 */     StringTokenizer tokenizer = new StringTokenizer(idNameStr, ":");
/* 48 */     String id = tokenizer.nextToken();
/* 49 */     String name = tokenizer.nextToken();
/*    */     
/* 51 */     return new IdName(id, name);
/*    */   }
/*    */ 
/*    */   
/*    */   public static IdName sample() {
/* 56 */     String id = "1234";
/* 57 */     String name = "Steve Jobs";
/*    */     
/* 59 */     return new IdName(id, name);
/*    */   }
/*    */ 
/*    */   
/*    */   public static IdName fromJson(String json) {
/* 64 */     return (IdName) JsonUtil.fromJson(json, IdName.class);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean equals(Object target) {
/* 70 */     if (this == target) {
/* 71 */       return true;
/*    */     }
/*    */     
/* 74 */     if (target == null || getClass() != target.getClass()) {
/* 75 */       return false;
/*    */     }
/*    */     
/* 78 */     IdName idName = (IdName)target;
/* 79 */     return (Objects.equals(this.id, idName.id) && 
/* 80 */       Objects.equals(this.name, idName.name));
/*    */   }
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 85 */     return Objects.hash(new Object[] { this.id + this.name });
/*    */   }
/*    */ 
/*    */   
/*    */   public static void main(String[] args) {
/* 90 */     System.out.println(sample());
/* 91 */     System.out.println(fromSimpleString(sample().toSimpleString()));
/*    */   }
/*    */ }


/* Location:              /Users/jmlee90/Documents/mySUNI/deployments/base/accent/accent-0.5.1-20200131.120332-18.jar!/io/naraplatform/share/domain/IdName.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */