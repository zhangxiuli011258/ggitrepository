package com.cloud.user.service.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.cloud.api.UserService;
import com.cloud.user.service.client.rule.MyRule;
import com.netflix.loadbalancer.IRule;

/**
 * 引导类
 *
 * @author <a href="mailto:mercyblitz@gmail.com">Mercy</a>
 * @since 0.0.1
 */
@SpringBootApplication
@RibbonClient("user-service-provider")
// 指定目标应用名称
@EnableCircuitBreaker
// 使用服务短路
@EnableFeignClients(clients = UserService.class)
// 申明 UserService 接口作为 Feign Client 调用
@EnableDiscoveryClient
// 激活服务发现客户端
public class UserServiceClientApplication {

	public static void main(String[] args) {

		SpringApplication.run(UserServiceClientApplication.class, args);
	}

	/**
	 * 将 {@link MyRule} 暴露成 {@link Bean}
	 *
	 * @return {@link MyRule}
	 */
	@Bean
	public IRule myRule() {

		return new MyRule();
	}

	/**
	 * 申明 具有负载均衡能力 {@link RestTemplate}
	 *
	 * @return
	 */
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {

		return new RestTemplate();
	}

}
