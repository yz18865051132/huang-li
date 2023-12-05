package com.huangli.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huangli.entity.HliStaff;
import com.huangli.service.HliStaffService;
import com.huangli.mapper.HliStaffMapper;
import org.springframework.stereotype.Service;

/**
* @author 61041
* @description 针对表【hli_staff】的数据库操作Service实现
* @createDate 2023-12-03 19:26:31
*/
@Service
public class HliStaffServiceImpl extends ServiceImpl<HliStaffMapper, HliStaff>
    implements HliStaffService{

	/**
	 * @param hliStaff
	 * @return
	 */

	private HliStaffMapper hliStaffMapper;
	@Override
	public HliStaff login(HliStaff hliStaff) {

		return null;
	}
}




