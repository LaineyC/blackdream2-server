package pers.laineyc.blackdream.generator.constant;

/**
 * @author LaineyC
 */
public enum DataModelFieldDisplayTypeEnum {

    /**
     * 显示方式：1默认显示；2默认隐藏；3强制显示；4强制隐藏
     */
    DEFAULT_DISPLAY(1, "DEFAULT_DISPLAY"),

    DEFAULT_HIDDEN(2, "DEFAULT_HIDDEN"),

    DISPLAY_ONLY(3, "DISPLAY_ONLY"),

    HIDDEN_ONLY(4, "HIDDEN_ONLY"),

    ;

    /**
     *  编码
     */
    private int code;

    private String description;

    DataModelFieldDisplayTypeEnum(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public static DataModelFieldDisplayTypeEnum value(Integer code){
        if(code == null){
            return null;
        }

        for(DataModelFieldDisplayTypeEnum item:values()){
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