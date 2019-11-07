package com.vah.reptile.collection;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.vah.reptile.entity.Poem;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Random;

public class BaiDuPoemPageProcessor implements PageProcessor {

    /**
     * 初始增量
     */
    private volatile static int i = 1;
    /**
     * 最大页码
     */
    private static final int MAX_PN = 1967;

    private SqlSession sqlSession = MybatisUtil.getSqlSession();

    private PoemDao poemDao = sqlSession.getMapper(PoemDao.class);
    private Random random = new Random();

    private Site site = Site.me().setTimeOut(20000).setRetryTimes(3).setSleepTime(3000).setRetrySleepTime(3000)
            .addCookie("BAIDUID", "FD7ECA82C4285D7D0770BE809D997647")
            .addCookie("BIDUPSID", "FD7ECA82C4285D7D0770BE809D997647")
            .addCookie("H_PS_PSSID", "1460_21097_18560_17001_22074")
            .addCookie("Hm_lpvt_010e9ef9290225e88b64ebf20166c8c4", "1520506957")
            .addCookie("Hm_lvt_010e9ef9290225e88b64ebf20166c8c4", "1520501377,1520501381,1520501555,1520501560")
            .addCookie("PSINO", "6").addCookie("PSTM", "1520501166")
            .addHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.132 Safari/537.36")
            .addHeader("Accept", "application/json, text/javascript, */*; q=0.01")
            .addHeader("Accept-Encoding", "gzip, deflate")
            .addHeader("Accept-Language", "zh-CN,zh;q=0.9").addHeader("Connection", "keep-alive").addHeader("Referer", "http://hanyu.baidu.com");

    @Override
    public void process(Page page) {

        String body = page.getHtml().xpath("//html/body/text()").toString();
        JSONObject jsonObject = JSON.parseObject(body);
        String content = jsonObject.get("ret_array").toString();
        List<Poem> poemList = JSON.parseArray(content, Poem.class);
        for (Poem p : poemList) {
            Poem formatPoem = null;
            try {
                formatPoem = (Poem) format(p);
            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchFieldException e) {
                e.printStackTrace();
            }
            assert formatPoem != null;
            System.out.print(formatPoem.getLiteratureAuthor() + " - " + formatPoem.getDisplayName());
            poemDao.insertPoem(formatPoem);
            try {
                sqlSession.commit();
                System.out.println(" : 插入成功");
            } catch (Exception e) {
                sqlSession.rollback();
                System.out.println(" : 插入失败");
            }
        }
        if (i < MAX_PN) {
            i++;
            String url = "http://hanyu.baidu.com/hanyu/ajax/search_list?wd=%E5%94%90%E8%AF%97&device=pc&from=home&pn=" + i + "&_=" + System.currentTimeMillis();
            // 将URL添加到请求列表
            page.addTargetRequest(url);
            // 间隔时间
            int setSleepTime = random.nextInt(10000) % (10000 - 500 + 1) + 500;
            try {
                Thread.sleep(setSleepTime);
                System.out.println(setSleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public Site getSite() {
        return site;
    }

    /**
     * 过滤对象字段中的 <tt>["</tt> 和 <tt>"]</tt> 字符
     *
     * @param object object
     * @return newObj
     */
    private static Object format(Object object) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        Field[] f = object.getClass().getDeclaredFields();
        Class clazz = Class.forName(object.getClass().getName());
        Object newObj = clazz.newInstance();
        for (Field ft : f) {
            ft.setAccessible(true);
            Field field = clazz.getDeclaredField(ft.getName());
            field.setAccessible(true);
            field.set(newObj, ft.get(object).toString().substring(2, ft.get(object).toString().length() - 2));
        }
        return newObj;
    }

    public static void main(String[] args) throws Exception {
        String url = "http://hanyu.baidu.com/hanyu/ajax/search_list?wd=%E5%94%90%E8%AF%97&device=pc&from=home&pn=1&_=1520506954955";
        Spider.create(new BaiDuPoemPageProcessor()).addUrl(url).thread(1).run();
    }
}
