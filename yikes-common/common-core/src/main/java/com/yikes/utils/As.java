package com.yikes.utils;

import cn.hutool.core.collection.CollUtil;
import com.yikes.exception.CommonException;
import com.yikes.factory.ExceptionEnumFactory;
import org.apache.commons.lang3.StringUtils;

import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.Objects;
import java.util.function.Supplier;

/**
 * 断言工具类
 *
 * @author guanrong.yin
 * @since 2023-07-18
 */
public class As {
    private As() {
    }

    /**
     * 断言对象不能为空
     *
     * @param obj 对象
     * @param ex  自定义异常
     */
    public static void isNotNull(Object obj, CommonException ex) {
        if (Objects.isNull(obj)) {
            throw ex;
        }
    }

    /**
     * 断言对象不能为空
     *
     * @param obj 对象
     * @param ef  异常输出对象
     */
    public static void isNotNull(Object obj, ExceptionEnumFactory ef) {
        if (Objects.isNull(obj)) {
            throw CommonException.build(ef);
        }
    }

    /**
     * 断言对象不能为空
     *
     * @param obj 对象
     * @param ef  异常输出对象
     */
    public static void isNotNull(Object obj, ExceptionEnumFactory ef, Object param1) {
        if (Objects.isNull(obj)) {
            throw CommonException.build(ef, param1);
        }
    }


    /**
     * 断言对象为空
     *
     * @param obj 对象
     * @param ex  自定义异常
     */
    public static void isNull(Object obj, CommonException ex) {
        if (Objects.nonNull(obj)) {
            throw ex;
        }
    }

    /**
     * 断言对象为空
     *
     * @param obj 对象
     * @param ef  自定义异常
     */
    public static void isNull(Object obj, ExceptionEnumFactory ef) {
        if (Objects.nonNull(obj)) {
            throw CommonException.build(ef);
        }
    }

    /**
     * 断言对象为空
     *
     * @param obj 对象
     * @param ef  自定义异常
     * @param o1 格外参数
     */
    public static void isNull(Object obj, ExceptionEnumFactory ef, Object o1) {
        if (Objects.nonNull(obj)) {
            throw CommonException.build(ef, o1);
        }
    }

    /**
     * 断言字符串不能为空或者空字符串
     *
     * @param str 字符串
     * @param ex  自定义异常
     */
    public static void isNotBlank(String str, CommonException ex) {
        if (StringUtils.isBlank(str)) {
            throw ex;
        }
    }

    /**
     * 断言字符串不能为空或者空字符串
     *
     * @param str 字符串
     * @param ef  自定义异常
     */
    public static void isNotBlank(String str, ExceptionEnumFactory ef) {
        if (StringUtils.isBlank(str)) {
            throw CommonException.build(ef);
        }
    }

    /**
     * 断言结果为true
     *
     * @param flag flag
     * @param ex   自定义异常
     */
    public static void isTure(boolean flag, CommonException ex) {
        if (Objects.equals(Boolean.FALSE, flag)) {
            throw ex;
        }
    }

    /**
     * 断言结果为true
     *
     * @param flag flag
     * @param ef   自定义异常
     */
    public static void isTure(boolean flag, ExceptionEnumFactory ef) {
        if (Objects.equals(Boolean.FALSE, flag)) {
            throw CommonException.build(ef);
        }
    }

    /**
     * 断言结果为true
     *
     * @param flag flag
     * @param ef   自定义异常
     */
    public static <T> void isTure(boolean flag, ExceptionEnumFactory ef, @NotNull T t) {
        if (Objects.equals(Boolean.FALSE, flag)) {
            throw CommonException.build(ef, t);
        }
    }

    /**
     * 断言结果为true
     *
     * @param flag flag
     * @param ef   自定义异常
     */
    public static void isTure(boolean flag, ExceptionEnumFactory ef, @NotNull Supplier<?> supplier) {
        if (Objects.equals(Boolean.FALSE, flag)) {
            throw CommonException.build(ef, supplier.get());
        }
    }


    /**
     * 断言两个对象相对
     *
     * @param obj1
     * @param obj2
     * @param ex
     */
    public static void isEq(Object obj1, Object obj2, CommonException ex) {
        if (!Objects.equals(obj1, obj2)) {
            throw ex;
        }

    }

    /**
     * 断言两个对象相对
     *
     * @param obj1
     * @param obj2
     * @param ef
     */
    public static void isEq(Object obj1, Object obj2, ExceptionEnumFactory ef) {
        if (!Objects.equals(obj1, obj2)) {
            throw CommonException.build(ef);
        }

    }

    /**
     * 断言集合为空
     */
    public static <T> void isEmpty(Collection<T> list, CommonException ex) {
        if (!CollUtil.isEmpty(list)) {
            throw ex;
        }
    }

    /**
     * 断言集合为空
     */
    public static <T> void isEmpty(Collection<T> list, ExceptionEnumFactory ef) {
        if (!CollUtil.isEmpty(list)) {
            throw CommonException.build(ef);
        }
    }

    /**
     * 断言集合不为空
     */
    public static <T> void isNotEmpty(Collection<T> list, CommonException ex) {
        if (CollUtil.isEmpty(list)) {
            throw ex;
        }
    }

    /**
     * 断言集合不为空
     */
    public static <T> void isNotEmpty(Collection<T> list, ExceptionEnumFactory ef) {
        if (CollUtil.isEmpty(list)) {
            throw CommonException.build(ef);
        }
    }

    /**
     * 直接抛出错误
     *
     * @param ef
     */
    public static void throwEx(ExceptionEnumFactory ef) {
        throw CommonException.build(ef);
    }
}
