package com.mall.order.util;

import com.mall.order.domain.News;
import com.mall.order.domain.ReceiveXml;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Junhe on 2018/8/3.
 */
public class TulingApiProcess {
    public String getTulingResult(ReceiveXml xmlEntity) {
        // 此处为图灵api接口，参数key需要自己去注册申请
        String apiUrl = "http://www.tuling123.com/openapi/api?key=b7f43c0d5643fb066240c6a7bce1f9dc&info=";
        String param = "";
        try {
            param = apiUrl + URLEncoder.encode(xmlEntity.getContent(), "utf-8");
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }//将参数转为url编码
        //发送httpget请求

        String result = new WechatApi().HttpGet(param);

        if (null == result) {
            return "对不起，我不能理解你说的话……";
        }
        try {
            JSONObject jsons = new JSONObject(result);
            if (100000 == jsons.getInt("code")) {//100000	文本类
                // result=new AnswerUtil().ImageAnswer(xmlEntity.getFromUserName(), xmlEntity.getToUserName(),"GlZhjhRDJLMirWhxQu-RCbpHRzcnVhXNTi10JfBf5vw");
                result = new AnswerUtil().TextAnswer(xmlEntity.getFromUserName(), xmlEntity.getToUserName(), jsons.getString("text"));
            } else if (200000 == jsons.getInt("code")) {//200000	链接类
                News newsEntity = new News();
                newsEntity.setTitle(jsons.getString("text"));
                newsEntity.setUrl(jsons.getString("url"));
                newsEntity.setDescription(jsons.getString("text"));
                newsEntity.setPicUrl("http://cesiumai.oss-cn-shenzhen.aliyuncs.com/upload/image/201701/51ce6e41-9866-45c7-8880-795f49a618e0.jpg");
                List<News> newsEntityList = new ArrayList<>();
                newsEntityList.add(newsEntity);
                result = new AnswerUtil().NewsAnswer(xmlEntity.getFromUserName(), xmlEntity.getToUserName(), newsEntityList);
            } else if (302000 == jsons.getInt("code")) {//302000	新闻类
                JSONObject newjson = new JSONObject(result);
                JSONArray jsonArray = new JSONArray(newjson.getString("list"));
                List<News> newsList = new ArrayList<>();

                for (int i = 0; i < jsonArray.length(); i++) {
                    if(i==8){
                        break;
                    }
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    News news = new News();
                    news.setTitle(jsonObject.getString("article"));
                    news.setUrl(jsonObject.getString("detailurl"));
                    news.setDescription(jsonObject.getString("source"));
                    news.setPicUrl(jsonObject.getString("icon"));
                    newsList.add(news);

                }
                result = new AnswerUtil().NewsAnswer(xmlEntity.getFromUserName(), xmlEntity.getToUserName(), newsList);
            } else if (308000 == jsons.getInt("code")) {//308000	菜谱类
                JSONObject jsoninfo = new JSONObject(result);
                JSONArray jsonArray = new JSONArray(jsoninfo.getString("list"));
                List<News> newsList = new ArrayList<>();

                for (int i = 0; i < jsonArray.length(); i++) {
                    if(i==8){
                        break;
                    }
                    News news = new News();
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    news.setTitle(jsonObject.getString("name"));
                    news.setUrl(jsonObject.getString("detailurl"));
                    news.setDescription(jsonObject.getString("info"));
                    news.setPicUrl(jsonObject.getString("icon"));
                    newsList.add(news);

                }
                result = new AnswerUtil().NewsAnswer(xmlEntity.getFromUserName(), xmlEntity.getToUserName(), newsList);
            }
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;

    }
}

