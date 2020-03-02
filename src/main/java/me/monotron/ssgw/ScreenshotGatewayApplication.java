package me.monotron.ssgw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories
@SpringBootApplication
public class ScreenshotGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScreenshotGatewayApplication.class, args);
    }
}
