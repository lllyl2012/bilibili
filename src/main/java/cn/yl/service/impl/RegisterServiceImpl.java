package cn.yl.service.impl;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import cn.yl.dao.UserDao;
import cn.yl.entity.User;
import cn.yl.service.RegisterService;
@Service("registerService")
public class RegisterServiceImpl implements RegisterService{
	@Resource
	UserDao dao;
	
	public String checkName(String name) {
		String flagstr = "";
		if(name.length()==0) {
			flagstr = "名字不能为空";
			return flagstr;
		}else if(name.length()>20) {
			flagstr = "不能超过20个字符";
			return flagstr;
		}
		int num = dao.countCheckName(name);
		if(num==0) {
			return "";
		}else {
			return "该昵称已存在";
		}
	}

	public String checkMobile(String mobile) {
		int flag = dao.countCheckMobile(mobile);
		if(flag==1) {
			return "该号码已经存在";
		}else {
			return "";
		}
	}
	

	public boolean saveUser(User user,HttpServletRequest req) {
		Integer flag = dao.insertRegisterUser(user);
		if(flag==1) {
			HttpSession session = req.getSession();
			session.setAttribute("user", user);
			return true;
		}else {
			req.setAttribute("registerError", "注册失败");
			return false;
		}
	}

}
