package pers.laineyc.blackdream.framework.exception;

/**
 * @author LaineyC
 *
 */
public class ErrorCodes {

    public static final ErrorCode EC_001001 = new ErrorCode(1001, "服务不可用");

    public static final ErrorCode EC_001002 = new ErrorCode(1002, "当前请求需要身份验证");

    public static final ErrorCode EC_001003 = new ErrorCode(1003, "当前请求权限受限");

}