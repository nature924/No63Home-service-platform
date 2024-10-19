package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.GuzhupingjiaDao;
import com.entity.GuzhupingjiaEntity;
import com.service.GuzhupingjiaService;
import com.entity.vo.GuzhupingjiaVO;
import com.entity.view.GuzhupingjiaView;

@Service("guzhupingjiaService")
public class GuzhupingjiaServiceImpl extends ServiceImpl<GuzhupingjiaDao, GuzhupingjiaEntity> implements GuzhupingjiaService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<GuzhupingjiaEntity> page = this.selectPage(
                new Query<GuzhupingjiaEntity>(params).getPage(),
                new EntityWrapper<GuzhupingjiaEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<GuzhupingjiaEntity> wrapper) {
		  Page<GuzhupingjiaView> page =new Query<GuzhupingjiaView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<GuzhupingjiaVO> selectListVO(Wrapper<GuzhupingjiaEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public GuzhupingjiaVO selectVO(Wrapper<GuzhupingjiaEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<GuzhupingjiaView> selectListView(Wrapper<GuzhupingjiaEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public GuzhupingjiaView selectView(Wrapper<GuzhupingjiaEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
