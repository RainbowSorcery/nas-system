package com.lyra.nas.config;

import cn.dev33.satoken.jwt.StpLogicJwtForSimple;
import cn.dev33.satoken.stp.StpLogic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @projectName: nas-system
 * @package: com.lyra.nas.config
 * @className: SecurityConfig
 * @author: lyra
 * @description: 鉴权框架配置类
 * @date: 2024-01-14 0:48
 * @version: 1.0
 */
@Configuration
public class SecurityConfig {
    @Bean
    public StpLogic stpLogic() {
        return new StpLogicJwtForSimple();
    }
}
