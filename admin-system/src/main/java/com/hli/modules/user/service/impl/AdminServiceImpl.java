package com.hli.modules.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hli.modules.user.entity.Admin;
import com.hli.modules.user.service.AdminService;
import com.hli.modules.user.mapper.AdminMapper;
import com.hli.modules.util.Result;
import java.util.List;
import org.springframework.stereotype.Service;

/**
* @author 61041
* @description 针对表【admin】的数据库操作Service实现
* @createDate 2023-12-04 01:21:32
*/
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin>
    implements AdminService{

	//用户登录
	@Override
	public Result<?> loginLogin(Admin admin) {
		QueryWrapper<Admin> queryWrapper =new QueryWrapper<>();
		queryWrapper.lambda().eq(Admin::getName,admin.getName()).eq(Admin::getPassword,admin.getPassword());
		if(queryWrapper.isEmptyOfEntity()){

			List<Admin> adminList=this.list(queryWrapper);
			admin=adminList.get(0);
			System.out.println(admin);
			return Result.ok(admin);

		}
		return null;
	}
}




