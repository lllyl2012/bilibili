package cn.yl.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.yl.entity.ResponseResult;
import cn.yl.entity.HistoryPro;
import cn.yl.entity.Product;
import cn.yl.entity.User;

public interface UserDao {
	//根据手机找用户
	User selectUserByMobile(@Param("mobile") String mobile);
	//注册
	Integer insertRegisterUser(User user);
	//返回自动播放的图片
	List<String> selectHot();
	//返回热门鬼畜
	List<Product> selectHotProduct(@Param("arrangid") String arrangid);
	//返回历史记录
	List<HistoryPro>  selectHistory(User user);
	//检查是否有该用户
	Integer countCheckName(@Param("username") String username);
	//检查是否有该号码
	Integer countCheckMobile(@Param("mobile") String mobile);
	//用户登录
	User selectLogin(User user);
	//分页获取所有用户
	List<User> selectAllUser(@Param("pages")int pages);
	//获得用户数量
	Integer countUserNum();
	//更新用户信息
	Integer updateUser(User user);
	//删除用户
	Integer deleteUser(@Param("mobile") String mobile);
	//每日番剧
	List<Product> selectAnimate();
	//获得所有最新鬼畜
	List<Product> selectGuichu(@Param("arrange") int arrange);
	
}
