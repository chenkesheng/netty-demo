package com.cks.netty;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.cks.netty.param.RequestParam;

/**
 * @Author: cks
 * @Date: Created by 下午14:35 2018/2/27
 * @Package: com.cks.netty
 * @Description:
 */
public class Media {

    public static Map<String, BeanMethod> beanMap;

    static {
        beanMap = new HashMap<>();
    }

    public static Object execute(RequestParam request) {
        try {
            String command = request.getCommand();
            BeanMethod beanMethod = beanMap.get(command);
            if (beanMethod == null) {
                return null;
            }

            Object bean = beanMethod.getBean();
            Method method = beanMethod.getMethod();

            //获取参数类型
            Class<?> paramType = method.getParameterTypes()[0];

            Object parameter = JSONObject.parseObject(JSONObject.toJSONString(request.getContent()), paramType);

            Object result = method.invoke(bean, parameter);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
