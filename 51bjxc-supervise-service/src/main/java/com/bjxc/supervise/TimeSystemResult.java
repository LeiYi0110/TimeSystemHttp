package com.bjxc.supervise;

import java.io.Serializable;
import java.util.HashMap;

import com.bjxc.exception.BusinessException;

public class TimeSystemResult extends HashMap<String, Object> implements Serializable{
	private static final long serialVersionUID = -5730703174755243880L;
	
	public TimeSystemResult(){
		this.setCode(200);
		this.setMessage("ok");
	}

	
	
	public Integer getCode() {
		return (Integer)this.get("errorcode");
	}
	public void setCode(Integer code) {
		this.put("errorcode",code);
	}
	public Object getData() {
		return this.get("data");
	}
	public void setData(Object data) {
		this.put("data",data);
	}
	public String getMessage() {
		return (String)this.get("message");
	}
	public void setMessage(String msg) {
		this.put("message",msg);
	}
	
	public void success(){
		this.setCode(0);
	}
	
	public void success(Object data){
		this.setCode(0);
		this.setData(data);
	}
	
	public void error(String msg){
		this.setCode(700);
		this.setMessage(msg);
	}
	
	public void error(Throwable exception){
		if(exception instanceof BusinessException){
			BusinessException bex = (BusinessException)exception;

			this.setCode(bex.getCode());
			this.setMessage(bex.getMessage());
		}else{
			this.setCode(700);
			this.setMessage(exception.getMessage());
		}
	}
	
	public void error(Integer code,String msg){
		this.setCode(code);
		this.setMessage(msg);
	}
}
