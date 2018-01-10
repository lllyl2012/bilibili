package cn.yl.test;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.dbcp.BasicDataSource;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import cn.yl.dao.UserDao;
import cn.yl.entity.ResponseResult;
import cn.yl.entity.HistoryPro;
import cn.yl.entity.Product;
import cn.yl.entity.User;

public class Testaa {
	AbstractApplicationContext ac ;
	UserDao dao;
	@Before
	public void init() {
		ac = new ClassPathXmlApplicationContext("conf/spring-db.xml","conf/spring-mybatis.xml");
		dao = ac.getBean("userDao",UserDao.class);
	}
	@Test
	public void testMybatis() {
		User user = new User();
		user.setId(6);
		List<HistoryPro> list=dao.selectHistory(user);
		for (HistoryPro historyPro : list) {
			System.out.println(historyPro);
		}
	}
}
