package com.li.control;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;


public class Test_Main {
	static Connection conn = null;
	static PreparedStatement pst = null;
	static ResultSet rs = null;
	public static void main(String[] args) {
		ReadExcel re = new ReadExcel();
		//创建Excel路径
		 File file = new File("C:\\Users\\Administrator\\Desktop\\地区数据.xls");
		Map<String,String> map = re.readFile(file);	
		System.out.println("全部数量："+map.size());
		//省级
		Map<String,String> map_pro = re.diff(map);
		System.out.println("省级数量"+map_pro.size());
		
		Map<String,String> last = re.oth(map);
		System.out.println("剩余数量："+last.size());
		//一级市
		Map<String,String> map_pre = re.pre_Level(last);
		System.out.println("一级市数量："+map_pre.size());
		//地区
		Map<String,String> reg = re.region(last);
		System.out.println("剩余数量："+reg.size());
	}

}
