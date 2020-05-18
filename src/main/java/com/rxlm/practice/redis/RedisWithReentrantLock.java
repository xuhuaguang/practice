package com.rxlm.practice.redis;


import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;

/**
 * 分布式锁
 */
public class RedisWithReentrantLock {
    private ThreadLocal<Map<String,Integer>> lockers = new ThreadLocal<>();
    private Jedis jedis;

    public RedisWithReentrantLock(Jedis jedis) {
        this.jedis = jedis;
    }

    /**
     * 设置锁以及失效时间
     * @param key
     * @return
     */
    private boolean _lock(String key) {
        return jedis.set(key,"","nx","ex",5L) != null;
    }

    /**
     * 删除锁
     * @param key
     */
    private void _unlock(String key) {
        jedis.del(key);
    }

    /**
     * 获取当前锁
     * @return
     */
    private Map<String,Integer> currentLockers() {
        Map<String, Integer> refs = lockers.get();
        if (null != refs) {
            return refs;
        }
        lockers.set(new HashMap<>());
        return lockers.get();
    }

    /**
     * 加锁
     * @param key
     * @return
     */
    private boolean lock(String key) {
        Map<String, Integer> refs = currentLockers();
        Integer refCnt = refs.get(key);
        if (null != refCnt) {
            refs.put(key,refCnt+1);
            return true;
        }
        boolean ok = this._lock(key);
        if (!ok) {
            return false;
        }
        refs.put(key,1);
        return true;
    }

    /**
     * 释放锁
     * @param key
     * @return
     */
    public boolean unlock(String key) {
        Map<String, Integer> refs = currentLockers();
        Integer refCnt = refs.get(key);
        if (refCnt == null) {
            return false;
        }
        refCnt -= 1;
        if (refCnt > 0) {
            refs.put(key, refCnt);
        } else {
            refs.remove(key);
            this._unlock(key);
        }
        return true;
    }

    public static void main(String[] args) {
        Jedis jedis = new Jedis();
        RedisWithReentrantLock redis = new RedisWithReentrantLock(jedis);
        System.out.println(redis.lock("codehole"));
        System.out.println(redis.lock("codehole"));
        System.out.println(redis.unlock("codehole"));
        System.out.println(redis.unlock("codehole"));
    }
}
