package com.huangli.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.mapper.annotation.RegisterMapper;

/**
 * @author yu zun
 * @Description
 * @date 2023/12/3 20:08
 */
@RestController
@RequestMapping("/login")

public class AdminController {
	public String login(String name,String password){
		String name1="admin";
		String password1="password";
		if(name1.equals(name)&&password.equals(password1)){
			return "登陆成功";

		}

		return "用户名或密码无效";
	}
	
}
