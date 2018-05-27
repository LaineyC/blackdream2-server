package pers.laineyc.blackdream.generator.constant;

/**
 * @author LaineyC
 */
public enum DataModelFieldTypeEnum {

    //数据类型：1Boolean；2Integer；3Decimal；4Text；5Enum；6Date；7Time；8Model

    VELOCITY(1, "vm"),

    FREEMARKER(2, "ftl"),

    ;

    /**
     *  编码
     */
    private int code;

    private String suffix;

    DataModelFieldTypeEnum(int code, String suffix) {
        this.code = code;
        this.suffix = suffix;
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

    public String getSuffix() {
        return suffix;
    }
}