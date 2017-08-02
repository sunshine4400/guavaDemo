package com.syswin.guava.cache;

import com.google.common.cache.*;
import com.syswin.guava.base.ObjectsTest.Student;
import junit.framework.TestCase;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class LoadingCacheTest extends TestCase{

	/**
	 * 缓存接口这里是LoadingCache，LoadingCache在缓存项不存在时可以自动加载缓存
	 * @throws InterruptedException 
	 * @throws ExecutionException 
	 */
	public void test1() throws InterruptedException, ExecutionException{
		//缓存接口这里是LoadingCache，LoadingCache在缓存项不存在时可以自动加载缓存
        LoadingCache<Integer,Student> studentCache
                //CacheBuilder的构造函数是私有的，只能通过其静态方法newBuilder()来获得CacheBuilder的实例
                = CacheBuilder.newBuilder()
                //设置并发级别为8，并发级别是指可以同时写缓存的线程数
                .concurrencyLevel(8)
                //设置写缓存后8秒钟过期
                .expireAfterWrite(8, TimeUnit.SECONDS)
                //设置缓存容器的初始容量为10
                .initialCapacity(10)
                //设置缓存最大容量为100，超过100之后就会按照LRU最近虽少使用算法来移除缓存项
                .maximumSize(100)
                //设置要统计缓存的命中率
                .recordStats()
                //设置缓存的移除通知
                .removalListener(new RemovalListener<Object, Object>() {
                    public void onRemoval(RemovalNotification<Object, Object> notification) {
                        System.out.println(notification.getKey() + " was removed, cause is " + notification.getCause());
                    }
                })
                //build方法中可以指定CacheLoader，在缓存不存在时通过CacheLoader的实现自动加载缓存
                .build(
                        new CacheLoader<Integer, Student>() {
                            @Override
                            public Student load(Integer key) throws Exception {
                                System.out.println("load student " + key);
                                Student student = new Student();
                                student.setId(key);
                                student.setName("name " + key);
                                return student;
                            }
                        }
                );

        for (int i=0;i<20;i++) {
            //从缓存中得到数据，由于我们没有设置过缓存，所以需要通过CacheLoader加载缓存数据
            Student student = studentCache.get(1);
            System.out.println(student);
            //休眠1秒
            TimeUnit.SECONDS.sleep(1);
        }

        System.out.println("cache stats:");
        //最后打印缓存的命中率等 情况
        /**
         * 看看到在20此循环中命中次数是17次，未命中3次，这是因为我们设定缓存的过期时间是写入后的8秒，
         * 所以20秒内会失效两次，另外第一次获取时缓存中也是没有值的，所以才会未命中3次，其他则命中。
         */
        System.out.println(studentCache.stats().toString());
	}


    public void test2(){
          Cache<Integer, String> cache = CacheBuilder.newBuilder()
                //设置cache的初始大小为10，要合理设置该值
                .initialCapacity(10)
                //设置并发数为5，即同一时间最多只能有5个线程往cache执行写入操作
                .concurrencyLevel(5)
                //设置cache中的数据在写入之后的存活时间为10秒
                .expireAfterWrite(10, TimeUnit.SECONDS)
                //构建cache实例
                .build();
    }
}
