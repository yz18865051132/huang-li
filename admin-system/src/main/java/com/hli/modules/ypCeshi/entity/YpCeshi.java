package com.hli.modules.ypCeshi.entity;

import lombok.Data;
import java.util.Date;
import java.math.BigDecimal;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.baomidou.mybatisplus.annotation.TableName;

/**
* @Description: 测试版
* @Author:  于遵
* @Date:   2023-12-04
*/
@Data
@TableName("yp_ceshi")
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="YpCeshi对象", description="测试版")
public class YpCeshi {

    /** 编号 */
    @ApiModelProperty(value = "编号")
    private String id;

    /** 归属表编号 */
    @ApiModelProperty(value = "归属表编号")
    private String tableId;

    /** 列名称 */
    @ApiModelProperty(value = "列名称")
    private String columnName;

    /** 列描述 */
    @ApiModelProperty(value = "列描述")
    private String columnComment;

    /** 列类型 */
    @ApiModelProperty(value = "列类型")
    private String columnType;

    /** JAVA类型 */
    @ApiModelProperty(value = "JAVA类型")
    private String javaType;

    /** JAVA字段名 */
    @ApiModelProperty(value = "JAVA字段名")
    private String javaField;

    /** 是否主键（1是） */
    @ApiModelProperty(value = "是否主键（1是）")
    private String isPk;

    /** 是否必填（1是） */
    @ApiModelProperty(value = "是否必填（1是）")
    private String isRequired;

    /** 是否编辑字段（1是） */
    @ApiModelProperty(value = "是否编辑字段（1是）")
    private String isEdit;

    /** 是否列表字段（1是） */
    @ApiModelProperty(value = "是否列表字段（1是）")
    private String isList;

    /** 是否查询字段（1是） */
    @ApiModelProperty(value = "是否查询字段（1是）")
    private String isQuery;

    /** 查询方式（等于、不等于、大于、小于、范围） */
    @ApiModelProperty(value = "查询方式（等于、不等于、大于、小于、范围）")
    private String queryType;

    /** 显示类型（文本框、文本域、下拉框、复选框、单选框、日期控件） */
    @ApiModelProperty(value = "显示类型（文本框、文本域、下拉框、复选框、单选框、日期控件）")
    private String htmlType;

    /** 字典类型 */
    @ApiModelProperty(value = "字典类型")
    private String dictType;

    /** 排序 */
    @ApiModelProperty(value = "排序")
    private Long sort;

    /** 创建者 */
    @ApiModelProperty(value = "创建者")
    private String createBy;

    /** 创建时间 */
    @ApiModelProperty(value = "创建时间")
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /** 更新者 */
    @ApiModelProperty(value = "更新者")
    private String updateBy;

    /** 更新时间 */
    @ApiModelProperty(value = "更新时间")
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

}

