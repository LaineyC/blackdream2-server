package pers.laineyc.blackdream.foundation.service.impl;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import pers.laineyc.blackdream.foundation.service.EmailService;
import pers.laineyc.blackdream.foundation.service.parameter.EmailBatchSendParameter;
import pers.laineyc.blackdream.foundation.service.parameter.EmailSendParameter;
import pers.laineyc.blackdream.framework.exception.BusinessException;
import pers.laineyc.blackdream.framework.exception.ErrorCode;
import pers.laineyc.blackdream.framework.service.BaseService;
import java.util.List;

/**
 * 短信服务
 * @author LaineyC
 */
@Service
public class EmailServiceImpl extends BaseService implements EmailService {

    public EmailServiceImpl(){

    }

    /**
     * 发送邮件
     */
    @Async
    public void send(EmailSendParameter parameter) {
        String host = parameter.getHost();
        if(!StringUtils.hasText(host)){
            throw new BusinessException("host不能为空");
        }

        String port = parameter.getPort();
        if(!StringUtils.hasText(port)){
            throw new BusinessException("port不能为空");
        }

        String username = parameter.getUsername();
        if(!StringUtils.hasText(username)){
            throw new BusinessException("用户名不能为空");
        }

        String password = parameter.getPassword();
        if(!StringUtils.hasText(password)){
            throw new BusinessException("密码不能为空");
        }

        String senderEmail = parameter.getSenderEmail();
        if(!StringUtils.hasText(senderEmail)){
            throw new BusinessException("发送者邮箱不能为空");
        }

        String senderName = parameter.getSenderName();

        String receiverEmail = parameter.getReceiverEmail();
        if(!StringUtils.hasText(receiverEmail)){
            throw new BusinessException("接收者邮箱不能为空");
        }

        String receiverName = parameter.getReceiverName();

        String subject = parameter.getSubject();
        if(!StringUtils.hasText(subject)){
            throw new BusinessException("邮箱主题不能为空");
        }

        String message = parameter.getMessage();
        if(!StringUtils.hasText(message)){
            throw new BusinessException("邮箱内容不能为空");
        }

        HtmlEmail email = new HtmlEmail();
        try {
            email.setHostName(host);
            email.setSslSmtpPort(port);
            email.setSSLOnConnect(true);
            email.setCharset("UTF-8");
            email.setAuthentication(username, password);
            email.setFrom(senderEmail, senderName);
            email.setSubject(subject);
            email.addTo(receiverEmail, receiverName);
            email.setHtmlMsg(message);
            email.send();
        }
        catch (EmailException e) {
            throw new BusinessException(e, new ErrorCode("邮件发送失败"));
        }
    }

    /**
     * 发送多条邮件
     */
    @Async
    public void batchSend(EmailBatchSendParameter parameter) {
        String host = parameter.getHost();
        if(!StringUtils.hasText(host)){
            throw new BusinessException("host不能为空");
        }

        String port = parameter.getPort();
        if(!StringUtils.hasText(port)){
            throw new BusinessException("port不能为空");
        }

        String username = parameter.getUsername();
        if(!StringUtils.hasText(username)){
            throw new BusinessException("用户名不能为空");
        }

        String password = parameter.getPassword();
        if(!StringUtils.hasText(password)){
            throw new BusinessException("密码不能为空");
        }

        String senderEmail = parameter.getSenderEmail();
        if(!StringUtils.hasText(senderEmail)){
            throw new BusinessException("发送者邮箱不能为空");
        }

        String senderName = parameter.getSenderName();

        List<EmailBatchSendParameter.Receiver> receiverList = parameter.getReceiverList();

        String subject = parameter.getSubject();
        if(!StringUtils.hasText(subject)){
            throw new BusinessException("邮箱主题不能为空");
        }

        String message = parameter.getMessage();
        if(!StringUtils.hasText(message)){
            throw new BusinessException("邮箱内容不能为空");
        }

        HtmlEmail email = new HtmlEmail();
        try {
            email.setHostName(host);
            email.setSslSmtpPort(port);
            email.setSSLOnConnect(true);
            email.setCharset("UTF-8");
            email.setAuthentication(username, password);
            email.setFrom(senderEmail, senderName);
            email.setSubject(subject);
            for(EmailBatchSendParameter.Receiver receiver : receiverList) {
                String receiverEmail = receiver.getEmail();
                if(!StringUtils.hasText(receiverEmail)){
                    throw new BusinessException("接收者邮箱不能为空");
                }

                String receiverName  = receiver.getName();
                if(StringUtils.hasText(receiverName)){
                    email.addTo(receiverEmail, receiverName);
                }
                else{
                    email.addTo(receiverEmail);
                }
            }
            email.setHtmlMsg(message);
            email.send();
        }
        catch (EmailException e) {
            throw new BusinessException(e, new ErrorCode("邮件发送失败"));
        }
    }

}