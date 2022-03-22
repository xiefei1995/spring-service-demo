package com.goat.calvin.service.provider.domain.controller;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * <p> 父类controller <p/>
 * @author xiefei15
 * @version 1.0.0
 * @since 2020/9/21 14:54
 */
public class BaseController{
    volatile int x = 1;
    /**
     * 获取当前请求的相关信息
     * @return ServletRequestAttributes
     */
    public HttpServletRequest getHttpServletRequest() {
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        assert sra != null;
        return sra.getRequest();
    }
}
