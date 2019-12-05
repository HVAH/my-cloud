package com.vah.reptile.config;

import com.mall.base.intercepter.JwtIntercepter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMVCConfig implements WebMvcConfigurer {

    /**
     * 注入权限拦截器
     * @return
     */
    @Bean
    public JwtIntercepter jwtIntercepter() {
        return new JwtIntercepter();
    }


    /**
     * 注册拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(jwtIntercepter()).addPathPatterns().excludePathPatterns("/static/", "/error", "/swagger-ui.html*")
                .addPathPatterns("/**");
    }


}
