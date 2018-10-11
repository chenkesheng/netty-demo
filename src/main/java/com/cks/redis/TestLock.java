package com.cks.redis;

/**
 * @Author: cks
 * @Date: Created by 13:07 2018/10/11
 * @Package: com.cks.redis
 * @Description:
 */
public class TestLock {
    public static void main(String[] args) {
        LockRedisService lockService = new LockRedisService();
        for (int i = 0; i < 50; i++) {
            ThreadRedis threadRedis = new ThreadRedis(lockService);
            threadRedis.start();
        }
    }
}

class ThreadRedis extends Thread {

    private LockRedisService lockRedisService;

    public ThreadRedis(LockRedisService lockRedisService) {
        this.lockRedisService = lockRedisService;
    }

    @Override
    public void run() {
        lockRedisService.seckill();
    }
}
