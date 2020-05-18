package com.rxlm.practice.redis;

import redis.clients.jedis.Jedis;

public interface CallWithJedis {
    public void call(Jedis jedis);
}
