package pers.laineyc.blackdream.generator.service.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import pers.laineyc.blackdream.framework.service.domain.Domain;
import pers.laineyc.blackdream.usercenter.service.domain.User;

/**
 * 生成器数据
 * @author LaineyC
 */
@ApiModel
public class TemplateFileContextGlobal extends Domain {

    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "生成号")
    private String generateId;

    @ApiModelProperty(value = "开发用户")
    private User developer;

    @ApiModelProperty(value = "所属用户")
    private User user;

    @ApiModelProperty(value = "所属生成器")
    private Generator generator;

    @ApiModelProperty(value = "生成器实例")
    private GeneratorInstance generatorInstance;

    @ApiModelProperty(value = "生成策略")
    private CreationStrategy creationStrategy;

	public TemplateFileContextGlobal() {

	}

    public String getGenerateId() {
        return generateId;
    }

    public void setGenerateId(String generateId) {
        this.generateId = generateId;
    }

    public User getDeveloper() {
        return developer;
    }

    public void setDeveloper(User developer) {
        this.developer = developer;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Generator getGenerator() {
        return generator;
    }

    public void setGenerator(Generator generator) {
        this.generator = generator;
    }

    public GeneratorInstance getGeneratorInstance() {
        return generatorInstance;
    }

    public void setGeneratorInstance(GeneratorInstance generatorInstance) {
        this.generatorInstance = generatorInstance;
    }

    public CreationStrategy getCreationStrategy() {
        return creationStrategy;
    }

    public void setCreationStrategy(CreationStrategy creationStrategy) {
        this.creationStrategy = creationStrategy;
    }
}