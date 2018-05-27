package pers.laineyc.blackdream.usercenter.constant;

/**
 * @author LaineyC
 */
public enum UserStatusEnum {

    FROZEN(1, "Frozen"),

    ENABLE(2, "Enable"),

    ;

    /**
     *  编码
     */
    private int code;

    /**
     *  类型名称
     */
    private String description;

    UserStatusEnum(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public static UserStatusEnum value(Integer code){
        if(code == null){
            return null;
        }

        for(UserStatusEnum item:values()){
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