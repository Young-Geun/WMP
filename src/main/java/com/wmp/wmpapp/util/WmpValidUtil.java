package com.wmp.wmpapp.util;

import java.util.regex.Pattern;

public class WmpValidUtil {

	/**
	 * @author 		: Young-geun Choi
	 * @since 		: 1.0
	 * @description	: URL 형태의 포맷인지 검사한다.
	 */
	public static boolean isUrlPattern(String url) {
		String regex = "^(https?):\\/\\/([^:\\/\\s]+)(:([^\\/]*))?((\\/[^\\s/\\/]+)*)?\\/?([^#\\s\\?]*)(\\?([^#\\s]*))?(#(\\w*))?$";
		Pattern p = Pattern.compile(regex);
		return p.matcher(url).matches();
	}

	/**
	 * @author 		: Young-geun Choi
	 * @since 		: 1.0
	 * @description	: 자연수인지 검사한다.
	 */
	public static boolean isNaturalNum(int param) {
		return param > 0 ? true : false;
	}
}
