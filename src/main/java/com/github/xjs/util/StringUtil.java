/**
 * 
 */
package com.github.xjs.util;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 605162215@qq.com
 *
 *         2016年8月12日 下午5:25:52
 */
public class StringUtil {

	public static boolean isEmpty(String src) {
		if (src == null || src.trim().length() <= 0) {
			return true;
		}
		return false;
	}

	public static boolean isChinese(String value) {
		boolean result = false;
		String reg = "[^u4E00-u9FA5]+";
		Pattern pattern = Pattern.compile(reg, 34);
		Matcher matcher = pattern.matcher(value);

		if (matcher.find()) {
			result = true;
		}

		return result;
	}
	
	public static String toString(byte[] data){
		try{
			return toString(data, "UTF-8");
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	public static String toString(byte[] data, String charset){
		try{
			return new String(data, charset);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	public static String urlEncode(String url){
		try{
			return URLEncoder.encode(url, "UTF-8");
		}catch(Exception e){
			e.printStackTrace();
			return url;
		}
	}
	
	public static String urlDecode(String url){
		try{
			return URLDecoder.decode(url, "UTF-8");
		}catch(Exception e){
			e.printStackTrace();
			return url;
		}
	}

	public static String underlineToCamel(String param) {
		if (param == null || "".equals(param.trim())) {
			return "";
		}
		int len = param.length();
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++) {
			char c = param.charAt(i);
			if (c == '_') {
				if (++i < len) {
					sb.append(Character.toUpperCase(param.charAt(i)));
				}
			} else {
				sb.append(c);
			}
		}
		return sb.toString();
	}

	public static String camelToUnderline(String param) {
		if (param == null || "".equals(param.trim())) {
			return "";
		}
		int len = param.length();
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++) {
			char c = param.charAt(i);
			if (Character.isUpperCase(c)) {
				sb.append("_");
				sb.append(Character.toLowerCase(c));
			} else {
				sb.append(c);
			}
		}
		return sb.toString();
	}
}
