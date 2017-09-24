package com.bjxc.supervise;

import java.util.Date;

public class TimeSystemFile {

	private Integer id;
	private String url;
	private String type;

	private Date createTime;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "TimeSystemFile [id=" + id + ", url=" + url + ", type=" + type + ", createTime=" + createTime + "]";
	}

}
