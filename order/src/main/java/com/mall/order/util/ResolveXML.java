package com.mall.order.util;

import com.mall.order.domain.ReceiveXml;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Iterator;

/**
 * Created by Junhe on 2018/8/3.
 */
public class ResolveXML {
    private static final Logger LOGGER = LoggerFactory.getLogger(ResolveXML.class);
    public ReceiveXml getMesEntity(String xml){
        ReceiveXml receiveXml = null;
        if(xml.length()<=0 || xml==null){
            return null;
        }
        try {
            //将字符串转化为xml文档对象
            Document document = DocumentHelper.parseText(xml);
            //获取节点
            Element root = document.getRootElement();
            //遍历所节点下的所有子节点
            Iterator<?> iter = root.elementIterator();
            receiveXml = new ReceiveXml();
            //利用反射机制，调用set方法
            //获得该实体的元类型
            Class<?> c = Class.forName("com.mall.order.domain.ReceiveXml");
            receiveXml = (ReceiveXml)c.newInstance();//创建这个实体的对象
            while(iter.hasNext()){
                Element element = (Element) iter.next();
                //获取set方法中的参数字段（实体类的属性）
                Field field = c.getDeclaredField(element.getName());
                //获取set方法，field.getType())获取它的参数数据类型
                Method method = c.getDeclaredMethod("set"+element.getName(),field.getType());
                //调用set方法
                method.invoke(receiveXml,element.getText());
            }
        } catch (DocumentException e) {
            LOGGER.info("xml异常:"+xml);
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return receiveXml;
    }
}
