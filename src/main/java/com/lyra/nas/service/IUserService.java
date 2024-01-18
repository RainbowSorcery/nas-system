package com.lyra.nas.service;

import com.lyra.nas.common.Result;
import com.lyra.nas.entity.User;
import com.lyra.nas.entity.UserLoginDTO;
import org.springframework.validation.BindingResult;

/**
 * @projectName: nas-system
 * @package: com.lyra.nas.service
 * @className: IUserService
 * @author: lyra
 * @description: 用户service
 * @date: 2024-01-14 0:39
 * @version: 1.0
 */
public interface IUserService {
    /**
     * 登录接口
     * @param userLoginDTO 用户名密码封装类
     * @return 如果登录成功返回token
     */
    Result<Object> login(UserLoginDTO userLoginDTO);

    /**
     * 用户注册
     * @param user 用户信息
     * @param bindingResult 错误封装类
     * @return 注册信息
     */
    Result<Object> register(User user, BindingResult bindingResult);

    /**
     * 根据用户id查询用户信息
     * @param userId 用户iod
     * @return 用户信息
     */
    User getById(Long userId);
}
