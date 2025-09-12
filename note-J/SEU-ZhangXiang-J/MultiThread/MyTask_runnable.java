package ch01.MultiThread;

public class MyTask_runnable implements Runnable {
    public void run()
    {
        while (true)
        {
            System.out.println(Thread.currentThread().getName()+" is doing MyTask");
            try
            {
                Thread.sleep(1000);
            }catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Thread thread =new Thread (new MyTask_runnable(),"My Thread");
        thread.start();

        //主线程也while打印一下
        while (true)
        {
            System.out.println(Thread.currentThread().getName()+" is doing MyTask");
            try
            {
                Thread.sleep(1000);
            }catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}
