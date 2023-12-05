package com.hli.modules.user.service;

import com.hli.modules.user.entity.HliStaff;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hli.modules.util.Result;
import javax.servlet.http.HttpServletResponse;

/**
* @author 61041
* @description 针对表【hli_staff】的数据库操作Service
* @createDate 2023-12-04 01:12:49
*/
public interface HliStaffService extends IService<HliStaff> {

	void queryStatus(HliStaff hliStaff, HttpServletResponse response);
}
