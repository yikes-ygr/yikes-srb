package com.yikes.result;

import com.yikes.enums.ResultCodeEnum;
import com.yikes.factory.ExceptionEnumFactory;
import lombok.Data;

import java.io.Serializable;

/**
 * 统一响应结构体
 *
 **/
@Data
public class Result<T> implements Serializable {

    private Object code;

    private T data;

    private String msg;

    public static <T> Result<T> ok() {
        return ok(null);
    }

    public static <T> Result<T> ok(T data) {
        Result<T> result = new Result<>();
        result.setCode(ResultCodeEnum.OK.getCode());
        result.setMsg(ResultCodeEnum.OK.getMsg());
        result.setData(data);
        return result;
    }

    public static <T> Result<T> fail() {
        return result(ResultCodeEnum.SYSTEM_EXECUTION_ERROR.getCode(), ResultCodeEnum.SYSTEM_EXECUTION_ERROR.getMsg(), null);
    }

    public static <T> Result<T> fail(String msg) {
        return result(ResultCodeEnum.SYSTEM_EXECUTION_ERROR.getCode(), msg, null);
    }

    public static <T> Result<T> judge(boolean status) {
        if (status) {
            return ok();
        } else {
            return fail();
        }
    }

    public static <T> Result<T> fail(ExceptionEnumFactory resultCode) {
        return result(resultCode.getCode(), resultCode.getMsg(), null);
    }

    public static <T> Result<T> fail(ExceptionEnumFactory resultCode, String msg) {
        return result(resultCode.getCode(), msg, null);
    }


    public static <T> Result<T> fail(Object code, String msg) {
        return result(code, msg, null);
    }

    private static <T> Result<T> result(ExceptionEnumFactory resultCode, T data) {
        return result(resultCode.getCode(), resultCode.getMsg(), data);
    }

    private static <T> Result<T> result(Object code, String msg, T data) {
        Result<T> result = new Result<>();
        result.setCode(code);
        result.setData(data);
        result.setMsg(msg);
        return result;
    }

    public static boolean isok(Result<?> result) {
        return result != null && ResultCodeEnum.OK.getCode().equals(result.getCode());
    }
}
