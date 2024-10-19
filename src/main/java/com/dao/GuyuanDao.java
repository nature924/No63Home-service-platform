package com.dao;

import com.entity.GuyuanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.GuyuanVO;
import com.entity.view.GuyuanView;


/**
 * 雇员
 * 
 * @author 
 * @email 
 * @date 2022-04-18 19:23:55
 */
public interface GuyuanDao extends BaseMapper<GuyuanEntity> {
	
	List<GuyuanVO> selectListVO(@Param("ew") Wrapper<GuyuanEntity> wrapper);
	
	GuyuanVO selectVO(@Param("ew") Wrapper<GuyuanEntity> wrapper);
	
	List<GuyuanView> selectListView(@Param("ew") Wrapper<GuyuanEntity> wrapper);

	List<GuyuanView> selectListView(Pagination page,@Param("ew") Wrapper<GuyuanEntity> wrapper);
	
	GuyuanView selectView(@Param("ew") Wrapper<GuyuanEntity> wrapper);
	

}
