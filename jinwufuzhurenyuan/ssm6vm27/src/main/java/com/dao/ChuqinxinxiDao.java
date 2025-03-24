package com.dao;

import com.entity.ChuqinxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ChuqinxinxiVO;
import com.entity.view.ChuqinxinxiView;


/**
 * 出勤信息
 * 
 * @author 
 * @email 
 * @date 2021-03-16 21:24:26
 */
public interface ChuqinxinxiDao extends BaseMapper<ChuqinxinxiEntity> {
	
	List<ChuqinxinxiVO> selectListVO(@Param("ew") Wrapper<ChuqinxinxiEntity> wrapper);
	
	ChuqinxinxiVO selectVO(@Param("ew") Wrapper<ChuqinxinxiEntity> wrapper);
	
	List<ChuqinxinxiView> selectListView(@Param("ew") Wrapper<ChuqinxinxiEntity> wrapper);

	List<ChuqinxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<ChuqinxinxiEntity> wrapper);
	
	ChuqinxinxiView selectView(@Param("ew") Wrapper<ChuqinxinxiEntity> wrapper);
	
}
