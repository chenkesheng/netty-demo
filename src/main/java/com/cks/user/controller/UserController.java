package com.cks.user.controller;

import com.cks.netty.annotation.Action;
import com.cks.user.model.User;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
	
	
	@Action("saveUser")
	public Object save(User user){
		System.out.println(user.getName());
		return user.getName();
	}

}
