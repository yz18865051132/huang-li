package com.hli.modules.user.mapper;

import com.hli.modules.user.entity.Admin;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 61041
* @description 针对表【admin】的数据库操作Mapper
* @createDate 2023-12-04 01:21:32
* @Entity com.hli.entity.Admin
*/
@Mapper
public interface AdminMapper extends BaseMapper<Admin> {
	//登录查新
	Admin loginSelectOne(Admin admin);
}




