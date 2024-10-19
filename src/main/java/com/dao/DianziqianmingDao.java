package com.dao;

import com.entity.DianziqianmingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DianziqianmingVO;
import com.entity.view.DianziqianmingView;


/**
 * 电子签名
 * 
 * @author 
 * @email 
 * @date 2022-04-18 19:23:55
 */
public interface DianziqianmingDao extends BaseMapper<DianziqianmingEntity> {
	
	List<DianziqianmingVO> selectListVO(@Param("ew") Wrapper<DianziqianmingEntity> wrapper);
	
	DianziqianmingVO selectVO(@Param("ew") Wrapper<DianziqianmingEntity> wrapper);
	
	List<DianziqianmingView> selectListView(@Param("ew") Wrapper<DianziqianmingEntity> wrapper);

	List<DianziqianmingView> selectListView(Pagination page,@Param("ew") Wrapper<DianziqianmingEntity> wrapper);
	
	DianziqianmingView selectView(@Param("ew") Wrapper<DianziqianmingEntity> wrapper);
	

}
