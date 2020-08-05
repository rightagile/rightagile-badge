package rightagile.badge.stage.envoy.spring.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CustomRequestHandler {
    void handleRequest(HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse) throws Exception;
}


/* Location:              /Users/jmlee90/Documents/mySUNI/deployments/base/stage/stage-envoy-0.5.0-20200204.072024-15.jar!/io/naraplatform/envoy/spring/interceptor/CustomRequestHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */