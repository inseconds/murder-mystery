package com.murder.mystery.common.exception;

import com.murder.mystery.common.response.ResponseCode;
import com.murder.mystery.common.response.ServiceResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * @author Rolex.Ye
 * @date 2018年4月25日 下午4:53:07
 * @desc Restful应用统一异常处理
 */
@ControllerAdvice
public class RestExceptionResolver {

    private static final Logger logger = LoggerFactory.getLogger(RestExceptionResolver.class);
	
    /**
     * 自定义异常  warning级别
     * @param ex
     * @return
     */
	@ExceptionHandler(value={ServiceException.class})
	@ResponseBody
	public ServiceResponse serviceExceptionHandler(ServiceException ex) {
		logger.warn(ex.getMessage());
		ServiceResponse response = new ServiceResponse();
		response.setCode(ex.getResponseCode());
		response.setResultMessage(ex.getMessage());
        return response;
    }
	
	/**
     * 自定义异常  error级别
     * @param ex
     * @return
     */
	@ExceptionHandler(value={ErrorException.class})
	@ResponseBody
	public ServiceResponse errorExceptionHandler(ErrorException ex) {
		logger.error(ex.getMessage(), ex);
		ServiceResponse response = new ServiceResponse();
		response.setCode(ex.getResponseCode());
		response.setResultMessage(ex.getMessage());
        return response;
    }
	
	@ExceptionHandler(value={Exception.class})
	@ResponseBody
	public ServiceResponse globalExceptionHandler(Exception ex) {
		ServiceResponse response = new ServiceResponse();
		response.setResultMessage(ex.getMessage());
		if(ex instanceof MethodArgumentNotValidException){
			response.setCode(ResponseCode.VALIDATION_ERROR);
			response.setResultMessage(((MethodArgumentNotValidException)ex).getBindingResult().getFieldError().getDefaultMessage());
			logger.warn(ex.getMessage());
		}
		else if(ex instanceof NoHandlerFoundException){
			response.setCode(ResponseCode.RESOURCE_UNFOUND);
			logger.warn(ex.getMessage());
		}
		else if(ex instanceof HttpRequestMethodNotSupportedException){
			response.setCode(ResponseCode.HTTP_METHOD_NOT_ALLOWED);
			logger.warn(ex.getMessage());
		}
		else if(ex instanceof HttpMediaTypeNotSupportedException){
			response.setCode(ResponseCode.HTTP_MEDIA_TYPE_UNSUPPORTED);
			logger.warn(ex.getMessage());
		}
		else{
			response.setCode(ResponseCode.SYSTEM_ERROR);
			response.setResultMessage("服务器内部异常");

			logger.error(ex.getMessage(), ex);
		}
        return response;
    }
	
}
