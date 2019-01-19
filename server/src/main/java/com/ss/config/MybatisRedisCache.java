package com.ss.config;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import org.apache.ibatis.cache.Cache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisServerCommands;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Set;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
public class MybatisRedisCache implements Cache {
    private static Logger log = LoggerFactory.getLogger(MybatisRedisCache.class);
    /**
     * 读写锁
     * Synchronized存在明显的性能问题==>读与读之间互斥
     * ReentrantReadWriteLock可以做到读和读互不影响，读和写互斥，写和写互斥，提高了读写的效率
     * reentrant : 可重入
     *  1.可重入(Reentrant)函数可以由多于一个线程并发使用，而不必担心数据错误。
     *  2.可重入函数可以在任意时刻被中断，稍后再继续运行，不会丢失数据。
      */
    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock(true);

	//这里使用了redis缓存，使用springboot自动注入
	@Autowired
    private RedisTemplate<String, Object> redisTemplate;

    private String id;

    public MybatisRedisCache(final String id) {
        if (id == null) {
            throw new IllegalArgumentException("Cache instances require an ID");
        }
        this.id = id;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public void putObject(Object key, Object value) {
        if (redisTemplate == null) {
        //运行期间注入RedisTemplate如果启动期间注入失败的话
            redisTemplate = (RedisTemplate<String, Object>) SpringContextHolder.getApplicationContext().getBean("redisJsonTemplate");
        }
        if (value != null) {
            redisTemplate.opsForValue().set(key.toString(), value);
        }
    }

    @Override
    public Object getObject(Object key) {
        try {
            if (key != null) {
                return redisTemplate.opsForValue().get(key.toString());
            }
        } catch (Exception e) {
            log.error("缓存出错 ");
        }
        return null;
    }

    @Override
    public Object removeObject(Object key) {
        if (key != null) {
            redisTemplate.delete(key.toString());
        }
        return null;
    }

    @Override
    public void clear() {
        log.debug("清空缓存");
        if (redisTemplate == null) {
            redisTemplate = (RedisTemplate<String, Object>) SpringContextHolder.getApplicationContext().getBean("redisJsonTemplate");
        }
        Set<String> keys = redisTemplate.keys("*:" + this.id + "*");
        if (!CollectionUtils.isEmpty(keys)) {
            redisTemplate.delete(keys);
        }
    }

    @Override
    public int getSize() { // 获取缓存中的缓存数量
        return  redisTemplate.execute((RedisCallback<Long>) RedisServerCommands::dbSize).intValue();
    }

    @Override
    public ReadWriteLock getReadWriteLock() {
        return this.readWriteLock;
    }
}
