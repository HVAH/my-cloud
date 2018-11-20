package com.mall.order.controller;

import com.foxinmy.weixin4j.exception.WeixinException;
import com.foxinmy.weixin4j.model.Token;
import com.mall.order.common.AjaxReturn;
import com.mall.order.domain.News;
import com.mall.order.domain.ReceiveXml;
import com.mall.order.service.impl.WechatApiService;
import com.mall.order.util.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description 微信 controller
 * @Author HuangJiang
 * @Date 2018/8/7 10:33
 * @Version 1.0
 **/
@CrossOrigin
@RestController
@Api(description = "微信相关接口")
public class WechatController {

    private @Resource WechatApiService wechatApiService;

    private static final Logger LOGGER = LoggerFactory.getLogger(WechatController.class);


    /**
     * 获取微信access_token
     * @return
     * @throws Exception
     */
    @GetMapping(path = { "/get-weixin-token" })
    @ApiOperation(value = "获取微信access_token", code = 200, produces = "application/json")
    @ApiResponses({ @ApiResponse(code = 200, message = "查询成功", response = Token.class) })
    public AjaxReturn method(
            )throws Exception {

        return new AjaxReturn(200, null,  wechatApiService.getAccessToken());
    }

    /**
     * 获取微信js_api_ticket
     * @return
     * @throws Exception
     */
    @GetMapping(path = { "/get-weixin-js-ticket" })
    @ApiOperation(value = "获取微信js_api_ticket", code = 200, produces = "application/json")
    @ApiResponses({ @ApiResponse(code = 200, message = "查询成功", response = Token.class) })
    public AjaxReturn jsTicket(
            )throws Exception {

        return new AjaxReturn(200, null, wechatApiService.getJsApiTicket());
    }

    @GetMapping(value = "/wechat")
    public void wechatDoGet(HttpServletRequest request, HttpServletResponse response,
                            @RequestParam(value = "signature", required = true) String signature,
                            @RequestParam(value = "timestamp", required = true) String timestamp,
                            @RequestParam(value = "nonce", required = true) String nonce,
                            @RequestParam(value = "echostr", required = true) String echostr) throws WeixinException {

        LOGGER.info("微信请求");
        try {
            if (AttestationUtil.checkSignature(signature, timestamp, nonce)) {
                PrintWriter out = response.getWriter();
                out.print(echostr);
                out.close();
            } else {
                LOGGER.info("非微信请求！");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

   /* @PostMapping(value = "/wechat")
    public void wechatDoPost(HttpServletRequest request, HttpServletResponse response) throws WeixinException {
        StringBuffer sb = new StringBuffer();
        String xml = "";
        String result = "";
        try {
            InputStream is = request.getInputStream();
            InputStreamReader isr = new InputStreamReader(is, "UTF-8");
            BufferedReader br = new BufferedReader(isr);
            String s;
            while ((s = br.readLine()) != null) {
                sb.append(s);
            }
            xml = sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 转换接收信息
        LOGGER.info("[从微信接收到的原始xml消息:{}]", xml);
        ReceiveXml xmlEntity = new ResolveXML().getMesEntity(xml);
        LOGGER.info("[转换为实体:{}]", xmlEntity.toString());
        if ("TEMPLATESENDJOBFINISH".equals(xmlEntity.getEvent())) {
            LOGGER.info("[模板消息回调-- 回复空内容]");
            //消息处理
            result = "success";
            LOGGER.info("[回复内容:{}]", result);
        } else {
            if (MessageUtil.REQ_MESSAGE_TYPE_EVENT.equals(xmlEntity.getMsgType())) {
                LOGGER.info("[扫码事件,回复空内容]");
                result = "success";
                LOGGER.info("[回复内容:{}]", result);
                //推送模板消息
                LOGGER.info("[该成发送模板消息|接收用户:{}]", xmlEntity.getFromUserName());
                wechatApiService.senTemlMessage(xmlEntity);
            } else {
                //消息处理
                result = new TulingApiProcess().getTulingResult(xmlEntity);
                LOGGER.info("[回复内容:{}]", result);
            }
        }
        try {
            OutputStream os = response.getOutputStream();
            os.write(result.getBytes("UTF-8"));
            os.flush();
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/


    @PostMapping(value = "/wechat")
    public void wechatDoPost(HttpServletRequest request, HttpServletResponse response) {
        StringBuffer sb = new StringBuffer();
        String xml = "";
        String result = "";
        try {
            InputStream is = request.getInputStream();
            InputStreamReader isr = new InputStreamReader(is, "UTF-8");
            BufferedReader br = new BufferedReader(isr);
            String s;
            while ((s = br.readLine()) != null) {
                sb.append(s);
            }
            xml = sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 转换接收信息
        ReceiveXml xmlEntity = new ResolveXML().getMesEntity(xml);
        LOGGER.info("[从微信接收到的消息:{}]", xmlEntity.toString());
        LOGGER.info("[进行解析并回复]");
        if (MessageUtil.REQ_MESSAGE_TYPE_EVENT.equals(xmlEntity.getMsgType())) {
            //推送事件
            String openid = xmlEntity.getFromUserName();
            LocalTime time = LocalTime.now();
//            JSONObject userInfo = new WechatApi().GetUseInfo(AccessTokenListener.access_token,openid);
//            System.out.println("用户信息："+JSON.toJSONString(userInfo));
           /* String context = "恭喜您！已成功获得【索菲亚】商品清单~" + "\n<a href='https://ycvr.com/AR/demo?sceneId=" + xmlEntity.getEventKey() +"'>立即查看！</a>";
            result = new AnswerUtil().TextAnswer(xmlEntity.getFromUserName(),xmlEntity.getToUserName(),context);*/
            News news = new News();
            news.setDescription("恭喜您！已成功获得【索菲亚】商品清单~");
            news.setTitle("您的购物清单已生成");
            news.setPicUrl("https://avatar.csdn.net/7/C/6/3_seapeak007.jpg");
            news.setUrl("https://ycvr.com/AR/demo?sceneId=" + xmlEntity.getEventKey().replace("qrscene_", ""));
            List<News> newsList = new ArrayList<>();
            newsList.add(news);
            result = new AnswerUtil().NewsAnswer(xmlEntity.getFromUserName(), xmlEntity.getToUserName(), newsList);
            LOGGER.info("[回复内容:{}]", result);
            //            if(userInfo != null){
//                String nickName = userInfo.getString("nickname");
//                String city = userInfo.getString("city");
//                String eventKey = xmlEntity.getEventKey();
//                result = "\n用户："+nickName+"\n openid:"+openid+"\n订单号："+eventKey+"\n创建时间："+time.toString()+"\n城市："+city+"\n<a href='https://ycvr.com'>ADT的AR码清单</a>";
//            }
        } else {
            //消息处理
            result = new TulingApiProcess().getTulingResult(xmlEntity);
            LOGGER.info("[回复内容:{}]", result);
        }
        try {
            OutputStream os = response.getOutputStream();
            os.write(result.getBytes("UTF-8"));
            os.flush();
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
