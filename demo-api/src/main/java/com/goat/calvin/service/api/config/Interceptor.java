package com.goat.calvin.service.api.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;



/**
 * @author xiefei15
 */
@Component
@Slf4j
public class Interceptor implements HandlerInterceptor {

//    /**
//     *  appId
//     */
//    private static final String appId = "software_app_id";
//
//    private static final String HTTP_HEADER_NAME = "token";
//
//    /**  自定义参数   */
//    private static final String LOGIN_NAME = "loginName";
//    private static final String REAL_NAME = "realName";
//    private static final String USER_ID = "userId";
//
//    /**
//     * 登录用户信息
//     */
//    private ThreadLocal<UserInfoRes> tokenInfo = new ThreadLocal<>();
//
//    @Resource
//    protected HttpServletRequest request;
//
//    @Resource
//    private BaseController baseController;
//
//    /**
//     * 获取登录用户
//     * @return  UserInfoRes
//     */
//    public synchronized UserInfoRes getLoginUserSimpleInfo() {
//        return this.tokenInfo.get();
//    }
//
//    /**
//     * 获取用户登录账号
//     * @return String
//     */
//    private String getLoginName() {
//        return request.getParameter(LOGIN_NAME);
//    }
//
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        String token = getToken();
//        System.out.println(token);
//        if (request.getRequestURI().contains("swagger") || request.getRequestURI().contains("webServer")) {
//            return true;
//        }
//
//        if (StringUtils.isEmpty(token)) {
//            return loginFailed(response);
//        }
//
//        /* 解析并验证token */
//        Result<UserInfoRes> validate = baseController.analysisToken(token,appId);
//        if (validate.getData() == null || validate.getData().getValid() == null || !validate.getData().getValid()) {
//            return loginFailed(response);
//        }else{
//            this.tokenInfo.set(validate.getData());
//            /*  验证后将需要的信息存放到request里面 */
//            log.info("--------------存入用户信息--------------");
//            request.setAttribute(LOGIN_NAME,validate.getData().getLoginName());
//            request.setAttribute(REAL_NAME,validate.getData().getRealName());
//            request.setAttribute(USER_ID,validate.getData().getUserId());
//            log.info("-------------token检验完成-----------------");
//            initByRequest();
//        }
//        return true;
//    }
//
//    private boolean loginFailed(HttpServletResponse response) throws IOException {
//        Result<Object> result = Result.successResult();
//        result.setMessage("登录过期，请重新登录");
//        result.setCode("1003");
//        PrintWriter pw = response.getWriter();
//        pw.write(anyObjToJson(result));
//        pw.flush();
//        pw.close();
//        return false;
//    }
//
//    private void initByRequest() {
//        log.info("--------init---------");
//    }
//
//
//    public String getToken() {
//        return request.getHeader(HTTP_HEADER_NAME);
//    }
//
//    @Override
//    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
//                           Object object, ModelAndView modelAndView){
//
//    }
//
//    @Override
//    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
//                                Object object, Exception exception){
//
//    }
//
//    public <T> String anyObjToJson(T t) {
//        String json = null;
//        try {
//            json = toJSONString(t);
//        }catch (Exception e){
//            log.error("obj序列化json失败：{}", e.getMessage());
//        }
//        return json;
//    }
}
