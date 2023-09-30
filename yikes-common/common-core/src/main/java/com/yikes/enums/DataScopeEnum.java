package com.yikes.enums;


import lombok.Getter;

/**
 * <pre>
 *
 * </pre>
 *
 * @author guanrong.yin
 * @date 2023/9/28 21:22
 */
public enum DataScopeEnum implements IBaseEnum<Integer> {

    /**
     * value 越小，数据权限范围越大
     */
    ALL(0, "所有数据"),
    DEPT_AND_SUB(1, "部门及子部门数据"),
    DEPT(2, "本部门数据"),
    SELF(3, "本人数据");

    @Getter
    private Integer value;

    @Getter
    private String label;

    DataScopeEnum(Integer value, String label) {
        this.value = value;
        this.label = label;
    }
    
}
