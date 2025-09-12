package ch01.JAVA_IO_0408;

import java.util.Scanner;

public class Bank_C {
    private Account_M user;
    private Scanner sc;
    public Bank_C()
    {
        sc=new Scanner(System.in);
        user=new Account_M();
    }
    protected void withdraw(double amount) throws Exception
    //取款
    {
        if(user.balance>=amount)
        {
            user.balance-=amount;
        }
        else {
            throw new Exception("YOUR WITHDRAWING AMOUNT IS HIHGER THAN YOUR BALANCE");
        }
    }
    protected void deposit(double amount) throws Exception{
        if (amount >= 0){
            user.balance+=amount;
        }
        else {
            throw new Exception("YOUR DEPISITING AMOUNT IS SMALLER THAN ZERO");
        }
    }
    protected void query()
    {
        System.out.println("Username : "+user.username);
        System.out.println("Balance : "+user.balance+" $ 】");
    }

    protected void clearScreen()
    //清屏
    {
        for (int i=0;i<3;i++)
        {
            System.out.println(" ");
        }
    }
}
