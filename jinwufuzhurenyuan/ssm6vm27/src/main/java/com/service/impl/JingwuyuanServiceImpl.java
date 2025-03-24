package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.JingwuyuanDao;
import com.entity.JingwuyuanEntity;
import com.service.JingwuyuanService;
import com.entity.vo.JingwuyuanVO;
import com.entity.view.JingwuyuanView;

@Service("jingwuyuanService")
public class JingwuyuanServiceImpl extends ServiceImpl<JingwuyuanDao, JingwuyuanEntity> implements JingwuyuanService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JingwuyuanEntity> page = this.selectPage(
                new Query<JingwuyuanEntity>(params).getPage(),
                new EntityWrapper<JingwuyuanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JingwuyuanEntity> wrapper) {
		  Page<JingwuyuanView> page =new Query<JingwuyuanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<JingwuyuanVO> selectListVO(Wrapper<JingwuyuanEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public JingwuyuanVO selectVO(Wrapper<JingwuyuanEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<JingwuyuanView> selectListView(Wrapper<JingwuyuanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JingwuyuanView selectView(Wrapper<JingwuyuanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
