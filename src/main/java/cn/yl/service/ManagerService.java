package cn.yl.service;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;

import cn.yl.entity.ResponseResult;
import cn.yl.entity.Product;
import cn.yl.entity.User;

public interface ManagerService {
	//判断是否正确登录
	User Login(User user);
	//获得用户列表
	List<User> getAllUsers(int pageNum);
	//获得页数
	Integer getPages();
	//定位当前页
	Integer getCurrentPage(Cookie[] cookies,int pageAll, String currentPage);
	//获得前一后一页
	int[] getAfterAndBefore(int pageNum,int pageAll);
	//获得该用户的历史记录
//	List<HistoryPro> getUserHistory(User user);
	List<List<String>> getUserHistory(User user);
	//获得个人用户信息
	User selectUserByMobile(String mobile);
	//发送意见邮件
	boolean sendAdviceMail(String advice);
	//删除用户
	boolean removeUser(User user);
	//修改个人用户信息
	User changeInfo(User user);
}
