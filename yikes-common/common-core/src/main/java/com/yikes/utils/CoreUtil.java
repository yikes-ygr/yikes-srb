package com.yikes.utils;

import cn.hutool.core.util.ClassUtil;
import com.yikes.enums.ResultCodeEnum;
import com.yikes.exception.CommonException;
import org.springframework.util.CollectionUtils;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * 工具类
 *
 * @author guanrong.yin
 * @since 2023-07-20
 */
public class CoreUtil {

    /** 下划线 */
    private static final char SEPARATOR = '_';

    /**
     * 获取泛型类类型
     * @param targetClazz   泛型类
     * @param index 泛型类下标
     */
    public static Class<?> getGenericClazz(Class<?> targetClazz, int index) {
        return ClassUtil.getTypeArgument(targetClazz, index);
    }

    public static <T> T newInstance(Class<T> targetClazz) {
        try {
            return targetClazz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        throw CommonException.build(ResultCodeEnum.SYSTEM_EXECUTION_ERROR);
    }

    /**
     * 获取泛型类 指定注解
     * @param targetClazz   目标类
     * @param index         目标类泛型下标
     * @param annotationClazz   注解类型
     */
    public static <A extends Annotation> A getAnnotationByClazz(Class<?> targetClazz, int index, Class<A> annotationClazz) {
        Class<?> target = getGenericClazz(targetClazz, index);
        if (target != null) {
            return target.getDeclaredAnnotation(annotationClazz);
        }
        return null;
    }


    /**
     * 递归树状列表
     * 1. 用法: 先从数据库查出DO对象列表，再通过 BeanConvert 转 VO对象，然后调用此方法成树状列表
     * 2. note: 实体类必须包含 子节点字段名、父节点字段名、子集数据列表
     * @param list          全量树状数据
     * @param predicate     断言参::用来断言第一层为父节点的表达式
     * @param idFunc        函数参::子节点字段名
     * @param pidFunc       函数参::父节点字段名
     * @param childFunc     接收参::子集数据列表 set
     */
    public static <T, R> List<T> toTree(List<T> list,
                                        Predicate<T> predicate,
                                        Function<T, R> idFunc,
                                        Function<T, R> pidFunc,
                                        BiConsumer<T, List<T>> childFunc) {
        List<T> firstList = list.stream().filter(predicate).collect(Collectors.toList());
        return toTree(list, firstList, idFunc, pidFunc, childFunc);
    }


    /**
     * 递归树状列表
     * @param list          全量树状数据
     * @param currentList   当前层级的数据
     * @param idFunc        函数参::子节点字段名
     * @param pidFunc       函数参::父节点字段名
     * @param childFunc     接收参::子集数据列表 set
     */
    private static <T, R> List<T> toTree(List<T> list,
                                        List<T> currentList,
                                        Function<T, R> idFunc,
                                        Function<T, R> pidFunc,
                                         BiConsumer<T, List<T>> childFunc) {
        for (T current : currentList) {
            List<T> nextList = list.stream().filter(it -> idFunc.apply(current).equals(pidFunc.apply(it)))
                    .collect(Collectors.toList());
            if (!CollectionUtils.isEmpty(nextList)) {
                toTree(list, nextList, idFunc, pidFunc, childFunc);
            }
            childFunc.accept(current, nextList);
        }
        return currentList;
    }


    /**
     * 将下划线大写方式命名的字符串转换为驼峰式。如果转换前的下划线大写方式命名的字符串为空，则返回空字符串。 例如：HELLO_WORLD->HelloWorld
     *
     * @param name 转换前的下划线大写方式命名的字符串
     * @return 转换后的驼峰式命名的字符串
     */
    public static String convertToCamelCase(String name)
    {
        StringBuilder result = new StringBuilder();
        // 快速检查
        if (name == null || name.isEmpty())
        {
            // 没必要转换
            return "";
        }
        else if (!name.contains("_"))
        {
            // 不含下划线，仅将首字母大写
            return name.substring(0, 1).toUpperCase() + name.substring(1);
        }
        // 用下划线将原始字符串分割
        String[] camels = name.split("_");
        for (String camel : camels)
        {
            // 跳过原始字符串中开头、结尾的下换线或双重下划线
            if (camel.isEmpty())
            {
                continue;
            }
            // 首字母大写
            result.append(camel.substring(0, 1).toUpperCase());
            result.append(camel.substring(1).toLowerCase());
        }
        return result.toString();
    }


    /**
     * 驼峰式命名法 例如：user_name->userName
     */
    public static String toCamelCase(String s)
    {
        if (s == null)
        {
            return null;
        }
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder(s.length());
        boolean upperCase = false;
        for (int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);

            if (c == SEPARATOR)
            {
                upperCase = true;
            }
            else if (upperCase)
            {
                sb.append(Character.toUpperCase(c));
                upperCase = false;
            }
            else
            {
                sb.append(c);
            }
        }
        return sb.toString();
    }


}
