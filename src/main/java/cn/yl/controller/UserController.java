package cn.yl.controller;

import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import cn.yl.entity.ResponseResult;
import cn.yl.entity.Product;
import cn.yl.entity.User;
import cn.yl.service.IndexService;
import cn.yl.service.ManagerService;
/**
 * 所有用户（包括游客都可以进行的操作）
 * @author soft01
 *
 */
@Controller
public class UserController {
	@Resource
	IndexService service;
	@Resource
	ManagerService managerService;
	
	/**
	 * 主页面
	 * @param map
	 * @return
	 */
	@RequestMapping("/index.do")
	public String index(ModelMap map,HttpSession session) {
		List<String> hots = service.selectHot();
		for(int i=0;i<5;i++) {
			map.put("hot"+i, hots.get(i));
		}
		Set<Product> indexset =  service.getHotProduct(1);
		map.put("hotrights", indexset);
		List<Product> animateNews= service.getAnimate();
		map.put("aniamteNews", animateNews);
		List<Product> animatePro = service.getRank1(1);
		map.put("animaterank", animatePro);
		List<Product> animatePro2 = service.getRank2(1);
		map.put("animaterank2", animatePro2);
		Set<Product> guichuRandoms = service.getGuichu();
		map.put("guichuNews", guichuRandoms);
		List<Product> guichuPro = service.getRank1(1);
		map.put("guichurank", guichuPro);
		List<Product> guichuPro2 = service.getRank2(1);
		map.put("guichurank2", guichuPro2);
		
		User user = (User)session.getAttribute("user");
		if(user!=null) {
			List<List<String>> list = managerService.getUserHistory(user);
			map.put("todayHistory", list.get(0));
			map.put("yesterdayHistory", list.get(1));
			map.put("weekHistory", list.get(2));
		}
		return "index";
	}
	/**
	 * 登录页面
	 * 
	 * @return
	 */
	@RequestMapping("/login.do")
	public String login() {
		return "login";
	}
	/**
	 * 登录
	 * 
	 * @param mobile
	 * @param password
	 * @param session
	 * @param map
	 * @return
	 */
	@RequestMapping("/loginvalidate.do")
	public String loginvalidate(String mobile,String password,HttpSession session,ModelMap map) {
		User user = new User();
		user.setMobile(mobile);
		user.setPassword(password);
		User user1 = managerService.Login(user);
		if(user1!=null) {
			session.setAttribute("user", user1);
			return "redirect:/index.do";
		}else {
			map.put("loginfail", "用户或密码错误");
			return "login";
		}
	}
	/**
	 * 获得历史记录
	 * @param req
	 * @param session
	 * @return
	 */
	@RequestMapping("/myhistory.do")
	@ResponseBody
	public String myHistory(HttpServletRequest req,HttpSession session) {
		User user = (User)session.getAttribute("user");
		List<List<String>> list = managerService.getUserHistory(user);
		for (List<String> list2 : list) {
			System.out.println("----------");
			for (String string : list2) {
				System.out.println(string);
			}
		}
		ObjectMapper om = new ObjectMapper();
		String str = null;
		try {
			str = om.writeValueAsString(list);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
	}
	/**
	 * 查看指定日期更新的动漫
	 */
	@RequestMapping("/thisDayAnimate.do")
	@ResponseBody
	public String thisDayAnimate(HttpServletRequest req, HttpServletResponse resp) {
		String day = req.getParameter("day");
		int week = Integer.parseInt(day.substring(day.length()-1))-2;
		System.out.println("week"+week);
		List<Product> list= service.getDayAnimate(week);
		ObjectMapper om = new ObjectMapper();
		String str = null;
		try {
			str = om.writeValueAsString(list);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
	}
	/**
	 * 更新一批鬼畜
	 */
	@RequestMapping("/changeGuichu.do")
	@ResponseBody
	public String changeGuichu() {
		Set<Product> set = service.ChangeGuichu();
		ObjectMapper om = new ObjectMapper();
		String str = null;
		try {
			str = om.writeValueAsString(set);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
	}
}
