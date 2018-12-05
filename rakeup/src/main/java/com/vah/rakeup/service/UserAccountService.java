package com.vah.rakeup.service;


import com.vah.rakeup.domain.UserAccount;

public interface UserAccountService {
    UserAccount getUserByName(String userName);
}
