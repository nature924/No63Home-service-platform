package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.GuzhuEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.GuzhuVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.GuzhuView;


/**
 * 雇主
 *
 * @author 
 * @email 
 * @date 2022-04-18 19:23:54
 */
public interface GuzhuService extends IService<GuzhuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<GuzhuVO> selectListVO(Wrapper<GuzhuEntity> wrapper);
   	
   	GuzhuVO selectVO(@Param("ew") Wrapper<GuzhuEntity> wrapper);
   	
   	List<GuzhuView> selectListView(Wrapper<GuzhuEntity> wrapper);
   	
   	GuzhuView selectView(@Param("ew") Wrapper<GuzhuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<GuzhuEntity> wrapper);
   	

}

