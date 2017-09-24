package com.bjxc.supervise.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;

public interface DeleteMapper {

	/**
	 * 教练车删除
	 */
	@Deprecated
	@Delete("delete from trainingcar where carnum=#{carnum}")
	// @Delete("delete from t_training_car where car_num=#{carnum}")
	Integer deletecar(Map map);

	/**
	 * 教练员删除
	 * 
	 * @param map
	 * @return
	 */
	@Deprecated
	@Delete("delete from tcoach where coachnum=#{coachnum}")
	// @Delete("delete from t_coach where coach_num=#{coachnum}")
	Integer deleteCoach(Map map);

	/**
	 * 省-计时终端删除
	 */
	@Deprecated
	@Delete("delete from tdevice where devnum=#{devnum}")
	// @Delete("delete from t_training_device where dev_num=#{devnum}")
	Integer deletedm(Map map);

	/**
	 * 省-考核员删除
	 * 
	 * @param map
	 * @return
	 */
	@Deprecated
	@Delete("delete from texaminer where examnum=#{examnum}")
	// @Delete("delete from t_examiner where exam_num=#{examnum}")
	Integer deleteExaminer(Map map);

	/**
	 * 省-安全员删除
	 * 
	 * @param map
	 * @return
	 */
	@Deprecated
	@Delete("delete from tsecurity where secunum=#{secunum}")
	// @Delete("delete from t_safety_officer where secu_num=#{secunum}")
	Integer deleteSecurity(Map map);

	/**
	 * 省-解绑计时终端和车辆******没用？？？？？
	 */
	@Delete("delete from tdevassign")
	@Deprecated
	// @Delete("delete from t_dev_assign **")
	Integer deletetdevassign(Map map);

	/**
	 * 省-删除收费标准
	 * 
	 * @param map
	 * @return
	 */
	@Deprecated
	@Delete("delete from tcharstandard where Inscode=#{inscode} and seq=#{seq}")
	Integer deleteCharStandard(Map map);

}
