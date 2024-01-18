package com.lyra.nas.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @projectName: nas-system
 * @package: com.lyra.nas.config
 * @className: SwaggerConfig
 * @author: lyra
 * @description: swagger配置
 * @date: 2024-01-16 8:24
 * @version: 1.0
 */
@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("lyra nas API")
                        .description("网络存储系统")
                        .version("v0.0.1"))
                .externalDocs(new ExternalDocumentation()
                        .description("接口文档信息"));
    }
}
