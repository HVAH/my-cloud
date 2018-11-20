package com.mall.base.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.InvalidClaimException;

/**
 * Created by Ken Huang on 9/3/2018.
 */
public class InvalidModouTokenException extends InvalidClaimException {
    public InvalidModouTokenException(Header header, Claims claims, String message) {
        super(header, claims, message);
    }

    public InvalidModouTokenException(Header header, Claims claims, String message, Throwable cause) {
        super(header, claims, message, cause);
    }
}
