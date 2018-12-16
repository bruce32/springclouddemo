package com.alibaba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.service.ProductService;

@RestController
@RequestMapping("/feign")
public class FeignController {

	@Autowired
	private ProductService productService;

	@RequestMapping("/{id}")
	public String feignDemo(@PathVariable("id") Long id) {
		return productService.updateUser(id);
	}
}
