package com.bjxc.supervise.service;



import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.bjxc.Result;
import com.bjxc.supervise.http.HttpClientService;
import com.bjxc.supervise.http.crypto.Sign;
import org.apache.commons.io.FileUtils;
@Service
public class UploadFileSuperviseService {
	private Logger logger = LoggerFactory.getLogger(StudentSuperviseService.class);
	
	@Resource
	private HttpClientService httpClientService;
	
	@Value("${bjxc.cuntry.supervise.url}")
	private String countrySuperviseUrl;
	
	@Value("${bjxc.cuntry.supervise.version}")
	private String version;
	
	@Resource
	private PrivateKeyFactory privateKeyFactory;
	
	@Value("${bjxc.test.upload.image}")
	private String  filePath;
	
	

	
	public Result upload(Map<String,Object> params) throws Exception{
		String type = (String)params.get("Type");
		Assert.notNull(type);
		
		File file = new File(filePath);
		
		
		long timestamp = new Date().getTime();
		String certsn = privateKeyFactory.getCertsn();
		Sign sign = new Sign();
		//String dataJSON = JacksonBinder.buildNonDefaultBinder().toJson(params);
		//String signStr = sign.sign(dataJSON, timestamp, privateKeyFactory.getPrivateKey());
		
		byte[] data = getContent(filePath);
		String signStr = sign.sign(data, timestamp, privateKeyFactory.getPrivateKey());
		String url = countrySuperviseUrl + "/imageup/" + type + "?v=" + version + "&ts=" + timestamp + "&sign=" + signStr +"&user="+certsn;
		//logger.info("institution url:" + url);
		
		
		Result result = httpClientService.upload(url, file);//httpClientService.doPostJson(url,dataJSON);
		return result;
	}
	
	public Result uploadFile(Map<String,Object> params) throws Exception{
		String type = (String)params.get("Type");
		Assert.notNull(type);
		
		String fileUrl = (String)params.get("url");
		
		String filePath = generateFile(fileUrl);
		
		File file = new File(filePath);
		
		
		long timestamp = new Date().getTime();
		String certsn = privateKeyFactory.getCertsn();
		Sign sign = new Sign();
		//String dataJSON = JacksonBinder.buildNonDefaultBinder().toJson(params);
		//String signStr = sign.sign(dataJSON, timestamp, privateKeyFactory.getPrivateKey());
		
		byte[] data = getContent(filePath);
		String signStr = sign.sign(data, timestamp, privateKeyFactory.getPrivateKey());
		String url = countrySuperviseUrl + "/imageup/" + type + "?v=" + version + "&ts=" + timestamp + "&sign=" + signStr +"&user="+certsn;
		//logger.info("institution url:" + url);
		
		
		Result result = httpClientService.upload(url, file);//httpClientService.doPostJson(url,dataJSON);
		return result;
	}
	
	public byte[] getContent(String filePath) throws IOException {  
        File file = new File(filePath);  
        long fileSize = file.length();  
        if (fileSize > Integer.MAX_VALUE) {  
            System.out.println("file too big...");  
            return null;  
        }  
        FileInputStream fi = new FileInputStream(file);  
        byte[] buffer = new byte[(int) fileSize];  
        int offset = 0;  
        int numRead = 0;  
        while (offset < buffer.length  
        && (numRead = fi.read(buffer, offset, buffer.length - offset)) >= 0) {  
            offset += numRead;  
        }  
        // 确保所有数据均被读取  
        if (offset != buffer.length) {  
        throw new IOException("Could not completely read file "  
                    + file.getName());  
        }  
        fi.close();  
        return buffer;  
    } 
	
	
	public String generateFile(String fileUrl)throws IOException
	{
		
		
		 //String fileName = "C:\\aaab.png";//String.valueOf((int)(1+Math.random()*(1000000-1+1))); //The file that will be saved on your computer
		String array[] = fileUrl.split("\\.");
		String fileName = String.valueOf((int)(1+Math.random()*(1000000-1+1))) + array[array.length - 1];
		 File file = new File(fileName);
		 FileUtils.copyURLToFile(new URL(fileUrl), file);
		 
		 
		 return fileName;
	}
	

}
