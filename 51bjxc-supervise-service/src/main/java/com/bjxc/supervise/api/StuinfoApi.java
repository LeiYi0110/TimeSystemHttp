package com.bjxc.supervise.api;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bjxc.Result;
import com.bjxc.supervise.service.StuinfoService;
import com.bjxc.web.utils.WebUtils;

@RestController
public class StuinfoApi {
	private static final Logger logger = LoggerFactory.getLogger(StuinfoApi.class);
	
	@Resource
	private StuinfoService stuService;
	
	@RequestMapping(value="/stuinfoApi",method=RequestMethod.GET)
	public Result stuinfo(ServletRequest request){
		Result result = new Result();
		try {
			Map<String,Object> params = new HashMap<String,Object>();

			params.put("cardnum", WebUtils.getParameterValue(request, "cardnum"));
			params.put("name", WebUtils.getParameterValue(request, "name"));
			
			
			result=stuService.coach(params);
		} catch (Exception e) {
			result.error(e);
			logger.error("CountryCoach api",e);
		}
		return result;
	}
}
