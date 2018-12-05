package com.vah.rakeup.service;


import com.vah.rakeup.domain.UserPermission;

import java.util.List;

public interface UserPermissionsSerivce {
    List<UserPermission> getUserPermissionsByUserId(Long userId);
}
