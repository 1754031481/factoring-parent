package com.ph.shopping.facade.pay.config;

/**
 * @package : com.ph.controller.payorder
 * @progect : factoring-parent
 * @Description : pay工程对接重要参数
 * @Created by : wangxueyang
 * @Creation Date ：2018年01月03日16:35
 */

public class PayConfig {
	
	/**
	 * 天易支付系统来源
	 */
	public static final String PAY_SYSTEM_FROM_TYAPP="PAY_SYSTEM_FROM_TY_APP";//天易微信App
	public static final String PAY_SYSTEM_FROM_TYPUBLIC="PAY_SYSTEM_FROM_TY_PU";//天易微信公众号
	//快火支付宝支付系统来源标识
	public static final String PAY_SYSTEM_FROM_KHAPP="PAY_SYSTEM_FROM_KHAPP";//快火App
	public static final String PAY_SYSTEM_FROM_TYAPP_ALIPAY="PAY_SYSTEM_FROM_TY_APP1";//天易支付宝支付
	/**
	 * 天易支付宝支付参数
	 */
	//支付宝请求pay加签路径（测试）
//	public static final String AliPaySignUrl = "http://118.89.229.182/pay/alipay/AppSign";
	public static final String AliPaySignUrl = "http://118.89.229.182/pay/alipay/addSign";//新通道
	//支付宝pay工程请求验签
	public static final String AliPaySignCheckUrl="http://118.89.229.182/pay/alipay/AppVerify";
	//支付宝回调路径（测试）
	public static final String AliASYNC_NOTIFY_URL = "http://211.103.138.178:5001/mobile/view/alipay/payback";
	//pay推送支付宝回调结果（测试）
	public static final String AliASYNC_NOTIFY_URL_PAY = "http://211.103.138.178:5001/mobile/view/alipay/aLiPayBackForPay";

	//支付宝请求路径（正式）
//	public static final String AliPaySignUrl = "http://merchantcenter.sht315.com/pay/alipay/AppSign";
//	public static final String AliPaySignUrl = "http://merchantcenter.sht315.com/pay/alipay/addSign";//新通道
	//支付宝pay工程请求验签（正式）
//	public static final String AliPaySignCheckUrl="http://merchantcenter.sht315.com/pay/alipay/AppVerify";
	//支付宝回调路径（正式）
//	public static final String AliASYNC_NOTIFY_URL = "http://113.209.232.190:5001/mobile/view/alipay/payback";
	//pay推送支付宝回调结果（正式）
//	public static final String AliASYNC_NOTIFY_URL_PAY = "http://113.209.232.190:5001/mobile/view/alipay/aLiPayBackForPay";

	/**
	 * 天易微信支付相关参数
	 */
	//微信统一下单URL
	public static final String WeChat_ORDER_PAY = "https://api.mch.weixin.qq.com/pay/unifiedorder";
	public final static String APPID = "wx790b136fb3f3756e";
	public final static String MCH_ID = "1489302412";

	//微信公众号号支付
	public final static String WX_PUBLIC_APPID = "wx86e5f790a962927a";
	public final static String WX_PUBLIC_MCHID = "1451851102";

	//微信请求pay  加签路径(正式)
//	public final static String Wechat_PAY_REQUEST_URL ="http://merchantcenter.sht315.com/pay/app/sign";
	//微信异步通知地址（正式）
//	public final static String Wechat_NOTIFY_URL = "http://140.143.131.254:40050/wxpaycallback";
	//微信异步pay通知推送路径(正式)
//	public final static String WeChat_Push_URL = "http://113.209.232.190:5001/mobile/view/wxpay/wxPayBackForPay";


	//微信请求pay加签路径(测试)
	public final static String Wechat_PAY_REQUEST_URL ="http://rsjjl.sht315.com/pay/app/sign";
	//微信异步通知地址（测试）
	public final static String Wechat_NOTIFY_URL = "http://118.89.229.182:40050/wxpaycallback";
	//微信pay推送回调路径（测试）
	public final static String WeChat_Push_URL = "http://211.103.138.178:5001/mobile/view/wxpay/wxPayBackForPay";

	//微信支付对接pay公钥
	public final static String PUBLIC_KRY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCiahhmGlsiwtIgRNX0HgHDeqsmCPtGqZ3fiig5TLv9Qqj/On4yCSk/xx+I2esiNT1z0WhWqTnN9UbbyfmmFpqhXcpC8PyLXrbPcK/F7jldGreXtiTfBcBFyIQ33rCL7AE4mrcYnz7yYc036db2fzenWDlAR7srJUQ8xFZ6ZzVRZwIDAQAB";
	//微信验签请求地址（未启用）
	public final static String Wechat_PAY_CHECK_URL="http://123.206.92.142:20028/SHY-pay_interface/pay/wxpay/AppVerify";

}
