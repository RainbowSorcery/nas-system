package com.lyra.nas.controller;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.util.StrUtil;
import com.lyra.nas.common.ResponseStatusEnums;
import com.lyra.nas.common.Result;
import com.lyra.nas.entity.User;
import com.lyra.nas.entity.UserLoginDTO;
import com.lyra.nas.service.IUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @projectName: nas-system
 * @package: com.lyra.nas.controller
 * @className: UserController
 * @author: lyra
 * @description: 用户
 * @date: 2024-01-14 1:27
 * @version: 1.0
 */
@RestController
@RequestMapping("/user")
@Tag(name = "用户", description = "用户相关")
public class UserController {
    @Resource
    private IUserService userService;

    @Operation(summary = "登录", description = "校验用户是否合法")
    @PostMapping("/login")
    public Result<Object> login(@RequestBody UserLoginDTO userLoginDTO, BindingResult bindingResult) {
        // 校验传参是否正确
        if (StrUtil.isBlank(userLoginDTO.getUsername()) || StrUtil.isBlank(userLoginDTO.getPassword())) {
            return Result.resultByStatusEnum(ResponseStatusEnums.request_pram_error);
        }

        return userService.login(userLoginDTO);
    }

    @PostMapping("/register")
    @Operation(summary = "注册", description = "注册")
    public Result<Object> register(@RequestBody @Valid User user, BindingResult bindingResult) {

        return userService.register(user, bindingResult);
    }

    @PostMapping("/logout")
    @Operation(summary = "退出登录", description = "退出登录")
    public Result<Object> logout() {
        StpUtil.logout();

        return Result.successful();
    }
}
