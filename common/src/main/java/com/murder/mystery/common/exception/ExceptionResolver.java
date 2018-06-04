package com.murder.mystery.common.exception;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.murder.mystery.server.response.DataResponse;
import com.murder.mystery.server.response.ResponseCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * com.aihuishou.opt.api.sj
 * @author Mark Li
 * @version 1.0.0
 * @since 2018/4/12
 */
public class ExceptionResolver implements HandlerExceptionResolver {

    private static final Logger logger = LoggerFactory.getLogger(ExceptionResolver.class);

	@Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {

        DataResponse response;
        if (e instanceof ServiceException) {
            logger.warn(e.getMessage());
            ServiceException se = (ServiceException) e;
            response =  new DataResponse(se.getResponseCode(), se.getMessage());
        } else if (e instanceof MethodArgumentNotValidException) {
            logger.warn(e.getMessage());
            response = new DataResponse(ResponseCode.BAD_REQUEST, e.getMessage());
        } else {
            logger.error(e.getMessage(), e);
            response = new DataResponse(ResponseCode.SYSTEM_ERROR, e.getMessage());
        }
        try {
        	httpServletResponse.setCharacterEncoding("UTF-8");
            httpServletResponse.setContentType("application/json");
            httpServletResponse.getWriter().write(JSON.toJSONString(response, SerializerFeature.WriteMapNullValue));
        } catch (IOException ioe) {
            logger.error("与客户端通讯异常：" + ioe.getMessage(), ioe);
        }

        return new ModelAndView();
    }
}
