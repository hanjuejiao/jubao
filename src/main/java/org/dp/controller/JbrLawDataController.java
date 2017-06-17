package org.dp.controller;

import org.dp.service.JbrLawDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="/LawManage")
public class JbrLawDataController extends BaseController {
	private final JbrLawDataService service;
	@Autowired
	public JbrLawDataController(JbrLawDataService service){
		this.service = service;
	}
	
	@RequestMapping(value="/GetSingleLawData")
	@ResponseBody
	public Object getSingleLawData(@RequestParam(value="id",required=true)Integer id){
		//返回JbrLaw + LawData中的content
		return service.getLawDataByPrimaryKey(id);
	}
}
