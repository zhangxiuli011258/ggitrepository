package com.cloud.domain;

import java.io.Serializable;

/**
 * Description: TODO[描述该类概要功能介绍]
 *
 * @author Administrator
 * @date 2018年11月29日
 * @version 1.0
 */
public class User implements Serializable {

	/**
	 * Description:[字段功能描述]
	 */
	private static final long	serialVersionUID	= 1L;
	private Long				id;
	private String				name;

	public Long getId() {

		return id;
	}

	public void setId(Long id) {

		this.id = id;
	}

	public String getName() {

		return name;
	}

	public void setName(String name) {

		this.name = name;
	}

}
