package com.xxl;

import java.util.concurrent.Semaphore;

public class SemaphoreDemo {
    //信号量 Doug Lea 大牛写的（concurrent并发包下面的东西都是他写的）  参数控制并发线程的个数
    private static Semaphore semaphore = new Semaphore(2);

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 20; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        method();
                    } catch (InterruptedException e) {
                    }
                }
            }).start();

        }
    }
        private static void method() throws InterruptedException {
            // semaphore.acquire()和semaphore.release()方法之间的代码只允许
            //private static Semaphore semaphore = new Semaphore(2) 即时2个线程同时进入
            // 首先获取一把锁
            semaphore.acquire();
            System.out.println("ThreadName" + Thread.currentThread().getName() + "进来了");
            Thread.sleep(2000);
            // 释放锁
            semaphore.release();

        }
    }
