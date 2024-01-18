package com.lyra.nas.service;

import com.lyra.nas.common.Result;
import com.lyra.nas.entity.Directory;

/**
 * @projectName: nas-system
 * @package: com.lyra.nas.service
 * @className: IDirectoryService
 * @author: lyra
 * @description: 目录service
 * @date: 2024-01-16 5:17
 * @version: 1.0
 */
public interface IDirectoryService {
    Result<Object> save(Directory directory);
}
