package com.bjxc.supervise.mapper;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext.xml")
public class SelectMapperTest {

	private final Logger logger = LoggerFactory.getLogger(SelectMapperTest.class);

	@Resource
	private SelectMapper selectMapper;

	@Test
	public void testGetStuId() {

		Integer id = selectMapper.getStuId("999");

		logger.info(id.toString());

	}

	@Test
	public void testGetInsid() {

		Integer id = selectMapper.getInsid("2236581429084424");

		logger.info(id.toString());

	}

}
