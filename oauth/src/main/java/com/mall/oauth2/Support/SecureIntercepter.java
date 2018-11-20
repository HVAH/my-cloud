package com.mall.oauth2.Support;

import com.mall.oauth2.domain.UserPermission;
import com.mall.oauth2.service.UserPermissionsSerivce;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 权限拦截器
 */
public class SecureIntercepter implements HandlerInterceptor {
    private @Resource UserPermissionsSerivce userPermissionsSerivce;
    private final static Logger LOGGER = LoggerFactory.getLogger(SecureIntercepter.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (this.checkPermission(handler)) {
            return true;
        }
        if (getAuthentication() > 0) {
            // 登录了但是没有相关权限
            response.sendError(HttpStatus.FORBIDDEN.value(), "没有权限");
        } else {
            // 未登录,踢到登录页面
            response.sendRedirect("http://127.0.0.1:8080/login");
        }
        return false;
    }


    private boolean checkPermission(Object handler) {
        if (handler instanceof HandlerMethod) {
            LOGGER.info("进入权限拦截");
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            // 获取方法上的注解
            Secure secure = handlerMethod.getMethod().getAnnotation(Secure.class);
            if (secure == null) {
                secure = handlerMethod.getMethod().getDeclaringClass().getAnnotation(Secure.class);
            }
            if (secure != null) {
                // 获取用户权限
                Long userId = getAuthentication();
                if (userId <= 0) {
                    return false;
                }
                if (StringUtils.isBlank(secure.value())) {
                    // 只需登录
                    return true;
                } else {
                    // 需要具体操作/访问权限
                    List<UserPermission> userPermissions = userPermissionsSerivce.getUserPermissionsByUserId(userId);
                    Set<String> permissions = userPermissions.stream().map(UserPermission::getCode).collect(Collectors.toSet());
                    return permissions.contains(secure.value());
                }
            }
        }

        // 没有注解，不需要权限
        return true;
    }

    // 获取用户id(没有登录的用户返回0)
    private Long getAuthentication() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            // null->0
            return NumberUtils.toLong(authentication.getName());
        }
        return 0L;
    }

}
