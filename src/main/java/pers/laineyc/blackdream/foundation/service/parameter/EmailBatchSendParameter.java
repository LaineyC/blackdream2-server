package pers.laineyc.blackdream.foundation.service.parameter;

import pers.laineyc.blackdream.framework.service.parameter.Parameter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author LaineyC
 */
public class EmailBatchSendParameter extends Parameter {

    /**
     * host
     */
    private String host;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 发件人的邮箱
     */
    private String senderEmail;

    /**
     * 发件人的姓名
     */
    private String senderName;

    /**
     * 收件人
     */
    private List<Receiver> receiverList = new ArrayList<>();

    /**
     * 邮件主题
     */
    private String subject;

    /**
     *  信息(支持HTML)
     */
    private String message;


    public EmailBatchSendParameter() {

    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSenderEmail() {
        return senderEmail;
    }

    public void setSenderEmail(String senderEmail) {
        this.senderEmail = senderEmail;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public List<Receiver> getReceiverList() {
        return receiverList;
    }

    public void setReceiverList(List<Receiver> receiverList) {
        this.receiverList = receiverList;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static class Receiver{

        private String email;

        private String name;

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}