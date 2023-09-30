package com.yikes.controller;

import com.yikes.service.IntegralGradeService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 积分等级表 前端控制器
 * </p>
 *
 * @author guanrong.yin
 * @since 2023-09-29
 */
@Api(tags = "积分等级表")
@RestController
@RequestMapping("/integral_grade")
public class IntegralGradeController {
    
    @Resource
    private IntegralGradeService service;
    

}
