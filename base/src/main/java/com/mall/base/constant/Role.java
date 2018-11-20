package com.mall.base.constant;

/**
 * Created by Ken on 7/12/2018.
 */
public final class Role {
    private Role() {}

    public static final Long ADMIN = 1L;
    public static final Long USER = 2L;
    public static final Long BRAND_OWNER = 3L;
    public static final Long BRAND_OP = 4L;
    public static final Long STORE_OWNER = 5L;
    public static final Long STORE_OP = 6L;


    public static final String ROLE_REFRESH = "ROLE_REFRESH_TOKEN";
    public static final String ROLE_ACCESS = "ROLE_ACCESS_TOKEN";
    public static final String ROLE_ADMIN = "ROLE_ADMIN";
    public static final String ROLE_USER = "ROLE_USER";
    public static final String ROLE_BRAND_OWNER = "ROLE_BRAND_OWNER";
    public static final String ROLE_BRAND_OP = "ROLE_BRAND_OP ";
    public static final String ROLE_STORE_OWNER = "ROLE_STORE_OWNER";
    public static final String ROLE_STORE_OP = "ROLE_STORE_OP";
}
