package com.yikes.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yikes.pojo.entities.Borrower;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 借款人 Mapper 接口
 * </p>
 *
 * @author guanrong.yin
 * @since 2023-09-29
 */
@Mapper
public interface BorrowerMapper extends BaseMapper<Borrower> {

}
