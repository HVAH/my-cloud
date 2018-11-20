package com.mall.base.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Ken Huang on 9/7/2018.
 */
@Component
public class JwtTokenFactory {
    private PublicKey publicKey;

    public JwtTokenFactory(PublicKey publicKey) {
        this.publicKey = publicKey;
    }

    public JwtToken getJwtToken(String rawToken) {
        return new DefaultJwtToken(rawToken, publicKey);
    }

    public Builder builder() {
        return new Builder();
    }

    @Setter
    @Accessors(chain = true)
    public static class Builder {
        private JwtToken.Type type;
        private String issuer;
        private String subject;
        private String audience;
        private String id;
        private String masterId;
        private Date issuedAt;
        private Date expiration;
        private Map<String, List<Long>> scopes;

        public JwtToken build(PrivateKey privateKey) {
            Assert.notNull(privateKey, "Private Key MUST NOT null");
            Claims claims = Jwts.claims();
            if (type != null) {
                claims.put(DefaultJwtToken.TYPE_KEY, type);
            }
            if (issuer != null) {
                claims.setIssuer(issuer);
            }
            if (subject != null) {
                claims.setSubject(subject);
            }
            if (audience != null) {
                claims.setAudience(audience);
            }
            if (id != null) {
                claims.setId(id);
            }
            if (masterId != null) {
                claims.put(DefaultJwtToken.MASTER_ID_KEY, masterId);
            }
            if (issuedAt != null) {
                claims.setIssuedAt(issuedAt);
            }
            if (expiration != null) {
                claims.setExpiration(expiration);
            }
            if (scopes != null) {
                claims.put(DefaultJwtToken.SCOPE_KEY, scopes);
            }
            return new DefaultJwtToken(claims, privateKey);
        }
    }
}
