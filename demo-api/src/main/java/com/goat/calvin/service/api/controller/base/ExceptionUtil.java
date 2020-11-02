package com.goat.calvin.service.api.controller.base;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * <p> 自定义错误的exceptionUtil <p/>
 * @author xiefei15
 * @version 1.0.0
 * @since 2020/9/21 14:34
 */
public class ExceptionUtil {
    public ExceptionUtil() {
    }

    public static void throwException(boolean flag, String code, String mes) {
        if (flag) {
            throw new BusinessException(mes, code);
        }
    }

    public static void throwException(boolean flag, String mes) {
        throwException(flag, "500", mes);
    }

    public static String getStackTrace(Throwable throwable) {
        String result = "";
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);

        try {
            throwable.printStackTrace(pw);
            result = sw.toString();
        } catch (Exception var8) {
        } finally {
            pw.close();
            sw.flush();
        }
        return result;
    }
}
