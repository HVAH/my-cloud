package com.vah.rakeup.service.impl;

import com.vah.rakeup.domain.UserAccount;
import com.vah.rakeup.service.UserAccountService;
import org.springframework.stereotype.Service;

@Service
public class UserAccountServiceImpl implements UserAccountService {


    @Override
    public UserAccount getUserByName(String userName) {
        if ("1".equals(userName)) {
            UserAccount userAccount = new UserAccount();
            userAccount.setUserId(1L);
            userAccount.setUserName("1");
            userAccount.setPassword("123456");
            return userAccount;
        } else if ("2".equals(userName)) {
            UserAccount userAccount = new UserAccount();
            userAccount.setUserId(2L);
            userAccount.setUserName("2");
            userAccount.setPassword("1234567");
            return userAccount;
        } else if ("3".equals(userName)) {
            UserAccount userAccount = new UserAccount();
            userAccount.setUserId(3L);
            userAccount.setUserName("3");
            userAccount.setPassword("1234578");
            return userAccount;
        }else if ("4".equals(userName)) {
            UserAccount userAccount = new UserAccount();
            userAccount.setUserId(4L);
            userAccount.setUserName("3");
            userAccount.setPassword("1234578");
            return userAccount;
        }
        return null;
    }

}
