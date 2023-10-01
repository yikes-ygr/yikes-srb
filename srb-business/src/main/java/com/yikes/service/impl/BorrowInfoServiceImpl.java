package com.yikes.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yikes.mapper.BorrowInfoMapper;
import com.yikes.pojo.entities.BorrowInfo;
import com.yikes.service.BorrowInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 借款信息表 服务实现类
 * </p>
 *
 * @author guanrong.yin
 * @since 2023-09-29
 */
@Service
@RequiredArgsConstructor
public class BorrowInfoServiceImpl extends ServiceImpl<BorrowInfoMapper, BorrowInfo> implements BorrowInfoService {

}
