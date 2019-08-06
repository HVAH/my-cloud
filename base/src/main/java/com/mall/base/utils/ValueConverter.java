package com.mall.base.utils;


import com.mall.base.constant.RegexPattern;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Created by Ken on 2018/4/19.
 */
public final class ValueConverter {
    private ValueConverter() {
    }

    private final static Pattern PATTERN_MOBILE = Pattern.compile(RegexPattern.MOBILE);

    public final static Integer ERROR_POSITIVE_INTEGER = -1;
    public final static Long ERROR_POSITIVE_LONG = -1L;
    public final static String ERROR_STRING = "???";

    public static String fromLongToString(Long value) {
        return value == null ? null : String.valueOf(value);
    }


    public static Long fromStringToPositiveLong(String value) {
        Long result = ERROR_POSITIVE_LONG;
        if (value != null) {
            try {
                result = Long.valueOf(value.trim());
            } catch (NumberFormatException e) {
                return ERROR_POSITIVE_LONG;
            }
            if (result <= 0) {
                return ERROR_POSITIVE_LONG;
            }
        }
        return result;
    }

    public static Long fromStringToPositiveOrZeroLong(String value) {
        Long result = ERROR_POSITIVE_LONG;
        if (value != null) {
            try {
                result = Long.valueOf(value.trim());
            } catch (NumberFormatException e) {
                return ERROR_POSITIVE_LONG;
            }
            if (result < 0) {
                return ERROR_POSITIVE_LONG;
            }
        }
        return result;
    }

    public static Integer fromStringToPositiveInteger(String value) {
        Integer result = ERROR_POSITIVE_INTEGER;
        if (value != null) {
            try {
                result = Integer.valueOf(value.trim());
            } catch (NumberFormatException e) {
                return ERROR_POSITIVE_INTEGER;
            }
            if (result <= 0) {
                return ERROR_POSITIVE_INTEGER;
            }
        }
        return result;
    }

    public static Integer fromStringToPositiveOrZeroInteger(String value) {
        Integer result = ERROR_POSITIVE_INTEGER;
        if (value != null) {
            try {
                result = Integer.valueOf(value.trim());
            } catch (NumberFormatException e) {
                return ERROR_POSITIVE_INTEGER;
            }
            if (result < 0) {
                return ERROR_POSITIVE_INTEGER;
            }
        }
        return result;
    }

    public static String fromStringToMobile(String value) {
        if (value == null) {
            return ERROR_STRING;
        }
        value = value.trim();
        Matcher matcher = PATTERN_MOBILE.matcher(value);
        if (matcher.matches()) {
            return matcher.group();
        } else {
            return ERROR_STRING;
        }
    }
}
