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
import com.bjxc.supervise.service.ProvinceSuperviseService;
import com.bjxc.supervise.service.UpdateService;
import com.bjxc.web.utils.WebUtils;

@RestController
@RequestMapping("/province")
public class ProvinceSuperviseAPI {
	private static final Logger logger = LoggerFactory.getLogger(ProvinceSuperviseAPI.class);
	
	@Resource
	private ProvinceSuperviseService provinceSuperviseService;
	@Resource
	private UpdateService updateService;
	
	/**
	 * 6.2.1.1
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/institution",method=RequestMethod.POST)
	public Result institution(ServletRequest request ){
		Result result = new Result();
		try {
			Map<String,Object> params = new HashMap<String,Object>();
			String inscode  = WebUtils.getParameterValue(request, "inscode");
			Assert.notNull(inscode);
			params.put("inscode", inscode);
			
			String district = WebUtils.getParameterValue(request, "district");
			Assert.notNull(district);
			params.put("district", district);
			String name = WebUtils.getParameterValue(request, "name");
			Assert.notNull(name);
			params.put("name", name);
			String shortname = WebUtils.getParameterValue(request, "shortname");
			Assert.notNull(shortname);
			params.put("shortname", shortname);
			String licnum = WebUtils.getParameterValue(request, "licnum");
			Assert.notNull(licnum);
			params.put("licnum", licnum);
			String licetime = WebUtils.getParameterValue(request, "licetime");
			Assert.notNull(licetime);
			params.put("licetime", licetime);
			String business = WebUtils.getParameterValue(request, "business");
			Assert.notNull(business);
			params.put("business", business);
			String creditcode = WebUtils.getParameterValue(request, "creditcode");
			if(creditcode != null){
				params.put("creditcode", creditcode);
			}
			String address = WebUtils.getParameterValue(request, "address");
			Assert.notNull(address);
			params.put("address", address);
			String postcode = WebUtils.getParameterValue(request, "postcode");
			Assert.notNull(postcode);
			params.put("postcode", postcode);
			String legal = WebUtils.getParameterValue(request, "legal");
			Assert.notNull(legal);
			params.put("legal", legal);
			String contact = WebUtils.getParameterValue(request, "contact");
			Assert.notNull(contact);
			params.put("contact", contact);
			String phone = WebUtils.getParameterValue(request, "phone");
			Assert.notNull(phone);
			params.put("phone", phone);
			String busiscope = WebUtils.getParameterValue(request, "busiscope");
			Assert.notNull(busiscope);
			params.put("busiscope", busiscope);
			String busistatus = WebUtils.getParameterValue(request, "busistatus");
			Assert.notNull(busistatus);
			params.put("busistatus", busistatus);
			String level = WebUtils.getParameterValue(request, "level");
			Assert.notNull(level);
			params.put("level", level);
			
			Integer coachnumber = WebUtils.getParameterIntegerValue(request, "coachnumber");
			Assert.notNull(coachnumber);
			params.put("coachnumber", coachnumber);
			Integer grasupvnum = WebUtils.getParameterIntegerValue(request, "grasupvnum");
			Assert.notNull(grasupvnum);
			params.put("grasupvnum", grasupvnum);
			Integer safmngnum = WebUtils.getParameterIntegerValue(request, "safmngnum");
			Assert.notNull(safmngnum);
			params.put("safmngnum", safmngnum);
			

			Integer tracarnum = WebUtils.getParameterIntegerValue(request, "tracarnum");
			Assert.notNull(tracarnum);
			params.put("tracarnum", tracarnum);
			
			Integer classroom = WebUtils.getParameterIntegerValue(request, "classroom");
			if(classroom != null){
				params.put("classroom", classroom);
			}
			Integer thclassroom = WebUtils.getParameterIntegerValue(request, "thclassroom");
			if(thclassroom != null){
				params.put("thclassroom", thclassroom);
			}
			Integer praticefield = WebUtils.getParameterIntegerValue(request, "praticefield");
			Assert.notNull(praticefield);
			params.put("praticefield", praticefield);
			
			
			result = provinceSuperviseService.institution(params);
			/*if(result.getCode()==200){
				updateService.updateInstitution(params);
			}*/
		} catch (Throwable ex) {
			result.error(ex);
			logger.error("getCoachInfo api  ",ex);
		}
		return result;
	}
}
