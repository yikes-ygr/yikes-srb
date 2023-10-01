package com.yikes.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yikes.pojo.entities.UserIntegral;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 用户积分记录表 Mapper 接口
 * </p>
 *
 * @author guanrong.yin
 * @since 2023-09-29
 */
@Mapper
public interface UserIntegralMapper extends BaseMapper<UserIntegral> {

}
