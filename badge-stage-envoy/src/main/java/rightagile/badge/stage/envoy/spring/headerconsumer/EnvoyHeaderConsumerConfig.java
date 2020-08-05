/*    */
package rightagile.badge.stage.envoy.spring.headerconsumer;
/*    */
/*    */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpHeaders;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.function.Consumer;

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
@Configuration
/*    */ public class EnvoyHeaderConsumerConfig
        /*    */ {
    /*    */
    @Profile({"!default"})
    /*    */
    @Bean
    /*    */ public EnvoyHeaderConsumerProvider getEnvoyHeaderConsumerProvider() {
        /* 20 */
        final Consumer<HttpHeaders> consumer = new Consumer<HttpHeaders>()
                /*    */ {
            /*    */
            /*    */
            public void accept(HttpHeaders httpHeaders)
            /*    */ {
                /* 25 */
                ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
                /* 26 */
                if (requestAttributes == null) {
                    /*    */
                    return;
                    /*    */
                }
                /* 29 */
                HttpServletRequest request = requestAttributes.getRequest();
                /* 30 */
                String audienceId = request.getHeader("audienceId");
                /* 31 */
                if (audienceId != null) {
                    /* 32 */
                    httpHeaders.add("audienceId", audienceId);
                    /* 33 */
                    httpHeaders.add("Authorization", request.getHeader("Authorization"));
                    /*    */
                }
                /*    */
            }
            /*    */
        };
        /* 37 */
        return new EnvoyHeaderConsumerProvider()
                /*    */ {
            /*    */
            public Consumer<HttpHeaders> getConsumer()
            /*    */ {
                /* 41 */
                return consumer;
                /*    */
            }
            /*    */
        };
        /*    */
    }

    /*    */
    /*    */
    /*    */
    @Profile({"default"})
    /*    */
    @Bean
    /*    */ public EnvoyHeaderConsumerProvider getEnvoyHeaderConsumerDefaultProvider() {
        /* 50 */
        final Consumer<HttpHeaders> consumer = new Consumer<HttpHeaders>()
                /*    */ {
            /*    */
            /*    */
            public void accept(HttpHeaders httpHeaders)
            /*    */ {
                /* 55 */
                ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
                /* 56 */
                if (requestAttributes == null) {
                    /*    */
                    return;
                    /*    */
                }
                /* 59 */
                HttpServletRequest request = requestAttributes.getRequest();
                /* 60 */
                String audienceId = request.getHeader("audienceId");
                /* 61 */
                if (audienceId != null) {
                    /* 62 */
                    httpHeaders.add("audienceId", audienceId);
                    /* 63 */
                    httpHeaders.add("cineroomUsid", request.getHeader("cineroomUsid"));
                    /* 64 */
                    httpHeaders.add("cineroomRoles", request.getHeader("cineroomRoles"));
                    /* 65 */
                    httpHeaders.add("dramaRoles", request.getHeader("dramaRoles"));
                    /*    */
                }
                /*    */
            }
            /*    */
        };
        /* 69 */
        return new EnvoyHeaderConsumerProvider()
                /*    */ {
            /*    */
            public Consumer<HttpHeaders> getConsumer()
            /*    */ {
                /* 73 */
                return consumer;
                /*    */
            }
            /*    */
        };
        /*    */
    }
    /*    */
}


/* Location:              /Users/jmlee90/Documents/mySUNI/deployments/base/stage/stage-envoy-0.5.0-20200204.072024-15.jar!/io/naraplatform/envoy/spring/headerconsumer/EnvoyHeaderConsumerConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */