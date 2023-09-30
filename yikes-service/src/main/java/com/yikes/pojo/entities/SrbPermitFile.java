package com.yikes.pojo.entities;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * yikes上传附件表
 * </p>
 *
 * @author guanrong.yin
 * @since 2023-09-29
 */
@Getter
@Setter
@TableName("srb_permit_file")
@ApiModel(value = "SrbPermitFile对象", description = "yikes上传附件表")
public class SrbPermitFile implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("PK")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("关联ID")
    @TableField("relation_id")
    private Long relationId;

    @ApiModelProperty("文件类型")
    @TableField("file_type")
    private String fileType;

    @ApiModelProperty("附件标签")
    @TableField("label_name")
    private String labelName;

    @ApiModelProperty("文件名称")
    @TableField("file_name")
    private String fileName;

    @ApiModelProperty("文件路径")
    @TableField("file_url")
    private String fileUrl;

    @ApiModelProperty("文件key")
    @TableField("file_key")
    private String fileKey;

    @ApiModelProperty("类型")
    @TableField("type")
    private String type;

    @ApiModelProperty("创建时间")
    @TableField("create_time")
    private Date createTime;

    @ApiModelProperty("修改时间")
    @TableField("update_time")
    private Date updateTime;

    @ApiModelProperty("逻辑删除")
    @TableField("is_deleted")
    private Boolean isDeleted;
}
