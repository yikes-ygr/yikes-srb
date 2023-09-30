package com.yikes.mapper;

import com.yikes.pojo.entities.Dict;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 数据字典 Mapper 接口
 * </p>
 *
 * @author guanrong.yin
 * @since 2023-09-29
 */
@Mapper
public interface DictMapper extends BaseMapper<Dict> {

}
