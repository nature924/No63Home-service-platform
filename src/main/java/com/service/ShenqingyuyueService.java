package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ShenqingyuyueEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ShenqingyuyueVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ShenqingyuyueView;


/**
 * 申请预约
 *
 * @author 
 * @email 
 * @date 2022-04-18 19:23:55
 */
public interface ShenqingyuyueService extends IService<ShenqingyuyueEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ShenqingyuyueVO> selectListVO(Wrapper<ShenqingyuyueEntity> wrapper);
   	
   	ShenqingyuyueVO selectVO(@Param("ew") Wrapper<ShenqingyuyueEntity> wrapper);
   	
   	List<ShenqingyuyueView> selectListView(Wrapper<ShenqingyuyueEntity> wrapper);
   	
   	ShenqingyuyueView selectView(@Param("ew") Wrapper<ShenqingyuyueEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ShenqingyuyueEntity> wrapper);
   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<ShenqingyuyueEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<ShenqingyuyueEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<ShenqingyuyueEntity> wrapper);
}

