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
import com.bjxc.supervise.service.ProvinceComplaintSuperviseService;

@RestController
@RequestMapping("/province")
public class ProvinceComplaintSuperviseAPI {
    private static final Logger logger = LoggerFactory.getLogger(ProvinceComplaintSuperviseAPI.class);

    @Resource
    ProvinceComplaintSuperviseService provinceComplaintSuperviseService;
    
    @Resource
	InsertService insertService;
    
	@RequestMapping(value="/complaint",method=RequestMethod.POST)
	public Result complaint(ServletRequest request ){

		Result result = new Result();

		try
		{
			Map<String,Object> params = new HashMap<String,Object>();
			String stunum = WebUtils.getParameterValue(request, "stunum");
			Assert.notNull(stunum);
			params.put("stunum", stunum);

			String type = WebUtils.getParameterValue(request, "type");
			Assert.notNull(type);
			params.put("type", type);

			String objenum = WebUtils.getParameterValue(request, "objenum");
			Assert.notNull(objenum);
			params.put("objenum", objenum);

			String cdate = WebUtils.getParameterValue(request, "cdate");
			Assert.notNull(cdate);
			params.put("cdate", cdate);

			String content = WebUtils.getParameterValue(request, "content");
			Assert.notNull(content);
			params.put("content", content);

			String depaopinion = WebUtils.getParameterValue(request, "depaopinion");
			params.put("depaopinion", depaopinion);

			String schopinion = WebUtils.getParameterValue(request, "schopinion");
			params.put("schopinion", schopinion);

			result = provinceComplaintSuperviseService.complaint(params);
			/*if(result.getCode()==200){
				
				try {
					insertService.addComplaint(params);
				} catch (Exception e) {
				}
			}*/
		} catch (Throwable ex) {
			result.error(ex);
			logger.error("ProvinceComplaint api",ex);
		}
		return result;
	}
}
