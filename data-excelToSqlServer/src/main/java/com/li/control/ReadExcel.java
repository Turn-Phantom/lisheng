package com.li.control;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ReadExcel {
	/**
	 * 读取文件，并添加进map集合
	 * @param file
	 */
	public Map<String,String> readFile(File file) {
		Map<String,String> map = new HashMap<String,String>();
		try {  
			// 创建输入流，读取Excel  
			InputStream is = new FileInputStream(file.getAbsolutePath());  
			// jxl提供的Workbook类  
			Workbook wb = Workbook.getWorkbook(is);  
			// Excel的页签数量  
			int sheet_size = wb.getNumberOfSheets();  
			for (int index = 0; index < sheet_size; index++) {  
				// 每个页签创建一个Sheet对象  
				Sheet sheet = wb.getSheet(index);  
				// sheet.getRows()返回该页的总行数  
				for (int i = 0; i < sheet.getRows(); i++) {  
					// sheet.getColumns()返回该页的总列数  
					/*for (int j = 0; j < sheet.getColumns(); j++) {  
						String cellinfo = sheet.getCell(j, i).getContents();  
						System.out.println(cellinfo);  
					}*/
					map.put(sheet.getCell(0,i).getContents(), sheet.getCell(1,i).getContents());
				}  
			} 
		} catch (FileNotFoundException e) {  
			e.printStackTrace();  
		} catch (BiffException e) {  
			e.printStackTrace();  
		} catch (IOException e) {  
			e.printStackTrace();  
		}
		return map;  
	}  
	/**
	 * 返回省级集合
	 */
	public Map<String,String> diff(Map<String,String> map) {
		Map<String,String> map_pro = new HashMap<String,String>();
		//遍历map集合
		for (Map.Entry<String, String> entry : map.entrySet()) {
			String id_code = entry.getKey().substring(entry.getKey().length()-5, entry.getKey().length()).trim();
			if(id_code.equals("0000")) {
				map_pro.put(entry.getKey(), entry.getValue());
			}
		}
		return map_pro;
	}
	/**
	 * 返回除了省级剩余的地区
	 * @return
	 */
	public Map<String,String> oth(Map<String,String> map){
		Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();  
        while(it.hasNext()){  
            Map.Entry<String, String> entry=it.next();
			String id_code = entry.getKey().substring(entry.getKey().length()-5, entry.getKey().length()).trim();
            if(id_code.equals("0000")){  
                it.remove();      
            }  
        }  
		return map;
	}
	/**
	 * 返回一级市城市
	 * @return
	 */
	public Map<String,String> pre_Level(Map<String,String> map){
		Map<String,String> map_pre = new HashMap<String,String>();
		//遍历map集合
		for (Map.Entry<String, String> entry : map.entrySet()) {
			String id_code = entry.getKey().substring(entry.getKey().length()-3, entry.getKey().length()).trim();
			if(id_code.equals("00")) {
				map_pre.put(entry.getKey(), entry.getValue());
			}
		}
		return map_pre;
	}
	
	public Map<String,String> region (Map<String,String> map){
		Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();  
        while(it.hasNext()){  
            Map.Entry<String, String> entry=it.next();
			String id_code = entry.getKey().substring(entry.getKey().length()-3, entry.getKey().length()).trim();
            if(id_code.equals("00")){  
                it.remove();      
            }  
        }  
		return map;
	}
}
