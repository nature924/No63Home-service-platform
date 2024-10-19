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


import com.dao.GuzhuDao;
import com.entity.GuzhuEntity;
import com.service.GuzhuService;
import com.entity.vo.GuzhuVO;
import com.entity.view.GuzhuView;

@Service("guzhuService")
public class GuzhuServiceImpl extends ServiceImpl<GuzhuDao, GuzhuEntity> implements GuzhuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<GuzhuEntity> page = this.selectPage(
                new Query<GuzhuEntity>(params).getPage(),
                new EntityWrapper<GuzhuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<GuzhuEntity> wrapper) {
		  Page<GuzhuView> page =new Query<GuzhuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<GuzhuVO> selectListVO(Wrapper<GuzhuEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public GuzhuVO selectVO(Wrapper<GuzhuEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<GuzhuView> selectListView(Wrapper<GuzhuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public GuzhuView selectView(Wrapper<GuzhuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
