package pers.laineyc.blackdream.framework.exception;

/**
 * @author LaineyC
 *
 */
public class BusinessException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private ErrorCode errorCode;

    public BusinessException(){

    }

    public BusinessException(ErrorCode errorCode){
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public BusinessException(Throwable throwable, ErrorCode errorCode){
        super(errorCode.getMessage(), throwable);
        this.errorCode = errorCode;
    }

    public BusinessException(Throwable throwable, String message){
        super(message, throwable);
        this.errorCode = new ErrorCode(message);
    }

    public BusinessException(String message){
        super(message);
        this.errorCode = new ErrorCode(message);
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }
}