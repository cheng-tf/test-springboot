package cn.edu.bupt.opensource.test.springboot.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * SpringBoot启动类
 * @author chengtf
 * @date 2019/4/9
 */
@SpringBootApplication
@EnableScheduling
@EnableKafka
@MapperScan(basePackages = "cn.edu.bupt.opensource.test.springboot.dao")
@ComponentScan(basePackages = "cn.edu.bupt.opensource.test.springboot.*")
public class SpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
    }

}
