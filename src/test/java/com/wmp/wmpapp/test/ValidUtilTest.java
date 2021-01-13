package com.wmp.wmpapp.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.wmp.wmpapp.util.WmpValidUtil;

public class ValidUtilTest {
	
	// URL패턴 확인
	@Test
	public void CertUrlPattern() {
		// 올바른 URL형태
		String url = "https://front.wemakeprice.com/main";		
		assertTrue(WmpValidUtil.isUrlPattern(url));
		
		// 올바르지않은 URL형태
		String url2 = "httpsfrontwemakepricecommain";	
		assertFalse(WmpValidUtil.isUrlPattern(url2));
	}

	// 자연수 확인
	@Test
	public void CertNaturalNum() {
		// 자연수
		int num = 7;
		assertTrue(WmpValidUtil.isNaturalNum(num));
		
		// 자연수 외 숫자
		int num2 = -70;
		assertFalse(WmpValidUtil.isNaturalNum(num2));				
	}
	
}
