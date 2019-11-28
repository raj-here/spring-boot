package com.biz.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.interceptor.CacheErrorHandler;
import org.springframework.cache.interceptor.CacheResolver;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.cache.interceptor.SimpleCacheErrorHandler;
import org.springframework.cache.interceptor.SimpleCacheResolver;
import org.springframework.cache.interceptor.SimpleKeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import net.sf.ehcache.config.CacheConfiguration;
import net.sf.ehcache.config.DiskStoreConfiguration;
import net.sf.ehcache.config.PersistenceConfiguration;
import net.sf.ehcache.config.PersistenceConfiguration.Strategy;
import net.sf.ehcache.store.MemoryStoreEvictionPolicy;

@Configuration
@EnableCaching
public class EHCacheConfig implements CachingConfigurer {

	private final CacheManager cacheManager;
	private final net.sf.ehcache.CacheManager ehCacheManager;

	private enum Env {
		USER_HOME("user.home"), USER_DIR("user.dir"), JAVA_IO_TMPDIR("java.io.tmpdir"), EHCACHE_DISK_STORE_DIR(
				"ehcache.disk.store.dir");
		private final String variable;

		Env(String variable) {
			this.variable = variable;
		}
	}

	public EHCacheConfig() {
		net.sf.ehcache.config.Configuration cfg = new net.sf.ehcache.config.Configuration();

		cfg.addCache(new CacheConfiguration("book", 10000).memoryStoreEvictionPolicy(MemoryStoreEvictionPolicy.LFU)
				.eternal(false).timeToLiveSeconds(60).timeToIdleSeconds(30).diskExpiryThreadIntervalSeconds(0)
				.persistence(new PersistenceConfiguration().strategy(Strategy.LOCALTEMPSWAP)));

		cfg.addDiskStore(getDiskStoragePath());

		this.ehCacheManager = net.sf.ehcache.CacheManager.newInstance(cfg);
		this.cacheManager = new EhCacheCacheManager(ehCacheManager);
	}

	@Bean(destroyMethod = "shutdown")
	public net.sf.ehcache.CacheManager ehCacheManager() {
		return ehCacheManager;
	}

	@Bean
	@Override
	public CacheManager cacheManager() {
		return cacheManager;
	}

	@Bean
	@Override
	public KeyGenerator keyGenerator() {
		return new SimpleKeyGenerator();
	}

	@Bean
	@Override
	public CacheResolver cacheResolver() {
		return new SimpleCacheResolver(cacheManager);
	}

	@Bean
	@Override
	public CacheErrorHandler errorHandler() {
		return new SimpleCacheErrorHandler();
	}

	public DiskStoreConfiguration getDiskStoragePath() {
		DiskStoreConfiguration dsCf = new DiskStoreConfiguration();
		dsCf.setPath(Env.JAVA_IO_TMPDIR.variable);
		return dsCf;
	}

}
