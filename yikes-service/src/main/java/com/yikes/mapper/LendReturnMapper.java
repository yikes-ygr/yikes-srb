package com.yikes.mapper;

import com.yikes.pojo.entities.LendReturn;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 还款记录表 Mapper 接口
 * </p>
 *
 * @author guanrong.yin
 * @since 2023-09-29
 */
@Mapper
public interface LendReturnMapper extends BaseMapper<LendReturn> {

}
