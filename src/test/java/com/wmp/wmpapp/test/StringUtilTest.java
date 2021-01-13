package com.wmp.wmpapp.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.wmp.wmpapp.util.WmpStringUtil;

public class StringUtilTest {

	// HTML태그제거
	@Test
	public void removeHtmlTag() {
		String str = "<html><head><body><div><hello</div></body></head></html>";
		assertEquals("<hello", WmpStringUtil.removeHtmlTag(str));
	}

	// 영문 이외의 문자제거
	@Test
	public void removeWithoutEn() {
		String str = "가ABC12나다xyz!@#";
		assertEquals("ABCxyz", WmpStringUtil.removeWithoutEn(str));
	}

	// 숫자 이외의 문자제거
	@Test
	public void removeWithoutNum() {
		String str = "가ABC12나다xyz!@#";
		assertEquals("12", WmpStringUtil.removeWithoutNum(str));
	}

	// 영문으로 구성된 문자정렬
	@Test
	public void enStrSort() {
		String str = "AcEgaaaHfDb";
		assertEquals("AaaabcDEfgH", WmpStringUtil.enStrSort(str));
	}

	// 숫자로 구성된 문자정렬
	@Test
	public void numStrSort() {
		String str = "1209348576";
		assertEquals("0123456789", WmpStringUtil.numStrSort(str));
	}

	// 문자열 결합
	@Test
	public void mergeStr() {
		String firStr = "AabCCCdddEEEEFFff";
		String secStr = "012";
		assertEquals("A0a1b2CCCdddEEEEFFff", WmpStringUtil.mergeStr(firStr, secStr));
	}

}
