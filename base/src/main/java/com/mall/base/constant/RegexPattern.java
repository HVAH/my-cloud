package com.mall.base.constant;

/**
 * Created by Ken on 7/24/2018.
 */
public final class RegexPattern {
    private RegexPattern() {}

    //    "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8}$"
    public static final String MOBILE = "^((1[3,5,8][0-9])|(14[5,7])|(17[0,6,7,8])|(19[7]))\\d{8}$";

    public static final String PASSWORD = "^[A-Za-z0-9]+$";

    public static final String USER_ID = "^\\d+$";

    public static final String TYPE = "^[12]$";

    public static final String GENDER = "^male|female$";

    // 手机号隐藏处理regex
    public static final String MOBILE_NUM = "(\\\\d{3})\\\\d{4}(\\\\d{4})";
    // 手机号替换符
    public static final String MOBILE_HIDE = "$1****$2";
}
