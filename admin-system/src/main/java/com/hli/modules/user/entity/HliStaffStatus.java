package com.hli.modules.user.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import java.util.Date;
import lombok.Data;

/**
 * 员工状态返回值
 */
@Data
public class HliStaffStatus {

    /**
     * 经销商名称
     */
    @Excel(name = "员工序号", width = 30)
    private int id;

    /**
     * 智慧车主盒子编号
     */
    @Excel(name = "姓名",width = 30)
    private String empName;

    /**
     * 盒子状态 1:启用
     */
    @Excel(name = "性别", width = 30)
    private String sex;



    /**
     * 位置是否更新
     */
    @Excel(name = "年龄", width = 30)
    private int age;
    /**
     * 真实姓名
     */
    @Excel(name = "部门", width = 30)
    private String daptName;

    /**
     * 车牌号
     */
    @Excel(name = "学历", width = 30)
    private String empDegreeName;




}
