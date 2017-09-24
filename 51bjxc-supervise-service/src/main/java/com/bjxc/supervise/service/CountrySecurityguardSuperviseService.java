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
public class CountrySecurityguardSuperviseService {
	private Logger logger = LoggerFactory.getLogger(CountrySecurityguardSuperviseService.class);
	@Resource
	private HttpClientService httpClientService;
	
	@Value("${bjxc.cuntry.supervise.url}")
	private String countrySuperviseUrl;
	
	@Value("${bjxc.cuntry.supervise.version}")
	private String version;
	
	@Resource
	private PrivateKeyFactory privateKeyFactory;
	
	
	public Result securityguard(Map<String,Object> params) throws Exception{
		long timestamp = new Date().getTime();
		String certsn = privateKeyFactory.getCertsn();
		Sign sign = new Sign();
		String dataJSON = JacksonBinder.buildNonDefaultBinder().toJson(params);
		String signStr = sign.sign(dataJSON, timestamp, privateKeyFactory.getPrivateKey());
		String url = countrySuperviseUrl + "/securityguard?v=" + version + "&ts=" + timestamp + "&sign=" + signStr +"&user="+certsn;
		Result result = httpClientService.doPostJson(url,dataJSON);
		return result;
	}
}