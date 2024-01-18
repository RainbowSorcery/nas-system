package com.lyra.nas.service.impl;

import cn.dev33.satoken.secure.BCrypt;
import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import com.lyra.nas.common.ResponseStatusEnums;
import com.lyra.nas.common.Result;
import com.lyra.nas.entity.User;
import com.lyra.nas.entity.UserLoginDTO;
import com.lyra.nas.repository.UserRepository;
import com.lyra.nas.service.IUserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

/**
 * @projectName: nas-system
 * @package: com.lyra.nas.service.impl
 * @className: UserServiceImpl
 * @author: lyra
 * @description: 用户service实现类
 * @date: 2024-01-14 0:39
 * @version: 1.0
 */
@Service
public class UserServiceImpl implements IUserService {
    @Resource
    private UserRepository userRepository;

    @Override
    public Result<Object> login(UserLoginDTO userLoginDTO) {
        // 校验用户是否存在
        User userByUsername = userRepository.findByUsername(userLoginDTO.getUsername());
        if (userByUsername == null) {
            return Result.resultByStatusEnum(ResponseStatusEnums.username_not_found);
        }

        // 校验用户名密码是否匹配
        if (!BCrypt.checkpw(userLoginDTO.getPassword(), userByUsername.getPassword())) {
            return Result.resultByStatusEnum(ResponseStatusEnums.username_password_not_match);
        }

        StpUtil.login(userByUsername.getId());
        SaTokenInfo tokenInfo = StpUtil.getTokenInfo();

        return Result.resultByStatusEnum(ResponseStatusEnums.login_success, tokenInfo.getTokenValue());
    }

    @Override
    public Result<Object> register(User user, BindingResult bindingResult) {
        User byUsername = userRepository.findByUsername(user.getUsername());
        // 校验用户是否存在
        if (byUsername != null) {
            return Result.resultByStatusEnum(ResponseStatusEnums.username_is_exits);
        }

        user.setPassword(BCrypt.hashpw(user.getPassword()));
        user.setType(0);

        userRepository.save(user);

        return Result.successful();
    }

    @Override
    public User getById(Long userId) {
        return userRepository.getReferenceById(userId);
    }
}
