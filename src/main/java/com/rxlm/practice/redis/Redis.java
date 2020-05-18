package com.rxlm.practice.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.exceptions.JedisConnectionException;

public class Redis {
    private JedisPool pool;
    public Redis() {
        this.pool = new JedisPool();
    }
    public void execute(CallWithJedis caller) {
        Jedis jedis = pool.getResource();
        try {
            caller.call(jedis);
        } catch (JedisConnectionException e) {
            caller.call(jedis);
        } finally {
            jedis.close();
        }

    }
}
