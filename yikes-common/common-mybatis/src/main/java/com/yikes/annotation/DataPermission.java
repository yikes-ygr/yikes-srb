package com.yikes.annotation;

import java.lang.annotation.*;

/**
 * <pre>
 *   MP数据权限注解
 *
 *   https://gitee.com/baomidou/mybatis-plus/issues
 *
 * </pre>
 *
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface DataPermission {

    /**
     * 数据权限 {@link com.baomidou.mybatisplus.extension.plugins.inner.DataPermissionInterceptor}
     */
    String deptAlias() default "";

    String orgIdColumnName() default "org_id";

    String userAlias() default "";

    String userIdColumnName() default "created_user";


}
