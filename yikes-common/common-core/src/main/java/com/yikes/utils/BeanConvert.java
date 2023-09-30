package com.yikes.utils;

import com.yikes.enums.ResultCodeEnum;
import com.yikes.exception.CommonException;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;


/**
 * 实体属性复制
 *
 * @author guanrong.yin
 * @since 2023-07-20
 */
public final class BeanConvert {


    /**
     * bean转换
     *
     * @param obj   源bean对象
     * @param clazz 目标 bean 的类型
     * @param <T>   泛型
     * @return 目标bean对象
     */
    public static <T> T toBean(@NotNull Object obj, @NotNull Class<T> clazz) {
        try {
            T bean = clazz.newInstance();
            // copyProperties 方法里的参数不能为null
            BeanUtils.copyProperties(obj, bean);
            return bean;
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
            throw CommonException.build(ResultCodeEnum.SYSTEM_EXECUTION_ERROR);
        }
    }


    /**
     * beanList转换
     *
     * @param list   源bean对象集
     * @param clazz 目标 bean的类型
     * @param <T>   泛型
     * @return 目标bean对象集
     */
    public static <T> List<T> toBeanList(@NotNull List<?> list, @NotNull Class<T> clazz) {
        return list.stream().map(it -> toBean(it, clazz)).collect(Collectors.toList());
    }

}
