package com.cloud.user.service.provider.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;

import com.cloud.api.UserService;
import com.cloud.domain.User;

/**
 * Description:内存实现类
 *
 * @author Administrator
 * @date 2018年11月29日
 * @version 1.0
 */
@Service("inMemoryUserService")
// Bean 名称
public class InMemoryUserService implements UserService {

	private Map<Long, User>	repository	= new ConcurrentHashMap<>();

	@Override
	public boolean saveUser(User user) {

		return repository.put(user.getId(), user) == null;
	}

	@Override
	public List<User> findAll() {

		return new ArrayList(repository.values());
	}
}
