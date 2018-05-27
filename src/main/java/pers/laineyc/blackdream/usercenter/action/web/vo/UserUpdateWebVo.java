package pers.laineyc.blackdream.usercenter.action.web.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import pers.laineyc.blackdream.framework.controller.response.Vo;
import java.util.Date;

/**
 * 用户
 * @author LaineyC
 */
@ApiModel
public class UserUpdateWebVo extends Vo {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    private Long id;

	public UserUpdateWebVo() {

	}

    public Long getId() {
        return this.id;
    }

	public void setId(Long id) {
        this.id = id;
    }

}