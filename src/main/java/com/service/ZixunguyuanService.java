package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ZixunguyuanEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ZixunguyuanVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ZixunguyuanView;


/**
 * 咨询雇员
 *
 * @author 
 * @email 
 * @date 2022-04-18 19:23:55
 */
public interface ZixunguyuanService extends IService<ZixunguyuanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZixunguyuanVO> selectListVO(Wrapper<ZixunguyuanEntity> wrapper);
   	
   	ZixunguyuanVO selectVO(@Param("ew") Wrapper<ZixunguyuanEntity> wrapper);
   	
   	List<ZixunguyuanView> selectListView(Wrapper<ZixunguyuanEntity> wrapper);
   	
   	ZixunguyuanView selectView(@Param("ew") Wrapper<ZixunguyuanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ZixunguyuanEntity> wrapper);
   	

}

