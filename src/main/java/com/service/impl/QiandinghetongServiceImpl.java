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


import com.dao.QiandinghetongDao;
import com.entity.QiandinghetongEntity;
import com.service.QiandinghetongService;
import com.entity.vo.QiandinghetongVO;
import com.entity.view.QiandinghetongView;

@Service("qiandinghetongService")
public class QiandinghetongServiceImpl extends ServiceImpl<QiandinghetongDao, QiandinghetongEntity> implements QiandinghetongService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<QiandinghetongEntity> page = this.selectPage(
                new Query<QiandinghetongEntity>(params).getPage(),
                new EntityWrapper<QiandinghetongEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<QiandinghetongEntity> wrapper) {
		  Page<QiandinghetongView> page =new Query<QiandinghetongView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<QiandinghetongVO> selectListVO(Wrapper<QiandinghetongEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public QiandinghetongVO selectVO(Wrapper<QiandinghetongEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<QiandinghetongView> selectListView(Wrapper<QiandinghetongEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public QiandinghetongView selectView(Wrapper<QiandinghetongEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
