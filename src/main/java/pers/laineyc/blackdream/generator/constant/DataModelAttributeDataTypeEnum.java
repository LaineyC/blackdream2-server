package pers.laineyc.blackdream.generator.constant;

/**
 * @author LaineyC
 */
public enum DataModelAttributeDataTypeEnum {

    BOOLEAN(1, "BOOLEAN"),

    INTEGER(2, "INTEGER"),

    NUMBER(3, "NUMBER"),

    STRING(4, "STRING"),

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