package com.entity.view;

import com.entity.XuqiuxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 需求信息
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2022-04-18 19:23:55
 */
@TableName("xuqiuxinxi")
public class XuqiuxinxiView  extends XuqiuxinxiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public XuqiuxinxiView(){
	}
 
 	public XuqiuxinxiView(XuqiuxinxiEntity xuqiuxinxiEntity){
 	try {
			BeanUtils.copyProperties(this, xuqiuxinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
