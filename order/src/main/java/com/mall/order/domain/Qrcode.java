package com.mall.order.domain;

/**
 * Created by Junhe on 2018/8/5.
 *
 * 二维码
 */
public class Qrcode {

    //二维码有效时间
    private String expire_seconds;
    //二维码类型
    private String action_name;
    //二维码详细信息
    private String action_info;
    //场景值ID
    private String scene_id;
    //场景值ID
    private String scene_str;

    public String getExpire_seconds() {
        return expire_seconds;
    }

    public void setExpire_seconds(String expire_seconds) {
        this.expire_seconds = expire_seconds;
    }

    public String getAction_name() {
        return action_name;
    }

    public void setAction_name(String action_name) {
        this.action_name = action_name;
    }

    public String getAction_info() {
        return action_info;
    }

    public void setAction_info(String action_info) {
        this.action_info = action_info;
    }

    public String getScene_id() {
        return scene_id;
    }

    public void setScene_id(String scene_id) {
        this.scene_id = scene_id;
    }

    public String getScene_str() {
        return scene_str;
    }

    public void setScene_str(String scene_str) {
        this.scene_str = scene_str;
    }
}
