package org.dp.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;

public class BaseController {
	@ExceptionHandler(value={Exception.class})
	public String exception(Exception e){
//		System.out.println(e);
		e.printStackTrace();
		return "error";
	}
}
