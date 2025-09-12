package ch01.JAVA_BASIC_b0325;

import java.util.Scanner;

/**
 * @author Robin Li
 * @serial JAVA-张祥-Week3
 * 2024年3月4日
 */

public class Student {
    private String name="";
    private String id="";
    private int gender=0;

    private static Scanner sc;
    public Student(String name,String id,int gender)
    {
        this.name=name;
        this.id=id;
        this.gender=gender;
        this.sc=new Scanner(System.in);
    }

    //为了将参数传递给JVM，写一个重载构造函数
    public Student(String arg, String arg1, String arg2) {
        this.name=arg;
        this.id=arg1;
        this.gender=Integer.parseInt(arg);
    }

    public void greet()
    {
        String gender_S;
        char class_num;
        if(gender==1)
        {
            gender_S="male";
        }
        else if (gender==0)
        {
            gender_S="female";
        }
        else {gender_S="X";}
        class_num=id.charAt(id.length()-3);
        System.out.println("Hello, I'm "+name+". I'm a "+gender_S+" student, and I'm from Class "+class_num+".");
    }

    public void setStudent(String name,String id,int gender)
    {
        this.name=name;
        this.gender=gender;
        this.id=id;
    }
    public String getStudentName() {
        return name;
    }
    public static void main(String[] args) {
        Student[] arr=new Student[3];
        for(int i=0;i<3;i++)
        {
            System.out.println("请依次输入学生的三个属性：\n");
            String str1=sc.next();
            String str2=sc.next();
            String str3=sc.next();
            int gender_t=Integer.parseInt(str3);
            arr[i]= new Student(str1,str2,gender_t);
            arr[i].greet();
        }
    }
}

//1、charAt()可以读取String对应位置的字符
//eg. class_num=id.charAt(id.length()-3);

//2、硬编码：“被写死了”
//（1）传参数到args String【】下
//（2）Scanner输入输出流作为全局变量来接收
//eg.将scanner声明为静态的，写在类的数据成员中，并且在构造函数中new出来
//  数据成员处  private static Scanner sc;
// 在构造函数中   this.sc=new Scanner(System.in);
//（3）Scanner中的更多命令
//  sc.nextInt(),取下一个键入转化为Int

//3、JAVA中的数组
//（1）静态创建
//int[] array1 = {1,2,3};
//（2）动态创建
//int[] array3 = new int[10];  []内表示数组长度

//4、判断两String是否相等
// （1）a.equals(b)  --判断字面量是否相等
// --在String内已经被重载，只比价字面量，其他类内比较hashCode
// （2）==是判断地址是否一致的
