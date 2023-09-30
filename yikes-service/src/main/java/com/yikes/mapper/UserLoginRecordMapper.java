package com.yikes.mapper;

import com.yikes.pojo.entities.UserLoginRecord;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 用户登录记录表 Mapper 接口
 * </p>
 *
 * @author guanrong.yin
 * @since 2023-09-29
 */
@Mapper
public interface UserLoginRecordMapper extends BaseMapper<UserLoginRecord> {

}
