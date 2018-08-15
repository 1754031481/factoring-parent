package com.ph.base;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.BeansException;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @description: copy from okdiweb
 * @author feng.wang
 * @date 2014-9-5
 * @version: 1.0.0
 */
public class PubMethod {

	public static final String[] FLAG = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e",
			"f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z" };

	public static StringBuffer concat(StringBuffer srcStr, String addStr, String splitStr) {
		if (PubMethod.isEmpty(addStr)) {
			return srcStr;
		}
		if (!PubMethod.isEmpty(srcStr) && srcStr.length() > 0 && !PubMethod.isEmpty(addStr)) {
			srcStr.append(splitStr).append(addStr);
		} else {
			srcStr.append(addStr);
		}
		return srcStr;
	}

	/**
	 * List 浅拷贝
	 * 
	 * @param src
	 * @param dest
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void copyCollectionByAdd(Collection src, Collection dest) {
		if (PubMethod.isEmpty(src) || PubMethod.isEmpty(dest)) {
            return;
        }

		// for (int i = 0 ; i< src.size() ;i++) {//jdk 1.4
        // jdk 1.5 以上版本
        for (Object obj : src) {
			// Object obj = src.get(i);
			dest.add(obj);
		}
	}

	/**
	 * 对象间值的相互拷贝.
	 */
	public static void copyPropeties(Object srcObj, Object destObj) {
		try {
			org.springframework.beans.BeanUtils.copyProperties(srcObj, destObj);
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/** 判断是否存在 单引号。
	 *
	 * @param str
	 * @return
	 */
	public static boolean isContainSingleQuotes(String str) {
	    String temp = "'";
		if (str.indexOf(temp) >= 0) {
            return true;
        } else {
            return false;
        }
	}

	/** 判断是否为空。
	 *
	 * @param value
	 * @return
	 */
	public static boolean isEmpty(String value) {
		return (value == null || "".equals(value));
	}

	/**
	 * @function:判空 @author:
	 */
	@SuppressWarnings("rawtypes")
	public static boolean isEmpty(List list) {
		if (list == null || list.size() == 0) {
            return true;
        } else {
            return false;
        }
	}

	/**
	 * @function:判空 @author:
	 */
	@SuppressWarnings("rawtypes")
	public static boolean isEmpty(Set set) {
		if (set == null || set.size() == 0) {
            return true;
        } else {
            return false;
        }
	}

	/**
	 * @function:判空 @author:
	 */
	@SuppressWarnings("rawtypes")
	public static boolean isEmpty(Map map) {
		if (map == null || map.size() == 0) {
            return true;
        } else {
            return false;
        }
	}

	/**判断是否为空。
	 *
	 * @param value
	 * @return
	 */
	public static boolean isEmpty(Object value) {
		if (value == null) {
            return true;
        } else {
            return false;
        }
	}

	public static boolean isEmpty(StringBuffer value) {
		if (value == null || value.length() <= 0) {
            return true;
        } else {
            return false;
        }
	}

	public static boolean isEmpty(Double value) {
		if (value == null || value.doubleValue() == 0.0) {
            return true;
        } else {
            return false;
        }
	}

	/**
	 * 判断是否为空。
 	 */
	public static boolean isEmpty(Long obj) {
		if (obj == null || obj.longValue() == 0) {
            return true;
        } else {
            return false;
        }
	}

	/** 判断是否为空。
	 *
	 * @param value
	 * @return
	 */
	public static boolean isEmpty(Object[] value) {
		if (value == null || value.length == 0) {
            return true;
        } else {
            return false;
        }
	}

	/**
	 * 返回有效状态值
	 * @return
	 */
	public static int validState() {
		return 1;
	}

	/**
	 * 返回无效状态值
	 * @return
	 */
	public static int invalidState() {
		return 0;
	}

	/**
	 * 判断状态是否有效。0无效、1有效、9删除。
	 * @param state
	 * @return
	 */
	public static boolean isValid(int state) {
		if (state == 1) {
            return true;
        } else {
            return false;
        }
	}

	/**
	 * Set集合到List的转换
	 * @param set
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static List getList(Set set) {
		List list = new ArrayList();
		Iterator iterator = set.iterator();
		while (iterator.hasNext()) {
			list.add(iterator.next());
		}
		return list;
	}

	/**
	 * 把List转换为Set
	 * 
	 * @param set
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Set convertList2Set(List list) {
		if (list == null || list.size() == 0) {
            return null;
        }
		Set set = new HashSet();
		Iterator iterator = list.iterator();
		while (iterator.hasNext()) {
			set.add(iterator.next());
		}
		return set;
	}

	/**
	 * 用户名正则验证
	 * 
	 * @param account
	 *            用户名
	 * @return
	 */
	public static boolean regexAccount(String account) {

		return true;

	}

	/**
	 * 密码正则验证
	 * 
	 * @param pwd
	 *            用户名
	 * @return
	 */
	public static boolean regexPwd(String pwd) {

		return true;

	}

	/**
	 * 获取系统操作时间
	 * 
	 * @param
	 * @return String
	 */
	public static String getSysOptDate() {
		Calendar date = Calendar.getInstance();
		Date sysDate = date.getTime();
		String optDate = PubMethod.dateToString(sysDate, "yyyy-MM-dd HH:mm:ss");
		return optDate;
	}

	/**
	 * 字符串转换为Date类型
	 * 
	 * @param dteValue
	 *            String 日期串
	 * @return Date
	 */
	public static String dateToString(Date dteValue, String strFormat) {
		if (PubMethod.isEmpty(dteValue)) {
			return null;
		}
		SimpleDateFormat clsFormat = new SimpleDateFormat(strFormat);
		return clsFormat.format(dteValue);
	}

	/**
	 * Description（方法描述）:生成随机六位密码(数字+英文) Author（开发人员）:ＨaiＦｅｎｇ.Ｈｅ Receive
	 * parameters(接收参数): Return parameters(返回参数):
	 */
	public static String createPassword() {
        // 生成密码
        StringBuffer idenCode = new StringBuffer();
		Random ran = new Random();
		int temp = 6;
		for (int i = 0; i < temp; i++) {
			idenCode.append(FLAG[ran.nextInt(36)]);
		}
		return idenCode.toString();
	}

	public static String escape(String src) {
		int i;
		char j;
		StringBuffer tmp = new StringBuffer();
		tmp.ensureCapacity(src.length() * 6);
		for (i = 0; i < src.length(); i++) {
			j = src.charAt(i);
			if (Character.isDigit(j) || Character.isLowerCase(j) || Character.isUpperCase(j)) {
                tmp.append(j);
            } else if (j < 256) {
				tmp.append("%");
				if (j < 16) {
                    tmp.append("0");
                }
				tmp.append(Integer.toString(j, 16));
			} else {
				tmp.append("%u");
				tmp.append(Integer.toString(j, 16));
			}
		}
		return tmp.toString();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Object strToList(String str) {
		if (isEmpty(str)) {
			return null;
		}
		List list = new ArrayList();
		String[] strArry = str.split(",");
		if (strArry.length > 1) {
			for (int i = 0; i < strArry.length; i++) {
				list.add(strArry[i]);
			}
		} else {
			list.add(str);
		}
		return list;
	}

	public static String paramsFailure(String errSubcode, String message) {
		Map<String, Object> map = new HashMap<String, Object>(16);
		map.put("success", false);
		map.put("errCode", 0);
		map.put("errSubcode", errSubcode);
		map.put("message", message);
		return JSON.toJSONString(map);
	}

	public static Timestamp getSysTimestamp() {
		return new Timestamp(System.currentTimeMillis());
	}

	/**
	 * Java按字节数截取字符串，一个中文长度为2
	 * 
	 * @param str
	 *            要截取的字符串
	 * @param subLength
	 *            截取字节数
	 * @return
	 */
	public static String limitString(String str, int subLength) {
		try {
			if (str == null) {
				return "";
			} else {
				int tempSubLength = subLength;
				String subStr = str.substring(0, str.length() < subLength ? str.length() : subLength);
                // 截取子串的字节长度
                int subByetsLength = subStr.getBytes("GBK").length;
				// 说明截取的字符串中包含有汉字
				while (subByetsLength > tempSubLength) {
					int subLengthTemp = --subLength;
					subStr = str.substring(0, (subLengthTemp > str.length() ? str.length() : subLengthTemp));
					subByetsLength = subStr.getBytes("GBK").length;
				}
				return subStr;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}

	public static String subDate(Date d1, Date d2) {
		String result = "";
		try {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date now = df.parse(d1.toString());
			Date date = df.parse(d2.toString());
			long l = now.getTime() - date.getTime();
			long day = l / (24 * 60 * 60 * 1000);
			long hour = (l / (60 * 60 * 1000) - day * 24);
			long min = ((l / (60 * 1000)) - day * 24 * 60 - hour * 60);
			long s = (l / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
			System.out.println(day + "," + hour + "," + min + "," + s + ",");
			result = day + "," + hour + "," + min + "," + s + ",";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public static long getLastSecond(Date createTime) {
		long second = 0;
		second = System.currentTimeMillis() - createTime.getTime();
		long temp = 10800000;
		if (second > temp) {
			return 0;
		} else {
			return second / 1000;
		}
	}

	public static String jsonSuccess(Object mapObject) {
		Map<String, Object> allMap = new HashMap<String, Object>(16);
		allMap.put("success", true);
		if (null != mapObject) {
			allMap.put("data", mapObject);
		}
		return JSON.toJSONString(allMap);
	}

	public static String jsonFailure() {
		Map<String, Object> map = new HashMap<String, Object>(16);
		map.put("success", false);
		return JSON.toJSONString(map);
	}

	public static String numForamt(Object obj) {
		DecimalFormat df = new DecimalFormat("#.00");
		return df.format(obj);
	}

	// 根据图片地址判断图片是否存在
	@SuppressWarnings("unused")
	public static boolean isExitsImage(String imageUrl) {
		boolean flag = true;
		try {
			URL url = new URL(imageUrl);
			// 返回一个 URLConnection 对象，它表示到 URL 所引用的远程对象的连接。
			URLConnection uc = url.openConnection();
			// 打开的连接读取的输入流。
			InputStream in = uc.getInputStream();
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}

//	/**
//	 * 敏感字过滤
//	 *
//	 * @param str
//	 *            要过滤的字符串
//	 * @return true: 合法 不包含敏感词 false: 不合法 有敏感词
//	 */
//	public static Boolean replaceSensitiveWord(String string) throws Exception {
//		String str = "";
//		if (isEmpty(string)) {
//			return Boolean.TRUE;
//		}
//		SensitivewordFilter filter = new SensitivewordFilter();
//		// System.out.println("待检测语句字数：" + string.length());
//		// long beginTime = System.currentTimeMillis();
//		Set<String> set = null;
//		// if(string.matches(".*[\u4E00-\u9FA5]+.*")){ set = filter.getSensitiveWord(string, 10);
//		str = filter.replaceSensitiveWord(string, 10, set, "*");
//		// }else{
//		// SensitivewordFilterEng filtere = new SensitivewordFilterEng();
//		// set = filtere.getSensitiveWord(string, 1);
//		// str = filtere.replaceSensitiveWord(string,1, "*");
//		// }
//		// long endTime = System.currentTimeMillis();
//		if (str.equals(string)) {
//			return Boolean.TRUE;
//		}
//		// String continuity = getContinuity(str);
//		// System.out.println("语句中包含敏感词的个数为：" + set.size() + "。包含：" + set);
//		// System.out.println("总共消耗时间为：" + (endTime - beginTime));
//		return Boolean.FALSE;
//	}

	@SuppressWarnings("unused")
	private static String getContinuity(String s) {
		List<String> resList = new ArrayList<String>();
		for (int i = 0; i < s.length(); i++) {
			char a = s.charAt(i);
			int j = i + 1;
			while (j < s.length()) {
				char b = s.charAt(j);
				if (a != b) {
					break;
				}
				j++;
			}
			if (j - i >= 2) {
				resList.add(s.substring(i, j));
			}
			i = j - 1;
		}
		for (String string : resList) {
			s = s.replace(string, getStart(string.length()));
		}
		return s;
	}

	private static String getStart(int length) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			sb.append("*");
		}
		return sb.toString();
	}

//	public static boolean replaceSensitiveWordCount(String string) throws Exception {
//		if (isEmpty(string)) {
//			return true;
//		}
//		SensitivewordFilter filter = new SensitivewordFilter();
//		Set<String> set = filter.getSensitiveWord(string, 1);
//		if (set.size() == 0) {
//			return Boolean.TRUE;
//		}
//		return Boolean.FALSE;
//	}

	public static String getMonth(String data) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf2 = new SimpleDateFormat("MM");
		try {
			Date date = sdf.parse(data);
			return sdf2.format(date);
		} catch (Exception e) {
			return sdf.format(new Date());
		}
	}

//	public static void main(String[] args) {
//		System.out.println(getMonth("2015-12-23 14:10:45"));
//		Boolean a;
//		try {
//			String ss = null;
//			ss = "fuck This one pan Sausage Alfredo is ready for dinner in less than 30 minutes";
//			// ss = "颠覆中华人民共和国政权";
//			// ss="美少6女";
//			System.out.println(ss.matches(".*[\u4E00-\u9FA5]+.*"));
//
//			ss = "毛主席ddddddddddddddd傻ddddddddddddddddddddddddddddddddddddddddddddddd逼";
//			ss = "11111111111111111111111rrrrrrrrrrrrrrrrrrrrrrrrrrrrrr";
//
//			a = replaceSensitiveWord(ss);
//			System.out.println("敏感词检测 => " + a);
//
//			a = replaceSensitiveWordCount(ss);
//
//			System.out.println("敏感词检测 => " + a);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
}
