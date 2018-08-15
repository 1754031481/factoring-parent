package com.ph.shopping.common.util.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * @author by : 王海龙
 * @package : com.ph.shopping.common.util.json
 * @progect : factoring-parent
 * @Description :
 * @Creation Date ：2018年06月13日14:27
 */
public class JsonUtil {
    public static boolean compareObject(JSONObject oldObj,JSONObject newObj){
        boolean flg = true;
        for (String key:newObj.keySet()) {
            String oldData = oldObj.getString(key);
            String newData = newObj.getString(key);
            try {
                Double oldNum = Double.parseDouble(oldData);
                Double newNum = Double.parseDouble(newData);
                if(!oldNum.equals(newNum)){
                    flg = false;
                    break;
                }
            }catch (Exception e){
                if(!oldData.equals(newData)){
                    flg = false;
                    break;
                }
            }
        }
        return flg;
    }

    public static boolean compareArray(JSONArray oldArray, JSONArray newArray){
        boolean flg = true;
        if(oldArray.size()!=newArray.size()){
            flg=false;
        }
        if(flg){
            for (int i=0;i<newArray.size();i++) {
                JSONObject newObj = JSON.parseObject(newArray.get(i).toString());
                JSONObject oldObj = JSON.parseObject(oldArray.get(i).toString());
                boolean objFlg = compareObject(oldObj,newObj);
                if (!objFlg){
                    flg=false;
                    break;
                }
            }
        }
        return flg;
    }
}
