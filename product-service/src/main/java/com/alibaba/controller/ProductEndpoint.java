package com.alibaba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/products")
public class ProductEndpoint {

	@Autowired
	@Qualifier("restTemplate")
	private RestTemplate restTemplate;

	@RequestMapping("/{id}")
	@HystrixCommand(fallbackMethod = "updateUserFallback")
	public String updateUser(@PathVariable("id") Long id) {
		return restTemplate.getForEntity("http://userservice/users/{id}", String.class, id).getBody();
	}

	public String updateUserFallback(Long id) {
		return id + "haha";
	}
}
