package org.dp.service.impl;

import java.util.List;

import org.dp.dao.JbrCategoryMapper;
import org.dp.dao.JbrJubaoMapper;
import org.dp.dao.JbrReportMapper;
import org.dp.entity.JbrCategory;
import org.dp.entity.JbrCategoryWithBLOBs;
import org.dp.entity.JbrJubao;
import org.dp.entity.JbrReport;
import org.dp.service.JbrReportService;
import org.dp.service.common.CheckCodePicture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
@Service("JbrReportService")
@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT,
		rollbackFor={Exception.class})
public class JbrReportServiceImpl implements JbrReportService {
	
	private final JbrReportMapper jbrReMapper;
	private final CheckCodePicture ccPic;
	private final JbrCategoryMapper categoryMapper;
	private final JbrJubaoMapper jubaoMapper;
	@Autowired
	public JbrReportServiceImpl(JbrReportMapper jbrReMapper,CheckCodePicture ccPic,JbrCategoryMapper categoryMapper,JbrJubaoMapper jubaoMapper){
		this.jbrReMapper = jbrReMapper;
		this.ccPic = ccPic;
		this.categoryMapper=categoryMapper;
		this.jubaoMapper = jubaoMapper;
	}
	@Transactional(timeout=30)
	public void insertSignature(JbrReport record) {
		// TODO Auto-generated method stub
		jbrReMapper.insertSelective(record);
	}
	@Transactional(timeout=30)
	public void insertAnonymous(JbrReport record) {
		// TODO Auto-generated method stub
		jbrReMapper.insertSelective(record);
	}
	public String getCheckCode() {
		// TODO Auto-generated method stub
		return ccPic.create();
	}
	public int getCatidByName(String catname){
		JbrCategory category = categoryMapper.selectByCatname(catname);
		short catid = category.getCatid();
		return catid;
	}
	public List<JbrJubao> getJubaoidByCatid(short catid){
		List<JbrJubao> jubao = jubaoMapper.selectByCatid(catid);
		return jubao;
	}
	public List<JbrCategoryWithBLOBs> getCategory(String catname) {
		// TODO Auto-generated method stub
		//通过catname找到catid
		JbrCategory category = categoryMapper.selectByCatname(catname);
		short catid = category.getCatid();
		//通过catid找到List<JbrCategoryWithBLOBs>   （catname）
		List<JbrCategoryWithBLOBs> categoryList = categoryMapper.selectByParentid(catid);
		return categoryList;
	}
	
	public List<JbrJubao> getJubao(String catname) {
		//通过catname找到catid
		JbrCategory category = categoryMapper.selectByCatname(catname);
		short catid = category.getCatid();
		//通过catid在JUBAO表中找到List<JbrJubao>
		List<JbrJubao> jubaoList = jubaoMapper.selectByCatid(catid);
		return jubaoList;
	}

}
