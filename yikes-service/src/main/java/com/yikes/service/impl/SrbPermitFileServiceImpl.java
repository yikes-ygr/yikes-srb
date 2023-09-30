package com.yikes.service.impl;

import com.yikes.pojo.entities.SrbPermitFile;
import com.yikes.mapper.SrbPermitFileMapper;
import com.yikes.service.SrbPermitFileService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * <p>
 * yikes上传附件表 服务实现类
 * </p>
 *
 * @author guanrong.yin
 * @since 2023-09-29
 */
@Service
@RequiredArgsConstructor
public class SrbPermitFileServiceImpl extends ServiceImpl<SrbPermitFileMapper, SrbPermitFile> implements SrbPermitFileService {

}
