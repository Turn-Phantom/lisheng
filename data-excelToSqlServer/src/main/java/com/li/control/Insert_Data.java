package com.li.control;

import java.io.File;
import java.util.Map;

public class Insert_Data {
	ReadExcel re = new ReadExcel();
	File file = new File("C:\\Users\\Administrator\\Desktop\\地区数据.xls");
	Map<String,String> map = re.readFile(file);	
	//省级
	Map<String,String> map_pro = re.diff(map);
}
