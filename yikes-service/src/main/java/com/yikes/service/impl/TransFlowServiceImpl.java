package com.yikes.service.impl;

import com.yikes.pojo.entities.TransFlow;
import com.yikes.mapper.TransFlowMapper;
import com.yikes.service.TransFlowService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 交易流水表 服务实现类
 * </p>
 *
 * @author guanrong.yin
 * @since 2023-09-29
 */
@Service
@RequiredArgsConstructor
public class TransFlowServiceImpl extends ServiceImpl<TransFlowMapper, TransFlow> implements TransFlowService {

}
