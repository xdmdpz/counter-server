package com.focus.Counter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by if on 2017/6/26.
 */
@SpringBootApplication
@Configuration
@RestController
public class Application extends WebMvcConfigurerAdapter {

    @RequestMapping("/")
    public String home() {
        return " counter service..."
                + "<br />Welcome to <a href='http://xdmdpz.github.io'>my blog</a></li>";
    }
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    /**
     * 跨域配置
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowCredentials(true)
                .allowedMethods("GET", "POST", "DELETE", "PUT")
                .maxAge(3600);
    }
}
