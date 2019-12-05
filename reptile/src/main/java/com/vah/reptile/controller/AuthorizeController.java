package com.vah.reptile.controller;

import com.foxinmy.weixin4j.exception.WeixinException;
import com.vah.reptile.dto.response.RespComboToken;
import com.vah.reptile.service.AuthorizeService;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description
 * @Author Jiang
 * @Date 2019/11/28 4:07 下午
 * @Version 1.0
 **/
@RestController
@RequestMapping("/reptile/auth")
public class AuthorizeController {

    private @Resource AuthorizeService authorizeService;

    @PostMapping("/oauth")
    public RespComboToken queryById(
            @ApiParam(name = "appid", value = "OAuth 平台对应的 AppId", required = true) @RequestParam(name = "appid", required = true)String appid,
            @ApiParam(name = "code", value = "OAuth 平台提供的授权码", required = true) @RequestParam(name = "code", required = true)String code
    ) throws WeixinException {
        return authorizeService.oauthAuthorize(appid, code);
    }
}
