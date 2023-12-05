package com.hli.modules.user.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hli.modules.user.entity.HliStaff;
import com.hli.modules.user.mapper.HliStaffMapper;
import com.hli.modules.user.service.HliStaffService;
import java.net.URLEncoder;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFDataFormat;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

/**
 * @author 61041
 * @description 针对表【hli_staff】的数据库操作Service实现
 * @createDate 2023-12-04 01:12:49
 */
@Service
public class HliStaffServiceImpl extends ServiceImpl<HliStaffMapper, HliStaff>
		implements HliStaffService {

	@Override
	public void queryStatus(HliStaff hliStaff, HttpServletResponse response) {
		try {
			QueryWrapper<HliStaff> queryWrapper = Wrappers.query();
			queryWrapper.lambda()
					.like(StrUtil.isNotEmpty(hliStaff.getEmpName()), HliStaff::getEmpName,hliStaff.getEmpName())
					.like(StrUtil.isNotEmpty(hliStaff.getDaptName()), HliStaff::getDaptName,hliStaff.getDaptName())
					.like(StrUtil.isNotEmpty(hliStaff.getEmpDegreeName()), HliStaff::getEmpDegreeName,hliStaff.getEmpDegreeName());
			List<HliStaff> hliStaffsList = this.list(queryWrapper);

			String fileName =  "aa.xlsx";
			XSSFWorkbook  hssfWorkbook = new XSSFWorkbook();
			XSSFSheet hssfSheet = hssfWorkbook.createSheet("yuzun");
			XSSFDataFormat format = hssfWorkbook.createDataFormat();
			int rowNum = 0;
			XSSFRow hssfRow = hssfSheet.createRow(rowNum++);
			hssfRow.setHeightInPoints(15);
			XSSFFont font = hssfWorkbook.createFont();
			font.setFontName("宋体");
			font.setFontHeightInPoints((short) 11);//设置字体大小
			XSSFCellStyle setBorder2 = hssfWorkbook.createCellStyle();
			setBorder2.setAlignment(HSSFCellStyle.ALIGN_CENTER); //水平居中
			setBorder2.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER); //垂直居中
			setBorder2.setFillForegroundColor(HSSFColor.PALE_BLUE.index);
			setBorder2.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
			setBorder2.setFillBackgroundColor(HSSFColor.PALE_BLUE.index);
			setBorder2.setDataFormat(format.getFormat("@"));//文本格式
			setBorder2.setWrapText(true);
			setBorder2.setFont(font);

			int j = 0;
			if (hliStaffsList.size() > 0) {
				String arr[] = {"员工序号","姓名","性别","部门","部门","学历"};
				for(int a = 0; a < arr.length; a++){
					hssfRow.createCell(a).setCellValue(arr[a]);
					hssfRow.getCell(a).setCellStyle(setBorder2);
				}
				//将数据放入表中
				for (HliStaff staff : hliStaffsList) {
					//新建一行
					XSSFRow row = hssfSheet.createRow(rowNum++);
					//设置行高
					row.setHeightInPoints(15);
					j = 0;
					if (null != staff.getId() && !"".equals(staff.getId())) {
						row.createCell(j++).setCellValue(staff.getId());
					} else {
						row.createCell(j++);
					}
					if (null != staff.getEmpName() && !"".equals(staff.getEmpName())) {
						row.createCell(j++).setCellValue(staff.getEmpName());
					} else {
						row.createCell(j++);
					}
					if (null != staff.getSex() && !"".equals(staff.getSex())) {
						row.createCell(j++).setCellValue(staff.getSex());
					} else {
						row.createCell(j++);
					}
					if (null != staff.getAge() && !"".equals(staff.getAge())) {
						row.createCell(j++).setCellValue(staff.getAge());
					} else {
						row.createCell(j++);
					}
					if (null != staff.getDaptName() && !"".equals(staff.getDaptName())) {
						row.createCell(j++).setCellValue(staff.getDaptName());
					} else {
						row.createCell(j++);
					}
					if (null != staff.getEmpDegreeName() && !"".equals(staff.getEmpDegreeName())) {
						row.createCell(j++).setCellValue(staff.getEmpDegreeName());
					} else {
						row.createCell(j++);
					}

				}
			}
			// 告诉浏览器用什么软件可以打开此文件
			response.setHeader("content-Type", "application/vnd.ms-excel");
			// 下载文件的默认名称
			response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "utf-8"));
			hssfWorkbook.write(response.getOutputStream());
		}catch (Exception e){
			e.printStackTrace();
		}
	}
}




