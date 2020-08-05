/*    */
package rightagile.badge.stage.envoy.spring.interceptor;
/*    */
/*    */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import rightagile.badge.stage.envoy.context.DramaContext;
import rightagile.badge.stage.envoy.context.DramaRequest;
import rightagile.badge.stage.envoy.context.StageContext;
import rightagile.badge.stage.envoy.spring.JwtUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
/*    */ public class DramaRequestInterceptor
        /*    */ extends HandlerInterceptorAdapter
        /*    */ {
    /* 17 */   private static final Logger log = LoggerFactory.getLogger(DramaRequestInterceptor.class);
    /*    */
    /*    */
    /*    */
    /*    */   private CustomRequestHandler customHandler;
    /*    */
    /*    */
    /*    */   private final JwtUtil jwtUtil;

    /*    */
    /*    */
    /*    */
    /*    */
    public DramaRequestInterceptor(JwtUtil jwtUtil) {
        /* 29 */
        this.jwtUtil = jwtUtil;
        /*    */
    }

    /*    */
    /*    */
    /*    */
    /*    */
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        /* 35 */
        if (request.getRequestURI().startsWith("/envoy/")) {
            /* 36 */
            return super.preHandle(request, response, handler);
            /*    */
        }
        /* 38 */
        String audienceId = request.getHeader("audienceId");
        /*    */
        /* 40 */
        if (audienceId == null) {
            /* 41 */
            DramaContext.getStage();
            StageContext.setCurrentRequest(new DramaRequest(null, null, null));
            /*    */
            /* 43 */
            return super.preHandle(request, response, handler);
            /*    */
        }
        /*    */
        /* 46 */
        DramaRequest dramaRequest = this.jwtUtil.createDramaRequest(audienceId);
        /* 47 */
        log.debug("Current request: {}", dramaRequest.toString());
        /*    */
        /* 49 */
        DramaContext.getStage();
        StageContext.setCurrentRequest(dramaRequest);
        /*    */
        /* 51 */
        if (this.customHandler != null) {
            /* 52 */
            this.customHandler.handleRequest(request, response);
            /*    */
        }
        /* 54 */
        return super.preHandle(request, response, handler);
        /*    */
    }

    /*    */
    /*    */
    /*    */
    /*    */
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        /* 60 */
        DramaContext.getStage();
        StageContext.clearCurrentRequest();
        /* 61 */
        super.afterCompletion(request, response, handler, ex);
        /*    */
    }
    /*    */
}


/* Location:              /Users/jmlee90/Documents/mySUNI/deployments/base/stage/stage-envoy-0.5.0-20200204.072024-15.jar!/io/naraplatform/envoy/spring/interceptor/DramaRequestInterceptor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */