/*     */
package rightagile.badge.stage.envoy.context;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import rightagile.badge.accent.shared.util.exception.NaraException;
import rightagile.badge.stage.envoy.model.AuthTask;
import rightagile.badge.stage.envoy.model.DramaAuthPolicy;
import rightagile.badge.stage.envoy.util.DramaSpecReader;


/*     */
/*     */ public class DramaContext {
    /*  10 */   private static final Logger log = LoggerFactory.getLogger(DramaContext.class);
    /*     */
    /*     */
    /*     */   private static DramaContext instance;
    /*     */
    /*     */
    /*     */   private StageContext stageContext;
    /*     */
    /*     */
    /*     */   private DramaAuthPolicy dramaAuthPolicy;
    /*     */
    /*     */
    /*     */   private AuthTask authTask;
    /*     */
    /*     */
    /*     */   private String dramaId;
    /*     */
    /*     */
    /*     */   private String specPackage;
    /*     */
    /*     */   private ApplicationContext applicationContext;

    /*     */
    /*     */
    /*     */
    public static DramaContext getInstance() {
        /*  34 */
        if (instance == null) instance = new DramaContext();
        /*  35 */
        return instance;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    public static StageContext getStage() {
        /*  40 */
        return getInstance().getStageContext();
        /*     */
    }

    /*     */
    /*     */
    /*     */
    public static DramaRequest getCurrentRequest() {
        /*  45 */
        getStage();
        return StageContext.getCurrentRequest();
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public static void setCurrentRequest(DramaRequest dramaRequest) {
        /*  55 */
        getStage();
        StageContext.setCurrentRequest(dramaRequest);
        /*     */
    }

    /*     */
    /*     */
    /*     */
    public void initialize(ApplicationContext applicationContext) {
        /*  60 */
        log.debug("Initialize drama spec context");
        /*  61 */
        this.applicationContext = applicationContext;
        /*  62 */
        if (this.specPackage == null) throw new NaraException("Spec package must be set.");
        /*     */
        /*  64 */
        this.stageContext = new StageContext(applicationContext);
        /*     */
        /*     */
        /*  67 */
        this.dramaAuthPolicy = DramaSpecReader.readFromAnnotation(this.specPackage);
        /*  68 */
        this.authTask = new AuthTask(this.dramaAuthPolicy);
        /*     */
        /*  70 */
        log.debug("after read annotation");
        /*  71 */
        log.debug("DramaAuthPolicy : {}", this.dramaAuthPolicy);
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public void setDramaId(String dramaId) {
        /*  78 */
        this.dramaId = dramaId;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    public String getDramaId() {
        /*  83 */
        return this.dramaId;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    public void setSpecPackage(String specPackage) {
        /*  88 */
        this.specPackage = specPackage;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    public StageContext getStageContext() {
        /*  93 */
        return this.stageContext;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    public AuthTask getAuthTask() {
        /*  98 */
        return this.authTask;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    public DramaAuthPolicy getDramaAuthPolicy() {
        /* 103 */
        return this.dramaAuthPolicy;
        /*     */
    }
    /*     */
}


/* Location:              /Users/jmlee90/Documents/mySUNI/deployments/base/stage/stage-envoy-0.5.0-20200204.072024-15.jar!/io/naraplatform/envoy/context/DramaContext.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */