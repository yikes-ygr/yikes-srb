package com.yikes.service.impl;

import com.yikes.pojo.entities.LendItem;
import com.yikes.mapper.LendItemMapper;
import com.yikes.service.LendItemService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 标的出借记录表 服务实现类
 * </p>
 *
 * @author guanrong.yin
 * @since 2023-09-29
 */
@Service
@RequiredArgsConstructor
public class LendItemServiceImpl extends ServiceImpl<LendItemMapper, LendItem> implements LendItemService {

}
