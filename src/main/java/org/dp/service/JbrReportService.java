package org.dp.service;

import java.util.List;

import org.dp.entity.JbrCategoryWithBLOBs;
import org.dp.entity.JbrJubao;
import org.dp.entity.JbrReport;
import org.springframework.stereotype.Service;

/**
 * 功能模块:举报信息管理
 * 所在层次：业务逻辑层
 * 
 * 业务逻辑列表:
 * 	1.署名举报信息录入;
 * 	2.匿名举报信息录入;
 *  3.获取验证码；
 *  4.获取问题类别
 *  5.政治面貌，级别，问题细类
 *  
 * @author ai-jusse
 *
 */
@Service
public interface JbrReportService {
	void insertSignature(JbrReport record);
	void insertAnonymous(JbrReport record);
	String getCheckCode();
	
	List<JbrCategoryWithBLOBs> getCategory(String catname);
	List<JbrJubao> getJubao(String catname);
	public int getCatidByName(String catname);
	public List<JbrJubao> getJubaoidByCatid(short catid);
}
