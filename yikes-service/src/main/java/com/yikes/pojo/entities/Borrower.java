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
 * 借款人
 * </p>
 *
 * @author guanrong.yin
 * @since 2023-09-29
 */
@Getter
@Setter
@TableName("borrower")
@ApiModel(value = "Borrower对象", description = "借款人")
public class Borrower implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("编号")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("用户id")
    @TableField("user_id")
    private Long userId;

    @ApiModelProperty("姓名")
    @TableField("name")
    private String name;

    @ApiModelProperty("身份证号")
    @TableField("id_card")
    private String idCard;

    @ApiModelProperty("手机")
    @TableField("mobile")
    private String mobile;

    @ApiModelProperty("性别（1：男 0：女）")
    @TableField("sex")
    private Byte sex;

    @ApiModelProperty("年龄")
    @TableField("age")
    private Byte age;

    @ApiModelProperty("学历")
    @TableField("education")
    private Byte education;

    @ApiModelProperty("是否结婚（1：是 0：否）")
    @TableField("is_marry")
    private Boolean isMarry;

    @ApiModelProperty("行业")
    @TableField("industry")
    private Byte industry;

    @ApiModelProperty("月收入")
    @TableField("income")
    private Byte income;

    @ApiModelProperty("还款来源")
    @TableField("return_source")
    private Byte returnSource;

    @ApiModelProperty("联系人名称")
    @TableField("contacts_name")
    private String contactsName;

    @ApiModelProperty("联系人手机")
    @TableField("contacts_mobile")
    private String contactsMobile;

    @ApiModelProperty("联系人关系")
    @TableField("contacts_relation")
    private Byte contactsRelation;

    @ApiModelProperty("状态（0：未认证，1：认证中， 2：认证通过， -1：认证失败）")
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
