package com.ph.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author whl
 * @version 1.0.0
 * @description 列表返回拦截器
 * @date 2018-04-27 13:57
 */
public class ListBackInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        String pageNum = request.getParameter("pageNum");
        String pageSize = request.getParameter("pageSize");
        HttpSession session = request.getSession();
        String uri = request.getRequestURI();
        uri = uri.toLowerCase();
        boolean flg = uri.contains("list");
        if (flg) {
            //列表或列表页面请求
            if (pageNum != null && !"".equals(pageNum) && pageSize != null && !"".equals(pageSize)) {
                session.removeAttribute("isBack");
                //列表数据请求
                Long lPageNum = Long.valueOf(pageNum);
                Long lPageSize = Long.valueOf(pageSize);
                session.setAttribute("iDisplayStart", (lPageNum - 1) * lPageSize);
            }
        } else {
            //非列表请求
            session.setAttribute("isBack", true);
        }
        return super.preHandle(request, response, handler);
    }

}
