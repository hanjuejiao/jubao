package org.dp.dao;

import org.dp.entity.JbrReport;

public interface JbrReportMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table jbr_report
	 * @mbggenerated  Wed May 03 16:28:45 CST 2017
	 */
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table jbr_report
	 * @mbggenerated  Wed May 03 16:28:45 CST 2017
	 */
	int insert(JbrReport record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table jbr_report
	 * @mbggenerated  Wed May 03 16:28:45 CST 2017
	 */
	int insertSelective(JbrReport record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table jbr_report
	 * @mbggenerated  Wed May 03 16:28:45 CST 2017
	 */
	JbrReport selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table jbr_report
	 * @mbggenerated  Wed May 03 16:28:45 CST 2017
	 */
	int updateByPrimaryKeySelective(JbrReport record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table jbr_report
	 * @mbggenerated  Wed May 03 16:28:45 CST 2017
	 */
	int updateByPrimaryKeyWithBLOBs(JbrReport record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table jbr_report
	 * @mbggenerated  Wed May 03 16:28:45 CST 2017
	 */
	int updateByPrimaryKey(JbrReport record);
}