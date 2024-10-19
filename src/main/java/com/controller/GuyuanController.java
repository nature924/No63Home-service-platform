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

import com.entity.GuyuanEntity;
import com.entity.view.GuyuanView;

import com.service.GuyuanService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 雇员
 * 后端接口
 * @author 
 * @email 
 * @date 2022-04-18 19:23:55
 */
@RestController
@RequestMapping("/guyuan")
public class GuyuanController {
    @Autowired
    private GuyuanService guyuanService;


    
	@Autowired
	private TokenService tokenService;
	
	/**
	 * 登录
	 */
	@IgnoreAuth
	@RequestMapping(value = "/login")
	public R login(String username, String password, String captcha, HttpServletRequest request) {
		GuyuanEntity user = guyuanService.selectOne(new EntityWrapper<GuyuanEntity>().eq("guyuanzhanghao", username));
		if(user==null || !user.getMima().equals(password)) {
			return R.error("账号或密码不正确");
		}
		
		String token = tokenService.generateToken(user.getId(), username,"guyuan",  "雇员" );
		return R.ok().put("token", token);
	}
	
	/**
     * 注册
     */
	@IgnoreAuth
    @RequestMapping("/register")
    public R register(@RequestBody GuyuanEntity guyuan){
    	//ValidatorUtils.validateEntity(guyuan);
    	GuyuanEntity user = guyuanService.selectOne(new EntityWrapper<GuyuanEntity>().eq("guyuanzhanghao", guyuan.getGuyuanzhanghao()));
		if(user!=null) {
			return R.error("注册用户已存在");
		}
		Long uId = new Date().getTime();
		guyuan.setId(uId);
        guyuanService.insert(guyuan);
        return R.ok();
    }

	
	/**
	 * 退出
	 */
	@RequestMapping("/logout")
	public R logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return R.ok("退出成功");
	}
	
	/**
     * 获取用户的session用户信息
     */
    @RequestMapping("/session")
    public R getCurrUser(HttpServletRequest request){
    	Long id = (Long)request.getSession().getAttribute("userId");
        GuyuanEntity user = guyuanService.selectById(id);
        return R.ok().put("data", user);
    }
    
    /**
     * 密码重置
     */
    @IgnoreAuth
	@RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request){
    	GuyuanEntity user = guyuanService.selectOne(new EntityWrapper<GuyuanEntity>().eq("guyuanzhanghao", username));
    	if(user==null) {
    		return R.error("账号不存在");
    	}
        user.setMima("123456");
        guyuanService.updateById(user);
        return R.ok("密码已重置为：123456");
    }


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,GuyuanEntity guyuan,
		HttpServletRequest request){
        EntityWrapper<GuyuanEntity> ew = new EntityWrapper<GuyuanEntity>();
		PageUtils page = guyuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, guyuan), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,GuyuanEntity guyuan, 
		HttpServletRequest request){
        EntityWrapper<GuyuanEntity> ew = new EntityWrapper<GuyuanEntity>();
		PageUtils page = guyuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, guyuan), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( GuyuanEntity guyuan){
       	EntityWrapper<GuyuanEntity> ew = new EntityWrapper<GuyuanEntity>();
      	ew.allEq(MPUtil.allEQMapPre( guyuan, "guyuan")); 
        return R.ok().put("data", guyuanService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(GuyuanEntity guyuan){
        EntityWrapper< GuyuanEntity> ew = new EntityWrapper< GuyuanEntity>();
 		ew.allEq(MPUtil.allEQMapPre( guyuan, "guyuan")); 
		GuyuanView guyuanView =  guyuanService.selectView(ew);
		return R.ok("查询雇员成功").put("data", guyuanView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        GuyuanEntity guyuan = guyuanService.selectById(id);
        return R.ok().put("data", guyuan);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        GuyuanEntity guyuan = guyuanService.selectById(id);
        return R.ok().put("data", guyuan);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody GuyuanEntity guyuan, HttpServletRequest request){
    	guyuan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(guyuan);
    	GuyuanEntity user = guyuanService.selectOne(new EntityWrapper<GuyuanEntity>().eq("guyuanzhanghao", guyuan.getGuyuanzhanghao()));
		if(user!=null) {
			return R.error("用户已存在");
		}
		guyuan.setId(new Date().getTime());
        guyuanService.insert(guyuan);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody GuyuanEntity guyuan, HttpServletRequest request){
    	guyuan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(guyuan);
    	GuyuanEntity user = guyuanService.selectOne(new EntityWrapper<GuyuanEntity>().eq("guyuanzhanghao", guyuan.getGuyuanzhanghao()));
		if(user!=null) {
			return R.error("用户已存在");
		}
		guyuan.setId(new Date().getTime());
        guyuanService.insert(guyuan);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody GuyuanEntity guyuan, HttpServletRequest request){
        //ValidatorUtils.validateEntity(guyuan);
        guyuanService.updateById(guyuan);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        guyuanService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<GuyuanEntity> wrapper = new EntityWrapper<GuyuanEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = guyuanService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	







}
