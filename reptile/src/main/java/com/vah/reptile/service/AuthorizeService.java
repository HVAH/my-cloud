package com.vah.reptile.service;

import com.foxinmy.weixin4j.exception.WeixinException;
import com.vah.reptile.dto.response.RespComboToken;

/**
 * @Description
 * @Author Jiang
 * @Date 2019/12/2 10:21 上午
 * @Version 1.0
 **/
public interface AuthorizeService {
    RespComboToken oauthAuthorize(String appid, String code) throws WeixinException;
}
