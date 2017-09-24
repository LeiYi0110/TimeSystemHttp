<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'testStudent.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script language='javascript' src='jquery.min.js'></script>
</head>

<body>
	<div style="width: 1500px;">
		<div style="width: 100%; height: 15%;">
			<h1 align="center">接口测试</h1>
		</div>
		<div style="width: 100%; margin-top: 10px;">
			<div style="width: 100%;">
				<div>
				<h3>全国登录</h3>
					<form action="country/login" method="post">
						district:<input type="text" name="district" value="420528"/> <span style="color: red">(必填)</span></br> 
						name:<input type="text" name="name" value="test111"/> <span style="color: red">(必填)</span></br> 
						licnum:<input type="text" name="licnum" value="112323445566"/> <span style="color: red">(必填)</span></br> 
						<input type="hidden" value="1" name="type" id="type">
						<input type="button" value="执行" onclick="submitForm(this)" /> </br>
						<div class="result_div"></div>
					</form>
				</div>
<hr />
					<h3>省登录</h3>
					<form action="country/login" method="post">
						district:<input type="text" name="district" value="420528"/> <span style="color: red">(必填)</span></br> 
						name:<input type="text" name="name" value="test111"/> <span style="color: red">(必填)</span></br> 
						licnum:<input type="text" name="licnum" value="112323445566"/> <span style="color: red">(必填)</span></br> 
						<input type="hidden" value="2" name="type" id="type">
						<input type="button" value="执行" onclick="submitForm(this)" /> </br>
						<div class="result_div"></div>
					</form>
				</div>
<hr />
					<h3>全国上传文件</h3>
					<form action="upload/file" method="post" enctype="multipart/form-data">
						
						<input type="hidden" name="type" id="fileType"/> 
						<select name="select" onchange="fileTypeChange(this.value,'fileType')">
							<option value ="">请选择</option>
  							<option value ="stuimg">学员头像</option>
  							<option value ="stufp">学员指纹</option>
  							<option value="coachimg">教练员头像</option>
  							<option value="coachfp">教练员指纹</option>
  							
  							<option value ="examinerimg">考核员头像</option>
  							<option value ="examinerfp">考核员指纹</option>
  							<option value="securityguardimg">安全员头像</option>
  							<option value="securityguardfg">安全员指纹</option>
  							
  							<option value ="vehimg">教练车图片</option>
  							<option value ="outletsimg">招生点照片</option>
  							<option value="occupationimg">资格证书图片</option>
  							<option value="voiceprintimg">声纹文件</option>
  							
  							
  							<option value ="epdfimg">电子培训部分记录表PDF文件</option>
  							<option value ="onlineimg">网络远程学习过程照片</option>
  							<option value="classroom">课堂教学过程照片</option>
  							<option value="simulation">模拟教学过程照片</option>
  							
  							<option value="video">视频文件</option>
						</select>
						file:<input type="file" name="ifile" id="ifile"></br>
						<!-- <input type="button" value="执行" onclick="submitForm(this)" /> --> 
						<input type="submit" value="确认"> </br>
						<div class="result_div"></div>
					</form>
				</div>
<hr />
					<h3>省上传文件</h3>
					<form action="province/upload/file" method="post" enctype="multipart/form-data">
						
						<input type="hidden" name="type" id="fileType2"/> 
						<select name="select" onchange="fileTypeChange(this.value,'fileType2')">

							<option value ="">请选择</option>
  							<option value ="stuimg">学员头像</option>
  							<option value ="stufp">学员指纹</option>
  							<option value="coachimg">教练员头像</option>
  							<option value="coachfp">教练员指纹</option>
  							
  							<option value ="examinerimg">考核员头像</option>
  							<option value ="examinerfp">考核员指纹</option>
  							<option value="securityguardimg">安全员头像</option>
  							<option value="securityguardfg">安全员指纹</option>
  							
  							<option value ="vehimg">教练车图片</option>
  							<option value ="outletsimg">招生点照片</option>
  							<option value="occupationimg">资格证书图片</option>
  							<option value="voiceprintimg">声纹文件</option>
  							
  							
  							<option value ="epdfimg">电子培训部分记录表PDF文件</option>
  							<option value ="onlineimg">网络远程学习过程照片</option>
  							<option value="classroom">课堂教学过程照片</option>
  							<option value="simulation">模拟教学过程照片</option>
  							
  							<option value="video">视频文件</option>
						</select>
						file:<input type="file" name="ifile" id="ifile"></br>
						<input type="button" value="执行" onclick="submitForm(this)" />
						<!-- <input type="submit" value="确认"> </br> -->
						<div class="result_div"></div>
					</form>
				</div>
<hr />
<h3>计时系统文件上传</h3>
					<form action="imageup/stuimg" method="post" enctype="multipart/form-data">
						file:<input type="file" name="file" id="file"></br>
						<input type="submit" value="确认"> </br> 
						<div class="result_div"></div>
					</form>
				</div>
<hr />
					<h3>5.1.1</h3>
					<form action="country/institution" method="post">
						district:<input type="text" name="district" value="420528"/> <span style="color: red">(必填)</span></br> 
						name:<input type="text" name="name" value="test111"/> <span style="color: red">(必填)</span></br> 
						shortname:<input type="text" name="shortname" value="test2"/> <span style="color: red">(必填)</span></br> 
						licnum:<input type="text" name="licnum" value="112323445566"/> <span style="color: red">(必填)</span></br> 
						licetime:<input type="text" name="licetime" value="20160720"/> <span style="color: red">(必填)</span></br> 
						business:<input type="text" name="business" value="23421345563567777775"/> <span style="color: red">(必填)</span></br> 
						creditcode:<input type="text" name="creditcode" /> </br> 
						address:<input type="text" name="address" value="asgweeee"/> <span style="color: red">(必填)</span></br> 
						postcode:<input type="text" name="postcode" value="443500" /> <span style="color: red">(必填)</span></br> 
						legal:<input type="text" name="legal" value="fff"/> <span style="color: red">(必填)</span></br> 
						contact:<input type="text" name="contact" value="fff"/> <span style="color: red">(必填)</span></br> 
						phone:<input type="text" name="phone" value="18215487978"/> <span style="color: red">(必填)</span></br> 
						busiscope:<input type="text" name="busiscope" value="C1,C2,C3" /> <span style="color: red">(必填)</span></br> 
						busistatus:<input type="text" name="busistatus" value="1"/> <span style="color: red">(必填)</span></br> 
						level:<input type="text" name="level" value="1"/> <span style="color: red">(必填)</span></br> 
						coachnumber:<input type="text" name="coachnumber" value="0" /> <span style="color: red">(必填)</span></br> 
						grasupvnum:<input type="text" name="grasupvnum" value="0" /> <span style="color: red">(必填)</span></br> 
						safmngnum:<input type="text" name="safmngnum" value="0" /> <span style="color: red">(必填)</span></br> 
						tracarnum:<input type="text" name="tracarnum" value="0" /> <span style="color: red">(必填)</span></br> 
						classroom:<input type="text" name="classroom" value="0" /> </br> 
						thclassroom:<input type="text" name="thclassroom"/> </br> 
						praticefield:<input type="text" name="praticefield"  value="0"/> <span style="color: red">(必填)</span></br> 
						<input type="button" value="执行" onclick="submitForm(this)" /> </br>
						<div class="result_div"></div>
					</form>
				</div>
<hr />
				<div>
					<h3>省修改机构</h3>
					<form action="province/institution" method="post">
						inscode:<input type="text" name="inscode" value="2236581429084424"/> <span style="color: red">(必填)</span></br> 
						district:<input type="text" name="district" value="420528"/> <span style="color: red">(必填)</span></br> 
						name:<input type="text" name="name" value="test111"/> <span style="color: red">(必填)</span></br> 
						shortname:<input type="text" name="shortname" value="test2"/> <span style="color: red">(必填)</span></br> 
						licnum:<input type="text" name="licnum" value="112323445566"/> <span style="color: red">(必填)</span></br> 
						licetime:<input type="text" name="licetime" value="20160720"/> <span style="color: red">(必填)</span></br> 
						business:<input type="text" name="business" value="23421345563567777775"/> <span style="color: red">(必填)</span></br> 
						creditcode:<input type="text" name="creditcode" /> </br> 
						address:<input type="text" name="address" value="asgweeee"/> <span style="color: red">(必填)</span></br> 
						postcode:<input type="text" name="postcode" value="443500" /> <span style="color: red">(必填)</span></br> 
						legal:<input type="text" name="legal" value="fff"/> <span style="color: red">(必填)</span></br> 
						contact:<input type="text" name="contact" value="fff"/> <span style="color: red">(必填)</span></br> 
						phone:<input type="text" name="phone" value="18215487978"/> <span style="color: red">(必填)</span></br> 
						busiscope:<input type="text" name="busiscope" value="C1,C2,C3" /> <span style="color: red">(必填)</span></br> 
						busistatus:<input type="text" name="busistatus" value="1"/> <span style="color: red">(必填)</span></br> 
						level:<input type="text" name="level" value="1"/> <span style="color: red">(必填)</span></br> 
						coachnumber:<input type="text" name="coachnumber" value="0" /> <span style="color: red">(必填)</span></br> 
						grasupvnum:<input type="text" name="grasupvnum" value="0" /> <span style="color: red">(必填)</span></br> 
						safmngnum:<input type="text" name="safmngnum" value="0" /> <span style="color: red">(必填)</span></br> 
						tracarnum:<input type="text" name="tracarnum" value="0" /> <span style="color: red">(必填)</span></br> 
						classroom:<input type="text" name="classroom" value="0" /> </br> 
						thclassroom:<input type="text" name="thclassroom"/> </br> 
						praticefield:<input type="text" name="praticefield"  value="0"/> <span style="color: red">(必填)</span></br> 
						<input type="button" value="执行" onclick="submitForm(this)" /> </br>
						<div class="result_div"></div>
					</form>
				</div>
<hr />

					

				<div>
					<h3>全国新增学员</h3>
					<form action="country/student/add" method="post">
						inscode:<input type="text" name="inscode" value="2236581429084424"/> <span style="color: red">(必填)</span></br> 
						cardtype:<input type="text" name="cardtype" value="1"/> <span style="color: red">(必填)</span></br> 
						idcard:<input type="text" name="idcard" value="431381197007126616"/> <span style="color: red">(必填)</span></br> 
						nationality:<input type="text" name="nationality" value="中国"/> <span style="color: red">(必填)</span></br> 
						name:<input type="text" name="name" value="测试"/> <span style="color: red">(必填)</span></br> 
						sex:<input type="text" name="sex" value="1"/> <span style="color: red">(必填)</span></br> 
						phone:<input type="text" name="phone" value="15019292929"/> <span style="color: red">(必填)</span></br> 
						address:<input type="text" name="address" value="深圳"/> </br> 
						photo:<input type="text" name="photo" value="209040"/> <span style="color: red">(必填)</span></br> 
						fingerprint:<input type="text" name="fingerprint" value="209043" /> <span style="color: red">(必填)</span></br> 
						busitype:<input type="text" name="busitype" value="0"/> <span style="color: red">(必填)</span></br> 
						drilicnum:<input type="text" name="drilicnum"/> <span style="color: red">(必填)</span></br> 
						fstdrilicdate:<input type="text" name="fstdrilicdate" value="20161022"/> <span style="color: red">(必填)</span></br> 
						perdritype:<input type="text" name="perdritype" value="C1" /> <span style="color: red">(必填)</span></br> 
						traintype:<input type="text" name="traintype" value="A1"/> <span style="color: red">(必填)</span></br> 
						applydate:<input type="text" name="applydate" value="20161022"/> <span style="color: red">(必填)</span></br> 
						
						<input type="button" value="执行" onclick="submitForm(this)" /> </br>
						<div class="result_div"></div>
					</form>
				</div>
<hr />

				<div>
					<h3>CountryCoachSuperviseAPI</h3>
					<form action="country/coach" method="post">
						inscode:<input type="text" name="inscode" value="2236581429084424"/> <span style="color: red">(必填)</span></br>
						name:<input type="text" name="name" value="yy"/> <span style="color: red">(必填)</span></br>
						sex:<input type="text" name="sex" value="1"/> <span style="color: red">(必填)</span></br>
						idcard:<input type="text" name="idcard" value="430688198812010003"/> <span style="color: red">(必填)</span></br>
						mobile:<input type="text" name="mobile" value="13988882222"/> <span style="color: red">(必填)</span></br>
						address:<input type="text" name="address" value="南山区"/></br>
						photo:<input type="text" name="photo" value="209040"/> <span style="color: red">(必填)</span></br>
						fingerprint:<input type="text" name="fingerprint" value="209043"/></br>
						drilicence:<input type="text" name="drilicence" value="430688198812010003"/> <span style="color: red">(必填)</span></br>
						fstdrilicdate:<input type="text" name="fstdrilicdate" value="19991201"/> <span style="color: red">(必填)</span></br>
						occupationno:<input type="text" name="occupationno" /></br>
						occupationlevel:<input type="text" name="occupationlevel" /></br>
						dripermitted:<input type="text" name="dripermitted" value="C1"/> <span style="color: red">(必填)</span></br>
						teachpermitted:<input type="text" name="teachpermitted"  value="C1"/> <span style="color: red">(必填)</span></br>
						employstatus:<input type="text" name="employstatus" value="0"/> <span style="color: red">(必填)</span></br>
						hiredate:<input type="text" name="hiredate" value="20051005"/> <span style="color: red">(必填)</span></br>
						leavedate:<input type="text" name="leavedate" /></br>
						<input type="button" value="执行" onclick="submitForm(this)" /> </br>
						<div class="result_div"></div>
					</form>
				</div>
<hr />

				<div>
					<h3>CountryExaminerSuperviseAPI</h3>
					<form action="country/examiner" method="post">
						inscode:<input type="text" name="inscode" value="2236581429084424"/> <span style="color: red">(必填)</span></br>
						name:<input type="text" name="name" value="yy"/> <span style="color: red">(必填)</span></br>
						sex:<input type="text" name="sex" value="1"/> <span style="color: red">(必填)</span></br>
						idcard:<input type="text" name="idcard" value="430688198812010003"/> <span style="color: red">(必填)</span></br>
						mobile:<input type="text" name="mobile" value="13988882222"/> <span style="color: red">(必填)</span></br>
						address:<input type="text" name="address" value="南山区"/></br>
						photo:<input type="text" name="photo" value="209040"/> <span style="color: red">(必填)</span></br>
						fingerprint:<input type="text" name="fingerprint" value="209043"/></br>
						drilicence:<input type="text" name="drilicence" value="430688198812010003"/> <span style="color: red">(必填)</span></br>
						fstdrilicdate:<input type="text" name="fstdrilicdate" value="19991201"/> <span style="color: red">(必填)</span></br>
						occupationno:<input type="text" name="occupationno" /></br>
						occupationlevel:<input type="text" name="occupationlevel" /></br>
						dripermitted:<input type="text" name="dripermitted" value="C1"/> <span style="color: red">(必填)</span></br>
						teachpermitted:<input type="text" name="teachpermitted"  value="C1"/> <span style="color: red">(必填)</span></br>
						employstatus:<input type="text" name="employstatus" value="0"/> <span style="color: red">(必填)</span></br>
						hiredate:<input type="text" name="hiredate" value="20051005"/> <span style="color: red">(必填)</span></br>
						leavedate:<input type="text" name="leavedate" /></br>
						<input type="button" value="执行" onclick="submitForm(this)" /> </br>
						<div class="result_div"></div>
					</form>
				</div>
<hr />

				<div>
					<h3>CountrySecurityguardSuperviseAPI</h3>
					<form action="country/securityguard" method="post">
						inscode:<input type="text" name="inscode" /> <span style="color: red">(必填)</span></br>
						name:<input type="text" name="name" /> <span style="color: red">(必填)</span></br>
						sex:<input type="text" name="sex" /> <span style="color: red">(必填)</span></br>
						idcard:<input type="text" name="idcard" /> <span style="color: red">(必填)</span></br>
						mobile:<input type="text" name="mobile" /> <span style="color: red">(必填)</span></br>
						address:<input type="text" name="address" /></br>
						photo:<input type="text" name="photo" /> <span style="color: red">(必填)</span></br>
						fingerprint:<input type="text" name="fingerprint" /></br>
						drilicence:<input type="text" name="drilicence" /></br>
						fstdrilicdate:<input type="text" name="fstdrilicdate" /></br>
						dripermitted:<input type="text" name="dripermitted" /></br>
						teachpermitted:<input type="text" name="teachpermitted" /></br>
						employstatus:<input type="text" name="employstatus" /> <span style="color: red">(必填)</span></br>
						hiredate:<input type="text" name="hiredate" /> <span style="color: red">(必填)</span></br>
						leavedate:<input type="text" name="leavedate" /></br>
						<input type="button" value="执行" onclick="submitForm(this)" /> </br>
						<div class="result_div"></div>
					</form>
				</div>
<hr />

				<div>
					<h3>CountryTrainingCarSuperviseAPI</h3>
					<form action="country/trainingcar" method="post">
						inscode:<input type="text" name="inscode" value="5851633716061642"/> <span style="color: red">(必填)</span></br>
						franum:<input type="text" name="franum" /></br>
						engnum:<input type="text" name="engnum" /></br>
						licnum:<input type="text" name="licnum" value="粤A1967学"/> <span style="color: red">(必填)</span></br>
						platecolor:<input type="text" name="platecolor" value="1"/> <span style="color: red">(必填)</span></br>
						photo:<input type="text" name="photo" /></br>
						manufacture:<input type="text" name="manufacture" value="Test"/> <span style="color: red">(必填)</span></br>
						brand:<input type="text" name="brand" value="Test"/> <span style="color: red">(必填)</span></br>
						model:<input type="text" name="model" /></br>
						perdritype:<input type="text" name="perdritype" value="C1"/> <span style="color: red">(必填)</span></br>
						buydate:<input type="text" name="buydate" /></br>
						<input type="button" value="执行" onclick="submitForm(this)" /> </br>
						<div class="result_div"></div>
					</form>
				</div>
<hr />

				<div>
					<h3>CountryDeviceSuperviseAPI</h3>
					<form action="country/device" method="post">
						termtype:<input type="text" name="termtype" /> <span style="color: red">(必填)</span></br>
						vender:<input type="text" name="vender" /> <span style="color: red">(必填)</span></br>
						model:<input type="text" name="model" /> <span style="color: red">(必填)</span></br>
						imei:<input type="text" name="imei" /> <span style="color: red">(必填)</span></br>
						sn:<input type="text" name="sn" /> <span style="color: red">(必填)</span></br>
						<input type="button" value="执行" onclick="submitForm(this)" /> </br>
						<div class="result_div"></div>
					</form>
				</div>
<hr />

				<div>
					<h3>CountryStudentSuperviseAPI</h3>
					<form action="country/student" method="post">
						inscode:<input type="text" name="inscode" /> <span style="color: red">(必填)</span></br>
						cardtype:<input type="text" name="cardtype" /> <span style="color: red">(必填)</span></br>
						idcard:<input type="text" name="idcard" /> <span style="color: red">(必填)</span></br>
						nationality:<input type="text" name="nationality" /> <span style="color: red">(必填)</span></br>
						name:<input type="text" name="name" /> <span style="color: red">(必填)</span></br>
						sex:<input type="text" name="sex" /> <span style="color: red">(必填)</span></br>
						phone:<input type="text" name="phone" /> <span style="color: red">(必填)</span></br>
						address:<input type="text" name="address" /></br>
						photo:<input type="text" name="photo" /> <span style="color: red">(必填)</span></br>
						fingerprint:<input type="text" name="fingerprint" /></br>
						busitype:<input type="text" name="busitype" /> <span style="color: red">(必填)</span></br>
						drilicnum:<input type="text" name="drilicnum" /></br>
						fstdrilicdate:<input type="text" name="fstdrilicdate" /></br>
						perdritype:<input type="text" name="perdritype" /></br>
						traintype:<input type="text" name="traintype" /> <span style="color: red">(必填)</span></br>
						applydate:<input type="text" name="applydate" /> <span style="color: red">(必填)</span></br>
						<input type="button" value="执行" onclick="submitForm(this)" /> </br>
						<div class="result_div"></div>
					</form>
				</div>
<hr />


				<div>
					<h3>ProvinceReviewmsgSuperviseAPI</h3>
					<form action="province/reviewmsg" method="post">
						reviewtype:<input type="text" name="reviewtype" /> <span style="color: red">(必填)</span></br>
						<input type="button" value="执行" onclick="submitForm(this)" /> </br>
						<div class="result_div"></div>
					</form>
				</div>
<hr />

				<div>
					<h3>ProvinceRecordchangemsgSuperviseAPI</h3>
					<form action="recordchangemsg" method="post">
						recordtype:<input type="text" name="recordtype" /> <span style="color: red">(必填)</span></br>
						changetype:<input type="text" name="changetype" /> <span style="color: red">(必填)</span></br>
						inscode:<input type="text" name="inscode" value="5851633716061642"/> <span style="color: red">(必填)</span></br>
						recordnum:<input type="text" name="recordnum" /> <span style="color: red">(必填)</span></br>
						<input type="button" value="执行" onclick="submitForm(this)" /> </br>
						<div class="result_div"></div>
					</form>
				</div>
<hr />

				<div>
					<h3>ProvinceRegionSuperviseAPI</h3>
					<form action="province/region" method="post">
						inscode:<input type="text" name="inscode" /> <span style="color: red">(必填)</span></br>
						seq:<input type="text" name="seq" /> <span style="color: red">(必填)</span></br>
						name:<input type="text" name="name" /></br>
						address:<input type="text" name="address" /> <span style="color: red">(必填)</span></br>
						area:<input type="text" name="area" /> <span style="color: red">(必填)</span></br>
						type:<input type="text" name="type" /> <span style="color: red">(必填)</span></br>
						vehicletype:<input type="text" name="vehicletype" /> <span style="color: red">(必填)</span></br>
						polygon:<input type="text" name="polygon" /> <span style="color: red">(必填)</span></br>
						totalvehnum:<input type="text" name="totalvehnum" /></br>
						curvehnum:<input type="text" name="curvehnum" /></br>
						<input type="button" value="执行" onclick="submitForm(this)" /> </br>
						<div class="result_div"></div>
					</form>
				</div>
<hr />

				<div>
					<h3>ProvinceCoachSuperviseAPI</h3>
					<form action="province/coach" method="post">
						inscode:<input type="text" name="inscode" /> <span style="color: red">(必填)</span></br>
						coachnum:<input type="text" name="coachnum" /> <span style="color: red">(必填)</span></br>
						name:<input type="text" name="name" /> <span style="color: red">(必填)</span></br>
						sex:<input type="text" name="sex" /> <span style="color: red">(必填)</span></br>
						idcard:<input type="text" name="idcard" /> <span style="color: red">(必填)</span></br>
						mobile:<input type="text" name="mobile" /> <span style="color: red">(必填)</span></br>
						address:<input type="text" name="address" /></br>
						photo:<input type="text" name="photo" /> <span style="color: red">(必填)</span></br>
						fingerprint:<input type="text" name="fingerprint" /></br>
						drilicence:<input type="text" name="drilicence" /> <span style="color: red">(必填)</span></br>
						fstdrilicdate:<input type="text" name="fstdrilicdate" /> <span style="color: red">(必填)</span></br>
						occupationno:<input type="text" name="occupationno" /></br>
						occupationlevel:<input type="text" name="occupationlevel" /></br>
						dripermitted:<input type="text" name="dripermitted" /> <span style="color: red">(必填)</span></br>
						teachpermitted:<input type="text" name="teachpermitted" /> <span style="color: red">(必填)</span></br>
						employstatus:<input type="text" name="employstatus" /> <span style="color: red">(必填)</span></br>
						hiredate:<input type="text" name="hiredate" /> <span style="color: red">(必填)</span></br>
						leavedate:<input type="text" name="leavedate" /></br>
						<input type="button" value="执行" onclick="submitForm(this)" /> </br>
						<div class="result_div"></div>
					</form>
				</div>
<hr />

				<div>
					<h3>ProvinceExaminerSuperviseAPI</h3>
					<form action="province/examiner" method="post">
						inscode:<input type="text" name="inscode" /> <span style="color: red">(必填)</span></br>
						examnum:<input type="text" name="examnum" /> <span style="color: red">(必填)</span></br>
						name:<input type="text" name="name" /> <span style="color: red">(必填)</span></br>
						sex:<input type="text" name="sex" /> <span style="color: red">(必填)</span></br>
						idcard:<input type="text" name="idcard" /> <span style="color: red">(必填)</span></br>
						mobile:<input type="text" name="mobile" /> <span style="color: red">(必填)</span></br>
						address:<input type="text" name="address" /></br>
						photo:<input type="text" name="photo" /> <span style="color: red">(必填)</span></br>
						fingerprint:<input type="text" name="fingerprint" /></br>
						drilicence:<input type="text" name="drilicence" /> <span style="color: red">(必填)</span></br>
						fstdrilicdate:<input type="text" name="fstdrilicdate" /> <span style="color: red">(必填)</span></br>
						occupationno:<input type="text" name="occupationno" /></br>
						occupationlevel:<input type="text" name="occupationlevel" /></br>
						dripermitted:<input type="text" name="dripermitted" /> <span style="color: red">(必填)</span></br>
						teachpermitted:<input type="text" name="teachpermitted" /></br>
						employstatus:<input type="text" name="employstatus" /> <span style="color: red">(必填)</span></br>
						hiredate:<input type="text" name="hiredate" /> <span style="color: red">(必填)</span></br>
						leavedate:<input type="text" name="leavedate" /></br>
						<input type="button" value="执行" onclick="submitForm(this)" /> </br>
						<div class="result_div"></div>
					</form>
				</div>
<hr />

				<div>
					<h3>ProvinceSecurityguardSuperviseAPI</h3>
					<form action="province/securityguard" method="post">
						inscode:<input type="text" name="inscode" /> <span style="color: red">(必填)</span></br>
						secunum:<input type="text" name="secunum" /> <span style="color: red">(必填)</span></br>
						name:<input type="text" name="name" /> <span style="color: red">(必填)</span></br>
						sex:<input type="text" name="sex" /> <span style="color: red">(必填)</span></br>
						idcard:<input type="text" name="idcard" /> <span style="color: red">(必填)</span></br>
						mobile:<input type="text" name="mobile" /> <span style="color: red">(必填)</span></br>
						address:<input type="text" name="address" /></br>
						photo:<input type="text" name="photo" /> <span style="color: red">(必填)</span></br>
						fingerprint:<input type="text" name="fingerprint" /></br>
						drilicence:<input type="text" name="drilicence" /></br>
						fstdrilicdate:<input type="text" name="fstdrilicdate" /></br>
						dripermitted:<input type="text" name="dripermitted" /></br>
						teachpermitted:<input type="text" name="teachpermitted" /></br>
						employstatus:<input type="text" name="employstatus" /> <span style="color: red">(必填)</span></br>
						hiredate:<input type="text" name="hiredate" /> <span style="color: red">(必填)</span></br>
						leavedate:<input type="text" name="leavedate" /></br>
						<input type="button" value="执行" onclick="submitForm(this)" /> </br>
						<div class="result_div"></div>
					</form>
				</div>
<hr />

				<div>
					<h3>ProvinceTrainingCarSuperviseAPI</h3>
					<form action="province/trainingcar" method="post">
						inscode:<input type="text" name="inscode" value="5851633716061642"/> <span style="color: red">(必填)</span></br>
						carnum:<input type="text" name="carnum" value="6445924856181536"/> <span style="color: red">(必填)</span></br>
						franum:<input type="text" name="franum" /></br>
						engnum:<input type="text" name="engnum" /></br>
						licnum:<input type="text" name="licnum" value="粤A1967学"/> <span style="color: red">(必填)</span></br>
						platecolor:<input type="text" name="platecolor" value="1"/> <span style="color: red">(必填)</span></br>
						photo:<input type="text" name="photo" /></br>
						manufacture:<input type="text" name="manufacture" value="Test"/> <span style="color: red">(必填)</span></br>
						brand:<input type="text" name="brand" value="Test"/> <span style="color: red">(必填)</span></br>
						model:<input type="text" name="model" /></br>
						perdritype:<input type="text" name="perdritype" value="C1"/> <span style="color: red">(必填)</span></br>
						buydate:<input type="text" name="buydate" value="20161201"/> <span style="color: red">(必填)</span></br>
						<input type="button" value="执行" onclick="submitForm(this)" /> </br>
						<div class="result_div"></div>
					</form>
				</div>
<hr />

				<div>
					<h3>ProvinceCharStandardSuperviseAPI</h3>
					<form action="province/charstandard" method="post">
						inscode:<input type="text" name="inscode" /> <span style="color: red">(必填)</span></br>
						seq:<input type="text" name="seq" /> <span style="color: red">(必填)</span></br>
						vehicletype:<input type="text" name="vehicletype" /> <span style="color: red">(必填)</span></br>
						trainningmode:<input type="text" name="trainningmode" /></br>
						subject:<input type="text" name="subject" /></br>
						trainningtime:<input type="text" name="trainningtime" /></br>
						chargemode:<input type="text" name="chargemode" /></br>
						paymode:<input type="text" name="paymode" /></br>
						service:<input type="text" name="service" /></br>
						price:<input type="text" name="price" /> <span style="color: red">(必填)</span></br>
						classcurr:<input type="text" name="classcurr" /> <span style="color: red">(必填)</span></br>
						uptime:<input type="text" name="uptime" /> <span style="color: red">(必填)</span></br>
						<input type="button" value="执行" onclick="submitForm(this)" /> </br>
						<div class="result_div"></div>
					</form>
				</div>
<hr />

				<div>
					<h3>ProvinceDeviceSuperviseAPI</h3>
					<form action="province/device" method="post">
						devnum:<input type="text" name="devnum" value="6106147544950515"/> <span style="color: red">(必填)</span></br>
						termtype:<input type="text" name="termtype" value="2"/> <span style="color: red">(必填)</span></br>
						vender:<input type="text" name="vender" value="酷商时代"/> <span style="color: red">(必填)</span></br>
						model:<input type="text" name="model" value="KS16"/> <span style="color: red">(必填)</span></br>
						imei:<input type="text" name="imei" value="C78546546"/> <span style="color: red">(必填)</span></br>
						sn:<input type="text" name="sn" value="KS160930"/> <span style="color: red">(必填)</span></br>
						inscode:<input type="text" name="inscode" value="2236581429084424"/></br>
						
						key:<input type="text" name="key" value="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"/> <span style="color: red">(必填)</span></br>
						password:<input type="text" name="password" value="a741Ls0z5h+J"/> <span style="color: red">(必填)</span></br>
						<input type="button" value="执行" onclick="submitForm(this)" /> </br>
						<div class="result_div"></div>
					</form>
				</div>
<hr />

				<div>
					<h3>ProvinceDevassignSuperviseAPI</h3>
					<form action="province/devassign" method="post">
						devnum:<input type="text" name="devnum" /> <span style="color: red">(必填)</span></br>
						carnum:<input type="text" name="carnum" /> <span style="color: red">(必填)</span></br>
						sim:<input type="text" name="sim" /> <span style="color: red">(必填)</span></br>
						<input type="button" value="执行" onclick="submitForm(this)" /> </br>
						<div class="result_div"></div>
					</form>
				</div>
<hr />

				<div>
					<h3>ProvinceDevRembindingSuperviseAPI</h3>
					<form action="province/devrembinding" method="post">
						devnum:<input type="text" name="devnum" /> <span style="color: red">(必填)</span></br>
						carnum:<input type="text" name="carnum" /> <span style="color: red">(必填)</span></br>
						sim:<input type="text" name="sim" /> <span style="color: red">(必填)</span></br>
						<input type="button" value="执行" onclick="submitForm(this)" /> </br>
						<div class="result_div"></div>
					</form>
				</div>
<hr />

				<div>
					<h3>ProvinceStudentSuperviseAPI</h3>
					<form action="province/student" method="post">
						inscode:<input type="text" name="inscode" /> <span style="color: red">(必填)</span></br>
						stunum:<input type="text" name="stunum" /> <span style="color: red">(必填)</span></br>
						cardtype:<input type="text" name="cardtype" /> <span style="color: red">(必填)</span></br>
						idcard:<input type="text" name="idcard" /> <span style="color: red">(必填)</span></br>
						nationality:<input type="text" name="nationality" /> <span style="color: red">(必填)</span></br>
						name:<input type="text" name="name" /> <span style="color: red">(必填)</span></br>
						sex:<input type="text" name="sex" /> <span style="color: red">(必填)</span></br>
						phone:<input type="text" name="phone" /> <span style="color: red">(必填)</span></br>
						address:<input type="text" name="address" /></br>
						photo:<input type="text" name="photo" /> <span style="color: red">(必填)</span></br>
						fingerprint:<input type="text" name="fingerprint" /></br>
						busitype:<input type="text" name="busitype" /> <span style="color: red">(必填)</span></br>
						drilicnum:<input type="text" name="drilicnum" /></br>
						fstdrilicdate:<input type="text" name="fstdrilicdate" /></br>
						perdritype:<input type="text" name="perdritype" /></br>
						traintype:<input type="text" name="traintype" /> <span style="color: red">(必填)</span></br>
						applydate:<input type="text" name="applydate" /> <span style="color: red">(必填)</span></br>
						<input type="button" value="执行" onclick="submitForm(this)" /> </br>
						<div class="result_div"></div>
					</form>
				</div>
<hr />

				<div>
					<h3>Province TransferSuperviseAPI</h3>
					<form action="province/ transfer" method="post">
						inscode:<input type="text" name="inscode" /> <span style="color: red">(必填)</span></br>
						stunum:<input type="text" name="stunum" /> <span style="color: red">(必填)</span></br>
						<input type="button" value="执行" onclick="submitForm(this)" /> </br>
						<div class="result_div"></div>
					</form>
				</div>
<hr />

				<div>
					<h3>ProvinceClassRecordSuperviseAPI</h3>
					<form action="province/classrecord" method="post">
						inscode:<input type="text" name="inscode" value="2236581429084424" /> <span style="color: red">(必填)</span></br>
						stunum:<input type="text" name="stunum" value="1013468626351111" /> <span style="color: red">(必填)</span></br>
						coachnum:<input type="text" name="coachnum" /></br>
						carnum:<input type="text" name="carnum" /></br>
						simunum:<input type="text" name="simunum" /></br>
						platnum:<input type="text" name="platnum" value="A0041"/> <span style="color: red">(必填)</span></br>
						recnum:<input type="text" name="recnum" value="00001"/> <span style="color: red">(必填)</span></br>
						subjcode:<input type="text" name="subjcode" value="2001010000"/> <span style="color: red">(必填)</span></br>
						photo1:<input type="text" name="photo1" value="231180"/> <span style="color: red">(必填)</span></br>
						photo2:<input type="text" name="photo2" /></br>
						photo3:<input type="text" name="photo3" value="231181"/> <span style="color: red">(必填)</span></br>
						starttime:<input type="text" name="starttime" value="20161201091000"/> <span style="color: red">(必填)</span></br>
						endtime:<input type="text" name="endtime" value="20161201101000"/> <span style="color: red">(必填)</span></br>
						duration:<input type="text" name="duration" value="1"/> <span style="color: red">(必填)</span></br>
						mileage:<input type="text" name="mileage" value="1"/> <span style="color: red">(必填)</span></br>
						avevelocity:<input type="text" name="avevelocity" /></br>
						coacmt:<input type="text" name="coacmt" /></br>
						total:<input type="text" name="total" value="4" /> <span style="color: red">(必填)</span></br>
						part1:<input type="text" name="part1" value="1"/> <span style="color: red">(必填)</span></br>
						part2:<input type="text" name="part2" value="1"/> <span style="color: red">(必填)</span></br>
						part3:<input type="text" name="part3" value="1"/> <span style="color: red">(必填)</span></br>
						part4:<input type="text" name="part4" value="1"/> <span style="color: red">(必填)</span></br>
						<input type="button" value="执行" onclick="submitForm(this)" /> </br>
						<div class="result_div"></div>
					</form>
				</div>
<hr />

				<div>
					<h3>ProvinceStageTrainningTimeSuperviseAPI</h3>
					<form action="province/stagetrainningtime" method="post">
						inscode:<input type="text" name="inscode" value="5851633716061642"/> <span style="color: red">(必填)</span></br>
						stunum:<input type="text" name="stunum" value="6161758136324302"/> <span style="color: red">(必填)</span></br>
						subject:<input type="text" name="subject" value="1"/> <span style="color: red">(必填)</span></br>
						totaltime:<input type="text" name="totaltime" value="60"/> <span style="color: red">(必填)</span></br>
						vehicletime:<input type="text" name="vehicletime" /></br>
						classtime:<input type="text" name="classtime" value="60"/></br>
						simulatortime:<input type="text" name="simulatortime" /></br>
						networktime:<input type="text" name="networktime" /></br>
						duration:<input type="text" name="duration" value="60"/> <span style="color: red">(必填)</span></br>
						examresult:<input type="text" name="examresult" value="0"/> <span style="color: red">(必填)</span></br>
						mileage:<input type="text" name="mileage" /></br>
						pdfid:<input type="text" name="pdfid" value="245185"/></br>
						esignature:<input type="text" name="esignature" value="7CB6D664EF6478EC92F2B0FA29BE2AFBD9B880F413F366C04CACE30E8E9173D4B75D66A6F0979D26A99B57E9F68371F53DDF6B9476E9CB7D935FC09641BE53E66620D715FC674C533E4514D9A817DB6202E3F68196F0F4C11BA04E1DCAF4FC5EC7B9DD28627051655FFE96F32AE066CE5D6B30C2B723C7EB714849B14D7D8BE42E070E89A202FACB2DA57665F919B7D1924CFEF2D5C233D754735E1BAF2971B4350880F22DD0862DB8C96F869C8210A4118DDCAA4B7EE7141E7A7FA2EED7344B6040D9E55FF62EF661066BFF75E782775631A5C1F0AC90ABD1479B8058C402477F6AE391280E865E414A2934EFE40BF8E02D6CA7118A694A9BE595A38E261FA8"/> <span style="color: red">(必填)</span></br> 
						rectype:<input type="text" name="rectype" value="2"/> <span style="color: red">(必填)</span></br>
						recarray:<input type="text" name="recarray" value='[{"rnum":"616175813632430200001"}]'/> <span style="color: red">(必填)</span></br>
						<!-- rnum:<input type="text" name="rnum" value="616175813632430200001"/> <span style="color: red">(必填)</span></br> -->
						<input type="button" value="执行" onclick="submitForm(this)" /> </br>
						<div class="result_div"></div>
					</form>
				</div>
<hr />

				<div>
					<h3>ProvinceGraduationSuperviseAPI</h3>
					<form action="province/graduation" method="post">
						stunum:<input type="text" name="stunum" value="1013468626351111"/> <span style="color: red">(必填)</span></br>
						autinscode:<input type="text" name="autinscode" value="5851633716061642"/> <span style="color: red">(必填)</span></br>
						gracertnum:<input type="text" name="gracertnum" /> <span style="color: red">(必填)</span></br>
						grantdate:<input type="text" name="grantdate" /> <span style="color: red">(必填)</span></br>
						pdfid:<input type="text" name="pdfid" /> <span style="color: red">(必填)</span></br>
						esignature:<input type="text" name="esignature" /> <span style="color: red">(必填)</span></br> 
						<input type="button" value="执行" onclick="submitForm(this)" /> </br>
						<div class="result_div"></div>
					</form>
				</div>
<hr />

				<div>
					<h3>ProvinceEvaluationSuperviseAPI</h3>
					<form action="province/evaluation" method="post">
						stunum:<input type="text" name="stunum" /> <span style="color: red">(必填)</span></br>
						evalobject:<input type="text" name="evalobject" /> <span style="color: red">(必填)</span></br>
						type:<input type="text" name="type" /> <span style="color: red">(必填)</span></br>
						overall:<input type="text" name="overall" /> <span style="color: red">(必填)</span></br>
						part:<input type="text" name="part" /></br>
						evaluatetime:<input type="text" name="evaluatetime" /> <span style="color: red">(必填)</span></br>
						srvmanner:<input type="text" name="srvmanner" /></br>
						teachlevel:<input type="text" name="teachlevel" /></br>
						<input type="button" value="执行" onclick="submitForm(this)" /> </br>
						<div class="result_div"></div>
					</form>
				</div>
<hr />

				<div>
					<h3>ProvinceComplaintSuperviseAPI</h3>
					<form action="province/complaint" method="post">
						stunum:<input type="text" name="stunum" /> <span style="color: red">(必填)</span></br>
						type:<input type="text" name="type" /> <span style="color: red">(必填)</span></br>
						objenum:<input type="text" name="objenum" /> <span style="color: red">(必填)</span></br>
						cdate:<input type="text" name="cdate" /> <span style="color: red">(必填)</span></br>
						content:<input type="text" name="content" /> <span style="color: red">(必填)</span></br>
						depaopinion:<input type="text" name="depaopinion" /></br>
						schopinion:<input type="text" name="schopinion" /></br>
						<input type="button" value="执行" onclick="submitForm(this)" /> </br>
						<div class="result_div"></div>
					</form>
				</div>
<hr />

				<div>
					<h3>ProvinceTrainimgInfoSuperviseAPI</h3>
					<form action="province/trainimginfo" method="post">
						inscode:<input type="text" name="inscode" /> <span style="color: red">(必填)</span></br>
						stunum:<input type="text" name="stunum" /> <span style="color: red">(必填)</span></br>
						coachnum:<input type="text" name="coachnum" /></br>
						subjcode:<input type="text" name="subjcode" /> <span style="color: red">(必填)</span></br>
						platnum:<input type="text" name="platnum" /> <span style="color: red">(必填)</span></br>
						recnum:<input type="text" name="recnum" /> <span style="color: red">(必填)</span></br>
						ptime:<input type="text" name="ptime" /> <span style="color: red">(必填)</span></br>
						fileid:<input type="text" name="fileid" /> <span style="color: red">(必填)</span></br>
						<input type="button" value="执行" onclick="submitForm(this)" /> </br>
						<div class="result_div"></div>
					</form>
				</div>
<hr />

				<div>
					<h3>ProvinceVideoRecordSuperviseAPI</h3>
					<form action="province/videorecord" method="post">
						devnum:<input type="text" name="devnum" /> <span style="color: red">(必填)</span></br>
						inscode:<input type="text" name="inscode" /> <span style="color: red">(必填)</span></br>
						stunum:<input type="text" name="stunum" /> <span style="color: red">(必填)</span></br>
						coachnum:<input type="text" name="coachnum" /></br>
						subjcode:<input type="text" name="subjcode" /> <span style="color: red">(必填)</span></br>
						recnum:<input type="text" name="recnum" /> <span style="color: red">(必填)</span></br>
						starttime:<input type="text" name="starttime" /> <span style="color: red">(必填)</span></br>
						endtime:<input type="text" name="endtime" /> <span style="color: red">(必填)</span></br>
						event:<input type="text" name="event" /> <span style="color: red">(必填)</span></br>
						fileid:<input type="text" name="fileid" /> <span style="color: red">(必填)</span></br>
						<input type="button" value="执行" onclick="submitForm(this)" /> </br>
						<div class="result_div"></div>
					</form>
				</div>
<hr />
		
		<!-- without body -->
		
				<div>
					<h3>ProvinceRegionReviewgetSuperviseAPI</h3>
					<form action="province/regionreview/get" method="post">
						inscode:<input type="text" name="inscode"  /><span style="color: red">(必填)</span></br>
						seq:<input type="text" name="seq"  /><span style="color: red">(必填)</span></br>
						<input type="button" value="执行" onclick="submitForm(this)" /> </br>
						<div class="result_div"></div>
					</form>
				</div>
<hr />

				<div>
					<h3>ProvinceRegiondeleteSuperviseAPI</h3>
					<form action="province/region/delete" method="post">
						inscode:<input type="text" name="inscode"  /><span style="color: red">(必填)</span></br>
						seq:<input type="text" name="seq"  /><span style="color: red">(必填)</span></br>
						<input type="button" value="执行" onclick="submitForm(this)" /> </br>
						<div class="result_div"></div>
					</form>
				</div>
<hr />

				<div>
					<h3>ProvinceCoachdeleteSuperviseAPI</h3>
					<form action="province/coach/delete" method="post">
						coachnum:<input type="text" name="coachnum"  /><span style="color: red">(必填)</span></br>
						<input type="button" value="执行" onclick="submitForm(this)" /> </br>
						<div class="result_div"></div>
					</form>
				</div>
<hr />

				<div>
					<h3>ProvinceExaminerdeleteSuperviseAPI</h3>
					<form action="province/examiner/delete" method="post">
						examnum:<input type="text" name="examnum"  /><span style="color: red">(必填)</span></br>
						<input type="button" value="执行" onclick="submitForm(this)" /> </br>
						<div class="result_div"></div>
					</form>
				</div>
<hr />

				<div>
					<h3>ProvinceSecurityguarddeleteSuperviseAPI</h3>
					<form action="province/securityguard/delete" method="post">
						secunum:<input type="text" name="secunum"  /><span style="color: red">(必填)</span></br>
						<input type="button" value="执行" onclick="submitForm(this)" /> </br>
						<div class="result_div"></div>
					</form>
				</div>
<hr />

				<div>
					<h3>ProvinceTrainingCardeleteSuperviseAPI</h3>
					<form action="province/trainingcar/delete" method="post">
						carnum:<input type="text" name="carnum"  /><span style="color: red">(必填)</span></br>
						<input type="button" value="执行" onclick="submitForm(this)" /> </br>
						<div class="result_div"></div>
					</form>
				</div>
<hr />

				<div>
					<h3>ProvinceCharStandarddeleteSuperviseAPI</h3>
					<form action="province/charstandard/delete" method="post">
						inscode:<input type="text" name="inscode"  /><span style="color: red">(必填)</span></br>
						seq:<input type="text" name="seq"  /><span style="color: red">(必填)</span></br>
						<input type="button" value="执行" onclick="submitForm(this)" /> </br>
						<div class="result_div"></div>
					</form>
				</div>
<hr />

				<div>
					<h3>ProvinceDevicedeleteSuperviseAPI</h3>
					<form action="province/device/delete" method="post">
						devnum:<input type="text" name="devnum"  /><span style="color: red">(必填)</span></br>
						<input type="button" value="执行" onclick="submitForm(this)" /> </br>
						<div class="result_div"></div>
					</form>
				</div>
<hr />

				<div>
					<h3>ProvinceStuinfoQuerygetSuperviseAPI</h3>
					<form action="province/stuinfoquery/get" method="post">
						stunum:<input type="text" name="stunum"  /><span style="color: red">(必填)</span></br>
						<input type="button" value="执行" onclick="submitForm(this)" /> </br>
						<div class="result_div"></div>
					</form>
				</div>
<hr />

				<div>
					<h3>ProvinceTraininfogetSuperviseAPI</h3>
					<form action="province/traininfo/get" method="post">
						 stunum :<input type="text" name=" stunum "  /><span style="color: red">(必填)</span></br>
						<input type="button" value="执行" onclick="submitForm(this)" /> </br>
						<div class="result_div"></div>
					</form>
				</div>
<hr />

				<div>
					<h3>ProvinceStageTrainningTimeReviewgetSuperviseAPI</h3>
					<form action="province/stagetrainningtimereview/get" method="post">
						stunum:<input type="text" name="stunum"  /><span style="color: red">(必填)</span></br>
						subject:<input type="text" name="subject"  /><span style="color: red">(必填)</span></br>
						<input type="button" value="执行" onclick="submitForm(this)" /> </br>
						<div class="result_div"></div>
					</form>
				</div>
<hr />

				<div>
					<h3>ProvinceEvaluationQuerygetSuperviseAPI</h3>
					<form action="province/evaluationquery/get" method="post">
						inscode:<input type="text" name="inscode"  /><span style="color: red">(必填)</span></br>
						querydate:<input type="text" name="querydate"  /><span style="color: red">(必填)</span></br>
						<input type="button" value="执行" onclick="submitForm(this)" /> </br>
						<div class="result_div"></div>
					</form>
				</div>
<hr />

				<div>
					<h3>ProvinceComplaintQuerygetSuperviseAPI</h3>
					<form action="province/complaintquery/get" method="post">
						inscode:<input type="text" name="inscode"  /><span style="color: red">(必填)</span></br>
						querydate:<input type="text" name="querydate"  /><span style="color: red">(必填)</span></br>
						<input type="button" value="执行" onclick="submitForm(this)" /> </br>
						<div class="result_div"></div>
					</form>
				</div>
<hr />

				<div>
					<h3>StuinfoGet</h3>
					<form action="stuinfoApi" method="get">
						cardnum:<input type="text" name="cardnum"  value="431381197007126616"/><span style="color: red">(必填)</span></br>
						name:<input type="text" name="name"  value="测试"/><span style="color: red">(必填)</span></br>
						<input type="button" value="执行" onclick="submitForm(this)" /> </br>
						<div class="result_div"></div>
					</form>
				</div>
<hr />
				<div>
					<h3>UploadFile</h3>
					<form action="upload/file/url" method="post">
						type:<input type="text" name="type"  value="stuimg"/><span style="color: red">(必填)</span></br>
						url:<input type="text" name="url"  value="http://img.91ygxc.com/2016/10/11/91efce96-95e6-4236-bd5e-3d1d49d785d5_s.png"/><span style="color: red">(必填)</span></br>
						level:<input type="text" name="level"  value="1"/><span style="color: red">(必填)1-全国 2-省</span></br>
						<input type="button" value="执行" onclick="submitForm(this)" /> </br>
						<div class="result_div"></div>
					</form>
					
				</div>
<hr />		
				<div>
					<h3>Reviewmsg</h3>
					<form action="reviewmsg" method="post">
						reviewtype:<input type="text" name="reviewtype" id="reviewtype" value="1"/><span style="color: red">(必填1 or 2)</span></br>
						inscode:<input type="text" name="inscode" id="inscode" value="5851633716061642"/><span style="color: red">(必填1)</span></br>
						seq:<input type="text" name="seq" id="seq" value="1"/><span style="color: red">(必填1)</span></br>
						stunum:<input type="text" name="stunum"  id="stunum" value="123321"/><span style="color: red">(必填2)</span></br>
						subject:<input type="text" name="subject" id="subject" value="1"/><span style="color: red">(必填2)</span></br>
						<input type="button" value="执行" onclick="subMsg()" /> </br>
						<div class="zzz"></div>
					</form>
					<script type="text/javascript">
						function subMsg(){
							var reviewtype=$("#reviewtype").val();
							var inscode=$("#inscode").val();
							var seq=$("#seq").val();
							var stunum=$("#stunum").val();
							var subject=$("#subject").val();
							var data=null;
							var params=null;
							if(reviewtype==1){
								data={
									'inscode':inscode,
									'seq':seq
								};
							}else if(reviewtype==2){
								data={
									'stunum':stunum,
									'subject':subject
								};
							}
							var a=JSON.stringify(data);
							params={
									'data':a
								};
							$.ajax({
								type : 'post',
								url : '/reviewmsg?reviewtype='+reviewtype,
								data : params,
								dataType : "text",
								success : function(data) {
									console.log(data);
									$(".zzz").text(data);
								}
							});
						}
					</script>
				</div>
<hr />		
				<div>
					<h3>Recordchangemsg</h3>
					<form action="recordchangemsg" method="post">
						recordtype:<input type="text" name="recordtype" id="recordtype"/><span style="color: red">(必填)</span></br>
						changetype:<input type="text" name="changetype" id="changetype" /><span style="color: red">(必填)</span></br>
						inscode:<input type="text" name="inscode" id="inscode" /><span style="color: red">(必填)</span></br>
						recordnum:<input type="text" name="recordnum"  id="recordnum"/><span style="color: red">(必填)</span></br>
						<input type="button" value="执行" onclick="subMsg2()" /> </br>
						<div class="result_divm"></div>
					</form>
					<script type="text/javascript">
						function subMsg2(){
							var recordtype=$("#recordtype").val();
							var changetype=$("#changetype").val();
							var inscode=$("#inscode").val();
							var recordnum=$("#recordnum").val();
							var params=null;
							params={
									'recordtype':recordtype,
									'changetype':changetype,
									'inscode':inscode,
									'recordnum':recordnum
								};
							$.ajax({
								type : 'post',
								/*url : '${ctx}/supervise/recordchangemsg',*/
								url : '/recordchangemsg',
								data : params,
								dataType : "text",
								success : function(data) {
									console.log(data);
									$(".result_divm").text(data);
								}
							});
						}
					</script>
				</div>
<hr />					
				
					
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
	function submitForm(button) {
		var form = $(button).parent();
		var url = form.attr('action');
		console.log(url);
		var method = form.attr('method');
		method = method ? method : "GET";
		console.log(method);
		var param = {};
		$(form).find('input').each(function() {
			var value = $(this).val();
			var name = $(this).attr("name");
			var restful = $(this).attr("restful");
			if (restful) {
				console.log("restful:" + restful)
				url = url.replace('{' + restful + '}', value);
			}
			else {
				param[name] = value;
			}
		});
	
		$.ajax({
			type : method,
			url : url,
			data : param,
			dataType : "text",
			success : function(data) {
				console.log(data);
				$(form).find(".result_div").text(data);
			}
		});
	}
	
	
	
	function fileTypeChange(value,fileId) {
		
		$("#"+ fileId).val(value);
	
	}
	
</script>
</html>


