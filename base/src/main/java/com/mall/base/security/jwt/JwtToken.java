package com.mall.base.security.jwt;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface JwtToken {
    enum Type {
        ACCESS_TOKEN, REFRESH_TOKEN
    }

    String getRawToken();

    Type getType();

    String getIssuer();

    String getSubject();

    String getAudience();

    String getId();

    String getMasterId();

    Date getIssueAt();

    Date getExpiration();

    Map<String, List<Long>> getScopes();
}
