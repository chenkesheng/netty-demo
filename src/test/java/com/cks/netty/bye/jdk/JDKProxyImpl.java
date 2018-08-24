package com.cks.netty.bye.jdk;

import java.lang.reflect.Proxy;

/**
 * @Author: cks
 * @Date: Created by 14:00 2018/8/24
 * @Package: com.cks.netty.bye.jdk
 * @Description:
 */
public class JDKProxyImpl implements IProxyProvider {

    private ICks cks;

    private Object target;


    public JDKProxyImpl() {
    }

    public JDKProxyImpl(ICks cks, Object target) {
        this.cks = cks;
        this.target = target;
    }

    public ICks getCks() {
        return cks;
    }

    public void setCks(ICks cks) {
        this.cks = cks;
    }

    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }

    @Override
    public Object getProxyObj() {
        Object obj = Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), (proxy, method, args) -> {
            if (cks != null){
                cks.before();
            }
            Object result = method.invoke(target,args);
            if (cks != null){
                cks.after();
            }
            return result;
        });
        return obj;
    }
}
