package com.dao;

import com.entity.FuwuxiangmuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.FuwuxiangmuVO;
import com.entity.view.FuwuxiangmuView;


/**
 * 服务项目
 * 
 * @author 
 * @email 
 * @date 2022-04-18 19:23:55
 */
public interface FuwuxiangmuDao extends BaseMapper<FuwuxiangmuEntity> {
	
	List<FuwuxiangmuVO> selectListVO(@Param("ew") Wrapper<FuwuxiangmuEntity> wrapper);
	
	FuwuxiangmuVO selectVO(@Param("ew") Wrapper<FuwuxiangmuEntity> wrapper);
	
	List<FuwuxiangmuView> selectListView(@Param("ew") Wrapper<FuwuxiangmuEntity> wrapper);

	List<FuwuxiangmuView> selectListView(Pagination page,@Param("ew") Wrapper<FuwuxiangmuEntity> wrapper);
	
	FuwuxiangmuView selectView(@Param("ew") Wrapper<FuwuxiangmuEntity> wrapper);
	

}
