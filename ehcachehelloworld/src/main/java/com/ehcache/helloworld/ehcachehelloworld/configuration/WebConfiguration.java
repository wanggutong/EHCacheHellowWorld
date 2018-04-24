package com.ehcache.helloworld.ehcachehelloworld.configuration;

import org.apache.catalina.filters.RemoteIpFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.ehcache.helloworld.ehcachehelloworld.filter.EHCacheFilter;
import com.ehcache.helloworld.ehcachehelloworld.interceptor.EHCacheHelloWorldInterceptor;
import com.ehcache.helloworld.ehcachehelloworld.listener.EHCacheHelloWorldListener;
import com.ehcache.helloworld.ehcachehelloworld.servlet.EHCacheHelloWorldServlet;

@Configuration
public class WebConfiguration extends WebMvcConfigurerAdapter{
	@Autowired
    private EHCacheHelloWorldInterceptor ehCacheHelloWorldInterceptor;
	
	@Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(ehCacheHelloWorldInterceptor);
    }
	
	@Bean
	public RemoteIpFilter remoteIpFilter() {
		return new RemoteIpFilter();
	}

	@Bean
	public ServletListenerRegistrationBean<EHCacheHelloWorldListener> servletListenerRegistrationBean() {
		return new ServletListenerRegistrationBean<EHCacheHelloWorldListener>(new EHCacheHelloWorldListener());
	}

	@Bean
	public FilterRegistrationBean testFilterRegistration() {

		FilterRegistrationBean registration = new FilterRegistrationBean();
		registration.setFilter(new EHCacheFilter());
		registration.addUrlPatterns("/*");
		registration.addInitParameter("paramName", "paramValue");
		registration.setName("EHCacheFilter");
		registration.setOrder(1);
		return registration;
	}

	@Bean
	public HttpMessageConverters fastJsonHttpMessageConverters() {
		FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();

		FastJsonConfig fastJsonConfig = new FastJsonConfig();
		fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);

		fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);

		HttpMessageConverter<?> converter = fastJsonHttpMessageConverter;

		return new HttpMessageConverters(converter);

	}

	@Bean
	public ServletRegistrationBean servletRegistrationBean() {
		return new ServletRegistrationBean(new EHCacheHelloWorldServlet(), "/EHCacheHelloWorldServlet");
	}
	
	
}
