package org.dp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.dp.entity.JbrCategory;
import org.dp.entity.JbrCategoryWithBLOBs;
import org.dp.service.page.PageParam;

public interface JbrCategoryMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table jbr_category
	 * @mbggenerated  Wed May 03 16:28:45 CST 2017
	 */
	int deleteByPrimaryKey(Short catid);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table jbr_category
	 * @mbggenerated  Wed May 03 16:28:45 CST 2017
	 */
	int insert(JbrCategoryWithBLOBs record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table jbr_category
	 * @mbggenerated  Wed May 03 16:28:45 CST 2017
	 */
	int insertSelective(JbrCategoryWithBLOBs record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table jbr_category
	 * @mbggenerated  Wed May 03 16:28:45 CST 2017
	 */
	JbrCategoryWithBLOBs selectByPrimaryKey(Short catid);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table jbr_category
	 * @mbggenerated  Wed May 03 16:28:45 CST 2017
	 */
	int updateByPrimaryKeySelective(JbrCategoryWithBLOBs record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table jbr_category
	 * @mbggenerated  Wed May 03 16:28:45 CST 2017
	 */
	int updateByPrimaryKeyWithBLOBs(JbrCategoryWithBLOBs record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table jbr_category
	 * @mbggenerated  Wed May 03 16:28:45 CST 2017
	 */
	int updateByPrimaryKey(JbrCategory record);
	
	//通过名称查找当前行，获取id
	JbrCategoryWithBLOBs selectByCatname(@Param("catname")String catname); 
	//通过父栏目id查找所有子栏目
	List<JbrCategoryWithBLOBs> selectByParentid(@Param("parentid")short parentid);
}