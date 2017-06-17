package org.dp.controller;

import org.dp.service.JbrLawService;
import org.dp.service.page.PageParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="/LawManage")
public class JbrLawController extends BaseController {
	@Autowired
	JbrLawService service;
	
	@RequestMapping(value="/getListLaw")
	@ResponseBody
	public Object getListLaw(PageParam pageParam){
//		System.out.println(pageParam.getBeginPageIndex());
//		System.out.println(pageParam.getRows());
//		System.out.println(service.getListLaws(pageParam));
		return service.getListLaws(pageParam);
	}
}
