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
import com.bjxc.supervise.service.ProvinceVideoRecordSuperviseService;

@RestController
@RequestMapping("/province")
public class ProvinceVideoRecordSuperviseAPI {
    private static final Logger logger = LoggerFactory.getLogger(ProvinceVideoRecordSuperviseAPI.class);

    @Resource
    ProvinceVideoRecordSuperviseService provinceVideoRecordSuperviseService;
    @Resource
    InsertService insertService;

	@RequestMapping(value="/videorecord",method=RequestMethod.POST)
	public Result videorecord(ServletRequest request ){

		Result result = new Result();

		try
		{
			Map<String,Object> params = new HashMap<String,Object>();
			String devnum = WebUtils.getParameterValue(request, "devnum");
			Assert.notNull(devnum);
			params.put("devnum", devnum);

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

			String recnum = WebUtils.getParameterValue(request, "recnum");
			Assert.notNull(recnum);
			params.put("recnum", recnum);

			String starttime = WebUtils.getParameterValue(request, "starttime");
			Assert.notNull(starttime);
			params.put("starttime", starttime);

			String endtime = WebUtils.getParameterValue(request, "endtime");
			Assert.notNull(endtime);
			params.put("endtime", endtime);

			String event = WebUtils.getParameterValue(request, "event");
			Assert.notNull(event);
			params.put("event", event);

			String fileid = WebUtils.getParameterValue(request, "fileid");
			Assert.notNull(fileid);
			params.put("fileid", fileid);

			result = provinceVideoRecordSuperviseService.videorecord(params);
			/*if(result.getCode()==200){
				insertService.insertVideoRecord(params);
			}*/
		} catch (Throwable ex) {
			result.error(ex);
			logger.error("ProvinceVideoRecord api",ex);
		}
		return result;
	}
}
