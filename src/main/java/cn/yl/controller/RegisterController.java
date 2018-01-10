package cn.yl.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.yl.dao.UserDao;
import cn.yl.entity.User;
import cn.yl.service.RegisterService;

/**
 * 此类用于注册
 * @author soft01
 *
 */
@Controller
public class RegisterController {
	@Resource
	RegisterService registerService;
	/**
	 * 注册页面
	 * @return
	 */
	@RequestMapping("/register.do")
	public String register() {
		System.out.println("RegisterController.register():");
		return "register";
	}
	/**
	 * 检查用户名
	 * @param name
	 * @param req
	 * @param resp
	 * @return
	 */
	@RequestMapping("/checkname.do")
	@ResponseBody
	public String checkName(String name,HttpServletRequest req, HttpServletResponse resp) {
		String text = registerService.checkName(name);
		return text;
	}
	/**
	 * 检查手机号码
	 * @param req
	 * @return
	 */
	@RequestMapping("/checkmobile.do")
	@ResponseBody
	public String checkMobile(HttpServletRequest req) {
		String mobile = req.getParameter("mobile");
		String str = registerService.checkMobile(mobile);
		return str;
	}
	/**
	 * 保存用户信息并注册
	 * @param req
	 * @param resp
	 * @return
	 */
	@RequestMapping("/save.do")
	public String saveUser(HttpServletRequest req, HttpServletResponse resp) {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String mobile = req.getParameter("mobile");
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setMobile(mobile);
		boolean flag = registerService.saveUser(user, req);
		if(flag) {
			return "redirect:index.do";
		}else {
			return "register";
		}
	}
}
