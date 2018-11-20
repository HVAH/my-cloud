package com.mall.oauth2.Support;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 认证失败处理器
 */
public class MyAuthenticationFailureHandler implements AuthenticationFailureHandler {
    // 认证失败的默认重定向地址
    private final static String DEFAULT_FAILUER_REDIRECT_URL = "http://127.0.0.1:8080/login";
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Override
    public void onAuthenticationFailure(
            HttpServletRequest request, HttpServletResponse response,
            AuthenticationException exception
                                        ) throws IOException, ServletException {

        String username = request.getParameter("username");
        // 获取重定向地址
        String redirectUrl = request.getParameter("redirect");
        if (StringUtils.isNotBlank(redirectUrl)) {
            redirectUrl = DEFAULT_FAILUER_REDIRECT_URL;
        }
        redirectStrategy.sendRedirect(request, response, redirectUrl);
    }
}
