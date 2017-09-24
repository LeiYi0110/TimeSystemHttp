package com.bjxc.supervise.service;

import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.bjxc.Result;
import com.bjxc.json.JacksonBinder;
import com.bjxc.supervise.http.HttpClientService;
import com.bjxc.supervise.http.crypto.Sign;

@Service
public class ProvinceSuperviseService {
	private Logger logger = LoggerFactory.getLogger(CountrySuperviseService.class);
	
	@Resource
	private HttpClientService httpClientService;
	
	@Value("${bjxc.province.supervise.url}")
	private String provinceSuperviseUrl;
	
	@Value("${bjxc.province.supervise.version}")
	private String version;
	
	@Resource
	private PrivateKeyFactory privateKeyFactory;
	
	

	
	public Result institution(Map<String,Object> params) throws Exception{
		String inscode = (String)params.get("inscode");
		Assert.notNull(inscode);
		long timestamp = new Date().getTime();
		String certsn = privateKeyFactory.getCertsn();
		Sign sign = new Sign();
		String dataJSON = JacksonBinder.buildNonDefaultBinder().toJson(params);
		String signStr = sign.sign(dataJSON, timestamp, privateKeyFactory.getPrivateKey());
		
		String url = provinceSuperviseUrl + "/institution?v=" + version + "&ts=" + timestamp + "&sign=" + signStr +"&user="+certsn;
		//logger.info("institution url:" + url);
		Result result = httpClientService.doPostJson(url,dataJSON);
		return result;
	}

}
