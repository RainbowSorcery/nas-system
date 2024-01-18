package com.lyra.nas.config;

import cn.dev33.satoken.interceptor.SaInterceptor;
import cn.dev33.satoken.stp.StpUtil;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @projectName: nas-system
 * @package: com.lyra.nas.config
 * @className: AuthConfig
 * @author: lyra
 * @description: 鉴权路由配置
 * @date: 2024-01-14 1:27
 * @version: 1.0
 */
@Configuration
public class AuthConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册 Sa-Token 拦截器，校验规则为 StpUtil.checkLogin() 登录校验。
        registry.addInterceptor(new SaInterceptor(handle -> StpUtil.checkLogin()))
                .addPathPatterns("/**")
                .excludePathPatterns("/user/login")
                .excludePathPatterns("/user/register")
                .excludePathPatterns("/user/logout")
                .excludePathPatterns("/v3/**")
                .excludePathPatterns(("/swagger-ui/**"))
        ;
    }
}
