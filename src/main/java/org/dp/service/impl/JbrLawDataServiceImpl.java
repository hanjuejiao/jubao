package org.dp.service.impl;

import org.dp.dao.JbrLawDataMapper;
import org.dp.dao.JbrLawMapper;
import org.dp.entity.JbrLawData;
import org.dp.entity.LawAndData;
import org.dp.service.JbrLawDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
@Service("JbrLawDataService")
@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT,rollbackFor={Exception.class})
public class JbrLawDataServiceImpl implements JbrLawDataService {
	private final JbrLawDataMapper mapper;
	private final JbrLawMapper lawMapper;
	@Autowired
	public JbrLawDataServiceImpl(JbrLawDataMapper mapper,JbrLawMapper lawMapper){
		this.mapper = mapper;
		this.lawMapper = lawMapper;
	}
	public LawAndData getLawDataByPrimaryKey(Integer id) {
		//返回JbrLaw + LawData中的content
		LawAndData lawanddata = new LawAndData();
		lawanddata.setLaw(lawMapper.selectByPrimaryKey(id));
		lawanddata.setLawdata(mapper.selectByPrimaryKey(id));
		return lawanddata;
	}

}
