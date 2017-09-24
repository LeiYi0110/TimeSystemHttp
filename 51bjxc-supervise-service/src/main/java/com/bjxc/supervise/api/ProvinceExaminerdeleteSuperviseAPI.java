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
import com.bjxc.supervise.service.ProvinceExaminerdeleteSuperviseService;

@RestController
@RequestMapping("/province")
public class ProvinceExaminerdeleteSuperviseAPI {
    private static final Logger logger = LoggerFactory.getLogger(ProvinceExaminerdeleteSuperviseAPI.class);

    @Resource
    ProvinceExaminerdeleteSuperviseService provinceExaminerdeleteSuperviseService;
    @Resource
    DeleteService deleteService;

	@RequestMapping(value="/examiner/delete",method=RequestMethod.POST)
	public Result examiner(ServletRequest request ){

		Result result = new Result();

		try
		{
			Map<String,Object> params = new HashMap<String,Object>();
			String examnum = WebUtils.getParameterValue(request, "examnum");
			Assert.notNull(examnum);
			params.put("examnum", examnum);

			result = provinceExaminerdeleteSuperviseService.examiner(params);
			/*if(result.getCode()==200){
				deleteService.deleteExaminer(params);
			}*/
		} catch (Throwable ex) {
			result.error(ex);
			logger.error("ProvinceExaminer api",ex);
		}
		return result;
	}
}
