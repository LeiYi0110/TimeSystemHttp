package com.bjxc.supervise.service;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bjxc.supervise.mapper.DeleteMapper;
import com.bjxc.supervise.mapper.UpdateMapper;

@Service
public class DeleteService {
	@Resource
	private DeleteMapper deleteMapper;
	
	public void deletecar(Map map){
		deleteMapper.deletecar(map);
	}

	public void deletedm(Map map){
		deleteMapper.deletedm(map);
	}
	/**
	 * 删除教练员
	 * @param map
	 */
	public void deleteCoach(Map map){
		try {
			deleteMapper.deleteCoach(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 删除考核员
	 * @param map
	 */
	public void deleteExaminer(Map map){
		try {
			deleteMapper.deleteExaminer(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 删除安全员
	 * @param map
	 */
	public void deleteSecurity(Map map){
		try {
			deleteMapper.deleteSecurity(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	
	public void deletetdevassign(Map map){
		deleteMapper.deletetdevassign(map);
	
	}

	/**
	 * 省-删除收费标准
	 * @param map
	 */
	public void deleteCharStandard(Map map){
		try {
			deleteMapper.deleteCharStandard(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
