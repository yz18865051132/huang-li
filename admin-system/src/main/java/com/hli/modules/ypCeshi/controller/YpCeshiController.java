package com.hli.modules.ypCeshi.controller;

import com.hli.modules.util.IdUtil;
import com.hli.modules.util.Result;
import java.util.Date;
import java.util.List;
import java.util.Arrays;
import cn.hutool.core.util.StrUtil;
import com.hli.modules.ypCeshi.entity.YpCeshi;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hli.modules.ypCeshi.service.IYpCeshiService;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;


/**
* @Description: 测试版 前端控制器
* @author 于遵
* @since 2023-12-04
*/
@RestController
@RequestMapping("/ypCeshi")
public class YpCeshiController{

@Autowired
private IYpCeshiService ypCeshiService;

    /**
    * 列表查询接口
    * @param pageNo
    * @param pageSize
    * @return
    */
    @GetMapping(value = "/list")
    public Result<?> queryList(
        @RequestParam(name="tableId",required = false) String tableId,
        @RequestParam(name="columnName",required = false) String columnName,
        @RequestParam(name="columnComment",required = false) String columnComment,
        @RequestParam(name="columnType",required = false) String columnType,
        @RequestParam(name="javaType",required = false) String javaType,
        @RequestParam(name="javaField",required = false) String javaField,
        @RequestParam(name="isPk",required = false) String isPk,
        @RequestParam(name = "sort", required = false, defaultValue = "sort") String sort,
        @RequestParam(name = "order", required = false, defaultValue = "DESC") String order,
        @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
        @RequestParam(name="pageSize", defaultValue="10") Integer pageSize){
        QueryWrapper<YpCeshi> queryWrapper = Wrappers.query();
        queryWrapper.lambda()
            .eq(StrUtil.isNotEmpty(tableId),YpCeshi::getTableId, tableId)
            .ne(StrUtil.isNotEmpty(columnName),YpCeshi::getColumnName, columnName)
            .gt(StrUtil.isNotEmpty(columnComment),YpCeshi::getColumnComment, columnComment)
            .ge(StrUtil.isNotEmpty(columnType),YpCeshi::getColumnType, columnType)
            .lt(StrUtil.isNotEmpty(javaType),YpCeshi::getJavaType, javaType)
            .le(StrUtil.isNotEmpty(javaField),YpCeshi::getJavaField, javaField)
            .like(StrUtil.isNotEmpty(isPk),YpCeshi::getIsPk, isPk)
        ;
        queryWrapper.orderBy(true, StrUtil.equalsIgnoreCase("ASC", order), IdUtil.humpToLine(sort));
        Page<YpCeshi> page = new Page<>(pageNo, pageSize);
        IPage<YpCeshi> pageList = ypCeshiService.page(page, queryWrapper);
        return Result.ok(pageList);
    }

    /**
    * 数据增加接口
    * @param
    * @return
    */
    @PostMapping(value = "/add")
    public Result<?> create(@RequestBody YpCeshi ypCeshi){
        ypCeshi.setId(IdUtil.UUID());
        ypCeshi.setCreateTime(new Date());
        ypCeshiService.save(ypCeshi);
        return Result.ok("添加成功");
    }

    /**
    * 数据编辑接口
    * @param ypCeshi
    * @return
    */
    @PostMapping(value = "/update")
    public Result<?> update(@RequestBody YpCeshi ypCeshi){
        ypCeshi.setUpdateTime(new Date());
        ypCeshiService.updateById(ypCeshi);
        return Result.ok("编辑成功");
    }

    /**
    * 通过id查询详情
    * @return
    */
    @GetMapping(value = "/queryById")
    public Result<?> queryById(@RequestParam String id){
        return Result.ok(ypCeshiService.getById(id));
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
        ypCeshiService.removeById(id);
        return Result.ok("删除成功");
     }

    /**
    * 批量删除
    * @return
    */
    @DeleteMapping(value = "/deletes")
    public Result<?> deletes(@RequestParam String ids){
        List<String> list = Arrays.asList(ids.split(","));
        /**
        * 如果有删除字段，可以用此方法
        *UpdateWrapper<YpCeshi> updateWrapper = Wrappers.update();
        *    updateWrapper.lambda()
        *    .in(YpCeshi::getId, id)
        *    .set(YpCeshi::getIsDel, "1");
        *ypCeshiService.update(updateWrapper);
        */
        ypCeshiService.removeBatchByIds(list);
        return Result.ok("删除成功");
    }
}
