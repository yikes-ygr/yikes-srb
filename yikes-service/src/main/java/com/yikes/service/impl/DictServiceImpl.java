package com.yikes.service.impl;

import com.yikes.controller.vo.DictVO;
import com.yikes.pojo.entities.Dict;
import com.yikes.mapper.DictMapper;
import com.yikes.service.DictService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yikes.utils.BeanConvert;
import com.yikes.utils.CoreUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 数据字典 服务实现类
 * </p>
 *
 * @author guanrong.yin
 * @since 2023-09-29
 */
@Service
@RequiredArgsConstructor
public class DictServiceImpl extends ServiceImpl<DictMapper, Dict> implements DictService {

    
    @Override
    public List<DictVO> getTree() {

        List<Dict> list = this.list();

        List<DictVO> dictVOS = BeanConvert.toBeanList(list, DictVO.class);

        List<DictVO> toTree = CoreUtil.toTree(dictVOS, 
                it -> it.getParentId() == 0, 
                DictVO::getId, 
                DictVO::getParentId, 
                DictVO::setChildren);
        
        return toTree;
    }
}
