package net.woniper.bean.generator;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class CustomBeanNameGeneratorApplication {

	public static void main(String[] args) {
        CustomBeanNameGenerator beanNameGenerator = new CustomBeanNameGenerator();
        beanNameGenerator.addBasePackages("net.woniper.bean.generator.controller");

        new SpringApplicationBuilder(CustomBeanNameGeneratorApplication.class)
                .beanNameGenerator(beanNameGenerator)
                .run(args);
    }
}
