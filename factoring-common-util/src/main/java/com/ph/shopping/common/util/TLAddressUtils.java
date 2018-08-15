package com.ph.shopping.common.util;

import org.apache.commons.collections.map.HashedMap;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

public class TLAddressUtils {

	/**
	 * 推流防盗链Key
	 */
	 private static final String KEY = "5017243bfaa0ebe562e3067f2212e1d5";

	/**
	 * @description ：获取腾讯云推流地址
	 * @author : gaoge
	 * @Creation Date ： 2018/5/14 15:12
	 * @version 1.0.0
	 * @param bizid  创建腾讯云平台后开通直播后的bizid
	 * @param roomId  房间号
	 * @return : java.lang.String
	 */
	public static Map<String,Object> getTLAdderss(String bizid, String roomId,String key) {
		Map<String,Object> address=new HashedMap();
		//stream_id
		String stream_id=bizid+"_"+roomId;
		//过期时间
		long txTime=(System.currentTimeMillis()/1000+60*60*24*30);
		String url=getSafeUrl(key,stream_id,txTime);
		//推流地址
		String tlAddress="rtmp://"+bizid+".livepush.myqcloud.com/live/"+stream_id+"?bizid="+bizid+"&"+url;
		address.put("tlAddress",tlAddress);

		//播放地址 (RTMP)
		String rtmpAddress="rtmp://"+bizid+".liveplay.myqcloud.com/live/"+stream_id;
		address.put("rtmpAddress",rtmpAddress);

		//播放地址 (FLV)
		String flvAddress="http://"+bizid+".liveplay.myqcloud.com/live/"+stream_id+".flv";
		address.put("flvAddress",flvAddress);

		//播放地址 (HLS)
		String hlsAddress="http://"+bizid+".liveplay.myqcloud.com/live/"+stream_id+".m3u8";
		address.put("hlsAddress",hlsAddress);

		return  address;
	}

	private static final char[] DIGITS_LOWER =
			{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

	/*
     * KEY+ stream_id + txTime
     */
	private static String getSafeUrl(String key, String streamId, long txTime) {
		System.out.println("key = "+key);
		System.out.println("streamid = "+streamId);
		System.out.println("txtime = "+txTime);


		String input = new StringBuilder().
				append(key).
				append(streamId).
				append(Long.toHexString(txTime).toUpperCase()).toString();

		String txSecret = null;
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			txSecret  = byteArrayToHexString(
					messageDigest.digest(input.getBytes("UTF-8")));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		System.out.println(txSecret+"***********");
		return txSecret == null ? "" :
				new StringBuilder().
						append("txSecret=").
						append(txSecret).
						append("&").
						append("txTime=").
						append(Long.toHexString(txTime).toUpperCase()).
						toString();
	}

	private static String byteArrayToHexString(byte[] data) {
		char[] out = new char[data.length << 1];

		for (int i = 0, j = 0; i < data.length; i++) {
			out[j++] = DIGITS_LOWER[(0xF0 & data[i]) >>> 4];
			out[j++] = DIGITS_LOWER[0x0F & data[i]];
		}
		return new String(out);
	}
}
