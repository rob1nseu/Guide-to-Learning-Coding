package ch01.JAVA_BASIC_b0325;

/**
 * @author Robin Li
 * @serial JAVA-张祥-Week2
 * 2024年2月26日
 * */

//java可以实现内部类的操作，但这边不推荐
//类名前常用public
public class Person implements Cloneable{
    private String name;
    private int age;
    //数据成员可以直接赋值诶
    public Person(String name,int age)
    {
        this.name=name;
        this.age=age;
    }
    public void greet()
    {
        System.out.println("Hello ,I'm "+name+", and I'm "+age+" years old.");
    }
    public boolean equals(Person a)
    {
        return (this.age==a.getage());
    }
    public int getage()
    {
        return this.age;
    }
    public String toString()
    {
        return this.name;
    }

    //重载Object中的toString()方法
    public static void main(String[] args) throws CloneNotSupportedException {
        //地址与对象绑定
        Person r=new Person("Robin",20);
        Person t=new Person("Robin",20);
        Person r_c=null;
        try
        {
            r_c= (Person) r.clone();
        }
        catch (CloneNotSupportedException e)
        {
            System.out.println("Wrong!");
        }
        r.greet();
        System.out.println(r.equals(t));
        System.out.println(r.toString());
        System.out.println(r.hashCode());
        System.out.println(t.hashCode());
        System.out.println(r_c.hashCode());
//        String name1="Tom";
//        String name2="Tom";
//        String name3=new String("Tom");
//        System.out.println(name1.hashCode());
//        System.out.println(name2.hashCode());
//        System.out.println(name3.hashCode());
    }
}

//JAVA学习
//1、文档注释以/**开头，以*/结束，Java特有的注释，结合

//2、sout是System.out.println()的缩写
//   psvm是public static void main(String[] args)的缩写

//3、   int k;
//      System.out.println(k); // 编译报错
// Java语言中变量必须先声明，再赋值，才能使用。
// 对于局部变量来说必须手动赋值，而对于成员变量来说，如果没有手动赋值，系统会自动赋默认值

//4、高精度变为低精度
//  int t=(int)10.2
//需显式转换捏

//5、常量名命名为全大写
//在变量之前加上关键字final表示常量，在class之前加上final关键词，表示不能继承

//6、instanceof 一个变量是不是该类的对象（继承的也算

//7、运算符与C++完全一致，
//new() 表示new出对象，而没有delete，JVM帮助自动回收

//8、 native方法是非Java语言实现的代码，供Java程序调用的，因为Java程序是运行在JVM虚拟机上面的，
// 要想访问到比较底层的与操作系统相关的就没办法了，只能由靠近操作系统的语言来实现。