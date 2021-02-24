package com.goat.calvin.service.domain.util;

import cn.hutool.core.util.StrUtil;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * 密码生成工具
 * @author xiefei15
 * @date 2020-11-18
 */
public class PasswordEncoderUtil {
    /**
     * 加密工具类
     */
    private final static BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    /**
     * 默认密码bmy123456
     */
    private static final String DEFAULT_PASSWORD = "1f4b806aec4e79d440cd1676b786cd2d";

    /**
     * 获取默认密码
     * @return  加密后密码
     */
    public static String buildPassword(String password) {
        return passwordEncoder.encode(StrUtil.isBlank(password) ? DEFAULT_PASSWORD : password);
    }

    /**
     * 验证密码正确性
     * @param rawPassword   待验证密码
     * @param encodedPassword   加密后密码
     * @return True 验证通过
     */
    public static boolean matches(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }

    public static void main(String[] args) {
        System.out.println(buildPassword(null));
    }
}
