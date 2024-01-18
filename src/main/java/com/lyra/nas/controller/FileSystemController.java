package com.lyra.nas.controller;

import com.lyra.nas.common.Result;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @projectName: nas-system
 * @package: com.lyra.nas.controller
 * @className: FileSystemController
 * @author: lyra
 * @description: 文件系统
 * @date: 2024-01-14 14:35
 * @version: 1.0
 */
@RestController
@RequestMapping("/fileSystem")
@Tag(name = "文件系统", description = "文件系统")
public class FileSystemController {
    @PostMapping("/preCreate")
    public Result<Object> preCreate() {
        return null;
    }
}
