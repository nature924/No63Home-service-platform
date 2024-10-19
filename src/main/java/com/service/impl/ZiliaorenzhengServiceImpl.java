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


import com.dao.ZiliaorenzhengDao;
import com.entity.ZiliaorenzhengEntity;
import com.service.ZiliaorenzhengService;
import com.entity.vo.ZiliaorenzhengVO;
import com.entity.view.ZiliaorenzhengView;

@Service("ziliaorenzhengService")
public class ZiliaorenzhengServiceImpl extends ServiceImpl<ZiliaorenzhengDao, ZiliaorenzhengEntity> implements ZiliaorenzhengService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZiliaorenzhengEntity> page = this.selectPage(
                new Query<ZiliaorenzhengEntity>(params).getPage(),
                new EntityWrapper<ZiliaorenzhengEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZiliaorenzhengEntity> wrapper) {
		  Page<ZiliaorenzhengView> page =new Query<ZiliaorenzhengView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ZiliaorenzhengVO> selectListVO(Wrapper<ZiliaorenzhengEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ZiliaorenzhengVO selectVO(Wrapper<ZiliaorenzhengEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ZiliaorenzhengView> selectListView(Wrapper<ZiliaorenzhengEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZiliaorenzhengView selectView(Wrapper<ZiliaorenzhengEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
