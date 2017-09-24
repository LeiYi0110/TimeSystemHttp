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
public class InsertMapperTest {

	private static final Logger logger = LoggerFactory.getLogger(InsertMapperTest.class);

	@Resource
	private InsertMapper insertMapper;

	@Test
	public void testAddHttpLog() {

		Integer row = insertMapper.addHttpLog("wtf?!中文限定");

		logger.info(row.toString());
		
		//ok

	}

}
