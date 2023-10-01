package com.yikes.controller;

import com.yikes.service.UserInfoService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 用户基本信息 前端控制器
 * </p>
 *
 * @author guanrong.yin
 * @since 2023-09-29
 */
@Api(tags = "用户基本信息")
@RestController
@RequestMapping("/user_info")
public class UserInfoController {

    @Resource
    private UserInfoService service;
    
    
}
