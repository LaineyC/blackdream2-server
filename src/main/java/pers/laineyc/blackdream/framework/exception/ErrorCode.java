package pers.laineyc.blackdream.framework.exception;

import java.io.Serializable;

/**
 * @author LaineyC
 *
 */
public class ErrorCode implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer code;

    private String message;

    public ErrorCode() {

    }

    public ErrorCode(String message) {
        this.message = message;
    }

    public ErrorCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
