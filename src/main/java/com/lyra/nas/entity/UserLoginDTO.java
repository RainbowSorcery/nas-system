package com.lyra.nas.entity;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * @projectName: nas-system
 * @package: com.lyra.nas.entity
 * @className: UserDTO
 * @author: lyra
 * @description: 用户登录DTO
 * @date: 2024-01-14 0:41
 * @version: 1.0
 */
public class UserLoginDTO {
    @Schema(description = "用户名")
    private String username;

    @Schema(description = "密码")
    private String password;;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
