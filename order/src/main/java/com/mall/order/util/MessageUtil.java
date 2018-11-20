package com.mall.order.util;

/**
 * Created by Junhe on 2018/8/3.
 * 微信消息工具类
 */
public class MessageUtil {
    /**
     * 接收文本消息
     */
    public static final String RESP_MESSAGE_TYPE_TEXT="text";
    /**
     * 接收图文消息
     */
    public static final String RESP_MESSAGE_TYPE_IMAGE="image";
    /**
     * 接收语音消息
     */
    public static final String RESP_MESSAGE_TYPE_VOICE="voice";
    /**
     * 接收视频消息
     */
    public static final String RESP_MESSAGE_TYPE_VIDEO="video";
    /**
     * 接收小视频消息
     */
    public static final String RESP_MESSAGE_TYPE_SHORTVIDEO="shortvideo";
    /**
     * 接收地理位置消息
     */
    public static final String RESP_MESSAGE_TYPE_LOCATION="location";
    /**
     * 接收链接信息
     */
    public static final String RESP_MESSAGE_TYPE_LINK="link";

    /**
     * 事件-关注事件
     */
    public static final String EVENT_TYPE_SUBSCRIBE="subscribe";
    /**
     * 事件-取消关注事件
     */
    public static final String EVENT_TYPE_UNSUBSCRIBE ="unsubscribe";
    /**
     * 事件-用户已关注时的事件推送
     */
    public static final String EVENT_TYPE_SCAN ="SCAN";
    /**
     * 事件-上报地理位置事件
     */
    public static final String EVENT_TYPE_LOCATION ="LOCATION";
    /**
     * 事件-点击菜单拉取消息时的事件推送
     */
    public static final String EVENT_TYPE_CLICK ="CLICK";
    /**
     * 事件-点击菜单跳转链接时的事件推送
     */
    public static final String EVENT_TYPE_VIEW ="VIEW";


    /**
     * 回复文本消息
     */
    public static final String REQ_MESSAGE_TYPE_TEXT="text";
    /**
     * 回复图片消息
     */
    public static final String REQ_MESSAGE_TYPE_IMAGE="image";
    /**
     * 回复语言信息
     */
    public static final String REQ_MESSAGE_TYPE_VOICE="voice";
    /**
     * 回复视频消息
     */
    public static final String REQ_MESSAGE_TYPE_VIDEO="video";
    /**
     * 回复音乐消息
     */
    public static final String REQ_MESSAGE_TYPE_MUSIC="music";
    /**
     * 回复图文消息
     */
    public static final String REQ_MESSAGE_TYPE_NEWS="news";
    /**
     * 请求消息类型：推送
     */
    public static final String REQ_MESSAGE_TYPE_EVENT = "event";

    public static String getRespMessageTypeText() {
        return RESP_MESSAGE_TYPE_TEXT;
    }

    public static String getRespMessageTypeImage() {
        return RESP_MESSAGE_TYPE_IMAGE;
    }

    public static String getRespMessageTypeVoice() {
        return RESP_MESSAGE_TYPE_VOICE;
    }

    public static String getRespMessageTypeVideo() {
        return RESP_MESSAGE_TYPE_VIDEO;
    }

    public static String getRespMessageTypeShortvideo() {
        return RESP_MESSAGE_TYPE_SHORTVIDEO;
    }

    public static String getRespMessageTypeLocation() {
        return RESP_MESSAGE_TYPE_LOCATION;
    }

    public static String getRespMessageTypeLink() {
        return RESP_MESSAGE_TYPE_LINK;
    }

    public static String getEventTypeSubscribe() {
        return EVENT_TYPE_SUBSCRIBE;
    }

    public static String getEventTypeUnsubscribe() {
        return EVENT_TYPE_UNSUBSCRIBE;
    }

    public static String getEventTypeScan() {
        return EVENT_TYPE_SCAN;
    }

    public static String getEventTypeLocation() {
        return EVENT_TYPE_LOCATION;
    }

    public static String getEventTypeClick() {
        return EVENT_TYPE_CLICK;
    }

    public static String getEventTypeView() {
        return EVENT_TYPE_VIEW;
    }

    public static String getReqMessageTypeText() {
        return REQ_MESSAGE_TYPE_TEXT;
    }

    public static String getReqMessageTypeImage() {
        return REQ_MESSAGE_TYPE_IMAGE;
    }

    public static String getReqMessageTypeVoice() {
        return REQ_MESSAGE_TYPE_VOICE;
    }

    public static String getReqMessageTypeVideo() {
        return REQ_MESSAGE_TYPE_VIDEO;
    }

    public static String getReqMessageTypeMusic() {
        return REQ_MESSAGE_TYPE_MUSIC;
    }

    public static String getReqMessageTypeNews() {
        return REQ_MESSAGE_TYPE_NEWS;
    }

    public static String getReqMessageTypeEvent() {
        return REQ_MESSAGE_TYPE_EVENT;
    }
}
