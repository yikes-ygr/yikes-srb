package com.yikes.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * <pre>
 *  下拉选项对象
 * </pre
 *
 * @Author: guanrong.yin
 * @CreateTime: 2023/9/9 18:46
 */
@ApiModel("下拉选项对象")
@Data
@NoArgsConstructor
public class Option<T> {

    public Option(T value, String label) {
        this.value = value;
        this.label = label;
    }

    public Option(T value, String label, List<Option> children) {
        this.value = value;
        this.label = label;
        this.children= children;
    }

    @ApiModelProperty("选项的值")
    private T value;

    @ApiModelProperty("选项的标签")
    private String label;

    @JsonInclude(value = JsonInclude.Include.NON_EMPTY)
    private List<Option> children;

}
