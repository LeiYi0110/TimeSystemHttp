package com.bjxc.supervise.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Select;

public interface SelectMapper {
	@Deprecated
	@Select("select * from tdrivingfield where insid=#{inscode} and seq=#{seq}")
	Map getArea(Map map);
	
	@Deprecated
	@Select("select * from stagetrainningtime where stunum=#{stunum} and subject=#{subject}")
	Map getSta(Map map);
	
	@Select("select id from t_student where stu_num=#{stunum}")
	//@Select("select id from tstudent where stunum=#{stunum}")
	Integer getStuId(String stunum);
	
	@Select("select id from t_institution where Ins_code=#{inscode}")
	//@Select("select id from tinstitution where Inscode=#{inscode}")
	Integer getInsid(String inscode);
	
	/**
	 * 省-查询审核结果
	 */
	@Deprecated
	@Select("select * from tdrivingfield where insId=#{inscode} and seq=#{seq}")
	Map gettdf(Map map);
}

