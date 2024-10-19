package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ZixunguzhuEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ZixunguzhuVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ZixunguzhuView;


/**
 * 咨询雇主
 *
 * @author 
 * @email 
 * @date 2022-04-18 19:23:55
 */
public interface ZixunguzhuService extends IService<ZixunguzhuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZixunguzhuVO> selectListVO(Wrapper<ZixunguzhuEntity> wrapper);
   	
   	ZixunguzhuVO selectVO(@Param("ew") Wrapper<ZixunguzhuEntity> wrapper);
   	
   	List<ZixunguzhuView> selectListView(Wrapper<ZixunguzhuEntity> wrapper);
   	
   	ZixunguzhuView selectView(@Param("ew") Wrapper<ZixunguzhuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ZixunguzhuEntity> wrapper);
   	

}

