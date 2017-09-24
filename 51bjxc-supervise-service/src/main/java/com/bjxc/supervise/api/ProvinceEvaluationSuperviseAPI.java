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
import com.bjxc.supervise.mapper.UpdateMapper;
import com.bjxc.supervise.service.InsertService;
import com.bjxc.supervise.service.ProvinceEvaluationSuperviseService;

@RestController
@RequestMapping("/province")
public class ProvinceEvaluationSuperviseAPI {
    private static final Logger logger = LoggerFactory.getLogger(ProvinceEvaluationSuperviseAPI.class);

    @Resource
    ProvinceEvaluationSuperviseService provinceEvaluationSuperviseService;
    
    @Resource
	InsertService insertService;
    
	@RequestMapping(value="/evaluation",method=RequestMethod.POST)
	public Result evaluation(ServletRequest request ){

		Result result = new Result();

		try
		{
			Map<String,Object> params = new HashMap<String,Object>();
			String stunum = WebUtils.getParameterValue(request, "stunum");
			Assert.notNull(stunum);
			params.put("stunum", stunum);

			String evalobject = WebUtils.getParameterValue(request, "evalobject");
			Assert.notNull(evalobject);
			params.put("evalobject", evalobject);

			String type = WebUtils.getParameterValue(request, "type");
			Assert.notNull(type);
			params.put("type", type);

			String overall = WebUtils.getParameterValue(request, "overall");
			Assert.notNull(overall);
			params.put("overall", overall);

			String part = WebUtils.getParameterValue(request, "part");
			params.put("part", part);

			String evaluatetime = WebUtils.getParameterValue(request, "evaluatetime");
			Assert.notNull(evaluatetime);
			params.put("evaluatetime", evaluatetime);

			String srvmanner = WebUtils.getParameterValue(request, "srvmanner");
			params.put("srvmanner", srvmanner);

			String teachlevel = WebUtils.getParameterValue(request, "teachlevel");
			params.put("teachlevel", teachlevel);
			
			result = provinceEvaluationSuperviseService.evaluation(params);
			/*if(result.getCode()==200){
				try {
					insertService.addEvaluation(params);
				} catch (Exception e) {
				}
			}*/
		} catch (Throwable ex) {
			result.error(ex);
			logger.error("ProvinceEvaluation api",ex);
		}
		return result;
	}
}
