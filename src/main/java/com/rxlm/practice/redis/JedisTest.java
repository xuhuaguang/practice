package com.rxlm.practice.redis;

import redis.clients.jedis.Jedis;

/**
 *  Redis 提供了 HyperLogLog 数据结构就是用来解决这种统计问题的。
 *  HyperLogLog 提供不精确的去重计数方案，虽然不精确但是也不是非常不精确，
 *  标准误差是 0.81%，这样的精确度已经可以满足上面的 UV 统计需求了。
 *
 *  HyperLogLog 提供了两个指令 pfadd 和 pfcount，
 *      根据字面意义很好理解，一个是增加计数，一个是获取计数。
 */
public class JedisTest {
    public static void main(String[] args) {
        //test100000();
        Redis redis = new Redis();
        Holder<Long> countHolder = new Holder<>();
        redis.execute(jedis -> {
            Long count = jedis.zcard("codehole");
            countHolder.value(count);
        });
        System.out.println(countHolder.value());
    }

    //测试1000
    private static void test1000() {
        Jedis jedis = new Jedis();
        for (int i = 0; i < 1000; i++) {
            //增加计数
            jedis.pfadd("codehole", "user" + i);
            //获取计数
            long total = jedis.pfcount("codehole");
            if (total != i + 1) {
                System.out.printf("%d %d\n", total, i + 1);
                break;
            }
        }
        jedis.close();
    }

    //测试10万
    private static void test100000() {
        Jedis jedis = new Jedis();
        for (int i = 0; i < 100000; i++) {
            jedis.pfadd("codehole", "user" + i);
        }
        long total = jedis.pfcount("codehole");
        System.out.printf("%d %d\n", 100000, total);
        jedis.close();
    }
}
