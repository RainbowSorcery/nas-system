package com.lyra.nas.entity;

import com.lyra.nas.config.JpaIdConfig;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;

/**
 * @projectName: nas-system
 * @package: com.lyra.nas.entity
 * @className: Directory
 * @author: lyra
 * @description: 文件目录
 * @date: 2024-01-16 5:02
 * @version: 1.0
 */
@Entity(name = "directory")
public class Directory {
    @Id
    @Schema(description = "主键")
    @GeneratedValue(generator = "snowFake")
    @GenericGenerator(name = "snowFake", type = JpaIdConfig.class)
    private Long id;

    @Schema(description = "父目录id，如果没有父目录则是0")
    @NotNull(message = "父id不能为空")
    private Long parentId;

    @Schema(description = "文件夹名称")
    @NotNull(message = "文件夹名称不能为空")
    private String name;

    @Schema(description = "目录更新时间")
    private LocalDateTime updateTime;

    @Schema(description = "所属用户id")
    @NotNull(message = "所属用户id不能为空")
    private Long userId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
