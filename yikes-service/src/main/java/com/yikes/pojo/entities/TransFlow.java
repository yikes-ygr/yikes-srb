package com.yikes.pojo.entities;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 交易流水表
 * </p>
 *
 * @author guanrong.yin
 * @since 2023-09-29
 */
@Getter
@Setter
@TableName("trans_flow")
@ApiModel(value = "TransFlow对象", description = "交易流水表")
public class TransFlow implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("编号")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("用户id")
    @TableField("user_id")
    private Long userId;

    @ApiModelProperty("用户名称")
    @TableField("user_name")
    private String userName;

    @ApiModelProperty("交易单号")
    @TableField("trans_no")
    private String transNo;

    @ApiModelProperty("交易类型（1：充值 2：提现 3：投标 4：投资回款 ...）")
    @TableField("trans_type")
    private Byte transType;

    @ApiModelProperty("交易类型名称")
    @TableField("trans_type_name")
    private String transTypeName;

    @ApiModelProperty("交易金额")
    @TableField("trans_amount")
    private BigDecimal transAmount;

    @ApiModelProperty("备注")
    @TableField("memo")
    private String memo;

    @ApiModelProperty("创建时间")
    @TableField("create_time")
    private Date createTime;

    @ApiModelProperty("更新时间")
    @TableField("update_time")
    private Date updateTime;

    @ApiModelProperty("逻辑删除(1:已删除，0:未删除)")
    @TableField("is_deleted")
    private Boolean isDeleted;
}
