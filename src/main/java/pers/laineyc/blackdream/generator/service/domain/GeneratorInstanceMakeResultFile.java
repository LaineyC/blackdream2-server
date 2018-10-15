package pers.laineyc.blackdream.generator.service.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import pers.laineyc.blackdream.framework.service.domain.Domain;
import java.util.ArrayList;
import java.util.List;

/**
 * @author LaineyC
 */
@ApiModel
public class GeneratorInstanceMakeResultFile extends Domain{

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "路径")
    private String path;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "是否文件")
    private Boolean isFile;

    @ApiModelProperty(value = "子文件")
    private List<GeneratorInstanceMakeResultFile> children = new ArrayList<>();

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getIsFile() {
        return isFile;
    }

    public void setIsFile(Boolean isFile) {
        this.isFile = isFile;
    }

    public List<GeneratorInstanceMakeResultFile> getChildren() {
        return children;
    }

    public void setChildren(List<GeneratorInstanceMakeResultFile> children) {
        this.children = children;
    }

}