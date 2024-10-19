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


import com.dao.FuwuyuyueDao;
import com.entity.FuwuyuyueEntity;
import com.service.FuwuyuyueService;
import com.entity.vo.FuwuyuyueVO;
import com.entity.view.FuwuyuyueView;

@Service("fuwuyuyueService")
public class FuwuyuyueServiceImpl extends ServiceImpl<FuwuyuyueDao, FuwuyuyueEntity> implements FuwuyuyueService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<FuwuyuyueEntity> page = this.selectPage(
                new Query<FuwuyuyueEntity>(params).getPage(),
                new EntityWrapper<FuwuyuyueEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<FuwuyuyueEntity> wrapper) {
		  Page<FuwuyuyueView> page =new Query<FuwuyuyueView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<FuwuyuyueVO> selectListVO(Wrapper<FuwuyuyueEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public FuwuyuyueVO selectVO(Wrapper<FuwuyuyueEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<FuwuyuyueView> selectListView(Wrapper<FuwuyuyueEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public FuwuyuyueView selectView(Wrapper<FuwuyuyueEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, Wrapper<FuwuyuyueEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, Wrapper<FuwuyuyueEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, Wrapper<FuwuyuyueEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }

}
