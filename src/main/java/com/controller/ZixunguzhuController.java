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

import com.entity.ZixunguzhuEntity;
import com.entity.view.ZixunguzhuView;

import com.service.ZixunguzhuService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 咨询雇主
 * 后端接口
 * @author 
 * @email 
 * @date 2022-04-18 19:23:55
 */
@RestController
@RequestMapping("/zixunguzhu")
public class ZixunguzhuController {
    @Autowired
    private ZixunguzhuService zixunguzhuService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ZixunguzhuEntity zixunguzhu,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("guyuan")) {
			zixunguzhu.setGuyuanzhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("guzhu")) {
			zixunguzhu.setZhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ZixunguzhuEntity> ew = new EntityWrapper<ZixunguzhuEntity>();
		PageUtils page = zixunguzhuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zixunguzhu), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ZixunguzhuEntity zixunguzhu, 
		HttpServletRequest request){
        EntityWrapper<ZixunguzhuEntity> ew = new EntityWrapper<ZixunguzhuEntity>();
		PageUtils page = zixunguzhuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zixunguzhu), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ZixunguzhuEntity zixunguzhu){
       	EntityWrapper<ZixunguzhuEntity> ew = new EntityWrapper<ZixunguzhuEntity>();
      	ew.allEq(MPUtil.allEQMapPre( zixunguzhu, "zixunguzhu")); 
        return R.ok().put("data", zixunguzhuService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ZixunguzhuEntity zixunguzhu){
        EntityWrapper< ZixunguzhuEntity> ew = new EntityWrapper< ZixunguzhuEntity>();
 		ew.allEq(MPUtil.allEQMapPre( zixunguzhu, "zixunguzhu")); 
		ZixunguzhuView zixunguzhuView =  zixunguzhuService.selectView(ew);
		return R.ok("查询咨询雇主成功").put("data", zixunguzhuView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ZixunguzhuEntity zixunguzhu = zixunguzhuService.selectById(id);
        return R.ok().put("data", zixunguzhu);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ZixunguzhuEntity zixunguzhu = zixunguzhuService.selectById(id);
        return R.ok().put("data", zixunguzhu);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ZixunguzhuEntity zixunguzhu, HttpServletRequest request){
    	zixunguzhu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zixunguzhu);
        zixunguzhuService.insert(zixunguzhu);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ZixunguzhuEntity zixunguzhu, HttpServletRequest request){
    	zixunguzhu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zixunguzhu);
        zixunguzhuService.insert(zixunguzhu);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody ZixunguzhuEntity zixunguzhu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(zixunguzhu);
        zixunguzhuService.updateById(zixunguzhu);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        zixunguzhuService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<ZixunguzhuEntity> wrapper = new EntityWrapper<ZixunguzhuEntity>();
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

		int count = zixunguzhuService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	







}
