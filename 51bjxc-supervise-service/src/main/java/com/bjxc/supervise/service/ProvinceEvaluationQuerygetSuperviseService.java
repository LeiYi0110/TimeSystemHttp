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
public class ProvinceEvaluationQuerygetSuperviseService {
	private Logger logger = LoggerFactory.getLogger(ProvinceEvaluationQuerygetSuperviseService.class);	@Resource
	private HttpClientService httpClientService;
	
	@Value("${bjxc.province.supervise.url}")
	private String provinceSuperviseUrl;
	
	@Value("${bjxc.province.supervise.version}")
	private String version;
	
	@Resource
	private PrivateKeyFactory privateKeyFactory;
	
	public Result evaluationquery(Map<String,Object> params) throws Exception{
		long timestamp = new Date().getTime();
		String certsn = privateKeyFactory.getCertsn();
		Sign sign = new Sign();
		String dataJSON = (String)params.get("inscode") + (String)params.get("querydate");
		String urlAction = "/" + (String)params.get("inscode") + "-evaluationquery-" + (String)params.get("querydate");
		String signStr = sign.sign(dataJSON, timestamp, privateKeyFactory.getPrivateKey());
		String url = provinceSuperviseUrl + urlAction + "?v=" + version + "&ts=" + timestamp + "&sign=" + signStr +"&user="+certsn;
		//logger.info("EvaluationQuery url:" + url);
		Result result = httpClientService.doGet(url);
		return result;
	}
}
