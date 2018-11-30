package com.cloud.api;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.cloud.domain.User;
import com.cloud.fallback.UserServiceFallback;

/**
 * Description: TODO[描述该类概要功能介绍]
 *
 * @author Administrator
 * @date 2018年11月29日
 * @version 1.0
 */
@FeignClient(name = "${user.service.name}", fallback = UserServiceFallback.class)
// 利用占位符避免未来整合硬编码
public interface UserService {

	/**
	 * 保存用户
	 *
	 * @param user
	 * @return
	 */
	@PostMapping("/user/save")
	boolean saveUser(User user);

	/**
	 * 查询所有的用户列表
	 *
	 * @return non-null
	 */
	@GetMapping("/user/find/all")
	List<User> findAll();

}
