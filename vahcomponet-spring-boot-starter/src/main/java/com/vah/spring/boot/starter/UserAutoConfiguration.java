package com.vah.spring.boot.starter;

import com.vah.component.User;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description
 * @Author Jiang
 * @Date 2019/8/5 17:32
 * @Version 1.0
 **/
@Configuration
@EnableConfigurationProperties(UserProperties.class)
public class UserAutoConfiguration {
    @Bean
    public User getUser(UserProperties userProperties) {
        User user = new User();
        user.setName(userProperties.getName());
        user.setAge(userProperties.getAge());
        return user;
    }
}
