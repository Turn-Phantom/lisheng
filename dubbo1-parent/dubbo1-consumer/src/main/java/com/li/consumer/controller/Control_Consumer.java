package com.li.consumer.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.li.api.PraService;

@Controller
@RequestMapping("/test")
public class Control_Consumer {
	@Resource
	private PraService praservice;
	
	@RequestMapping("/say")
	@ResponseBody
	public String sayHello(String name){
		String str = praservice.sayHello(name);
		return str;	
	}
}
