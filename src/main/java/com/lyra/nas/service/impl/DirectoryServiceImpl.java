package com.lyra.nas.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import com.lyra.nas.common.ResponseStatusEnums;
import com.lyra.nas.common.Result;
import com.lyra.nas.entity.Directory;
import com.lyra.nas.entity.User;
import com.lyra.nas.repository.DirectoryRepository;
import com.lyra.nas.service.IDirectoryService;
import com.lyra.nas.service.IUserService;
import jakarta.annotation.Resource;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;

/**
 * @projectName: nas-system
 * @package: com.lyra.nas.service.impl
 * @className: DirectoryServiceImpl
 * @author: lyra
 * @description: 目录service
 * @date: 2024-01-16 5:17
 * @version: 1.0
 */
@Service
public class DirectoryServiceImpl implements IDirectoryService {
    @Resource
    private DirectoryRepository directoryRepository;

    @Resource
    private IUserService userService;

    @Override
    public Result<Object> save(Directory directory) {
        Object loginId = StpUtil.getTokenInfo().getLoginId();

        // 校验用户是否存在
        User user = userService.getById(Long.valueOf(loginId.toString()));
        if (user == null) {
            return Result.resultByStatusEnum(ResponseStatusEnums.user_not_found);
        }

        // 校验目录是parent目录是否存在
        if (directory.getParentId() != 0) {
            Optional<Directory> dirByIdOptional = directoryRepository.findById(directory.getParentId());
            if (dirByIdOptional.isEmpty()) {
                return Result.resultByStatusEnum(ResponseStatusEnums.DIR_NOT_EXITS);
            }
        }

        directory.setUpdateTime(LocalDateTime.now());
        directory.setUserId(user.getId());

        directoryRepository.save(directory);

        return Result.successful();
    }
}
