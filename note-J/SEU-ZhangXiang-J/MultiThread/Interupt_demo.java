package ch01.MultiThread;

public class Interupt_demo extends Thread{
    public void run()
    {
        System.out.println(Thread.currentThread().getName()+" started");
        while(!interrupted())
        {
            System.out.println("Thread is running");
        }
        System.out.println("Interupted, and ended");
    }

    public static void main(String[] args) {
        System.out.println("Main started");
        try
        {
            Thread t=new Interupt_demo();
            t.start();
            Thread.sleep(2000);
            t.interrupt();
        } catch (Exception e) {
            System.out.println("Main ended.");
        }
    }
}
