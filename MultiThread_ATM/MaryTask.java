package ch01.MultiThread_ATM;

public class MaryTask implements Runnable{
    ATM O;
    public MaryTask(ATM account)
    {
        O=account;
    }

    public void run()
    {
        O.deposit(1500);
        O.withdraw(100);
    }
}
