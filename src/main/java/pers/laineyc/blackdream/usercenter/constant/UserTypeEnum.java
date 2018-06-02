package pers.laineyc.blackdream.usercenter.constant;

/**
 * @author LaineyC
 */
public enum UserTypeEnum {

    /**
     * 状态：1一般用户；2开发用户
     */
    GENERAL(1, "GENERAL"),

    DEVELOPER(2, "DEVELOPER"),

    ;

    /**
     *  编码
     */
    private int code;

    /**
     *  类型名称
     */
    private String description;

    UserTypeEnum(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public static UserTypeEnum value(Integer code){
        if(code == null){
            return null;
        }

        for(UserTypeEnum item:values()){
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