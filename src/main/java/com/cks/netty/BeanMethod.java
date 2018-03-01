package com.cks.netty;

import java.lang.reflect.Method;

/**
 * @Author: cks
 * @Date: Created by 下午4:43 2018/2/16
 * @Package: com.cks.netty
 * @Description: BeanMethod bean反射获取对应方法
 */
public class BeanMethod {

    private Object bean;

    private Method method;

    public Object getBean() {
        return bean;
    }

    public void setBean(Object bean) {
        this.bean = bean;
    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }


}
