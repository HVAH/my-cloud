package com.vah.reptile.constants;

public final class RedisKey {
    private RedisKey() { }

    public static final String ID_SEQUENCE = "id_sequence";
    public static final String DELIMITER = ":";
    public static final String PATTERN_REFRESH_TOKEN = "refresh" + DELIMITER + "%s" + DELIMITER + "%s";
    public static final String PATTERN_REFRESH_JTI = "re_jti" + DELIMITER + "%s" + DELIMITER + "%s";

    public static final String PATTERN_ACCESS_TOKEN = "access" + DELIMITER + "%s" + DELIMITER + "%s" + DELIMITER + "%s";
    public static final String PATTERN_ACCESS_JTI = "ac_jti" + DELIMITER + "%s" + DELIMITER + "%s";

    public static final String ADT_TOKEN_USER = "adt_token_user" + DELIMITER + "%s";

    public static final String PREFIX_VERIFICATION_TOKEN = "verif_token:";
}
