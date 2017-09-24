package com.bjxc.supervise.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

public interface UpdateMapper {
	/**
	 * 省--教学区域修改
	 */
	@Deprecated
	@Update("UPDATE tdrivingfield SET name=#{name},coatotal=#{coatotal},cartotal=#{cartotal},insid=#{insid},address=#{address},polygon=#{polygon},status=#{status},area=#{area},areasize=#{areasize},type=#{type},seq=#{seq},vehicletype=#{vehicletype},totalvehnum=#{totalvehnum},curvehnum=#{curvehnum},areaid=#{areaid} WHERE seq=#{seq}")
	Integer updateRegion(Map map);

	@Deprecated
	@Update("UPDATE trainingcar SET inscode=#{inscode}, franum=#{faranum}, engnum=#{engnum}, licnum=#{licnum}, platecolor=#{platecolor}, photo=#{photo}, manufacture=#{manufacture}, brand=#{vrand}, model=#{model}, perdritype=#{perdritype}, buydate=#{buydate}, photourl=#{photourl},carnum=#{carnum}, coachId=#{coachid},remarks=#{remarks}, insId=#{insid} WHERE carnum=#{carnum})")
	Integer updatecar(Map map);

	/**
	 * 省-更新培训机构
	 * 
	 * @param map
	 * @return
	 */
	@Deprecated
	@Update("UPDATE `tinstitution` SET `Name`=#{name}, `district`=#{district}, `ShortName`=#{shortname}, `Licnum`=#{licnum}, `Licetime`=#{licetime},"
			+ " `Business`=#{business}, `Creditcode`=#{creditcode}, `postcode`=#{postcode}, `Province`=#{province}, `City`=#{city}, `Area`=#{area},"
			+ " `Address`=#{address}, `Legal`=#{legal}, `Busistatus`=#{busistatus}, `Contact`=#{contact}, `Phone`=#{phone},"
			+ " `level`=#{level}, `coachnumber`=#{coachnumber}, `grasupvnum`=#{grasupvnum}, `safmngnum`=#{safmngnum}, `tracarnum`=#{tracarnum}, `classroom`=#{classroom}, `thclassroom`=#{thclassroom}, `praticefield`=#{praticefield},"
			+ " `introduction`=#{introduction}, `busiscope`=#{busiscope}" + " WHERE (`Inscode`=#{inscode});")
	Integer updateInstitution(Map map);

	/**
	 * 省-更新教练
	 * 
	 * @param map
	 * @return
	 */
	@Deprecated
	@Update("UPDATE `tcoach` SET `InsId`=#{inscode}, `Name`=#{name}, `Sex`=#{sex}, `Idcard`=#{idcard}, `Mobile`=#{mobile}, `Address`=#{address}, `Photo`=#{photo},"
			+ " `Fingerprint`=#{fingerprint}, `Drilicence`=#{drilicence}, `Occupationlevel`=#{occupationlevel}, `Dripermitted`=#{dripermitted}, `Teachpermitted`=#"
			+ "{teachpermitted}, `Employstatus`=#{employstatus}, `Hiredate`=#{hiredate}, `Leavedate`=#{leavedate},`Occupationno`=#{occupationno} WHERE (`Coachnum`=#"
			+ "{coachnum});")
	Integer updateCoach(Map map);

	/**
	 * 省-计时终端备案修改
	 */
	@Deprecated
	@Update("UPDATE tdevice SET termtype=#{termtype}, vender=#{vender}, model=#{model}, imei=#{imei}, sn=#{sn}, devnum=#{devnum}, key=#{key}, passwd=#{password}, createdate=#{createdate}, insId=#{insid} WHERE devnum=#{devnum})")
	Integer updatedevice(Map map);

	/**
	 * 省-更新考核员
	 * 
	 * @param map
	 * @return
	 */
	@Update("UPDATE `texaminer` SET `inscode`=#{inscode}, `name`=#{name}, `sex`=#{sex}, `idcard`=#{idcard}, `mobile`=#{mobile}, `address`=#{address}, `photo`=#{photo},"
			+ " `fingerprint`=#{fingerprint}, `drilicence`=#{drilicence}, `fstdrilicdate`=#{fstdrilicdate}, `dripermitted`=#{dripermitted}, `teachpermitted`=#{teachpermitted},"
			+ " `employstatus`=#{employstatus}, `hiredate`=#{hiredate}, `leavedate`=#{leavedate}, `occupationno`=#{occupationno}, `occupationlevel`=#{occupationlevel}, `examnum`=#{examnum}"
			+ " WHERE (`examnum`=#{examnum});")
	Integer updateExaminer(Map map);

	@Deprecated
	/**
	 * 省-学员备案和修改
	 */
	@Update("UPDATE tstudent SET  InsId=#{insid}, Name=#{name}, Mobile=#{mobile}, cardtype=#{cardtype}, Idcard=#{idcard}, Nationality=#{nationality}, Sex=#{sex}, Address=#{address}, Photo=#{photo}, Fingerprint=#{fingerprint}, Busitype=#{busitype}, Drilicnum=#{drilicnum},Fstdrilicdate=#{Fstdrilicdate}, Perdritype=#{perdritype}, Traintype=#{traintype}, Applydate=#{applydate}, stunum=#{stunum}, Status=#{status}, Arrearage=#{arrearage} WHERE stunum=#{stunum}")
	Integer updateStudent(Map map);

	@Deprecated
	/**
	 * 省-更新安全员
	 * 
	 * @param map
	 * @return
	 */
	@Update("UPDATE `tsecurity` SET `inscode`=#{inscode}, `name`=#{name}, `sex`=#{sex}, `idcard`=#{idcard}, `mobile`=#{mobile}, `address`=#{address}, `photo`=#{photo}, `fingerprint`=#{fingerprint},"
			+ " `drilicence`=#{drilicence}, `fstdrilicdate`=#{fstdrilicdate}, `dripermitted`=#{dripermitted}, `teachpermitted`=#{teachpermitted}, `employstatus`=#{employstatus}, `hiredate`=#{hiredate}, `leavedate`=#{leavedate}, `secunum`=#{secunum} WHERE (`mobile`=#{mobile});")
	Integer updateSecurity(Map map);

	@Deprecated
	/**
	 * 省-更新 收费标准
	 * 
	 * @param map
	 * @return
	 */
	@Update("UPDATE `tcharstandard` SET `inscode`=#{inscode}, `seq`=#{seq}, `vehicletype`=#{vehicletype}, `trainningmode`=#{trainningmode},"
			+ " `subject`=#{subject}, `trainningtime`=#{trainningtime}, `chargemode`=#{chargemode}, `paymode`=#{paymode}, `service`=#{service},"
			+ " `price`=#{price}, `classcurr`=#{classcurr}, `uptime`=#{uptime} WHERE (`seq`=#{seq} and `inscode`=#{inscode});")
	Integer updateCharStandard(Map map);

	@Deprecated
	/**
	 * 省-学员跨培训机构备案
	 */
	@Update("UPDATE tstudent SET InsId=#{inscode} WHERE  stunum=#{stunum}")
	Integer updatetstudents(Map map);

	@Deprecated
	/**
	 * XXXXXXXXXXXXXXXX
	 * 
	 * @param map
	 * @return
	 */
	Integer updateDevice2(Map map);

	@Deprecated
	/**
	 * XXXXXXXXXXXXXXX
	 * 
	 * @param map
	 * @return
	 */
	Integer updateCoach2(Map map);

	@Deprecated
	/**
	 * XXXXXXXXXXXXXX
	 * 
	 * @param map
	 * @return
	 */
	Integer updateExam2(Map map);

	@Deprecated
	/**
	 * XXXXXXXXXXXXXXXX
	 * 
	 * @param map
	 * @return
	 */
	Integer updateCar2(Map map);

	@Deprecated
	/**
	 * XXXXXXXXXXXXXXXXXX
	 * 
	 * @param map
	 * @return
	 */
	Integer updateSafe2(Map map);

	@Update("update t_coach set is_province=#{type} where coach_num=#{recordNum};")
	// @Update("update TCoach set isProvince=#{type} where
	// coachNum=#{recordNum};")
	Integer updateCoachprovince(Map map);

	@Update("update t_examiner set is_province=#{type} where exam_num=#{recordNum}")
	// @Update("update texaminer set isProvince=#{type} where
	// examnum=#{recordNum}")
	Integer updateExaminerprovince(Map map);

	@Update("update t_safety_officer set is_province=#{type} where secu_num=#{recordNum}")
	//@Update("update tsecurity set isProvince=#{type} where secunum=#{recordNum}")
	Integer updateSecurityprovince(Map map);

	@Update("update t_training_car set is_province=#{type} where car_num=#{recordNum}")
	//@Update("update TrainingCar set isProvince=#{type} where carnum=#{recordNum}")
	Integer updateTrainingCarprovince(Map map);

	@Update("update t_driving_field set is_notice=#{type},reason=#{reason} where seq=#{seq} and ins_id=(select id from t_institution where Ins_code=#{inscode});")
	//@Update("update TDrivingField set isNotice=#{type},reason=#{reason} where seq=#{seq} and insid=(select id from TInstitution where inscode=#{inscode});")
	Integer updateDrivingfieldprovince(Map map);

	@Deprecated
	@Update("update TDrivingField set isNotice=1 where seq=#{seq} and insid=(select id from TInstitution where inscode=#{inscode});")
	Integer updateIsnotice(@Param("seq") Integer seq, @Param("inscode") String inscode);

	@Update("update t_training_result set valid=#{valid},validtime=#{validtime},needfultime=#{needfultime},pdfid=#{pdfid} where stunum=#{stunum} and subjectId=#{subject}")
	//@Update("update jtrainingresult set valid=#{valid},validtime=#{validtime},needfultime=#{needfultime},pdfid=#{pdfid} where stunum=#{stunum} and subjectId=#{subject}")
	Integer updateTimeResult(Map map);

	@Update("update t_training_record set is_province_pass=1 where student_Id=(select id from t_student where stu_num=#{stunum}) and subject_id=#{subject}")
	//@Update("update trainingrecord set pass=1 where studentId=(select id from tstudent where stunum=#{stunum}) and subjectId=#{subject}")
	Integer updateTimePass(Map map);

	// @Update("update trainingrecord set pass=0,reason=#{reason} where
	// recordCode=#{rnum} and studentId=(select id from tstudent where
	// stunum=#{stunum})")
	@Update("update t_training_log set is_province_pass=0,province_reason=#{reason} where record_num=#{rnum} and student_num=#{stunum}")
	//@Update("update TrainingLog set propass=0,reason=#{reason} where recordnum=#{rnum} and studentnum=#{stunum}")
	Integer updateTimeFailBy3(@Param("reason") String reason, @Param("rnum") String rnum,
			@Param("stunum") String stunum);

	@Update("update t_training_record set is_province_pass=0,province_reason=#{reason} where e_training_num=#{rnum} and student_Id=(select id from t_student where stu_num=#{stunum})")
	// @Update("update trainingrecord set pass=0,reason=#{reason} where
	// eTrainingLogCode=#{rnum} and studentId=(select id from tstudent where
	// stunum=#{stunum})")
	Integer updateTimeFail(@Param("reason") String reason, @Param("rnum") String rnum, @Param("stunum") String stunum);
	
	
}



