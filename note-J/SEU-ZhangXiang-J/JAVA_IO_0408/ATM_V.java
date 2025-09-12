package ch01.JAVA_IO_0408;

import java.util.Scanner;

public class ATM_V {
    private Bank_C SEUbank;
    private Scanner sc;
    public ATM_V()
    {
        SEUbank=new Bank_C();
        sc=new Scanner(System.in);
        System.out.println("Welcome to SEUBank!");
    }

    public void atm()
    {
        while (true) {
            System.out.println("Please select your transaction: ");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Query Blance");
            int num = sc.nextInt();
            if (num == 1) {
                System.out.println("Please enter depositing amount");
                double amount=sc.nextDouble();
                try {
                    SEUbank.deposit(amount);
                }catch (Exception e)
                {
                    System.out.println(e.getMessage());
                }
            } else if (num == 2) {
                System.out.println("Please enter withdrawing amount");
                double amount=sc.nextDouble();
                try{
                    SEUbank.withdraw(amount);
                }catch (Exception e)
                {
                    System.out.println(e.getMessage());
                }
            } else if (num == 3) {
                SEUbank.query();
            } else {
                System.out.println("See you next time!\n");
                return;
            }
            SEUbank.clearScreen();
        }
    }

    public static void main(String[] args) {
        ATM_V atm=new ATM_V();
        atm.atm();
    }
}
