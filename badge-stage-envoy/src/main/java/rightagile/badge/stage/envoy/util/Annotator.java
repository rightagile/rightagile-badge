/*     */
package rightagile.badge.stage.envoy.util;
/*     */

import com.google.common.base.Predicate;
import org.reflections.Configuration;
import org.reflections.Reflections;
import org.reflections.scanners.MethodAnnotationsScanner;
import org.reflections.scanners.Scanner;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.scanners.TypeAnnotationsScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import org.reflections.util.FilterBuilder;
import rightagile.badge.accent.shared.domain.drama.ServiceFeature;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.*;

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
/*     */
/*     */
/*     */
/*     */ public class Annotator {
    /*  21 */   private static final Collection<URL> classLoaderUrls = ClasspathHelper.forClassLoader();
    /*     */   private final Class<?> clazz;
    /*     */   private static Reflections reflections;

    /*     */
    /*     */
    public Annotator(Class<?> clazz) {
        /*  26 */
        this.clazz = clazz;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    public Class<?> getTargetClass() {
        /*  31 */
        return this.clazz;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    public String getTargetClassName() {
        /*  36 */
        return this.clazz.getSimpleName();
        /*     */
    }

    /*     */
    /*     */
    /*     */
    public boolean hasAnnotation(Class annotationClass) {
        /*  41 */
        /*  42 */
        /*     */
        return this.clazz.getAnnotation(annotationClass) != null;
        /*     */
        /*  45 */
        /*     */
    }

    /*     */
    /*     */
    /*     */
    public Annotation getAnnotation(Class annotationClass) {
        /*  50 */
        return this.clazz.getAnnotation(annotationClass);
        /*     */
    }

    /*     */
    /*     */
    /*     */
    public Class getAnnotatedSubClass(Class annotationClass) {
        /*  55 */
        Set<Class<?>> subClasses = reflections.getSubTypesOf((Class<Object>) this.clazz);
        /*  56 */
        for (Class<?> subClass : subClasses) {
            /*  57 */
            if (subClass.getAnnotation(annotationClass) != null) {
                /*  58 */
                return subClass;
                /*     */
            }
            /*     */
        }
        /*  61 */
        return null;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    public Annotation[] getTypeAnnotations() {
        /*  66 */
        return this.clazz.getAnnotations();
        /*     */
    }

    /*     */
    /*     */
    /*     */
    public Map<Method, Annotation> geteMethodAnnotations(Class<Annotation> annotationClass) {
        /*  71 */
        Map<Method, Annotation> annoteMap = new HashMap<>();
        /*  72 */
        Method[] methods = this.clazz.getMethods();
        /*  73 */
        for (Method method : methods) {
            /*  74 */
            Annotation methodAnnotation = method.getAnnotation(annotationClass);
            /*  75 */
            if (methodAnnotation != null) {
                /*  76 */
                annoteMap.put(method, methodAnnotation);
                /*     */
            }
            /*     */
        }
        /*     */
        /*  80 */
        return annoteMap;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    public Map<Method, Annotation[]> geteMethodAnnotations() {
        /*  85 */
        Map<Method, Annotation[]> annoteMap = new HashMap<>();
        /*  86 */
        Method[] methods = this.clazz.getMethods();
        /*  87 */
        for (Method method : methods) {
            /*  88 */
            annoteMap.put(method, method.getAnnotations());
            /*     */
        }
        /*     */
        /*  91 */
        return annoteMap;
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
    /*     */
    /*     */
    public static List<Annotator> requestWrappers(String packageName) {
        /* 103 */
        reflections = new Reflections((Configuration) (new ConfigurationBuilder()).setScanners(new Scanner[]{(Scanner) new SubTypesScanner(false), (Scanner) new TypeAnnotationsScanner(), (Scanner) new MethodAnnotationsScanner()}).setUrls(classLoaderUrls).filterInputsBy((Predicate) (new FilterBuilder()).include(FilterBuilder.prefix(packageName))));
        /*     */
        /* 105 */
        List<Annotator> annotators = new ArrayList<>();
        /* 106 */
        Set<Class<?>> clazzes = reflections.getTypesAnnotatedWith(ServiceFeature.class);
        /* 107 */
        for (Class<?> clazz : clazzes) {
            /* 108 */
            annotators.add(new Annotator(clazz));
            /*     */
        }
        /*     */
        /* 111 */
        return annotators;
        /*     */
    }
    /*     */
}


/* Location:              /Users/jmlee90/Documents/mySUNI/deployments/base/stage/stage-envoy-0.5.0-20200204.072024-15.jar!/io/naraplatform/envoy/util/Annotator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */