package com.lukasowy.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class EhCacheConfig {
	//
	// @Bean
	// public CacheManager cacheManager() {
	// SimpleCacheManager cacheManager = new SimpleCacheManager();
	// List<Cache> cacheList = new ArrayList<Cache>();
	// cacheList.add(new ConcurrentMapCache("userCache"));
	// cacheList.add(new ConcurrentMapCache("addressCache"));
	// cacheManager.setCaches(cacheList);
	// return cacheManager;
	// }
}
