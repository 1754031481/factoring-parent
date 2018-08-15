package com.ph.shopping.common.util;

import com.alibaba.fastjson.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * Discovery Pay SDK 代付交易
 * @Description: TODO
 * @author Shen.joe
 * @e-mail sudiluo_java@163.com
 * @version v1.0
 * @copyright 2010-2015
 * @create-time 2017年8月29日 下午5:42:43
 * 
 */
public class DPRequestUtils {

	public enum REQUEST_TYPE {
		/**
		 * POST
		 */
		POST,
		/**
		 * PUT
		 */
		PUT,
		/**
		 * GET
		 */
		GET,
		/**
		 * DELETE
		 */
		DELETE
	}

	/**
	 * doPost方法，封装rest api POST方式请求
	 *
	 * @param requestUrl 请求url
	 * @param param 请求参数
	 * @return rest api返回参数
	 * @throws DPException
	 */
	public static Map<String, Object> doPost(String requestUrl, Map<String, Object> param)
			throws DPException {
		String jsonString = JSONObject.toJSONString(param);
		return postJson(requestUrl, jsonString);
	}

	@SuppressWarnings("unchecked")
	private static Map<String, Object> postJson(String url, String param) throws DPException {
		HttpURLConnection connection =null;
		Integer reponseStatus;
		try {
			// 创建连接
			URL url2 = new URL(url);
			connection = (HttpURLConnection) url2.openConnection();
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setRequestMethod("POST");
			connection.setUseCaches(false);
			connection.setInstanceFollowRedirects(true);
			connection.setReadTimeout(20000);
			connection.setConnectTimeout(20000);
			connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
			connection.connect();

			// POST请求
			DataOutputStream out = new DataOutputStream(connection.getOutputStream());
			// out.writeBytes(obj.toString());//这个中文会乱码
			out.write(param.getBytes("UTF-8"));// 这样可以处理中文乱码问题
			out.flush();
			out.close();
			reponseStatus = connection.getResponseCode();
			// 读取响应
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(connection.getInputStream()));
			String lines;
			StringBuffer sb = new StringBuffer("");
			while ((lines = reader.readLine()) != null) {
				lines = new String(lines.getBytes(), "utf-8");
				sb.append(lines);
			}
			reader.close();
			if (StrShyUtil.empty(sb)) {
				throw new DPException(-4, "接收参数为空", "接收参数为空", reponseStatus);
			}
			JSONObject jsonObject = null;
			Map<String, Object> javaObject = new HashMap<>(16);
			try {
				jsonObject = JSONObject.parseObject(StrShyUtil.toStr(sb));
				javaObject = JSONObject.toJavaObject(jsonObject, Map.class);
			} catch (Exception e) {
				javaObject.put("error", e.getMessage());
				javaObject.put("info", StrShyUtil.toStr(sb));
			}
			return javaObject;
		} catch (MalformedURLException e) {
			e.printStackTrace();
			throw new DPException(-2, "url不合法,url不合法" , e.getMessage());
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			throw new DPException(-2, "编码错误,编码错误" , e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
			throw new DPException(-3, "IOException,网络异常" , e.getMessage());
		} catch (DPException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw new DPException(-5, "Unknown,未知异常", e.getMessage());
		} finally {
			if (connection != null) {
				connection.disconnect();
			}
		}
	}
}
