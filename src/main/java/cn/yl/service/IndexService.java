package cn.yl.service;

import java.util.List;
import java.util.Set;

import cn.yl.entity.Product;

public interface IndexService {
	//自动播放业务
	List<String> selectHot();
	//右端鬼畜热点
	Set<Product> getHotProduct(int num);
	//最新动漫
	List<Product> getAnimate();
	//动漫排行
	List<Product> getRank1(int arrangeid);
	List<Product> getRank2(int arrangeid);
	//鬼畜
	Set<Product> getGuichu();
	//指定日期的动漫
	List<Product> getDayAnimate(int day);
	//换一批鬼畜
	Set<Product> ChangeGuichu();
}
