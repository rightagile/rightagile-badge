/*    */ package rightagile.badge.stage.client.config;
/*    */ 
/*    */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/*    */
/*    */
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Configuration
/*    */ public class StageBaseUrlConfig
/*    */ {
/*    */   @Profile({"k8s"})
/*    */   @Bean
/*    */   public StageBaseUrl k8sStageBaseUrl() {
/* 24 */     return new StageBaseUrl("http://stage:8080");
/*    */   }
/*    */ 
/*    */   
/*    */   @Profile({"local"})
/*    */   @Bean
/*    */   public StageBaseUrl localStageBaseUrl() {
/* 31 */     return new StageBaseUrl("http://stage:8093");
/*    */   }
/*    */ 
/*    */   
/*    */   @Profile({"dev"})
/*    */   @Bean
/*    */   public StageBaseUrl devStageBaseUrl() {
/* 38 */     return new StageBaseUrl("http://stage:8080");
/*    */   }
/*    */ 
/*    */   
/*    */   @Profile({"default"})
/*    */   @Bean
/*    */   public StageBaseUrl defaultStageBaseUrl() {
/* 45 */     return new StageBaseUrl("http://stage:8093");
/*    */   }
/*    */ }


/* Location:              /Users/jmlee90/Documents/mySUNI/deployments/base/stage/stage-client-0.5.0-20191216.092137-2.jar!/io/naraplatform/stage/client/config/StageBaseUrlConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */