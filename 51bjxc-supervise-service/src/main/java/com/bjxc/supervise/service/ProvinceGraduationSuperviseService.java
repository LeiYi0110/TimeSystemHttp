package com.bjxc.supervise.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.bjxc.Result;
import com.bjxc.json.JacksonBinder;
import com.bjxc.supervise.http.HttpClientService;
import com.bjxc.supervise.http.crypto.Sign;

/**
 * 全国平台
 * @author Administrator
 *
 */
@Service
public class ProvinceGraduationSuperviseService {
	private Logger logger = LoggerFactory.getLogger(ProvinceGraduationSuperviseService.class);	@Resource
	private HttpClientService httpClientService;
	
	@Value("${bjxc.province.supervise.url}")
	private String provinceSuperviseUrl;
	
	@Value("${bjxc.province.supervise.version}")
	private String version;
	
	@Resource
	private PrivateKeyFactory privateKeyFactory;
	
	public Result graduation(Map<String,Object> params,String pdfid, String esignature) throws Exception{
		long timestamp = new Date().getTime();
		String certsn = privateKeyFactory.getCertsn();
		Sign sign = new Sign();
		
		
		Map<String, Object> esignatureDataMap = params;
		//esignatureDataMap.remove("pdfid");
		//String dataEsignature = JacksonBinder.buildNonDefaultBinder().toJson(esignatureDataMap);
		//String esignature = sign.sign(dataEsignature, timestamp, privateKeyFactory.getPrivateKey());
		
		params.put("esignature", esignature);
		params.put("pdfid", pdfid);
		
		String dataJSON = JacksonBinder.buildNonDefaultBinder().toJson(params);
		String signStr = sign.sign(dataJSON, timestamp, privateKeyFactory.getPrivateKey());
		String url = provinceSuperviseUrl + "/graduation?v=" + version + "&ts=" + timestamp + "&sign=" + signStr +"&user="+certsn;
		//logger.info("Graduation url:" + url);
		Result result = httpClientService.doPostJson(url,dataJSON);
		return result;
	}
}
