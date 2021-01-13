package com.wmp.wmpapp.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WmpConvertUtil {

	private static final Logger logger = LoggerFactory.getLogger(WmpConvertUtil.class);

	/**
	 * @author 		: Young-geun Choi
	 * @since 		: 1.0
	 * @description	: URL을 호출하여 얻은 데이터를 문자열로 변환한다.  
	 */
	public static String htmlToString(String paramUrl) {

		StringBuffer sb = new StringBuffer();
		HttpURLConnection conn = null;
		InputStreamReader reader = null;
		BufferedReader buff = null;

		try {

			URL url = new URL(paramUrl);
			conn = (HttpURLConnection)url.openConnection();
			reader = new InputStreamReader(conn.getInputStream(), "UTF-8");
			buff = new BufferedReader(reader);

			String tmpStr = "";
			while ((tmpStr = buff.readLine()) != null) {
				sb.append(tmpStr);
			}
		} catch (Exception e) {
			logger.error(e.toString());
		} finally {
			if (buff != null) {
				try {
					buff.close();
				} catch (IOException e) {
					logger.error(e.toString());
				}
			}

			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					logger.error(e.toString());
				}
			}

			if (conn != null) {
				try {
					conn.disconnect();
				} catch (Exception e) {
					logger.error(e.toString());
				}
			}

		}
		
		return sb.toString();
	}
}
