package cn.et;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
//自动注册到注册中心
@EnableEurekaClient
public class Main {

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}
}
