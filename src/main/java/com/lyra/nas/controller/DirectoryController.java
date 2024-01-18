package com.lyra.nas.controller;

import com.lyra.nas.common.Result;
import com.lyra.nas.entity.Directory;
import com.lyra.nas.service.IDirectoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @projectName: nas-system
 * @package: com.lyra.nas.controller
 * @className: DirecotryController
 * @author: lyra
 * @description: 目录controller
 * @date: 2024-01-16 5:17
 * @version: 1.0
 */
@RestController
@RequestMapping("/directory")
@Tag(name = "目录", description = "目录")
public class DirectoryController {
    @Resource
    private IDirectoryService directoryService;

    @Operation(summary = "添加目录", description = "添加目录")
    @PostMapping("/save")
    public Result<Object> save(@RequestBody Directory directory, BindingResult bindingResult) {
        return directoryService.save(directory);
    }

}
