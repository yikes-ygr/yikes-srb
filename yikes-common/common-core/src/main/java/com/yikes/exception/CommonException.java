package com.yikes.exception;

import cn.hutool.core.util.ObjectUtil;
import com.yikes.factory.ExceptionEnumFactory;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * <pre>
 *
 * </pre>
 *
 * @author guanrong.yin
 * @date 2023/7/19 22:20
 */
@Getter
@AllArgsConstructor
public class CommonException extends RuntimeException {

    private final ExceptionEnumFactory resultCode;

    public static CommonException build(ExceptionEnumFactory resultCode) {

        return new CommonException(resultCode);
    }

    /**
     * 自定义异常描述
     * @param resultCode   异常枚举类
     * @param obj          描述信息
     */
    public static CommonException build(ExceptionEnumFactory resultCode, Object obj) {

        ExceptionEnumFactory factory = new ExceptionEnumFactory() {
            @Override
            public Object getCode() {
                return resultCode.getCode();
            }

            @Override
            public String getMsg() {
                return (ObjectUtil.isNotNull(obj)) ? String.format(resultCode.getMsg(), obj) : resultCode.getMsg();
            }
        };

        return new CommonException(factory);
    }

    /**
     * 自定义异常描述
     * @param code   异常枚举类
     * @param msg    描述信息
     */
    public static CommonException build(String code, String msg) {
        ExceptionEnumFactory factory = new ExceptionEnumFactory() {
            @Override
            public String getCode() {
                return code;
            }

            @Override
            public String getMsg() {
                return msg;
            }


        };
        return new CommonException(factory);
    }

}
