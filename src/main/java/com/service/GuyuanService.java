package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.GuyuanEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.GuyuanVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.GuyuanView;


/**
 * 雇员
 *
 * @author 
 * @email 
 * @date 2022-04-18 19:23:55
 */
public interface GuyuanService extends IService<GuyuanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<GuyuanVO> selectListVO(Wrapper<GuyuanEntity> wrapper);
   	
   	GuyuanVO selectVO(@Param("ew") Wrapper<GuyuanEntity> wrapper);
   	
   	List<GuyuanView> selectListView(Wrapper<GuyuanEntity> wrapper);
   	
   	GuyuanView selectView(@Param("ew") Wrapper<GuyuanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<GuyuanEntity> wrapper);
   	

}

