package com.mall.base.security.jwt.extractor;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Ken Huang on 8/30/2018.
 */
public interface TokenExtractor {
    String extract(HttpServletRequest request);
}
