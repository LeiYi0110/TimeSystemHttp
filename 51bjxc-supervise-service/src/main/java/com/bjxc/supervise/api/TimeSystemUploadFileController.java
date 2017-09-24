package com.bjxc.supervise.api;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.disk.DiskFileItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

import com.bjxc.supervise.TimeSystemResult;
import com.bjxc.supervise.service.TimeSystemUploadFileService;

/**
 * 计时系统文档上传接口
 *
 */

@RestController
public class TimeSystemUploadFileController {
	private static final Logger logger = LoggerFactory.getLogger(TimeSystemUploadFileController.class);
	
	@Resource
	TimeSystemUploadFileService service;
	
	@RequestMapping(value="/imageup/{type}",method=RequestMethod.POST)
	public TimeSystemResult imageUp(HttpServletRequest request,@PathVariable("type")String type)
	{
		// mod by Levin,20161226
		// 1、增加日志输出
		// 2、修改审核通知逻辑，先接受到备案通知，然后再去省平台查询备案结果，最后再更新计时平台数据库
		logger.info("开始调用接口:" + request.getRequestURL());
		logger.info("访问来源:" + request.getRemoteAddr());
		
		TimeSystemResult result = new TimeSystemResult();
		try
		{
			//String type = WebUtils.getParameterValue(request, "type");
			
			MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request; 
			
			//HttpServletRequest originalRequest = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
			//MultipartHttpServletRequest multipartRequest = new DefaultMultipartHttpServletRequest(request);
			
			MultipartFile file = multipartRequest.getFile("file");  
			Map<String,Object> params = new HashMap<String,Object>();
			params.put("file", file);
			params.put("type", type);
			
			logger.info("file=" + file.getOriginalFilename());
			logger.info("type=" + type);

			result = service.upload(params);
			
		}
		catch (Exception e) {
			logger.info("调用计时平台上传接口失败."+e.toString());
		}
		return result;
	}

}
