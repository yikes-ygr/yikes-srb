package com.yikes.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yikes.pojo.entities.UserBind;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 用户绑定表 Mapper 接口
 * </p>
 *
 * @author guanrong.yin
 * @since 2023-09-29
 */
@Mapper
public interface UserBindMapper extends BaseMapper<UserBind> {

}
