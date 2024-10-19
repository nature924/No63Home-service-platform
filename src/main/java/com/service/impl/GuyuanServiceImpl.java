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


import com.dao.GuyuanDao;
import com.entity.GuyuanEntity;
import com.service.GuyuanService;
import com.entity.vo.GuyuanVO;
import com.entity.view.GuyuanView;

@Service("guyuanService")
public class GuyuanServiceImpl extends ServiceImpl<GuyuanDao, GuyuanEntity> implements GuyuanService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<GuyuanEntity> page = this.selectPage(
                new Query<GuyuanEntity>(params).getPage(),
                new EntityWrapper<GuyuanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<GuyuanEntity> wrapper) {
		  Page<GuyuanView> page =new Query<GuyuanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<GuyuanVO> selectListVO(Wrapper<GuyuanEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public GuyuanVO selectVO(Wrapper<GuyuanEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<GuyuanView> selectListView(Wrapper<GuyuanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public GuyuanView selectView(Wrapper<GuyuanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
