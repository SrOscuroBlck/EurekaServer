package co.com.camargo.coursesmicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan(basePackages = {
        "co.com.camargo.entitycommon",
        "co.com.camargo.coursesmicroservice",
})
@EntityScan(basePackages = {
        "co.com.camargo.entitycommon.models.entity",
        "co.com.camargo.coursesmicroservice.models.entity"
})

public class CoursesmicroserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CoursesmicroserviceApplication.class, args);
    }

}
