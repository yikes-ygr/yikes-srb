package com.yikes.controller;

import com.yikes.service.UserBindService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 用户绑定表 前端控制器
 * </p>
 *
 * @author guanrong.yin
 * @since 2023-09-29
 */
@Api(tags = "用户绑定表")
@RestController
@RequestMapping("/user_bind")
public class UserBindController {
    
    @Resource
    private UserBindService service;
    

}
