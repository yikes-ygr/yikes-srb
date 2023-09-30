package com.yikes.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * <pre>
 *  Canal 消息对象
 * </pre
 *
 * @Author: guanrong.yin
 * @CreateTime: 2023/9/9 18:51
 */
@NoArgsConstructor
@Data
public class CanalMessage<T> {

    private String type;

    private String table;

    private List<T> data;

    private String database;

    private Long es;

    private Integer id;

    private Boolean isDdl;

    private List<T> old;

    private List<String> pkNames;

    private String sql;

    private Long ts;

}
