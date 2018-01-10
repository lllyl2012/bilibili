package cn.yl.service;

import java.awt.image.BufferedImage;

import javax.servlet.http.HttpServletRequest;

public interface ValiCodeService {
	BufferedImage getCode(HttpServletRequest req);
}
