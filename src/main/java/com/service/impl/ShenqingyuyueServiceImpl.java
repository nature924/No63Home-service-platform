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


import com.dao.ShenqingyuyueDao;
import com.entity.ShenqingyuyueEntity;
import com.service.ShenqingyuyueService;
import com.entity.vo.ShenqingyuyueVO;
import com.entity.view.ShenqingyuyueView;

@Service("shenqingyuyueService")
public class ShenqingyuyueServiceImpl extends ServiceImpl<ShenqingyuyueDao, ShenqingyuyueEntity> implements ShenqingyuyueService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShenqingyuyueEntity> page = this.selectPage(
                new Query<ShenqingyuyueEntity>(params).getPage(),
                new EntityWrapper<ShenqingyuyueEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ShenqingyuyueEntity> wrapper) {
		  Page<ShenqingyuyueView> page =new Query<ShenqingyuyueView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ShenqingyuyueVO> selectListVO(Wrapper<ShenqingyuyueEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ShenqingyuyueVO selectVO(Wrapper<ShenqingyuyueEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ShenqingyuyueView> selectListView(Wrapper<ShenqingyuyueEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ShenqingyuyueView selectView(Wrapper<ShenqingyuyueEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, Wrapper<ShenqingyuyueEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, Wrapper<ShenqingyuyueEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, Wrapper<ShenqingyuyueEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }

}
