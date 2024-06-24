package ch01.Homework_MultiThread;
/**
 * @author 09022211李宾
 * Train_sys 售票系统模型类 以互斥的方式实现 sell 函数
 * 模仿上课讲到的 ATM类  实现同步互斥函数 sell
 * **/

public class Train_sys
{
    private int ticket_id;
    public Train_sys()
    {
        ticket_id=0;
    }

    //互斥进行售卖--sell()函数
    public synchronized void sell()
    {
        while (ticket_id<=199)
        {
            //火车票首张定义为 No.1
            ticket_id++;
            System.out.println(Thread.currentThread().getName() + " 正在售出火车票 NO." + ticket_id);
            try
            {
                //若此处不添加wait()命令 则售票点 1 会把两百张票给卖完！
                wait(10);
            }
            catch(Exception e)
            {
                return;
            }
        }
        System.out.println(Thread.currentThread().getName()+" 已售罄");
        return;
    }
}
