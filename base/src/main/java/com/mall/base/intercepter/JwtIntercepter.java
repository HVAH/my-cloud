package com.mall.base.intercepter;

import com.mall.base.util.ThreadLocalUtils;
import com.mall.base.security.jwt.JwtToken;
import com.mall.base.security.jwt.JwtTokenFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * @Description 用于解析jwt信息
 * @Author HuangJiang
 * @Date 2018/10/17 10:44
 * @Version 1.0
 */
public class JwtIntercepter implements HandlerInterceptor {

    private static final Logger LOGGER = LoggerFactory.getLogger(JwtIntercepter.class);

    private @Resource JwtTokenFactory jwtTokenFactory;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        JwtToken jwtToken= null;
        String requestHeader = request.getHeader("Authorization");
        if (requestHeader != null && !"".equals(requestHeader.trim())) {
            String [] headers = requestHeader.split(" ");
            if (headers.length == 2) {
                jwtToken = jwtTokenFactory.getJwtToken(headers[1]);
            }
        }
        // 设置Threadlocal
        if (jwtToken != null) {
            Map<String, List<Long>> scopes = jwtToken.getScopes();
            LOGGER.debug("[用户角色信息: {}]", scopes);
            ThreadLocalUtils.setUserId(Long.parseLong(jwtToken.getSubject()));
            ThreadLocalUtils.setRoles(scopes);
        }
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        ThreadLocalUtils.remove();
    }
}
