package ch01.MultiThread_ATM;

public class TomTask implements Runnable{
    ATM O;
    public TomTask(ATM account)
    {
        O=account;
    }

    public void run()
    {
        O.withdraw(100);
    }

}
