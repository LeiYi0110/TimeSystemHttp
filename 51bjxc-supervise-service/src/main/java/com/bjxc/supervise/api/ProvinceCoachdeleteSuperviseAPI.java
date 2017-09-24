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
import com.bjxc.supervise.service.ProvinceCoachdeleteSuperviseService;

@RestController
@RequestMapping("/province")
public class ProvinceCoachdeleteSuperviseAPI {
    private static final Logger logger = LoggerFactory.getLogger(ProvinceCoachdeleteSuperviseAPI.class);

    @Resource
    ProvinceCoachdeleteSuperviseService provinceCoachdeleteSuperviseService;
    @Resource
    DeleteService deleteService;

	@RequestMapping(value="/coach/delete",method=RequestMethod.POST)
	public Result coach(ServletRequest request ){

		Result result = new Result();

		try
		{
			Map<String,Object> params = new HashMap<String,Object>();
			String coachnum = WebUtils.getParameterValue(request, "coachnum");
			Assert.notNull(coachnum);
			params.put("coachnum", coachnum);

			result = provinceCoachdeleteSuperviseService.coach(params);
			/*if(result.getCode()==200){
				deleteService.deleteCoach(params);
			}*/
		} catch (Throwable ex) {
			result.error(ex);
			logger.error("ProvinceCoach api",ex);
		}
		return result;
	}
}
