package com.bjxc.supervise.service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.commons.fileupload.disk.DiskFileItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.bjxc.Result;
import com.bjxc.supervise.TimeSystemFile;
import com.bjxc.supervise.TimeSystemResult;
import com.bjxc.supervise.http.HttpClientService;
import com.bjxc.supervise.mapper.FileMapper;

@Service
public class TimeSystemUploadFileService {
	
	@Value("${bjxc.upload.image.path}")
	private String  path;
	
	@Resource
	private HttpClientService httpClientService;
	
	@Value("${bjxc.upload.image.url}")
	private String  url;
	
	@Resource
	private FileMapper fileMapper;
	
	
	private static final Logger logger = LoggerFactory.getLogger(TimeSystemUploadFileService.class);
	
	/**
	 * 计时平台文件上传接口，供省平台其其他地方使用。
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public TimeSystemResult upload(Map<String,Object> params) throws Exception{
		TimeSystemResult result = new TimeSystemResult();
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd/");
		String timePath=format.format(new Date());
		
		///usr/local/nginx/html/image/
		//Step1：按日期建立建立目录
		String filePath = path + timePath;
		File folder=new File(filePath);
		if(!folder.exists()){                     //创建文件夹
			folder.mkdirs();
		}
		
		//接受上传的文件
		MultipartFile file = (MultipartFile)params.get("file");
		
		String _fileName = file.getOriginalFilename();
		
		//String fileName = UUID.randomUUID() + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")) ;
		//应该不会超过127位，太长截取最后一段
		int len = _fileName.lastIndexOf(".");
		if(len>1){
			_fileName=_fileName.substring(len);
		}else{
			_fileName = getFileType(params.get("type").toString());
		}
		String fileName = UUID.randomUUID() + _fileName;
		
		//保存文件
		File destFile = new File(filePath + fileName);
		
		CommonsMultipartFile cf= (CommonsMultipartFile)file;  
		DiskFileItem fi = (DiskFileItem)cf.getFileItem();  
		File file2=fi.getStoreLocation();
		file2.renameTo(destFile);
		
		logger.info("接收文件成功:"+file2.getAbsolutePath());
		
		TimeSystemFile timeSystemFile = new TimeSystemFile();
		timeSystemFile.setUrl(url + timePath + fileName);
		String type = params.get("type").toString();
		timeSystemFile.setType(type);
		Integer id = fileMapper.addFile(timeSystemFile);
		
		Map<String, Integer> map = new HashMap<String,Integer>();
		map.put("id", timeSystemFile.getId());
		logger.info("上传文件ID:"+timeSystemFile.getId());
		logger.info("上传文件访问路径：" + timeSystemFile.getUrl());
		result.success(map);
		return result;
		
	}
	
	/**
	 * 默认文件后缀方法
	 * @param type
	 * @return
	 */
	private static String getFileType(String type){
		if(type.contains("pdf")){
			return ".pdf";
		}
		if(type.contains("video")){
			return ".mp4";
		}
		return ".jpg";
	}

}
