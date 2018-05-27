package pers.laineyc.blackdream.configuration.constant;

/**
 * @author LaineyC
 */
public enum RunLogLevelEnum {

    DEBUG(1, "DEBUG"),

    INFO(2, "INFO"),

    WARN(3, "WARN"),

    ERROR(4, "ERROR"),

    FATAL(5, "FATAL"),

    ;

    /**
     *  编码
     */
    private int code;

    /**
     *  类型名称
     */
    private String description;

    RunLogLevelEnum(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public static RunLogLevelEnum value(Integer code){
        if(code == null){
            return null;
        }

        for(RunLogLevelEnum item:values()){
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