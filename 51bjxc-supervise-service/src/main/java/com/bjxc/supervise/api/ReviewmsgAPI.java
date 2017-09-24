package com.bjxc.supervise.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bjxc.Result;
import com.bjxc.json.JacksonBinder;
import com.bjxc.supervise.http.HttpClientService;
import com.bjxc.supervise.service.InsertService;
import com.bjxc.supervise.service.ProvinceRegionReviewgetSuperviseService;
import com.bjxc.supervise.service.ProvinceStageTrainningTimeReviewgetSuperviseService;
import com.bjxc.supervise.service.ReviewmsgService;
import com.bjxc.supervise.service.SelectService;
import com.bjxc.supervise.service.UpdateService;
import com.bjxc.web.utils.WebUtils;

@Controller
public class ReviewmsgAPI {
	private JacksonBinder binder = JacksonBinder.buildNormalBinder();
	private static final Logger logger = LoggerFactory.getLogger(ReviewmsgAPI.class);

	@Resource
	private SelectService selectService;
	
	@Resource
	private InsertService InsertService;

	@Resource
	private UpdateService updateService;

	@Resource
	private ProvinceRegionReviewgetSuperviseService pservice;

	@Resource
	private HttpClientService httpClientService;

	@Resource
	private ReviewmsgService service;

	@Resource
	private ProvinceStageTrainningTimeReviewgetSuperviseService tservice;

	@ResponseBody
	@RequestMapping(value = "/reviewmsg", method = RequestMethod.POST)
	public Map post(HttpServletRequest request) {

		// mod by Levin,20161224
		// 1、增加日志输出
		// 2、修改审核通知逻辑，先接受到备案通知，然后再去省平台查询备案结果，最后再更新计时平台数据库
		logger.info("开始调用接口:" + request.getRequestURL());
		logger.info("访问来源:" + request.getRemoteAddr());

		Map map2 = new HashMap();
		try {
			Map<String, String> notifiMap = new HashMap<String, String>();
			request.setCharacterEncoding("UTF-8");
			BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream()));//post方式传递读取字符流
			String jsonStr = null;
			StringBuilder result = new StringBuilder();
			try {
				while ((jsonStr = reader.readLine()) != null) {
					result.append(jsonStr);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			reader.close();// 关闭输入流
			Map mapss=binder.fromJson(result.toString(), Map.class);
			String reviewtype = (String)mapss.get("reviewtype");
			Map map  = (Map)mapss.get("data");
			
			// 记录传递过来的参数
			logger.info("reviewtype=" + reviewtype);
			logger.info("data=" + map.toString());
			
			//reviewtype,1教学区域,2阶段培训记录
			if (reviewtype.equals("1")) {
				String inscode = map.get("inscode").toString();
				Integer seq = Integer.parseInt(map.get("seq").toString());
				Map map3 = new HashMap();
				map3.put("inscode", inscode);
				map3.put("seq", seq);

				//先查询到审核状态再更新，改方法去掉
				//updateService.updateIsnotice(seq, inscode);
				
				//去省平台查询教学区域审核状态
				logger.info("接收到教学区域审核通知，开始查询教学区域审核结果.");
				HttpThread httpThread = new HttpThread(map3);
				httpThread.start();
				
				//TODO 去掉Webscoket
				notifiMap.put("inscode", map.get("inscode").toString());
				notifiMap.put("seq", map.get("seq").toString());

			} else if (reviewtype.equals("2")) {
				
				//去省平台查询培训学时审核状态
				logger.info("接收到阶段培训记录审核通知，开始查询阶段培训记录审核结果.");
				String stunum = map.get("stunum").toString();
				Integer subject = Integer.parseInt(map.get("subject").toString());
				Map map3 = new HashMap();
				map3.put("stunum", stunum);
				map3.put("subject", subject);
				HttpThread2 httpThread = new HttpThread2(map3);
				httpThread.start();

				//TODO 去掉Webscoket
				notifiMap.put("stunum", map.get("stunum").toString());
				notifiMap.put("subject", map.get("subject").toString());

			}
			NotificationReviewMsgThread notificationReviewMsgThread = new NotificationReviewMsgThread(
					Integer.valueOf(reviewtype).intValue(), notifiMap);
			notificationReviewMsgThread.start();
		
			// 操作
			map2.put("errorcode", 0);
			map2.put("message", "");
			
		} catch (Exception e) {
			logger.error("接收消息通知错误： ", e);
			map2.put("errorcode", 1);
			map2.put("message", "数据异常");
		}
		return map2;
	}

	/**
	 * 调用省平台接口，查询教学区域审核结果
	 */
	public class HttpThread extends Thread {
		private Map map;

		public HttpThread(Map map) {
			this.map = map;
		}

		public void run() {
			try {
				String str = String.format("%04d", (int) map.get("seq"));
				map.put("seq", str);
				Result result = pservice.regionreview(map);
				
				if ((int) result.get("errorcode") == 0) {
					Map maps = (Map) result.get("data");

					// 如果同意启用，更新计时平台数据库
					if ((int) maps.get("flag") == 1) {
						map.put("type", 1);
						map.put("reason", "");
						logger.info("教学区域" + str + "同意启用.");
					} else { // 如果不同意启用，记录不同意启用的原因
								// TODO 后续需要在界面上显示，暂时先记录到日志，同步记录到数据库
						map.put("type", 2);
						map.put("reason", maps.get("reason"));
						logger.info("教学区域" + str + "不同意启用.原因:" + maps.get("reason"));
					}
					map.put("seq", Integer.parseInt(map.get("seq").toString()));
					updateService.updateDrivingfieldprovince(map);
				}

			} catch (Exception e) {
				logger.error("调用省平台接口，查询教学区域审核结果错误，HttpThread api：", e);
			}
		}
	}

	
	/**
	 * 调用省平台接口，查询阶段培训记录审核结果
	 */
	public class HttpThread2 extends Thread {
		private Map map;

		public HttpThread2(Map map) {
			this.map = map;
		}

		public void run() {
			try {
				Result result = tservice.stagetrainningtimereview(map);
				if ((int) result.get("errorcode") == 0) {
					Map maps = (Map) result.get("data");
					//更新审核结果
					updateService.updateTimeResult(maps);
				}

			} catch (Exception e) {
				logger.error("调用省平台接口，查询阶段培训记录审核结果错误，HttpThread api：", e);
			}

		}

	}

	public class NotificationReviewMsgThread extends Thread {
		Map map;
		int reviewtype;

		public NotificationReviewMsgThread(int reviewtype, Map map) {
			this.map = map;
			this.reviewtype = reviewtype;
		}

		public void run() {
			try {
				String path = "";
				if (reviewtype == 1) {
					path = "/socket/ReviewMsg/DrivingFiled";
				} else if (reviewtype == 2) {
					path = "/socket/ReviewMsg/StageTrainningTime";
				}
				if (path.length() > 0) {
					service.notification(path, map);
				}

			} catch (Exception e) {
				logger.error("HttpThread api", e);
			}

		}
	}

	public class NotificationThread extends Thread {
		Map map;

		public NotificationThread(Map map) {
			this.map = map;
		}

		public void run() {
			try {

				service.notification("socket/relationshipChange", map);

			} catch (Exception e) {
				logger.error("HttpThread api", e);
			}

		}

	}

	@ResponseBody
	@RequestMapping(value = "/recordchangemsg", method = RequestMethod.POST)
	public Map post2(HttpServletRequest request) {
		
		// mod by Levin,20161224
		// 1、增加日志输出
		// 2、修改审核通知逻辑，先接受到备案通知，然后再去省平台查询备案结果，最后再更新计时平台数据库
		logger.info("开始调用接口:" + request.getRequestURL());
		logger.info("访问来源:" + request.getRemoteAddr());
		
		Map map2 = new HashMap();
		Map map = new HashMap();
		try {
			request.setCharacterEncoding("UTF-8");
			BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream()));//post方式传递读取字符流
			String jsonStr = null;
			StringBuilder result = new StringBuilder();
			try {
				while ((jsonStr = reader.readLine()) != null) {
					result.append(jsonStr);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			logger.info("接受数据:" + result.toString());
			reader.close();// 关闭输入流
			Map mapss=binder.fromJson(result.toString(), Map.class);
			
			String recordtype = (String)mapss.get("recordtype");
			String changetype = (String)mapss.get("changetype");	// '0'解除，'1'恢复
			String inscode = (String)mapss.get("inscode");
			String recordnum = (String)mapss.get("recordnum");
			String reason = (String)mapss.get("reason");
			
			map.put("recordNum", recordnum);
			map.put("inscode", inscode);
			map.put("type", changetype);
			map.put("recordtype", recordtype);
			map.put("reason", reason);
			
			

			String msg = null;
			Integer errorcode = 0;
			
			//还有计时平台
			if ("1".equals(recordtype)){
				//TODO 计时平台备案，待处理
			}else if("2".equals(recordtype)) { // 教练员
				updateService.updateCoachprovince(map);
			} else if ("3".equals(recordtype)) { // 考核员
				updateService.updateExaminerprovince(map);
			} else if ("4".equals(recordtype)) { // 安全员
				updateService.updateSecurityprovince(map);
			} else if ("5".equals(recordtype)) { // 教练车
				updateService.updateTrainingCarprovince(map);
			}

			NotificationThread notificationThread = new NotificationThread(map);
			notificationThread.start();
			
			map2.put("errorcode", errorcode);
			map2.put("message", msg);
			map2.put("data", null);
			
		} catch (Exception e) {
			logger.error("省平台调用备案关系变更接口失败.", e);
			map2.put("errorcode", 1);
			map2.put("message", "数据异常");
		}
		return map2;
	}
	
	@ResponseBody
	@RequestMapping(value = "/classrecord", method = RequestMethod.POST)
	public Map post3(HttpServletRequest request) {
		Map map = new HashMap();
		try {
			request.setCharacterEncoding("UTF-8");
			BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream()));//post方式传递读取字符流
			String jsonStr = null;
			StringBuilder result = new StringBuilder();
			try {
				while ((jsonStr = reader.readLine()) != null) {
					result.append(jsonStr);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			logger.info("接受数据:" + result.toString());
			reader.close();// 关闭输入流
			Map mapss=binder.fromJson(result.toString(), Map.class);
			InsertService.addTeachLog(mapss);
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("errorcode", 0);
		map.put("message", null);
		return map;
	}
}
