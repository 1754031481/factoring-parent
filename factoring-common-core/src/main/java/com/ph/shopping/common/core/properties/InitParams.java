package com.ph.shopping.common.core.properties;

import org.apache.commons.codec.binary.Base64;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

/**
 * 读取配置文件工具类
 *
 * 2017-12-22
 * @author zjb
 */

public class InitParams {

	private Properties properties = new Properties();

	private String uri = "";

	public InitParams(String uri){
		this.uri = uri;
	}

	/**
	 * 加载配置文件
	 * @throws IOException
	 */
	public void init() throws Exception {
		Properties proper = new Properties();
     	proper.load(new FileReader("c:"+uri));
//		proper.load(new FileReader(uri));

		Map<String,String> map=new HashMap<String,String>(16);
		 Iterator<Object> keys = proper.keySet().iterator();
	     while(keys.hasNext()) {
			 String key= (String)keys.next();
			 if(proper.getProperty(key)!=null){
				 map.put(key, proper.getProperty(key).toString());
			 }
	    }
		proper.putAll(map);
		properties.putAll(proper);

	}
	public Properties getProperties() {
		try {
			init();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return properties;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}
	private final static Base64 BASE64=new Base64();

}
