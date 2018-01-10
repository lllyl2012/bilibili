package cn.yl.test;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.yl.entity.ResponseResult;
import cn.yl.entity.Product;
import cn.yl.entity.User;
import cn.yl.service.IndexService;
import cn.yl.service.ManagerService;

public class TestService {
	AbstractApplicationContext ac;
	IndexService service;
	ManagerService managerService;
	@Before
	public void init() {
		ac = new ClassPathXmlApplicationContext("conf/spring-service.xml","conf/spring-db.xml","conf/spring-mybatis.xml");
		service = ac.getBean("indexService",IndexService.class);
		managerService = ac.getBean("managerService",ManagerService.class);
	}
	@After
	public void destory() {
		ac.close();
	}
	@Test
	public void testService() {
		User user = new User();
		user.setId(6);
//		List<HistoryPro> list=managerService.getUserHistory(user);
		List<List<String>> list = managerService.getUserHistory(user);
		for (List<String> list2 : list) {
			for (String string : list2) {
				System.out.println(string);
			}
			
		}
	}
}
