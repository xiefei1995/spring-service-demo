package com.goat.calvin.service.api.controller.base;

/**
 * <p> web层封装统一返回实体Result <p/>
 * @author xiefei15
 * @version 1.0.0
 * @since 2020/9/21 11:58
 */
public class Result<T> {
    private boolean success;
    private String message;
    private String code;
    private T data;

    public static <T> Result<T> createResult(boolean isSuccess, String mes, T data, String code) {
        Result<T> result = new Result<>();
        if (mes != null && !mes.isEmpty()) {
            result.setMessage(mes);
        }
        if (data != null) {
            result.setData(data);
        }

        result.setSuccess(isSuccess);
        result.setCode(code);
        return result;
    }

    /** Object由于它是所有类的父类，所以会强制类型转换，而T从一开始在编码时（注意是在写代码时）就限定了某种具体类型，所以它不用强制类型转换 */

    public static <T> Result<T> successResult(String mes) {
        return (Result<T>) createResult(true, mes, (Object)null, "200");
    }

    public static <T> Result<T> successResult(String mes, T data) {
        return createResult(true, mes, data, "200");
    }

    public static Result<String> successResultForStringData(String data) {
        return createResult(true, (String)null, data, "200");
    }

    public static <T> Result<T> successResult() {
        return successResult((String)null);
    }

    public static <T> Result<T> successResult(T data) {
        return createResult(true, "", data, "200");
    }

    public static <T> Result<T> errorResult(String mes, T data) {
        return createResult(false, mes, data, "500");
    }

    public static Result<String> errorResultForStringData(String data) {
        return createResult(true, (String)null, data, "500");
    }

    public static <T> Result<T> errorResult() {
        return errorResult((String)null);
    }

    public static <T> Result<T> errorResult(String mes) {
        return (Result<T>) createResult(false, mes, (Object)null, "500");
    }

    public static <T> Result<T> errorResult(T data) {
        return createResult(false, "", data, "500");
    }

    public Result<T> failFast(){
        return this.failFast(this.code, this.message);
    }

    public Result<T> failFastWithCode(String code){
        return this.failFast(code, this.message);
    }

    public Result<T> failFastWithMessage(String mes){
        return this.failFast(this.code, mes);
    }

    public Result<T> failFast(String code, String msg){
        if (!this.success) {
            throw new BusinessException(code,msg);
        } else {
            return this;
        }
    }

    public Result() {
    }

    public boolean isSuccess() {
        return this.success;
    }

    public String getMessage() {
        return this.message;
    }

    public String getCode() {
        return this.code;
    }

    public T getData() {
        return this.data;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof Result)) {
            return false;
        } else {
            Result<T> other = (Result)o;
            if (!other.canEqual(this)) {
                return false;
            } else if (this.isSuccess() != other.isSuccess()) {
                return false;
            } else {
                label49: {
                    String this$message = this.getMessage();
                    String other$message = other.getMessage();
                    if (this$message == null) {
                        if (other$message == null) {
                            break label49;
                        }
                    } else if (this$message.equals(other$message)) {
                        break label49;
                    }
                    return false;
                }

                String this$code = this.getCode();
                String other$code = other.getCode();
                if (this$code == null) {
                    if (other$code != null) {
                        return false;
                    }
                } else if (!this$code.equals(other$code)) {
                    return false;
                }

                T this$data = this.getData();
                Object other$data = other.getData();
                if (this$data == null) {
                    if (other$data != null) {
                        return false;
                    }
                } else if (!this$data.equals(other$data)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(Result<T> other) {
        return other instanceof Result;
    }

    public int hashCode() {
        int result = 1;
//      boolean PRIME = true;
        result = result * 59 + (this.isSuccess() ? 79 : 97);
        String $message = this.getMessage();
        result = result * 59 + ($message == null ? 43 : $message.hashCode());
        String $code = this.getCode();
        result = result * 59 + ($code == null ? 43 : $code.hashCode());
        T $data = this.getData();
        result = result * 59 + ($data == null ? 43 : $data.hashCode());
        return result;
    }

    public String toString() {
        return "Result(success=" + this.isSuccess() + ", message=" + this.getMessage() + ", code=" + this.getCode() + ", data=" + this.getData() + ")";
    }
}
