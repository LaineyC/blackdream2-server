package pers.laineyc.blackdream.framework.util;

import java.util.regex.Pattern;

/**
 * @author LaineyC
 */
public class RegexUtil {

    public static final String REGEX_USERNAME = "^[a-zA-Z][a-zA-Z0-9]{3,16}$";

    public static final String REGEX_PASSWORD = "^[a-zA-Z0-9]{6,24}$";

    public static final String REGEX_EMAIL = "^\\w+((-\\w+)|(\\.\\w+))*@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z0-9]+$";

    public static final String REGEX_MOBILE = "^1(3|4|5|7|8)[0-9]\\d{8}$";

    public static final String REGEX_PHONE = "^(\\+\\d+)?(\\d{3,4}\\-?)?\\d{7,8}$";

    public static boolean isUsername(String username) {
        if(username == null){
            return false;
        }
        return Pattern.matches(REGEX_USERNAME, username);
    }

    public static boolean isPassword(String password) {
        if(password == null){
            return false;
        }
        return Pattern.matches(REGEX_PASSWORD, password);
    }

    public static boolean isEmail(String email) {
        if(email == null){
            return false;
        }
        return Pattern.matches(REGEX_EMAIL, email);
    }

    public static boolean isMobile(String mobile) {
        if(mobile == null){
            return false;
        }
        return Pattern.matches(REGEX_MOBILE, mobile);
    }

    public static boolean isPhone(String phone) {
        if(phone == null){
            return false;
        }
        return Pattern.matches(REGEX_PHONE, phone);
    }

}