package com.example.demo;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisSampleController {

	private RedisSampleService redisSampleService;

	public RedisSampleController(RedisSampleService redisSampleService) {
		this.redisSampleService = redisSampleService;
	}

	@GetMapping(value = "/get")
	public String getRedisStringValue(@RequestParam String key, HttpSession session) {
		String value = redisSampleService.getRedisStringValue(key);    			

		return "Session Id : %s, Redis Key : %s , Redis Value : %s ".formatted(session.getId(), key, value);
	}



}