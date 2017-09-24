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



import com.bjxc.supervise.service.ProvinceReviewmsgSuperviseService;

@RestController
@RequestMapping("/province")
public class ProvinceReviewmsgSuperviseAPI {
	/*
    private static final Logger logger = LoggerFactory.getLogger(ProvinceReviewmsgSuperviseAPI.class);

    @Resource
    ProvinceReviewmsgSuperviseService provinceReviewmsgSuperviseService;

	@RequestMapping(value="/reviewmsg",method=RequestMethod.POST)
	public Result reviewmsg(ServletRequest request ){

		Result result = new Result();

		try
		{
			Map<String,Object> params = new HashMap<String,Object>();
			String reviewtype = WebUtils.getParameterValue(request, "reviewtype");
			Assert.notNull(reviewtype);
			params.put("reviewtype", reviewtype);

			result = provinceReviewmsgSuperviseService.reviewmsg(params);
		} catch (Throwable ex) {
			result.error(ex);
			logger.error("ProvinceReviewmsg api",ex);
		}
		return result;
	}
	*/
}
