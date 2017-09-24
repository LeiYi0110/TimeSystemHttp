package com.bjxc.supervise.mapper;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import junit.framework.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext.xml")
public class UpdateMapperTest {

	@Resource
	private UpdateMapper updateMapper;

	@Test
	public void testUpdateCoachprovince() {

		Map map = new HashMap<>();

		map.put("type", 6);
		map.put("recordNum", "666666666");

		Integer row = updateMapper.updateCoachprovince(map);

		Assert.assertTrue(row > 0);// ok

	}

	@Test
	public void testUpdateExaminerprovince() {

		Map map = new HashMap<>();

		map.put("type", 6);
		map.put("recordNum", "888888888");

		Integer row = updateMapper.updateExaminerprovince(map);

		Assert.assertTrue(row > 0);// ok
	}

	@Test
	public void testUpdateSecurityprovince() {

		Map map = new HashMap<>();

		map.put("type", 6);
		map.put("recordNum", "Securityprovince");

		Integer row = updateMapper.updateSecurityprovince(map);
		Assert.assertTrue(row > 0);// ok
	}

	@Test
	public void testUpdateTrainingCarprovince() {

		Map map = new HashMap<>();

		map.put("type", 6);
		map.put("recordNum", "TrainingCarprovince");

		Integer row = updateMapper.updateTrainingCarprovince(map);
		Assert.assertTrue(row > 0);// ok
	}

	@Test
	public void testUpdateDrivingfieldprovince() {

		Map map = new HashMap<>();

		map.put("type", 6);
		map.put("reason", "Drivingfieldprovince");
		map.put("seq", 6);
		map.put("inscode", "2236581429084424");

		Integer row = updateMapper.updateDrivingfieldprovince(map);
		Assert.assertTrue(row > 0);// ok
	}

	@Test
	public void testUpdateTimeResult() {

		Map map = new HashMap<>();

		map.put("valid", 6);
		map.put("validtime", -9);
		map.put("pdfid", "FFFFFFF");
		map.put("needfultime", 6);
		map.put("stunum", "999");
		map.put("subject", 1);

		Integer row = updateMapper.updateTimeResult(map);
		Assert.assertTrue(row > 0);
		// ok
	}

	@Test
	public void testUpdateTimePass() {

		Map map = new HashMap<>();

		map.put("stunum", "999");
		map.put("subject", 4);

		Integer row = updateMapper.updateTimePass(map);
		Assert.assertTrue(row > 0);// ok
	}

	@Test
	public void testUpdateTimeFailBy3() {

		String reason = "testUpdateTimeFailBy3";

		Integer row = updateMapper.updateTimeFailBy3(reason, "1", "999");
		Assert.assertTrue(row > 0);// ok
	}

	@Test
	public void testUpdateTimeFail() {

		String reason = "testUpdateTimeFail";

		Integer row = updateMapper.updateTimeFail(reason, "233-3", "999");
		Assert.assertTrue(row > 0);// ok
	}

}
