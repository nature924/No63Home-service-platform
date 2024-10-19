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


import com.dao.FuwuxiangmuDao;
import com.entity.FuwuxiangmuEntity;
import com.service.FuwuxiangmuService;
import com.entity.vo.FuwuxiangmuVO;
import com.entity.view.FuwuxiangmuView;

@Service("fuwuxiangmuService")
public class FuwuxiangmuServiceImpl extends ServiceImpl<FuwuxiangmuDao, FuwuxiangmuEntity> implements FuwuxiangmuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<FuwuxiangmuEntity> page = this.selectPage(
                new Query<FuwuxiangmuEntity>(params).getPage(),
                new EntityWrapper<FuwuxiangmuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<FuwuxiangmuEntity> wrapper) {
		  Page<FuwuxiangmuView> page =new Query<FuwuxiangmuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<FuwuxiangmuVO> selectListVO(Wrapper<FuwuxiangmuEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public FuwuxiangmuVO selectVO(Wrapper<FuwuxiangmuEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<FuwuxiangmuView> selectListView(Wrapper<FuwuxiangmuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public FuwuxiangmuView selectView(Wrapper<FuwuxiangmuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
