package pers.laineyc.blackdream.generator.constant;

/**
 * @author LaineyC
 */
public enum GeneratorStatusEnum {

    DEVELOP(1, "开发"),

    RELEASE(2, "发布"),

    ;

    /**
     *  编码
     */
    private int code;

    /**
     *  类型名称
     */
    private String description;

    GeneratorStatusEnum(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public static GeneratorStatusEnum value(Integer code){
        if(code == null){
            return null;
        }

        for(GeneratorStatusEnum item:values()){
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