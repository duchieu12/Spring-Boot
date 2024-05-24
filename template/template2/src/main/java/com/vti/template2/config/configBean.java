package com.vti.template2.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class configBean {
    @Bean
    public ModelMapper init() {
        return new ModelMapper();
    }
}
