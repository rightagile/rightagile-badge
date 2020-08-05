/*    */
package rightagile.badge.stage.envoy.util;
/*    */

import rightagile.badge.accent.shared.domain.drama.AuthorizedRole;
import rightagile.badge.accent.shared.domain.drama.ServiceFeature;
import rightagile.badge.stage.envoy.model.DramaAuthPolicy;
import rightagile.badge.stage.envoy.model.FeatureAuthRole;
import rightagile.badge.stage.envoy.model.OperationAuthRole;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.*;

/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */

/*    */
/*    */ public class DramaSpecReader {
    /*    */
    public static DramaAuthPolicy readFromAnnotation(String packageName) {
        /* 18 */
        if (packageName == null) {
            /* 19 */
            throw new NoSuchElementException("DramaSpec.Settings.specPackage is null.");
            /*    */
        }
        /* 21 */
        List<Annotator> annotators = Annotator.requestWrappers(packageName);
        /* 22 */
        List<FeatureAuthRole> featureAuthRoles = extractFeatures(annotators);
        /* 23 */
        DramaAuthPolicy dramaAuthPolicy = new DramaAuthPolicy(featureAuthRoles);
        /* 24 */
        return dramaAuthPolicy;
        /*    */
    }

    /*    */
    /*    */
    /*    */
    private static List<FeatureAuthRole> extractFeatures(List<Annotator> annotators) {
        /* 29 */
        List<FeatureAuthRole> features = new ArrayList<>();
        /* 30 */
        for (Annotator annotator : annotators) {
            /* 31 */
            if (!annotator.hasAnnotation(ServiceFeature.class)) {
                /*    */
                continue;
                /*    */
            }
            /* 34 */
            ServiceFeature serviceFeature = (ServiceFeature) annotator.getAnnotation(ServiceFeature.class);
            /* 35 */
            FeatureAuthRole feature = createFeatureAuthRole((Annotation) serviceFeature);
            /* 36 */
            feature.setOperationAuthRoleMap(createMaximumOperations(annotator, feature));
            /* 37 */
            features.add(feature);
            /*    */
        }
        /*    */
        /* 40 */
        return features;
        /*    */
    }

    /*    */
    /*    */
    /*    */
    private static FeatureAuthRole createFeatureAuthRole(Annotation annotation) {
        /* 45 */
        String name = ((ServiceFeature) annotation).name();
        /* 46 */
        String[] editions = ((ServiceFeature) annotation).editions();
        /* 47 */
        String[] authorizedRoles = ((ServiceFeature) annotation).authorizedRoles();
        /*    */
        /* 49 */
        return new FeatureAuthRole(name, Arrays.asList(editions), Arrays.asList(authorizedRoles));
        /*    */
    }

    /*    */
    /*    */
    /*    */
    private static Map<String, OperationAuthRole> createMaximumOperations(Annotator annotator, FeatureAuthRole feature) {
        /* 54 */
        Map<String, OperationAuthRole> operationMap = new HashMap<>();
        /* 55 */
        Map<Method, Annotation[]> annotationMap = annotator.geteMethodAnnotations();
        /*    */
        /* 57 */
        for (Method method : annotationMap.keySet()) {
            /* 58 */
            String operationName = method.getName();
            /* 59 */
            List<String> paramTypes = new ArrayList<>();
            /* 60 */
            for (Parameter parameter : method.getParameters()) {
                /* 61 */
                paramTypes.add(parameter.getType().getSimpleName());
                /*    */
            }
            /* 63 */
            String[] roleNames = (String[]) feature.getAuthRoleKeys().toArray((Object[]) new String[1]);
            /* 64 */
            AuthorizedRole role = method.<AuthorizedRole>getAnnotation(AuthorizedRole.class);
            /* 65 */
            if (role != null) {
                /* 66 */
                roleNames = role.roleNames();
                /*    */
            }
            /*    */
            /*    */
            /*    */
            /* 71 */
            OperationAuthRole operation = new OperationAuthRole(operationName, paramTypes, Arrays.asList(roleNames));
            /* 72 */
            operationMap.put(operation.getOperationId(), operation);
            /*    */
        }
        /*    */
        /* 75 */
        return operationMap;
        /*    */
    }

    /*    */
    /*    */
    /*    */
    //private static Map<String, OperationAuthRole> createMinimalOperations(Annotator annotator) {
        /* 80 */
    //    Map<String, OperationAuthRole> operationMap = new HashMap<>();
        /* 81 */
    //    Map<Method, Annotation> annotationMap = annotator.geteMethodAnnotations(AuthorizedRole.class);
        /*    */
        /* 83 */
    //    for (Method method : annotationMap.keySet()) {
            /* 84 */
    //        AuthorizedRole role = (AuthorizedRole) annotationMap.get(method);
            /* 85 */
    //        String operationName = method.getName();
            /* 86 */
     //       List<String> paramTypes = new ArrayList<>();
            /* 87 */
     //       for (Parameter parameter : method.getParameters()) {
                /* 88 */
     //           paramTypes.add(parameter.getType().getSimpleName());
                /*    */
    //        }
            /*    */
            /*    */
            /*    */
            /* 93 */
     //       OperationAuthRole operation = new OperationAuthRole(operationName, paramTypes, Arrays.asList(role.roleNames()));
            /* 94 */
     //       operationMap.put(operation.getOperationId(), operation);
            /*    */
     //   }
        /*    */
        /* 97 */
    //    return operationMap;
        /*    */
    //}
    /*    */
}


/* Location:              /Users/jmlee90/Documents/mySUNI/deployments/base/stage/stage-envoy-0.5.0-20200204.072024-15.jar!/io/naraplatform/envoy/util/DramaSpecReader.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */