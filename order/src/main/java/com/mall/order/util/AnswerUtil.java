package com.mall.order.util;

import com.mall.order.domain.News;

import java.util.Date;
import java.util.List;

/**
 * Created by Junhe on 2018/8/3.
 */
public class AnswerUtil {
    /**
     * 回复文本消息
     *
     * @param toUserName   接收方帐号（收到的OpenID）
     * @param fromUserName 开发者微信号
     * @param content      回复的消息内容（换行：在content中能够换行，微信客户端就支持换行显示）
     * @return
     */
    public String TextAnswer(String toUserName, String fromUserName, String content) {
        StringBuffer sb = new StringBuffer();
        Date date = new Date();
        sb.append("<xml>");
        sb.append("<ToUserName><![CDATA[" + toUserName + "]]></ToUserName>");
        sb.append("<FromUserName><![CDATA[" + fromUserName + "]]></FromUserName>");
        sb.append("<CreateTime>" + date.getTime() + "</CreateTime>");
        sb.append("<MsgType><![CDATA[text]]></MsgType>");
        sb.append("<Content><![CDATA[" + content + "]]></Content>");
        sb.append("</xml>");
        return sb.toString();
    }

    /**
     * 回复图片消息
     *
     * @param toUserName   接收方帐号（收到的OpenID）
     * @param fromUserName 开发者微信号
     * @param mediaId      通过素材管理接口上传多媒体文件，得到的id
     * @return
     */
    public String ImageAnswer(String toUserName, String fromUserName, String mediaId) {
        StringBuffer sb = new StringBuffer();
        Date data = new Date();
        sb.append("<xml>");
        sb.append("<ToUserName><![CDATA[" + toUserName + "]]></ToUserName>");
        sb.append("<FromUserName><![CDATA[" + fromUserName + "]]></FromUserName>");
        sb.append("<CreateTime>" + data.getTime() + "</CreateTime>");
        sb.append("<MsgType><![CDATA[image]]></MsgType>");
        sb.append("<Image>");
        sb.append("<MediaId><![CDATA[" + mediaId + "]]></MediaId>");
        sb.append("</Image>");
        sb.append("</xml>");
        return sb.toString();
    }

    /**
     * 回复语音消息
     *
     * @param toUserName   接收方帐号（收到的OpenID）
     * @param fromUserName 开发者微信号
     * @param mediaId      通过素材管理接口上传多媒体文件，得到的id
     * @return
     */
    public String VoiceAnswer(String toUserName, String fromUserName, String mediaId) {
        StringBuffer sb = new StringBuffer();
        Date data = new Date();
        sb.append("<xml>");
        sb.append("<ToUserName><![CDATA[" + toUserName + "]]></ToUserName>");
        sb.append("<FromUserName><![CDATA[" + fromUserName + "]]></FromUserName>");
        sb.append("<CreateTime>" + data.getTime() + "</CreateTime>");
        sb.append("<MsgType><![CDATA[voice]]></MsgType>");
        sb.append("<Voice>");
        sb.append("<MediaId><![CDATA[" + mediaId + "]]></MediaId>");
        sb.append("</Voice>");
        sb.append("</xml>");
        return sb.toString();
    }

    /**
     * 回复视频消息
     *
     * @param toUserName   接收方帐号（收到的OpenID）
     * @param fromUserName 开发者微信号
     * @param mediaId      通过素材管理接口上传多媒体文件，得到的id
     * @param title        视频消息的标题
     * @param description  视频消息的描述
     * @return
     */
    public String VideoAnswer(String toUserName, String fromUserName, String mediaId, String title, String description) {
        StringBuffer sb = new StringBuffer();
        Date data = new Date();
        sb.append("<xml>");
        sb.append("<ToUserName><![CDATA[" + toUserName + "]]></ToUserName>");
        sb.append("<FromUserName><![CDATA[" + fromUserName + "]]></FromUserName>");
        sb.append("<CreateTime>" + data.getTime() + "</CreateTime>");
        sb.append("<MsgType><![CDATA[video]]></MsgType>");
        sb.append("<Video>");
        sb.append("<MediaId><![CDATA[" + mediaId + "]]></MediaId>");
        sb.append("<Title><![CDATA[" + title + "]]></Title>");
        sb.append("<Description><![CDATA[" + description + "]]></Description>");
        sb.append("</Video>");
        sb.append("</xml>");
        return sb.toString();
    }

    /**
     * 回复音乐消息
     *
     * @param toUserName   接收方帐号（收到的OpenID）
     * @param fromUserName 开发者微信号
     * @param title        音乐标题
     * @param description  音乐描述
     * @param musicURL     音乐链接
     * @param hqMusicUrl   高质量音乐链接，WIFI环境优先使用该链接播放音乐
     * @param thumbMediaId 缩略图的媒体id，通过素材管理接口上传多媒体文件，得到的id
     * @return
     */
    public String MusicAnswer(String toUserName, String fromUserName, String title, String description, String musicURL, String hqMusicUrl, String thumbMediaId) {
        StringBuffer sb = new StringBuffer();
        Date data = new Date();
        sb.append("<xml>");
        sb.append("<ToUserName><![CDATA[" + toUserName + "]]></ToUserName>");
        sb.append("<FromUserName><![CDATA[" + fromUserName + "]]></FromUserName>");
        sb.append("<CreateTime>" + data.getTime() + "</CreateTime>");
        sb.append("<MsgType><![CDATA[music]]></MsgType>");
        sb.append("<Music>");
        sb.append("<Title><![CDATA[" + title + "]]></Title>");
        sb.append("<Description><![CDATA[" + description + "]]></Description>");
        sb.append("<MusicUrl><![CDATA[" + musicURL + "]]></MusicUrl>");
        sb.append("<HQMusicUrl><![CDATA[" + hqMusicUrl + "]]></HQMusicUrl>");
        sb.append("<ThumbMediaId><![CDATA[" + thumbMediaId + "]]></ThumbMediaId>");
        sb.append("</Music>");
        sb.append("</xml>");
        return sb.toString();
    }

    /**
     * 回复图文消息
     * @param toUserName 接收方帐号（收到的OpenID）
     * @param fromUserName 开发者微信号
     * @param newsList 图文回复实体类
     * @return
     */
    public String NewsAnswer(String toUserName, String fromUserName, List<News> newsList) {
        StringBuffer sb = new StringBuffer();
        if (newsList != null && newsList.size() > 0 && newsList.size() <= 10) {
            Date data = new Date();
            sb.append("<xml>");
            sb.append("<ToUserName><![CDATA[" + toUserName + "]]></ToUserName>");
            sb.append("<FromUserName><![CDATA[" + fromUserName + "]]></FromUserName>");
            sb.append("<CreateTime>" + data.getTime() + "</CreateTime>");
            sb.append("<MsgType><![CDATA[news]]></MsgType>");
            sb.append("<ArticleCount>" + newsList.size() + "</ArticleCount>");
            sb.append("<Articles>");
            for (News newsEntity : newsList) {
                sb.append("<item>");
                sb.append("<Title><![CDATA[" + newsEntity.getTitle() + "]]></Title>");
                sb.append("<Description><![CDATA[" + newsEntity.getDescription() + "]]></Description>");
                sb.append("<PicUrl><![CDATA[" + newsEntity.getPicUrl() + "]]></PicUrl>");
                sb.append("<Url><![CDATA[" + newsEntity.getUrl() + "]]></Url>");
                sb.append("</item>");
            }
            sb.append("</Articles>");
            sb.append("</xml>");
        }
        return sb.toString();
    }
}
