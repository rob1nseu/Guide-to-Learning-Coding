package ch01.MultiThread;

import java.sql.SQLOutput;

public class JoinDemo implements Runnable{
    public void run()
    {
        String name =Thread.currentThread().getName();
        System.out.println("Thread started.");
        for(int i=0;i<20;i++)
        {
            System.out.println("Thread is running.");
        }
        System.out.println("Thread ends");
    }

    public static void main(String[] args) {
        System.out.println("Main Started.");
        Thread t=new Thread(new JoinDemo());
        t.start();
        try{t.join();}
        catch(Exception e)
        {}
        System.out.println("Main ended.");
    }
}
