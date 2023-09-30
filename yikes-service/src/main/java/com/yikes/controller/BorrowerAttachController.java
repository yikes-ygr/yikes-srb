package com.yikes.controller;

import com.yikes.service.BorrowerAttachService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 借款人上传资源表 前端控制器
 * </p>
 *
 * @author guanrong.yin
 * @since 2023-09-29
 */
@Api(tags = "借款人上传资源表")
@RestController
@RequestMapping("/borrower_attach")
public class BorrowerAttachController {

    @Resource
    private BorrowerAttachService service;
    
}
