package com.entity.view;

import com.entity.DianziqianmingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 电子签名
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2022-04-18 19:23:55
 */
@TableName("dianziqianming")
public class DianziqianmingView  extends DianziqianmingEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DianziqianmingView(){
	}
 
 	public DianziqianmingView(DianziqianmingEntity dianziqianmingEntity){
 	try {
			BeanUtils.copyProperties(this, dianziqianmingEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
