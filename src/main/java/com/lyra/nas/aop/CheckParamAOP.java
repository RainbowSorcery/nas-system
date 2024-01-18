package com.lyra.nas.aop;

import com.lyra.nas.common.ResponseStatusEnums;
import com.lyra.nas.common.Result;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import java.util.List;

/**
 * @projectName: nas-system
 * @package: com.lyra.nas.aop
 * @className: CheckParamAOP
 * @author: lyra
 * @description: 参数校验AOP
 * @date: 2024-01-14 10:48
 * @version: 1.0
 */
@Aspect
@Component
public class CheckParamAOP {
    private static final Logger log = LoggerFactory.getLogger(CheckParamAOP.class);

    @Pointcut("execution (* com.lyra.nas.controller.*.*(..))")
    public void controllerInterfacePointcut() {
    }

    @Around("controllerInterfacePointcut()")
    public Object controllerBeforeAdvice(ProceedingJoinPoint proceedingJoinPoint) {
        for (Object arg : proceedingJoinPoint.getArgs()) {
            if (arg instanceof BindingResult) {
                BindingResult bindingResult = (BindingResult) arg;
                if (bindingResult.hasErrors()) {
                    List<ObjectError> errors = bindingResult.getAllErrors();
                    for (ObjectError error : errors) {
                        FieldError fieldError = (FieldError) error;
                        log.error("Invalid Parameter : object - {},field - {},errorMessage - {}", fieldError.getObjectName(), fieldError.getField(), fieldError.getDefaultMessage());
                        return Result.resultByStatusEnum(ResponseStatusEnums.request_pram_error, fieldError.getDefaultMessage());
                    }
                }
            }
        }

        try {
            return proceedingJoinPoint.proceed();
        } catch (Throwable e) {
            log.error("aop执行错误, 错误信息：{}", e.getMessage());
            return Result.resultByStatusEnum(ResponseStatusEnums.aop_run_exception, e.getMessage());
        }
    }
}
