package com.yikes.controller;

import com.yikes.service.LendReturnService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 还款记录表 前端控制器
 * </p>
 *
 * @author guanrong.yin
 * @since 2023-09-29
 */
@Api(tags = "还款记录表")
@RestController
@RequestMapping("/lend_return")
public class LendReturnController {
    
    @Resource
    private LendReturnService service;
    

}
