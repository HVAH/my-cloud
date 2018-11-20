package com.mall.order.util;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import javax.net.ssl.SSLContext;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/**
 * Created by Junhe on 2018/8/3.
 */
public class WechatApi {
    /**
     * 获取access token   GET请求
     *
     * @param appid     第三方用户唯一凭证
     * @param appsecret 第三方用户唯一凭证密钥，即appsecret
     * @return
     */
    public String GetAccess_token(String appid, String appsecret) {
        String apiUrl = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=" + appid + "&secret=" + appsecret;
        String result = "";
        try {
            JSONObject jsons = new JSONObject(HttpGet(apiUrl));
            result = jsons.getString("access_token");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 生成带参数的二维码
     *
     * @return
     */
    public String qrcode(String access_token){
        String apiUrl = "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token="+access_token;
        String parameters = "{\"expire_seconds\": 604800, \"action_name\": \"QR_STR_SCENE\", \"action_info\": {\"scene\": {\"scene_str\": \"Junhe\"}}}";
        String result = "";
        try {
            JSONObject jsons = new JSONObject(HttpPost(apiUrl,parameters));
            result = jsons.getString("url");
            System.out.println("二维码:"+result);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return result;
    }
    /**
     * 获取自动回复规则 GET请求
     *
     * @param access_token
     * @return
     */
    public String GetCurrentAutoReply(String access_token) {
        String apiUrl = "https://api.weixin.qq.com/cgi-bin/get_current_autoreply_info?access_token=" + access_token;
        return null;
    }

    /**
     * 创建自定义菜单 POST请求
     *
     * @param access_token
     * @param json         自定义菜单json
     * @return
     */
    public String CreateMenu(String access_token, String json) {
        String apiUrl = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=" + access_token;
        return null;
    }

    /**
     * 创建个性化菜单 POST请求
     *
     * @param access_token
     * @param json         自定义菜单json
     * @return
     */
    public String CreatePersonalizedMenu(String access_token, String json) {
        String apiUrl = "https://api.weixin.qq.com/cgi-bin/menu/addconditional?access_token=" + access_token;
        return null;
    }

    /**
     * 获取自定义菜单 GET请求
     *
     * @param access_token
     * @return
     */
    public String GetMenu(String access_token) {
        String apiUrl = "https://api.weixin.qq.com/cgi-bin/menu/get?access_token=" + access_token;
        return null;
    }

    /**
     * 获取自定义菜单配置 GET请求   (本接口与自定义菜单查询接口的不同之处在于，本接口无论公众号的接口是如何设置的，都能查询到接口，而自定义菜单查询接口则仅能查询到使用API设置的菜单配置)
     *
     * @param access_token
     * @return
     */
    public String GetPublicMenu(String access_token) {
        String apiUrl = "https://api.weixin.qq.com/cgi-bin/get_current_selfmenu_info?access_token=" + access_token;
        return null;
    }

    /**
     * 删除自定义菜单 GET请求
     *
     * @param access_token
     * @return
     */
    public String DeleteMenu(String access_token) {
        String apiUrl = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=" + access_token;
        return null;
    }

    /**
     * 删除个性化菜单 GET请求
     *
     * @param access_token
     * @return
     */
    public String DeletePersonalizedMenu(String access_token) {
        String apiUrl = "https://api.weixin.qq.com/cgi-bin/menu/delconditional?access_token=" + access_token;
        return null;
    }

    /**
     * 添加客服帐号 POST请求
     *
     * @param access_token
     * @param json
     * @return
     */
    public String AddCostomService(String access_token, String json) {
        String apiUrl = "https://api.weixin.qq.com/customservice/kfaccount/add?access_token=" + access_token;
        return null;
    }

    /**
     * 修改客服帐号 POST请求
     *
     * @param access_token
     * @param json
     * @return
     */
    public String UpdateCostomService(String access_token, String json) {
        String apiUrl = "https://api.weixin.qq.com/customservice/kfaccount/update?access_token=" + access_token;
        return null;
    }

    /**
     * 删除客服帐号 GET请求
     *
     * @param access_token
     * @return
     */
    public String DeleteCostomService(String access_token) {
        String apiUrl = "https://api.weixin.qq.com/customservice/kfaccount/del?access_token=" + access_token;
        return null;
    }

    /**
     * 创建用户分组 POST请求
     *
     * @param access_token
     * @param json
     * @return
     */
    public String CreateGroup(String access_token, String json) {
        String apiUrl = "https://api.weixin.qq.com/cgi-bin/groups/create?access_token=" + access_token;
        return null;
    }

    /**
     * 查询所有分组 GET请求
     *
     * @param access_token
     * @return
     */
    public String GetAllGroup(String access_token) {
        String apiUrl = "https://api.weixin.qq.com/cgi-bin/groups/get?access_token=" + access_token;
        return null;
    }

    /**
     * 查询用户所在分组 POST请求
     *
     * @param access_token
     * @param json
     * @return
     */
    public String BelongGroup(String access_token, String json) {
        String apiUrl = "https://api.weixin.qq.com/cgi-bin/groups/getid?access_token=" + access_token;
        return null;
    }

    /**
     * 修改分组名 POST请求
     *
     * @param access_token
     * @return
     */
    public String UpdateGroupName(String access_token) {
        String apiUrl = "https://api.weixin.qq.com/cgi-bin/groups/update?access_token=" + access_token;
        return null;
    }

    /**
     * 移动用户分组 POST请求
     *
     * @param access_token
     * @param json
     * @return
     */
    public String MoveMembersToGroup(String access_token, String json) {
        String apiUrl = "https://api.weixin.qq.com/cgi-bin/groups/members/update?access_token=" + access_token;
        return null;
    }

    /**
     * 批量移动用户分组
     *
     * @param access_token
     * @param json
     * @return
     */
    public String BatchMoveToGroup(String access_token, String json) {
        String apiUrl = "https://api.weixin.qq.com/cgi-bin/groups/members/batchupdate?access_token=" + access_token;
        return null;
    }

    /**
     * 删除分组
     *
     * @param access_token
     * @param json
     * @return
     */
    public String DeleteGroup(String access_token, String json) {
        String apiUrl = "https://api.weixin.qq.com/cgi-bin/groups/delete?access_token=" + access_token;
        return null;
    }

    /**
     * 设置用户备注名 POST请求
     *
     * @param access_token
     * @param json
     * @return
     */
    public String UpdateRemark(String access_token, String json) {
        String apiUrl = "https://api.weixin.qq.com/cgi-bin/user/info/updateremark?access_token=" + access_token;
        return null;
    }

    /**
     * 获取用户基本信息（包括UnionID机制） GET请求
     *
     * @param access_token
     * @param openid
     * @return
     */
    public JSONObject GetUseInfo(String access_token, String openid) {
        String apiUrl = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=" + access_token + "&openid=" + openid + "&lang=zh_CN";
        System.out.println("access_token:"+access_token);
        System.out.println("openid:"+openid);
        JSONObject result = null;
        try {
            result = new JSONObject(HttpGet(apiUrl));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 批量获取用户基本信息 POST请求
     *
     * @param access_token
     * @param json
     * @return
     */
    public String GetBatchUseInfo(String access_token, String json) {
        String apiUrl = "https://api.weixin.qq.com/cgi-bin/user/info/batchget?access_token=" + access_token;
        return null;
    }

    /**
     * 获取用户列表 GET请求
     *
     * @param access_token
     * @param next_openid  第一个拉取的OPENID，不填默认从头开始拉取
     * @return
     */
    public String GetUseList(String access_token, String next_openid) {
        String apiUrl = "https://api.weixin.qq.com/cgi-bin/user/get?access_token=" + access_token + "&next_openid=" + next_openid;
        return null;
    }

    /**
     * 获取用户增减数据 POST请求
     *
     * @param access_token
     * @return
     */
    public String GetUserSummary(String access_token, String json) {
        String apiUrl = "https://api.weixin.qq.com/datacube/getusersummary?access_token=" + access_token;
        return null;
    }

    /**
     * 获取累计用户数据 POST请求
     *
     * @param access_token
     * @return
     */
    public String GetUserCumulate(String access_token, String json) {
        String apiUrl = "https://api.weixin.qq.com/datacube/getusercumulate?access_token=" + access_token;
        return null;
    }

    /**
     * 获取图文群发每日数据 POST请求
     *
     * @param access_token
     * @return
     */
    public String GetArticleSummary(String access_token, String json) {
        String apiUrl = "https://api.weixin.qq.com/datacube/getarticlesummary?access_token=" + access_token;
        return null;
    }

    /**
     * 获取图文群发总数据 POST请求
     *
     * @param access_token
     * @return
     */
    public String GetArticletotal(String access_token, String json) {
        String apiUrl = "https://api.weixin.qq.com/datacube/getarticletotal?access_token=" + access_token;
        return null;
    }

    /**
     * 获取图文统计数据 POST请求
     *
     * @param access_token
     * @return
     */
    public String GetUserRead(String access_token, String json) {
        String apiUrl = "https://api.weixin.qq.com/datacube/getuserread?access_token=" + access_token;
        return null;
    }

    /**
     * 获取图文统计分时数据 POST请求
     *
     * @param access_token
     * @return
     */
    public String GetUserReadHour(String access_token, String json) {
        String apiUrl = "https://api.weixin.qq.com/datacube/getuserreadhour?access_token=" + access_token;
        return null;
    }

    /**
     * 获取图文分享转发数据 POST请求
     *
     * @param access_token
     * @return
     */
    public String GetUserShare(String access_token, String json) {
        String apiUrl = "https://api.weixin.qq.com/datacube/getusershare?access_token=" + access_token;
        return null;
    }

    /**
     * 获取图文分享转发分时数据 POST请求
     *
     * @param access_token
     * @return
     */
    public String GetUserShareHour(String access_token, String json) {
        String apiUrl = "https://api.weixin.qq.com/datacube/getusersharehour?access_token=" + access_token;
        return null;
    }

    /**
     * 获取消息发送概况数据 POST请求
     *
     * @param access_token
     * @return
     */
    public String GetUpstreamMsg(String access_token, String json) {
        String apiUrl = "https://api.weixin.qq.com/datacube/getupstreammsg?access_token=" + access_token;
        return null;
    }

    /**
     * 获取消息分送分时数据 POST请求
     *
     * @param access_token
     * @return
     */
    public String GetUpstreamMsgHour(String access_token, String json) {
        String apiUrl = "https://api.weixin.qq.com/datacube/getupstreammsghour?access_token=" + access_token;
        return null;
    }

    /**
     * 获取消息发送周数据 POST请求
     *
     * @param access_token
     * @return
     */
    public String GetUpstreamMsgWeek(String access_token, String json) {
        String apiUrl = "https://api.weixin.qq.com/datacube/getupstreammsgweek?access_token=" + access_token;
        return null;
    }

    /**
     * 获取消息发送月数据 POST请求
     *
     * @param access_token
     * @return
     */
    public String GetUpstreamMsgMonth(String access_token, String json) {
        String apiUrl = "https://api.weixin.qq.com/datacube/getupstreammsgmonth?access_token=" + access_token;
        return null;
    }

    /**
     * 获取消息发送分布数据 POST请求
     *
     * @param access_token
     * @return
     */
    public String GetUpstreamMsgDist(String access_token, String json) {
        String apiUrl = "https://api.weixin.qq.com/datacube/getupstreammsgdist?access_token=" + access_token;
        return null;
    }

    /**
     * 获取消息发送分布周数据 POST请求
     *
     * @param access_token
     * @return
     */
    public String GetUpstreamMsgDistWeek(String access_token, String json) {
        String apiUrl = "https://api.weixin.qq.com/datacube/getupstreammsgdistweek?access_token=" + access_token;
        return null;
    }

    /**
     * 获取消息发送分布月数据 POST请求
     *
     * @param access_token
     * @return
     */
    public String GetUpstreamMsgDistMonth(String access_token, String json) {
        String apiUrl = "https://api.weixin.qq.com/datacube/getupstreammsgdistmonth?access_token=" + access_token;
        return null;
    }

    /**
     * 获取接口分析数据 POST请求
     *
     * @param access_token
     * @return
     */
    public String GetInterfaceSummary(String access_token, String json) {
        String apiUrl = "https://api.weixin.qq.com/datacube/getinterfacesummary?access_token=" + access_token;
        return null;
    }

    /**
     * 获取接口分析分时数据 POST请求
     *
     * @param access_token
     * @return
     */
    public String GetInterfaceSummaryHour(String access_token, String json) {
        String apiUrl = "https://api.weixin.qq.com/datacube/getinterfacesummaryhour?access_token=" + access_token;
        return null;
    }

    /**
     * 新增临时素材 POST请求
     *
     * @param access_token
     * @param type
     * @return
     */
    public String UploadTempMaterial(String access_token, String type) {
        String apiUrl = "https://api.weixin.qq.com/cgi-bin/media/upload?access_token=" + access_token + "&type=" + type;
        return null;
    }

    /**
     * 新增永久素材 POST请求
     *
     * @param access_token
     * @param type
     * @return
     */
    public String UploadMaterial(String access_token, String type) {
        String apiUrl = "https://api.weixin.qq.com/cgi-bin/material/add_material?access_token=" + access_token;
        return null;
    }

    /**
     * 删除永久素材 POST请求
     *
     * @param access_token
     * @param type
     * @return
     */
    public String DelMaterial(String access_token, String type) {
        String apiUrl = "https://api.weixin.qq.com/cgi-bin/material/del_material?access_token=" + access_token;
        return null;
    }

    /**
     * 新增永久图文素材 POST请求
     *
     * @param access_token
     * @param json
     * @return
     */
    public String AddNewsMaterial(String access_token, String json) {
        String apiUrl = "https://api.weixin.qq.com/cgi-bin/material/add_news?access_token=" + access_token;
        return null;
    }

    /**
     * 修改永久图文素材 POST请求
     *
     * @param access_token
     * @param json
     * @return
     */
    public String UpdateNewsMaterial(String access_token, String json) {
        String apiUrl = "https://api.weixin.qq.com/cgi-bin/material/update_news?access_token=" + access_token;
        return null;
    }

    /**
     * 获取永久素材 POST请求
     *
     * @param access_token
     * @param json
     * @return
     */
    public String GetMaterial(String access_token, String json) {
        String apiUrl = "https://api.weixin.qq.com/cgi-bin/material/get_material?access_token=" + access_token;
        return null;
    }

    /**
     * 上传图文消息内的图片获取URL POST请求
     *
     * @param access_token
     * @return
     */
    public String UploadImg(String access_token) {
        String apiUrl = "https://api.weixin.qq.com/cgi-bin/media/uploadimg?access_token=" + access_token;
        return null;
    }

    /**
     * 获取素材总数 GET请求
     *
     * @param access_token
     * @return
     */
    public String GetMaterailCount(String access_token) {
        String apiUrl = "https://api.weixin.qq.com/cgi-bin/material/get_materialcount?access_token=" + access_token;
        return null;
    }

    /**
     * 获取素材列表  POST请求
     *
     * @param access_token
     * @param json
     * @return
     */
    public String GetMaterialList(String access_token, String json) {
        String apiUrl = "https://api.weixin.qq.com/cgi-bin/material/batchget_material?access_token=" + access_token;
        return null;
    }


    /**
     * HttpGet请求
     *
     * @param url
     * @return
     */
    public String HttpGet(String url) {
        String result = "";
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //创建 HttpGet
        HttpGet httpGet = new HttpGet(url);
        //执行get请求
        try {
            CloseableHttpResponse response = httpClient.execute(httpGet);
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                HttpEntity httpEntity = response.getEntity();
                result = EntityUtils.toString(httpEntity);
                EntityUtils.consume(httpEntity);
                response.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * POST请求
     *
     * @param url
     * @param parameters
     * @return
     */
    public String HttpPost(String url, String parameters) {
        String result = "";
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        try {
            StringEntity stringEntity = new StringEntity(parameters, "UTF-8");
            stringEntity.setContentType("application/json");
            httpPost.setEntity(stringEntity);
            //给请求传入参数
            CloseableHttpResponse response = httpClient.execute(httpPost);
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                HttpEntity httpEntity = response.getEntity();
                result = EntityUtils.toString(httpEntity);
                EntityUtils.consume(httpEntity);
                response.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    public String HttpPostUpload(String url, File file) throws NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        String result = "";
        MultipartEntityBuilder multipartEntityBuilder = MultipartEntityBuilder.create();
        multipartEntityBuilder.setBoundary("-------------" + System.currentTimeMillis()).setCharset(Charset.forName(HTTP.UTF_8))
                .setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
        multipartEntityBuilder.addBinaryBody("media", file, ContentType.APPLICATION_OCTET_STREAM, file.getName());
        HttpEntity httpEntity = multipartEntityBuilder.build();
        // 建立一个sslcontext，这里信任任何的证书。
        SSLContext sslContext = getTrustAllSSLContext();
        // 建立socket工厂
        SSLConnectionSocketFactory factory = new SSLConnectionSocketFactory(sslContext);
        // 建立连接器
        CloseableHttpClient httpClient = HttpClients.custom().setSSLSocketFactory(factory).build();
        HttpPost httpPost = new HttpPost(url);
        httpPost.addHeader("Connection", "keep-alive");
        httpPost.addHeader("Accept", "*/*");
        httpPost.addHeader("Content-Type", "multipart/form-data;");
        httpPost.addHeader("User-Agent",
                "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.0) ");
        //给请求传入参数
        httpPost.setEntity(httpEntity);
        try {
            CloseableHttpResponse response = httpClient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            result = EntityUtils.toString(entity);
            EntityUtils.consume(entity);
            response.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return result;
    }

    /**
     * 信任任何的证书
     *
     * @return
     * @throws KeyStoreException
     * @throws NoSuchAlgorithmException
     * @throws KeyManagementException
     */
    private static SSLContext getTrustAllSSLContext() throws KeyStoreException, NoSuchAlgorithmException, KeyManagementException {
        SSLContext sslContext = SSLContexts.custom().loadTrustMaterial(null, new TrustStrategy() {
            @Override
            public boolean isTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
                return true;
            }
        }).build();
        return sslContext;
    }

    public static void main(String[] args) throws JSONException {
        String access_token = "-UmiXe7VxSith9d8o0xX7Ob3i9nnxUQJuA_JHdRJkdfhKzVI_bmFuPI4uQva2LDrmouP03SbfIL6dvMzXQZlyGRvuMBT4GToqNCw5yOFdjss_CnLWDN5OVIQcNpRUQo8QWQfAHAUAU";
        File file = new File("D:/123.jpg");
        if (file.exists()) {

            String apiUrl = "https://api.weixin.qq.com/cgi-bin/material/add_material?access_token=" + access_token;
            String result = null;
            try {
                result = new WechatApi().HttpPostUpload(apiUrl, file);
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            } catch (KeyStoreException e) {
                e.printStackTrace();
            } catch (KeyManagementException e) {
                e.printStackTrace();
            }
            System.out.println("result=" + result);
        } else {
            System.out.println("不存在");
        }
        //result={"media_id":"GlZhjhRDJLMirWhxQu-RCSBL8B56XUq25gi9P4hieSY","url":"http:\/\/mmbiz.qpic.cn\/mmbiz_jpg\/7zHbygAvicSBnuHzKD6VzeXebTdcCD0icHKXZtvXl62xsd0qOhia53Jm2CGiaVmAhefLylxMNt5Wt0MI0CFF3q3lGA\/0?wx_fmt=jpeg"}

       /* String apiUrl = "https://api.weixin.qq.com/cgi-bin/material/batchget_material?access_token=" + access_token;
        String json = "{\n" +
                "\"type\":\"image\",\n" +
                "\"offset\":0,\n" +
                "\"count\":20\n" +
                "}";
        String result = new WechatApi().HttpPost(apiUrl, json);*/

    }
}
