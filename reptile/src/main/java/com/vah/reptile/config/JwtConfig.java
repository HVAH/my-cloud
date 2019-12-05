package com.vah.reptile.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class JwtConfig {

//    @Value("${modou.jwt.issuer:#{www.phvah.com}}")
    private String issuer = "www.phvah.com";

    // default 5 minutes
//    @Value("${modou.jwt.expiration.access:#{60*60*24*30}}")
    private long accessExpiration = 60*60*24*30;

    // default 30 days
//    @Value("${modou.jwt.expiration.refresh:#{60*60*24*30}}")
    private long refreshExpiration = 60*60*24*30;
}
