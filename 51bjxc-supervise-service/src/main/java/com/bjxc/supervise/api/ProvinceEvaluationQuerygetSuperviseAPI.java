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
import com.bjxc.supervise.service.InsertService;
import com.bjxc.supervise.service.ProvinceEvaluationQuerygetSuperviseService;
import com.bjxc.web.utils.WebUtils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@RestController
@RequestMapping("/province")
public class ProvinceEvaluationQuerygetSuperviseAPI {
    private static final Logger logger = LoggerFactory.getLogger(ProvinceEvaluationQuerygetSuperviseAPI.class);

    @Resource
    ProvinceEvaluationQuerygetSuperviseService provinceEvaluationQuerygetSuperviseService;
    
    @Resource
   	InsertService insertService;
    
	@RequestMapping(value="/evaluationquery/get",method=RequestMethod.POST)
	public Result evaluationquery(ServletRequest request ){
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

			result = provinceEvaluationQuerygetSuperviseService.evaluationquery(params);
		/*	if(result.getCode()==200){
				try {
					
					JSONObject data = JSONObject.fromObject(result.getData());
					
					JSONArray evaluationarray = data.getJSONArray("evaluationarray");
					
					for(int i = 0; i < evaluationarray.size(); i++)
					{
						JSONObject item = evaluationarray.getJSONObject(i);
						Map<String,Object> map = new HashMap<String,Object>();
						
						map.put("stunum", item.getString("stunum"));

						map.put("evalobject", item.getString("evalobject"));

						map.put("type",item.getString("type"));

						map.put("overall", item.getString("overall"));

						map.put("part", item.getString("part"));

						map.put("evaluatetime", item.getString("evaluatetime"));

						map.put("srvmanner", item.getString("srvmanner"));

						map.put("teachlevel", item.getString("stunum"));
						insertService.addEvaluation(map);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}*/
		} catch (Throwable ex) {
			result.error(ex);
			logger.error("ProvinceEvaluationQuery api",ex);
		}
		return result;
	}
}
