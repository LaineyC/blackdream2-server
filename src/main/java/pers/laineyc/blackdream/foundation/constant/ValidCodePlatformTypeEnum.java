package pers.laineyc.blackdream.foundation.constant;

/**
 * ValidCodePlatformTypeEnum
 *
 * @author LaineyC
 */
public enum ValidCodePlatformTypeEnum {

    /**
     * 发送平台类型：1邮箱
     */
    EMAIL(1, "EMAIL"),

    ;

    /**
     *  编码
     */
    private int code;

    /**
     *  类型名称
     */
    private String description;

    ValidCodePlatformTypeEnum(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public static ValidCodePlatformTypeEnum value(Integer code){
        if(code == null){
            return null;
        }

        for(ValidCodePlatformTypeEnum item:values()){
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

}
