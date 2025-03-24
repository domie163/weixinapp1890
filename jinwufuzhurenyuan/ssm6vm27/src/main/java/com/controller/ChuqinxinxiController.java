package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.ChuqinxinxiEntity;
import com.entity.view.ChuqinxinxiView;

import com.service.ChuqinxinxiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 出勤信息
 * 后端接口
 * @author 
 * @email 
 * @date 2021-03-16 21:24:26
 */
@RestController
@RequestMapping("/chuqinxinxi")
public class ChuqinxinxiController {
    @Autowired
    private ChuqinxinxiService chuqinxinxiService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ChuqinxinxiEntity chuqinxinxi, 
		HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("jingwuyuan")) {
			chuqinxinxi.setJingwuhao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ChuqinxinxiEntity> ew = new EntityWrapper<ChuqinxinxiEntity>();
		PageUtils page = chuqinxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, chuqinxinxi), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ChuqinxinxiEntity chuqinxinxi, HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("jingwuyuan")) {
			chuqinxinxi.setJingwuhao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ChuqinxinxiEntity> ew = new EntityWrapper<ChuqinxinxiEntity>();
		PageUtils page = chuqinxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, chuqinxinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ChuqinxinxiEntity chuqinxinxi){
       	EntityWrapper<ChuqinxinxiEntity> ew = new EntityWrapper<ChuqinxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( chuqinxinxi, "chuqinxinxi")); 
        return R.ok().put("data", chuqinxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ChuqinxinxiEntity chuqinxinxi){
        EntityWrapper< ChuqinxinxiEntity> ew = new EntityWrapper< ChuqinxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( chuqinxinxi, "chuqinxinxi")); 
		ChuqinxinxiView chuqinxinxiView =  chuqinxinxiService.selectView(ew);
		return R.ok("查询出勤信息成功").put("data", chuqinxinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ChuqinxinxiEntity chuqinxinxi = chuqinxinxiService.selectById(id);
        return R.ok().put("data", chuqinxinxi);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ChuqinxinxiEntity chuqinxinxi = chuqinxinxiService.selectById(id);
        return R.ok().put("data", chuqinxinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ChuqinxinxiEntity chuqinxinxi, HttpServletRequest request){
    	chuqinxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(chuqinxinxi);

        chuqinxinxiService.insert(chuqinxinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ChuqinxinxiEntity chuqinxinxi, HttpServletRequest request){
    	chuqinxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(chuqinxinxi);
    	chuqinxinxi.setUserid((Long)request.getSession().getAttribute("userId"));

        chuqinxinxiService.insert(chuqinxinxi);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody ChuqinxinxiEntity chuqinxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(chuqinxinxi);
        chuqinxinxiService.updateById(chuqinxinxi);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        chuqinxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<ChuqinxinxiEntity> wrapper = new EntityWrapper<ChuqinxinxiEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("jingwuyuan")) {
			wrapper.eq("jingwuhao", (String)request.getSession().getAttribute("username"));
		}

		int count = chuqinxinxiService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	


}
