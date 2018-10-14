package pers.laineyc.blackdream.generator.service.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import pers.laineyc.blackdream.framework.service.domain.Domain;
import pers.laineyc.blackdream.usercenter.service.domain.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 生成器实例
 * @author LaineyC
 */
@ApiModel
public class GeneratorInstanceMakeResult extends Domain {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "异常信息")
    private List<String> errorMessageList = new ArrayList<>();

    @ApiModelProperty(value = "测试信息")
    private List<String> testMessageList = new ArrayList<>();

    @ApiModelProperty(value = "下载地址")
    private String url;

    @ApiModelProperty(value = "文件名")
    private String fileName;

	public GeneratorInstanceMakeResult() {

	}

    public List<String> getErrorMessageList() {
        return errorMessageList;
    }

    public void setErrorMessageList(List<String> errorMessageList) {
        this.errorMessageList = errorMessageList;
    }

    public List<String> getTestMessageList() {
        return testMessageList;
    }

    public void setTestMessageList(List<String> testMessageList) {
        this.testMessageList = testMessageList;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}