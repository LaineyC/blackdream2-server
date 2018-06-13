package pers.laineyc.blackdream.generator.constant;

/**
 * @author LaineyC
 */
public enum CreationStrategyLanguageEnum {

    JAVASCRIPT(1, "JAVASCRIPT"),

    ;

    /**
     *  编码
     */
    private int code;

    private String suffix;

    CreationStrategyLanguageEnum(int code, String suffix) {
        this.code = code;
        this.suffix = suffix;
    }

    public static CreationStrategyLanguageEnum value(Integer code){
        if(code == null){
            return null;
        }

        for(CreationStrategyLanguageEnum item:values()){
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

    public String getSuffix() {
        return suffix;
    }
}