/*
package com.mall.base.component;

import com.mall.base.utils.ThreadLocalUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

*//*


import com.mall.base.utils.ThreadLocalUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.el.MethodInfo;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

*/
/**
 * @Description
 * @Author Jiang
 * @Date 2018/11/8 14:58
 * @Version 1.0
 **//*


@Component
@Aspect
public class AOP {

    @Pointcut("@annotation(Secure)")
    public void params() {
    }

    @Before("params()")
    public void doBefore(JoinPoint joinPoint) throws ClassNotFoundException, ChangeSetPersister.NotFoundException, IOException {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        HttpServletResponse response = attributes.getResponse();
        String classType = joinPoint.getTarget().getClass().getName();
        Class<?> clazz = Class.forName(classType);
        String clazzName = clazz.getName();
        String methodName = joinPoint.getSignature().getName(); //获取方法名称
        Object[] args = joinPoint.getArgs();//参数
        Map<String, Object> nameAndArgs = getFieldsName(this.getClass(), clazzName, methodName, args);//获取被切参数名称及参数值
        System.out.println(nameAndArgs.toString());
        Long userId = ThreadLocalUtils.getUserId();
        //response.sendError(401, "fasfasdfadsf");
 List<Object> requestParams = RequestParamsContextHolder.getRequestParamsLocal();//获取不能为空的参数
        RpcResponseEntity rpcResponseEntity = new RpcResponseEntity();
        boolean hasEmptyParams = false;
        for (Object o : requestParams) {
            if (nameAndArgs.containsKey(o)) {
                Object o1 = nameAndArgs.get(o);
                if (o1 == null) {
                    rpcResponseEntity.setInvoke_result_code(RpcResponseEnum.LACK_NECESSARY_PARAMS.getCode());
                    rpcResponseEntity.setInvoke_result_message(RpcResponseEnum.LACK_NECESSARY_PARAMS.getMessage());
                    hasEmptyParams = true;
                    break;
                }
            }
        }
        if (hasEmptyParams) {
            response.reset();
            response.setCharacterEncoding("UTF-8");
            response.setHeader("Content-Type", "text/plain;charset=UTF-8");
            response.setHeader("icop-content-type", "exception");
            OutputStream stream = response.getOutputStream();
            net.sf.json.JSONObject jsonObject = net.sf.json.JSONObject.fromObject(rpcResponseEntity);
            stream.write(jsonObject.toString().getBytes("UTF-8"));
        }
        //获取参数名称和值
        logger.info("当前调用接口-[" + request.getRequestURL() + "]");*/
/*

    }

    *//*

*/
/**
     * 通过反射机制 获取被切参数名以及参数值
     *
     * @param cls
     * @param clazzName
     * @param methodName
     * @param args
     * @return
     * @throws NotFoundException
     *//*


    private Map<String, Object> getFieldsName(Class cls, String clazzName, String methodName, Object[] args) throws
        ChangeSetPersister.NotFoundException {
        Map<String, Object> map = new HashMap<String, Object>();

        ClassPool pool = ClassPool.getDefault();
        //Cla1ssClassPath classPath = new ClassClassPath(this.getClass());
        ClassClassPath classPath = new ClassClassPath(cls);
        pool.insertClassPath(classPath);

        CtClass cc = pool.get(clazzName);
        CtMethod cm = cc.getDeclaredMethod(methodName);
        MethodInfo methodInfo = cm.getMethodInfo();
        CodeAttribute codeAttribute = methodInfo.getCodeAttribute();
        LocalVariableAttribute attr = (LocalVariableAttribute) codeAttribute.getAttribute(LocalVariableAttribute.tag);
        if (attr == null) {
            // exception
        }
        // String[] paramNames = new String[cm.getParameterTypes().length];
        int pos = Modifier.isStatic(cm.getModifiers()) ? 0 : 1;
        for (int i = 0; i < cm.getParameterTypes().length; i++) {
            map.put(attr.variableName(i + pos), args[i]);//paramNames即参数名
        }
        return map;
    }
}
*/
