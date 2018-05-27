package pers.laineyc.blackdream.foundation.service.impl;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.springframework.beans.BeanUtils;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import pers.laineyc.blackdream.foundation.dao.po.RunLogPo;
import pers.laineyc.blackdream.foundation.service.RunLogService;
import pers.laineyc.blackdream.foundation.service.parameter.RunLogSendParameter;
import pers.laineyc.blackdream.framework.controller.request.Request;
import pers.laineyc.blackdream.framework.exception.BusinessException;
import pers.laineyc.blackdream.framework.model.Auth;
import pers.laineyc.blackdream.framework.service.BaseService;
import pers.laineyc.blackdream.framework.util.JsonObjectMapper;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;
import java.util.Map;

/**
 * SequenceServiceImpl
 *
 * @author LaineyC
 */
public class RunLogMongoServiceImpl extends BaseService implements RunLogService {

    @Resource
    private MongoTemplate mongoTemplate;

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
        sendMongo(parameter);
    }

    private void sendMongo(RunLogSendParameter parameter){
        RunLogPo runLog = new RunLogPo();

        String action = parameter.getAction();
        if(!StringUtils.hasText(action)){
            throw new BusinessException("缺少action参数");
        }
        runLog.setAction(action);

        String message = parameter.getMessage();
        if(!StringUtils.hasText(message)){
            throw new BusinessException("缺少message参数");
        }
        runLog.setMessage(message);

        Date invokeTime = parameter.getInvokeTime();
        runLog.setInvokeTime(invokeTime);

        Long runTime = parameter.getRunTime();
        runLog.setRunTime(runTime);

        Auth authParameter = parameter.getAuthParameter();

        Map<String ,Object> commonParameter = parameter.getCommonParameter();

        Request requestParameter = parameter.getRequestParameter();

        Throwable exception = parameter.getException();

        String authJsonString = "{}";
        String requestJsonString = "{}";
        String commonJsonString = "{}";
        String exceptionString = "";
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

        runLog.setAuthParameter(authJsonString);

        runLog.setRequestParameter(requestJsonString);

        runLog.setCommonParameter(commonJsonString);

        if(exception != null){
            runLog.setException(exceptionString);
        }

        mongoTemplate.insert(runLog, "RunLog");

    }

}
