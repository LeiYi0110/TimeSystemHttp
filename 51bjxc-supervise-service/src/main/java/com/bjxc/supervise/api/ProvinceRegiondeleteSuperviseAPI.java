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



import com.bjxc.supervise.service.ProvinceRegiondeleteSuperviseService;

@RestController
@RequestMapping("/province")
public class ProvinceRegiondeleteSuperviseAPI {
    private static final Logger logger = LoggerFactory.getLogger(ProvinceRegiondeleteSuperviseAPI.class);

    @Resource
    ProvinceRegiondeleteSuperviseService provinceRegiondeleteSuperviseService;

	@RequestMapping(value="/region/delete",method=RequestMethod.POST)
	public Result region(ServletRequest request ){

		Result result = new Result();

		try
		{
			Map<String,Object> params = new HashMap<String,Object>();
			String inscode = WebUtils.getParameterValue(request, "inscode");
			Assert.notNull(inscode);
			params.put("inscode", inscode);

			String seq = WebUtils.getParameterValue(request, "seq");
			Assert.notNull(seq);
			params.put("seq", seq);

			result = provinceRegiondeleteSuperviseService.region(params);
		} catch (Throwable ex) {
			result.error(ex);
			logger.error("ProvinceRegion api",ex);
		}
		return result;
	}
}
