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



import com.bjxc.supervise.service.CountryStudentSuperviseService;

@RestController
@RequestMapping("/country")
public class CountryStudentSuperviseAPI {
    private static final Logger logger = LoggerFactory.getLogger(CountryStudentSuperviseAPI.class);

    @Resource
    CountryStudentSuperviseService countryStudentSuperviseService;

	@RequestMapping(value="/student",method=RequestMethod.POST)
	public Result student(ServletRequest request ){

		Result result = new Result();

		try
		{
			Map<String,Object> params = new HashMap<String,Object>();
			String inscode = WebUtils.getParameterValue(request, "inscode");
			Assert.notNull(inscode);
			params.put("inscode", inscode);

			String cardtype = WebUtils.getParameterValue(request, "cardtype");
			Assert.notNull(cardtype);
			params.put("cardtype", cardtype);

			String idcard = WebUtils.getParameterValue(request, "idcard");
			Assert.notNull(idcard);
			params.put("idcard", idcard);

			String nationality = WebUtils.getParameterValue(request, "nationality");
			Assert.notNull(nationality);
			params.put("nationality", nationality);

			String name = WebUtils.getParameterValue(request, "name");
			Assert.notNull(name);
			params.put("name", name);

			String sex = WebUtils.getParameterValue(request, "sex");
			Assert.notNull(sex);
			params.put("sex", sex);

			String phone = WebUtils.getParameterValue(request, "phone");
			Assert.notNull(phone);
			params.put("phone", phone);

			String address = WebUtils.getParameterValue(request, "address");
			params.put("address", address);

			String photo = WebUtils.getParameterValue(request, "photo");
			Assert.notNull(photo);
			params.put("photo", photo);

			String fingerprint = WebUtils.getParameterValue(request, "fingerprint");
			params.put("fingerprint", fingerprint);

			String busitype = WebUtils.getParameterValue(request, "busitype");
			Assert.notNull(busitype);
			params.put("busitype", busitype);

			String drilicnum = WebUtils.getParameterValue(request, "drilicnum");
			params.put("drilicnum", drilicnum);

			String fstdrilicdate = WebUtils.getParameterValue(request, "fstdrilicdate");
			params.put("fstdrilicdate", fstdrilicdate);

			String perdritype = WebUtils.getParameterValue(request, "perdritype");
			params.put("perdritype", perdritype);

			String traintype = WebUtils.getParameterValue(request, "traintype");
			Assert.notNull(traintype);
			params.put("traintype", traintype);

			String applydate = WebUtils.getParameterValue(request, "applydate");
			Assert.notNull(applydate);
			params.put("applydate", applydate);

			result = countryStudentSuperviseService.student(params);
		} catch (Throwable ex) {
			result.error(ex);
			logger.error("CountryStudent api",ex);
		}
		return result;
	}
}
