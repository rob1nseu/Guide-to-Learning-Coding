package ch01.JAVA_BASIC_b0325;

//存在BUG
import java.util.Scanner;

/**
 * @author Robin Li
 * @serial JAVA-张祥-Week4
 * 2024年3月11日
 */
public class StudentInfoSystem {
    class Student{
        private String id="000";
        private String name="张三";
        private boolean gender=true;
        private int javascore=0;
    }
    private Student[] student_table= new Student[5];
    private static int counter=0;
    private Scanner sc;
    public StudentInfoSystem()
    {
        sc=new Scanner(System.in);
    }
    private int getCounter()
    {
        return counter;
    }

    public void keyIn(int n)
    {
        for(int i=0;i<n;i++) {
            System.out.println("【Input id】");
            student_table[i].id = sc.next();
            System.out.println("【Input name】");
            student_table[i].name = sc.next();
            System.out.println("【Input gender, 1 -- boy, 2 -- girl 】");
            student_table[i].gender = sc.nextBoolean();
            System.out.println("【Input JavaScore】");
            student_table[i].javascore = sc.nextInt();
            counter++;
        }
    }

    public void sortJavaScore(int n)
    {
        for(int i=0;i<n-1;i++)
        {
            for(int j=0;j<n-1-i;j++)
            {
                if(student_table[j].javascore<student_table[j+1].javascore)
                {
                    Student temp;
                    temp=student_table[j];
                    student_table[j]=student_table[j+1];
                    student_table[j+1]=temp;
                }
            }
        }
        System.out.println("Java成绩排名");
        for(int k=0;k<n;k++)
        {
            System.out.println(student_table[k].id+" "+student_table[k].name+" "+student_table[k].javascore);
        }
    }

    public static void main(String[] args) {
        StudentInfoSystem s=new StudentInfoSystem();
        s.keyIn(5);
        s.sortJavaScore(5);
    }
}
