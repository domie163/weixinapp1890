package com.dao;

import com.entity.JingwuyuanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.JingwuyuanVO;
import com.entity.view.JingwuyuanView;


/**
 * 警务员
 * 
 * @author 
 * @email 
 * @date 2021-03-16 21:24:26
 */
public interface JingwuyuanDao extends BaseMapper<JingwuyuanEntity> {
	
	List<JingwuyuanVO> selectListVO(@Param("ew") Wrapper<JingwuyuanEntity> wrapper);
	
	JingwuyuanVO selectVO(@Param("ew") Wrapper<JingwuyuanEntity> wrapper);
	
	List<JingwuyuanView> selectListView(@Param("ew") Wrapper<JingwuyuanEntity> wrapper);

	List<JingwuyuanView> selectListView(Pagination page,@Param("ew") Wrapper<JingwuyuanEntity> wrapper);
	
	JingwuyuanView selectView(@Param("ew") Wrapper<JingwuyuanEntity> wrapper);
	
}
