package com.ph.config;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 荐家跃
 * @date 2018/5/3 15:33
 * @Title: TokenSpringInterceptor
 * @Description: 防爆
 * @Version:1.0.0
 */
public class TokenSpringInterceptor extends HandlerInterceptorAdapter {
	private static Log logger = LogFactory.getLog(TokenSpringInterceptor.class);

	private static RedisTemplate redisTemplate;

	public TokenSpringInterceptor(RedisTemplate redisTemplate) {
		TokenSpringInterceptor.redisTemplate = redisTemplate;
	}

	/**
	 * 需要防爆的地址
	 */
	private final List<String> getPublicUrls() {
		List<String> publicUrls = new ArrayList<String>();
		publicUrls.add("/api/get/");
		publicUrls.add("/web/merchants/add");
		//publicUrls.add("/web/product/add");
		publicUrls.add("/web/product/productClassify/addClassify");
        //新增咨询分类
		publicUrls.add("/web/consultation/addClassify");
        //后台增加角色
		publicUrls.add("/web/permission/role/add");
        //店铺增加角色
		publicUrls.add("/web/permission/roledp/add");
        //后台增加用户
		publicUrls.add("/web/permission/user/add");
        //店铺增加用户
		publicUrls.add("/web/permission/userdp/add");
		publicUrls.add("/web/supplier/add");
        //添加商品 系统
//		publicUrls.add("/web/product/addSup");
        //添加商品 店铺
		publicUrls.add("/web/product/merchantsaveproduct");
        //添加商品 店铺
		publicUrls.add("/web/product/addSupdp");
        //后台添加服务专员
		publicUrls.add("/web/headhunting/addHeadhunting");
        //后台添加进货订单
		publicUrls.add("/web/order/purchase/addPurchaseOrder");
        //后台添加商户地址
		publicUrls.add("/web/warehouseaddress/add");
		//后台进货订单发货
		publicUrls.add("/web/order/supply/sendGoods");
		//后台进货订单收货
		publicUrls.add("/web/order/supply/confirmGoods");
		//后台进货订单撤销
		publicUrls.add("/web/order/supply/revoke");
		//创建线下订单
		publicUrls.add("/web/Cashier/addUnLineOrder");
		//提交修改库存申请
		publicUrls.add("/web/repertory/addRepertoryApply");
		//新增本地供应商商品
		publicUrls.add("/web/product/addLocalSupPro");
		//添加供应商
		//publicUrls.add("/web/supplier/addSuppler");
		//添加驻店专员
		publicUrls.add("/web/merchant/add");
		return publicUrls;
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String url = request.getRequestURI();
		String clientIP = getClientIP(request);
		request.setAttribute("token", "ip"+clientIP);
		System.out.println(handler.getClass().toString());
		TokenEnum spring;
		boolean isajax = "XMLHttpRequest".equals(request.getHeader("X-Requested-With"));

		List<String> publicUrls = getPublicUrls();
		for (String publicUrl : publicUrls) {
			if (url.contains(publicUrl)) {
				spring = TokenHelper.validToken(request, redisTemplate);
				// 缓存中存在表明了改地址存储
				// 重复提交表单 请求
				if (spring == TokenEnum.FAILED) {

					// ajax请求的数据
					if (isajax) {
						request.setAttribute("error", "请勿重复提交");
						request.getRequestDispatcher("/index").forward(request, response);
					}
					request.setAttribute("error", "请勿重复提交");
					request.getRequestDispatcher("/index").forward(request, response);
					return false;
					//否则 没设置请求token
				} else if (spring == TokenEnum.NOTFOUNDFROMREQUEST) {
					request.setAttribute("error", "请求参数不正确");
					request.getRequestDispatcher("/index").forward(request, response);
					return false;
				}
			}
		}
		return super.preHandle(request, response, handler);
	}

	/**
	 * 获取访问的真实IP
	 * @param request
	 * @return
	 */
	public static String getClientIP(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		String string="unknown";
		if (ip == null || ip.length() == 0 || string.equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || string.equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || string.equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}

}
