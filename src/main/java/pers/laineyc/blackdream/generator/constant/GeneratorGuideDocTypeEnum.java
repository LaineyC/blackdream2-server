package pers.laineyc.blackdream.generator.constant;

/**
 * @author LaineyC
 */
public enum GeneratorGuideDocTypeEnum {

    MARKDOWN(1, "md"),

    ;

    /**
     *  编码
     */
    private int code;

    private String suffix;

    GeneratorGuideDocTypeEnum(int code, String suffix) {
        this.code = code;
        this.suffix = suffix;
    }

    public static GeneratorGuideDocTypeEnum value(Integer code){
        if(code == null){
            return null;
        }

        for(GeneratorGuideDocTypeEnum item:values()){
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