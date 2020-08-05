/*    */
package rightagile.badge.stage.envoy.spring;
/*    */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import rightagile.badge.stage.envoy.context.DramaContext;

/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
@Component("stageContextRefreshedListener")
/*    */ public class DramaApplicationContextRefreshedListener implements ApplicationListener<ContextRefreshedEvent> {
    /* 10 */   private static final Logger log = LoggerFactory.getLogger(DramaApplicationContextRefreshedListener.class);
    /*    */
    /*    */
    /*    */
    /*    */   private final Environment environment;
    /*    */
    /*    */
    /*    */
    /*    */   private boolean contextInitialized = false;

    /*    */
    /*    */
    /*    */
    /*    */
    public DramaApplicationContextRefreshedListener(Environment environment) {
        /* 23 */
        this.environment = environment;
        /*    */
    }

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
    public void onApplicationEvent(ContextRefreshedEvent cse) {
        /* 38 */
        if (this.contextInitialized) {
            /*    */
            return;
            /*    */
        }
        /* 41 */
        String specScanPackage = this.environment.getProperty("domainSpecPackage");
        /* 42 */
        String dramaId = this.environment.getProperty("dramaId");
        /*    */
        /* 44 */
        log.debug("Handling context refreshed event.. specScanPackage : '{}', dramaId : '{}'", specScanPackage, dramaId);
        /*    */
        /*    */
        /*    */
        /*    */
        /*    */
        /*    */
        /*    */
        /* 52 */
        DramaContext dramaContext = DramaContext.getInstance();
        /* 53 */
        dramaContext.setDramaId(dramaId);
        /* 54 */
        dramaContext.setSpecPackage(specScanPackage);
        /* 55 */
        dramaContext.initialize(cse.getApplicationContext());
        /*    */
        /*    */
        /* 58 */
        this.contextInitialized = true;
        /*    */
    }
    /*    */
}


/* Location:              /Users/jmlee90/Documents/mySUNI/deployments/base/stage/stage-envoy-0.5.0-20200204.072024-15.jar!/io/naraplatform/envoy/spring/DramaApplicationContextRefreshedListener.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */