package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.QiandinghetongEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.QiandinghetongVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.QiandinghetongView;


/**
 * 签订合同
 *
 * @author 
 * @email 
 * @date 2022-04-18 19:23:55
 */
public interface QiandinghetongService extends IService<QiandinghetongEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<QiandinghetongVO> selectListVO(Wrapper<QiandinghetongEntity> wrapper);
   	
   	QiandinghetongVO selectVO(@Param("ew") Wrapper<QiandinghetongEntity> wrapper);
   	
   	List<QiandinghetongView> selectListView(Wrapper<QiandinghetongEntity> wrapper);
   	
   	QiandinghetongView selectView(@Param("ew") Wrapper<QiandinghetongEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<QiandinghetongEntity> wrapper);
   	

}

