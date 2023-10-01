package com.yikes.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yikes.mapper.BorrowerMapper;
import com.yikes.pojo.entities.Borrower;
import com.yikes.service.BorrowerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 借款人 服务实现类
 * </p>
 *
 * @author guanrong.yin
 * @since 2023-09-29
 */
@Service
@RequiredArgsConstructor
public class BorrowerServiceImpl extends ServiceImpl<BorrowerMapper, Borrower> implements BorrowerService {

}
