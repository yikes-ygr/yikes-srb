package com.yikes.controller.vo;

import com.yikes.base.BaseEntityVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * <pre>
 *
 * </pre>
 *
 * @author guanrong.yin
 * @date 2023/9/30 21:12
 */
@Data
@ToString
@ApiModel(value = "Dict对象", description = "数据字典")
public class DictVO extends BaseEntityVO implements Serializable {

    @ApiModelProperty("id")
    private Long id;

    @ApiModelProperty("上级id")
    private Long parentId;

    @ApiModelProperty("名称")
    private String name;

    @ApiModelProperty("值")
    private Integer value;

    @ApiModelProperty("编码")
    private String dictCode;
    
    private List<DictVO> children;
    
}
