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



import com.bjxc.supervise.service.ProvinceDeviceSuperviseService;
import com.bjxc.supervise.service.UpdateService;

@RestController
@RequestMapping("/province")
public class ProvinceDeviceSuperviseAPI {
    private static final Logger logger = LoggerFactory.getLogger(ProvinceDeviceSuperviseAPI.class);

    @Resource
    ProvinceDeviceSuperviseService provinceDeviceSuperviseService;
    @Resource
    UpdateService	updateService;
    
	@RequestMapping(value="/device",method=RequestMethod.POST)
	public Result device(ServletRequest request ){

		Result result = new Result();

		try
		{
			Map<String,Object> params = new HashMap<String,Object>();
			String devnum = WebUtils.getParameterValue(request, "devnum");
			Assert.notNull(devnum);
			params.put("devnum", devnum);

			String termtype = WebUtils.getParameterValue(request, "termtype");
			Assert.notNull(termtype);
			params.put("termtype", termtype);

			String vender = WebUtils.getParameterValue(request, "vender");
			Assert.notNull(vender);
			params.put("vender", vender);

			String model = WebUtils.getParameterValue(request, "model");
			Assert.notNull(model);
			params.put("model", model);

			String imei = WebUtils.getParameterValue(request, "imei");
			Assert.notNull(imei);
			params.put("imei", imei);

			String sn = WebUtils.getParameterValue(request, "sn");
			Assert.notNull(sn);
			params.put("sn", sn);

			String inscode = WebUtils.getParameterValue(request, "inscode");
			params.put("inscode", inscode);

			/*
			String cerbase64 = WebUtils.getParameterValue(request, "cerbase64");
			Assert.notNull(cerbase64);
			params.put("cerbase64", cerbase64);
			*/
			String key = WebUtils.getParameterValue(request, "key");
			Assert.notNull(key);
			params.put("key", key);
			
			String password = WebUtils.getParameterValue(request, "password");
			Assert.notNull(password);
			params.put("password", password);

			result = provinceDeviceSuperviseService.device(params);
		/*	if(result.getCode()==200){
				try {
				updateService.updatedevice(params);
				} catch (Exception e) {
			
				}
				
			}*/
		} catch (Throwable ex) {
			result.error(ex);
			logger.error("ProvinceDevice api",ex);
		}
		return result;
	}
}
