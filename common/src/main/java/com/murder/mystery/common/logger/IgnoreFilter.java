package com.murder.mystery.common.logger;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * 对日志进行过滤
 *
 *
 * @author 李伟超
 * @email liweichoa0102@gmail.com
 * @date 2018/05/09
 */
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.ANNOTATION_TYPE})
public @interface IgnoreFilter {

    Class<?> clazz();

    String[] excludes() default {};
}
