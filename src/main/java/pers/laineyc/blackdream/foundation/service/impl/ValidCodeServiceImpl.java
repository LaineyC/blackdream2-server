package pers.laineyc.blackdream.foundation.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.context.annotation.Primary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import pers.laineyc.blackdream.configuration.constant.SystemConstant;
import pers.laineyc.blackdream.foundation.constant.ValidCodePlatformTypeEnum;
import pers.laineyc.blackdream.foundation.constant.ValidCodeTypeEnum;
import pers.laineyc.blackdream.foundation.service.EmailService;
import pers.laineyc.blackdream.foundation.service.parameter.*;
import pers.laineyc.blackdream.framework.model.Auth;
import pers.laineyc.blackdream.framework.service.BaseService;
import pers.laineyc.blackdream.framework.exception.BusinessException;
import pers.laineyc.blackdream.foundation.service.ValidCodeService;
import pers.laineyc.blackdream.foundation.tool.ValidCodeServiceTool;
import pers.laineyc.blackdream.framework.model.PageResult;
import pers.laineyc.blackdream.foundation.service.domain.ValidCode;
import pers.laineyc.blackdream.foundation.dao.po.ValidCodePo;
import pers.laineyc.blackdream.foundation.dao.query.ValidCodeQuery;
import pers.laineyc.blackdream.foundation.dao.ValidCodeDao;

import java.util.*;

/**
 * 验证码ServiceImpl
 * @author LaineyC
 */
@Primary
@Service
public class ValidCodeServiceImpl extends BaseService implements ValidCodeService {

    @Value(SystemConstant.EMAIL_HOST_KEY)
    private String host;

    @Value(SystemConstant.EMAIL_USERNAME_KEY)
    private String username;

    @Value(SystemConstant.EMAIL_PASSWORD_KEY)
    private String password;

    @Autowired
    private EmailService emailService;

    @Autowired
    private ValidCodeServiceTool validCodeServiceTool;

    @Autowired
    private ValidCodeDao validCodeDao;

    public ValidCodeServiceImpl() {

	}

    /**
     * 验证码创建
     */
    @Transactional
    public ValidCode create(ValidCodeCreateParameter parameter) {
        validCodeServiceTool.createValidate(parameter);

        Auth auth = parameter.getAuth();
    
        ValidCodePo validCodePo = new ValidCodePo();
        
        Integer type = parameter.getType();
        validCodePo.setType(type);

        Integer platformType = parameter.getPlatformType();
        validCodePo.setPlatformType(platformType);

        String platformAccount = parameter.getPlatformAccount();
        validCodePo.setPlatformAccount(platformAccount);

        String code = parameter.getCode();
        validCodePo.setCode(code);

        Integer interval = parameter.getInterval();
        validCodePo.setInterval(interval);

        Integer timeout = parameter.getTimeout();
        validCodePo.setTimeout(timeout);

        Integer failCount = parameter.getFailCount();
        validCodePo.setFailCount(failCount);

        Integer maxFailCount = parameter.getMaxFailCount();
        validCodePo.setMaxFailCount(maxFailCount);

        validCodePo.setIsDeleted(false);

        validCodePo.setCreateTime(new Date());

        validCodePo.setUpdateTime(new Date());

        validCodeDao.insert(validCodePo);

        ValidCode validCode = new ValidCode();
        validCode.setId(validCodePo.getId());

        return validCode;
    }

    /**
     * 验证码删除
     */
    @Transactional
    public ValidCode delete(ValidCodeDeleteParameter parameter) {
        validCodeServiceTool.deleteValidate(parameter);
        
        Auth auth = parameter.getAuth();
               
        String id = parameter.getId();
        ValidCodePo validCodePo = validCodeDao.selectById(id);
        if(validCodePo == null){
            throw new BusinessException("验证码不存在");
        }

        validCodeDao.delete(validCodePo);

        ValidCode validCode = new ValidCode();
        validCode.setId(id);

        return validCode;
    }
    
    /**
     * 验证码修改
     */
    @Transactional
    public ValidCode update(ValidCodeUpdateParameter parameter) {
        validCodeServiceTool.updateValidate(parameter);
      
        Auth auth = parameter.getAuth();

        String id = parameter.getId();
        ValidCodePo validCodePo = validCodeDao.selectById(id);
        if(validCodePo == null){
            throw new BusinessException("验证码不存在");
        }
        validCodePo.setId(id);
        
        Integer type = parameter.getType();
        validCodePo.setType(type);

        Integer platformType = parameter.getPlatformType();
        validCodePo.setPlatformType(platformType);

        String platformAccount = parameter.getPlatformAccount();
        validCodePo.setPlatformAccount(platformAccount);

        String code = parameter.getCode();
        validCodePo.setCode(code);

        Integer interval = parameter.getInterval();
        validCodePo.setInterval(interval);

        Integer timeout = parameter.getTimeout();
        validCodePo.setTimeout(timeout);

        Integer failCount = parameter.getFailCount();
        validCodePo.setFailCount(failCount);

        Integer maxFailCount = parameter.getMaxFailCount();
        validCodePo.setMaxFailCount(maxFailCount);

        validCodePo.setIsDeleted(false);

        validCodePo.setCreateTime(new Date());

        validCodePo.setUpdateTime(new Date());

        validCodeDao.update(validCodePo);

        ValidCode validCode = new ValidCode();
        validCode.setId(id);

        return validCode;
    }
    
    /**
     * 验证码单个查询
     */
    //@Transactional(readOnly = true)
    public ValidCode get(ValidCodeGetParameter parameter) {
        validCodeServiceTool.getValidate(parameter);
        
        Auth auth = parameter.getAuth();
        
        String id = parameter.getId();
        ValidCodePo validCodePo = validCodeDao.selectById(id);
        if(validCodePo == null) {
            throw new BusinessException("验证码不存在");
        }

        ValidCode validCode = new ValidCode();
        
        validCode.setId(validCodePo.getId());

        validCode.setType(validCodePo.getType());

        validCode.setPlatformType(validCodePo.getPlatformType());

        validCode.setPlatformAccount(validCodePo.getPlatformAccount());

        validCode.setCode(validCodePo.getCode());

        validCode.setInterval(validCodePo.getInterval());

        validCode.setTimeout(validCodePo.getTimeout());

        validCode.setFailCount(validCodePo.getFailCount());

        validCode.setMaxFailCount(validCodePo.getMaxFailCount());

        return validCode;
    }

    /**
     * 验证码多个查询
     */
    //@Transactional(readOnly = true)
    public List<ValidCode> query(ValidCodeQueryParameter parameter) {
        validCodeServiceTool.queryValidate(parameter);
    
        Auth auth = parameter.getAuth();
        
        ValidCodeQuery validCodeQuery = new ValidCodeQuery();
        validCodeQuery.setType(parameter.getType());
        validCodeQuery.setPlatformType(parameter.getPlatformType());
        validCodeQuery.setPlatformAccount(parameter.getPlatformAccount());
        validCodeQuery.setCode(parameter.getCode());
        validCodeQuery.setInterval(parameter.getInterval());
        validCodeQuery.setTimeout(parameter.getTimeout());
        validCodeQuery.setFailCount(parameter.getFailCount());
        validCodeQuery.setMaxFailCount(parameter.getMaxFailCount());

        List<ValidCodePo> validCodePoList = validCodeDao.selectList(validCodeQuery);

        List<ValidCode> validCodeList = new ArrayList<>();
        if(validCodePoList.isEmpty()){
            return validCodeList;
        }
        
        validCodePoList.forEach(po -> {
            ValidCode validCode = new ValidCode();

            validCode.setId(po.getId());

            validCode.setType(po.getType());

            validCode.setPlatformType(po.getPlatformType());

            validCode.setPlatformAccount(po.getPlatformAccount());

            validCode.setCode(po.getCode());

            validCode.setInterval(po.getInterval());

            validCode.setTimeout(po.getTimeout());

            validCode.setFailCount(po.getFailCount());

            validCode.setMaxFailCount(po.getMaxFailCount());

            validCodeList.add(validCode);
        });
        
        return validCodeList;
    }

    /**
     * 验证码分页查询
     */
    //@Transactional(readOnly = true)
    public PageResult<ValidCode> search(ValidCodeSearchParameter parameter) {
        validCodeServiceTool.searchValidate(parameter);
    
        Auth auth = parameter.getAuth();

        Integer page = parameter.getPage();

        Integer pageSize = parameter.getPageSize();
        
        PageResult<ValidCode> pageResult = new PageResult<>();
        List<ValidCode> records = pageResult.getRecords();

        ValidCodeQuery validCodeQuery = new ValidCodeQuery();
        validCodeQuery.setType(parameter.getType());
        validCodeQuery.setPlatformType(parameter.getPlatformType());
        validCodeQuery.setPlatformAccount(parameter.getPlatformAccount());
        validCodeQuery.setCode(parameter.getCode());
        validCodeQuery.setInterval(parameter.getInterval());
        validCodeQuery.setTimeout(parameter.getTimeout());
        validCodeQuery.setFailCount(parameter.getFailCount());
        validCodeQuery.setMaxFailCount(parameter.getMaxFailCount());
        validCodeQuery.limit((page - 1) * pageSize, pageSize);
        
        PageResult<ValidCodePo> validCodePoPageResult = validCodeDao.selectPage(validCodeQuery);
        pageResult.setTotal(validCodePoPageResult.getTotal());

        validCodePoPageResult.getRecords().forEach(po -> {
            ValidCode validCode = new ValidCode();

            validCode.setId(po.getId());

            validCode.setType(po.getType());

            validCode.setPlatformType(po.getPlatformType());

            validCode.setPlatformAccount(po.getPlatformAccount());

            validCode.setCode(po.getCode());

            validCode.setInterval(po.getInterval());

            validCode.setTimeout(po.getTimeout());

            validCode.setFailCount(po.getFailCount());

            validCode.setMaxFailCount(po.getMaxFailCount());

            records.add(validCode);
        });

        return pageResult;
    }


    /**
     * 验证码发送
     */
    @Transactional
    public ValidCode send(ValidCodeSendParameter parameter) {
        validCodeServiceTool.sendValidate(parameter);

        Auth auth = parameter.getAuth();

        String authUserId = null;
        if(auth != null){
            authUserId = auth.getUserId();
        }

        Date now = new Date();

        ValidCodeTypeEnum typeEnum = parameter.getType();
        Integer type = typeEnum.getCode();

        String platformAccount = parameter.getPlatformAccount();

        ValidCodeQuery validCodeQuery = new ValidCodeQuery();
        validCodeQuery.setIsDeleted(false);
        validCodeQuery.setType(type);
        validCodeQuery.setPlatformAccount(platformAccount);
        ValidCodePo validCodePo = validCodeDao.selectOne(validCodeQuery);
        if(validCodePo != null){
            Integer interval = validCodePo.getInterval();
            Date createTime = validCodePo.getCreateTime();
            if(now.getTime() < createTime.getTime() + interval * 1000){
                ValidCode validCode = new ValidCode();
                validCode.setPlatformAccount(validCodePo.getPlatformAccount());
                validCode.setCreateTime(validCodePo.getCreateTime());
                validCode.setInterval(validCodePo.getInterval());
                validCode.setTimeout(validCodePo.getTimeout());
                validCode.setFailCount(validCodePo.getFailCount());
                return validCode;
            }
            else{
                ValidCodePo validCodePoUpdate = new ValidCodePo();
                validCodePoUpdate.setId(validCodePo.getId());
                validCodePoUpdate.setIsDeleted(true);
                validCodeDao.updateSelective(validCodePoUpdate);
            }
        }

        validCodePo = new ValidCodePo();

        validCodePo.setUserId(authUserId);

        validCodePo.setType(type);

        Integer platformType = parameter.getPlatformType();
        validCodePo.setPlatformType(platformType);

        validCodePo.setPlatformAccount(platformAccount);

        String code = parameter.getCode();
        if(!StringUtils.hasText(code)){
            code = "";
            String[] numberTable = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
            for(int i = 0 ; i < 6 ; i++){
                Random random = new Random();
                int randomNumber = random.nextInt(numberTable.length);
                code += numberTable[randomNumber];
            }
        }
        validCodePo.setCode(code);

        Integer interval = parameter.getInterval();
        interval = interval == null ? 60 : interval;
        validCodePo.setInterval(interval);

        Integer timeout = parameter.getTimeout();
        timeout = timeout == null ? 600 : timeout;
        validCodePo.setTimeout(timeout);

        Integer failCount = 0;
        validCodePo.setFailCount(failCount);

        Integer maxFailCount = parameter.getMaxFailCount();
        maxFailCount = maxFailCount == null ? 5 : maxFailCount;
        validCodePo.setMaxFailCount(maxFailCount);

        validCodePo.setIsDeleted(false);

        validCodePo.setCreateTime(now);

        validCodePo.setUpdateTime(now);

        validCodeDao.insert(validCodePo);

        String messageTemplate = typeEnum.getTemplate();
        messageTemplate = messageTemplate.replaceAll(ValidCodeTypeEnum.VALID_CODE_REPLACE, code);

        Map<String, String> templateParameter = parameter.getTemplateParameter();
        for(Map.Entry<String, String> entry : templateParameter.entrySet()){
            messageTemplate = messageTemplate.replaceAll("\\$\\{" + entry.getKey() + "\\}", entry.getValue());
        }

        if(platformType == ValidCodePlatformTypeEnum.EMAIL.getCode()){
            EmailSendParameter emailSendParameter = new EmailSendParameter();
            emailSendParameter.setHost(host);
            emailSendParameter.setUsername(username);
            emailSendParameter.setPassword(password);
            emailSendParameter.setSenderEmail(username);
            emailSendParameter.setSenderName("BlackDream");
            emailSendParameter.setReceiverEmail(platformAccount);
            emailSendParameter.setReceiverName(platformAccount);
            emailSendParameter.setSubject(typeEnum.getDescription());
            emailSendParameter.setMessage(messageTemplate);
            emailService.send(emailSendParameter);
        }
        else{
            throw new UnsupportedOperationException("不支持此发送方式");
        }

        ValidCode validCode = new ValidCode();
        validCode.setPlatformAccount(validCodePo.getPlatformAccount());
        validCode.setCreateTime(now);
        validCode.setInterval(interval);
        validCode.setTimeout(timeout);
        validCode.setFailCount(failCount);

        return validCode;
    }

    /**
     * 验证码验证有效
     */
    @Transactional
    public ValidCode check(ValidCodeCheckParameter parameter) {
        validCodeServiceTool.checkValidate(parameter);
    
        Auth auth = parameter.getAuth();
        Date now = new Date();

        ValidCodeTypeEnum typeEnum = parameter.getType();
        Integer type = typeEnum.getCode();

        String platformAccount = parameter.getPlatformAccount();

        ValidCodeQuery validCodeQuery = new ValidCodeQuery();
        validCodeQuery.setIsDeleted(false);
        validCodeQuery.setType(type);
        validCodeQuery.setPlatformAccount(platformAccount);

        ValidCodePo validCodePo = validCodeDao.selectOne(validCodeQuery);
        if(validCodePo == null){
            throw new BusinessException("请先发送验证码");
        }

        Integer failCount = validCodePo.getFailCount();
        if(failCount >= validCodePo.getMaxFailCount()){
            throw new BusinessException("错误次数过多，稍后请重新发送验证码");
        }

        String code = parameter.getCode();
        if(!code.equals(validCodePo.getCode())){
            validCodePo.setFailCount(validCodePo.getFailCount() + 1);
            validCodeDao.update(validCodePo);
            throw new BusinessException("验证码有误");
        }

        Integer timeout = validCodePo.getTimeout();
        Date createTime = validCodePo.getCreateTime();
        if(now.getTime() > createTime.getTime() + timeout * 1000){
            throw new BusinessException("验证码已过期");
        }

        ValidCode validCode = new ValidCode();

        return validCode;
    }
    
}