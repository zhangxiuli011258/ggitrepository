package com.cloud.user.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * Description: TODO[描述该类概要功能介绍]
 *
 * @author Administrator
 * @date 2018年11月29日
 * @version 1.0
 */
@SpringBootApplication
@EnableHystrix
@EnableDiscoveryClient
// 激活服务发现客户端
public class UserServiceProviderApplication {

	public static void main(String[] args) {

		SpringApplication.run(UserServiceProviderApplication.class, args);
	}
}
