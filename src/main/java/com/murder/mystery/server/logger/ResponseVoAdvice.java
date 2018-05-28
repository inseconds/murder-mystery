package com.murder.mystery.server.logger;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by james on 2018/4/18.
 */
@ControllerAdvice
public class ResponseVoAdvice implements ResponseBodyAdvice<Object> {

    private static final Logger logger = LoggerFactory.getLogger(ResponseVoAdvice.class);

    private static final String REQUEST_PREFIX = "> ";
    private static final String KEY_VALUE_SEPERATOR = ": ";
    private static final String RESPONSE_PREFIX = "< ";

    //request 记录的key
    private static final String REQUEST_KEY_REQUEST_TIME = "request-time";
    private static final String REQUEST_KEY_URL = "url";
    private static final String REQUEST_KEY_HTTP_METHOD = "http-method";
    private static final String REQUEST_KEY_CONTENT_TYPE = "content-type";
    private static final String REQUEST_KEY_CONTENT_LENGTH = "content-length";
    private static final String REQUEST_KEY_HOST = "host";
    private static final String REQUEST_KEY_USER_AGENT = "user-agent";
    private static final String REQUEST_KEY_X_FORWARDED_FOR = "x-forwarded-for";
    private static final String REQUEST_KEY_EXTRA_PARAM = "extra-param";
    private static final String REQUEST_KEY_BODY_PARAM = "body-param";

    //response 记录的key
    private static final String RESPONSE_KEY_RESPONSE_TIME = "response-time";
    private static final String RESPONSE_KEY_HTTP_CODE = "http-code";
    private static final String RESPONSE_KEY_CONTENT_TYPE = "content-type";
    private static final String RESPONSE_KEY_TAKE_TIME = "take-time";
    private static final String RESPONSE_KEY_RESPONSE_DATA = "response-data";

    //extra_param对应的内部key
    private static final String REQUEST_KEY_EXTRA_PARAM_USER_ID = "userid";
    private static final String REQUEST_KEY_EXTRA_PARAM_ACCESS_TOKEN = "access-token";

    private static final List<String> REQUEST_KEY_LIST = new ArrayList<>();
    private static final List<String> RESPONSE_KEY_LIST = new ArrayList<>();
    private static final List<String> REQUEST_EXTRA_PARAM_KEY_LIST = new ArrayList<>();
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
    private static final List<String> VALUES_DEFAULT_LIST = Arrays.asList("-");

    static {
        //初始化request中的key add的顺序即为日志显示的顺序
        REQUEST_KEY_LIST.add(REQUEST_KEY_REQUEST_TIME);
        REQUEST_KEY_LIST.add(REQUEST_KEY_URL);
        REQUEST_KEY_LIST.add(REQUEST_KEY_HTTP_METHOD);
        REQUEST_KEY_LIST.add(REQUEST_KEY_CONTENT_TYPE);
        REQUEST_KEY_LIST.add(REQUEST_KEY_CONTENT_LENGTH);
        REQUEST_KEY_LIST.add(REQUEST_KEY_HOST);
        REQUEST_KEY_LIST.add(REQUEST_KEY_USER_AGENT);
        REQUEST_KEY_LIST.add(REQUEST_KEY_X_FORWARDED_FOR);
        REQUEST_KEY_LIST.add(REQUEST_KEY_EXTRA_PARAM);
        REQUEST_KEY_LIST.add(REQUEST_KEY_BODY_PARAM);

        //初始化response中的key add的顺序即为日志显示的顺序
        RESPONSE_KEY_LIST.add(RESPONSE_KEY_RESPONSE_TIME);
        RESPONSE_KEY_LIST.add(RESPONSE_KEY_HTTP_CODE);
        RESPONSE_KEY_LIST.add(RESPONSE_KEY_CONTENT_TYPE);
        RESPONSE_KEY_LIST.add(RESPONSE_KEY_TAKE_TIME);
        RESPONSE_KEY_LIST.add(RESPONSE_KEY_RESPONSE_DATA);

        REQUEST_EXTRA_PARAM_KEY_LIST.add(REQUEST_KEY_EXTRA_PARAM_USER_ID);
        REQUEST_EXTRA_PARAM_KEY_LIST.add(REQUEST_KEY_EXTRA_PARAM_ACCESS_TOKEN);
    }


    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body,
                                  MethodParameter returnType,
                                  MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType,
                                  ServerHttpRequest request,
                                  ServerHttpResponse response) {
        Map<String, List<String>> resultMap = new HashMap<>();
        StringBuilder resultStr = new StringBuilder();

        Set<Map.Entry<String, List<String>>> entries = request.getHeaders().entrySet();
        for (Map.Entry<String, List<String>> entry : entries) {
            resultMap.put(entry.getKey().toLowerCase(), entry.getValue());
        }

        //填补extraParam参数
        handleExtraParam(resultMap);

        //填补body-param, take-time参数
        handleBodyParam(resultMap);

        //填补request key参数
        resultMap.put(REQUEST_KEY_URL, Arrays.asList(request.getURI().toString()));
        resultMap.put(REQUEST_KEY_HTTP_METHOD, Arrays.asList(request.getMethod().toString()));

        //填补response key参数
        resultMap.put(RESPONSE_KEY_RESPONSE_TIME, Arrays.asList(DATE_FORMAT.format(new Date())));
        resultMap.put(RESPONSE_KEY_RESPONSE_DATA, Arrays.asList(JSON.toJSONString(body)));

        //组装request和response
        generateResultLogger(resultMap, resultStr);

        logger.info(resultStr.toString());
        return body;
    }

    private void generateResultLogger(Map<String, List<String>> resultMap, StringBuilder resultStr) {
        //遍历request key, 并将相应的值写入StringBuilder中
        resultStr.append("\n");
        for (String requestKey : REQUEST_KEY_LIST) {
            List<String> requestValues = resultMap.get(requestKey);
            if (CollectionUtils.isEmpty(requestValues)) {
                requestValues = VALUES_DEFAULT_LIST;
            }
            appendKeyValue(resultStr, requestKey, requestValues, REQUEST_PREFIX);
        }

        resultStr.append("\n");
        //遍历response key, 并将相应的值写入StringBuilder中
        for (String responseKey : RESPONSE_KEY_LIST) {
            List<String> responseValues = resultMap.get(responseKey);
            if (CollectionUtils.isEmpty(responseValues)) {
                responseValues = VALUES_DEFAULT_LIST;
            }
            appendKeyValue(resultStr, responseKey, responseValues, RESPONSE_PREFIX);
        }
    }

    private void handleBodyParam(Map<String, List<String>> resultMap) {
        Date responseTime = new Date();

        ThreadLocal<Map<String, Object>> requestValThreadLocal = Conts.requestValThreadLocal;
        Map<String, Object> requestMap = requestValThreadLocal.get();
        requestValThreadLocal.remove();

        if (requestMap != null && !requestMap.isEmpty()) {
            Object bodyParam = requestMap.get(REQUEST_KEY_BODY_PARAM);
            if (null != bodyParam) {
                resultMap.put(REQUEST_KEY_BODY_PARAM, Arrays.asList((String) bodyParam));
            }
            Object requestTimeObj = requestMap.get(REQUEST_KEY_REQUEST_TIME);
            if (null != requestTimeObj) {
                Date requestTime = (Date) requestTimeObj;
                resultMap.put(REQUEST_KEY_REQUEST_TIME, Arrays.asList(DATE_FORMAT.format(requestTime)));
                resultMap.put(RESPONSE_KEY_TAKE_TIME, Arrays.asList(String.valueOf(responseTime.getTime() - requestTime.getTime())));
            }
        }
    }

    private void handleExtraParam(Map<String, List<String>> resultMap) {
        Map<String, Object> extraParam = new HashMap<>();
        for (String requestExtraParamKey : REQUEST_EXTRA_PARAM_KEY_LIST) {
            List<String> extraParamVal = resultMap.get(requestExtraParamKey);
            if (!CollectionUtils.isEmpty(extraParamVal)) {
                extraParam.put(requestExtraParamKey, extraParamVal);
            }
        }
        if (!extraParam.isEmpty()) {
            resultMap.put(REQUEST_KEY_EXTRA_PARAM, Arrays.asList(JSONObject.toJSONString(extraParam)));
        }
    }

    private static void appendKeyValue(StringBuilder sb, String key, List<String> values, String prefix) {
        sb.append(prefix).append(key).append(KEY_VALUE_SEPERATOR).append(convertToString(values)).append("\n");
    }

    private static String convertToString(List<?> headerValues) {
        if (headerValues == null) {
            return "";
        }
        if (headerValues.size() == 1) {
            return headerValues.get(0).toString();
        }

        final StringBuilder sb = new StringBuilder();
        boolean add = false;
        for (final Object s : headerValues) {
            if (add) {
                sb.append(',');
            }
            add = true;
            sb.append(s);
        }
        return sb.toString();
    }

}
