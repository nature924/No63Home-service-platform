package com.dao;

import com.entity.ZiliaorenzhengEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ZiliaorenzhengVO;
import com.entity.view.ZiliaorenzhengView;


/**
 * 资料认证
 * 
 * @author 
 * @email 
 * @date 2022-04-18 19:23:55
 */
public interface ZiliaorenzhengDao extends BaseMapper<ZiliaorenzhengEntity> {
	
	List<ZiliaorenzhengVO> selectListVO(@Param("ew") Wrapper<ZiliaorenzhengEntity> wrapper);
	
	ZiliaorenzhengVO selectVO(@Param("ew") Wrapper<ZiliaorenzhengEntity> wrapper);
	
	List<ZiliaorenzhengView> selectListView(@Param("ew") Wrapper<ZiliaorenzhengEntity> wrapper);

	List<ZiliaorenzhengView> selectListView(Pagination page,@Param("ew") Wrapper<ZiliaorenzhengEntity> wrapper);
	
	ZiliaorenzhengView selectView(@Param("ew") Wrapper<ZiliaorenzhengEntity> wrapper);
	

}
