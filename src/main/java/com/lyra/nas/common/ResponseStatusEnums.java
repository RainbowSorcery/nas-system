package com.lyra.nas.common;


public enum ResponseStatusEnums {
    successful("成功", true, 200),
    login_success("登录成功", true, 201),
    failed("失败", false, 500),
    username_not_found("用户名不存在", false, 501),
    username_password_not_match("用户名密码不匹配", false, 502),
    request_pram_error("请求参数错误", false, 503),
    user_not_login("用户未登录", false, 504),
    username_is_exits("用户名已存在", false, 505),
    user_not_found("用户不存在", false, 506),
    DIR_NOT_EXITS("文件夹不存在", false, 507),
    aop_run_exception("aop执行错误", false, 508);
    private String message;
    private Boolean success;
    private Integer code;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    ResponseStatusEnums(String message, Boolean success, Integer code) {
        this.message = message;
        this.success = success;
        this.code = code;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }
}
