package com.mall.oauth2.Support;

import com.mall.oauth2.domain.UserAccount;
import com.mall.oauth2.domain.UserPermission;
import com.mall.oauth2.service.UserAccountService;
import com.mall.oauth2.service.UserPermissionsSerivce;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *认证服务实现
 */
@Component
public class MyAuthenticationProvider implements AuthenticationProvider {
    protected final Logger logger = LoggerFactory.getLogger(getClass());
    private @Resource UserAccountService userAccountService;
    private @Resource UserPermissionsSerivce userPermissionsSerivce;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = (String) authentication.getCredentials();
        if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
            throw new RuntimeException("用户名或者密码错误！");
        }
        UserAccount userAccount = null;
        userAccount = userAccountService.getUserByName(username);
        if (userAccount == null) {
            throw new RuntimeException("用户名或者密码错误！");
        }
        if (!password.equals(userAccount.getPassword())) {
            throw new RuntimeException("用户名或者密码错误！");
        }

        // 获取用户权限
        List<UserPermission> permissions = userPermissionsSerivce.getUserPermissionsByUserId(userAccount.getUserId());
        List<String> permissionCodes = permissions.stream().map(UserPermission::getCode).collect(Collectors.toList());
        Set<GrantedAuthority> authorities = new LinkedHashSet<>();

        for (String permissionCode : permissionCodes) {
            authorities.add(new SimpleGrantedAuthority(permissionCode));
        }

        return new UsernamePasswordAuthenticationToken(String.valueOf(userAccount.getUserId()), password, authorities);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
