package com.mall.oauth2.service.impl;

import com.mall.oauth2.domain.UserPermission;
import com.mall.oauth2.service.UserPermissionsSerivce;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserPermissionsServiceImpl implements UserPermissionsSerivce {

    @Override
    public List<UserPermission> getUserPermissionsByUserId(Long userId) {
        if (userId.equals(1L)) {
            return new ArrayList() {
                {
                    add(new UserPermission("product"));
                    add(new UserPermission("car"));
                    add(new UserPermission("test"));
                }
            };
        } else if (userId.equals(2L)) {
            return new ArrayList() {
                {
                    add(new UserPermission("product"));
                    add(new UserPermission("car"));
                }
            };
        } else if (userId.equals(3L)) {
            return new ArrayList() {
                {
                    add(new UserPermission("product"));
                }
            };
        }
        return new ArrayList<>();
    }
}
