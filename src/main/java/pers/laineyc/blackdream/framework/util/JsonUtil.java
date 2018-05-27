package pers.laineyc.blackdream.framework.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author LaineyC
 */
public final class JsonUtil {

    private static final ObjectMapper objectMapper = new JsonObjectMapper();

    public static void writeObject(File resultFile, Object object) {
        try {
            objectMapper.writeValue(resultFile, object);
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public static <T> T readObject(File src, Class<T> clazz) {
        try {
            return objectMapper.readValue(src, clazz);
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public static String toJson(Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public static <T> T toObject(String json, Class<T> clazz){
        if(!StringUtils.hasText(json)){
            return null;
        }
        try {
            return objectMapper.readValue(json, clazz);
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public static <T>  T toObject(InputStream inputStream, Class<T> clazz){
        if(inputStream == null){
            return null;
        }
        try {
            return objectMapper.readValue(inputStream, clazz);
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public static <T> List<T> toArray(String json, Class<T> clazz){
        if(!StringUtils.hasText(json)){
            return new ArrayList<>();
        }
        try {
            return objectMapper.readValue(json, objectMapper.getTypeFactory().constructCollectionType(List.class, clazz));
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
    }

}
