/*
 * @author 09022211李宾
 * ATM界面类 -- 为用户提供可视化的ATM界面，方便用户操作
 */
package ch01.Homework_finalwithsql;
import java.util.Scanner;

public class ATMView
{
    private Scanner scanner = new Scanner(System.in);

    // 显示主菜单
    public int showMainMenu()
    {
        System.out.println("***  SEU ATM  ***");
        System.out.println(" 1. 创建用户      ");
        System.out.println(" 2. 用户登录      ");
        System.out.println(" 3. 退出系统      ");
        System.out.println("*****************");
        System.out.print("您好！请选择服务：");
        return scanner.nextInt();
    }

    // 显示用户菜单
    public int showUserMenu()
    {
        System.out.println("***** 用户菜单 ******");
        System.out.println(" 1. 修改密码        ");
        System.out.println(" 2. 查询余额        ");
        System.out.println(" 3. 取款           ");
        System.out.println(" 4. 存款           ");
        System.out.println(" 5. 退出登录         ");
        System.out.println("********************");
        System.out.print("您好！请选择服务：");
        return scanner.nextInt();
    }

    // 提示输入用户名
    public String promptUsername()
    {
        System.out.print("输入用户名: ");
        return scanner.next();
    }

    // 提示输入密码
    public String promptPassword()
    {
        System.out.print("输入密码: ");
        return scanner.next();
    }

    // 提示输入金额
    public double promptAmount()
    {
        System.out.print("输入金额: ");
        return scanner.nextDouble();
    }

    // 显示消息
    public void showMessage(String message)
    {
        System.out.println(message);
    }

    // 显示余额
    public void showBalance(double balance)
    {
        System.out.println(String.format("%.1f", balance));
    }
}