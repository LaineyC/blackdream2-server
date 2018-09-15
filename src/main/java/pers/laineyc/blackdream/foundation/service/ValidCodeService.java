package pers.laineyc.blackdream.foundation.service;

import pers.laineyc.blackdream.foundation.service.parameter.*;
import pers.laineyc.blackdream.framework.service.Service;
import pers.laineyc.blackdream.framework.model.PageResult;
import pers.laineyc.blackdream.foundation.service.domain.ValidCode;
import java.util.List; 

/**
 * 验证码Service
 * @author LaineyC
 */
public interface ValidCodeService extends Service{

    /**
     * 验证码创建
     */
    ValidCode create(ValidCodeCreateParameter parameter);

    /**
     * 验证码删除
     */
    ValidCode delete(ValidCodeDeleteParameter parameter);
    
    /**
     * 验证码修改
     */
    ValidCode update(ValidCodeUpdateParameter parameter);
    
    /**
     * 验证码单个查询
     */
    ValidCode get(ValidCodeGetParameter parameter);

    /**
     * 验证码多个查询
     */
    List<ValidCode> query(ValidCodeQueryParameter parameter);

    /**
     * 验证码分页查询
     */
    PageResult<ValidCode> search(ValidCodeSearchParameter parameter);

    /**
     * 验证码发送
     */
    ValidCode send(ValidCodeSendParameter parameter);

    /**
     * 验证码验证有效
     */
    ValidCode check(ValidCodeCheckParameter parameter);
    
}