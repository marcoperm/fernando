package com.example.demo.configuration;

import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class MvcConfig implements WebMvcConfigurer{
    //ViewControllerRegistry se utiliza ara registrar controladores  de vista  manejar las solicitudes y renderizar las vistas
    public void addViewControllers( @SuppressWarnings("null") ViewControllerRegistry registry){
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/comite").setViewName("comite");
        registry.addViewController("/comiteevent").setViewName("comiteevent");
        registry.addViewController("/vicerrectoria").setViewName("vicerrectoria");
        registry.addViewController("/registrar").setViewName("registrar");
        registry.addViewController("/autenticar").setViewName("autenticar");
    }
    @Override
    public void addResourceHandlers(@SuppressWarnings("null") ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/");
    }


}
