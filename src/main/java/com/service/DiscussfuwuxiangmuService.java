package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussfuwuxiangmuEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussfuwuxiangmuVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussfuwuxiangmuView;


/**
 * 服务项目评论表
 *
 * @author 
 * @email 
 * @date 2022-04-18 19:23:55
 */
public interface DiscussfuwuxiangmuService extends IService<DiscussfuwuxiangmuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussfuwuxiangmuVO> selectListVO(Wrapper<DiscussfuwuxiangmuEntity> wrapper);
   	
   	DiscussfuwuxiangmuVO selectVO(@Param("ew") Wrapper<DiscussfuwuxiangmuEntity> wrapper);
   	
   	List<DiscussfuwuxiangmuView> selectListView(Wrapper<DiscussfuwuxiangmuEntity> wrapper);
   	
   	DiscussfuwuxiangmuView selectView(@Param("ew") Wrapper<DiscussfuwuxiangmuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussfuwuxiangmuEntity> wrapper);
   	

}

