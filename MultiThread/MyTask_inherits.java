package ch01.MultiThread;

public class MyTask_inherits extends Thread {
    public void run()
    {
        while(true)
        {
            System.out.println(this.getName()+" is doing its own task");
            try
            {
                Thread.sleep(1000);
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        MyTask_inherits myThread=new MyTask_inherits();
        myThread.setName("Thread 1");
        myThread.start();
    }
}
