package pers.laineyc.blackdream.generator.constant;

/**
 * @author LaineyC
 */
public enum TemplateEngineTypeEnum {

    VELOCITY(1, "vm"),

    FREEMARKER(2, "ftl"),

    ;

    /**
     *  编码
     */
    private int code;

    private String suffix;

    TemplateEngineTypeEnum(int code, String suffix) {
        this.code = code;
        this.suffix = suffix;
    }

    public static TemplateEngineTypeEnum value(Integer code){
        if(code == null){
            return null;
        }

        for(TemplateEngineTypeEnum item:values()){
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