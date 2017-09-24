package com.bjxc.supervise.mapper;

import static org.junit.Assert.*;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bjxc.supervise.TimeSystemFile;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext.xml")
public class FileMapperTest {

	@Autowired
	private FileMapper fileMapper;

	@Test
	public void testAddFile() {
		TimeSystemFile timeSystemFile = new TimeSystemFile();
		timeSystemFile.setCreateTime(new Date());
		timeSystemFile.setType("阳光驾培");
		timeSystemFile.setUrl("http://ks.91ygxc.com/");

		fileMapper.addFile(timeSystemFile);
		//ok
	}

}
