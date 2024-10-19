package com.dao;

import com.entity.DiscussfuwuxiangmuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussfuwuxiangmuVO;
import com.entity.view.DiscussfuwuxiangmuView;


/**
 * 服务项目评论表
 * 
 * @author 
 * @email 
 * @date 2022-04-18 19:23:55
 */
public interface DiscussfuwuxiangmuDao extends BaseMapper<DiscussfuwuxiangmuEntity> {
	
	List<DiscussfuwuxiangmuVO> selectListVO(@Param("ew") Wrapper<DiscussfuwuxiangmuEntity> wrapper);
	
	DiscussfuwuxiangmuVO selectVO(@Param("ew") Wrapper<DiscussfuwuxiangmuEntity> wrapper);
	
	List<DiscussfuwuxiangmuView> selectListView(@Param("ew") Wrapper<DiscussfuwuxiangmuEntity> wrapper);

	List<DiscussfuwuxiangmuView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussfuwuxiangmuEntity> wrapper);
	
	DiscussfuwuxiangmuView selectView(@Param("ew") Wrapper<DiscussfuwuxiangmuEntity> wrapper);
	

}
