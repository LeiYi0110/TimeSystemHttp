package com.bjxc.supervise.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.aspectj.apache.bcel.generic.NEW;
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
public class ProvinceStageTrainningTimeSuperviseService {
	private Logger logger = LoggerFactory.getLogger(ProvinceStageTrainningTimeSuperviseService.class);	@Resource
	private HttpClientService httpClientService;
	
	@Value("${bjxc.province.supervise.url}")
	private String provinceSuperviseUrl;
	
	@Value("${bjxc.province.supervise.version}")
	private String version;
	
	@Resource
	private PrivateKeyFactory privateKeyFactory;
	
	public Result stagetrainningtime(Map<String,Object> params,String pdfid,String esignature) throws Exception{
		long timestamp = new Date().getTime();
		String certsn = privateKeyFactory.getCertsn();
		//certsn = "9B64FED25801";
		Sign sign = new Sign();
		



		//String esignature = "7CB6D664EF6478EC92F2B0FA29BE2AFBD9B880F413F366C04CACE30E8E9173D4B75D66A6F0979D26A99B57E9F68371F53DDF6B9476E9CB7D935FC09641BE53E66620D715FC674C533E4514D9A817DB6202E3F68196F0F4C11BA04E1DCAF4FC5EC7B9DD28627051655FFE96F32AE066CE5D6B30C2B723C7EB714849B14D7D8BE42E070E89A202FACB2DA57665F919B7D1924CFEF2D5C233D754735E1BAF2971B4350880F22DD0862DB8C96F869C8210A4118DDCAA4B7EE7141E7A7FA2EED7344B6040D9E55FF62EF661066BFF75E782775631A5C1F0AC90ABD1479B8058C402477F6AE391280E865E414A2934EFE40BF8E02D6CA7118A694A9BE595A38E261FA8";//"33D2828686F3BDA555389A9ED90D2E39990792DFFF8FDDC1279FF8DCE2978662CF00F6A6725B91EC35035F2743B6F3EE4B2A8FE0112FF5A638FF450B80B6E712C9D2CBFDFB6D68AF4947C00C37473E87F43761C7AB9A78B0E7E3FA0138400514498EF2DFF21469B869B65D851944466105DAC7A006D3097B45C5D3C1BE76192559852FF339919CE7A2143DE861DDFF773CE081207D970F88F9FC123A76CA36200660E89C38C70201C59D04AE84551123DB43F7D0C20AEA9E27E1E70403D4A81BB764EDA1B1E365AFF298297EA9B8E998DF76547791D4A359633853324EAA1DBD6D290FF7260DCE2D04854A676B6A4D9DDBC4081A663A896ECE10A907F42A2129";
		//params.put("esignature", esignature);
		
		//logger.info(esignature);
		//String frontSideJSON = JacksonBinder.buildNonDefaultBinder().toJson(params);
		params.put("esignature", esignature);
		params.put("pdfid", pdfid);
		String dataJSON = JacksonBinder.buildNonDefaultBinder().toJson(params);
		String signStr = sign.sign(dataJSON, timestamp, privateKeyFactory.getPrivateKey());
		
		//params.put("esignature", esignature);
		//params.put("pdfid", new Integer(1));
		//String dataJSON2 = JacksonBinder.buildNonDefaultBinder().toJson(params);
		String url = provinceSuperviseUrl + "/stagetrainningtime?v=" + version + "&ts=" + timestamp + "&sign=" + signStr +"&user="+certsn;
		//logger.info("StageTrainningTime url:" + url);
		Result result = httpClientService.doPostJson(url,dataJSON);
		return result;
	}
}
