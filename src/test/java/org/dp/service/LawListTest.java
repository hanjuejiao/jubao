package org.dp.service;

import org.dp.dao.JbrLawMapper;
import org.dp.entity.JbrLaw;
import org.dp.service.page.PageParam;
import org.dp.util.ExcelWork;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.slf4j.Logger;

import java.util.List;

/**
 * Created by Administrator on 2017/6/7.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:conf/spring-mybatis.xml"})
public class LawListTest {
    private Logger logger = org.slf4j.LoggerFactory.getLogger(this.getClass());

    @Autowired
    JbrLawMapper lawMapper;

    PageParam pageParam = new PageParam();

    @Test
    public void lawtest() throws Exception{
//        pageParam.setPage(1);
//        pageParam.setRows(8);
//        List<JbrLaw> laws = lawMapper.selectPageAll(pageParam);
//        for(JbrLaw law: laws)
//            System.out.println(law.toString());
        ExcelWork.createExcel("D:/a/a.xls");
    }

}
