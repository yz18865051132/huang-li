package com.huangli.mapper;

import com.huangli.entity.HliStaff;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 61041
* @description 针对表【hli_staff】的数据库操作Mapper
* @createDate 2023-12-03 19:26:31
* @Entity com.huangli.entity.HliStaff
*/
@Mapper
public interface HliStaffMapper extends BaseMapper<HliStaff> {
	HliStaff selectOne(String name);

}




