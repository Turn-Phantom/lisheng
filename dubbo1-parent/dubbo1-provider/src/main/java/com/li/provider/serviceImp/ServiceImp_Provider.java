package com.li.provider.serviceImp;

import org.springframework.stereotype.Service;
import com.li.api.PraService;

@Service("controlService")
public class ServiceImp_Provider implements PraService {

	public String sayHello(String name) {
		System.out.println("你好1"+name);
		return "success";
	}

}
