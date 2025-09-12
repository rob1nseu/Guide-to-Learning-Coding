/*
 * @author 09022211李宾
 * ATM界面类 -- 为用户提供可视化的ATM界面，方便用户操作
 */
package ch01.Homework_final;
import java.util.Scanner;
public class ATMView
{
    private Scanner scanner = new Scanner(System.in);

    //ATM主页界面
    public int showMainMenu()
    {
        System.out.println("*****ATM Main Menu*****");
        System.out.println("*1. Create New User   *");
        System.out.println("*2. Login             *");
        System.out.println("*3. Exit              *");
        System.out.println("***********************");
        System.out.print("Choose an option: ");
        return scanner.nextInt();
    }

    //获取键入用户名
    public String getUsername()
    {
        System.out.print("Enter username: ");
        return scanner.next();
    }

    //获取键入用户密码
    public String getPassword()
    {
        System.out.print("Enter password: ");
        return scanner.next();
    }

    //二级界面 -- 用户界面
    public int showUserMenu()
    {
        System.out.println("*****User Menu******");
        System.out.println("*1. Change Password*");
        System.out.println("*2. Query Balance  *");
        System.out.println("*3. Withdraw       *");
        System.out.println("*4. Deposit        *");
        System.out.println("*5. Logout         *");
        System.out.println("********************");
        System.out.print("Choose an option: ");
        return scanner.nextInt();
    }

    //向控制台输出Message
    public void showMessage(String message)
    {
        System.out.println(message);
    }

    //获取键入金额
    public double getAmount()
    {
        System.out.print("Enter amount: ");
        return scanner.nextDouble();
    }
}