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
import com.bjxc.supervise.service.InsertService;
import com.bjxc.supervise.service.ProvinceTransferSuperviseService;
import com.bjxc.supervise.service.UpdateService;

@RestController
@RequestMapping("/province")
public class ProvinceTransferSuperviseAPI {
    private static final Logger logger = LoggerFactory.getLogger(ProvinceTransferSuperviseAPI.class);

    @Resource
    ProvinceTransferSuperviseService provinceTransferSuperviseService;
    @Resource
    UpdateService updateService;
    
	@RequestMapping(value="/ transfer",method=RequestMethod.POST)
	public Result  transfer(ServletRequest request ){

		Result result = new Result();

		try
		{
			Map<String,Object> params = new HashMap<String,Object>();
			String inscode = WebUtils.getParameterValue(request, "inscode");
			Assert.notNull(inscode);
			params.put("inscode", inscode);

			String stunum = WebUtils.getParameterValue(request, "stunum");
			Assert.notNull(stunum);
			params.put("stunum", stunum);
			
			
			result = provinceTransferSuperviseService.transfer(params);
		/*	if(result.getCode()==200){
				try{
					updateService.updatetstudents(params);
				}catch (Exception e) {
				}
			}*/
			
		} catch (Throwable ex) {
			result.error(ex);
			logger.error("Province Transfer api",ex);
		}
		return result;
	}
}
