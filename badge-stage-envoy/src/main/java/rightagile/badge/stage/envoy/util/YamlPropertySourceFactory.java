/*    */
package rightagile.badge.stage.envoy.util;
/*    */
/*    */

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertySourceFactory;
import org.springframework.lang.Nullable;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

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
/*    */ public class YamlPropertySourceFactory
        /*    */ implements PropertySourceFactory
        /*    */ {
    /*    */
    public PropertySource<?> createPropertySource(@Nullable String name, EncodedResource resource) throws IOException {
        /* 19 */
        Properties propertiesFromYaml = loadYamlIntoProperties(resource);
        /* 20 */
        String sourceName = (name != null) ? name : resource.getResource().getFilename();
        /* 21 */
        return (PropertySource<?>) new PropertiesPropertySource(sourceName, propertiesFromYaml);
        /*    */
    }

    /*    */
    /*    */
    /*    */
    private Properties loadYamlIntoProperties(EncodedResource resource) throws FileNotFoundException {
        /*    */
        try {
            /* 27 */
            YamlPropertiesFactoryBean factory = new YamlPropertiesFactoryBean();
            /* 28 */
            factory.setResources(new Resource[]{resource.getResource()});
            /* 29 */
            factory.afterPropertiesSet();
            /* 30 */
            return factory.getObject();
            /* 31 */
        } catch (IllegalStateException e) {
            /*    */
            /* 33 */
            Throwable cause = e.getCause();
            /* 34 */
            if (cause instanceof FileNotFoundException)
                /* 35 */ throw (FileNotFoundException) e.getCause();
            /* 36 */
            throw e;
            /*    */
        }
        /*    */
    }
    /*    */
}


/* Location:              /Users/jmlee90/Documents/mySUNI/deployments/base/stage/stage-envoy-0.5.0-20200204.072024-15.jar!/io/naraplatform/envoy/util/YamlPropertySourceFactory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */