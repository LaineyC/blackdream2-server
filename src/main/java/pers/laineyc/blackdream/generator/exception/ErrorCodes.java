package pers.laineyc.blackdream.generator.exception;

import pers.laineyc.blackdream.framework.exception.ErrorCode;

/**
 * @author LaineyC
 *
 */
public class ErrorCodes {

    public static final ErrorCode EC_020001 = new ErrorCode(20001, "当前生成器已升级发布，请刷新数据，重新操作！");

    public static final ErrorCode EC_020002 = new ErrorCode(20002, "当前生成器正在开发，请暂停操作，等待发布！");

}