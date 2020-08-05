/*    */ package rightagile.badge.stage.client.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.web.reactive.function.client.WebClient;

/*    */
/*    */ @Configuration
/*    */ public class StageEnvoyWebClientConfig {
/* 10 */   private static final Logger log = LoggerFactory.getLogger(StageEnvoyWebClientConfig.class);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @Bean
/*    */   @Qualifier("stageEnvoyWebClient")
/*    */   public WebClient getStageEnvoyWebClient(StageBaseUrl stageBaseUrl) {
/* 20 */     log.debug("stageBaseUrl : {}", stageBaseUrl);
/*    */ 
/*    */ 
/*    */     
/* 24 */     WebClient client = WebClient.builder().baseUrl(stageBaseUrl.getUrl()).build();
/*    */     
/* 26 */     return client;
/*    */   }
/*    */ 
/*    */   
/*    */   @Bean
/*    */   public static PropertySourcesPlaceholderConfigurer propertyPlaceholderConfigurer() {
/* 32 */     return new PropertySourcesPlaceholderConfigurer();
/*    */   }
/*    */ }


/* Location:              /Users/jmlee90/Documents/mySUNI/deployments/base/stage/stage-client-0.5.0-20191216.092137-2.jar!/io/naraplatform/stage/client/config/StageEnvoyWebClientConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */