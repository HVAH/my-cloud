package com.vah.rakeup.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

import javax.annotation.Resource;


@Configuration
public class OAuth2ServiceConfigurer {

    /**
     * 认证服务配置
     */
    @Configuration
    @EnableAuthorizationServer
    protected static class AuthorizationConfigurer extends AuthorizationServerConfigurerAdapter {

        @Resource AuthenticationManager authenticationManager;

        @Override
        public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
            // 配置两个客户端
            // 用于password认证和client认证
            clients.inMemory()
                    .withClient("client_1")
                    .resourceIds("order")
                    .authorizedGrantTypes("client_credentials", "refresh_token")
                    .scopes("select")
                    .authorities("client")
                    .secret("123456")
                    .and().withClient("client_2")
                    .resourceIds("order")
                    .authorizedGrantTypes("password", "refresh_token")
                    .scopes("select")
                    .authorities("client")
                    .secret("123456");
        }

        /**
         * * 注入authenticationManager
         * * 来支持 password grant type
         * @param endpoints
         * @throws Exception
         */
        @Override
        public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
            endpoints.authenticationManager(authenticationManager);
        }

        @Override
        public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
            // 允许客户端表单认证
            security.allowFormAuthenticationForClients();
        }
    }

    /**
     * 资源服务配置
     */
    @Configuration
    @EnableResourceServer
    protected  static class ResourceServerConfigurer extends ResourceServerConfigurerAdapter {
        @Override
        public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
            resources.resourceId("order").stateless(true);
        }

        @Override
        public void configure(HttpSecurity http) throws Exception {
            http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
                    .and()
                    .requestMatchers().anyRequest()
                    .and()
                    .authorizeRequests()
//                    .antMatchers("/product/**").access("#oauth2.hasScope('select') and hasRole('ROLE_USER')")
                    .antMatchers("/order/**").authenticated();//配置order访问控制，必须认证过后才可以访问
        }

    }

}
