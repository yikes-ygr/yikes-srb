package com.yikes.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * <pre>
 *     前端下拉框
 * </pre
 *
 * @Author: guanrong.yin
 * @CreateTime: 2023/9/9 19:14
 */
@Data
@ToString
@AllArgsConstructor
public class OptionListVO<T> {


    @ApiModelProperty("下拉框数据")
    private Collection<Node<T>> data;

    @ApiModelProperty("默认值")
    private T defaultValue;

    /**
     * @param list list集合
     * @param id   下拉框 value
     * @param name 下拉框显示值
     * @param <T>  泛型
     * @param <V>  泛型
     * @return OptionListVO
     */
    public static <T, V> OptionListVO<T> covert(Collection<V> list, Function<V, T> id, Function<V, String> name) {
        List<Node<T>> collect = list.stream().map(m -> new Node<T>(id.apply(m), name.apply(m))).collect(Collectors.toList());
        return new OptionListVO<>(collect, null);
    }

    /**
     * @param list list集合
     * @param id   下拉框 value
     * @param name 下拉框显示值
     * @param <T>  泛型
     * @param <V>  泛型
     * @return OptionListVO
     */
    public static <T, V> OptionListVO<T> covert(Collection<V> list, Function<V, T> id, Function<V, String> name, Function<V, ?> param2) {
        List<Node<T>> collect = list.stream().map(m -> new Node<T>(id.apply(m), name.apply(m), param2.apply(m))).collect(Collectors.toList());
        return new OptionListVO<>(collect, null);
    }

    /**
     * @param list list集合
     * @param id   下拉框 value
     * @param name 下拉框显示值
     * @param <T>  泛型
     * @param <V>  泛型
     * @return OptionListVO
     */
    public static <T, V> OptionListVO<T> covert(Collection<V> list, Function<V, T> id,
                                                Function<V, String> name,
                                                Function<V, ?> param2,
                                                Function<V, ?> param3) {
        List<Node<T>> collect = list.stream()
                .map(m -> new Node<T>(id.apply(m), name.apply(m), param2.apply(m), param3.apply(m)))
                .collect(Collectors.toList());
        return new OptionListVO<>(collect, null);
    }

    /**
     * @param list list集合
     * @param id   下拉框 value
     * @param name 下拉框显示值
     * @param <T>  泛型
     * @param <V>  泛型
     * @return OptionListVO
     */
    public static <T, V> OptionListVO<T> covert(Collection<V> list, Function<V, T> id,
                                                Function<V, String> name,
                                                Function<V, ?> param2,
                                                Function<V, ?> param3,
                                                Function<V, ?> param4) {
        List<Node<T>> collect = list.stream()
                .map(m -> new Node<T>(id.apply(m), name.apply(m), param2.apply(m), param3.apply(m), param4.apply(m)))
                .collect(Collectors.toList());
        return new OptionListVO<>(collect, null);
    }

    public static <T, V> OptionListVO<T> covert(Collection<V> list, Function<V, T> id,
                                                Function<V, String> name,
                                                Function<V, ?> param2,
                                                Function<V, ?> param3,
                                                Function<V, ?> param4,
                                                Function<V, ?> param5) {
        List<Node<T>> collect = list.stream()
                .map(m -> new Node<T>(id.apply(m), name.apply(m), param2.apply(m), param3.apply(m), param4.apply(m), param5.apply(m)))
                .collect(Collectors.toList());
        return new OptionListVO<>(collect, null);
    }


    /**
     * @param list         list集合
     * @param id           下拉框 value
     * @param name         下拉框显示值
     * @param defaultValue 默认值
     * @param <T>          泛型
     * @param <V>          泛型
     * @return OptionListVO
     */
    public static <T, V> OptionListVO<T> covert(T defaultValue, Collection<V> list, Function<V, T> id, Function<V, String> name) {
        List<Node<T>> collect = list.stream().map(m -> new Node<T>(id.apply(m), name.apply(m))).collect(Collectors.toList());
        return new OptionListVO<>(collect, defaultValue);
    }

    /**
     * @param list         list集合
     * @param id           下拉框 value
     * @param name         下拉框显示值
     * @param defaultValue 默认值
     * @param <T>          泛型
     * @param <V>          泛型
     * @return OptionListVO
     */
    public static <T, V> OptionListVO<T> covert(T defaultValue, Collection<V> list, Function<V, T> id, Function<V, String> name, Function<V, ?> param2) {
        List<Node<T>> collect = list.stream().map(m -> new Node<T>(id.apply(m), name.apply(m), param2.apply(m))).collect(Collectors.toList());
        return new OptionListVO<>(collect, defaultValue);
    }

    /**
     * @param map
     * @param <V> 泛型
     * @return OptionListVO
     */
    public static <V> OptionListVO<V> covert(Map<V, String> map) {
        return covert(map, null);
    }

    /**
     * @param map          map对象
     * @param defaultValue 默认值
     * @param <V>          泛型
     * @return OptionListVO
     */
    public static <V> OptionListVO<V> covert(Map<V, String> map, V defaultValue) {
        List<Node<V>> collect = map.entrySet().stream().map(m -> new Node<>(m.getKey(), m.getValue())).collect(Collectors.toList());
        return new OptionListVO<>(collect, defaultValue);
    }


    /**
     * 过滤
     *
     * @param fun
     */
    public void filter(Function<T, Boolean> fun) {

        data = data.stream().filter(m -> fun.apply(m.id)).collect(Collectors.toList());
    }


    @Data
    static class Node<T> {

        public Node(T id, String name) {
            this(id, name, null, null, null);
        }

        public Node(T id, String name, Object param2) {
            this(id, name, param2, null, null);
        }

        public Node(T id, String name, Object param2, Object param3) {
            this(id, name, param2, param3, null);
        }

        public Node(T id, String name, Object param2, Object param3, Object param4) {

            this.id = id;
            this.name = name;
            this.param2 = param2;
            this.param3 = param3;
            this.param4 = param4;

        }

        public Node(T id, String name, Object param2, Object param3, Object param4, Object param5) {

            this.id = id;
            this.name = name;
            this.param2 = param2;
            this.param3 = param3;
            this.param4 = param4;
            this.param5 = param5;

        }

        @ApiModelProperty("下拉框value值")
        private T id;

        @ApiModelProperty("下拉框显示值")
        private String name;

        @ApiModelProperty("额外参数2")
        private Object param2;
        @ApiModelProperty("额外参数2")
        private Object param3;
        @ApiModelProperty("额外参数4")
        private Object param4;

        @ApiModelProperty("额外参数5")
        private Object param5;
    }

}
