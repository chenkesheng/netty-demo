package com.cks.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.UUID;

/**
 * @Author: cks
 * @Date: Created by 13:33 2018/10/10
 * @Package: com.cks.redis
 * @Description:基于redis代码实现思路,核心方法
 */
public class LockRedis {
    //redis线程池
    private JedisPool jedisPool;
    //在redis中创建一样的key
    private String redisLockKey = "redis_lock";

    public LockRedis(JedisPool jedisPool) {
        this.jedisPool = jedisPool;
    }

    /**
     * @param lockKey
     * @param acquireTimeout 获取锁超时时间
     * @param timeOut        获取锁成功之后超时时间
     */
    //获取锁
    public String getRedisLock(String lockKey, Long acquireTimeout, Long timeOut) {
        Jedis conn = null;
        try {
            //1.建立redis连接
            conn = jedisPool.getResource();
            //2.定义redis的key value
            String idValue = UUID.randomUUID().toString();
            //3.定义锁的名称
            String lockName = redisLockKey + lockKey;
            //4.定义上锁成功之后,锁的超时时间
            int expireLock = (int) (timeOut / 1000);//以秒为单位
            //5.定义在没有获取锁之前,锁的超时时间
            long endTime = System.currentTimeMillis() + acquireTimeout;
            //5.使用循环机制 如果没有获取到锁，要在规定的时间内 保证重复进行尝试操作获取锁 （类似乐观锁）
            while (System.currentTimeMillis() < endTime) {
                //获取锁
                //6.使用setnx命令插入对应的redisLockKey ,如果返回1成功获取锁
                if (conn.setnx(lockName, idValue) == 1) {
                    //设置key的有效期
                    conn.expire(lockName, expireLock);
                    return idValue;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
        return null;
    }

    //释放锁

    /**
     * 要保证每个线程删除自己创建的锁
     *
     * @param idValue
     * @return
     */
    public boolean unRedisLock(String lockKey,String idValue) {
        Jedis conn;
        //建立连接
        conn = jedisPool.getResource();

        String lockName = redisLockKey + lockKey;
        try {
            if (conn.get(lockName).equals(idValue)) {
                conn.del(lockName);
                System.out.println(idValue + "解锁成功......");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
        return true;
    }
}
