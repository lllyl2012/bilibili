package cn.yl.service;

import javax.servlet.http.HttpServletRequest;

import cn.yl.entity.User;

public interface RegisterService {
	/**
	 *检查用户名
	 * @param name
	 * @return
	 */
	String checkName(String name);
	/**
	 * 检查电话是否存在
	 * @param mobile
	 * @return
	 */
	String checkMobile(String mobile); 
	/**
	 * 返回保存用户是否成功
	 * @param user
	 * @return
	 */
	boolean saveUser(User user,HttpServletRequest req);
}
