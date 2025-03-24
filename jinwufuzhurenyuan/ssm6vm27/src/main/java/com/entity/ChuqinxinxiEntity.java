package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 出勤信息
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2021-03-16 21:24:26
 */
@TableName("chuqinxinxi")
public class ChuqinxinxiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public ChuqinxinxiEntity() {
		
	}
	
	public ChuqinxinxiEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 警务号
	 */
					
	private String jingwuhao;
	
	/**
	 * 姓名
	 */
					
	private String xingming;
	
	/**
	 * 头像
	 */
					
	private String touxiang;
	
	/**
	 * 出勤时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date chuqinshijian;
	
	/**
	 * 出勤类型
	 */
					
	private String chuqinleixing;
	
	/**
	 * 备注
	 */
					
	private String beizhu;
	
	/**
	 * 用户id
	 */
					
	private Long userid;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：警务号
	 */
	public void setJingwuhao(String jingwuhao) {
		this.jingwuhao = jingwuhao;
	}
	/**
	 * 获取：警务号
	 */
	public String getJingwuhao() {
		return jingwuhao;
	}
	/**
	 * 设置：姓名
	 */
	public void setXingming(String xingming) {
		this.xingming = xingming;
	}
	/**
	 * 获取：姓名
	 */
	public String getXingming() {
		return xingming;
	}
	/**
	 * 设置：头像
	 */
	public void setTouxiang(String touxiang) {
		this.touxiang = touxiang;
	}
	/**
	 * 获取：头像
	 */
	public String getTouxiang() {
		return touxiang;
	}
	/**
	 * 设置：出勤时间
	 */
	public void setChuqinshijian(Date chuqinshijian) {
		this.chuqinshijian = chuqinshijian;
	}
	/**
	 * 获取：出勤时间
	 */
	public Date getChuqinshijian() {
		return chuqinshijian;
	}
	/**
	 * 设置：出勤类型
	 */
	public void setChuqinleixing(String chuqinleixing) {
		this.chuqinleixing = chuqinleixing;
	}
	/**
	 * 获取：出勤类型
	 */
	public String getChuqinleixing() {
		return chuqinleixing;
	}
	/**
	 * 设置：备注
	 */
	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}
	/**
	 * 获取：备注
	 */
	public String getBeizhu() {
		return beizhu;
	}
	/**
	 * 设置：用户id
	 */
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	/**
	 * 获取：用户id
	 */
	public Long getUserid() {
		return userid;
	}

}
