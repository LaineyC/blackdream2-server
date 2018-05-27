package pers.laineyc.blackdream.foundation.service.impl;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.scheduling.annotation.Async;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import pers.laineyc.blackdream.foundation.service.RunLogService;
import pers.laineyc.blackdream.foundation.service.parameter.RunLogSendParameter;
import pers.laineyc.blackdream.framework.controller.request.Request;
import pers.laineyc.blackdream.framework.exception.BusinessException;
import pers.laineyc.blackdream.framework.model.Auth;
import pers.laineyc.blackdream.framework.service.BaseService;
import pers.laineyc.blackdream.framework.util.JsonObjectMapper;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * SequenceServiceImpl
 *
 * @author LaineyC
 */
public class RunLogConsoleServiceImpl extends BaseService implements RunLogService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RunLogConsoleServiceImpl.class);

    private ObjectMapper objectMapper = new JsonObjectMapper();

    private ObjectMapper requestObjectMapper = new JsonObjectMapper(){
        {
            SimpleModule simpleModule = new SimpleModule();
            simpleModule.addSerializer(MultipartFile.class, new JsonSerializer<MultipartFile>() {
                public void serialize(MultipartFile multipartFile, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
                    jsonGenerator.writeStartObject();
                    jsonGenerator.writeStringField("originalFilename", multipartFile.getOriginalFilename());
                    jsonGenerator.writeStringField("name", multipartFile.getName());
                    jsonGenerator.writeNumberField("size", multipartFile.getSize());
                    jsonGenerator.writeStringField("contentType", multipartFile.getContentType());
                    jsonGenerator.writeEndObject();
                }
            });
            this.registerModule(simpleModule);
        }
    };

    @Async
    public void send(RunLogSendParameter parameter) {
        sendConsole(parameter);
    }

    private void sendConsole(RunLogSendParameter parameter){
        String action = parameter.getAction();
        if(!StringUtils.hasText(action)){
            throw new BusinessException("缺少action参数");
        }

        String message = parameter.getMessage();
        if(!StringUtils.hasText(message)){
            throw new BusinessException("缺少message参数");
        }

        Date invokeTime = parameter.getInvokeTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
        String invokeTimeString = simpleDateFormat.format(invokeTime);

        Long runTime = parameter.getRunTime();

        Auth authParameter = parameter.getAuthParameter();

        Map<String ,Object> commonParameter = parameter.getCommonParameter();

        Request requestParameter = parameter.getRequestParameter();

        Throwable exception = parameter.getException();

        String authJsonString = "{}";
        String requestJsonString = "{}";
        String commonJsonString = "{}";
        String exceptionString = null;
        try{
            if(authParameter != null) {
                Auth authParameterClone  = new Auth();
                BeanUtils.copyProperties(authParameter, authParameterClone);
                authJsonString = objectMapper.writeValueAsString(authParameterClone);
            }
            if(requestParameter != null){
                Request requestParameterClone = requestParameter.getClass().newInstance();
                BeanUtils.copyProperties(requestParameter, requestParameterClone, "auth");
                requestJsonString = requestObjectMapper.writeValueAsString(requestParameterClone);
            }
            if(commonParameter != null){
                commonJsonString = requestObjectMapper.writeValueAsString(commonParameter);
            }
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }

        if(exception != null){
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            exception.printStackTrace(printWriter);
            exceptionString = stringWriter.getBuffer().toString();
        }

        LOGGER.info(
                "接口名称：" + action
            + "，调用时间：" + invokeTimeString
            + "，运行时间：" + runTime + "ms"
            + "，认证参数：" + authJsonString
            + "，请求参数：" + requestJsonString
            + "，公共参数：" + commonJsonString
            + "，日志信息：" + message
            + (exception != null ? ("，异常信息：" + exceptionString) : "")
        );
    }

}
