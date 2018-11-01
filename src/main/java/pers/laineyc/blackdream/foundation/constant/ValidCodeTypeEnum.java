package pers.laineyc.blackdream.foundation.constant;

/**
 * ValidCodeTypeEnum
 *
 * @author LaineyC
 */
public enum ValidCodeTypeEnum {

    /**
     * 类型：1注册；2密码重置
     */
    REGISTER(1, "注册", "欢迎注册BlackDream，您的验证码：${validCode}"),

    PASSWORD_RESET(2, "密码重置", "您的验证码：${validCode}"),

    ;

    /**
     * 全局验证码占位符
     */
    public final static  String VALID_CODE_REPLACE = "\\$\\{validCode\\}";

    /**
     *  编码
     */
    private int code;

    /**
     *  类型名称
     */
    private String description;

    /**
     *  类型名称
     */
    private String template;

    ValidCodeTypeEnum(int code, String description, String template) {
        this.code = code;
        this.description = description;
        this.template = template;
    }

    public static ValidCodeTypeEnum value(Integer code){
        if(code == null){
            return null;
        }

        for(ValidCodeTypeEnum item:values()){
            if(item.code == code){
                return item;
            }
        }
        return null;
    }

    public static boolean hasCode(Integer code){
        return value(code) != null;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public String getTemplate() {
        return template;
    }
}
