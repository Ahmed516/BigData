package com.example.ahmed.MultiThread;

import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;


/**
 * 【强制】线程资源必须通过线程池提供，不允许在应用中自行显式创建线程。 说明：线程池的好处是减少在创建和销毁线程上所消耗的时间以及系统资源的开销，解决资源不足的问题。如果不使用线程池，有可能造成系统创建大量同类线程而导致消耗完内存或者“过度切换”的问题。
 * 【强制】线程池不允许使用Executors去创建，而是通过ThreadPoolExecutor的方式，这样的处理方式让写的同学更加明确线程池的运行规则，规避资源耗尽的风险。 说明：Executors返回的线程池对象的弊端如下： 1） FixedThreadPool和SingleThreadPool： 允许的请求队列长度为Integer.MAX_VALUE，可能会堆积大量的请求，从而导致OOM。 2） CachedThreadPool： 允许的创建线程数量为Integer.MAX_VALUE，可能会创建大量的线程，从而导致OOM。
 */
public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        MyThread myThread = new MyThread();
        myThread.start();

        MyThread02 myThread02 = new MyThread02();
        System.out.println(myThread02.toString());

        MyThread03 myThread03 = new MyThread03();
        FutureTask<String> futureTask = new FutureTask<String>(new MyThread03());

        new Thread(futureTask,"my-call-thread-test").start();
        System.out.println(futureTask.get().toString()); //callable只有调用futuretask的get方法后才能打印结果
    }
}

class MyThread extends Thread{

    @Override
    public void run() {
        super.run();
        System.out.println("hello thread!");
    }
}

class MyThread02 implements Runnable{
    @Override
    public void run() {
        System.out.println("hello thread02!");
    }
}

class MyThread03 implements Callable<String>{
    @Override
    public String call() throws Exception {
        return UUID.randomUUID().toString();
    }
}