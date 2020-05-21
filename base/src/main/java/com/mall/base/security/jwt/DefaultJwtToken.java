package com.mall.base.security.jwt;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.SignatureException;

import java.security.Key;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class DefaultJwtToken implements JwtToken {
    static final String TYPE_KEY = "typ";
    static final String SCOPE_KEY = "scp";
    static final String MASTER_ID_KEY = "mjti";

    private String rawToken;
    private Claims claims;
    private Type type;

    protected DefaultJwtToken(String rawToken, Key publicKey, long skewSeconds) throws ExpiredJwtException, UnsupportedJwtException, MalformedJwtException, SignatureException, IllegalArgumentException, InvalidModouTokenException {
        Jws<Claims> jws = Jwts.parser()
                .setSigningKey(publicKey)
                .setAllowedClockSkewSeconds(skewSeconds)
                .parseClaimsJws(rawToken);
        this.claims = jws.getBody();
        String _type = claims.get(TYPE_KEY, String.class);
        if (_type == null) {
            throw new InvalidModouTokenException(jws.getHeader(), claims, String.format(ClaimJwtException.MISSING_EXPECTED_CLAIM_MESSAGE_TEMPLATE, TYPE_KEY, Type.ACCESS_TOKEN + " or " + Type.REFRESH_TOKEN));
        }
        try {
            this.type = Type.valueOf(_type);
        } catch (IllegalArgumentException e) {
            throw new InvalidModouTokenException(jws.getHeader(), claims, String.format(ClaimJwtException.INCORRECT_EXPECTED_CLAIM_MESSAGE_TEMPLATE, TYPE_KEY, Type.ACCESS_TOKEN + " or " + Type.REFRESH_TOKEN, _type));
        }
        if (Type.ACCESS_TOKEN == this.type) {
            if (claims.getExpiration() == null) {
                throw new InvalidModouTokenException(jws.getHeader(), claims, String.format(ClaimJwtException.MISSING_EXPECTED_CLAIM_MESSAGE_TEMPLATE, Claims.EXPIRATION, "expiration"));
            }
            if (claims.get(MASTER_ID_KEY, String.class) == null) {
                throw new InvalidModouTokenException(jws.getHeader(), claims, String.format(ClaimJwtException.MISSING_EXPECTED_CLAIM_MESSAGE_TEMPLATE, MASTER_ID_KEY, "refresh token id"));
            }
        }
        this.rawToken = rawToken;
    }

    protected DefaultJwtToken(String rawToken, Key publicKey) throws ExpiredJwtException, UnsupportedJwtException, MalformedJwtException, SignatureException, IllegalArgumentException {
        this(rawToken, publicKey, 0);
    }

    protected DefaultJwtToken(Claims claims, Key privateKey) {
        Type type;
        try {
            type = claims.get(TYPE_KEY, Type.class);
        } catch (RequiredTypeException e) {
            throw new InvalidModouTokenException(null, claims, String.format(ClaimJwtException.INCORRECT_EXPECTED_CLAIM_MESSAGE_TEMPLATE, TYPE_KEY, Type.ACCESS_TOKEN + " or " + Type.REFRESH_TOKEN, claims.get(TYPE_KEY)));
        }
        if (type == null) {
            throw new InvalidModouTokenException(null, claims, String.format(ClaimJwtException.MISSING_EXPECTED_CLAIM_MESSAGE_TEMPLATE, TYPE_KEY, Type.ACCESS_TOKEN + " or " + Type.REFRESH_TOKEN));
        }
        if (Type.ACCESS_TOKEN == type) {
            if (claims.getExpiration() == null) {
                throw new InvalidModouTokenException(null, claims, String.format(ClaimJwtException.MISSING_EXPECTED_CLAIM_MESSAGE_TEMPLATE, Claims.EXPIRATION, "expiration"));
            }
            if (claims.get(MASTER_ID_KEY, String.class) == null) {
                throw new InvalidModouTokenException(null, claims, String.format(ClaimJwtException.MISSING_EXPECTED_CLAIM_MESSAGE_TEMPLATE, MASTER_ID_KEY, "refresh token id"));
            }
        }
        this.type = type;
        this.claims = claims;
        this.rawToken = Jwts.builder().setClaims(claims).signWith(privateKey, SignatureAlgorithm.RS256).compact();
    }

    @Override
    public String getRawToken() {
        return rawToken;
    }

    @Override
    public Type getType() {
        return type;
    }

    @Override
    public String getIssuer() {
        return claims.getIssuer();
    }

    @Override
    public String getSubject() {
        return claims.getSubject();
    }

    @Override
    public String getAudience() {
        return claims.getAudience();
    }

    @Override
    public String getId() {
        return claims.getId();
    }

    @Override
    public String getMasterId() {
        return claims.get(MASTER_ID_KEY, String.class);
    }

    @Override
    public Date getIssueAt() {
        return claims.getIssuedAt();
    }

    @Override
    public Date getExpiration() {
        return claims.getExpiration();
    }

    @Override
    public Map<String, List<Long>> getScopes() {
        return claims.get(SCOPE_KEY, Map.class);
    }
}
