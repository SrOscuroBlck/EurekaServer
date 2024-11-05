package co.com.camargo.usermicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class UsermicroserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UsermicroserviceApplication.class, args);
    }

}
