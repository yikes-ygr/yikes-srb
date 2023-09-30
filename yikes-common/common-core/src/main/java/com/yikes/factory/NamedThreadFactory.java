package com.yikes.factory;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yikes.enums.ResultCodeEnum;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 自定义 ThreadFactory
 * <p>
 * 重命名线程池
 *
 * @author Administrator
 */
public class NamedThreadFactory implements ThreadFactory {

    private final AtomicInteger poolNumber = new AtomicInteger(1);

    private final ThreadGroup threadGroup;

    private final AtomicInteger threadNumber = new AtomicInteger(1);

    public final String namePrefix;

    public NamedThreadFactory(String name) {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            this.threadGroup = securityManager.getThreadGroup();
        } else {
            this.threadGroup = Thread.currentThread().getThreadGroup();
        }

        if (StrUtil.isBlank(name)) {
            name = "pool";
        }
        namePrefix = name + "-" + poolNumber.getAndIncrement() + "-thread-";
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(threadGroup, r,
                namePrefix + threadNumber.getAndIncrement(),
                0);
        if (t.isDaemon()) {
            t.setDaemon(false);
        }

        if (t.getPriority() != Thread.NORM_PRIORITY) {
            t.setPriority(Thread.NORM_PRIORITY);
        }
        return t;
    }

    /**
     * 分页响应结构体
     *
     */
    @Data
    public static class PageResult<T> implements Serializable {

        private Object code;

        private Data<T> data;

        private String msg;

        public static <T> PageResult<T> ok(IPage<T> page) {
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

    /**
     * 统一响应结构体
     *
     **/
    @Data
    public static class Result<T> implements Serializable {

        private Object code;

        private T data;

        private String msg;

        public static <T> Result<T> ok() {
            return ok(null);
        }

        public static <T> Result<T> ok(T data) {
            Result<T> result = new Result<>();
            result.setCode(ResultCodeEnum.OK.getCode());
            result.setMsg(ResultCodeEnum.OK.getMsg());
            result.setData(data);
            return result;
        }

        public static <T> Result<T> failed() {
            return result(ResultCodeEnum.SYSTEM_EXECUTION_ERROR.getCode(), ResultCodeEnum.SYSTEM_EXECUTION_ERROR.getMsg(), null);
        }

        public static <T> Result<T> failed(String msg) {
            return result(ResultCodeEnum.SYSTEM_EXECUTION_ERROR.getCode(), msg, null);
        }

        public static <T> Result<T> judge(boolean status) {
            if (status) {
                return ok();
            } else {
                return failed();
            }
        }

        public static <T> Result<T> failed(ExceptionEnumFactory resultCode) {
            return result(resultCode.getCode(), resultCode.getMsg(), null);
        }

        public static <T> Result<T> failed(ExceptionEnumFactory resultCode, String msg) {
            return result(resultCode.getCode(), msg, null);
        }

        private static <T> Result<T> result(ExceptionEnumFactory resultCode, T data) {
            return result(resultCode.getCode(), resultCode.getMsg(), data);
        }

        private static <T> Result<T> result(Object code, String msg, T data) {
            Result<T> result = new Result<>();
            result.setCode(code);
            result.setData(data);
            result.setMsg(msg);
            return result;
        }

        public static boolean isok(Result<?> result) {
            return result != null && ResultCodeEnum.OK.getCode().equals(result.getCode());
        }
    }
}
