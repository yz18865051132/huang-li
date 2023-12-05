package com.hli.modules.user.controller;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hli.modules.user.entity.HliStaff;
import com.hli.modules.user.service.impl.HliStaffServiceImpl;
import com.hli.modules.util.IdUtil;
import com.hli.modules.util.Result;
import com.hli.modules.ypCeshi.entity.YpCeshi;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yu zun
 * @Description
 * @date 2023/12/4 14:33
 */
@RequestMapping("/hiliStaff")
@RestController
public class HliStaffController {
	@Autowired
	private HliStaffServiceImpl hliStaffService;
	@GetMapping(value = "/list")
	public Result<?> queryPageList(
			@RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
			@RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
			@RequestParam(name="empName",required = false) String empName,
			@RequestParam(name="daptName",required = false) String daptName,
			@RequestParam(name="empDegreeName",required = false) String empDegreeName)

			{
		QueryWrapper<HliStaff> queryWrapper = Wrappers.query();
		queryWrapper.lambda()
				.like(StrUtil.isNotEmpty(empName), HliStaff::getEmpName,empName)
				.like(StrUtil.isNotEmpty(daptName), HliStaff::getDaptName,daptName)
				.like(StrUtil.isNotEmpty(empDegreeName), HliStaff::getEmpDegreeName,empDegreeName);

		//封装翻页
		Page<HliStaff> page = new Page<>(pageNo, pageSize);
		IPage<HliStaff> pageList = hliStaffService.page(page, queryWrapper);
		return Result.ok(pageList);
	}
	@PostMapping(value = "/add")
	public Result<?> create(@RequestBody HliStaff hliStaff){

		hliStaffService.save(hliStaff);
		return Result.ok("添加成功");
	}

	/**
	 * 数据编辑接口
	 * @param hliStaff
	 * @return
	 */
	@PostMapping(value = "/update")
	public Result<?> update(@RequestBody HliStaff hliStaff){

		hliStaffService.updateById(hliStaff);
		return Result.ok("编辑成功");
	}

	/**
	 * 通过id删除
	 * @return
	 */
	@DeleteMapping(value = "/delete")
	public Result<?> delete(@RequestParam String id){
		/**
		 * 如果有删除字段，可以用此方法
		 *UpdateWrapper<YpCeshi> updateWrapper = Wrappers.update();
		 *    updateWrapper.lambda()
		 *    .eq(YpCeshi::getId, id)
		 *    .set(YpCeshi::getIsDel, "1");
		 *ypCeshiService.update(updateWrapper);
		 */
		hliStaffService.removeById(id);
		return Result.ok("删除成功");
	}
	/**
	 * 导出
	 */
	@RequestMapping("/exportStatus")
	public void exportObdStatus(@RequestBody HliStaff hliStaff, HttpServletResponse response, HttpServletRequest request){
		request.getParameter("dddd");
		request.getHeaders("");
		hliStaffService.queryStatus(hliStaff,response);
	}



}
