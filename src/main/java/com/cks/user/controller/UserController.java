package com.cks.user.controller;

import com.cks.netty.annotation.Action;
import com.cks.user.model.User;
import org.springframework.stereotype.Controller;

/**
 * @Author: cks
 * @Date: Created by 下午14:35 2018/2/27
 * @Package: com.cks.netty.client
 * @Description: UserController
 */
@Controller
public class UserController {
	
	
	@Action("saveUser")
	public Object save(User user){
		System.out.println(user.getName());
		return user.getName();
	}

}
