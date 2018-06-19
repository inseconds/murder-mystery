package com.murder.mystery.service.server.logger;

import java.util.Map;

/**
 * Created by james on 2018/4/19.
 */
public class Conts {

    public static final ThreadLocal<Map<String, Object>> requestValThreadLocal = new ThreadLocal<>();

}
