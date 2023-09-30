package com.yikes.headler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * <pre>
 *  mybatis-plus 字段自动填充
 * </pre>
 *
 * @author guanrong.yin
 * @date 2023/9/9 0:24
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    /**
     * 新增填充创建时间
     * @param metaObject
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        
        this.strictInsertFill(metaObject, "createdTime", LocalDateTime::now, LocalDateTime.class);
        this.strictUpdateFill(metaObject, "updatedTime", LocalDateTime::now, LocalDateTime.class);
        
    }

    /**
     * 更新填充更新时间
     * @param metaObject
     */
    @Override
    public void updateFill(MetaObject metaObject) {

        this.strictUpdateFill(metaObject, "updatedTime", LocalDateTime::now, LocalDateTime.class);
    }
}
