package pers.laineyc.blackdream.generator.constant;

/**
 * @author LaineyC
 */
public enum DataModelFieldTypeEnum {

    /**
     * 1BOOLEAN；2INTEGER；NUMBER；4TEXT；5ENUM_SINGLE；6ENUM_MULTIPLE；7DATE；8TIME；9DATETIME；10MODEL_REF
     */
    BOOLEAN(1, "BOOLEAN"),

    INTEGER(2, "INTEGER"),

    NUMBER(3, "NUMBER"),

    TEXT(4, "TEXT"),

    ENUM_SINGLE(5, "ENUM_SINGLE"),

    ENUM_MULTIPLE(6, "ENUM_MULTIPLE"),

    DATE(7, "DATE"),

    TIME(8, "TIME"),

    DATETIME(9, "DATETIME"),

    MODEL_REF(10, "MODEL_REF"),

    ;

    /**
     *  编码
     */
    private int code;

    private String description;

    DataModelFieldTypeEnum(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public static DataModelFieldTypeEnum value(Integer code){
        if(code == null){
            return null;
        }

        for(DataModelFieldTypeEnum item:values()){
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