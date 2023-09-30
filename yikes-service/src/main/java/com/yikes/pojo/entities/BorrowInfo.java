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
 * 借款信息表
 * </p>
 *
 * @author guanrong.yin
 * @since 2023-09-29
 */
@Getter
@Setter
@TableName("borrow_info")
@ApiModel(value = "BorrowInfo对象", description = "借款信息表")
public class BorrowInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("编号")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("借款用户id")
    @TableField("user_id")
    private Long userId;

    @ApiModelProperty("借款金额")
    @TableField("amount")
    private BigDecimal amount;

    @ApiModelProperty("借款期限")
    @TableField("period")
    private Integer period;

    @ApiModelProperty("年化利率")
    @TableField("borrow_year_rate")
    private BigDecimal borrowYearRate;

    @ApiModelProperty("还款方式 1-等额本息 2-等额本金 3-每月还息一次还本 4-一次还本")
    @TableField("return_method")
    private Byte returnMethod;

    @ApiModelProperty("资金用途")
    @TableField("money_use")
    private Byte moneyUse;

    @ApiModelProperty("状态（0：未提交，1：审核中， 2：审核通过， -1：审核不通过）")
    @TableField("status")
    private Byte status;

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
