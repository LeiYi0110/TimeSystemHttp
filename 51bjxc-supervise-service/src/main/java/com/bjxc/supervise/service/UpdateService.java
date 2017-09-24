package com.bjxc.supervise.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.http.client.ClientProtocolException;
import org.springframework.stereotype.Service;

import com.bjxc.json.JacksonBinder;
import com.bjxc.supervise.http.HttpClientService;
import com.bjxc.supervise.mapper.SelectMapper;
import com.bjxc.supervise.mapper.UpdateMapper;

import net.sf.json.JSONArray;

@Service
public class UpdateService {
	@Resource
	private UpdateMapper updateMapper;

	@Resource
	private SelectMapper selectMapper;
	
	@Resource
	private HttpClientService httpClientService;

	/**
	 * 省-教学区域修改
	 */
	public void updateRegion(Map map){
		updateMapper.updateRegion(map);
	}


	/**
	 * 教练车修改
	 * @param map
	 */
	public void updatecar(Map map){
		updateMapper.updatecar(map);
	}

	/**
	 * 省-计时机构更新、备份到省平台
	 */
	public void updateInstitution(Map map){
		try {
			updateMapper.updateInstitution(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	/**
	 * 省-计时终端备案修改
	 */
	public void updatedevice(Map map){
		updateMapper.updatedevice(map);
	}

	/**
	 * 省-教练更新
	 * @param map
	 */
	public void updateCoach(Map map){
		try {
			updateMapper.updateCoach(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 省-考核员更新
	 * @param map
	 */
	public void updateExaminer(Map map){
		try {
			updateMapper.updateExaminer(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 省-学员备案和修改
	 */
	public void updateStudent(Map map){
		try {
			updateMapper.updateStudent(map);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	/**
	 * 省-安全员更新
	 * @param map
	 */
	public void updateSecurity(Map map){
		try {
			updateMapper.updateSecurity(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 省-修改 收费标准
	 * @param map
	 */
	public void updateCharStandard(Map map){
		try {
			updateMapper.updateCharStandard(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 省-学员跨培训机构备案
	 */
	public void updatetstudents(Map map){
		try {
			updateMapper.updatetstudents(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateCoachprovince(Map map){
		updateMapper.updateCoachprovince(map);
	}

	public void updateExaminerprovince(Map map){
		updateMapper.updateExaminerprovince(map);
	}

	public void updateSecurityprovince(Map map){
		updateMapper.updateSecurityprovince(map);
	}

	public void updateTrainingCarprovince(Map map){
		updateMapper.updateTrainingCarprovince(map);
	}

	public void updateDrivingfieldprovince(Map map){
		updateMapper.updateDrivingfieldprovince(map);
	}
	
	public void updateIsnotice(Integer seq,String inscode){
		updateMapper.updateIsnotice(seq, inscode);
	}
	
	/**
	 * 更新阶段培训记录审核结果
	 * @param map
	 * @throws IOException 
	 * @throws ClientProtocolException 
	 */
	public void updateTimeResult(Map map) throws ClientProtocolException, IOException{
		
		//更新结果记录
		updateMapper.updateTimeResult(map);
		
		//1.将所有教学记录更新为已通过，2.将没有通过的的更新
		updateMapper.updateTimePass(map);
		
		JSONArray jsonArray=JSONArray.fromObject(map.get("recarray"));
		List<Map> list=(List<Map>) JSONArray.toCollection(jsonArray,Map.class);
		if(list.size()>0){
			for (Map maps : list) {
				//科目三时学时编号是TCP协议上传的学时记录编号：recordCode。其余为eTrainingLogCode
				if(map.get("subject").toString().equals("3")||map.get("subject").toString().equals("2")){
					updateMapper.updateTimeFailBy3(maps.get("reason").toString(),maps.get("rnum").toString(),map.get("stunum").toString());
				}else {
					updateMapper.updateTimeFail(maps.get("reason").toString(),maps.get("rnum").toString(),map.get("stunum").toString());
				}
			}
		}

		//调用考试结果接口，使学员在阶段审核通过后自动进入下一阶段
		if((int)map.get("valid")==1){
			Integer studentId=selectMapper.getStuId(map.get("stunum").toString());
			Integer insId=selectMapper.getInsid(map.get("inscode").toString());
			Map maps=new HashMap();
			maps.put("status", 1);
			maps.put("subject", map.get("subject"));
			maps.put("insId", insId);
			maps.put("studentId", studentId);
			maps.put("coach", 0);
			String dataJSON = JacksonBinder.buildNonDefaultBinder().toJson(maps);
			httpClientService.doPostJson("http://112.74.129.7:8702/exam/0", dataJSON);
		}
	}
}
