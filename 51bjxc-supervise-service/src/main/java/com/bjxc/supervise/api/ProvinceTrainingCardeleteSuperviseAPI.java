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
import com.bjxc.supervise.service.ProvinceTrainingCardeleteSuperviseService;

@RestController
@RequestMapping("/province")
public class ProvinceTrainingCardeleteSuperviseAPI {
    private static final Logger logger = LoggerFactory.getLogger(ProvinceTrainingCardeleteSuperviseAPI.class);

    @Resource
    ProvinceTrainingCardeleteSuperviseService provinceTrainingCardeleteSuperviseService;

    @Resource
    DeleteService   deleteService;
    
	@RequestMapping(value="/trainingcar/delete",method=RequestMethod.POST)
	public Result trainingcar(ServletRequest request ){

		Result result = new Result();
		try
		{
			Map<String,Object> params = new HashMap<String,Object>();
			String carnum = WebUtils.getParameterValue(request, "carnum");
			Assert.notNull(carnum);
			params.put("carnum", carnum);

			result = provinceTrainingCardeleteSuperviseService.trainingcar(params);
			/*if(result.getCode()==200){
				try{
					deleteService.deletecar(params);
				}catch (Exception e) {
				}
			}*/
		} catch (Throwable ex) {
			result.error(ex);
			logger.error("ProvinceTrainingCar api",ex);
		}
		return result;
	}
}
