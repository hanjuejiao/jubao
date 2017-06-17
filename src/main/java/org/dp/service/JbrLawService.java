package org.dp.service;

import org.dp.entity.JbrLaw;
import org.dp.service.page.PageBean;
import org.dp.service.page.PageParam;

/**
 * 功能模块:法律法规管理模块
 * 所在层次：业务逻辑层
 * 
 * 业务逻辑列表:
 * 	1.分页查询文件;
 * @author ai-jusse
 *
 */
public interface JbrLawService {
	PageBean<JbrLaw> getListLaws(PageParam pageParam);
}
