package com.dao;

import com.entity.ZixunguzhuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ZixunguzhuVO;
import com.entity.view.ZixunguzhuView;


/**
 * 咨询雇主
 * 
 * @author 
 * @email 
 * @date 2022-04-18 19:23:55
 */
public interface ZixunguzhuDao extends BaseMapper<ZixunguzhuEntity> {
	
	List<ZixunguzhuVO> selectListVO(@Param("ew") Wrapper<ZixunguzhuEntity> wrapper);
	
	ZixunguzhuVO selectVO(@Param("ew") Wrapper<ZixunguzhuEntity> wrapper);
	
	List<ZixunguzhuView> selectListView(@Param("ew") Wrapper<ZixunguzhuEntity> wrapper);

	List<ZixunguzhuView> selectListView(Pagination page,@Param("ew") Wrapper<ZixunguzhuEntity> wrapper);
	
	ZixunguzhuView selectView(@Param("ew") Wrapper<ZixunguzhuEntity> wrapper);
	

}
