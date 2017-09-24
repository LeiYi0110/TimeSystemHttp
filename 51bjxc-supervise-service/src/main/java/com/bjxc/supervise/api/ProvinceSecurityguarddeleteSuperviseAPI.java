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
import com.bjxc.supervise.service.DeleteService;
import com.bjxc.supervise.service.ProvinceSecurityguarddeleteSuperviseService;

@RestController
@RequestMapping("/province")
public class ProvinceSecurityguarddeleteSuperviseAPI {
    private static final Logger logger = LoggerFactory.getLogger(ProvinceSecurityguarddeleteSuperviseAPI.class);

    @Resource
    ProvinceSecurityguarddeleteSuperviseService provinceSecurityguarddeleteSuperviseService;
    @Resource
    DeleteService deleteService;

	@RequestMapping(value="/securityguard/delete",method=RequestMethod.POST)
	public Result securityguard(ServletRequest request ){

		Result result = new Result();

		try
		{
			Map<String,Object> params = new HashMap<String,Object>();
			String secunum = WebUtils.getParameterValue(request, "secunum");
			Assert.notNull(secunum);
			params.put("secunum", secunum);

			result = provinceSecurityguarddeleteSuperviseService.securityguard(params);
		/*	if(result.getCode()==200){
				deleteService.deleteSecurity(params);
			}*/
		} catch (Throwable ex) {
			result.error(ex);
			logger.error("ProvinceSecurityguard api",ex);
		}
		return result;
	}
}
