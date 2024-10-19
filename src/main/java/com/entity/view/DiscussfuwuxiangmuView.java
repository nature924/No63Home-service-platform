package com.entity.view;

import com.entity.DiscussfuwuxiangmuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 服务项目评论表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2022-04-18 19:23:55
 */
@TableName("discussfuwuxiangmu")
public class DiscussfuwuxiangmuView  extends DiscussfuwuxiangmuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscussfuwuxiangmuView(){
	}
 
 	public DiscussfuwuxiangmuView(DiscussfuwuxiangmuEntity discussfuwuxiangmuEntity){
 	try {
			BeanUtils.copyProperties(this, discussfuwuxiangmuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
