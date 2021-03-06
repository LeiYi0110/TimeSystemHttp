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
import com.fasterxml.jackson.core.io.SegmentedStringWriter;

import java.net.URLEncoder;

/**
 * 全国平台
 * @author Administrator
 *
 */
@Service
public class StuinfoService {
	private Logger logger = LoggerFactory.getLogger(StuinfoService.class);
	@Resource
	private HttpClientService httpClientService;
	
	@Value("${bjxc.cuntry.supervise.stuinfo.url}")
	private String countrySuperviseUrl;
	
	@Value("${bjxc.cuntry.supervise.version}")
	private String version;
	
	@Resource
	private PrivateKeyFactory privateKeyFactory;
	
	
	public Result coach(Map<String,Object> params) throws Exception{
		long timestamp = new Date().getTime();
		String certsn = privateKeyFactory.getCertsn();
		Sign sign = new Sign();
		//String dataJSON = JacksonBinder.buildNonDefaultBinder().toJson(params);
		String dataJSON = params.get("cardnum").toString() + params.get("name").toString();
		String signStr = sign.sign(dataJSON, timestamp, privateKeyFactory.getPrivateKey());

		
		String name = params.get("name").toString();
		String url =countrySuperviseUrl+"/"+params.get("cardnum").toString()+"-stuinfo-"+ name + "?v=" + version + "&ts=" + timestamp + "&sign=" + signStr +"&user="+certsn;
		
		//logger.info("Stuinfo url:" + url);
		//Result result = httpClientService.doPostJson(url,dataJSON);
		
		Result result = httpClientService.doGet(url);
		
		return result;
	}
}
