package cn.yl.controller;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.yl.service.ValiCodeService;
/**
 * 此类用于验证码操作
 * @author soft01
 *
 */
@Controller
public class ValiCodeController {
	@Resource
	ValiCodeService valiCodeService;
	/**
	 * 获得验证码
	 * @param req
	 * @param resp
	 * @return
	 */
	@RequestMapping("/getCode.do")
	public String getCode(HttpServletRequest req, HttpServletResponse resp) {
		BufferedImage bi = valiCodeService.getCode(req);
		try {
			ImageIO.write(bi, "JPG", resp.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 检查验证码
	 * @param req
	 * @param resp
	 * @return
	 */
	@RequestMapping("/checkyz.do")
	@ResponseBody
	public String checkCode(HttpServletRequest req,HttpServletResponse resp) {
		String code = (String)req.getSession().getAttribute("code");
		String inputCode = req.getParameter("code");
		System.out.println("valiCodeController.checkCodeServlet():"+inputCode+":"+code);
		resp.setContentType("text/html;charset=utf-8");
		if(code.toLowerCase().equals(inputCode.toLowerCase())) {
			return "正确";
		}else {
			return "错误";
		}
		
	}
}
