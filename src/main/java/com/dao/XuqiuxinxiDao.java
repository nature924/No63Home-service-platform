package com.dao;

import com.entity.XuqiuxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.XuqiuxinxiVO;
import com.entity.view.XuqiuxinxiView;


/**
 * 需求信息
 * 
 * @author 
 * @email 
 * @date 2022-04-18 19:23:55
 */
public interface XuqiuxinxiDao extends BaseMapper<XuqiuxinxiEntity> {
	
	List<XuqiuxinxiVO> selectListVO(@Param("ew") Wrapper<XuqiuxinxiEntity> wrapper);
	
	XuqiuxinxiVO selectVO(@Param("ew") Wrapper<XuqiuxinxiEntity> wrapper);
	
	List<XuqiuxinxiView> selectListView(@Param("ew") Wrapper<XuqiuxinxiEntity> wrapper);

	List<XuqiuxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<XuqiuxinxiEntity> wrapper);
	
	XuqiuxinxiView selectView(@Param("ew") Wrapper<XuqiuxinxiEntity> wrapper);
	

}
