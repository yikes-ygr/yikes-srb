package com.yikes.controller;

import com.yikes.service.UserIntegralService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 用户积分记录表 前端控制器
 * </p>
 *
 * @author guanrong.yin
 * @since 2023-09-29
 */
@Api(tags = "用户积分记录表")
@RestController
@RequestMapping("/user_integral")
public class UserIntegralController {

    @Resource
    private UserIntegralService service;
    
}
