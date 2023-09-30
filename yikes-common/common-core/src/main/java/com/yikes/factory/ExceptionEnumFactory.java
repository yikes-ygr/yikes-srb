package com.yikes.factory;

/**
 * 异常枚举类工厂接口
 *
 * @author guanrong.yin
 */
public interface ExceptionEnumFactory {

    /**
     * 异常code
     * @return
     */
    Object getCode();

    /**
     * 异常描述
     * @return
     */
    String getMsg();

}
