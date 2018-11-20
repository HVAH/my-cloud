package com.mall.oauth2.configurer;

import com.mall.oauth2.Support.SecureIntercepter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMVCConfigurer implements WebMvcConfigurer {

    /**
     * 注入权限拦截器
     * @return
     */
    @Bean
    public SecureIntercepter authorizationIntercepter() {
        return new SecureIntercepter();
    }

    /**
     * 注册拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authorizationIntercepter()).excludePathPatterns("/static/")
                .excludePathPatterns("/error").addPathPatterns("/**");
    }


}
