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
import com.bjxc.supervise.service.ProvinceDevicedeleteSuperviseService;

@RestController
@RequestMapping("/province")
public class ProvinceDevicedeleteSuperviseAPI {
    private static final Logger logger = LoggerFactory.getLogger(ProvinceDevicedeleteSuperviseAPI.class);

    @Resource
    ProvinceDevicedeleteSuperviseService provinceDevicedeleteSuperviseService;
   
    @Resource
    DeleteService deleteService;
	@RequestMapping(value="/device/delete",method=RequestMethod.POST)
	public Result device(ServletRequest request ){

		Result result = new Result();

		try
		{
			Map<String,Object> params = new HashMap<String,Object>();
			String devnum = WebUtils.getParameterValue(request, "devnum");
			Assert.notNull(devnum);
			params.put("devnum", devnum);

			result = provinceDevicedeleteSuperviseService.device(params);
		/*	if(result.getCode()==200){
				deleteService.deletecar(params);
			}*/
		} catch (Throwable ex) {
			result.error(ex);
			logger.error("ProvinceDevice api",ex);
		}
		return result;
	}
}
