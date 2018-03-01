package com.cks.netty.param;

/**
 * @Author: cks
 * @Date: Created by 下午14:35 2018/2/27
 * @Package: com.cks.netty.param
 * @Description: RequestParam
 */
public class RequestParam {

    private String command;

    private Object content;

    private long id;


    public void setId(long id) {
        this.id = id;
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
