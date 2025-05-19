package tech.jianning.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"tech.jianning"})
@MapperScan(basePackages = "tech.jianning.core.mapper")
public class AlgVisServerApplication {

  public static void main(String[] args) {
    SpringApplication.run(AlgVisServerApplication.class, args);
  }

}
