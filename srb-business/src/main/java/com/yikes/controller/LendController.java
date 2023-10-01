package com.yikes.controller;

import com.yikes.service.LendService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 标的准备表 前端控制器
 * </p>
 *
 * @author guanrong.yin
 * @since 2023-09-29
 */
@Api(tags = "标的准备表")
@RestController
@RequestMapping("/lend")
public class LendController {
    
    @Resource
    private LendService service;
    

}
