package com.dao;

import com.entity.ZixunguyuanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ZixunguyuanVO;
import com.entity.view.ZixunguyuanView;


/**
 * 咨询雇员
 * 
 * @author 
 * @email 
 * @date 2022-04-18 19:23:55
 */
public interface ZixunguyuanDao extends BaseMapper<ZixunguyuanEntity> {
	
	List<ZixunguyuanVO> selectListVO(@Param("ew") Wrapper<ZixunguyuanEntity> wrapper);
	
	ZixunguyuanVO selectVO(@Param("ew") Wrapper<ZixunguyuanEntity> wrapper);
	
	List<ZixunguyuanView> selectListView(@Param("ew") Wrapper<ZixunguyuanEntity> wrapper);

	List<ZixunguyuanView> selectListView(Pagination page,@Param("ew") Wrapper<ZixunguyuanEntity> wrapper);
	
	ZixunguyuanView selectView(@Param("ew") Wrapper<ZixunguyuanEntity> wrapper);
	

}
