package com.example.test.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Spring Configuration
 */
@Configuration
@ComponentScan({"com.example.test", "com.codeborne.selenide"})
public class Config {
}
