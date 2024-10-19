package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.FuwuyuyueEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.FuwuyuyueVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.FuwuyuyueView;


/**
 * 服务预约
 *
 * @author 
 * @email 
 * @date 2022-04-18 19:23:55
 */
public interface FuwuyuyueService extends IService<FuwuyuyueEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<FuwuyuyueVO> selectListVO(Wrapper<FuwuyuyueEntity> wrapper);
   	
   	FuwuyuyueVO selectVO(@Param("ew") Wrapper<FuwuyuyueEntity> wrapper);
   	
   	List<FuwuyuyueView> selectListView(Wrapper<FuwuyuyueEntity> wrapper);
   	
   	FuwuyuyueView selectView(@Param("ew") Wrapper<FuwuyuyueEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<FuwuyuyueEntity> wrapper);
   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<FuwuyuyueEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<FuwuyuyueEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<FuwuyuyueEntity> wrapper);
}

