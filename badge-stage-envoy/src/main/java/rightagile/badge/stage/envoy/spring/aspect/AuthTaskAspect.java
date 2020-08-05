/*     */
package rightagile.badge.stage.envoy.spring.aspect;
/*     */

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import rightagile.badge.accent.shared.domain.drama.ServiceFeature;
import rightagile.badge.accent.shared.util.exception.NaraException;
import rightagile.badge.stage.envoy.domain.spec.AuthorizationFlowService;
import rightagile.badge.stage.envoy.domain.spec.lifecycle.EnvoyServiceLycler;

import java.lang.reflect.Method;

/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
@Component
/*     */
@Aspect
/*     */ public class AuthTaskAspect {
    /*  19 */   private static final Logger log = LoggerFactory.getLogger(AuthTaskAspect.class);
    /*     */
    /*     */
    /*     */
    @Value("${spring.profiles.active:default}")
    /*     */ private String activeProfiles;
    /*     */
    /*     */   private final AuthorizationFlowService authorizationFlowService;

    /*     */
    /*     */
    /*     */
    public AuthTaskAspect(EnvoyServiceLycler serviceLycler) {
        /*  29 */
        this.authorizationFlowService = serviceLycler.requestAuthorizationFlowService();
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*
    @Around("execution(public * rightagile..facade..*Facade+.*(..)) && execution(public * rightagile..rest..*Resource.*(..))")
    public Object arroundSkUnivMethodCall(ProceedingJoinPoint joinPoint) throws Throwable {
        return aroundServieMethodCall(joinPoint);
    }
     */

    @Before("execution(public * rightagile..facade..*Facade+.*(..)) && execution(public * rightagile..rest..*Resource.*(..))")
    /*     */ public void arroundSkUnivMethodCall(JoinPoint joinPoint) {
        /*  35 */
        aroundServieMethodCall(joinPoint);
        /*     */
    }
    /*     */
    /*     */
    /*     */
    /*     */
    /*
    @Around("execution(public * io.naradrama..facade..*Facade+.*(..)) && execution(public * io.naradrama..rest..*Resource.*(..)) ")
    public Object arroundNaraDramaMethodCall(ProceedingJoinPoint joinPoint) throws Throwable {
        return aroundServieMethodCall(joinPoint);
    }
     */

    /*     */
    /*     */
    /*     */
    /*     */
    public void aroundServieMethodCall(JoinPoint joinPoint) {
        /*  48 */
        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
        /*     */
        /*  50 */
        ServiceFeature serviceFeature = getServiceFeature(method);
        /*     */
        /*  52 */
        if (serviceFeature != null) {
            /*     */
            /*  54 */

            String[] editions = serviceFeature.editions();
            /*  55 */
            String featureName = serviceFeature.name();
            /*  56 */
            String operationId = getOperationId(method);
            boolean isAuthorized = this.authorizationFlowService.isAuthorized(editions, featureName, operationId);
            log.debug("feature {}, operation {}, isAuthorized {}\n", featureName, operationId, Boolean.valueOf(isAuthorized));
            log.debug("EXECUTED");

            if (!isAuthorized) {
                throw new NaraException("request is not authorized");
            }
        }
        /*
        Object result = null;
        try {
            result = joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            throw throwable;
        }
        return result;
        */
    }

    /*     */
    /*     */
    /*     */
    private String getOperationId(Method method) {
        /*  78 */
        if ((method.getParameterTypes()).length == 0) {
            /*  79 */
            return method.getName() + ":void";
            /*     */
        }
        /*     */
        /*  82 */
        StringBuilder builder = new StringBuilder();
        /*  83 */
        builder.append(method.getName());
        /*  84 */
        for (Class<?> param : method.getParameterTypes()) {
            /*  85 */
            builder.append(":").append(param.getSimpleName());
            /*     */
        }
        /*     */
        /*  88 */
        return builder.toString();
        /*     */
    }

    /*     */
    /*     */
    /*     */
    private ServiceFeature getServiceFeature(Method method) {
        /*  93 */
        Class<?>[] interfaces = method.getDeclaringClass().getInterfaces();
        /*     */
        /*  95 */
        ServiceFeature serviceFeature = null;
        /*  96 */
        for (Class<?> clazz : interfaces) {
            /*  97 */
            serviceFeature = clazz.<ServiceFeature>getAnnotation(ServiceFeature.class);
            /*  98 */
            if (serviceFeature != null) {
                /*     */
                break;
                /*     */
            }
            /*     */
        }
        /*     */
        /* 103 */
        return serviceFeature;
        /*     */
    }
    /*     */
}


/* Location:              /Users/jmlee90/Documents/mySUNI/deployments/base/stage/stage-envoy-0.5.0-20200204.072024-15.jar!/io/naraplatform/envoy/spring/aspect/AuthTaskAspect.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */