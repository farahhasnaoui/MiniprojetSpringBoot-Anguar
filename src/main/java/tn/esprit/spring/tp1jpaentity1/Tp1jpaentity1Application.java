package tn.esprit.spring.tp1jpaentity1;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EntityScan(basePackages={"tn.esprit.spring.entity"})
@SpringBootApplication
@Slf4j
@ComponentScan(basePackages = {"tn.esprit.spring.controllers","tn.esprit.spring.services"})
@EnableJpaRepositories(basePackages = {"tn.esprit.spring.reposotiries"})
public class Tp1jpaentity1Application {

    public static void main(String[] args) {
        SpringApplication.run(Tp1jpaentity1Application.class, args);

        log.info("hello");
    }

}
