package com.entity.view;

import com.entity.JingwuyuanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 警务员
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2021-03-16 21:24:26
 */
@TableName("jingwuyuan")
public class JingwuyuanView  extends JingwuyuanEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public JingwuyuanView(){
	}
 
 	public JingwuyuanView(JingwuyuanEntity jingwuyuanEntity){
 	try {
			BeanUtils.copyProperties(this, jingwuyuanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
