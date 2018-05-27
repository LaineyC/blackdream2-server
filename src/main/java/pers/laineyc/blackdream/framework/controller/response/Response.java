package pers.laineyc.blackdream.framework.controller.response;

import pers.laineyc.blackdream.framework.exception.ErrorCode;
import java.io.Serializable;

/**
 * @author LaineyC
 *
 */
public class Response<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private ErrorCode error;

    private T body;

    public Response(){

    }

    public Response(T body){
        setBody(body);
    }

    public ErrorCode getError() {
        return error;
    }

    public void setError(ErrorCode error) {
        this.error = error;
    }

    public boolean hasError(){
        return this.error != null;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }

}
