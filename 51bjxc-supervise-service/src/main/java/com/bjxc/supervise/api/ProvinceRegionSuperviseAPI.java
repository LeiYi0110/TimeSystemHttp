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
import com.bjxc.supervise.service.ProvinceRegionSuperviseService;
import com.bjxc.supervise.service.UpdateService;

@RestController
@RequestMapping("/province")
public class ProvinceRegionSuperviseAPI {
    private static final Logger logger = LoggerFactory.getLogger(ProvinceRegionSuperviseAPI.class);

    @Resource
    ProvinceRegionSuperviseService provinceRegionSuperviseService;

	@Resource
	InsertService insertService;
	@Resource
	UpdateService  updateService;
    
	@RequestMapping(value="/region",method=RequestMethod.POST)
	public Result region(ServletRequest request ){

		
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

			String name = WebUtils.getParameterValue(request, "name");
			params.put("name", name);

			String address = WebUtils.getParameterValue(request, "address");
			Assert.notNull(address);
			params.put("address", address);

			String area = WebUtils.getParameterValue(request, "area");
			Assert.notNull(area);
			params.put("area", area);

			String type = WebUtils.getParameterValue(request, "type");
			Assert.notNull(type);
			params.put("type", type);

			String vehicletype = WebUtils.getParameterValue(request, "vehicletype");
			Assert.notNull(vehicletype);
			params.put("vehicletype", vehicletype);

			String polygon = WebUtils.getParameterValue(request, "polygon");
			Assert.notNull(polygon);
			params.put("polygon", polygon);

			String totalvehnum = WebUtils.getParameterValue(request, "totalvehnum");
			params.put("totalvehnum", totalvehnum);

			String curvehnum = WebUtils.getParameterValue(request, "curvehnum");
			params.put("curvehnum", curvehnum);

	
			result = provinceRegionSuperviseService.region(params);

				
		} catch (Exception ex) {
			result.error(ex);
			logger.error("ProvinceRegion api",ex);
		}
		return result;
	}
}
