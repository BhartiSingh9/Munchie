package com.example.muncihe_user_db.configure;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // Allow cross-origin requests from any origin for the specific endpoint
        // registry.addMapping("/restaurants")
        //         .allowedOrigins("*")
        //         .allowedMethods("GET"); // You can specify other HTTP methods as needed

        // registry.addMapping("/dishes")
        //         .allowedOrigins("*")
        //         .allowedMethods("GET");
        // registry.addMapping("/dishes/restaurants/{restaurantId}")
        //         .allowedOrigins("http://127.0.0.1:5500")
        //         .allowedMethods("GET");
        // registry.addMapping("/users/getbyemail")
        //         .allowedOrigins("http://127.0.0.1:5500") // Replace with your Angular app's actual origin
        //         .allowedMethods("POST");
        registry.addMapping("/**");
        
}
}
