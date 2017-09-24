package com.bjxc.supervise.api;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bjxc.Result;

import com.bjxc.web.utils.WebUtils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.bjxc.supervise.service.InsertService;
import com.bjxc.supervise.service.ProvinceComplaintQuerygetSuperviseService;

@RestController
@RequestMapping("/province")
public class ProvinceComplaintQuerygetSuperviseAPI {
    private static final Logger logger = LoggerFactory.getLogger(ProvinceComplaintQuerygetSuperviseAPI.class);

    @Resource
    ProvinceComplaintQuerygetSuperviseService provinceComplaintQuerygetSuperviseService;
    
    @Resource
   	InsertService insertService;
    
	@RequestMapping(value="/complaintquery/get",method=RequestMethod.POST)
	public Result complaintquery(ServletRequest request ){

		Result result = new Result();

		try
		{
			Map<String,Object> params = new HashMap<String,Object>();
			String inscode = WebUtils.getParameterValue(request, "inscode");
			Assert.notNull(inscode);
			params.put("inscode", inscode);

			String querydate = WebUtils.getParameterValue(request, "querydate");
			Assert.notNull(querydate);
			params.put("querydate", querydate);

			result = provinceComplaintQuerygetSuperviseService.complaintquery(params);
		/*	if(result.getCode()==200){
				try {
					
					JSONObject data = JSONObject.fromObject(result.getData());
					
					JSONArray evaluationarray = data.getJSONArray("complaintarray");
					
					for(int i = 0; i < evaluationarray.size(); i++)
					{
						JSONObject item = evaluationarray.getJSONObject(i);
						Map<String,Object> map = new HashMap<String,Object>();
						map.put("stunum", item.getString("stunum"));

						map.put("type", item.getString("type"));

						map.put("objenum", item.getString("objenum"));

						map.put("cdate", item.getString("cdate"));

						map.put("content", item.getString("content"));

						map.put("depaopinion", item.getString("depaopinion"));

						map.put("schopinion", item.getString("schopinion"));
						insertService.addComplaint(map);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}*/
		} catch (Throwable ex) {
			result.error(ex);
			logger.error("ProvinceComplaintQuery api",ex);
		}
		return result;
	}
}
