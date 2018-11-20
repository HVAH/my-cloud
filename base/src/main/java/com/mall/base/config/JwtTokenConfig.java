package com.mall.base.config;

import com.mall.base.security.jwt.JwtTokenFactory;
import com.mall.base.util.RsaKeyUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;

/**
 * Created by Ken Huang on 9/7/2018.
 */
@Configuration
public class JwtTokenConfig {
    @Bean
    public JwtTokenFactory jwtTokenFactory() throws NoSuchAlgorithmException, IOException, InvalidKeySpecException {
        PublicKey publicKey = RsaKeyUtil.getPublicKey("public.key");
        return new JwtTokenFactory(publicKey);
    }
}
