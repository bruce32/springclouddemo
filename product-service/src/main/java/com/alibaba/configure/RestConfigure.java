package com.alibaba.configure;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestConfigure {

	@LoadBalanced // 必须加，不然不能用微服务名进行调用
	@Bean(value = "restTemplate")
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
}
