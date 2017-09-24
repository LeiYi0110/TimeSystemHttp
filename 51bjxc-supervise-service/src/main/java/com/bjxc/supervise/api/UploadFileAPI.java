package com.bjxc.supervise.api;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.xml.crypto.KeySelector.Purpose;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bjxc.Result;
import com.bjxc.supervise.service.ProvinceUploadFileSuperviseService;
import com.bjxc.supervise.service.UploadFileSuperviseService;
import com.bjxc.web.utils.WebUtils;

@RestController
@RequestMapping("/upload")
public class UploadFileAPI {
	private static final Logger logger = LoggerFactory.getLogger(UploadFileAPI.class);
	
	@Resource
	private UploadFileSuperviseService service;
	
	@Resource
	private ProvinceUploadFileSuperviseService provinceService;
	
	
	@RequestMapping(value="/file/url",method=RequestMethod.POST)
	public Result uploadFile(ServletRequest request ){
		
		//目前备案文件上传，先从我们的应用服务器上传到接口服务器，然后从接口服务器上传到保存到本地获取路径,最后再上传
		
		Result result = new Result();
		try {
			
			String type = WebUtils.getParameterValue(request, "type");
			String url = WebUtils.getParameterValue(request, "url");
			String level = WebUtils.getParameterValue(request, "level");
			
			
			Map<String,Object> params = new HashMap<String,Object>();

			//params.put("Type", "stufp");
			params.put("Type", type);
			params.put("url", url);
			//params.put("level", level);
			if (level.equals("1")) {
				result = service.uploadFile(params);
			}else if (level.equals("2")) {  //省文档上传
				result = provinceService.uploadFile(params);
			}
			
		} catch (Throwable ex) {
			result.error(ex);
			logger.error("文件上传接口调用错误/file/url:",ex);
		}
		return result;
	}

}
