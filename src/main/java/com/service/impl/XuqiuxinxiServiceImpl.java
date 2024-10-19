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


import com.dao.XuqiuxinxiDao;
import com.entity.XuqiuxinxiEntity;
import com.service.XuqiuxinxiService;
import com.entity.vo.XuqiuxinxiVO;
import com.entity.view.XuqiuxinxiView;

@Service("xuqiuxinxiService")
public class XuqiuxinxiServiceImpl extends ServiceImpl<XuqiuxinxiDao, XuqiuxinxiEntity> implements XuqiuxinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<XuqiuxinxiEntity> page = this.selectPage(
                new Query<XuqiuxinxiEntity>(params).getPage(),
                new EntityWrapper<XuqiuxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<XuqiuxinxiEntity> wrapper) {
		  Page<XuqiuxinxiView> page =new Query<XuqiuxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<XuqiuxinxiVO> selectListVO(Wrapper<XuqiuxinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public XuqiuxinxiVO selectVO(Wrapper<XuqiuxinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<XuqiuxinxiView> selectListView(Wrapper<XuqiuxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public XuqiuxinxiView selectView(Wrapper<XuqiuxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
