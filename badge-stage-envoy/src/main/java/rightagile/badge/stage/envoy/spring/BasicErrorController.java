/*    */
package rightagile.badge.stage.envoy.spring;
/*    */
/*    */

import org.springframework.boot.autoconfigure.web.servlet.error.AbstractErrorController;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

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
@Controller
/*    */
@RequestMapping({"${server.error.path:${error.path:/error}}"})
/*    */ public class BasicErrorController
        /*    */ extends AbstractErrorController
        /*    */ {
    /*    */
    public BasicErrorController(ErrorAttributes errorAttributes) {
        /* 23 */
        super(errorAttributes);
        /*    */
    }

    /*    */
    /*    */
    /*    */
    public String getErrorPath() {
        /* 28 */
        return "";
        /*    */
    }

    /*    */
    /*    */
    /*    */
    @RequestMapping(produces = {"text/html"})
    /*    */ public ModelAndView errorHtml(HttpServletRequest request, HttpServletResponse response) {
        /* 34 */
        HttpStatus status = getStatus(request);
        /* 35 */
        Map<String, Object> model = new HashMap<>();
        /*    */
        /*    */
        /* 38 */
        model.put("message", "error");
        /*    */
        /* 40 */
        response.setStatus(status.value());
        /* 41 */
        ModelAndView modelAndView = resolveErrorView(request, response, status, model);
        /* 42 */
        return (modelAndView != null) ? modelAndView : new ModelAndView("error", model);
        /*    */
    }

    /*    */
    /*    */
    /*    */
    /*    */
    @RequestMapping
    /*    */ public ResponseEntity<Map<String, Object>> error(HttpServletRequest request) {
        /* 49 */
        Map<String, Object> body = new HashMap<>();
        /*    */
        /*    */
        /* 52 */
        body.put("error", Boolean.valueOf(true));
        /* 53 */
        body.put("message", "error");
        /* 54 */
        HttpStatus status = getStatus(request);
        /* 55 */
        return new ResponseEntity(body, status);
        /*    */
    }
    /*    */
}


/* Location:              /Users/jmlee90/Documents/mySUNI/deployments/base/stage/stage-envoy-0.5.0-20200204.072024-15.jar!/io/naraplatform/envoy/spring/BasicErrorController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */