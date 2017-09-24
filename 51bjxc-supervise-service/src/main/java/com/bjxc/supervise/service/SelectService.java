package com.bjxc.supervise.service;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bjxc.supervise.mapper.SelectMapper;

@Service
public class SelectService {
	@Resource 
	SelectMapper selectMapper;
	
	public Map getArea(Map map){
		return selectMapper.getArea(map);
	}
	
	public Map getSta(Map map){
		return selectMapper.getSta(map);
	}
	
	/**
	 * 省-教学区域审核
	 * @param map
	 * @return
	 */
	public Map gettdf(Map map){
		return selectMapper.getSta(map);
		
	}
}
