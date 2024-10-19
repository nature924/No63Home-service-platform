package com.entity.view;

import com.entity.ShenqingyuyueEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 申请预约
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2022-04-18 19:23:55
 */
@TableName("shenqingyuyue")
public class ShenqingyuyueView  extends ShenqingyuyueEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ShenqingyuyueView(){
	}
 
 	public ShenqingyuyueView(ShenqingyuyueEntity shenqingyuyueEntity){
 	try {
			BeanUtils.copyProperties(this, shenqingyuyueEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
