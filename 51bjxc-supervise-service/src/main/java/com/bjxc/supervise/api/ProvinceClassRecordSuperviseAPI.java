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
import com.bjxc.supervise.service.ProvinceClassRecordSuperviseService;

@RestController
@RequestMapping("/province")
public class ProvinceClassRecordSuperviseAPI {
    private static final Logger logger = LoggerFactory.getLogger(ProvinceClassRecordSuperviseAPI.class);

    @Resource
    ProvinceClassRecordSuperviseService provinceClassRecordSuperviseService;

    @Resource
    InsertService insertService;
	@RequestMapping(value="/classrecord",method=RequestMethod.POST)
	public Result classrecord(ServletRequest request ){

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

			String coachnum = WebUtils.getParameterValue(request, "coachnum");
			params.put("coachnum", coachnum);

			String carnum = WebUtils.getParameterValue(request, "carnum");
			params.put("carnum", carnum);

			String simunum = WebUtils.getParameterValue(request, "simunum");
			params.put("simunum", simunum);

			String platnum = WebUtils.getParameterValue(request, "platnum");
			Assert.notNull(platnum);
			params.put("platnum", platnum);

			String recnum = WebUtils.getParameterValue(request, "recnum");
			Assert.notNull(recnum);
			params.put("recnum", recnum);

			String subjcode = WebUtils.getParameterValue(request, "subjcode");
			Assert.notNull(subjcode);
			params.put("subjcode", subjcode);

			String photo1 = WebUtils.getParameterValue(request, "photo1");
			Assert.notNull(photo1);
			params.put("photo1", photo1);

			String photo2 = WebUtils.getParameterValue(request, "photo2");
			params.put("photo2", photo2);

			String photo3 = WebUtils.getParameterValue(request, "photo3");
			Assert.notNull(photo3);
			params.put("photo3", photo3);

			String starttime = WebUtils.getParameterValue(request, "starttime");
			Assert.notNull(starttime);
			params.put("starttime", starttime);

			String endtime = WebUtils.getParameterValue(request, "endtime");
			Assert.notNull(endtime);
			params.put("endtime", endtime);

			String duration = WebUtils.getParameterValue(request, "duration");
			Assert.notNull(duration);
			params.put("duration", duration);

			String mileage = WebUtils.getParameterValue(request, "mileage");
			Assert.notNull(mileage);
			params.put("mileage", mileage);

			String avevelocity = WebUtils.getParameterValue(request, "avevelocity");
			params.put("avevelocity", avevelocity);

			String coacmt = WebUtils.getParameterValue(request, "coacmt");
			params.put("coacmt", coacmt);

			String total = WebUtils.getParameterValue(request, "total");
			Assert.notNull(total);
			params.put("total", total);

			String part1 = WebUtils.getParameterValue(request, "part1");
			Assert.notNull(part1);
			params.put("part1", part1);

			String part2 = WebUtils.getParameterValue(request, "part2");
			Assert.notNull(part2);
			params.put("part2", part2);

			String part3 = WebUtils.getParameterValue(request, "part3");
			Assert.notNull(part3);
			params.put("part3", part3);

			String part4 = WebUtils.getParameterValue(request, "part4");
			Assert.notNull(part4);
			params.put("part4", part4);

			result = provinceClassRecordSuperviseService.classrecord(params);
		/*	if(result.getCode()==200){
				try{
					insertService.classrecord(params);
				}catch (Exception e) {
				}
				
			}*/
		} catch (Throwable ex) {
			result.error(ex);
			logger.error("ProvinceClassRecord api",ex);
		}
		return result;
	}
}
