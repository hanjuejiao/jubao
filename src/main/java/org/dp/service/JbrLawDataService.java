package org.dp.service;

import org.dp.entity.JbrLawData;
import org.dp.entity.LawAndData;

/**
 * 功能模块:法律法规管理模块
 * 所在层次：业务逻辑层
 * 
 * 业务逻辑列表:
 * 	1.根据主键查询一个详细文件
 * @author ai-jusse
 *
 */
public interface JbrLawDataService {
	LawAndData getLawDataByPrimaryKey(Integer id);
}
