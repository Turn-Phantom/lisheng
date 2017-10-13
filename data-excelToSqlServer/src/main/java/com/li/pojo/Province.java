package com.li.pojo;

public class Province {
	private String province_code;
	private String province_name;
	private String province_subcode;
	
	public Province() {
		super();
	}
	
	public String getProvince_subcode() {
		return province_subcode;
	}
	public void setProvince_subcode(String province_subcode) {
		this.province_subcode = province_subcode;
	}
	public String getProvince_code() {
		return province_code;
	}
	public void setProvince_code(String province_code) {
		this.province_code = province_code;
	}
	public String getProvince_name() {
		return province_name;
	}
	public void setProvince_name(String province_name) {
		this.province_name = province_name;
	}
}
