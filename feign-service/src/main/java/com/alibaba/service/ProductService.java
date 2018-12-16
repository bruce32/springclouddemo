package com.alibaba.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("productservice")
public interface ProductService {

	@RequestMapping(value = "/products/{id}")
	String updateUser(@PathVariable("id") Long id);
}
