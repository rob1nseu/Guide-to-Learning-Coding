package ch01.MultiThread;

public class threeThread implements Runnable {
    public void run()
    {
        for(int i=0;i<30;i++)
        {
            String threadName=Thread.currentThread().getName();
            System.out.println(threadName+" is running");
        }
    }

    public static void main(String[] args) {
        Runnable myTask=new threeThread();
        Thread thread_1=new Thread(myTask,"Thread_1");
        thread_1.setPriority(10);
        Thread thread_2=new Thread(myTask,"Thread_2");
        thread_2.setPriority(1);
        thread_1.start();
        thread_2.start();
    }
}
