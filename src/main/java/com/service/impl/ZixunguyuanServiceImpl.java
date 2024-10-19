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


import com.dao.ZixunguyuanDao;
import com.entity.ZixunguyuanEntity;
import com.service.ZixunguyuanService;
import com.entity.vo.ZixunguyuanVO;
import com.entity.view.ZixunguyuanView;

@Service("zixunguyuanService")
public class ZixunguyuanServiceImpl extends ServiceImpl<ZixunguyuanDao, ZixunguyuanEntity> implements ZixunguyuanService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZixunguyuanEntity> page = this.selectPage(
                new Query<ZixunguyuanEntity>(params).getPage(),
                new EntityWrapper<ZixunguyuanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZixunguyuanEntity> wrapper) {
		  Page<ZixunguyuanView> page =new Query<ZixunguyuanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ZixunguyuanVO> selectListVO(Wrapper<ZixunguyuanEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ZixunguyuanVO selectVO(Wrapper<ZixunguyuanEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ZixunguyuanView> selectListView(Wrapper<ZixunguyuanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZixunguyuanView selectView(Wrapper<ZixunguyuanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
