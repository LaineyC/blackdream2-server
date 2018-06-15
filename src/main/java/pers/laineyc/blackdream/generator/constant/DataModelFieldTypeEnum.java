package pers.laineyc.blackdream.generator.constant;

/**
 * @author LaineyC
 */
public enum DataModelFieldTypeEnum {

    //1Boolean；2Integer；3Decimal；4Text；5Enum；6Date；7Time；8DateTime；9Model

    BOOLEAN(1, "BOOLEAN"),

    INTEGER(2, "INTEGER"),

    DECIMAL(3, "DECIMAL"),

    TEXT(4, "TEXT"),

    ENUM(5, "ENUM"),

    DATE(6, "DATE"),

    TIME(7, "TIME"),

    DATETIME(8, "DATETIME"),

    MODEL(9, "MODEL"),

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