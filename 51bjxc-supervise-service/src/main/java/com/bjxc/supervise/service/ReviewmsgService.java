package com.bjxc.supervise.service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

//import com.bjxc.supervise.NotificationMessage;
//import com.bjxc.supervise.api.ReviewmsgAPI;
import com.bjxc.supervise.http.HttpClientService;
//import com.sun.mail.imap.protocol.SearchSequence;

@Service
public class ReviewmsgService {
	
	@Value("${bjxc.message.host}")
	private String  messageHost;
	
	@Resource
	private HttpClientService httpClientService;

	
	private static final Logger logger = LoggerFactory.getLogger(ReviewmsgService.class);
	
	public void notification(String path, Map<String,String> map)
	{
		try
		{
			
			
			String url = messageHost + path;
			httpClientService.doPost(url, map);
			/*
			 map.put("recordNum", recordnum);
			map.put("inscode", inscode);
			map.put("type", changetype);
			map.put("recordtype", recordtype);
			map.put("reason", reason);
			 * */
			String inscode = "";
			String content = "";
			if(path.equals("socket/relationshipChange"))
			{
				inscode = map.get("inscode");
				String type = map.get("type");
				if (Integer.valueOf(type).intValue() == 1) {
					content += "解除备案";
					
				}
				else if (Integer.valueOf(type).intValue() == 2) {
					
					content += "恢复备案";
					
				}
				content += ":";
				String recordtype =  map.get("recordtype");
				switch(Integer.valueOf(recordtype).intValue())
				{
					case 1:
						content += "计时平台";
						break;
					case 2:
						content += "教练员";
						break;
					case 3:
						content += "考核员";
						break;
					case 4:
						content += "安全员";
						break;
					case 5:
						content += "教练车";
						break;
					case 6:
						content += "教学区域";
						break;
					default:
						content += "";
						break;

				
				}
				
				String recordnum = map.get("recordNum");
				content += recordnum;
				
			}
			else if(path.equals("/socket/ReviewMsg/DrivingFiled"))
			{
				inscode = map.get("inscode");
				String seq = map.get("seq");
				content = "培训机构" + inscode + "教学区域" + seq + "有审核消息通知";
			}
			else if (path.equals("/socket/ReviewMsg/StageTrainningTime")) {
				
				/*
				 * map3.put("stunum", stunum);
				map3.put("subject", subject);
				 * */
				
				String stunum = map.get("stunum");
				String subject = map.get("subject");
				
				content = "学员" + stunum + "科目" + subject + "有阶段性学时记录审核通知";
				
				
				
			}
			
			httpClientService.doGet("http://112.74.129.7:8709/message?inscode=" + inscode +"&content=" + content);
		
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	

	


}
