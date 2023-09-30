package com.yikes.service.impl;

import com.yikes.pojo.entities.UserAccount;
import com.yikes.mapper.UserAccountMapper;
import com.yikes.service.UserAccountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户账户 服务实现类
 * </p>
 *
 * @author guanrong.yin
 * @since 2023-09-29
 */
@Service
@RequiredArgsConstructor
public class UserAccountServiceImpl extends ServiceImpl<UserAccountMapper, UserAccount> implements UserAccountService {

}
