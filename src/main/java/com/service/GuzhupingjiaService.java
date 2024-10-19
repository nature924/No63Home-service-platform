package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.GuzhupingjiaEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.GuzhupingjiaVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.GuzhupingjiaView;


/**
 * 雇主评价
 *
 * @author 
 * @email 
 * @date 2022-04-18 19:23:55
 */
public interface GuzhupingjiaService extends IService<GuzhupingjiaEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<GuzhupingjiaVO> selectListVO(Wrapper<GuzhupingjiaEntity> wrapper);
   	
   	GuzhupingjiaVO selectVO(@Param("ew") Wrapper<GuzhupingjiaEntity> wrapper);
   	
   	List<GuzhupingjiaView> selectListView(Wrapper<GuzhupingjiaEntity> wrapper);
   	
   	GuzhupingjiaView selectView(@Param("ew") Wrapper<GuzhupingjiaEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<GuzhupingjiaEntity> wrapper);
   	

}

