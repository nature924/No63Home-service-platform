package com.dao;

import com.entity.GuzhupingjiaEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.GuzhupingjiaVO;
import com.entity.view.GuzhupingjiaView;


/**
 * 雇主评价
 * 
 * @author 
 * @email 
 * @date 2022-04-18 19:23:55
 */
public interface GuzhupingjiaDao extends BaseMapper<GuzhupingjiaEntity> {
	
	List<GuzhupingjiaVO> selectListVO(@Param("ew") Wrapper<GuzhupingjiaEntity> wrapper);
	
	GuzhupingjiaVO selectVO(@Param("ew") Wrapper<GuzhupingjiaEntity> wrapper);
	
	List<GuzhupingjiaView> selectListView(@Param("ew") Wrapper<GuzhupingjiaEntity> wrapper);

	List<GuzhupingjiaView> selectListView(Pagination page,@Param("ew") Wrapper<GuzhupingjiaEntity> wrapper);
	
	GuzhupingjiaView selectView(@Param("ew") Wrapper<GuzhupingjiaEntity> wrapper);
	

}
