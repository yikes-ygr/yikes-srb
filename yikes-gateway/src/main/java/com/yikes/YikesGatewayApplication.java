package com.yikes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * <pre>
 *
 * </pre>
 *
 * @author guanrong.yin
 * @date 2023/9/30 15:20
 */
@SpringBootApplication
@EnableDiscoveryClient
public class YikesGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(YikesGatewayApplication.class, args);
    }
    
}
