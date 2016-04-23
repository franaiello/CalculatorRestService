package com.aiello.calculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

@SpringBootApplication(scanBasePackages = "com.aiello.calculator")
public class Application {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(Application.class, args);

        String[] beans = ctx.getBeanDefinitionNames();
        Arrays.sort(beans);
        Arrays.stream(beans).forEach(System.out::println);
    }
}
