package com.yikes.base;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 基础分页请求对象
 */
@ApiModel
public class PageForm {

    @ApiModelProperty(value = "页码", example = "1")
    private Integer pageNum;

    @ApiModelProperty(value = "每页记录数", example = "10")
    private Integer pageSize;

    @ApiModelProperty("排序信息")
    private List<OrderItem> orderItems = new ArrayList<>();

    public Integer getPageNum() {

        if (pageNum ==  null || pageNum < 1) {
            pageNum = 1;
        }
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {

        if (pageSize == null || pageSize < 1) {
            pageSize = 10;
        }
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public List<OrderItem> getOrderItems() {

        orderItems.forEach(it -> {
            if (StringUtils.containsNone(it.getColumn(), StringPool.UNDERSCORE)) {
                it.setColumn(StrUtil.toUnderlineCase(it.getColumn()));
            }
        });
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    @Override
    public String toString() {
        return "PageForm{" +
                "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", orderItems=" + orderItems +
                '}';
    }
}
