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
public class ProvinceVideoRecordSuperviseService {
	private Logger logger = LoggerFactory.getLogger(ProvinceVideoRecordSuperviseService.class);	@Resource
	private HttpClientService httpClientService;
	
	@Value("${bjxc.province.supervise.url}")
	private String provinceSuperviseUrl;
	
	@Value("${bjxc.province.supervise.version}")
	private String version;
	
	@Resource
	private PrivateKeyFactory privateKeyFactory;
	
	public Result videorecord(Map<String,Object> params) throws Exception{
		long timestamp = new Date().getTime();
		String certsn = privateKeyFactory.getCertsn();
		Sign sign = new Sign();
		String dataJSON = JacksonBinder.buildNonDefaultBinder().toJson(params);
		String signStr = sign.sign(dataJSON, timestamp, privateKeyFactory.getPrivateKey());
		String url = provinceSuperviseUrl + "/videoRecord?v=" + version + "&ts=" + timestamp + "&sign=" + signStr +"&user="+certsn;
		//logger.info("VideoRecord url:" + url);
		Result result = httpClientService.doPostJson(url,dataJSON);
		return result;
	}
}
