package pers.laineyc.blackdream.usercenter.tool;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import pers.laineyc.blackdream.configuration.constant.SystemConstant;
import pers.laineyc.blackdream.foundation.service.EmailService;
import pers.laineyc.blackdream.foundation.service.parameter.EmailSendParameter;
import pers.laineyc.blackdream.framework.exception.BusinessException;
import pers.laineyc.blackdream.framework.util.RegexUtil;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.Random;

/**
 * @author LaineyC
 */
@Component
public class EmailValidCodeTool {

    public static final String VALID_CODE_PLACE = "$VALID_CODE_REPLACE$";

    private static final String VALID_CODE_REPLACE = "\\$VALID_CODE_REPLACE\\$";

    @Value(SystemConstant.EMAIL_HOST_KEY)
    private String host;

    @Value(SystemConstant.EMAIL_USERNAME_KEY)
    private String username;

    @Value(SystemConstant.EMAIL_PASSWORD_KEY)
    private String password;

    @Autowired
    private EmailService emailService;

    public EmailValidCode send(String email, String subject, String message, String mobileValidCodeSessionKey, HttpServletRequest httpServletRequest){
        if(!StringUtils.hasText(email)){
            throw new BusinessException("邮箱不能为空");
        }
        if(!RegexUtil.isEmail(email)){
            throw new BusinessException("邮箱格式不正确");
        }

        Date now = new Date();

        HttpSession httpSession = httpServletRequest.getSession(false);
        EmailValidCode validCode = (EmailValidCode)httpSession.getAttribute(mobileValidCodeSessionKey);
        if(validCode != null){
            Integer interval = validCode.getInterval();
            Date createTime = validCode.getCreateTime();
            if(now.getTime() < createTime.getTime() + interval * 1000){
                EmailValidCode validCodeCopy = new EmailValidCode();
                validCodeCopy.setEmail(validCode.getEmail());
                validCodeCopy.setCreateTime(validCode.getCreateTime());
                validCodeCopy.setInterval(validCode.getInterval());
                validCodeCopy.setTimeout(validCode.getTimeout());
                validCodeCopy.setErrorTimes(validCode.getErrorTimes());
                return validCodeCopy;
            }
        }

        String[] numberTable = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        String code = "";
        for(int i = 0 ; i < 6 ; i ++){
            Random random = new Random();
            int randomNumber = random.nextInt(numberTable.length);
            code += numberTable[randomNumber];
        }

        EmailSendParameter emailSendParameter = new EmailSendParameter();
        emailSendParameter.setHost(host);
        emailSendParameter.setUsername(username);
        emailSendParameter.setPassword(password);
        emailSendParameter.setSenderEmail(username);
        emailSendParameter.setSenderName("BlackDream");
        emailSendParameter.setReceiverEmail(email);
        emailSendParameter.setReceiverName(email);
        emailSendParameter.setSubject(subject);
        emailSendParameter.setMessage(message.replaceAll(VALID_CODE_REPLACE, code));
        emailService.send(emailSendParameter);

        validCode = new EmailValidCode();
        validCode.setEmail(email);
        validCode.setCreateTime(now);
        validCode.setInterval(90);
        validCode.setTimeout(600);
        validCode.setValidCode(code);
        validCode.setErrorTimes(0);

        httpSession.setAttribute(mobileValidCodeSessionKey, validCode);

        EmailValidCode validCodeCopy = new EmailValidCode();
        validCodeCopy.setEmail(email);
        validCodeCopy.setCreateTime(now);
        validCodeCopy.setInterval(90);
        validCodeCopy.setTimeout(600);
        validCodeCopy.setErrorTimes(0);

        return validCodeCopy;
    }

    public void check(String email, String code, String mobileValidCodeSessionKey, HttpServletRequest httpServletRequest){
        HttpSession httpSession = httpServletRequest.getSession(false);
        EmailValidCode validCode = (EmailValidCode)httpSession.getAttribute(mobileValidCodeSessionKey);
        if(validCode == null){
            throw new BusinessException("请先发送验证码");
        }

        if(!StringUtils.hasText(code)){
            throw new BusinessException("缺少验证码参数");
        }

        if(!StringUtils.hasText(email)){
            throw new BusinessException("缺少邮箱参数");
        }
        if(!email.equals(validCode.getEmail())){
            throw new BusinessException("请先发送验证码");
        }

        Integer errorTimes = validCode.getErrorTimes();
        if(errorTimes >= 6){
            throw new BusinessException("错误次数过多，稍后请重新发送验证码");
        }

        String sessionValidCode = validCode.getValidCode();
        if(!code.equals(sessionValidCode)){
            validCode.setErrorTimes(validCode.getErrorTimes() + 1);
            httpSession.setAttribute(mobileValidCodeSessionKey, validCode);
            throw new BusinessException("验证码有误");
        }

        Date now = new Date();
        Integer timeout = validCode.getTimeout();
        Date createTime = validCode.getCreateTime();
        if(now.getTime() > createTime.getTime() + timeout * 1000){
            throw new BusinessException("验证码已过期");
        }
    }

}
