package com.cloud.user.service.client.hystrix;

import java.util.Collection;
import java.util.Collections;

import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

/**
 * User Ribbon Client HystrixCommand
 *
 * @author <a href="mailto:mercyblitz@gmail.com">Mercy</a>
 * @since 0.0.1
 */
public class UserRibbonClientHystrixCommand extends HystrixCommand<Collection> {

	private final String		providerServiceName;

	private final RestTemplate	restTemplate;

	public UserRibbonClientHystrixCommand(String providerServiceName, RestTemplate restTemplate) {

		super(HystrixCommandGroupKey.Factory.asKey(
				"User-Ribbon-Client"),
				100);
		this.providerServiceName = providerServiceName;
		this.restTemplate = restTemplate;
	}

	/**
	 * 主逻辑实现
	 *
	 * @return
	 * @throws Exception
	 */
	@Override
	protected Collection run() throws Exception {

		return restTemplate.getForObject("http://" + providerServiceName + "/user/list", Collection.class);
	}

	/**
	 * Fallback 实现
	 *
	 * @return 空集合
	 */
	@Override
	protected Collection getFallback() {

		return Collections.emptyList();
	}

}
