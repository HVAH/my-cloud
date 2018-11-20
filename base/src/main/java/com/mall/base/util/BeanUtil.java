package com.mall.base.util;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.beans.PropertyDescriptor;
import java.util.HashSet;
import java.util.Set;

public final class BeanUtil {
    private BeanUtil() {}

    private static String[] getNullPropertyNames(Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        PropertyDescriptor[] pds = src.getPropertyDescriptors();
        Set<String> emptyNames = new HashSet<String>();
        for (PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) {
                emptyNames.add(pd.getName());
            }
        }
        return emptyNames.toArray(new String[0]);
    }

    public static void copyPropertiesIgnoreNull(Object source, Object target) {
        BeanUtils.copyProperties(source, target, getNullPropertyNames(source));
    }

    public static void copyPropertiesIgnoreNull(Object source, Object target, String[] ignores) {
        if (ignores == null || ignores.length == 0) {
            copyPropertiesIgnoreNull(source, target);
        } else {
            String[] nulls = getNullPropertyNames(source);
            String[] newIgnores = new String[ignores.length + nulls.length];
            System.arraycopy(ignores, 0, newIgnores, 0, ignores.length);
            System.arraycopy(nulls, 0, newIgnores, ignores.length, nulls.length);
            BeanUtils.copyProperties(source, target, newIgnores);
        }
    }
}
