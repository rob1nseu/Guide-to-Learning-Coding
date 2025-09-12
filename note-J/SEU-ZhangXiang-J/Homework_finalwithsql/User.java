/*
 * @author 09022211李宾
 * 用户信息类 -- 存储用户的用户名、密码、余额
 */
package ch01.Homework_finalwithsql;
public class User
{
    private String username;
    private String password;
    private double balance;

    // 获取用户名
    public String getUsername()
    {
        return username;
    }
    // 设置用户名
    public void setUsername(String username)
    {
        this.username = username;
    }
    // 获取密码
    public String getPassword()
    {
        return password;
    }
    // 设置密码
    public void setPassword(String password)
    {
        this.password = password;
    }
    // 获取余额
    public double getBalance()
    {
        return balance;
    }
    // 设置余额
    public void setBalance(double balance)
    {
        this.balance = balance;
    }
}