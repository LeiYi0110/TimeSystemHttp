package com.bjxc.supervise.api;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;

import org.apache.commons.fileupload.disk.DiskFileItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.bjxc.Result;
import com.bjxc.supervise.service.UploadFileSuperviseService;
import com.bjxc.web.utils.WebUtils;

@RestController
@RequestMapping("/upload")
public class UploadFileSuperviseAPI {
	private static final Logger logger = LoggerFactory.getLogger(UploadFileSuperviseAPI.class);
	@Resource
	private UploadFileSuperviseService service;
	@RequestMapping(value="/file",method=RequestMethod.POST)
	public Result uploadFile(ServletRequest request ){
		Result result = new Result();
		try {
			
			String type = WebUtils.getParameterValue(request, "type");
			MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request; 
			MultipartFile file = multipartRequest.getFile("ifile");  
			CommonsMultipartFile cf= (CommonsMultipartFile)file;  
			DiskFileItem fi = (DiskFileItem)cf.getFileItem();  
			File file2=fi.getStoreLocation();
			
			Map<String,Object> params = new HashMap<String,Object>();
			params.put("file", file2);
			//params.put("Type", "stufp");
			params.put("Type", type);
			result = service.upload(params);
		} catch (Throwable ex) {
			result.error(ex);
			logger.error("getCoachInfo api  ",ex);
		}
		return result;
	}

}
