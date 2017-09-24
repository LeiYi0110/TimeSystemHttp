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
import com.bjxc.supervise.service.ProvinceTrainimgInfoSuperviseService;
import com.bjxc.supervise.service.UpdateService;

@RestController
@RequestMapping("/province")
public class ProvinceTrainimgInfoSuperviseAPI {
    private static final Logger logger = LoggerFactory.getLogger(ProvinceTrainimgInfoSuperviseAPI.class);

    @Resource
    ProvinceTrainimgInfoSuperviseService provinceTrainimgInfoSuperviseService;
    @Resource
    InsertService insertService;

	@RequestMapping(value="/trainimginfo",method=RequestMethod.POST)
	public Result trainimginfo(ServletRequest request ){

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

			String subjcode = WebUtils.getParameterValue(request, "subjcode");
			Assert.notNull(subjcode);
			params.put("subjcode", subjcode);

			String platnum = WebUtils.getParameterValue(request, "platnum");
			Assert.notNull(platnum);
			params.put("platnum", platnum);

			String recnum = WebUtils.getParameterValue(request, "recnum");
			Assert.notNull(recnum);
			params.put("recnum", recnum);

			String ptime = WebUtils.getParameterValue(request, "ptime");
			Assert.notNull(ptime);
			params.put("ptime", ptime);

			String fileid = WebUtils.getParameterValue(request, "fileid");
			Assert.notNull(fileid);
			params.put("fileid", fileid);

			result = provinceTrainimgInfoSuperviseService.trainimginfo(params);
			/*if(result.getCode()==200){
				insertService.addTrainimgInfo(params);
			}*/
		} catch (Throwable ex) {
			result.error(ex);
			logger.error("ProvinceTrainimgInfo api",ex);
		}
		return result;
	}
}
