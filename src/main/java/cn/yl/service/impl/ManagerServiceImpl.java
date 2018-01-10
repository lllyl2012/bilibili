package cn.yl.service.impl;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.annotation.Resource;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.Cookie;

import org.springframework.stereotype.Service;

import cn.yl.dao.UserDao;
import cn.yl.entity.HistoryPro;
import cn.yl.entity.Product;
import cn.yl.entity.User;
import cn.yl.service.ManagerService;

@Service("managerService")
public class ManagerServiceImpl implements ManagerService{
	
	@Resource
	UserDao dao;
	public User Login(User user) {
		User user1 = dao.selectUserByMobile(user.getMobile());
		
		if(user1==null) {
			return null;
		}else {
			if(user.getPassword().equals(user1.getPassword())) {
				return user1;
			}else {
				return null;
			}
		}
	}
	public int[] getAfterAndBefore(int pageNum,int pageAll) {
		int beforePage = 0;
		int afterPage = 0;
		if((pageNum-1)<=0) {
			beforePage = 1;
		}else {
			beforePage = pageNum - 1;
		}
		if((pageNum+1)>=pageAll) {
			afterPage = pageAll;
		}else {
			afterPage = pageNum + 1;
		}
		int[] arr = new int[2];
		arr[0] = beforePage;
		arr[1] = afterPage;
		return arr;
	}
	public List<User> getAllUsers(int pageNum) {
		List<User> list = dao.selectAllUser((pageNum-1)*7);
		return list;
	}
	
	
	
	public Integer getPages() {
		Integer num = dao.countUserNum();
		int pages = num/7;
		if(num%7!=0) {
			pages++;
		}
		return pages;
	}

	public Integer getCurrentPage(Cookie[] cookies,int pageAll, String currentPage) {
		String page = "1";
		page = currentPage;
		if(page==null) {
			if(cookies!=null) {
				for(Cookie c:cookies) {
					if("page".equals(c.getName())){
						try {
							page =URLDecoder.decode(c.getValue(),"utf-8");
						} catch (UnsupportedEncodingException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						c.setMaxAge(0);
					}
				}
			}
		}
		if(page ==null) {
				page = "1";
		}
		int pageNum = Integer.parseInt(page);
		if(pageNum>pageAll) {
			pageNum = pageAll;
		}
		page = ""+pageNum;
		return Integer.parseInt(page);
	}
	
	public List<List<String>> getUserHistory(User user) {
		List<HistoryPro> list = dao.selectHistory(user);
		Collections.sort(list,new Comparator<HistoryPro>() {
			public int compare(HistoryPro p1,HistoryPro p2) {
				return (int)(p1.getReadtime().getTime() - p2.getReadtime().getTime());
			}
		});
		int length = list.size();
		if(length>6) {
			list = list.subList(0, 6);
		}else if(length==0){
			list = list;
		}else{
			list = list.subList(0, length-1);
		}
		List<List<String>> all = new ArrayList<List<String>>();
		List<String> todayList = new ArrayList<String>();
		List<String> yesterdayList = new ArrayList<String>();
		List<String> weekList = new ArrayList<String>();

		
		Calendar todayCalendar = Calendar.getInstance();
		Calendar thatCalendar = Calendar.getInstance();
		int today = todayCalendar.get(Calendar.DAY_OF_YEAR);
		for (HistoryPro historyPro : list) {
			Date date = historyPro.getReadtime();
			thatCalendar.setTime(date);
			int thatDay = thatCalendar.get(Calendar.DAY_OF_YEAR);
			if(today - thatDay ==0) {
				todayList.add(historyPro.getProductname());
			}else if(today - thatDay==1){
				yesterdayList.add(historyPro.getProductname());
			}else {
				weekList.add(historyPro.getProductname());
			}
		}
		all.add(todayList);
		all.add(yesterdayList);
		all.add(weekList);
		return all;
	}
	
	public User selectUserByMobile(String mobile) {
		User user1 = dao.selectUserByMobile(mobile);
		return user1;
	}
	
	public boolean sendAdviceMail(String advice) {
		Context initCtx;
		System.out.println(1);
		Transport transport = null;
		try {
			initCtx = new InitialContext();
			System.out.println("initCtx:"+initCtx);
			  Context envCtx = (Context) initCtx.lookup("java:comp/env");
			  System.out.println("envCtx:"+envCtx);
			  Session session = (Session)envCtx.lookup("mail/Session");
			  System.out.println("session:"+session);
			  Message msg= new MimeMessage(session);
			  msg.setSubject("gaga");
			  msg.setText(advice);
				msg.setFrom(new InternetAddress("lllyl2012@sina.com","武帝","utf-8"));
				msg.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress("229707363@qq.com"));
				transport = session.getTransport();
				transport.connect("lllyl2012","yl82662422");
				transport.sendMessage(msg, new Address[]{new InternetAddress("229707363@qq.com")});
				return true;
				//
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally {
			try {
				transport.close();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public boolean removeUser(User user) {
		int num = dao.deleteUser(user.getMobile());
		if(num==1) {
			return true;
		}else {
			return false;
		}
	}
	public User changeInfo(User user) {
		int num = dao.updateUser(user);
		if(num==1) {
			User user1 = dao.selectUserByMobile(user.getMobile());
			return user1;
		}else {
			return user;
		}
	}
}
