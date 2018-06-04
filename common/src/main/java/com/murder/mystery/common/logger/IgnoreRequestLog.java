package com.murder.mystery.common.logger;

import java.lang.annotation.*;

/**
 *
 * 过滤规则详情请参看 IgnoreFilter
 *
 * @author 李伟超
 * @email liweichoa0102@gmail.com
 * @date 2018/05/09
 */

@Documented
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface IgnoreRequestLog {

    IgnoreFilter[] values();

}
