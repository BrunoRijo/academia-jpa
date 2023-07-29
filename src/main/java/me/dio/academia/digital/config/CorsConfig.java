package me.dio.academia.digital.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class CorsConfig implements WebMvcConfigurer {

    /*
        allowedOrigins: Permite acesso da origem de onde subi o projeto que consome essa api,
                        no caso: "http://localhost:333"
        allowedMethods: Permite métodos HTTP especificos
        allowedHeaders: Permite qualquer cabeçalho
        */
    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/alunos")
                .allowedOrigins("http://localhost:333")
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedHeaders("*");
    }
}
