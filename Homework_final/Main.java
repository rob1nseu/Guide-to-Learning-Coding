/*
 * @author 09022211李宾
 * Main主程序类 -- ATM程序的入口
 */
package ch01.Homework_final;
public class Main
{
    public static void main(String[] args)
    {
        ATMView view = new ATMView();
        ATMController controller = new ATMController(view);
        controller.start();
    }
}