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


import com.dao.ZixunguzhuDao;
import com.entity.ZixunguzhuEntity;
import com.service.ZixunguzhuService;
import com.entity.vo.ZixunguzhuVO;
import com.entity.view.ZixunguzhuView;

@Service("zixunguzhuService")
public class ZixunguzhuServiceImpl extends ServiceImpl<ZixunguzhuDao, ZixunguzhuEntity> implements ZixunguzhuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZixunguzhuEntity> page = this.selectPage(
                new Query<ZixunguzhuEntity>(params).getPage(),
                new EntityWrapper<ZixunguzhuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZixunguzhuEntity> wrapper) {
		  Page<ZixunguzhuView> page =new Query<ZixunguzhuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ZixunguzhuVO> selectListVO(Wrapper<ZixunguzhuEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ZixunguzhuVO selectVO(Wrapper<ZixunguzhuEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ZixunguzhuView> selectListView(Wrapper<ZixunguzhuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZixunguzhuView selectView(Wrapper<ZixunguzhuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
