package com.vah.reptile.service.impl;

import com.mall.base.security.jwt.JwtToken;
import com.mall.base.security.jwt.JwtTokenFactory;
import com.mall.base.utils.StringUtils;
import com.vah.reptile.config.JwtConfig;
import com.vah.reptile.dto.AuthUser;
import com.vah.reptile.dto.response.RespComboToken;
import com.vah.reptile.repository.RedisRepository;
import com.vah.reptile.service.JwtService;
import com.vah.reptile.constants.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.security.PrivateKey;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@Slf4j
public class JwtServiceImpl implements JwtService {

    private @Resource JwtConfig jwtConfig;

    private @Resource JwtTokenFactory jwtTokenFactory;

    private @Resource PrivateKey privateKey;

    @Override
    @Transactional
    public Optional<RespComboToken> generateComboToken(AuthUser authUser) {
        if (authUser == null) {
            return Optional.empty();
        }
        RespComboToken respComboToken = new RespComboToken();
        String endpoint = authUser.getEndpoint();
        String userId = authUser.getUserId() + "";
        Map<String, List<Long>> roles = authUser.getAuthorities();

        // step 1: revoke previous tokens
        //revokeTokensByClientAndUserId(endpoint, userId);

        // step 2: generate new tokens
        Instant now = Instant.now();
        Date issuedAt = Date.from(now);
        Date accessExpiration = Date.from(now.plusSeconds(jwtConfig.getAccessExpiration()));

//        String refreshTokenId = redisRepository.increment(RedisKey.ID_SEQUENCE, 1L).toString();
        String refreshTokenId = StringUtils.uuid();
        //saveRefreshToken(endpoint, userId, refreshTokenId);
        JwtToken refreshToken = jwtTokenFactory.builder()
                .setIssuer(jwtConfig.getIssuer())
                .setAudience(endpoint)
                .setSubject(userId)
                .setType(JwtToken.Type.REFRESH_TOKEN)
                .setId(refreshTokenId)
                .setScopes(roles)
                .setIssuedAt(issuedAt)
                .build(privateKey);
        respComboToken.setRefreshToken(refreshToken.getRawToken());

        String accessTokenId = StringUtils.uuid();
//        String accessTokenId = redisRepository.increment(RedisKey.ID_SEQUENCE, 1L).toString();
        //saveAccessTokenAndJti(endpoint, userId, accessTokenId);
        JwtToken accessToken = jwtTokenFactory.builder()
                .setIssuer(jwtConfig.getIssuer())
                .setAudience(endpoint)
                .setSubject(userId)
                .setType(JwtToken.Type.ACCESS_TOKEN)
                .setId(accessTokenId)
                .setMasterId(refreshTokenId)
                .setScopes(roles)
                .setIssuedAt(issuedAt)
                .setExpiration(accessExpiration)
                .build(privateKey);
        respComboToken.setAccessToken(accessToken.getRawToken());

        return Optional.of(respComboToken);
    }


    @Override
    @Transactional
    public Optional<RespComboToken> renewComboToken(String rawRefreshToken) {
        JwtToken refreshToken;
        try {
            refreshToken = jwtTokenFactory.getJwtToken(rawRefreshToken);
        } catch (Exception e) {
            return Optional.empty();
        }
        JwtToken.Type type = refreshToken.getType();
        if (JwtToken.Type.REFRESH_TOKEN != type) {
            return Optional.empty();
        }
        RespComboToken respComboToken = new RespComboToken();
        String client = refreshToken.getAudience();
        String userId = refreshToken.getSubject();
        String refreshTokenId = refreshToken.getId();
        Map<String, List<Long>> roles = refreshToken.getScopes();

        // reset the last token expiration to 10s
        //resetLastAccessToken(client, userId, 10L);

        // step 2 renew tokens
        Instant now = Instant.now();
        Date issuedAt = Date.from(now);
        Date accessExpiration = Date.from(now.plusSeconds(jwtConfig.getAccessExpiration()));

        String accessTokenId = StringUtils.uuid();
        //saveAccessTokenAndJti(client, userId, accessTokenId);
        JwtToken accessToken = jwtTokenFactory.builder()
                .setIssuer(jwtConfig.getIssuer())
                .setAudience(client)
                .setSubject(userId)
                .setType(JwtToken.Type.ACCESS_TOKEN)
                .setId(accessTokenId)
                .setMasterId(refreshTokenId)
                .setScopes(roles)
                .setIssuedAt(issuedAt)
                .setExpiration(accessExpiration)
                .build(privateKey);
        respComboToken.setAccessToken(accessToken.getRawToken());

        // step 3 renew refresh token's expiration
        //saveRefreshToken(client, userId, refreshTokenId);
        respComboToken.setRefreshToken(rawRefreshToken);
        return Optional.of(respComboToken);
    }



}
