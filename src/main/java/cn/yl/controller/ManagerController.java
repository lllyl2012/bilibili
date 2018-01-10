package cn.yl.controller;


import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.omg.IOP.ServiceContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import cn.yl.dao.UserDao;
import cn.yl.entity.ManagerPage;
import cn.yl.entity.ResponseResult;
import cn.yl.entity.User;
import cn.yl.service.IndexService;
import cn.yl.service.ManagerService;
/**
 * 此类用于用户登录以后的操作
 * @author soft01
 *
 */
@Controller
@RequestMapping("/user")
public class ManagerController {
	@Resource
	IndexService userService;
	@Resource
	ManagerService managerService;
	@Resource
	UserDao dao;
	/**
	 * 退出登录
	 * @param session
	 * @return
	 */
	@RequestMapping("/logout.do")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/index.do";
	}
	/**
	 * 到管理会员界面
	 * @param req
	 * @param page
	 * @param map
	 * @param resp
	 * @return
	 */
	@RequestMapping("/manager.do")
	public String manager(HttpServletRequest req,String page,ModelMap map,HttpServletResponse resp) {
		Cookie[] cookies = req.getCookies();
		Integer pageAll = managerService.getPages();
		Integer pageNum = managerService.getCurrentPage(cookies,pageAll, page);
		int[] arr = managerService.getAfterAndBefore(pageNum,pageAll);
		List<User> list = managerService.getAllUsers(pageNum);
		Cookie cookie = null;
		try {
			cookie = new Cookie("page",URLEncoder.encode(""+pageNum,"utf-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		resp.addCookie(cookie);
		map.put("users", list);
		map.put("pageAll", pageAll);
		map.put("page", pageNum);
		map.put("beforePage", arr[0]);
		map.put("afterPage", arr[1]);
		return "manager";
	}
	/**
	 * 会员管理界面分页
	 */
	@RequestMapping("/thisPage.do")
	@ResponseBody
	public String thisPage(HttpServletRequest req,String page,HttpServletResponse resp) {
		Cookie[] cookies = req.getCookies();
		Integer pageAll = managerService.getPages();
		Integer pageNum = managerService.getCurrentPage(cookies,pageAll, page);
		int[] arr = managerService.getAfterAndBefore(pageNum,pageAll);
		List<User> list = managerService.getAllUsers(pageNum);
		Cookie cookie = null;
		try {
			cookie = new Cookie("page",URLEncoder.encode(""+pageNum,"utf-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		resp.addCookie(cookie);
		ManagerPage managerPage = new ManagerPage();
		managerPage.setList(list);
		managerPage.setPage(page);
		managerPage.setPageAll(pageAll);
		managerPage.setBeforePage(arr[0]);
		managerPage.setAfterPage(arr[1]);
		ResponseResult rr = new ResponseResult();
		rr.setState(1);
		rr.setMessage("ok");
		rr.setObj(managerPage);
		ObjectMapper om = new ObjectMapper();
		String str = null;
		try {
			str = om.writeValueAsString(rr);
			return str;
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
	}
	/**
	 * 删除角色
	 */
	@RequestMapping("/removeUser.do")
	public String removeUser(HttpServletRequest req, HttpServletResponse resp) {
		String mobile = req.getParameter("mobile");
		User user = new User();
		user.setMobile(mobile);
		boolean flag = managerService.removeUser(user);
		if(flag) {
			Cookie[] cookies = req.getCookies();
			String nowPage = "1";
			for(Cookie c:cookies) {
				if("page".equals(c.getName())) {
					nowPage = c.getValue();
				}
			}
		}
		return "redirect:manager.do";
	}
	/**
	 * 个人信息管理界面
	 * @param req
	 * @param resp
	 * @param map
	 * @return
	 */
	@RequestMapping("/youown.do")
	public String youown(HttpServletRequest req, HttpServletResponse resp,ModelMap map) {
		User user = (User)req.getSession().getAttribute("user");
		String mobile = user.getMobile();
		User user1 = managerService.selectUserByMobile(mobile);
		String sign = user1.getSign();
		String sex = user1.getSex();
		String username = user1.getUsername();
		map.put("sign", sign);
		map.put("sex", sex);
		map.put("username", username);
		map.put("mobile", user1.getMobile());
		return "yourown";
	}
	/**
	 * 修改个人信息
	 */
	@RequestMapping(value="/changeMessage.do", method = RequestMethod.POST)
	public String changeInfo(MultipartFile file,HttpServletRequest req, HttpServletResponse resp,HttpSession session) {
		String username = req.getParameter("username");
		String sign = req.getParameter("sign");
		String sex = req.getParameter("sex");
		User user = (User)session.getAttribute("user");
		String head = "head"+user.getMobile()+".jpg";
	
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		try {
			fos = new FileOutputStream("./haha.jpg");
			bos = new BufferedOutputStream(fos);
			if(!file.isEmpty()) {
				byte[]  bytes = file.getBytes();
				bos.write(bytes);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				fos.close();
				bos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		user.setUsername(username);
		user.setSign(sign);
		user.setSex(sex);
		if(head!=null) {
			user.setHead(head);	
		}
		User user1 = managerService.changeInfo(user);
		return "redirect:youown.do";
	}
	/**
	 * 跳转至发送建议页面
	 */
	@RequestMapping("/advice.do")
	public String advice() {
		return "advice";
	}
	/**
	 * 发送建议
	 */
	@RequestMapping("/mail.do")
	public String mail(String advice) {
		boolean flag = managerService.sendAdviceMail(advice);
		if(flag) {
			return "redirect:youown.do";
		}else {
			return "-1";
		}
	}

}
