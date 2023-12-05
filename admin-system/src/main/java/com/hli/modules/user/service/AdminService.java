package com.hli.modules.user.service;

import com.hli.modules.user.entity.Admin;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hli.modules.util.Result;

/**
* @author 61041
* @description 针对表【admin】的数据库操作Service
* @createDate 2023-12-04 01:21:32
*/
public interface AdminService extends IService<Admin> {
	//登录查询
	Result<?> loginLogin(Admin admin);


}
