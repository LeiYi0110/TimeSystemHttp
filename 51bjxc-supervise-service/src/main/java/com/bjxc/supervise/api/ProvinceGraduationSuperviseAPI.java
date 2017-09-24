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



import com.bjxc.supervise.service.ProvinceGraduationSuperviseService;

@RestController
@RequestMapping("/province")
public class ProvinceGraduationSuperviseAPI {
    private static final Logger logger = LoggerFactory.getLogger(ProvinceGraduationSuperviseAPI.class);

    @Resource
    ProvinceGraduationSuperviseService provinceGraduationSuperviseService;

	@RequestMapping(value="/graduation",method=RequestMethod.POST)
	public Result graduation(ServletRequest request ){

		Result result = new Result();

		try
		{
			Map<String,Object> params = new HashMap<String,Object>();
			String stunum = WebUtils.getParameterValue(request, "stunum");
			Assert.notNull(stunum);
			params.put("stunum", stunum);

			String autinscode = WebUtils.getParameterValue(request, "autinscode");
			Assert.notNull(autinscode);
			params.put("autinscode", autinscode);

			String gracertnum = WebUtils.getParameterValue(request, "gracertnum");
			Assert.notNull(gracertnum);
			params.put("gracertnum", gracertnum);

			String grantdate = WebUtils.getParameterValue(request, "grantdate");
			Assert.notNull(grantdate);
			params.put("grantdate", grantdate);

			String pdfid = WebUtils.getParameterValue(request, "pdfid");
			Assert.notNull(pdfid);
			//params.put("pdfid", pdfid);

			
			String esignature = WebUtils.getParameterValue(request, "esignature");
			Assert.notNull(esignature);
			//params.put("esignature", esignature);
			
			result = provinceGraduationSuperviseService.graduation(params,pdfid,esignature);
		} catch (Throwable ex) {
			result.error(ex);
			logger.error("ProvinceGraduation api",ex);
		}
		return result;
	}
}
