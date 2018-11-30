/**
 * user-api
 */

/**
 * 文件名： com.example.fallback.package-info.java
 * 作者： zhangxl
 * 日期： 2018年11月29日
 * 功能说明：
 * =========================================================
 * 修改记录：
 * 修改作者 日期 修改内容
 * =========================================================
 * Copyright (c) 2010-2011 .All rights reserved.
 */
package com.cloud.fallback;

import java.util.Collections;
import java.util.List;

import com.cloud.api.UserService;
import com.cloud.domain.User;

/**
 * {@link UserService} Fallback 实现
 *
 * @author <a href="mailto:mercyblitz@gmail.com">Mercy</a>
 * @since 1.0.0
 */
public class UserServiceFallback implements UserService {

	@Override
	public boolean saveUser(User user) {

		return false;
	}

	@Override
	public List<User> findAll() {

		return Collections.emptyList();
	}
}
