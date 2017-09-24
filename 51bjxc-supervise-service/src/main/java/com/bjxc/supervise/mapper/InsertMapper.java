package com.bjxc.supervise.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Insert;

public interface InsertMapper {
	/**
	 * 全国-机构添加
	 */
	@Deprecated
	@Insert("INSERT INTO TInstitution (`Name`, `district`, `ShortName`, `Licnum`, `Licetime`, `Business`, `Creditcode`, `postcode`, `Address`, `Legal`, `Busistatus`, `Contact`, `Phone`, `Inscode`, `level`, `coachnumber`, `grasupvnum`, `safmngnum`, `tracarnum`, `classroom`, `thclassroom`, `praticefield`, `busiscope`) VALUES (#{name}, #{district}, #{shortname}, #{licnum}, #{licetime}, #{business}, #{creditcode}, #{postcode},  #{address}, #{legal}, #{busistatus}, #{contact}, #{phone}, #{inscode}, #{level}, #{coachnumber}, #{grasupvnum}, #{safmngnum}, #{tracarnum}, #{classroom}, #{thclassroom}, #{praticefield}, #{busiscope})")
	Integer addInstitution(Map map);

	
	/**
	 * 省-教学区域新增
	 */
	@Deprecated
	@Insert("INSERT INTO tdrivingfield ( Name,CoaTotal, CarTotal, InsId, Address, polygon, Status, Area, AreaSize, type, seq, vehicletype, totalvehnum, curvehnum, areaId)  VALUES (#{name},#{coatotal},#{cartotal},#{inscode},#{address},#{polygon},#{status},#{area},#{areasize},#{type},#{seq},#{vehicletype},#{totalvehnum},#{curvehnum},#{areaid})")
	Integer addRegion(Map map);

	
	/**
	 * 全国-学生添加
	 */
	@Deprecated
	@Insert("INSERT INTO `tstudent` (`InsId`, `Name`, `Mobile`, `cardtype`, `Idcard`, `Nationality`, `Sex`, `Address`, `Photo`, `Fingerprint`, `Busitype`, `Drilicnum`, `Fstdrilicdate`, `Perdritype`, `Traintype`, `Applydate`,stunum) VALUES (#{inscode}, #{name}, #{phone}, #{cardtype}, #{idcard}, #{nationality}, #{sex}, #{address}, #{photo}, #{fingerprint}, #{busitype}, #{drilicnum}, #{fstdrilicdate}, #{perdritype}, #{traintype}, #{applydate},#{stunum})")
	Integer addStudent(Map map);

	
	/**
	 * 全国-教练添加
	 */
	@Deprecated
	@Insert("INSERT INTO `tcoach` (`InsId`, `Name`, `Sex`, `Idcard`, `Mobile`, `Address`, `Photo`, `Fingerprint`, `Drilicence`, `Occupationlevel`, `Dripermitted`, `Teachpermitted`, `Employstatus`, `Hiredate`, `Leavedate`, `Coachnum`, `Occupationno`) VALUES (#{inscode}, #{name}, #{sex}, #{idcard}, #{mobile}, #{address}, #{photo}, #{fingerprint}, #{drilicence}, #{occupationlevel}, #{dripermitted}, #{teachpermitted}, #{employstatus}, #{hiredate}, #{leavedate}, #{coachnum}, #{occupationno})")
	Integer addCoach(Map map);
	
	/**
	 * 全国-考核员添加
	 */
	@Deprecated
	@Insert("INSERT INTO `texaminer` (`inscode`, `name`, `sex`, `idcard`, `mobile`, `address`, `photo`, `fingerprint`, `drilicence`, `fstdrilicdate`, `dripermitted`, `teachpermitted`, `employstatus`, `hiredate`, `leavedate`, `occupationno`, `occupationlevel`,  `examnum`) VALUES (#{inscode}, #{name}, #{sex}, #{idcard}, #{mobile}, #{address}, #{photo}, #{fingerprint}, #{drilicence}, #{fstdrilicdate}, #{dripermitted}, #{teachpermitted}, #{employstatus}, #{hiredate}, #{leavedate}, #{occupationno}, #{occupationlevel}, #{examnum})")
	Integer addExaminer(Map map);
	
	/**
	 * 全国-安全员添加
	 */
	@Deprecated
	@Insert("INSERT INTO `tsecurity` (`inscode`, `name`, `sex`, `idcard`, `mobile`, `address`, `photo`, `fingerprint`, `drilicence`, `fstdrilicdate`, `dripermitted`, `teachpermitted`, `employstatus`, `hiredate`, `leavedate`, `secunum`) VALUES (#{inscode}, #{name}, #{sex}, #{idcard}, #{mobile}, #{address}, #{photo}, #{fingerprint}, #{drilicence}, #{fstdrilicdate}, #{dripermitted}, #{teachpermitted}, #{employstatus}, #{hiredate}, #{leavedate}, #{secunum})")
	Integer addSecurity(Map map);
	
	/**
	 * 全国-计时终端添加
	 */
	@Deprecated
	@Insert("INSERT INTO `tdevice` (`termtype`, `vender`, `model`, `imei`, `sn`, `devnum`, `key`, `passwd`,`cerbase64`) VALUES (#{termtype}, #{vender}, #{model}, #{imei}, #{sn}, #{devnum}, #{key}, #{passwd},#{cerbase64})")
	Integer addDevice(Map map);
	
	/**
	 * 全国-车辆添加
	 */
	@Deprecated
	@Insert("INSERT INTO trainingcar(inscode, franum, engnum, licnum, platecolor,photo,manufacture,brand,model,perdritype,buydate,photourl,carnum,coachId,remarks,insId) VALUES (#{inscode},#{franum},#{engnum},#{licnum},#{platecolor},#{photo},#{manufacture},#{brand},#{model},#{perdritype},#{buydate},#{photourl},#{carnum},#{coachId},#{remarks},#{insid})")
	Integer addcar(Map map);
	
	/**
	 * 省-评价信息交换
	 * @param map
	 * @return
	 */
	@Deprecated
	@Insert("INSERT INTO tevaluation(stunum,evalobject,type,overall,part,evaluatetime,srvmanner,teachlevel) VALUES (#{stunum},#{evalobject},#{type},#{overall},#{part},#{evaluatetime},#{srvmanner},#{teachlevel})")
	Integer addEvaluation(Map map);
	
	/**
	 * 省-评价信息交换
	 * @param map
	 * @return
	 */
	@Deprecated
	@Insert("INSERT INTO tComplaint(stunum,type,objectId,cdate,content,depaopinion,schopinion) VALUES (#{stunum},#{type},#{objenum},#{cdate},#{content},#{depaopinion},#{schopinion})")
	Integer addComplaint(Map map);
	
	

	

	/**
	 * 省-电子教学日志
	 */
	@Deprecated
	@Insert("INSERT INTO classrecord (`inscode`, `stunum`, `coachnum`, `carnum`, `simunum`, `platnum`, `recnum`, `subjcode`, `photo1`, `photo2`, `photo3`, `starttime`, `endtime`, `duration`, `mileage`, `avevelocity`, `coacmt`, `total`, `part1`, `part2`, `part3`, `part4`) VALUES (#{inscode},#{stunum},#{coachnum},#{carnum},#{simunum},#{platnum},#{recnum},#{subjcode},#{photo1},#{photo2},#{photo3},#{starttime},#{endtime},#{duration},#{mileage},#{avevelocity},#{coacmt},#{total},#{part1},#{part2},#{part3},#{part4})")
    Integer classrecord(Map map);
	
	/**
	 * 省-计时终端绑定教练车
	 */
	@Deprecated
	@Insert("INSERT INTO tdevassign( `deviceId`, `trainingcarId`, `sim`) VALUES (#{deviceId},#{trainingcarId},#{sim})")
	Integer addDevassign(Map map);
	
	/**
	 * 省-培训记录上报
	 */
	@Deprecated
	@Insert("INSERT INTO stagetrainningtime (`inscode`, `stunum`, `subject`, `totaltime`, `vehicletime`, `classtime`, `simulatortime`, `networktime`, `duration`, `examresult`, `mileage`, `pdfid`, `esignature`, `rectype`, `recarray`, `rnum`) VALUES (#{inscode}, #{stunum}, #{subject}, #{totaltime}, #{vehicletime}, #{classtime}, #{simulatortime}, #{networktime}, #{duration}, #{examresult}, #{mileage}, #{pdfid}, #{esignature}, #{rectype}, #{recarray}, #{rnum})")
    Integer addstagetrainningtime(Map map);

	/**
	 * 省-培训过程视频资料信息 增加
	 */
	@Deprecated
	@Insert("INSERT INTO `videorecord` (`devnum`, `inscode`, `stunum`, `coachnum`, `subjcode`, `recnum`, `starttime`, `endtime`, `event`, `fileid`) VALUES "
			+ "(#{devnum}, #{inscode}, #{stunum}, #{coachnum}, #{subjcode}, #{recnum}, #{starttime}, #{endtime}, #{event}, #{fileid});")
	Integer insertVideoRecord(Map map);
	/**
	 * 省-培训过程图片资料信息 增加
	 */
	@Deprecated
	@Insert("INSERT INTO `trainimginfo` ( `inscode`, `stunum`, `coachnum`, `subjcode`, `platnum`, `recnum`, `ptime`, `fileid`) VALUES "
			+ "(#{inscode}, #{stunum}, #{coachnum}, #{subjcode}, #{platnum}, #{recnum}, #{ptime}, #{fileid});")
	Integer addTrainimgInfo(Map map);

	//@Insert("insert thttp_log(content,createtime) value(#{log},now())")
	@Insert("insert t_log_http(log_content,log_time) value(#{log},now())")
	Integer addHttpLog(String log);
	
	@Deprecated
	/**
	 * ?????????????????
	 * @param map
	 * @return
	 */
	//@Insert("insert into trainingrecord(studentId,coachId,createtime,courseCode,status,maxSpeed,distance,locationInfoId,trainingcarId,deviceId,starttime,endtime,recordCode,courseType,subjectId,loginPhotoUrl,logoutPhotoUrl,etrainingLogCode) "
	//		+ "values((select id from tstudent where stunum=#{stunum}),1,now(),0,1,0,0,1,1,1,#{starttime},#{endtime},#{subjcode},1,1,'a','b',#{recnum})")
	Integer addTeachLog(Map map);
}
