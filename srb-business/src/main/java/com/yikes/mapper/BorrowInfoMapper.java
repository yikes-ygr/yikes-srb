package com.yikes.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yikes.pojo.entities.BorrowInfo;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 借款信息表 Mapper 接口
 * </p>
 *
 * @author guanrong.yin
 * @since 2023-09-29
 */
@Mapper
public interface BorrowInfoMapper extends BaseMapper<BorrowInfo> {

}
