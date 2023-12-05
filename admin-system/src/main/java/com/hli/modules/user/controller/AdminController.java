package com.hli.modules.user.controller;

import com.hli.modules.user.entity.Admin;
import com.hli.modules.user.service.AdminService;
import com.hli.modules.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author  yu zun
 * @Description
 * @date  2023/12/4 1:28
 */

@RequestMapping("/admin")
@RestController
public class AdminController {
	@Autowired
	private AdminService adminService;
	@PostMapping("/login")
	private Result<?> login(@RequestBody Admin admin) {

		System.out.println(admin);

		return adminService.loginLogin(admin);
	}

}
