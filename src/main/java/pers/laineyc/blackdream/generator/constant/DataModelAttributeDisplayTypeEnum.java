package pers.laineyc.blackdream.generator.constant;

/**
 * @author LaineyC
 */
public enum DataModelAttributeDisplayTypeEnum {

    /**
     * 显示方式：1默认显示；2默认隐藏；3强制显示；4强制隐藏
     */
    DISPLAY_DEFAULT(1, "DEFAULT_DISPLAY"),

    HIDDEN_DEFAULT(2, "DEFAULT_HIDDEN"),

    DISPLAY_ONLY(3, "DISPLAY_ONLY"),

    HIDDEN_ONLY(4, "HIDDEN_ONLY"),

    ;

    /**
     *  编码
     */
    private int code;

    private String description;

    DataModelAttributeDisplayTypeEnum(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public static DataModelAttributeDisplayTypeEnum value(Integer code){
        if(code == null){
            return null;
        }

        for(DataModelAttributeDisplayTypeEnum item:values()){
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