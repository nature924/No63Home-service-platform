package com.dao;

import com.entity.GuzhuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.GuzhuVO;
import com.entity.view.GuzhuView;


/**
 * 雇主
 * 
 * @author 
 * @email 
 * @date 2022-04-18 19:23:54
 */
public interface GuzhuDao extends BaseMapper<GuzhuEntity> {
	
	List<GuzhuVO> selectListVO(@Param("ew") Wrapper<GuzhuEntity> wrapper);
	
	GuzhuVO selectVO(@Param("ew") Wrapper<GuzhuEntity> wrapper);
	
	List<GuzhuView> selectListView(@Param("ew") Wrapper<GuzhuEntity> wrapper);

	List<GuzhuView> selectListView(Pagination page,@Param("ew") Wrapper<GuzhuEntity> wrapper);
	
	GuzhuView selectView(@Param("ew") Wrapper<GuzhuEntity> wrapper);
	

}
