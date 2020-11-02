package com.goat.calvin.service.api.controller.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.core.annotation.Order;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * <p> web层controller的基类 <p/>
 * @author xiefei15
 * @version 1.0.0
 * @since 2020/9/16 15:33
 */

/**
 * 注解@Order或者接口Ordered的作用是定义Spring IOC容器中Bean的执行顺序的优先级，
 * 而不是定义Bean的加载顺序，Bean的加载顺序不受@Order或Ordered接口的影响；
 */
@Order(-1)
public class ControllerBase implements HandlerExceptionResolver {

    private static final Logger log = LoggerFactory.getLogger(ControllerBase.class);

    public ControllerBase() {
    }

    public <T> Result<T> createResult(boolean isSuccess, String mes, T data, String code) {
        return Result.createResult(true, mes, data, "200");
    }

    public <T> Result<T> successResult(String mes, T data) {
        return Result.createResult(true, mes, data, "200");
    }

    public <T> Result<T> successResult(String mes) {
        return (Result<T>) Result.createResult(true, mes, (Object)null, "200");
    }

    public <T> Result<T> successResult() {
        return this.successResult((String)null);
    }

    public <T> Result<T> successResult(T data) {
        return Result.createResult(true, "", data, "200");
    }

    public <T> Result<T> errorResult(String mes, T data) {
        return Result.createResult(false, mes, data, "500");
    }

    public <T> Result<T> errorResult() {
        return this.errorResult((String)null);
    }

    public <T> Result<T> errorResult(String mes) {
        return (Result<T>) Result.createResult(false, mes, (Object)null, "500");
    }

    public Result<String> errorResultForStringData(String data) {
        return Result.errorResultForStringData(data);
    }

    public Result<String> successResultForStringData(String data) {
        return Result.successResultForStringData(data);
    }

    public <T> Result<T> errorResult(T data) {
        return Result.createResult(false, "", data, "500");
    }

    public boolean isAjax(HttpServletRequest request) {
        return request.getHeader("x-requested-with") != null && request.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest");
    }

    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception ex) {
        ModelAndView mv = new ModelAndView();
        String message = null;
        String code = "500";
        Object data = null;
        if (ex != null) {
            message = ex.getMessage();
            if (StringUtils.isEmpty(message) && ex.getCause() != null) {
                message = ex.getCause().getMessage();
            }

            if (ex instanceof BusinessException) {
                code = ((BusinessException)ex).getErrorCode();
                data = ((BusinessException)ex).getData();
                log.info("BusinessException ,error detail:{}", message);
            } else if (ex instanceof MethodArgumentNotValidException) {
                MethodArgumentNotValidException methodArgumentNotValidException = (MethodArgumentNotValidException)ex;
                BindingResult bindingResult = methodArgumentNotValidException.getBindingResult();
                message = Optional.ofNullable(bindingResult.getFieldError()).map(DefaultMessageSourceResolvable::getDefaultMessage).orElse("数据校验错误");
                log.info("MethodArgumentNotValidException ,error detail:{}", message);
            } else {
                log.error("未知错误,错误类型：{},堆栈:{}", ex.toString(), ExceptionUtil.getStackTrace(ex));
            }
        } else {
            log.error("未知错误,ex 为null");
        }

        Map<String,Object> attributes = new HashMap<>();
        attributes.put("success", false);
        attributes.put("message", message);
        attributes.put("code", code);
        attributes.put("data", data);
        MappingJackson2JsonView jsonView = new MappingJackson2JsonView();
        jsonView.setAttributesMap(attributes);
        mv.setView(jsonView);
        return mv;
    }

}
