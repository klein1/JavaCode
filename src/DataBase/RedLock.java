package DataBase;

import org.redisson.Redisson;
import org.redisson.RedissonRedLock;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.config.SingleServerConfig;

import java.util.concurrent.TimeUnit;

public class RedLock {

    public static void main(String[] args) {
        Config config1 = new Config();
        config1.useSingleServer().setAddress("127.0.0.1:6379").setDatabase(0);
        RedissonClient redissonClient1 = Redisson.create(config1);

//        Config config2 = new Config();
//        config1.useSingleServer().setAddress("127.0.0.1:6380").setDatabase(0);
//        RedissonClient redissonClient2 = Redisson.create(config2);
//
//        Config config3 = new Config();
//        config1.useSingleServer().setAddress("127.0.0.1:6381").setDatabase(0);
//        RedissonClient redissonClient3 = Redisson.create(config3);

        String resourceName = "REDLOCK_KEY";

        RLock lock1 = redissonClient1.getLock(resourceName);
//        RLock lock2 = redissonClient2.getLock(resourceName);
//        RLock lock3 = redissonClient3.getLock(resourceName);
        // 向3个redis实例尝试加锁
        RedissonRedLock redLock = new RedissonRedLock(lock1);
//        RedissonRedLock redLock = new RedissonRedLock(lock1, lock2, lock3);
        boolean isLock;
        try {
            // isLock = redLock.tryLock();
            // 500ms拿不到锁, 就认为获取锁失败。10000ms即10s是锁失效时间。
            isLock = redLock.tryLock(500, 10000, TimeUnit.MILLISECONDS);
            System.out.println("isLock = "+isLock);
            if (isLock) {
                //TODO if get lock success, do something;
            }
        } catch (Exception e) {
        } finally {
            // 无论如何, 最后都要解锁
            redLock.unlock();
        }

    }
}
