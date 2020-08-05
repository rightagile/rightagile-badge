/*    */
package rightagile.badge.stage.envoy.spring.interceptor;
/*    */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import rightagile.badge.accent.shared.domain.nara.Workspace;
import rightagile.badge.accent.shared.domain.nara.WorkspaceList;
import rightagile.badge.accent.shared.domain.patron.AudienceKey;
import rightagile.badge.stage.envoy.context.DramaContext;
import rightagile.badge.stage.envoy.context.DramaRequest;
import rightagile.badge.stage.envoy.context.StageContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

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
/*    */ public class DefaultProfileDramaRequestInterceptor extends HandlerInterceptorAdapter {
    /* 18 */   private static final Logger log = LoggerFactory.getLogger(DefaultProfileDramaRequestInterceptor.class);
    /*    */
    /*    */
    /*    */
    /*    */
    /*    */   private CustomRequestHandler customHandler;

    /*    */
    /*    */
    /*    */
    /*    */
    /*    */
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        /* 29 */
        if (request.getRequestURI().startsWith("/envoy/")) {
            /* 30 */
            return super.preHandle(request, response, handler);
            /*    */
        }
        /* 32 */
        String audienceId = request.getHeader("audienceId");
        /*    */
        /* 34 */
        if (audienceId == null) {
            /* 35 */
            DramaContext.getStage();
            StageContext.setCurrentRequest(new DramaRequest(null, null, null));
            /*    */
            /* 37 */
            return super.preHandle(request, response, handler);
            /*    */
        }
        /* 39 */
        String cineroomId = AudienceKey.fromKeyString(audienceId).genCineroomKeyString();
        /* 40 */
        WorkspaceList workspaceList = new WorkspaceList();
        /* 41 */
        workspaceList.addCineroom(new Workspace(cineroomId, "temp cineroom", audienceId));
        /* 42 */
        List<String> cineroomRoles = (List<String>) Arrays.<String>stream(request.getHeader("cineroomRoles").split(",")).map(String::trim).collect(Collectors.toList());
        /*    */
        /* 44 */
        DramaRequest dramaRequest = new DramaRequest(audienceId, cineroomId, cineroomRoles, workspaceList, "test@test.com", new HashMap<>());
        /*    */
        /*    */
        /* 47 */
        log.debug("Current request: {}}", dramaRequest.toString());
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


/* Location:              /Users/jmlee90/Documents/mySUNI/deployments/base/stage/stage-envoy-0.5.0-20200204.072024-15.jar!/io/naraplatform/envoy/spring/interceptor/DefaultProfileDramaRequestInterceptor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */