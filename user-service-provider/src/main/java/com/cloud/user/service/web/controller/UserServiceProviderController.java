package com.cloud.user.service.web.controller;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.api.UserService;
import com.cloud.domain.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

/**
 * Description: TODO[描述该类概要功能介绍]
 *
 * @author Administrator
 * @date 2018年11月29日
 * @version 1.0
 */
@RestController
public class UserServiceProviderController implements UserService {

	@Autowired
	@Qualifier("inMemoryUserService")
	// 实现 Bean ： InMemoryUserService
	private UserService			userService;

	private final static Random	random	= new Random();

	// 通过方法继承，URL 映射 ："/user/save"
	@Override
	public boolean saveUser(@RequestBody User user) {

		return userService.saveUser(user);
	}

	@HystrixCommand(
			commandProperties = { // Command 配置
			// 设置操作时间为 100 毫秒
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "100")
			},
			fallbackMethod = "fallbackForGetUsers" // 设置 fallback 方法
	)
	// 通过方法继承，URL 映射 ："/user/find/all"
	@Override
	public List<User> findAll() {

		return userService.findAll();
	}

	/**
	 * 获取所有用户列表
	 *
	 * @return
	 */
	@HystrixCommand(
			commandProperties = { // Command 配置
			// 设置操作时间为 100 毫秒
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "100")
			},
			fallbackMethod = "fallbackForGetUsers" // 设置 fallback 方法
	)
	@GetMapping("/user/list")
	public List<User> getUsers() throws InterruptedException {

		long executeTime = random.nextInt(200);

		// 通过休眠来模拟执行时间
		System.out.println("Execute Time : " + executeTime + " ms");

		Thread.sleep(executeTime);

		return userService.findAll();
	}

	/**
	 * {@link #getUsers()} 的 fallback 方法
	 *
	 * @return 空集合
	 */
	public List<User> fallbackForGetUsers() {

		return Collections.emptyList();
	}

}
