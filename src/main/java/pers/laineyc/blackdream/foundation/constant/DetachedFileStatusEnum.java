package pers.laineyc.blackdream.foundation.constant;

/**
 * DetachedFileStatusEnum
 *
 * @author LaineyC
 */
public enum DetachedFileStatusEnum {

    DETACHED(1, "DETACHED"),

    MANAGED(2, "MANAGED"),

    ;

    /**
     *  编码
     */
    private int code;

    /**
     *  类型名称
     */
    private String description;

    DetachedFileStatusEnum(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public static DetachedFileStatusEnum value(Integer code){
        if(code == null){
            return null;
        }

        for(DetachedFileStatusEnum item:values()){
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
