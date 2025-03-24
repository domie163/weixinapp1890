package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ChuqinxinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ChuqinxinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ChuqinxinxiView;


/**
 * 出勤信息
 *
 * @author 
 * @email 
 * @date 2021-03-16 21:24:26
 */
public interface ChuqinxinxiService extends IService<ChuqinxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ChuqinxinxiVO> selectListVO(Wrapper<ChuqinxinxiEntity> wrapper);
   	
   	ChuqinxinxiVO selectVO(@Param("ew") Wrapper<ChuqinxinxiEntity> wrapper);
   	
   	List<ChuqinxinxiView> selectListView(Wrapper<ChuqinxinxiEntity> wrapper);
   	
   	ChuqinxinxiView selectView(@Param("ew") Wrapper<ChuqinxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ChuqinxinxiEntity> wrapper);
   	
}

