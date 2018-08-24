package com.cks.netty.bye.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author: cks
 * @Date: Created by 17:41 2018/8/15
 * @Package: com.cks.netty.bye.cglib
 * @Description:
 */
public class CksProxy implements MethodInterceptor {
    //Cks 创建代理对象
    private Enhancer enhancer = new Enhancer();

    //通过Class对象获取代理对象
    public Object getProxy(Class c){
        //设置创建子类的类
        enhancer.setSuperclass(c);
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("start...");
        methodProxy.invokeSuper(o, objects);
        System.out.println("end....");
        return null;
    }
}
