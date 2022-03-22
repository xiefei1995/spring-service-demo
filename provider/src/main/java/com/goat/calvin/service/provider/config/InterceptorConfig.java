/*
 * FileName: InterceptorConfig.java
 * Company: cy
 */
package com.goat.calvin.service.provider.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * <p> 拦截器配置类，自动注入到spring <p/>
 * @author xiefei15
 */

@Configuration
@Slf4j
public class InterceptorConfig implements WebMvcConfigurer {
    /** 指定不需要过滤的路径 */
    private final String[] notLoginInterceptPaths = {
            "/demo/student/save"
    };

    @Resource
    private Interceptor interceptor;

    @Component
    @Order(Ordered.HIGHEST_PRECEDENCE)
    public static class CorsFilter implements Filter {
        @Override
        public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
            HttpServletResponse response = (HttpServletResponse) res;
            HttpServletRequest request = (HttpServletRequest) req;
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE");
            response.setHeader("Access-Control-Allow-Headers", "token,Content-Type,X-Requested-With,accept,Origin,Access-Control-Request-Method,Access-Control-Request-Headers");
            response.setHeader("Access-Control-Max-Age", "3600");
            response.setHeader("Content-type", "text/html;charset=UTF-8");
            response.setCharacterEncoding("UTF-8");

            if (!"OPTIONS".equals(request.getMethod())) {
                chain.doFilter(req, res);
            }
        }

        @Override
        public void init(FilterConfig filterConfig) {
            log.info("************ interceptor init ************  ");
        }

        @Override
        public void destroy() {
            log.info("************ interceptor end ************  ");
        }
    }


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //registry.addResourceHandler("/**").addResourceLocations("classpath:/META-INF/resources/").setCachePeriod(0);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        /* 开启过滤器*/
        // registry.addInterceptor(interceptor).addPathPatterns("/**").excludePathPatterns(notLoginInterceptPaths);
    }

    /**
     *  web层统一处理Long转String问题
     * @param converters 需要转换的对象
     */
    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        MappingJackson2HttpMessageConverter jackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
        ObjectMapper objectMapper = jackson2HttpMessageConverter.getObjectMapper();

        SimpleModule simpleModule = new SimpleModule();
        //将Long转为string 解决id过大 js显示问题
        simpleModule.addSerializer(Long.class, ToStringSerializer.instance);
        simpleModule.addSerializer(Long.TYPE, ToStringSerializer.instance);
        objectMapper.registerModule(simpleModule);

        jackson2HttpMessageConverter.setObjectMapper(objectMapper);
        //放到第一个
        converters.add(0, jackson2HttpMessageConverter);
    }
}
