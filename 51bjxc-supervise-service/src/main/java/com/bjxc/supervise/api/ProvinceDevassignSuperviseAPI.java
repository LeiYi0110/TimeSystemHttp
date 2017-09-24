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
import com.bjxc.supervise.service.ProvinceDevassignSuperviseService;

@RestController
@RequestMapping("/province")
public class ProvinceDevassignSuperviseAPI {
    private static final Logger logger = LoggerFactory.getLogger(ProvinceDevassignSuperviseAPI.class);

    @Resource
    ProvinceDevassignSuperviseService provinceDevassignSuperviseService;

    @Resource
    InsertService insertService;
    
	@RequestMapping(value="/devassign",method=RequestMethod.POST)
	public Result devassign(ServletRequest request ){

		Result result = new Result();

		try
		{
			Map<String,Object> params = new HashMap<String,Object>();
			String devnum = WebUtils.getParameterValue(request, "devnum");
			Assert.notNull(devnum);
			params.put("devnum", devnum);

			String carnum = WebUtils.getParameterValue(request, "carnum");
			Assert.notNull(carnum);
			params.put("carnum", carnum);

			String sim = WebUtils.getParameterValue(request, "sim");
			Assert.notNull(sim);
			params.put("sim", sim);

			result = provinceDevassignSuperviseService.devassign(params);
			/*if(result.getCode()==200){
				try{
					insertService.addDevassign(params);
				}catch (Exception e) {
				}
				
			}*/
		} catch (Throwable ex) {
			result.error(ex);
			logger.error("ProvinceDevassign api",ex);
		}
		return result;
	}
}
