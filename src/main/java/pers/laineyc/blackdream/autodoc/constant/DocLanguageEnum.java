package pers.laineyc.blackdream.autodoc.constant;

/**
 * @author LaineyC
 */
public enum DocLanguageEnum {

    JAVA(1, "JAVA"),

    ;

    /**
     *  编码
     */
    private int code;

    /**
     *  类型名称
     */
    private String description;

    DocLanguageEnum(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public static DocLanguageEnum value(Integer code){
        if(code == null){
            return null;
        }

        for(DocLanguageEnum item:values()){
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