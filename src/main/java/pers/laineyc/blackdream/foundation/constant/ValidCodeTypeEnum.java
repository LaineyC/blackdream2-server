package pers.laineyc.blackdream.foundation.constant;

/**
 * ValidCodeTypeEnum
 *
 * @author LaineyC
 */
public enum ValidCodeTypeEnum {

    /**
     * 类型：1注册；2找回密码
     */
    REGISTER(1, "注册", "欢迎注册BlackDream，您的验证码：${validCode}"),

    FIND_PASSWORD(2, "密码找回", "您的验证码：${validCode}"),

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
