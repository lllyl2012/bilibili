package cn.yl.service.impl;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import cn.yl.service.ValiCodeService;
@Service("valiCodeService")
public class ValiCodeServiceImpl implements ValiCodeService{
	private static final int IMG_HEIGHT = 100;
	private static final int IMG_WIDTH=30;
	private static final int CODE_LEN = 4;
	public BufferedImage getCode(HttpServletRequest req) {
		BufferedImage bi = new BufferedImage(IMG_HEIGHT,IMG_WIDTH,BufferedImage.TYPE_INT_RGB);
		Graphics graphics = bi.getGraphics();
		graphics.setColor(new Color(100,230,200));
		graphics.fillRect(0, 0, 100, 30);
		char[] codeChar = "ABCDEFGHIJKLMNOPQRSTUVWXVZabcdefghijklmnopqrstuvwxyz0123456789".toCharArray();
		String captcha="";
		Random random = new Random();
		System.out.println("ValiCodeController:"+random);
		for(int i=0;i<CODE_LEN;i++) {
			int index = random.nextInt(codeChar.length);
			graphics.setColor(new Color(random.nextInt(150),random.nextInt(200),random.nextInt(255)));
			graphics.drawString(codeChar[index]+"", (i*20)+15, 20);
			captcha +=codeChar[index];
			req.getSession().setAttribute("code", captcha);
			
		}
		return bi;
	}

}
