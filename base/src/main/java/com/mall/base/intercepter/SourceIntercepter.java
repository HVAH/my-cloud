package com.mall.base.intercepter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description 资源拦截器
 * @Author HuangJiang
 * @Date 2018/10/17 10:44
 * @Version 1.0
 */
public class SourceIntercepter implements HandlerInterceptor {

    private static final Logger LOGGER = LoggerFactory.getLogger(SourceIntercepter.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        /*if (handler instanceof HandlerMethod) {
            String servletPath = request.getServletPath();
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Class<?> clazz = handlerMethod.getBeanType();
            RequestMapping requestMapping = clazz.getAnnotation(RequestMapping.class);
            String[] controllerMappingUrls = requestMapping.value();
            Method method = handlerMethod.getMethod();
            Annotation[] annotations = method.getAnnotations();
            String[] methodMappingUrls = null;
            for (Annotation annotation : annotations) {
                if (annotation instanceof PostMapping) {
                    methodMappingUrls = ((PostMapping) annotation).value();
                } else if (annotation instanceof GetMapping) {
                    methodMappingUrls = ((GetMapping) annotation).value();
                } else if (annotation instanceof DeleteMapping) {
                    methodMappingUrls = ((DeleteMapping) annotation).value();
                } else if (annotation instanceof PatchMapping) {
                    methodMappingUrls = ((PatchMapping) annotation).value();
                }
            }


            ArrayList requestMappingPaths = new ArrayList<>();
            requestMappingPaths.add(Arrays.asList(controllerMappingUrls));
            requestMappingPaths.add(Arrays.asList(methodMappingUrls));
            //requestMappingPaths = Dikaer(requestMappingPaths);
            method.getAnnotation(PostMapping.class);
            Parameter[] parameters = method.getParameters();

            for (Parameter parameter : parameters) {
                SourceValid sourceValid = parameter.getAnnotation(SourceValid.class);
                if (sourceValid == null) {
                    sourceValid = parameter.getDeclaredAnnotation(SourceValid.class);
                }
                if (sourceValid != null) {
                    //validSource(sourceValid, parameter, )
                }
            }


        }*/
        return true;
    }


    private boolean validSource(SourceValid sourceValid, Parameter parameter, String disPactherUrl, List<String> requestMappingPaths, HttpServletRequest request) {
        return true;
    }

    /**
     * TODO 笛卡尔积 待完成
     * @param al0
     * @return
     */
    public static ArrayList Dikaer(ArrayList al0) {
        ArrayList a0 = (ArrayList) al0.get(0);// l1   
        ArrayList result = new ArrayList();// 组合的结果  
        for (int i = 1; i < al0.size(); i++) {
            ArrayList a1 = (ArrayList) al0.get(i);
            ArrayList temp = new ArrayList();
            //每次先计算两个集合的笛卡尔积，然后用其结果再与下一个计算  
            for (int j = 0; j < a0.size(); j++) {
                for (int k = 0; k < a1.size(); k++) {
                    ArrayList cut = new ArrayList();
                    if (a0.get(j) instanceof ArrayList) {
                        cut.addAll((ArrayList) a0.get(j));
                    } else {
                        cut.add(a0.get(j));
                    }
                    if (a1.get(k) instanceof ArrayList) {
                        cut.addAll((ArrayList) a1.get(k));
                    } else {
                        cut.add(a1.get(k));
                    }
                    temp.add(cut);
                }
            }
            a0 = temp;
            if (i == al0.size() - 1) {
                result = temp;
            }
        }
        return result;
    }
}
