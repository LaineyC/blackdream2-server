package pers.laineyc.blackdream.foundation.tool;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import pers.laineyc.blackdream.foundation.constant.ValidCodeTypeEnum;
import pers.laineyc.blackdream.foundation.service.parameter.*;
import pers.laineyc.blackdream.framework.exception.BusinessException;
import pers.laineyc.blackdream.foundation.dao.ValidCodeDao;

import java.util.Map;

/**
 * 验证码ServiceTool
 * @author LaineyC
 */
@Component
public class ValidCodeServiceTool{

    @Autowired
    private ValidCodeDao validCodeDao;

    public ValidCodeServiceTool() {

	}

    /**
     * 验证码创建Validate
     */
    public void createValidate(ValidCodeCreateParameter parameter) {
        Integer type = parameter.getType();
        if(type == null){
            throw new BusinessException("缺少类型：1注册；2找回密码");
        }

        Integer platformType = parameter.getPlatformType();
        if(platformType == null){
            throw new BusinessException("缺少发送平台类型：1邮箱");
        }

        String platformAccount = parameter.getPlatformAccount();
        if(platformAccount == null){
            throw new BusinessException("缺少平台账号（如手机、邮箱）");
        }

        String code = parameter.getCode();
        if(code == null){
            throw new BusinessException("缺少验证码");
        }

        Integer interval = parameter.getInterval();

        Integer timeout = parameter.getTimeout();

        Integer failCount = parameter.getFailCount();

        Integer maxFailCount = parameter.getMaxFailCount();




    }

    /**
     * 验证码删除Validate
     */
    public void deleteValidate(ValidCodeDeleteParameter parameter) {
        String id = parameter.getId();
        if(id == null){
            throw new BusinessException("缺少主键");
        }
    }
    
    /**
     * 验证码修改Validate
     */
    public void updateValidate(ValidCodeUpdateParameter parameter) {
        String id = parameter.getId();
        if(id == null){
            throw new BusinessException("缺少主键");
        }
        
        Integer type = parameter.getType();
        if(type == null){
            throw new BusinessException("缺少类型：1注册；2找回密码");
        }

        Integer platformType = parameter.getPlatformType();
        if(platformType == null){
            throw new BusinessException("缺少发送平台类型：1邮箱");
        }

        String platformAccount = parameter.getPlatformAccount();
        if(platformAccount == null){
            throw new BusinessException("缺少平台账号（如手机、邮箱）");
        }

        String code = parameter.getCode();
        if(code == null){
            throw new BusinessException("缺少验证码");
        }

        Integer interval = parameter.getInterval();

        Integer timeout = parameter.getTimeout();

        Integer failCount = parameter.getFailCount();

        Integer maxFailCount = parameter.getMaxFailCount();




    }
    
    /**
     * 验证码单个查询Validate
     */
    public void getValidate(ValidCodeGetParameter parameter) {
        String id = parameter.getId();
        if(id == null) {
            throw new BusinessException("缺少主键");
        }
    }

    /**
     * 验证码多个查询Validate
     */
    public void queryValidate(ValidCodeQueryParameter parameter) {

    }

    /**
     * 验证码分页查询Validate
     */
    public void searchValidate(ValidCodeSearchParameter parameter) {
        Integer page = parameter.getPage();
        if(page == null || page < 1){
            throw new BusinessException("页数不合法");
        }

        Integer pageSize = parameter.getPageSize();
        if(pageSize == null || pageSize < 1 || pageSize > 100){
            throw new BusinessException("每页数量不合法");
        }
    }

    /**
     * 验证码验证有效Validate
     */
    public void sendValidate(ValidCodeSendParameter parameter) {
        ValidCodeTypeEnum type = parameter.getType();

        Integer platformType = parameter.getPlatformType();

        String platformAccount = parameter.getPlatformAccount();

        String code = parameter.getCode();

        Integer interval = parameter.getInterval();

        Integer timeout = parameter.getTimeout();

        Integer maxFailCount = parameter.getMaxFailCount();

        Map<String, String> templateParameter = parameter.getTemplateParameter();
    }

    /**
     * 验证码验证有效Validate
     */
    public void checkValidate(ValidCodeCheckParameter parameter) {
        ValidCodeTypeEnum typeEnum = parameter.getType();

        if(typeEnum == null){
            throw new BusinessException("缺少类型");
        }

        String platformAccount = parameter.getPlatformAccount();
        if(platformAccount == null){
            throw new BusinessException("缺少平台账号（如手机、邮箱）");
        }

        String code = parameter.getCode();
        if(code == null){
            throw new BusinessException("缺少验证码");
        }
    }
    
}