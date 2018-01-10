package cn.yl.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.yl.dao.UserDao;
import cn.yl.entity.Product;
import cn.yl.service.IndexService;
@Service("indexService")
public class IndexServiceImpl implements IndexService{
	
	@Resource
	private UserDao dao;
	Random ran = new Random();
	public List<String> selectHot(){
		return dao.selectHot();
	}
	public Set<Product> getHotProduct(int num) {
		List<Product> products = dao.selectHotProduct("1");
		int index = products.size();
		
		Set<Product> indexset = new HashSet<Product>();
		
		while(indexset.size()<8) {
			int u = ran.nextInt(index);
			
			indexset.add(products.get(u));
		}
		return indexset;
	}
	public List<Product> getAnimate() {
		List<Product> animateProducts = dao.selectAnimate();
		Collections.sort(animateProducts, new Comparator<Product>() {
			public int compare(Product p1,Product p2) {
				return (int)(p1.getCreatetime().getTime() - p2.getCreatetime().getTime());
			}
		});
//		Product[] animateNews = new Product[16]; 
		
//		System.arraycopy(animateProducts, 0, animateNews, 0, animateNews.length);
		List<Product> animateNews = new ArrayList<Product>();
		for(int i =0;i<16;i++) {
			animateNews.add(animateProducts.get(i));
		}
		return animateNews;
	}
	public List<Product> getRank1(int arrangeid) {
		List<Product> animateProducts = null;
		if(arrangeid==2) {
		 animateProducts = dao.selectAnimate();
		}else {
			animateProducts = dao.selectGuichu(arrangeid);
		}
		Collections.sort(animateProducts, new Comparator<Product>() {
			public int compare(Product p1,Product p2) {
				return p1.getShot() - p2.getShot();
			}
		});
//		Product[] animatePro = new Product[3];
//		System.arraycopy(animateProducts, 0, animatePro, 0, 3);
		List<Product> animatePro = new ArrayList<Product>();
		for(int i=0;i<3;i++) {
			animatePro.add(animateProducts.get(i));
		}
		return animatePro;
	}
	public List<Product> getRank2(int arrangeid) {
		List<Product> animateProducts = null;
		if(arrangeid==2) {
		 animateProducts = dao.selectAnimate();
		}else {
			animateProducts = dao.selectGuichu(arrangeid);
		}
		Collections.sort(animateProducts, new Comparator<Product>() {
			public int compare(Product p1,Product p2) {
				return p1.getShot() - p2.getShot();
			}
		});
//		Product[] animatePro = new Product[3];
//		System.arraycopy(animateProducts, 0, animatePro, 0, 3);
		List<Product> animatePro2 = new ArrayList<Product>();
		for(int i=3;i<10;i++) {
			animatePro2.add(animateProducts.get(i));
		}
		return animatePro2;	
	}
	public Set<Product> getGuichu() {
		List<Product> guichuProducts = dao.selectGuichu(1);
		Set<Product> guichuRandoms = new HashSet<Product>();
		int guichulength = guichuProducts.size();
		while(guichuRandoms.size()<10) {
			int guichunum = ran.nextInt(guichulength);
			guichuRandoms.add(guichuProducts.get(guichunum));
		}
		return guichuRandoms;
	}
	
	public List<Product> getDayAnimate(int week) {
		List<Product> list2= dao.selectAnimate();
		List<Product> list = new ArrayList<Product>();
		if(week!=-1) {	
			for(Product p:list2 ){
				if(p.getWeek()==week) {
					list.add(p);
				}
			}
		}else {
			Collections.sort(list2, new Comparator<Product>() {
				public int compare(Product p1,Product p2) {
					return (int)(p1.getCreatetime().getTime() - p2.getCreatetime().getTime());
				}
			});
			for(int i=0;i<16;i++) {
				list.add(list2.get(i));
			}
		}
		return list;
	}
	public Set<Product> ChangeGuichu() {
		List<Product> list = dao.selectGuichu(1);
		Set<Product> guichuRandoms = new HashSet<Product>();
		int guichulength = list.size();
		while(guichuRandoms.size()<10) {
			int guichunum = ran.nextInt(guichulength);
			guichuRandoms.add(list.get(guichunum));
		}
		return guichuRandoms;
	}
	
}
