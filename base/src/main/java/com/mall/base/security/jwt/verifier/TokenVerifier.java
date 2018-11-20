package com.mall.base.security.jwt.verifier;

/**
 * Created by Ken Huang on 9/4/2018.
 */
public interface TokenVerifier {
    boolean verify(String id);
}
