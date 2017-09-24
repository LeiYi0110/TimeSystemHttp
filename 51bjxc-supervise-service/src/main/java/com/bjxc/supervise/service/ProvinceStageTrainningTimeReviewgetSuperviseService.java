package com.bjxc.supervise.service;

import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.bjxc.Result;
import com.bjxc.supervise.http.HttpClientService;
import com.bjxc.supervise.http.crypto.Sign;

/**
 * 全国平台
 * 
 * @author Administrator
 *
 */
@Service
public class ProvinceStageTrainningTimeReviewgetSuperviseService {
	private Logger logger = LoggerFactory.getLogger(ProvinceStageTrainningTimeReviewgetSuperviseService.class);
	@Resource
	private HttpClientService httpClientService;

	@Value("${bjxc.province.supervise.url}")
	private String provinceSuperviseUrl;

	@Value("${bjxc.province.supervise.version}")
	private String version;

	@Resource
	private PrivateKeyFactory privateKeyFactory;

	public Result stagetrainningtimereview(Map<String, Object> params) throws Exception {
		long timestamp = new Date().getTime();
		String certsn = privateKeyFactory.getCertsn();
		
		//Mod by Levin, 20161224, 防止java.lang.ClassCastException
		String stunum = String.valueOf(params.get("stunum"));
		String subject = String.valueOf(params.get("subject"));
		Sign sign = new Sign();
		String dataJSON = stunum + subject;
		String urlAction = "/" + stunum + "-stagetrainningtimereview-" + subject;
		String signStr = sign.sign(dataJSON, timestamp, privateKeyFactory.getPrivateKey());
		String url = provinceSuperviseUrl + urlAction + "?v=" + version + "&ts=" + timestamp + "&sign=" + signStr
				+ "&user=" + certsn;
		//logger.info("调用省平台接口StageTrainningTimeReview:" + url);
		Result result = httpClientService.doGet(url);
		return result;
	}
}
