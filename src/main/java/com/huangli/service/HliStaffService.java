package com.huangli.service;

import com.huangli.entity.HliStaff;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author 61041
* @description 针对表【hli_staff】的数据库操作Service
* @createDate 2023-12-03 19:26:31
*/
public interface HliStaffService extends IService<HliStaff> {
	HliStaff login(HliStaff hliStaff);

}
