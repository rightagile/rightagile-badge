/*    */
package rightagile.badge.stage.envoy.service.lifecycle;
/*    */
/*    */

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import rightagile.badge.stage.envoy.domain.spec.lifecycle.EnvoyServiceLycler;
import rightagile.badge.stage.envoy.proxy.lifecycle.EnvoyProxyLycler;

/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
@Configuration
/*    */ public class EnvoyServiceLyclerConfig
        /*    */ {
    /*    */
    @Value("${spring.profiles.active:default}")
    /*    */ private String activeProfile;

    /*    */
    /*    */
    @Bean
    /*    */ public EnvoyServiceLycler envoyServiceLycler(EnvoyProxyLycler proxyLycler) {
        /* 18 */
        return new EnvoyServiceSpringLycler(proxyLycler, this.activeProfile);
        /*    */
    }
    /*    */
}


/* Location:              /Users/jmlee90/Documents/mySUNI/deployments/base/stage/stage-envoy-0.5.0-20200204.072024-15.jar!/io/naraplatform/envoy/service/lifecycle/EnvoyServiceLyclerConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */