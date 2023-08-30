package ssgssak.ssgpointuser.global.config.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.CorsRegistry;
import org.springframework.web.reactive.config.WebFluxConfigurer;


/**
 * WebMvcConfigurer를 사용하는 대신 WebFluxConfigurer을 사용하도록 변경
 */
@Configuration
public class CorsConfig implements WebFluxConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        WebFluxConfigurer.super.addCorsMappings(registry);
        registry.addMapping("/**");
    }
}
