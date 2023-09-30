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
 * 用户账户
 * </p>
 *
 * @author guanrong.yin
 * @since 2023-09-29
 */
@Getter
@Setter
@TableName("user_account")
@ApiModel(value = "UserAccount对象", description = "用户账户")
public class UserAccount implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("编号")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("用户id")
    @TableField("user_id")
    private Long userId;

    @ApiModelProperty("帐户可用余额")
    @TableField("amount")
    private BigDecimal amount;

    @ApiModelProperty("冻结金额")
    @TableField("freeze_amount")
    private BigDecimal freezeAmount;

    @ApiModelProperty("创建时间")
    @TableField("create_time")
    private Date createTime;

    @ApiModelProperty("更新时间")
    @TableField("update_time")
    private Date updateTime;

    @ApiModelProperty("逻辑删除(1:已删除，0:未删除)")
    @TableField("is_deleted")
    private Boolean isDeleted;

    @ApiModelProperty("版本号")
    @TableField("version")
    private Integer version;
}
