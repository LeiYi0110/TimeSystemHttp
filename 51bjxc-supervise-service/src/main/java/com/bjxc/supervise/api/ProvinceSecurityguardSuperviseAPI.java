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
import com.bjxc.supervise.service.ProvinceSecurityguardSuperviseService;
import com.bjxc.supervise.service.UpdateService;

@RestController
@RequestMapping("/province")
public class ProvinceSecurityguardSuperviseAPI {
    private static final Logger logger = LoggerFactory.getLogger(ProvinceSecurityguardSuperviseAPI.class);

    @Resource
    ProvinceSecurityguardSuperviseService provinceSecurityguardSuperviseService;
    @Resource
    UpdateService updateService;

	@RequestMapping(value="/securityguard",method=RequestMethod.POST)
	public Result securityguard(ServletRequest request ){

		Result result = new Result();

		try
		{
			Map<String,Object> params = new HashMap<String,Object>();
			String inscode = WebUtils.getParameterValue(request, "inscode");
			Assert.notNull(inscode);
			params.put("inscode", inscode);

			String secunum = WebUtils.getParameterValue(request, "secunum");
			Assert.notNull(secunum);
			params.put("secunum", secunum);

			String name = WebUtils.getParameterValue(request, "name");
			Assert.notNull(name);
			params.put("name", name);

			String sex = WebUtils.getParameterValue(request, "sex");
			Assert.notNull(sex);
			params.put("sex", sex);

			String idcard = WebUtils.getParameterValue(request, "idcard");
			Assert.notNull(idcard);
			params.put("idcard", idcard);

			String mobile = WebUtils.getParameterValue(request, "mobile");
			Assert.notNull(mobile);
			params.put("mobile", mobile);

			String address = WebUtils.getParameterValue(request, "address");
			params.put("address", address);

			String photo = WebUtils.getParameterValue(request, "photo");
			Assert.notNull(photo);
			params.put("photo", photo);

			String fingerprint = WebUtils.getParameterValue(request, "fingerprint");
			params.put("fingerprint", fingerprint);

			String drilicence = WebUtils.getParameterValue(request, "drilicence");
			params.put("drilicence", drilicence);

			String fstdrilicdate = WebUtils.getParameterValue(request, "fstdrilicdate");
			params.put("fstdrilicdate", fstdrilicdate);

			String dripermitted = WebUtils.getParameterValue(request, "dripermitted");
			params.put("dripermitted", dripermitted);

			String teachpermitted = WebUtils.getParameterValue(request, "teachpermitted");
			params.put("teachpermitted", teachpermitted);

			String employstatus = WebUtils.getParameterValue(request, "employstatus");
			Assert.notNull(employstatus);
			params.put("employstatus", employstatus);

			String hiredate = WebUtils.getParameterValue(request, "hiredate");
			Assert.notNull(hiredate);
			params.put("hiredate", hiredate);

			String leavedate = WebUtils.getParameterValue(request, "leavedate");
			params.put("leavedate", leavedate);

			result = provinceSecurityguardSuperviseService.securityguard(params);
			/*if(result.getCode()==200){
				updateService.updateSecurity(params);
			}*/
		} catch (Throwable ex) {
			result.error(ex);
			logger.error("ProvinceSecurityguard api",ex);
		}
		return result;
	}
}
