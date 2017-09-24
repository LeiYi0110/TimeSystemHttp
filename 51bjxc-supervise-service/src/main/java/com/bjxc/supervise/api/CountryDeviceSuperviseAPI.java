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



import com.bjxc.supervise.service.CountryDeviceSuperviseService;
import com.bjxc.supervise.service.InsertService;

@RestController
@RequestMapping("/country")
public class CountryDeviceSuperviseAPI {
    private static final Logger logger = LoggerFactory.getLogger(CountryDeviceSuperviseAPI.class);

    @Resource
    CountryDeviceSuperviseService countryDeviceSuperviseService;
    
    @Resource
	InsertService insertService;

	@RequestMapping(value="/device",method=RequestMethod.POST)
	public Result device(ServletRequest request ){

		Result result = new Result();

		try
		{
			Map<String,Object> params = new HashMap<String,Object>();
			String termtype = WebUtils.getParameterValue(request, "termtype");
			Assert.notNull(termtype);
			params.put("termtype", termtype);

			String vender = WebUtils.getParameterValue(request, "vender");
			Assert.notNull(vender);
			params.put("vender", vender);

			String model = WebUtils.getParameterValue(request, "model");
			Assert.notNull(model);
			params.put("model", model);

			String imei = WebUtils.getParameterValue(request, "imei");
			Assert.notNull(imei);
			params.put("imei", imei);

			String sn = WebUtils.getParameterValue(request, "sn");
			Assert.notNull(sn);
			params.put("sn", sn);

			result = countryDeviceSuperviseService.device(params);
	/*		System.out.println(result.getMessage());
			if(result.getCode()==200){
				System.out.println(result.getData().toString());
				String str=result.getData().toString();
				String strs[]=str.split(",");
				if(strs.length==5){	//	第一次新增有message，长度五位，以后重复点击4位，取第一次点击
					String passwd=strs[1].split("=")[1];
					String devnum=strs[3].split("=")[1];
					String key=strs[4].substring(5,strs[4].length()-1);
					params.put("passwd", passwd);
					params.put("devnum", devnum);
					params.put("key", key);
					insertService.addDevice(params);
				}
				
			}*/
		} catch (Throwable ex) {
			result.error(ex);
			logger.error("CountryDevice api",ex);
		}
		return result;
	}
}
