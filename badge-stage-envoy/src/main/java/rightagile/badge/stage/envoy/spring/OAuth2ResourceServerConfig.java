/*    */
package rightagile.badge.stage.envoy.spring;
/*    */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

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
@Configuration
/*    */
@EnableResourceServer
/*    */ public class OAuth2ResourceServerConfig extends ResourceServerConfigurerAdapter {
    /* 19 */   private static final Logger log = LoggerFactory.getLogger(OAuth2ResourceServerConfig.class);
    /*    */
    /*    */
    /*    */
    @Value("${spring.profiles.active:default}")
    /*    */ private String activeProfiles;
    /*    */
    /*    */
    /*    */
    @Value("${nara.signing_key:naraBizAdmin1!!}")
    /*    */ private String jwtSigningKey;
    /*    */
    /*    */
    /*    */
    @Value("${nara.public_resource_path:}")
    /*    */ private String publicResourcePathString;

    /*    */
    /*    */
    /*    */
    /*    */
    public void configure(HttpSecurity http) throws Exception {
        /* 36 */
        if (this.activeProfiles.equals("default")) {
            /* 37 */
            ((ExpressionUrlAuthorizationConfigurer.AuthorizedUrl) http
/* 38 */.authorizeRequests()
/* 39 */.antMatchers(new String[]{"/**"})).permitAll();
            /*    */
        } else {
            /*    */
            /* 42 */
            String[] publicResourcePaths = this.publicResourcePathString.split(",");
            /* 43 */
            log.debug("publicResourcePaths.length {}", Integer.valueOf(publicResourcePaths.length));
            /* 44 */
            for (int i = 0; i < publicResourcePaths.length; i++) {
                /* 45 */
                publicResourcePaths[i] = publicResourcePaths[i].trim();
                /* 46 */
                log.debug("publicResourcePaths[{}] '{}'", Integer.valueOf(i), publicResourcePaths[i]);
                /*    */
            }
            /* 48 */
            if (publicResourcePaths.length == 0 || (publicResourcePaths.length == 1 && publicResourcePaths[0]
/* 49 */.length() == 0)) {
                /* 50 */
                ((ExpressionUrlAuthorizationConfigurer.AuthorizedUrl) ((ExpressionUrlAuthorizationConfigurer.AuthorizedUrl) http
/* 51 */.authorizeRequests()
/* 52 */.antMatchers(new String[]{"/envoy/**"})).permitAll()
/* 53 */.anyRequest())
/* 54 */.authenticated();
                /*    */
            } else {
                /*    */
                /* 57 */
                log.debug("apply publicResourcePaths");
                /* 58 */
                ((ExpressionUrlAuthorizationConfigurer.AuthorizedUrl) ((ExpressionUrlAuthorizationConfigurer.AuthorizedUrl) ((ExpressionUrlAuthorizationConfigurer.AuthorizedUrl) http
/* 59 */.authorizeRequests()
/* 60 */.antMatchers(new String[]{"/envoy/**"})).permitAll()
/* 61 */.antMatchers(publicResourcePaths)).permitAll()
/* 62 */.anyRequest())
/* 63 */.authenticated();
                /*    */
            }
            /*    */
        }
        /*    */
    }

    /*    */
    /*    */
    /*    */
    /*    */
    public void configure(ResourceServerSecurityConfigurer config) {
        /* 71 */
        config.tokenServices((ResourceServerTokenServices) tokenServices());
        /*    */
    }

    /*    */
    /*    */
    /*    */
    /*    */
    @Bean
    /*    */ public TokenStore tokenStore() {
        /* 78 */
        return (TokenStore) new JwtTokenStore(jwtAccessTokenConverter());
        /*    */
    }

    /*    */
    /*    */
    /*    */
    /*    */
    @Bean
    /*    */
    @Primary
    /*    */ public DefaultTokenServices tokenServices() {
        /* 86 */
        DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
        /* 87 */
        defaultTokenServices.setTokenStore(tokenStore());
        /* 88 */
        defaultTokenServices.setSupportRefreshToken(true);
        /* 89 */
        return defaultTokenServices;
        /*    */
    }

    /*    */
    /*    */
    /*    */
    /*    */
    @Bean
    /*    */ public JwtAccessTokenConverter jwtAccessTokenConverter() {
        /* 96 */
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        /* 97 */
        converter.setSigningKey(this.jwtSigningKey);
        /* 98 */
        return converter;
        /*    */
    }
    /*    */
}


/* Location:              /Users/jmlee90/Documents/mySUNI/deployments/base/stage/stage-envoy-0.5.0-20200204.072024-15.jar!/io/naraplatform/envoy/spring/OAuth2ResourceServerConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */