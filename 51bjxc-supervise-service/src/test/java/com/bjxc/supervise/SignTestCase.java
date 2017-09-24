package com.bjxc.supervise;

import java.io.FileInputStream;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.util.Date;
import java.util.Enumeration;

import junit.framework.Assert;

import org.junit.Test;

import com.bjxc.supervise.http.crypto.Sign;


public class SignTestCase {
	
	@Test
	public void sign() throws Exception{
		PrivateKey privateKey = readPfx();
		Sign sign = new Sign();
		long timestamp = 1470201200322l;//new Date().getTime();
		String data = "{\"inscode\":\"2236581429084424\",\"district\":\"420528\",\"name\":\"test111\",\"shortname\":\"test2\",\"licnum\":\"112323445566\",\"licetime\":\"20160720\",\"business\":\"23421345563567777775\",\"address\":\"asgweeee\",\"postcode\":\"443500\",\"legal\":\"fff\",\"contact\":\"fff\",\"phone\":\"18215487978\",\"busiscope\":\"C1,C2,C3\",\"busistatus\":\"1\",\"level\":1,\"coachnumber\":0,\"grasupvnum\":0,\"safmngnum\":0,\"tracarnum\":0,\"praticefield\":0,\"thcoachnum\":0,\"pracoachnum\":0,\"lat\":0.0,\"lng\":0.0,\"position\":0,\"thumbnailid\":0}";
		String signStr = sign.sign(data,timestamp, privateKey);
		System.out.println("new:" + signStr);
		String exSign = "249B975D4B01B31FE8BA1105A9E162495BE1FBE71FB08EEB4C0BECDE01F0BCD22F9A2008B58FCE7AD4D63CA1DE77E1451AC65413765B75381583F594DD0B24B0B313F83E4A272F5BFD6B743C876708BA0CFCE394B999A2121120182756BEB2178CF1DB7D370FF978426E19AC27CFEEE9041F6A2F35EEC9DD24CCBC47215F76477D1A5E72F2A8259593DEAA61B1706FD59B2757EEC983C301DDA886CEC07DC9824089C62692254B8501C933A0B217288890A13AA2A5B38CC8E1057CDB2D005534E6EFA089AB2EBC37C6CB89AA6EA58B3A5D8F230E67FC14249228E45C325CDB736CBB9D4921F78F311EFD983B371BDF9D06B32D91945E762A30C0D488CA5B2F22";
		System.out.println("old:" + exSign);
		Assert.assertEquals(exSign, signStr);
		
	}
	
	
	public static PrivateKey readPfx() {
		try {
			KeyStore keyStore = KeyStore.getInstance("PKCS12");
			String path = "E:\\jee workspace\\51bjxc-supervise-service\\src\\main\\resources\\cer\\shenzhenks.pfx";//ÀýÈçd:/test.pfx
			String passwd = "1";
			try (InputStream input = new FileInputStream(path)) {
				keyStore.load(input, passwd.toCharArray());
			}
			Enumeration<String> aliases = keyStore.aliases();
			if (!aliases.hasMoreElements())
				throw new RuntimeException("no alias found");
			String alias = aliases.nextElement();
			X509Certificate cert = (X509Certificate) keyStore.getCertificate(alias);
			String SerialNumber = cert.getSerialNumber().toString();//ÐòÁÐºÅ
			PrivateKey privateKey = (PrivateKey) keyStore.getKey(alias, passwd.toCharArray());//Ë½Ô¿
			return privateKey;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


}
