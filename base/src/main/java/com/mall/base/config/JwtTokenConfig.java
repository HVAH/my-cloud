package com.mall.base.config;

import com.mall.base.security.jwt.JwtTokenFactory;
import com.mall.base.utils.RsaKeyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;

@Configuration
public class JwtTokenConfig {

    private @Autowired
    PublicKey publicKey;

    @Bean
    public PublicKey publicKey() throws NoSuchAlgorithmException, IOException, InvalidKeySpecException {
        return RsaKeyUtil.getPublicKey("public.key");
    }

    @Bean
    public PrivateKey privateKey() throws NoSuchAlgorithmException, IOException, InvalidKeySpecException {
        return RsaKeyUtil.getPrivateKey("private.key");
    }

    @Bean
    public JwtTokenFactory jwtTokenFactory() throws NoSuchAlgorithmException, IOException, InvalidKeySpecException {
        return new JwtTokenFactory(publicKey);
    }
}
