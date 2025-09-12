package ch01.Homework_MultiThread;

import java.util.ArrayList;

/**
 * @author 09022211李宾
 * SellingTask 多线程需要执行的任务类 实现 Runnable 功能
 * 模仿课上讲到的多线程ATM的 Tom_task 与 Mary_task 及其 ATM_thread
 * **/

public class SellingTask implements Runnable {
    Train_sys system;  //实例化一个Train_sys对象

    public SellingTask()
    {
        system = new Train_sys();
    }

    public void run()
    {
        /*每个线程需要执行的任务即为互斥的sell()函数*/
        system.sell();
    }

    /*在main函数中创建10个线程 并分配同一个Runnable任务--task*/
    public static void main(String[] args)
    {
        Runnable task = new SellingTask();
        ArrayList<Thread> selling_threads = new ArrayList<Thread>();
        for (int i = 1; i <= 10; i++)
        {
            //线程的名字设置为 “ "售票点 " + i ”
            Thread temp = new Thread(task, "售票点 " + i);
            selling_threads.add(temp);
            temp.start();
        }
    }
}