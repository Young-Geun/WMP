package com.wmp.wmpapp.util;

import java.util.Arrays;
import java.util.Comparator;

public class WmpStringUtil {

	/**
	 * @author 		: Young-geun Choi
	 * @since 		: 1.0
	 * @description	: 문자열 내에 HTML태그를 제거한다.  
	 */
	public static String removeHtmlTag(String paramStr) {
		return paramStr.replaceAll("<(/)?([a-zA-Z]*)(\\\\s[a-zA-Z]*=[^>]*)?(\\\\s)*(/)?>", "");
	}

	/**
	 * @author 		: Young-geun Choi
	 * @since 		: 1.0
	 * @description	: 문자열 내에 영문 이외의 모든 문자(공백 포함)를 제거한다.  
	 */
	public static String removeWithoutEn(String paramStr) {
		return paramStr.replaceAll("[^a-zA-Z]", "");
	}

	/**
	 * @author 		: Young-geun Choi
	 * @since 		: 1.0
	 * @description	: 문자열 내에 숫자 이외의 모든 문자(공백 포함)를 제거한다.  
	 */
	public static String removeWithoutNum(String paramStr) {
		return paramStr.replaceAll("[^0-9]", "");
	}

	/**
	 * @author 		: Young-geun Choi
	 * @since 		: 1.0
	 * @description	: 영문으로만 구성된 문자열을 AaBbCcDd.. 의 형태로 정렬한다.  
	 */
	public static String enStrSort(String paramStr) {
		StringBuffer sb = new StringBuffer();
		String[] tmpArr = paramStr.split("");

		Arrays.sort(tmpArr, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				int result = o1.toUpperCase().compareTo(o2.toUpperCase());

				if (result != 0) {
					return result;
				} else {
					return o1.compareTo(o2);
				}
			}
		});

		for (String s : tmpArr) {
			sb.append(s);
		}

		return sb.toString();
	}

	/**
	 * @author 		: Young-geun Choi
	 * @since 		: 1.0
	 * @description	: 숫자로만 구성된 문자열을 오름차순으로 정렬한다.
	 */
	public static String numStrSort(String paramStr) {
		StringBuffer sb = new StringBuffer();
		char[] tmpArr = paramStr.toCharArray();

		Arrays.sort(tmpArr);
		for (char c : tmpArr) {
			sb.append(c);
		}

		return sb.toString();
	}

	/**
	 * @author 		: Young-geun Choi
	 * @since 		: 1.0
	 * @description	: 두 개의 문자열을 번갈아가며 합친다.
	 * 				  Ex) firStr=abc, secStr=123, return=a1b2c3
	 */
	public static String mergeStr(String firStr, String secStr) {
		StringBuffer sb = new StringBuffer();
		char[] firArr = firStr.toCharArray();
		char[] secArr = secStr.toCharArray();

		int min = Math.min(firArr.length, secArr.length);
		int max = Math.max(firArr.length, secArr.length);

		for (int i = 0; i < min; i++) {
			sb.append(firArr[i]);
			sb.append(secArr[i]);
		}

		for (int i = min; i < max; i++) {
			if (firArr.length > secArr.length) {
				sb.append(firArr[i]);
			} else {
				sb.append(secArr[i]);
			}
		}

		return sb.toString();
	}
}
