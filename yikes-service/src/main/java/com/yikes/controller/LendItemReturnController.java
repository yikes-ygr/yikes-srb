package com.yikes.controller;

import com.yikes.service.LendItemReturnService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 标的出借回款记录表 前端控制器
 * </p>
 *
 * @author guanrong.yin
 * @since 2023-09-29
 */
@Api(tags = "标的出借回款记录表")
@RestController
@RequestMapping("/lend_item_return")
public class LendItemReturnController {
    
    @Resource
    private LendItemReturnService service;
    

}
