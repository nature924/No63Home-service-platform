package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ZiliaorenzhengEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ZiliaorenzhengVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ZiliaorenzhengView;


/**
 * 资料认证
 *
 * @author 
 * @email 
 * @date 2022-04-18 19:23:55
 */
public interface ZiliaorenzhengService extends IService<ZiliaorenzhengEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZiliaorenzhengVO> selectListVO(Wrapper<ZiliaorenzhengEntity> wrapper);
   	
   	ZiliaorenzhengVO selectVO(@Param("ew") Wrapper<ZiliaorenzhengEntity> wrapper);
   	
   	List<ZiliaorenzhengView> selectListView(Wrapper<ZiliaorenzhengEntity> wrapper);
   	
   	ZiliaorenzhengView selectView(@Param("ew") Wrapper<ZiliaorenzhengEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ZiliaorenzhengEntity> wrapper);
   	

}

