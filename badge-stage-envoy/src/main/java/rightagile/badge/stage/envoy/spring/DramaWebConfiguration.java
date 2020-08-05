/*    */
package rightagile.badge.stage.envoy.spring;
/*    */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import rightagile.badge.stage.envoy.spring.interceptor.DefaultProfileDramaRequestInterceptor;
import rightagile.badge.stage.envoy.spring.interceptor.DramaRequestInterceptor;

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
/*    */ public class DramaWebConfiguration extends WebMvcConfigurationSupport {
    /* 13 */   private static final Logger log = LoggerFactory.getLogger(DramaWebConfiguration.class);
    /*    */
    /*    */
    /*    */
    @Value("${spring.profiles.active:default}")
    /*    */ private String activeProfiles;
    /*    */
    /*    */
    /*    */   private final JwtUtil jwtUtil;

    /*    */
    /*    */
    /*    */
    public DramaWebConfiguration(JwtUtil jwtUtil) {
        /* 24 */
        this.jwtUtil = jwtUtil;
        /*    */
    }

    /*    */
    /*    */
    /*    */
    /*    */
    protected void addInterceptors(InterceptorRegistry registry) {
        /* 30 */
        registry.addInterceptor((HandlerInterceptor) dramaRequestInterceptor());
        /*    */
    }

    /*    */
    /*    */
    /*    */
    protected HandlerInterceptorAdapter dramaRequestInterceptor() {
        /* 35 */
        if (this.activeProfiles.equals("default")) {
            /* 36 */
            return (HandlerInterceptorAdapter) new DefaultProfileDramaRequestInterceptor();
            /*    */
        }
        /* 38 */
        return (HandlerInterceptorAdapter) new DramaRequestInterceptor(this.jwtUtil);
        /*    */
    }

    /*    */
    /*    */
    /*    */
    /*    */
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        /* 44 */
        registry
/* 45 */.addResourceHandler(new String[]{"swagger-ui.html"
/* 46 */}).addResourceLocations(new String[]{"classpath:/META-INF/resources/"});
        /* 47 */
        registry
/* 48 */.addResourceHandler(new String[]{"/webjars/**"
/* 49 */}).addResourceLocations(new String[]{"classpath:/META-INF/resources/webjars/"});
        /*    */
    }
    /*    */
}


/* Location:              /Users/jmlee90/Documents/mySUNI/deployments/base/stage/stage-envoy-0.5.0-20200204.072024-15.jar!/io/naraplatform/envoy/spring/DramaWebConfiguration.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */