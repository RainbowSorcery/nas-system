package com.lyra.nas.execption;

import cn.dev33.satoken.exception.NotLoginException;
import com.lyra.nas.common.ResponseStatusEnums;
import com.lyra.nas.common.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * @projectName: nas-system
 * @package: com.lyra.nas.execption
 * @className: ExceptionHandler
 * @author: lyra
 * @description: 统一异常解析
 * @date: 2024-01-14 0:30
 * @version: 1.0
 */
@RestControllerAdvice
public class ServiceExceptionHandler {
    private static final Logger log = LoggerFactory.getLogger(ServiceExceptionHandler.class);

    @ExceptionHandler(LyraException.class)
    public Result<Object> processLyraExceptionHandler(LyraException exception) {
        log.error(exception.getLocalizedMessage(), exception);

        return Result.resultByStatusEnum(exception.getResultCode());
    }

    @ExceptionHandler(NotLoginException.class)
    public Result<Object> notLoginExceptionHandler(NotLoginException notLoginException) {
        log.error("用户未登录, 错误信息:{}", notLoginException.getMessage());

        return Result.resultByStatusEnum(ResponseStatusEnums.user_not_login);
    }


    @ExceptionHandler(RuntimeException.class)
    public Result<Object> otherExceptionHandler(RuntimeException e) {
        log.error(e.getLocalizedMessage());

        return Result.resultByStatusEnum(ResponseStatusEnums.failed, e.getMessage());
    }
}
