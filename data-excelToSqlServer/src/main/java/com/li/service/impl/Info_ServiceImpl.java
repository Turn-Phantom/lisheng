package com.li.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.li.pojo.Province;
import com.li.service.Info_Service;

public class Info_ServiceImpl implements Info_Service {

	public int addInfo(Province pro) {
		String sql ="insert into province(province_code,province_name,province_subcode) values(?,?,?)";
		List<Province> list = new ArrayList<>();
		return 0;
	}

}
