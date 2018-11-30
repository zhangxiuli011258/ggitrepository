package com.cloud.eureka.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Description: TODO[描述该类概要功能介绍]
 *
 * @author Administrator
 * @date 2018年11月29日
 * @version 1.0
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication {

	public static void main(String[] args) {

		SpringApplication.run(EurekaServerApplication.class, args);
	}

}
