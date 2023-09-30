package com.yikes.controller;

import com.yikes.service.UserAccountService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 用户账户 前端控制器
 * </p>
 *
 * @author guanrong.yin
 * @since 2023-09-29
 */
@Api(tags = "用户账户")
@RestController
@RequestMapping("/user_account")
public class UserAccountController {

    @Resource
    private UserAccountService service;
    
    
}
