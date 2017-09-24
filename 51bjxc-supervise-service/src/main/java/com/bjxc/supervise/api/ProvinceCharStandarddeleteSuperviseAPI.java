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
import com.bjxc.supervise.service.ProvinceCharStandarddeleteSuperviseService;

@RestController
@RequestMapping("/province")
public class ProvinceCharStandarddeleteSuperviseAPI {
    private static final Logger logger = LoggerFactory.getLogger(ProvinceCharStandarddeleteSuperviseAPI.class);

    @Resource
    ProvinceCharStandarddeleteSuperviseService provinceCharStandarddeleteSuperviseService;
    @Resource
    DeleteService deleteService;

	@RequestMapping(value="/charstandard/delete",method=RequestMethod.POST)
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

			result = provinceCharStandarddeleteSuperviseService.charstandard(params);
			/*if(result.getCode()==200){
				deleteService.deleteCharStandard(params);
			}*/
		} catch (Throwable ex) {
			result.error(ex);
			logger.error("ProvinceCharStandard api",ex);
		}
		return result;
	}
}
