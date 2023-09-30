package com.yikes.result;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yikes.enums.ResultCodeEnum;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 分页响应结构体
 *
 */
@Data
public class PageResult<T> implements Serializable {

    private Object code;

    private Data<T> data;

    private String msg;

    public static <T> PageResult<T> success(IPage<T> page) {
        PageResult<T> result = new PageResult<>();
        result.setCode(ResultCodeEnum.OK.getCode());

        Data data = new Data<T>();
        data.setList(page.getRecords());
        data.setTotal(page.getTotal());

        result.setData(data);
        result.setMsg(ResultCodeEnum.OK.getMsg());
        return result;
    }

    @lombok.Data
    public static class Data<T> {

        private List<T> list;

        private long total;

    }

}
