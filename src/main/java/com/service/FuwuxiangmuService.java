package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.FuwuxiangmuEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.FuwuxiangmuVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.FuwuxiangmuView;


/**
 * 服务项目
 *
 * @author 
 * @email 
 * @date 2022-04-18 19:23:55
 */
public interface FuwuxiangmuService extends IService<FuwuxiangmuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<FuwuxiangmuVO> selectListVO(Wrapper<FuwuxiangmuEntity> wrapper);
   	
   	FuwuxiangmuVO selectVO(@Param("ew") Wrapper<FuwuxiangmuEntity> wrapper);
   	
   	List<FuwuxiangmuView> selectListView(Wrapper<FuwuxiangmuEntity> wrapper);
   	
   	FuwuxiangmuView selectView(@Param("ew") Wrapper<FuwuxiangmuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<FuwuxiangmuEntity> wrapper);
   	

}

