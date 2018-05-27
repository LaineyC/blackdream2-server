package pers.laineyc.blackdream.foundation.service;

import pers.laineyc.blackdream.foundation.service.parameter.EmailBatchSendParameter;
import pers.laineyc.blackdream.foundation.service.parameter.EmailSendParameter;

/**
 * 邮件Service
 * @author LaineyC
 */
public interface EmailService {

    /**
     * 发送单条邮件
     */
    void send(EmailSendParameter parameter);

    /**
     * 发送多条邮件
     */
    void batchSend(EmailBatchSendParameter parameter);

}