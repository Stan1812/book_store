package com.expr.bookstore.config;

import com.expr.bookstore.filter.JwtFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JwtConfig {
    @Bean
    public FilterRegistrationBean jwtFilter() {
        final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new JwtFilter());
        registrationBean.addUrlPatterns("/secure/*");
        registrationBean.addUrlPatterns("/book/*");
        registrationBean.addUrlPatterns("/category/*");
        registrationBean.addUrlPatterns("/order/*");
        registrationBean.addUrlPatterns("/shopping/*");
        return registrationBean;
    }

}