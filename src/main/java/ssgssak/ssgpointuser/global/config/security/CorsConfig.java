package ssgssak.ssgpointuser.global.config.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.WebFluxConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
//@EnableWebMvc // 여기에는 필요없음 -> 웹 요청 및 응답을 처리하는데 필요 ex) 컨트롤러, 뷰 리졸버, 핸들러 매핑, 인터셉터 등을 활성화 함
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry
                .addMapping("/**")
                .allowCredentials(true).maxAge(3600) // maxAge는 preflight 정보를 캐싱해두는 기간이다. 이 기간동안은 preflight request를 보내지 않는다.
                .allowedOriginPatterns("*")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS")
                .allowedHeaders("*")
                .exposedHeaders("*");
    }
}
