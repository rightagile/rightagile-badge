package rightagile.badge.accent.shared.util.json;

import com.fatboyindustrial.gsonjavatime.Converters;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.commons.lang3.StringUtils;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class JsonUtil {
    private static Gson gson = Converters.registerZonedDateTime(new GsonBuilder()).setPrettyPrinting().create();

    public JsonUtil() {
    }

    public static String toJson(Object obj) {
        return gson.toJson(obj);
    }

    public static <T> T fromJson(String json, Class<T> clazz) {
        return gson.fromJson(json, clazz);
    }

    public static <T> T fromJson(String jsonString, Type type) {
        return gson.fromJson(jsonString, type);
    }

    public static <T> List<T> fromJsonList(String json, Class<T> valueType) {
        if (json == null) {
            return null;
        } else {
            List<T> ObjectList = new ArrayList();
            if (StringUtils.isEmpty(json)) {
                return ObjectList;
            } else {
                Type collectionType = new JsonUtil.ListParameterizedType(valueType);
                Collection<T> links = (Collection)gson.fromJson(json, collectionType);
                if (links != null && !links.isEmpty()) {
                    Iterator linkIter = links.iterator();

                    while(linkIter.hasNext()) {
                        ObjectList.add((T) linkIter.next());
                    }

                    return ObjectList;
                } else {
                    return ObjectList;
                }
            }
        }
    }

    private static class ListParameterizedType implements ParameterizedType {
        private Type type;

        private ListParameterizedType(Type type) {
            this.type = type;
        }

        public Type[] getActualTypeArguments() {
            return new Type[]{this.type};
        }

        public Type getRawType() {
            return Collection.class;
        }

        public Type getOwnerType() {
            return null;
        }
    }
}