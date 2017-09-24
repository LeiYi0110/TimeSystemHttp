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



import com.bjxc.supervise.service.ProvinceStuinfoQuerygetSuperviseService;

@RestController
@RequestMapping("/province")
public class ProvinceStuinfoQuerygetSuperviseAPI {
    private static final Logger logger = LoggerFactory.getLogger(ProvinceStuinfoQuerygetSuperviseAPI.class);

    @Resource
    ProvinceStuinfoQuerygetSuperviseService provinceStuinfoQuerygetSuperviseService;

	@RequestMapping(value="/stuinfoquery/get",method=RequestMethod.POST)
	public Result stuinfoquery(ServletRequest request ){

		Result result = new Result();

		try
		{
			Map<String,Object> params = new HashMap<String,Object>();
			String stunum = WebUtils.getParameterValue(request, "stunum");
			Assert.notNull(stunum);
			params.put("stunum", stunum);

			result = provinceStuinfoQuerygetSuperviseService.stuinfoquery(params);
		} catch (Throwable ex) {
			result.error(ex);
			logger.error("ProvinceStuinfoQuery api",ex);
		}
		return result;
	}
}
