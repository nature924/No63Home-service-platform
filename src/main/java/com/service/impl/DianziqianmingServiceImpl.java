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


import com.dao.DianziqianmingDao;
import com.entity.DianziqianmingEntity;
import com.service.DianziqianmingService;
import com.entity.vo.DianziqianmingVO;
import com.entity.view.DianziqianmingView;

@Service("dianziqianmingService")
public class DianziqianmingServiceImpl extends ServiceImpl<DianziqianmingDao, DianziqianmingEntity> implements DianziqianmingService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DianziqianmingEntity> page = this.selectPage(
                new Query<DianziqianmingEntity>(params).getPage(),
                new EntityWrapper<DianziqianmingEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DianziqianmingEntity> wrapper) {
		  Page<DianziqianmingView> page =new Query<DianziqianmingView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DianziqianmingVO> selectListVO(Wrapper<DianziqianmingEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DianziqianmingVO selectVO(Wrapper<DianziqianmingEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DianziqianmingView> selectListView(Wrapper<DianziqianmingEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DianziqianmingView selectView(Wrapper<DianziqianmingEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
