package com.mall.oauth2.service;

import com.mall.oauth2.domain.UserPermission;

import java.util.List;

public interface UserPermissionsSerivce {
    List<UserPermission> getUserPermissionsByUserId(Long userId);
}
