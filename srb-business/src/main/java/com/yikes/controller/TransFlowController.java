package com.yikes.controller;

import com.yikes.service.TransFlowService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 交易流水表 前端控制器
 * </p>
 *
 * @author guanrong.yin
 * @since 2023-09-29
 */
@Api(tags = "交易流水表")
@RestController
@RequestMapping("/trans_flow")
public class TransFlowController {
    
    @Resource
    private TransFlowService service;
    

}
