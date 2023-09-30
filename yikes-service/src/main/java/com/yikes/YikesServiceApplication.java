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
 * @date 2023/9/28 21:12
 */
@SpringBootApplication
@EnableDiscoveryClient
public class YikesServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(YikesServiceApplication.class, args);
    }
    
}
