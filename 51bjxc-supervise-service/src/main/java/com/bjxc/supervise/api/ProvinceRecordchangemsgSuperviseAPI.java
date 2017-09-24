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



import com.bjxc.supervise.service.ProvinceRecordchangemsgSuperviseService;

@RestController
@RequestMapping("/province")
public class ProvinceRecordchangemsgSuperviseAPI {
	/*
    private static final Logger logger = LoggerFactory.getLogger(ProvinceRecordchangemsgSuperviseAPI.class);

    @Resource
    ProvinceRecordchangemsgSuperviseService provinceRecordchangemsgSuperviseService;

	@RequestMapping(value="/recordchangemsg",method=RequestMethod.POST)
	public Result recordchangemsg(ServletRequest request ){

		Result result = new Result();
		try
		{
			Map<String,Object> params = new HashMap<String,Object>();
			String recordtype = WebUtils.getParameterValue(request, "recordtype");
			Assert.notNull(recordtype);
			params.put("recordtype", recordtype);

			String changetype = WebUtils.getParameterValue(request, "changetype");
			Assert.notNull(changetype);
			params.put("changetype", changetype);

			String inscode = WebUtils.getParameterValue(request, "inscode");
			Assert.notNull(inscode);
			params.put("inscode", inscode);

			String recordnum = WebUtils.getParameterValue(request, "recordnum");
			Assert.notNull(recordnum);
			params.put("recordnum", recordnum);

			result = provinceRecordchangemsgSuperviseService.recordchangemsg(params);
		} catch (Throwable ex) {
			result.error(ex);
			logger.error("ProvinceRecordchangemsg api",ex);
		}
		return result;
	}
	*/
}
