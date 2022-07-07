package com.example.demo;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisSampleController {

	private RedisSampleService redisSampleService;

	public RedisSampleController(RedisSampleService redisSampleService) {
		this.redisSampleService = redisSampleService;
	}

	@GetMapping(value = "/get/{key}")
	public String getRedisStringValue(@PathVariable String key, HttpSession session) {
		String value = redisSampleService.getRedisStringValue(key);    			

		return "Session Id : %s, Redis Key : %s , Redis Value : %s ".formatted(session.getId(), key, value);
	}

	@GetMapping(value = "/set/{key}/{value}")
	public String setRedisStringValue(@PathVariable String key, @PathVariable String value, HttpSession session) {
		redisSampleService.setRedisStringValue(key, value);    			

		return "Session Id : %s, Redis Key : %s , Redis Value : %s ".formatted(session.getId(), key, value);
	}

}