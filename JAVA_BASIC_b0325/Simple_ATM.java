package ch01.JAVA_BASIC_b0325;

/**
 * @author Robin Li
 * @serial JAVA-张祥-Week3
 * 2024年3月4日
 */

import java.util.Scanner;

public class Simple_ATM {
    private int balance=0;//余额 JAVA的数据成员可以直接赋值
    private Scanner sc;
    public Simple_ATM()
    {
        //将Scanner在类中实例化，传入参数为System.in
        sc=new Scanner(System.in);
    }
    public void query()
    {
        System.out.println("【 Your credit: "+balance+" $ 】\n");
    }
    public void askingTable()
    //菜单界面
    {
        while (true) {
            System.out.println("Please select your transaction: ");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Query Blance");
            int num=sc.nextInt();
            if(num==1)
            {
                deposit();
            }
            else if (num==2)
            {
                withdraw();
            }
            else if(num==3)
            {
                query();
            }
            else
            {
                System.out.println("See you next time!\n");
                return;
            }
            clearScreen();
        }
    }
    public void withdraw()
    //取款
    {
        System.out.println("Please enter depositing amount\n");
        int num=sc.nextInt();
        if(num>0) {
            balance-=num;
        }
        else {
            System.out.println("\n【 invalid operation! 】");
        }
    }
    public void deposit()
    //存款
    {
        System.out.println("Please enter depositing amount:\n");
        int num=sc.nextInt();
        if(num>0) {
            balance+=num;
        }
        else {
            System.out.println("\n【 invalid operation! 】");
        }
    }

    public void clearScreen()
    //清屏
    {
        for (int i=0;i<30;i++)
        {
            System.out.println(" ");
        }
    }

    public static void main(String[] args) {
        Simple_ATM atm=new Simple_ATM();
        atm.askingTable();
    }
}

//1、前后端及MVC的三层架构
// Menu--展示界面--前端--VIEW
// 数据的存放--后端--MODE
// 处理数据--中间端--CONTROLLER

//2、ATM的加入利息功能--多线程或单线程（用户观察时再计算）

//3、重构Refactor，IntelliJ中存在这样的功能

// 4、Java OOP 杂乱的知识
//（1）super a= new sub()
// super为父类，sub为其子类；super为声明期类型，sub为运行期类型
// 其中a为内存中对象的引用，指向内存中一个sub()类型的对象;

//（2）抽象设计类
// public abstract class AbstractPerson{
// pubilc void greet(){}         //这里只是设计，但不包含实现
// }

//（3）多态
// super a= new sub()
// 一个对象（引用）能够调用的方法取决于声明期类型--super
// 如何强行调用呢？  --   (sub)a.subEat()  --在这一句进行强制类型转化

//（4）静态成员变量  --类变量
//public static int counter=0
//存在的对象会被垃圾回收了？   --finalize   --与JVM GC（Garbage Collection）通信的手段   --不建议使用（垃圾容易死而复生
//protected void finalize(){counter--;}
//建议多使用static的方法与变量

//（5）重载函数
//函数签名不得相同：函数名与形参列表

//（6）引用与指针  --引用是指针的优化版，只能引用对象而不能是地址
//（7）可变长度参数的形参列表
// public void add(int.. numbers){}
// --将numbers默认转化为一个数组

//（8）
//1...String s="Oi"
//2...String s= new String("Oi")
//区别:1--先搜索再绑定，若已经有变量赋值为“Oi”就重用;(String为一个特殊类  2--新建