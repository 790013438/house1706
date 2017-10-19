package com.qfedu.house.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public final class CommonUtil {
	private static final String CHARS = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static final int LEN = CHARS.length();
	
	private CommonUtil() {
		throw new AssertionError();
	}
	
	/**
	 * 生成指定范围的随机整数
	 * @param min 下限(闭区间)
	 * @param max 上限(开区间)
	 * @return 随机整数
	 */
	public static int randomInt(int min, int max) {
		return (int) (Math.random() * (max - min) + min);
	}
	
	/**
	 * 生成字母数字随机组合的指定长度的验证码
	 * @param len 长度
	 * @return 验证码
	 */
	public static String generateCode(int len) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < len; ++i) {
			int index = randomInt(0, LEN);
			sb.append(CHARS.charAt(index));
		}
		return sb.toString();
	}
	// OCR 
	
	/**
	 * 根据指定的验证码生成对应的图片
	 * @param code 验证码
	 * @param width 图片的宽度
	 * @param height 图片的高度
	 * @return 验证码图片
	 */
	public static BufferedImage generateCodeImage(String code, int width, int height) {
		BufferedImage codeImage = new BufferedImage(width, height, 1);
		Graphics2D g = (Graphics2D) codeImage.getGraphics();
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, width, height);
		g.setColor(Color.BLUE);
		int size = (width - 10) / code.length();
		g.setFont(new Font("Arial", Font.BOLD, size));
		for (int i = 0; i < code.length(); ++i) {
			String currentChar = code.substring(i, i + 1);
			g.drawString(currentChar, 5 + size * i, height / 2);
		}
//		for (int i = 1; i <= 20; ++i) {
//			int x1 = randomInt(0, width);
//			int y1 = randomInt(0, height);
//			int x2 = randomInt(0, width);
//			int y2 = randomInt(0, height);
//			g.drawLine(x1, y1, x2, y2);
//		}
		return codeImage;
	}
}
