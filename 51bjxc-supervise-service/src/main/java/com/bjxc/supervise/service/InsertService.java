package com.bjxc.supervise.service;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Service;

import com.bjxc.supervise.mapper.InsertMapper;
import com.bjxc.supervise.mapper.UpdateMapper;

@Service
public class InsertService {
	@Resource
	private InsertMapper insertMapper;
	@Resource
	private PrivateKeyFactory privateKeyFactory;

	
	/**
	 * 全国-机构添加
	 */
	public void addInstitution(Map map){
		insertMapper.addInstitution(map);
	}

	/**
	 * 省-教学区域添加
	 * @param map
	 */
	public void addRegion(Map map){
		insertMapper.addRegion(map);	
		
	}

	
	/**
	 * 全国-学生添加
	 */	
	public void addStudent(Map map){
		insertMapper.addStudent(map);
	}

	
	/**
	 * 全国-教练添加
	 */	
	public void addCoach(Map map){
		insertMapper.addCoach(map);
	}

	
	/**
	 * 全国-考核员添加
	 */	
	public void addExaminer(Map map){
		insertMapper.addExaminer(map);
	}

	
	/**
	 * 全国-车辆添加
	 */
	public void addcar(Map map){
		insertMapper.addcar(map);
	}


	
	/**
	 * 全国-安全员添加
	 */	
	public void addSecurity(Map map){
		insertMapper.addSecurity(map);
	}
	
	/**
	 * 全国-计时终端添加
	 */	
	public void addDevice(Map map){
		String cerbase64=privateKeyFactory.getDevicePublicKey(map.get("key").toString(), map.get("passwd").toString());
		map.put("cerbase64", cerbase64);
		insertMapper.addDevice(map);
	}
	
	/**
	 * 省-评价信息交换
	 */	
	public void addEvaluation(Map map){
		insertMapper.addEvaluation(map);
	}
	
	/**
	 * 省-投诉信息交换
	 */	
	public void addComplaint(Map map){
		insertMapper.addComplaint(map);
	}

	/**
	 * 省-电子教学日志
	 */
   public void classrecord(Map map){
	   insertMapper.classrecord(map);
   }
	/**
	 * 省-计时终端绑定教练车
	 */
	
	public void addDevassign(Map map){
		insertMapper.addDevassign(map);
	}
	
	/**
	 * 省-培训记录上报
	 */
	public void addstagetrainningtime(Map map){
		insertMapper.addstagetrainningtime(map);
	}
   

	/**
	 * 省-培训过程视频资料信息 增加
	 */
	public void insertVideoRecord(Map map){
		insertMapper.insertVideoRecord(map);
	}
	
	/**
	 * 省-培训过程图片资料信息 增加
	 */
	public void addTrainimgInfo(Map map){
		insertMapper.addTrainimgInfo(map);
	}
	
	public void addHttpLog(String log){
		insertMapper.addHttpLog(log);
	}
	
	public void addTeachLog(Map map){
		insertMapper.addTeachLog(map);
	}
}
