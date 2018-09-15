package pers.laineyc.blackdream.generator.constant;

/**
 * @author LaineyC
 */
public enum DataModelFieldDataTypeEnum {

    /**
     * 数据类型：1BOOLEAN；2INTEGER；3FLOAT；4NUMBER；5TEXT；6ENUM_SINGLE；7ENUM_MULTIPLE；8DATE；9TIME；10DATETIME；15MODEL_REF
     */
    BOOLEAN(1, "BOOLEAN"),

    INTEGER(2, "INTEGER"),

    FLOAT(3, "FLOAT"),

    NUMBER(4, "NUMBER"),

    TEXT(5, "TEXT"),

    ENUM_SINGLE(6, "ENUM_SINGLE"),

    ENUM_MULTIPLE(7, "ENUM_MULTIPLE"),

    DATE(8, "DATE"),

    TIME(9, "TIME"),

    DATETIME(10, "DATETIME"),

    MODEL_REF(15, "MODEL_REF"),

    ;

    /**
     *  编码
     */
    private int code;

    private String description;

    DataModelFieldDataTypeEnum(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public static DataModelFieldDataTypeEnum value(Integer code){
        if(code == null){
            return null;
        }

        for(DataModelFieldDataTypeEnum item:values()){
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