package com.qfedu.house.util;

import org.junit.Test;

public class CommonUtilTest {

	@Test
	public void testGenerateCode() {
		for (int i = 0; i < 100; ++i) {
			System.out.println(CommonUtil.generateCode(4));
		}
	}
}
