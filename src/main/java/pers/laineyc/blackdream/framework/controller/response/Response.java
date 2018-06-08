package pers.laineyc.blackdream.framework.controller.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import pers.laineyc.blackdream.framework.exception.ErrorCode;
import java.io.Serializable;

/**
 * @author LaineyC
 *
 */
@ApiModel
public class Response<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "错误")
    private ErrorCode error;

    @ApiModelProperty(value = "数据")
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
