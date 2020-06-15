package com.xxl;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ThreadPoolDemo {
    /**
     * java 提供了线程池的创建工具类（ Executors），
     * 我们可以通过工具类创建不同的线程池
     */
    //初始核心线程数0，阻塞队列是只能存一个的SynchronousQueue，无限最大线程数，缓存60秒，瞬间执行完成
    private static Executor executor = Executors.newCachedThreadPool();//缓冲线程池
    //固定线程池的核心线程数和最大线程数是一样的，所以是每次只会同时有2个线程执行，虽然阻塞队列无限大
    private static Executor executor2 = Executors.newFixedThreadPool(2);//固定线程池
    //指定2个核心线程数，无最大线程数限制，阻塞队列是无限扩容的DelayedWorkQueue，所以每次也是2个同时执行
    private static Executor executor3 = Executors.newScheduledThreadPool(2);//计划任务线程池
    //不管怎么样都是只有一个线程同时执行
    private static Executor executor4 = Executors.newSingleThreadExecutor();//单个线程池（池中只有一个线程）

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            // 线程池的简单使用（十分简单） 调用execute方法传递参数类型为runnable类型即可
            executor2.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        method();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    private static void method() throws InterruptedException {
        System.out.println("ThreadName" + Thread.currentThread().getName() + "进来了");
        Thread.sleep(2000);

    }
}
