package com.ph.config;

import com.dianping.cat.servlet.CatFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 过滤器
 * @author xwolf
 **/
@Configuration
public class FilterConfiguration {

    @Bean
    public FilterRegistrationBean catFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        CatFilter filter = new CatFilter();
        registration.setFilter(filter);
        registration.addUrlPatterns("/web/*","/login","/index","/logout");
        registration.setName("cat-filter");
        registration.setOrder(1);
        return registration;
    }
}
