package com.yikes.service;

import com.yikes.controller.vo.DictVO;
import com.yikes.pojo.entities.Dict;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 数据字典 服务类
 * </p>
 *
 * @author guanrong.yin
 * @since 2023-09-29
 */
public interface DictService extends IService<Dict> {

    /**
     * 三级列表
     */
    List<DictVO> getTree();
}
