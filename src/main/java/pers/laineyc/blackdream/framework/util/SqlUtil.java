package pers.laineyc.blackdream.framework.util;

/**
 * @author LaineyC
 */
public final class SqlUtil {

    public static String escapeLikeWildcard(String sql) {
        if(sql == null){
            return null;
        }
        return sql.replaceAll("[%\\[\\]\\^_]","\\\\$0");
    }

}