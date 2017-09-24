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
import com.bjxc.supervise.service.ProvinceStageTrainningTimeSuperviseService;

import net.sf.json.JSONArray;  

@RestController
@RequestMapping("/province")
public class ProvinceStageTrainningTimeSuperviseAPI {
    private static final Logger logger = LoggerFactory.getLogger(ProvinceStageTrainningTimeSuperviseAPI.class);

    @Resource
    ProvinceStageTrainningTimeSuperviseService provinceStageTrainningTimeSuperviseService;

    @Resource
    InsertService insertService;
    
	@RequestMapping(value="/stagetrainningtime",method=RequestMethod.POST)
	public Result stagetrainningtime(ServletRequest request ){

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

			String subject = WebUtils.getParameterValue(request, "subject");
			Assert.notNull(subject);
			params.put("subject", subject);

			String totaltime = WebUtils.getParameterValue(request, "totaltime");
			Assert.notNull(totaltime);
			params.put("totaltime", totaltime);

			String vehicletime = WebUtils.getParameterValue(request, "vehicletime");
			params.put("vehicletime", vehicletime);

			String classtime = WebUtils.getParameterValue(request, "classtime");
			params.put("classtime", classtime);

			String simulatortime = WebUtils.getParameterValue(request, "simulatortime");
			params.put("simulatortime", simulatortime);

			String networktime = WebUtils.getParameterValue(request, "networktime");
			params.put("networktime", networktime);

			String duration = WebUtils.getParameterValue(request, "duration");
			Assert.notNull(duration);
			params.put("duration", duration);

			String examresult = WebUtils.getParameterValue(request, "examresult");
			Assert.notNull(examresult);
			params.put("examresult", examresult);

			String mileage = WebUtils.getParameterValue(request, "mileage");
			params.put("mileage", mileage);
			
			//String pdfid = WebUtils.getParameterValue(request, "pdfid");
			
			
			String pdfid = WebUtils.getParameterValue(request, "pdfid");
			//params.put("pdfid", pdfid);
			
			
			String esignature = WebUtils.getParameterValue(request, "esignature");
			Assert.notNull(esignature);
			//params.put("esignature", esignature);
			

			String rectype = WebUtils.getParameterValue(request, "rectype");
			Assert.notNull(rectype);
			params.put("rectype", rectype);

			String recarray = WebUtils.getParameterValue(request, "recarray");
			
			JSONArray jsonArray = JSONArray.fromObject(recarray);
			Assert.notNull(jsonArray);
			params.put("recarray", jsonArray);

			/*
			String rnum = WebUtils.getParameterValue(request, "rnum");
			Assert.notNull(rnum);
			params.put("rnum", rnum);
			*/



			result = provinceStageTrainningTimeSuperviseService.stagetrainningtime(params,pdfid,esignature);
			/*if(result.getCode()==200){
			try {
				insertService.addstagetrainningtime(params);
			} catch (Exception e) {
			}
			}*/
		} catch (Throwable ex) {
			result.error(ex);
			logger.error("ProvinceStageTrainningTime api",ex);
		}
		return result;
	}
}
