package ch01.MultiThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MultiThreadPool {
    public static void main(String[] args) {
        ExecutorService Threadpool=Executors.newScheduledThreadPool(5);
        System.out.println("delay for 5 seconds");
            ((ScheduledExecutorService) Threadpool).schedule(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+" is executing.");
                }
            },5, TimeUnit.SECONDS);
    }
}

