package com.yikes.service.impl;

import com.yikes.pojo.entities.Lend;
import com.yikes.mapper.LendMapper;
import com.yikes.service.LendService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 标的准备表 服务实现类
 * </p>
 *
 * @author guanrong.yin
 * @since 2023-09-29
 */
@Service
@RequiredArgsConstructor
public class LendServiceImpl extends ServiceImpl<LendMapper, Lend> implements LendService {

}
