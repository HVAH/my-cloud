package com.mall.order.service.impl;

import com.foxinmy.weixin4j.exception.WeixinException;
import com.foxinmy.weixin4j.model.qr.QRParameter;
import com.foxinmy.weixin4j.model.qr.QRResult;
import com.foxinmy.weixin4j.mp.WeixinProxy;
import com.foxinmy.weixin4j.mp.message.TemplateMessage;
import com.foxinmy.weixin4j.mp.model.User;
import com.foxinmy.weixin4j.token.TokenManager;
import com.foxinmy.weixin4j.type.TicketType;
import com.mall.order.domain.ReceiveXml;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @Description 封装的微信API
 * @Author HuangJiang
 * @Date 2018/8/9 14:32
 * @Version 1.0
 **/
@Service
public class WechatApiService{
    private @Resource WeixinProxy weixinProxy;
    private @Resource TokenManager tokenManager;

    private final static Logger LOGGER = LoggerFactory.getLogger(WechatApiService.class);

    /**
     * 创建零时的微信推广二维码
     * @param sceneId
     * @param expires
     * @return
     * @throws IOException
     * @throws WeixinException
     */
    public String getQrCodeUrl(Long sceneId, Integer expires) throws WeixinException {
        QRParameter temporaryQR = QRParameter.createTemporaryQR(expires, sceneId.toString());
        QRResult qrResult = weixinProxy.createQR(temporaryQR);
        return qrResult.getUrl();
    }

    /**
     * 获取微信AccessToken, 先从redis缓存查询,如果已失效则重新请求
     * @return
     * @throws WeixinException
     */
    public String getAccessToken() throws WeixinException {
        return tokenManager.getCache().getAccessToken();
    }

    /**
     * 获取jsApi_ticket
     * @return
     * @throws WeixinException
     */
    public String getJsApiTicket() throws WeixinException {
        TokenManager ticketManager = weixinProxy.getTicketManager(TicketType.jsapi);
        return ticketManager.getCache().getAccessToken();
    }

    /**
     * 发送模板消息
     * @param xmlEntity
     */
    public void senTemlMessage(ReceiveXml xmlEntity) throws WeixinException {
        TemplateMessage templateMessage = new TemplateMessage(xmlEntity.getFromUserName(),
                "hSsMh3OR2-itQ59z2D7O0gm7zxXtNSGCeNVyO0FGZ2M",
                "https://ycvr.com/AR/demo/?sceneId=" + xmlEntity.getEventKey().replace("qrscene_", ""));
        String result = weixinProxy.sendTmplMessage(templateMessage);
        User user = weixinProxy.getUser("");
        LOGGER.info("发送完成: {}", result);
    }
}
