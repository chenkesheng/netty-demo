package com.cks.netty.param;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @Author: cks
 * @Date: Created by 下午14:35 2018/2/27
 * @Package: com.cks.netty.param
 * @Description: Request
 */
public class Request {

    private String command;

    private Object content;

    private final long id;

    public static final AtomicLong nid = new AtomicLong(0);


    public Request() {
        id = nid.incrementAndGet();
    }

    public long getId() {
        return id;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }


}
