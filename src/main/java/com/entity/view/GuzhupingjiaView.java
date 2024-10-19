package com.entity.view;

import com.entity.GuzhupingjiaEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 雇主评价
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2022-04-18 19:23:55
 */
@TableName("guzhupingjia")
public class GuzhupingjiaView  extends GuzhupingjiaEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public GuzhupingjiaView(){
	}
 
 	public GuzhupingjiaView(GuzhupingjiaEntity guzhupingjiaEntity){
 	try {
			BeanUtils.copyProperties(this, guzhupingjiaEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
