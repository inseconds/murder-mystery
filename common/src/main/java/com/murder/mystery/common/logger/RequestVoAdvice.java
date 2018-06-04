package com.murder.mystery.common.logger;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.PropertyFilter;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdvice;

import java.lang.reflect.Type;
import java.util.*;

/**
 * Created by james on 2018/4/19.
 */
@ControllerAdvice
public class RequestVoAdvice implements RequestBodyAdvice {

    private static final String REQUEST_KEY_REQUEST_TIME = "request-time";
    public static final String REQUEST_KEY_BODY_PARAM = "body-param";

    @Override
    public boolean supports(MethodParameter methodParameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public Object handleEmptyBody(Object body, HttpInputMessage inputMessage, MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        return body;
    }

    @Override
    public HttpInputMessage beforeBodyRead(HttpInputMessage inputMessage, MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        return inputMessage;
    }

    @Override
    public Object afterBodyRead(Object body, HttpInputMessage inputMessage, MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        Map<String, Object> requestMap = new HashMap<>(16);
        requestMap.put(REQUEST_KEY_REQUEST_TIME, new Date());
        if (Objects.nonNull(parameter.getMethodAnnotation(IgnoreRequestLog.class))) {
            IgnoreRequestLog ignoreRequestLog = parameter.getMethodAnnotation(IgnoreRequestLog.class);
            requestMap.put(REQUEST_KEY_BODY_PARAM,
                    JSON.toJSONString(body, (PropertyFilter) (object, name, value) -> {
                        for (IgnoreFilter ignoreFilter : ignoreRequestLog.values()){
                            if(object.getClass().isAssignableFrom(ignoreFilter.clazz())){
                                return Collections.binarySearch(Arrays.asList(ignoreFilter.excludes()),name)<0;
                            }
                        }
                        return true;
                    }));

        }else{
            requestMap.put(REQUEST_KEY_BODY_PARAM, JSON.toJSONString(body));
        }

        Conts.requestValThreadLocal.set(requestMap);
        return body;
    }

}
