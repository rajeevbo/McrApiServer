package com.interview.mcr.api;

import com.interview.mcr.Parser;
import com.interview.mcr.ParserImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class Config {
    @Bean
    public Parser parser() {
        return new ParserImpl();
    }

}
