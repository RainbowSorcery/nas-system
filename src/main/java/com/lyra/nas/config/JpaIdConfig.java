package com.lyra.nas.config;

import cn.hutool.core.util.IdUtil;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.springframework.context.annotation.Configuration;

/**
 * @projectName: nas-system
 * @package: com.lyra.nas.config
 * @className: JpaConfig
 * @author: lyra
 * @description: spring data jpa id生成配置类
 * @date: 2024-01-14 12:01
 * @version: 1.0
 */
@Configuration
public class JpaIdConfig implements IdentifierGenerator {
    @Override
    public Object generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object o) {
        return IdUtil.getSnowflakeNextId();
    }
}
