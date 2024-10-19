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


import com.dao.DiscussfuwuxiangmuDao;
import com.entity.DiscussfuwuxiangmuEntity;
import com.service.DiscussfuwuxiangmuService;
import com.entity.vo.DiscussfuwuxiangmuVO;
import com.entity.view.DiscussfuwuxiangmuView;

@Service("discussfuwuxiangmuService")
public class DiscussfuwuxiangmuServiceImpl extends ServiceImpl<DiscussfuwuxiangmuDao, DiscussfuwuxiangmuEntity> implements DiscussfuwuxiangmuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussfuwuxiangmuEntity> page = this.selectPage(
                new Query<DiscussfuwuxiangmuEntity>(params).getPage(),
                new EntityWrapper<DiscussfuwuxiangmuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussfuwuxiangmuEntity> wrapper) {
		  Page<DiscussfuwuxiangmuView> page =new Query<DiscussfuwuxiangmuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscussfuwuxiangmuVO> selectListVO(Wrapper<DiscussfuwuxiangmuEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussfuwuxiangmuVO selectVO(Wrapper<DiscussfuwuxiangmuEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussfuwuxiangmuView> selectListView(Wrapper<DiscussfuwuxiangmuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussfuwuxiangmuView selectView(Wrapper<DiscussfuwuxiangmuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
