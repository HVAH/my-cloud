package com.mall.oauth2.service;

import com.mall.oauth2.domain.UserAccount;

public interface UserAccountService {
    UserAccount getUserByName(String userName);
}
