package pers.laineyc.blackdream.generator.constant;

/**
 * @author LaineyC
 */
public enum DataModelAttributeDataTypeEnum {

    NONE(1, "BOOLEAN"),

    BOOLEAN(2, "BOOLEAN"),

    INTEGER(3, "INTEGER"),

    DECIMAL(4, "DECIMAL"),

    STRING(5, "STRING"),

    DATE(6, "DATE"),

    TIME(7, "TIME"),

    DATETIME(8, "DATETIME"),

    MODEL_REF(15, "MODEL_REF"),

    ;

    /**
     *  编码
     */
    private int code;

    private String description;

    DataModelAttributeDataTypeEnum(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public static DataModelAttributeDataTypeEnum value(Integer code){
        if(code == null){
            return null;
        }

        for(DataModelAttributeDataTypeEnum item:values()){
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