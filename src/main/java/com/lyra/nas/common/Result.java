package com.lyra.nas.common;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * @projectName: nas-system
 * @package: com.lyra.nas.common
 * @className: Result
 * @author: lyra
 * @description: 统一返回结果
 * @date: 2024-01-12 8:24
 * @version: 1.0
 */
public class Result<T> {
    @Schema(description = "信息")
    private String message;
    @Schema(description = "返回结果")
    private Boolean successful;
    @Schema(description = "返回数组")
    private T data;
    @Schema(description = "状态码")
    private Integer status;

    public Result(String message, Boolean successful, Integer status) {
        this.message = message;
        this.successful = successful;
        this.status = status;
    }

    public Result(String message, Boolean successful, Integer status, T data) {
        this.message = message;
        this.successful = successful;
        this.data = data;
        this.status = status;
    }


    public static <T> Result<T> successful(T data) {
        return Result.resultByStatusEnum(ResponseStatusEnums.successful, data);
    }

    public static <T> Result<T> successful() {
        return Result.resultByStatusEnum(ResponseStatusEnums.successful);
    }

    public static <T> Result<T> failed(T data) {
        return Result.resultByStatusEnum(ResponseStatusEnums.failed, data);
    }

    public static <T> Result<T> failed() {
        return Result.resultByStatusEnum(ResponseStatusEnums.failed);
    }

    public static <T> Result<T> resultByStatusEnum(ResponseStatusEnums ResponseStatusEnums) {
        return new Result<T>(ResponseStatusEnums.getMessage(), ResponseStatusEnums.getSuccess(), ResponseStatusEnums.getCode());
    }

    public static <T> Result<T> resultByStatusEnum(ResponseStatusEnums ResponseStatusEnums, T data) {
        return new Result<T>(ResponseStatusEnums.getMessage(), ResponseStatusEnums.getSuccess(), ResponseStatusEnums.getCode(), data);
    }

    public String getMessage() {
        return message;
    }

    public Boolean getSuccessful() {
        return successful;
    }

    public T getData() {
        return data;
    }

    public Integer getStatus() {
        return status;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setSuccessful(Boolean successful) {
        this.successful = successful;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
