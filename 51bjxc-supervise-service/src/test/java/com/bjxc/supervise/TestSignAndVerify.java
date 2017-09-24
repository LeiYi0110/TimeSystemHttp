package com.bjxc.supervise;

import java.io.FileInputStream;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.util.Date;
import java.util.Enumeration;

import org.junit.Test;

import com.bjxc.supervise.http.crypto.Sign;
import com.bjxc.supervise.http.crypto.Verify;

public class TestSignAndVerify {
	
	@Test
	public  void signAndVerify() throws Exception {
		String password = "1";
		KeyStore keyStore = KeyStore.getInstance("PKCS12");
		try (InputStream input = new FileInputStream("E:\\jee workspace\\51bjxc-supervise-service\\src\\main\\resources\\cer\\shenzhenks.pfx")) {
			keyStore.load(input, password.toCharArray());
		}
		Enumeration<String> aliases = keyStore.aliases();
		if (!aliases.hasMoreElements()) {
			throw new RuntimeException("no alias found");
		}
		String alias = aliases.nextElement();
		PrivateKey privateKey = (PrivateKey) keyStore.getKey(alias, password.toCharArray());
		X509Certificate cert = (X509Certificate) keyStore.getCertificate(alias);
		String data = "{\"inscode\":\"2236581429084424\",\"district\":\"420528\",\"name\":\"test111\",\"shortname\":\"test2\",\"licnum\":\"112323445566\",\"licetime\":\"20160720\",\"business\":\"23421345563567777775\",\"address\":\"asgweeee\",\"postcode\":\"443500\",\"legal\":\"fff\",\"contact\":\"fff\",\"phone\":\"18215487978\",\"busiscope\":\"C1,C2,C3\",\"busistatus\":\"1\",\"level\":1,\"coachnumber\":0,\"grasupvnum\":0,\"safmngnum\":0,\"tracarnum\":0,\"praticefield\":0,\"thcoachnum\":0,\"pracoachnum\":0,\"lat\":0.0,\"lng\":0.0,\"position\":0,\"thumbnailid\":0}";
		long timestamp = new Date().getTime();
		
		Sign sign = new Sign();
		String sign_hex = sign.sign(data, timestamp, privateKey);
		System.out.println(sign_hex);
		Verify verify = new Verify();
		boolean ok = verify.verify(data, timestamp, sign_hex, cert);
		System.out.println(ok);
	}
}
