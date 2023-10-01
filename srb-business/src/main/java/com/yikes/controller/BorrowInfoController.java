package com.yikes.controller;

import com.yikes.service.BorrowInfoService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 借款信息表 前端控制器
 * </p>
 *
 * @author guanrong.yin
 * @since 2023-09-29
 */
@Api(tags = "借款信息表")
@RestController
@RequestMapping("/borrow_info")
public class BorrowInfoController {
    
    @Resource
    private BorrowInfoService service;
    

}
