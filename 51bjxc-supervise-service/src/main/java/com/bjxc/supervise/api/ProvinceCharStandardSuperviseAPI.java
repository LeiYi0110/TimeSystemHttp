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



import com.bjxc.supervise.service.ProvinceCharStandardSuperviseService;
import com.bjxc.supervise.service.UpdateService;

@RestController
@RequestMapping("/province")
public class ProvinceCharStandardSuperviseAPI {
    private static final Logger logger = LoggerFactory.getLogger(ProvinceCharStandardSuperviseAPI.class);

    @Resource
    ProvinceCharStandardSuperviseService provinceCharStandardSuperviseService;
    @Resource
    UpdateService updateService;

	@RequestMapping(value="/charstandard",method=RequestMethod.POST)
	public Result charstandard(ServletRequest request ){

		Result result = new Result();

		try
		{
			Map<String,Object> params = new HashMap<String,Object>();
			String inscode = WebUtils.getParameterValue(request, "inscode");
			Assert.notNull(inscode);
			params.put("inscode", inscode);

			String seq = WebUtils.getParameterValue(request, "seq");
			Assert.notNull(seq);
			params.put("seq", seq);

			String vehicletype = WebUtils.getParameterValue(request, "vehicletype");
			Assert.notNull(vehicletype);
			params.put("vehicletype", vehicletype);

			String trainningmode = WebUtils.getParameterValue(request, "trainningmode");
			params.put("trainningmode", trainningmode);

			String subject = WebUtils.getParameterValue(request, "subject");
			params.put("subject", subject);

			String trainningtime = WebUtils.getParameterValue(request, "trainningtime");
			params.put("trainningtime", trainningtime);

			String chargemode = WebUtils.getParameterValue(request, "chargemode");
			params.put("chargemode", chargemode);

			String paymode = WebUtils.getParameterValue(request, "paymode");
			params.put("paymode", paymode);

			String service = WebUtils.getParameterValue(request, "service");
			params.put("service", service);

			String price = WebUtils.getParameterValue(request, "price");
			Assert.notNull(price);
			params.put("price", price);

			String classcurr = WebUtils.getParameterValue(request, "classcurr");
			Assert.notNull(classcurr);
			params.put("classcurr", classcurr);

			String uptime = WebUtils.getParameterValue(request, "uptime");
			Assert.notNull(uptime);
			params.put("uptime", uptime);

			result = provinceCharStandardSuperviseService.charstandard(params);
		/*	if(result.getCode()==200){
				updateService.updateCharStandard(params);
			}*/
		} catch (Throwable ex) {
			result.error(ex);
			logger.error("ProvinceCharStandard api",ex);
		}
		return result;
	}
}
