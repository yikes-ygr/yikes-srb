package com.yikes.controller;

import com.yikes.controller.vo.DictVO;
import com.yikes.result.Result;
import com.yikes.service.DictService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 数据字典 前端控制器
 * </p>
 *
 * @author guanrong.yin
 * @since 2023-09-29
 */
@Api(tags = "数据字典")
@RestController
@RequestMapping("/dict")
public class DictController {

    @Resource
    private DictService service;
    
    @ApiOperation("三级列表")
    @GetMapping("/getTree")
    public Result<List<DictVO>> getTree() {
        
        return Result.ok(service.getTree());
    }
}
