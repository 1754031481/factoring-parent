package com.ph.shopping.common.util;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * 自定义异常，该异常信息包含错误码，错误基本信息、错误详细信息
 * @Description: TODO
 * @author Shen.joe
 * @e-mail sudiluo_java@163.com
 * @version v1.0
 * @copyright 2010-2015
 * @create-time 2017年4月19日 上午10:45:22
 * 
 */
public class DPException extends Exception {

    private static final long serialVersionUID = 1L;

    public DPException(Integer resultCode, String resultMessage, String errorDetail, Integer responseCode) {
        super(mapToJsonString(resultCode, resultMessage, errorDetail, responseCode));
    }

    public DPException(Integer resultCode, String resultMessage, String errorDetail) {
    	super(mapToJsonString(resultCode, resultMessage, errorDetail));
    }

    public DPException(String msg) {
        super(msg);
    }
    
    private static String mapToJsonString(Integer resultCode, String resultMessage, String errorDetail){
    	Map<String, Object> map = new HashMap<String, Object>(16);
		map.put("resultCode", resultCode);
		map.put("resultMessage", resultMessage);
		map.put("errorDetail", errorDetail);
		return JSONObject.toJSONString(map);
    }
    
    private static String mapToJsonString(Integer resultCode, String resultMessage, String errorDetail,Integer responseCode){
    	Map<String, Object> map = new HashMap<String, Object>(16);
		map.put("resultCode", resultCode);
		map.put("resultMessage", resultMessage);
		map.put("errorDetail", errorDetail);
		map.put("responseCode", responseCode);
		return JSONObject.toJSONString(map);
    }
}
