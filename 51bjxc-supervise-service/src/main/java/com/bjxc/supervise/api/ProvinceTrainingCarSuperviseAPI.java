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



import com.bjxc.supervise.service.ProvinceTrainingCarSuperviseService;
import com.bjxc.supervise.service.UpdateService;

@RestController
@RequestMapping("/province")
public class ProvinceTrainingCarSuperviseAPI {
    private static final Logger logger = LoggerFactory.getLogger(ProvinceTrainingCarSuperviseAPI.class);

    @Resource
    ProvinceTrainingCarSuperviseService provinceTrainingCarSuperviseService;
  
    @Resource
    UpdateService updateService;
    
	@RequestMapping(value="/trainingcar",method=RequestMethod.POST)
	public Result trainingcar(ServletRequest request ){

		Result result = new Result();

		try
		{
			Map<String,Object> params = new HashMap<String,Object>();
			String inscode = WebUtils.getParameterValue(request, "inscode");
			Assert.notNull(inscode);
			params.put("inscode", inscode);

			String carnum = WebUtils.getParameterValue(request, "carnum");
			Assert.notNull(carnum);
			params.put("carnum", carnum);

			String franum = WebUtils.getParameterValue(request, "franum");
			params.put("franum", franum);

			String engnum = WebUtils.getParameterValue(request, "engnum");
			params.put("engnum", engnum);

			String licnum = WebUtils.getParameterValue(request, "licnum");
			Assert.notNull(licnum);
			params.put("licnum", licnum);

			String platecolor = WebUtils.getParameterValue(request, "platecolor");
			Assert.notNull(platecolor);
			params.put("platecolor", platecolor);

			String photo = WebUtils.getParameterValue(request, "photo");
			params.put("photo", photo);

			String manufacture = WebUtils.getParameterValue(request, "manufacture");
			Assert.notNull(manufacture);
			params.put("manufacture", manufacture);

			String brand = WebUtils.getParameterValue(request, "brand");
			Assert.notNull(brand);
			params.put("brand", brand);

			String model = WebUtils.getParameterValue(request, "model");
			params.put("model", model);

			String perdritype = WebUtils.getParameterValue(request, "perdritype");
			Assert.notNull(perdritype);
			params.put("perdritype", perdritype);

			String buydate = WebUtils.getParameterValue(request, "buydate");
			Assert.notNull(buydate);
			params.put("buydate", buydate);

			result = provinceTrainingCarSuperviseService.trainingcar(params);
		/*	if(result.getCode()==200){
				try {
					updateService.updatecar(params);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}*/
		} catch (Throwable ex) {
			result.error(ex);
			logger.error("ProvinceTrainingCar api",ex);
		}
		return result;
	}
}
