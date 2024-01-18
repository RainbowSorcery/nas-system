package com.lyra.nas.repository;

import com.lyra.nas.entity.Directory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @projectName: nas-system
 * @package: com.lyra.nas.repository
 * @className: DirectoryRepository
 * @author: lyra
 * @description: 文件夹Repository
 * @date: 2024-01-16 5:04
 * @version: 1.0
 */
@Repository
public interface DirectoryRepository extends JpaRepository<Directory, Long> {

}
