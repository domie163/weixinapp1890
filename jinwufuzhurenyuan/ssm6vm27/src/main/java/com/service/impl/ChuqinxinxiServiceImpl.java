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


import com.dao.ChuqinxinxiDao;
import com.entity.ChuqinxinxiEntity;
import com.service.ChuqinxinxiService;
import com.entity.vo.ChuqinxinxiVO;
import com.entity.view.ChuqinxinxiView;

@Service("chuqinxinxiService")
public class ChuqinxinxiServiceImpl extends ServiceImpl<ChuqinxinxiDao, ChuqinxinxiEntity> implements ChuqinxinxiService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ChuqinxinxiEntity> page = this.selectPage(
                new Query<ChuqinxinxiEntity>(params).getPage(),
                new EntityWrapper<ChuqinxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ChuqinxinxiEntity> wrapper) {
		  Page<ChuqinxinxiView> page =new Query<ChuqinxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ChuqinxinxiVO> selectListVO(Wrapper<ChuqinxinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ChuqinxinxiVO selectVO(Wrapper<ChuqinxinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ChuqinxinxiView> selectListView(Wrapper<ChuqinxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ChuqinxinxiView selectView(Wrapper<ChuqinxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
