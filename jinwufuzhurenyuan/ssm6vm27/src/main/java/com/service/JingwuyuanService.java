package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.JingwuyuanEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.JingwuyuanVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.JingwuyuanView;


/**
 * 警务员
 *
 * @author 
 * @email 
 * @date 2021-03-16 21:24:26
 */
public interface JingwuyuanService extends IService<JingwuyuanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JingwuyuanVO> selectListVO(Wrapper<JingwuyuanEntity> wrapper);
   	
   	JingwuyuanVO selectVO(@Param("ew") Wrapper<JingwuyuanEntity> wrapper);
   	
   	List<JingwuyuanView> selectListView(Wrapper<JingwuyuanEntity> wrapper);
   	
   	JingwuyuanView selectView(@Param("ew") Wrapper<JingwuyuanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JingwuyuanEntity> wrapper);
   	
}

