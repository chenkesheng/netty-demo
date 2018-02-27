package com.cks.netty.bye;


import com.alibaba.fastjson.JSONObject;
import com.cks.netty.client.TcpClient;
import com.cks.netty.param.Request;
import com.cks.user.model.User;
import org.junit.jupiter.api.Test;

public class TcpClientTest {

	@Test
	public void testClient(){
		for(int i=0;i<100;i++){
			Request request = new Request();
			request.setCommand("saveUser");
			User user = new User();
			user.setAge("24");
			user.setId(i);
			user.setName("张三"+i);
			request.setContent(user);
			Object result = TcpClient.send(request);
			
			System.out.println("客户端长连接测试返回结果"+JSONObject.toJSONString(result));
		}
	
	}
}
