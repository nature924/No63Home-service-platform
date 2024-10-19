package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.XuqiuxinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.XuqiuxinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.XuqiuxinxiView;


/**
 * 需求信息
 *
 * @author 
 * @email 
 * @date 2022-04-18 19:23:55
 */
public interface XuqiuxinxiService extends IService<XuqiuxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<XuqiuxinxiVO> selectListVO(Wrapper<XuqiuxinxiEntity> wrapper);
   	
   	XuqiuxinxiVO selectVO(@Param("ew") Wrapper<XuqiuxinxiEntity> wrapper);
   	
   	List<XuqiuxinxiView> selectListView(Wrapper<XuqiuxinxiEntity> wrapper);
   	
   	XuqiuxinxiView selectView(@Param("ew") Wrapper<XuqiuxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<XuqiuxinxiEntity> wrapper);
   	

}

