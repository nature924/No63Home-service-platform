package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.ZixunguyuanEntity;
import com.entity.view.ZixunguyuanView;

import com.service.ZixunguyuanService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 咨询雇员
 * 后端接口
 * @author 
 * @email 
 * @date 2022-04-18 19:23:55
 */
@RestController
@RequestMapping("/zixunguyuan")
public class ZixunguyuanController {
    @Autowired
    private ZixunguyuanService zixunguyuanService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ZixunguyuanEntity zixunguyuan,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("guyuan")) {
			zixunguyuan.setGuyuanzhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("guzhu")) {
			zixunguyuan.setZhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ZixunguyuanEntity> ew = new EntityWrapper<ZixunguyuanEntity>();
		PageUtils page = zixunguyuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zixunguyuan), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ZixunguyuanEntity zixunguyuan, 
		HttpServletRequest request){
        EntityWrapper<ZixunguyuanEntity> ew = new EntityWrapper<ZixunguyuanEntity>();
		PageUtils page = zixunguyuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zixunguyuan), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ZixunguyuanEntity zixunguyuan){
       	EntityWrapper<ZixunguyuanEntity> ew = new EntityWrapper<ZixunguyuanEntity>();
      	ew.allEq(MPUtil.allEQMapPre( zixunguyuan, "zixunguyuan")); 
        return R.ok().put("data", zixunguyuanService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ZixunguyuanEntity zixunguyuan){
        EntityWrapper< ZixunguyuanEntity> ew = new EntityWrapper< ZixunguyuanEntity>();
 		ew.allEq(MPUtil.allEQMapPre( zixunguyuan, "zixunguyuan")); 
		ZixunguyuanView zixunguyuanView =  zixunguyuanService.selectView(ew);
		return R.ok("查询咨询雇员成功").put("data", zixunguyuanView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ZixunguyuanEntity zixunguyuan = zixunguyuanService.selectById(id);
        return R.ok().put("data", zixunguyuan);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ZixunguyuanEntity zixunguyuan = zixunguyuanService.selectById(id);
        return R.ok().put("data", zixunguyuan);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ZixunguyuanEntity zixunguyuan, HttpServletRequest request){
    	zixunguyuan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zixunguyuan);
        zixunguyuanService.insert(zixunguyuan);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ZixunguyuanEntity zixunguyuan, HttpServletRequest request){
    	zixunguyuan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zixunguyuan);
        zixunguyuanService.insert(zixunguyuan);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody ZixunguyuanEntity zixunguyuan, HttpServletRequest request){
        //ValidatorUtils.validateEntity(zixunguyuan);
        zixunguyuanService.updateById(zixunguyuan);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        zixunguyuanService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<ZixunguyuanEntity> wrapper = new EntityWrapper<ZixunguyuanEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("guyuan")) {
			wrapper.eq("guyuanzhanghao", (String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("guzhu")) {
			wrapper.eq("zhanghao", (String)request.getSession().getAttribute("username"));
		}

		int count = zixunguyuanService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	







}
