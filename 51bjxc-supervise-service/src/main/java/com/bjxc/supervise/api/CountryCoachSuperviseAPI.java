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



import com.bjxc.supervise.service.CountryCoachSuperviseService;
import com.bjxc.supervise.service.InsertService;

@RestController
@RequestMapping("/country")
public class CountryCoachSuperviseAPI {
    private static final Logger logger = LoggerFactory.getLogger(CountryCoachSuperviseAPI.class);

    @Resource
    CountryCoachSuperviseService countryCoachSuperviseService;
    
    @Resource
	InsertService insertService;

	@RequestMapping(value="/coach",method=RequestMethod.POST)
	public Result coach(ServletRequest request ){
		Result result = new Result();
		try
		{
			Map<String,Object> params = new HashMap<String,Object>();
			String inscode = WebUtils.getParameterValue(request, "inscode");
			Assert.notNull(inscode);
			params.put("inscode", inscode);

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
			Assert.notNull(drilicence);
			params.put("drilicence", drilicence);

			String fstdrilicdate = WebUtils.getParameterValue(request, "fstdrilicdate");
			Assert.notNull(fstdrilicdate);
			params.put("fstdrilicdate", fstdrilicdate);

			String occupationno = WebUtils.getParameterValue(request, "occupationno");
			params.put("occupationno", occupationno);

			String occupationlevel = WebUtils.getParameterValue(request, "occupationlevel");
			params.put("occupationlevel", occupationlevel);

			String dripermitted = WebUtils.getParameterValue(request, "dripermitted");
			Assert.notNull(dripermitted);
			params.put("dripermitted", dripermitted);

			String teachpermitted = WebUtils.getParameterValue(request, "teachpermitted");
			Assert.notNull(teachpermitted);
			params.put("teachpermitted", teachpermitted);

			String employstatus = WebUtils.getParameterValue(request, "employstatus");
			Assert.notNull(employstatus);
			params.put("employstatus", employstatus);

			String hiredate = WebUtils.getParameterValue(request, "hiredate");
			Assert.notNull(hiredate);
			params.put("hiredate", hiredate);

			String leavedate = WebUtils.getParameterValue(request, "leavedate");
			params.put("leavedate", leavedate);

			result = countryCoachSuperviseService.coach(params);
			/*if(result.getCode()==200){
				if(result.getData()!=null){
				String str=result.getData().toString();
				String strs[]=str.split("=");
				String strss[]=strs[1].split("}");
				params.put("coachnum", strss[0]);
				try {
					insertService.addCoach(params);
				} catch (Exception e) {
				}
				}else{
					result.error(result.getMessage());
				}
			}*/
		} catch (Throwable ex) {
			result.error(ex);
			logger.error("CountryCoach api",ex);
		}
		return result;
	}
	
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public Result login(ServletRequest request ){
		Result result = new Result();
		try {
			Integer type=WebUtils.getParameterIntegerValue(request, "type");
			
			Map<String,Object> params = new HashMap<String,Object>();
			String name = WebUtils.getParameterValue(request, "name");
			Assert.notNull(name);
			params.put("name", name);
			
			String district = WebUtils.getParameterValue(request, "district");
			Assert.notNull(district);
			params.put("district", district);
			
			String licnum = WebUtils.getParameterValue(request, "licnum");
			Assert.notNull(licnum);
			params.put("licnum", licnum);
			result=countryCoachSuperviseService.login(params, type);
		}catch (Exception e){
			
		}
		return result;
	}
}
