package com.mall.base.security.jwt.extractor;

import com.mall.base.constant.Header;
import io.jsonwebtoken.JwtException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Ken Huang on 8/30/2018.
 */
@Component
public class JwtHeaderTokenExtractor implements TokenExtractor {

    @Override
    public String extract(HttpServletRequest request) {
        if (request == null) {
            return null;
        }
        String header = request.getHeader(Header.AUTHORIZATION);
        if (StringUtils.isEmpty(header)) {
            throw new JwtException("Authorization header cannot be blank!");
        }

        if (header.length() < Header.BEARER.length()) {
            throw new JwtException("Invalid authorization header size.");
        }

        if (!header.contains(Header.BEARER)) {
            throw new JwtException("Invalid authorization format");
        }

        return header.substring(Header.BEARER.length(), header.length());
    }
}
