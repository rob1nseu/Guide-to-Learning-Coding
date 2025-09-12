/*
 * @author 09022211李宾
 * 用户信息类 -- 存储用户的用户名、密码、余额
 */
package ch01.Homework_final;
import java.io.Serializable;
public class User implements Serializable
{
    private static final long serialVersionUID = 1L;    //序列化编号
    private String username;
    private String password;
    private double balance;

    //用户构造方法
    public User(String username, String password, double balance)
    {
        this.username = username;
        this.password = password;
        this.balance = balance;
    }

    //getUsername--用户名称的get方法
    public String getUsername()
    {
        return username;
    }

    //setPassword--用户密码的set方法
    public void setPassword(String password)
    {
        this.password = password;
    }

    //checkPassword--检查用户密码正误方法
    public boolean checkPassword(String password)
    {
        return this.password.equals(password);
    }

    //getBalance--用户余额的set方法
    public double getBalance()
    {
        return balance;
    }

    //deposit--存钱方法
    public void deposit(double amount)
    {
        if (amount > 0)
        {
            this.balance += amount;
        }
    }

    //withdraw--取钱方法
    public boolean withdraw(double amount)
    {
        if (amount > 0 && this.balance >= amount) {
            this.balance -= amount;
            return true;
        }
        return false;
    }

    //addInterest--利息计算方法，余额*=5%
    public void addInterest()
    {
        this.balance *= 1.05;
    }
}