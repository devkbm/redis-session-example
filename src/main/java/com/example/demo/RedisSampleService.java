package com.example.demo;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

@Service
public class RedisSampleService {

	private StringRedisTemplate stringRedisTemplate;

	public RedisSampleService(StringRedisTemplate stringRedisTemplate) {
		this.stringRedisTemplate = stringRedisTemplate;		
	}

	public String getRedisStringValue(String key) {		        
		ValueOperations<String, String> stringValueOperations = stringRedisTemplate.opsForValue();        		

		return stringValueOperations.get(key);
	}

	public void setRedisStringValue(String key, String value) {		        
		ValueOperations<String, String> stringValueOperations = stringRedisTemplate.opsForValue();        		
		
		stringValueOperations.set(key, value);			
	}
		
}