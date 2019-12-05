package com.vah.reptile.service.impl;

import com.foxinmy.weixin4j.exception.WeixinException;
import com.foxinmy.weixin4j.mp.WeixinProxy;
import com.foxinmy.weixin4j.mp.api.OauthApi;
import com.foxinmy.weixin4j.mp.model.OauthToken;
import com.foxinmy.weixin4j.mp.model.User;
import com.mall.base.utils.OperationResult;
import com.vah.reptile.config.WxProxyFactory;
import com.vah.reptile.dto.AuthUser;
import com.vah.reptile.dto.response.RespComboToken;
import com.vah.reptile.service.AuthorizeService;
import com.vah.reptile.service.JwtService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;

import static org.springframework.http.HttpStatus.UNAUTHORIZED;

/**
 * @Description
 * @Author Jiang
 * @Date 2019/12/2 10:24 上午
 * @Version 1.0
 **/
@Service
public class AuthorizeServiceImpl implements AuthorizeService {

    private @Resource JwtService jwtService;
    private @Resource WxProxyFactory wxProxyFactory;

    @Override
    public RespComboToken oauthAuthorize(String appid, String code) throws WeixinException {
        WeixinProxy proxy = wxProxyFactory.getProxy("wx9790544c70e9b2dd");
        OauthApi oauthApi = proxy.getOauthApi();
        OauthToken token = oauthApi.getAuthorizationToken(code);
        User user = oauthApi.getAuthorizationUser(token);

        return jwtService.generateComboToken(new AuthUser(Long.valueOf(user.getOpenId()), "asdfd", "fsd", "", new HashMap())).get();
    }
}
