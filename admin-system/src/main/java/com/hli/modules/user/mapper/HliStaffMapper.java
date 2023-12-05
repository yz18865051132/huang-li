package com.hli.modules.user.mapper;

import com.hli.modules.user.entity.HliStaff;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author 61041
* @description 针对表【hli_staff】的数据库操作Mapper
* @createDate 2023-12-04 01:12:49
* @Entity com.hli.entity.HliStaff
*/
public interface HliStaffMapper extends BaseMapper<HliStaff> {

	//查询一个用户
	HliStaff selectOneByAge(HliStaff hliStaff);

}




