package org.dp.service.impl;

import org.dp.dao.JbrLawMapper;
import org.dp.entity.JbrLaw;
import org.dp.service.JbrLawService;
import org.dp.service.page.PageBean;
import org.dp.service.page.PageParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
@Service("JbrLawService")
@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT,rollbackFor={Exception.class})
public class JbrLawServiceImpl implements JbrLawService {
	
	private final JbrLawMapper mapper;
	@Autowired
	public JbrLawServiceImpl(JbrLawMapper mapper){
		this.mapper = mapper;
	}
	public PageBean<JbrLaw> getListLaws(PageParam pageParam) {
		// TODO Auto-generated method stub
		PageBean<JbrLaw> pageBean = new PageBean<JbrLaw>();
		pageBean.setData(mapper.selectPageAll(pageParam));
		pageBean.setTotal(mapper.getTotalNum());
		return pageBean;
	}

}
