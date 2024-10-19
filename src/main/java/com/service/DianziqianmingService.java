package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DianziqianmingEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DianziqianmingVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DianziqianmingView;


/**
 * 电子签名
 *
 * @author 
 * @email 
 * @date 2022-04-18 19:23:55
 */
public interface DianziqianmingService extends IService<DianziqianmingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DianziqianmingVO> selectListVO(Wrapper<DianziqianmingEntity> wrapper);
   	
   	DianziqianmingVO selectVO(@Param("ew") Wrapper<DianziqianmingEntity> wrapper);
   	
   	List<DianziqianmingView> selectListView(Wrapper<DianziqianmingEntity> wrapper);
   	
   	DianziqianmingView selectView(@Param("ew") Wrapper<DianziqianmingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DianziqianmingEntity> wrapper);
   	

}

