package com.yikes.headler;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.springframework.stereotype.Component;

/**
 * <pre>
 *Long 数组类型转换 json
 * </pre>
 *
 * @author guanrong.yin
 * @date 2023/9/9 0:29
 */
@Slf4j
@Component
@MappedTypes(value = {Long[].class})
@MappedJdbcTypes(value = {JdbcType.OTHER}, includeNullJdbcType = true)
public class LongArrayJsonTypeHandler extends ArrayObjectJsonTypeHandler<Long> {
    public LongArrayJsonTypeHandler() {
        super(Long[].class);
    }
}
