package pers.laineyc.blackdream.framework.util;

import java.text.SimpleDateFormat;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author LaineyC
 */
public class JsonObjectMapper extends ObjectMapper{

    public JsonObjectMapper(){
        super();
        Jackson2ObjectMapperBuilder.json().configure(this);
        this.setSerializationInclusion(JsonInclude.Include.NON_NULL);
 		//空值不序列化
        this.configure(SerializationFeature.WRITE_NULL_MAP_VALUES, false);
 		//允许对象无属性
 		this.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
 		// 反序列化时，属性不存在的兼容处理
 		this.getDeserializationConfig().withoutFeatures(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
 		//日期格式序列化操作
 		this.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

        SimpleModule simpleModule = new SimpleModule();
        simpleModule.addSerializer(Long.class, ToStringSerializer.instance);
        simpleModule.addSerializer(Long.TYPE, ToStringSerializer.instance);

        this.registerModule(simpleModule);
    }

}