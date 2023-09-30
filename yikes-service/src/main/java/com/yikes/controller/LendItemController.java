package com.yikes.controller;

import com.yikes.service.LendItemService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 标的出借记录表 前端控制器
 * </p>
 *
 * @author guanrong.yin
 * @since 2023-09-29
 */
@Api(tags = "标的出借记录表")
@RestController
@RequestMapping("/lend_item")
public class LendItemController {
    
    @Resource
    private LendItemService service;
    

}
